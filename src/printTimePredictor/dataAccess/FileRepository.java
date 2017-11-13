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

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author Miroslav Labr
 */
public class FileRepository
{

    
    public FileRepository()
    {
    }
      
    public ArrayList<String> GetLinesFromFile(String filename) throws IOException
    {
        ArrayList<String> lines = new ArrayList<String>();
        
        try
        {
            // Open the file that is the first 
            // command line parameter
            FileInputStream fstream = new FileInputStream(filename);
            // Get the object of DataInputStream
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String line;

            //Read File Line By Line
            while ((line = br.readLine()) != null)
            {
                lines.add(line);
                //System.out.println (line);
            }
            in.close();
        }
        catch (Exception e)
        {
            throw e;
            //System.err.println("Error: " + e.getMessage());
        }
        
        return lines;
    }
    
    
 


}
