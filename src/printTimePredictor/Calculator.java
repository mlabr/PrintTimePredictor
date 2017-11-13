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
    public double AccelerationStart = 3500; // mm/s^2
    public double AccelerationStop = 3500; // mm/s^2
    private double travelSpeed = 0; // mm/s
    
    
    
    private double pathTotal = 0; // mm
    private double pathStart = 0; // mm
    private double pathStop = 0; // mm
    private double pathLinear = 0; // mm
    
    private double timeTotal = 0; // s
    private double timeStart = 0; // s
    private double timeStop = 0; // s
    private double timeLinear = 0; // s
    
    
    
    
    public double calculateTraveTime(double path, double speed)
    {   
        pathTotal = path;
        travelSpeed = speed;
        timeStart = travelSpeed / AccelerationStart;
        timeStop = travelSpeed / AccelerationStop;

        pathStart = 0.5 * AccelerationStart * (pow(timeStart,2));
        pathStop =  0.5 * AccelerationStop * (pow(timeStop,2));

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
            double ratio = AccelerationStart /  AccelerationStop;
            pathStart = pathTotal / (1 + ratio);
            pathStop = ratio * pathStart;
            
            timeStart = sqrt(((2 * pathStart) / AccelerationStart));
            timeStop = sqrt(((2 * pathStop) / AccelerationStop));
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
                time = calculateTraveTime(path, speed);   
            } else
            {
                time = 0;
            }
            timeSum += time;

        }

        return (float)timeSum;
    }

}
