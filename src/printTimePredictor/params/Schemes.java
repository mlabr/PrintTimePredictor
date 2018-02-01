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
public class Schemes
{
    private final int startWithKey = 1;
    private final int endWithKey = 2;
            
    
    BaseScheme Parameter = new BaseScheme("-", "", startWithKey);

    /*
    version number MAJOR.MINOR.PATCH, 
    MAJOR version when you make incompatible API changes,
    MINOR version when you add functionality in a backwards-compatible manner, and
    PATCH version when you make backwards-compatible bug fixes.
    */
    BaseScheme Version = new BaseScheme("--version", "\nPrint Time Predictor v0.3.0\n");
    BaseScheme VerboseMode = new BaseScheme("-v", "Run in verbose mode for testing and development.");
    BaseScheme ProcessCurrentDirectory = new BaseScheme("-a", "Load and process all gcode files from current directory. This will override the filename.gcode parameter.");
    
    
    BaseScheme GCode = new BaseScheme(".gcode", "Type one or more filename.gcode to specify file or files to load and process.", endWithKey);
    BaseScheme GCodeList = new BaseScheme(".glist", "Type one or more filename.glist to specify file or files to load and process.", endWithKey);
    BaseScheme ConfigFile = new BaseScheme(".conf", "Type filename of configuration settings of your printer.", endWithKey);

    
    String key = "--help";
    String description = Version.GetDescription()
            +"\n\nHELP"
            +"\nThis program try to load gcode file or files inputed as parameters and estimated printing time in seconds by default."
            +"\n\nAll parameter have to start with \"-\" character."
            +"\n\nUsable parameters are:"
            +"\n\t" + key + "\t\t\t Show this help.\n"
            +"\t" + Version.GetKey() + "\t\t Show version.\n"
            +"\t" + VerboseMode.GetKey() + "\t\t\t " +VerboseMode.GetDescription()+"\n"
            +"\t-filename" + GCode.GetKey() + "\t\t " + GCode.GetDescription() +"\n"
            +"\t-filename" + ConfigFile.GetKey() + "\t\t " + ConfigFile.GetDescription() +"\n"
            +"\t" + ProcessCurrentDirectory.GetKey() + "\t\t\t " + ProcessCurrentDirectory.GetDescription() +"\n";
            //+"\t-filename" + GCodeList.GetKey() + "\t\t " + GCodeList.GetDescription() +" (This is NOT implemented yet.)" +"\n"
            //+"\t-a \t\t\t proccess all gcode files in current directory (This is NOT implemented yet.)\n";
   
    
    BaseScheme Help = new BaseScheme(key, description);
    
    
    String str = "gcode filename -  single gcode file"
            +"-l gcodeFilenameLis - list with gcode files"
            +"-a all gcode files in current directory"
            +"-v verbose mode for testing :D"
            +"output in minutes"
            +"output in hh:mm:ss";
    
    public boolean IsHelp(String str)
    {
        return str.equalsIgnoreCase(Help.GetKey());
    }
    
    public boolean IsVersion(String str)
    {
        return str.equalsIgnoreCase(Version.GetKey());
    }
    
    public boolean IsVerbose(String str)
    {
        return str.equalsIgnoreCase(VerboseMode.GetKey());
    }
}
