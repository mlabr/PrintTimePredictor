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

package printTimePredictor.params;

/**
 *
 * @author Miroslav Labr
 */
public class BaseScheme
{
    private String key = "";
    private int rule = 0;
    private String description = "";
    
    /**
     * Something something
     * 
     * @param key dsafdf
     * @param rule ad fad
     * @param description  adfadfa 
     * 
     * 0 - equal
     * 1 - start with
     * 2 - end with
     * 
     * Description is for help usage.
     * 
     * somethig to <b>Say</b> 
     */
    public BaseScheme(String key, String description, int rule)
    {
        this.key = key;
        this.rule = rule;
        this.description = description;
    }
    /**
     * 
     * 
     * @param key
     * @param description 
     */
    public BaseScheme(String key, String description)
    {
        this(key, description, 0);
    }
    
    public String GetKey()
    {
        return key;
    }
    
    public boolean IsEqualToRule(String param)
    {
        switch (rule)
        {
            case 0:
            {
                return param.equalsIgnoreCase(key);
            }
            case 1:
            {
                return param.startsWith(key);
            }
            case 2:
            {
                return param.endsWith(key);
            }
            default: return false;
        }

    }
        
    public String GetDescription()
    {
        return description;
    }
    
    
}
