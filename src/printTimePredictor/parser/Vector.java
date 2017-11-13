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

package printTimePredictor.parser;

import static java.lang.Math.abs;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

/**
 *
 * @author Miroslav Labr
 */
public class Vector
{
    private float deltaX;
    private float deltaY;
    private float deltaZ;
    private float extrude;
    public float TravelSpeed; //mm per seconds
    public String Type;
    
    public Vector(float dx, float dy, float dz, float extrude)
    {
        deltaX = dx;
        deltaY = dy;
        deltaZ = dz;
        this.extrude = extrude; 
    }
    
    public double GetSize()
    {
        double size = sqrt(pow(deltaX, 2) + pow(deltaY, 2)+ pow(deltaZ, 2));
        
        if (size == 0)
        {
            size = abs(extrude);
        }
        
        return size;
    }
    
    public double GetSpeed()
    {
        return TravelSpeed;
    }
    
    
    public String ToString()
    {
        
        return "X: " + deltaX
               +" Y: " +deltaY
                +" Z: " +deltaZ
                +" E: " +extrude;
    }
    
    
    
}
