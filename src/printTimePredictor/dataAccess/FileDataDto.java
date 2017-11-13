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
package printTimePredictor.dataAccess;

import java.util.ArrayList;

/**
 *
 * @author Miroslav Labr
 */
public class FileDataDto
{
    private String name = "";
    private ArrayList<String> dataLines = new ArrayList<>();
    
    public FileDataDto(String name, ArrayList<String> dataLines)
    {
        this.name = name;
        this.dataLines = dataLines;
    }
    
    public String GetName()
    {
        return name;
    }
    
    public ArrayList<String> GetData()
    {
        return dataLines;
    }
    
}
