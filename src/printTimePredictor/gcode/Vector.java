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

package printTimePredictor.gcode;

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
    private int type = 0;
    public float TravelSpeed; //mm per seconds
    //public String Type;
    
    public Vector(float dx, float dy, float dz, float extrude)
    {
        deltaX = dx;
        deltaY = dy;
        deltaZ = dz;
        this.extrude = extrude;
        
        boolean isHorizontal = (dx != 0) || (dy!= 0);
        boolean isExtrude = (extrude != 0);
        boolean isVertical = (dz != 0);
        
        if(isHorizontal)
        {
            type += 1;
        }
        if(isExtrude)
        {
            type +=2;
        }
        if(isVertical)
        {
            type +=4;
        }
        //1 - moving
        //2 - retraction
        //3 - printing
        //4 - vertical
        //any other result cause that vector is unknown type.
        
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
    
    //TODO
    public double GetAngleXY()
    {
        double degrees = 0;
        double yxRatio = 0;
        if(deltaX != 0)
        {
            yxRatio = abs(deltaY / deltaX);
            degrees = Math.toDegrees(Math.atan(yxRatio));
            if(deltaX < 0)
            {
                degrees = 180.0 - degrees;
            }
            
            if(deltaY < 0)
            {
                degrees *=-1;
            }
            
        }
        else
        {
            if(deltaY > 0)
            {
                degrees = 90;
            }
            else
            {
                degrees = -90;
            }
            
        }

        

        
        //degrees = Math.toDegrees(Math.atan(yxRatio));
        
        
        return degrees;
    }
    
    public double GetSpeed()
    {
        return TravelSpeed;
    }
    
    public int GetType()
    {
        return type;
    }
    
    
    public String ToString()
    {
        
        return "X: " + deltaX
               +" Y: " +deltaY
                +" Z: " +deltaZ
                +" E: " +extrude
                +" Type: " +type;
    }
    
    
    
}
