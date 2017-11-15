/*
* This file is part of PrintTimePredictor.
*
* PrintTimePredictor is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* PrintTimePredictor is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with PrintTimePredictor.  If not, see <http://www.gnu.org/licenses/>.
*/

package printTimePredictor;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import java.util.ArrayList;
import printTimePredictor.parser.Vector;

/**
 *
 * @author Miroslav Labr
 */
public class Calculator
{
    //TODO rafactore this:
    public Acceleration accelerationXY = new Acceleration(3000,3000);
    public Acceleration accelerationXYprinting = new Acceleration(4000,4000);
    public Acceleration accelerationZ = new Acceleration(4000,4000);
    public Acceleration accelerationRetraction = new Acceleration(3500,3500);
    public Acceleration accelerationDefault = new Acceleration(3500,3500);

    
    public Acceleration acceleration;
    private double travelSpeed = 0; // mm/s
    private double pathTotal = 0; // mm
    private double pathStart = 0; // mm
    private double pathStop = 0; // mm
    private double pathLinear = 0; // mm
    
    private double timeTotal = 0; // s
    private double timeStart = 0; // s
    private double timeStop = 0; // s
    private double timeLinear = 0; // s
    
    
    public double calculateTraveTime(double path, double speed, Acceleration acceleration)
    {   
        double accelerationStart = acceleration.GetStartValue(); // mm/s^2
        double accelerationStop = acceleration.GetStopValue();
        
        pathTotal = path;
        travelSpeed = speed;
        timeStart = travelSpeed / accelerationStart;
        timeStop = travelSpeed / accelerationStop;

        pathStart = 0.5 * accelerationStart * (pow(timeStart,2));
        pathStop =  0.5 * accelerationStop * (pow(timeStop,2));

        if((pathStart + pathStop) < pathTotal) 
        {
            pathLinear = pathTotal - (pathStart + pathStop);
            
            timeLinear = pathLinear / travelSpeed;
            timeTotal = timeLinear + timeStart + timeStop;

            return timeTotal;
        }
        else 
        {
            //acceleration is not enought to accelerate to full speed
            double ratio = accelerationStart /  accelerationStop;
            pathStart = pathTotal / (1 + ratio);
            pathStop = ratio * pathStart;
            
            timeStart = sqrt(((2 * pathStart) / accelerationStart));
            timeStop = sqrt(((2 * pathStop) / accelerationStop));
            timeTotal = timeStart + timeStop;

            return timeTotal;
        }
        
    }
            
    public float ProcessVectorList(ArrayList<Vector> vectorList)
    {
        double timeSum = 0;
        double time = 0;
        double path;
        double speed;
        for (Vector vector : vectorList)
        {
            
            if (vector.TravelSpeed != 0)
            { 
                path = vector.GetSize();
                speed = vector.GetSpeed();
                switch(vector.GetType())
                {
                    case 1: 
                        acceleration = accelerationXY;
                        break;
                    case 2:
                        acceleration = accelerationRetraction;
                        break;
                    case 3:
                        acceleration = accelerationXYprinting;
                        break;
                    case 4:
                        acceleration = accelerationZ;
                        break;
                    default : //Todo warning to log this.
                        acceleration = accelerationDefault;
   
                }
                time = calculateTraveTime(path, speed, acceleration);   
            } else
            {
                time = 0;
            }
            timeSum += time;

        }

        return (float)timeSum;
    }

}
