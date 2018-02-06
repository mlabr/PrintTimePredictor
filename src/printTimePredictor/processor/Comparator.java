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
package printTimePredictor.processor;

import printTimePredictor.gcode.Vector;

/**
 *
 * @author mlabr
 */
public class Comparator
{
    /**
     * 
     * @param angleA
     * @param angleB
     * @return 
     */
    public float GetAngleXyDifference(double angleA, double angleB)
    {
        double difference = Math.abs(angleA - angleB);
        if(difference > 180)
        {
            difference = 360.0 - difference;
        }

        return (float)difference;
    }
    
    /**
     * 
     * @param speedA
     * @param speedB
     * @param angle
     * @return 
     */
    public float GetSpeedDifferenceByAngleXY(float speedA, float speedB, float angle)
    {
        double difference = speedB - (Math.cos(Math.toRadians(angle)) * speedA);
        
        return (float)difference;
    }
}
