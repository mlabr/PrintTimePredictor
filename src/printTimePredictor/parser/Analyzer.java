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

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 *
 * @author Miroslav Labr
 */
public class Analyzer
{
    private final String[] paramPrefix = {"X", "Y", "Z", "E", "F"};
    private GCodeData currentGCodeData = new GCodeData();
    private GCodeData newGCodeData = new GCodeData();
    private float currentTravelSpeed = 0;
    private ArrayList vectorList = new ArrayList();
    private float printTime = 0;
    
    public Analyzer()
    {
 
    }
    
    
    //current position
    //next position
    public Analyzer(String line)
    {
        currentGCodeData = getDataFromLine(line);

        if(currentGCodeData.isF)
        {
            currentTravelSpeed = currentGCodeData.F;
        }
        
    }
    
    
    public void AddLine(String line)
    {
        newGCodeData = getDataFromLine(line);
        float dx = 0,dy = 0,dz = 0, de = 0;
        

        if(newGCodeData.isX)
        {
            dx = newGCodeData.X - currentGCodeData.X;
        }

        
        if(newGCodeData.isY)
        {
            dy = newGCodeData.Y - currentGCodeData.Y;
        }

        
        if(newGCodeData.isZ)
        {
            dz = newGCodeData.Z - currentGCodeData.Z;
        }
        
        if(newGCodeData.isE)
        {
            de = newGCodeData.E;
        }

        Vector vector = new Vector(dx,dy,dz, de);
        
        if(newGCodeData.isF)
        {
            currentTravelSpeed = newGCodeData.F;
            vector.TravelSpeed = currentTravelSpeed / 60f;//velocity per second
        }
        else
        {
            vector.TravelSpeed = currentTravelSpeed / 60f;
        }
        
        currentGCodeData = newGCodeData;
              

        //System.out.println(vector.ToString());
        vectorList.add(vector);
        
    }
    
    public ArrayList<Vector> GetVectorList()
    {
        return vectorList;
    }
    
    private GCodeData getDataFromLine(String line)
    {
        GCodeData gcodeData = new GCodeData(currentGCodeData.X, currentGCodeData.Y, currentGCodeData.Z, currentGCodeData.E, currentGCodeData.F);
        //Init default values;
        float fl = 0;
        if(line.startsWith("G"))
        {
            String[] gcodeLine = line.split(";");
            String[] gcodeParts = gcodeLine[0].split(" ");
            String[] sp = gcodeParts;
            //String[] sp = line.split(" ");
            for(String s : sp)
            {
                //type
                if(s.equalsIgnoreCase("G0"))
                {
                    gcodeData.functionName = "G0";
                }
                if(s.equalsIgnoreCase("G1"))
                {
                    gcodeData.functionName = "G1";
                }


                //Position, feed rate(velocity)
                for(String prefix : paramPrefix)
                {
                    String ch = prefix;
                    if(s.startsWith(ch.toUpperCase()) || s.startsWith(ch.toLowerCase()))
                    {
                        //System.out.println("prefix: " + ch);
                        fl = Float.parseFloat(s.substring(1));
                        gcodeData.AddNewValue(ch, fl);

                    }
                }
            }
        }
        
        return gcodeData;
    }
    
    private void getPosition()
    {
        
    }
    
}
