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

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import printTimePredictor.gcode.Vector;

/**
 *
 * @author mlabr
 */
public class ComparatorTest
{
    public ComparatorTest()
    {
    }
    
    
    @Test
    public void testGetAngleXyDifference()
    {
        System.out.println("GetAngleXyDifference");
        Comparator instance = new Comparator();
        
        double angleA = 0;
        double angleB = 45;
        double expResult = 45.0;
        double result = instance.GetAngleXyDifference(angleA, angleB); 
        assertEquals(expResult, result, 0.0);
        
        angleA = 0;
        angleB = 90;
        expResult = 90.0;
        result = instance.GetAngleXyDifference(angleA, angleB); 
        assertEquals(expResult, result, 0.0);
        
        angleA = 0;
        angleB = 135;
        expResult = 135.0;
        result = instance.GetAngleXyDifference(angleA, angleB); 
        assertEquals(expResult, result, 0.0);
        
        angleA = 0;
        angleB = 180;
        expResult = 180.0;
        result = instance.GetAngleXyDifference(angleA, angleB); 
        assertEquals(expResult, result, 0.0);
        
        angleA = 0;
        angleB = -45;
        expResult = 45.0;
        result = instance.GetAngleXyDifference(angleA, angleB); 
        assertEquals(expResult, result, 0.0);
        
        angleA = 0;
        angleB = -90;
        expResult = 90.0;
        result = instance.GetAngleXyDifference(angleA, angleB); 
        assertEquals(expResult, result, 0.0);
        
        angleA = 0;
        angleB = -135;
        expResult = 135.0;
        result = instance.GetAngleXyDifference(angleA, angleB); 
        assertEquals(expResult, result, 0.0);
        
        angleA = 135;
        angleB = -135;
        expResult = 90.0;
        result = instance.GetAngleXyDifference(angleA, angleB); 
        assertEquals(expResult, result, 0.0);
    }
}
