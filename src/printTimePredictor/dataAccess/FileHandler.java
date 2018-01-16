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

import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author Miroslav Labr
 */
public class FileHandler
{
    private final FileRepository fileRepo;
    private ArrayList<String> errors = new ArrayList<String>();
    private ArrayList<String> gcodeDataList = new ArrayList<String>();
    private ArrayList<FileDataDto> gcodeDataDtoList = new ArrayList<FileDataDto>();
    
    public FileHandler()
    {
        fileRepo = new FileRepository();
    };
    
    public ArrayList<FileDataDto> GetGCodeDataListByNameList(ArrayList<String> filenameList)
    {
        String fileContain = "";
        ArrayList<String> lines = new ArrayList<String>();
        
        for(String filename : filenameList)
        {
            try
            {               
                lines = fileRepo.GetLinesFromFile(filename);
                FileDataDto dto = new FileDataDto(filename, lines);
                gcodeDataDtoList.add(dto);
            }
            catch (Exception e)
            {
                errors.add(filename + " " + e.toString());
            }  
        }

        return gcodeDataDtoList;
    }
    
    
    
    public ArrayList<String> GetErrorsList()
    {
        return errors;
    }
    
    public String GetCurrentDirecory()
    {
        return System.getProperty("user.dir");
    }
    
    public ArrayList<String> GetFilenameListByDirectory(String directory)
    {
        final File folder = new File(directory);
        ArrayList<String> gcodeFileList = new ArrayList<>();
        
        for (final File fileEntry : folder.listFiles())
        {
            if (fileEntry.isDirectory())
            {
                //NOP
            }
            else
            {
                String gcodeFilename = fileEntry.getName().toLowerCase();
                if(gcodeFilename.endsWith(".gcode"))
                {
                    gcodeFileList.add(fileEntry.getName());
                }
            }
        }
        
        return gcodeFileList;
     

    }
}
