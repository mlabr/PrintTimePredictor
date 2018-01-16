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

import java.util.ArrayList;

/**
 *
 * @author Miroslav Labr
 */
public class ParamHandler
{
    private final ArrayList<String> parameterList = new ArrayList(); 
    private final ArrayList<String> unrecognisedParameterList = new ArrayList();
    private final ArrayList<String> gcodeList = new ArrayList<>();
    private boolean isHelpInParams = false;
    private boolean isVersionInParams = false;
    private boolean isVerboseMode = false;
    private boolean isGcodeInParams = false;
    private boolean isProcessCurrentDirectory = false;
    
    
    private final Schemes schemes = new Schemes();

    public ParamHandler(String[] args)
    {
        if(args.length > 0)
        {
            for (String arg : args)
            {
                if (isParameter(arg))
                {
                    parameterList.add(arg);
                    if(isHelp(arg))
                    {
                        isHelpInParams = true;
                    }
                    if(isVersion(arg))
                    {
                        isVersionInParams = true;
                    }
                    
                    if(isVerbose(arg))
                    {
                        isVerboseMode = true;
                    }
                    
                    if(isGCode(arg))
                    {
                        gcodeList.add(arg.substring(1));
                        
                        isGcodeInParams = true;
                    }
                    
                    if(isProcessCurrentdirectory(arg))
                    {
                        isProcessCurrentDirectory = true;
                    }
                    
                } else
                {
                    unrecognisedParameterList.add(arg); 
                }
            }
        }       
    }
    
    public ArrayList<String> GetParameterList()
    {
        return parameterList;
    }
    
    public ArrayList<String> GetGCodeList()
    {
        return gcodeList;
    }
    
    public ArrayList<String> GetUnrecogisedParameterList()
    {
        return unrecognisedParameterList;
    }
    
    
    public String GetHelp()
    {
        if(isHelpInParams)
        {
            return schemes.Help.GetDescription();
        }
        return null;
    }
    
    public String GetVersion()
    {
        if(isVersionInParams)
        {
            return schemes.Version.GetDescription();
        }
        return null;
    }
    
    public boolean IsVerbose()
    {
        return isVerboseMode;
    }
    
    public boolean isProcessCurrentDirectory()
    {
        return isProcessCurrentDirectory;
    }
    
    private boolean isParameter(String str)
    {
        return schemes.Parameter.IsEqualToRule(str);
    }
    
    private boolean isHelp(String str)
    {
        //return str.equalsIgnoreCase(schemes.Help.GetKey());
        return schemes.Help.IsEqualToRule(str);
    }
    
    private boolean isVersion(String str)
    {
        return schemes.Version.IsEqualToRule(str);
    }
    
    private boolean isVerbose(String str)
    {
        return schemes.VerboseMode.IsEqualToRule(str);
    }
    
    private boolean isProcessCurrentdirectory(String str)
    {
        return schemes.ProcessCurrentDirectory.IsEqualToRule(str);
    }

    
    private boolean isGCode(String str)
    {
        return schemes.GCode.IsEqualToRule(str);           
    }
    

}
