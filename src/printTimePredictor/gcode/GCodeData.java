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

/**
 *
 * @author Miroslav Labr
 */
public class GCodeData
{
    /*
    G0 Xnnn Ynnn Znnn Ennn Fnnn Snnn 
    G1 Xnnn Ynnn Znnn Ennn Fnnn Snnn 
    
    Xnnn The position to move to on the X axis 
    Ynnn The position to move to on the Y axis 
    Znnn The position to move to on the Z axis 
    Ennn The amount to extrude between the starting point and ending point 
    Fnnn The feedrate per minute of the move between the starting point and ending point (if supplied) 
    Snnn Flag to check if an endstop was hit (S1 to check, S0 to ignore, S2 see note, default is S0)
    */
    
    public float X = 0;
    public float Y = 0;
    public float Z = 0;
    public float E = 0;
    public float F = 0;
    
    public String functionName= "G1";
    
    public boolean isX = false;
    public boolean isY = false;
    public boolean isZ = false;
    public boolean isE = false;
    public boolean isF = false;
    
    public GCodeData()
    {
        this(0,0,0,0,0);
    }
    
    public GCodeData(float x, float y, float z,float e, float f)
    {
        X = x;
        Y = y;
        Z = z;
        E = e;
        F = f;
        
        isX = false;
        isY = false;
        isZ = false;
        isE = false;
        isF = false;
    }
    
    public void AddNewValue(String key, float value)
    {
        if(key.equalsIgnoreCase("X"))
        {
            X = value;
            isX = true;
        }
        
        if(key.equalsIgnoreCase("Y"))
        {
            Y = value;
            isY = true;
        }
        
        if(key.equalsIgnoreCase("Z"))
        {
            Z = value;
            isZ = true;
        }
        
        if(key.equalsIgnoreCase("E"))
        {
            E = value;
            isE = true;
        }
        
        if(key.equalsIgnoreCase("F"))
        {
            F = value;
            isF = true;
        }

    }
    
    public String ToString()
    {
        String str = functionName  
                +" X: " + X
                +" Y: " + Y
                +" Z: " + Z
                +" F: " + F;
        
        return str;
    }
}
