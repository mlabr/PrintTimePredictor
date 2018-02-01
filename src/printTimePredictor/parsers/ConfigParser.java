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
package printTimePredictor.parsers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author mlabr
 */
public class ConfigParser
{
    
    
    
    public static Map<String, Float> GetConfigMap(ArrayList<String> containList)
    {
        if(containList == null || containList.isEmpty())
        {
            return null;
        }
        
        
        Map<String, Float> configMap = new HashMap<>();
        for(String str : containList)
        {
            
            if(str.startsWith("#") || str.trim().isEmpty())
            {
                //System.out.println("Skipping comment or empty space");
            }
            else
            {

                //System.out.println(str);
                float value = 0;
                String val = "0";
                String key = "Undefined";
                try
                {
                    String[] prop = str.split("=");
                    key = prop[0].trim();
                    val = prop[1].trim();
                }
                catch (Exception e)
                {
                    //System.out.println("Error during parsing config file: " + e);
                    //System.out.println("Bad string: " + str);  
                }

                try
                {
                    value = Float.valueOf(val).floatValue();  
                }
                catch (NumberFormatException nfe)
                {
                    //System.out.println("NumberFormatException: " + nfe.getMessage());
                }
                configMap.put(key,value);
            }
        
        }
        return configMap;
    }
            
}
