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



package printTimePredictor;

import printTimePredictor.processor.Calculator;
import printTimePredictor.parsers.GCodeParser;
import printTimePredictor.service.ProgramLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import printTimePredictor.dataAccess.*;
import printTimePredictor.dataAccess.FileDataDto;
import printTimePredictor.helpers.TimeConvertor;
import printTimePredictor.params.ParamHandler;
import printTimePredictor.gcode.Vector;
import printTimePredictor.parsers.ConfigParser;
import printTimePredictor.printer.PrinterProperties;

/**
 *
 * @author mlabr
 */
public class PrintTimePredictor
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {

        ParamHandler paramHandler = new ParamHandler(args);
        FileHandler fileHandler = new FileHandler();
        PrinterProperties printer = new PrinterProperties();
        
        
        boolean isVerbose = paramHandler.IsVerbose();
        ProgramLog log = new ProgramLog();

        
        //Update pinter settings
        String configFilename = paramHandler.GetConfigFilename();
        String PrinterConfFilename = paramHandler.GetConfigFilename();
        if(PrinterConfFilename != null)
        {
            FileDataDto configFile = fileHandler.GetConfigFileDtoByFilename(PrinterConfFilename);
        
            ArrayList<String> containList = configFile.GetData();
            Map<String, Float> configMap =  ConfigParser.GetConfigMap(containList);

            if(configMap != null)
            {
                printer.UpdatePropertyMap(configMap);
            }
        }
        
        
        ArrayList<String> propertyNameList = printer.GetPropertyNameList();
        Map<String, Float> map = printer.GetPropertyMap(); 
        

        String help = paramHandler.GetHelp();
        if (help != null)
        {
            System.out.println(help);
        }

        String version = paramHandler.GetVersion();
        if (version != null)
        {
            System.out.println(version);
        }
        
        
        ArrayList<String> gcodeList = new ArrayList<>();
        
        if(paramHandler.isProcessCurrentDirectory())
        {
            gcodeList = fileHandler.GetFilenameListByDirectory(fileHandler.GetCurrentDirecory());  
        }
        else
        {
            gcodeList = paramHandler.GetGCodeList();
        }

        
        
        //TODO Refactore
        if (isVerbose)
        {
            ArrayList<String> parameterList = paramHandler.GetParameterList();

            for (String str : parameterList)
            {
                System.out.println("Parameters: " + str);
            }

            ArrayList<String> unrecognisedParameterList = paramHandler.GetUnrecogisedParameterList();
            for (String str : unrecognisedParameterList)
            {
                System.out.println("Unrecognised parameter: " + str);
            }
            
            
            System.out.println("Settings:\n" + printer.Acceleration.ToString() + "\n");

            System.out.println("GCode files to load:");
            for (String str : gcodeList)
            {
                System.out.println("  " + str);
            }

            if (parameterList.size() < 1)
            {
                System.out.println("No input valid parameters, input --help.");
            };
            
            System.out.println("\nProcessed GCode files:");
        }
        
        
        
        ArrayList<FileDataDto> dtoList = new ArrayList<>();
        dtoList = fileHandler.GetGCodeDtoListByNameList(gcodeList);
        
        Calculator calculator = new Calculator(printer);
        
        
        float TotalEstimatedPrintTime = 0;
        for(FileDataDto dto : dtoList)
        {           
            GCodeParser analyzer = new GCodeParser(dto.GetData().get(0));
            
            ArrayList<String> lines = dto.GetData();
            for(String line : lines )
            {
                analyzer.AddLine(line);
            }
            ArrayList<Vector> vectorList = analyzer.GetVectorList();
        
            float estimatedPrintTime = calculator.ProcessVectorList(vectorList);
            TotalEstimatedPrintTime += estimatedPrintTime;
            if(isVerbose)
            {  
                String hoursMinutesSeconds = TimeConvertor.ConvertSecondsToHMS((long) estimatedPrintTime);
                
                System.out.println("  " + dto.GetName() + ": " + estimatedPrintTime  +" seconds; " + hoursMinutesSeconds);
            }

        }     
        
        if(isVerbose)
        {
            String hoursMinutesSeconds = TimeConvertor.ConvertSecondsToHMS((long) TotalEstimatedPrintTime);
            System.out.println("\nTotal estimated print time: " + TotalEstimatedPrintTime +" seconds; " + hoursMinutesSeconds);   
        }
        else
        {
            System.out.println(TotalEstimatedPrintTime);
        }
        
        
        
        ArrayList<String> errorsDurringLoadingFiles = fileHandler.GetErrorsList();
        
        if(isVerbose)
        {
            if(errorsDurringLoadingFiles.size() > 0)
            {
                System.out.println("\nErrors:");
                for(String error : errorsDurringLoadingFiles)
                {
                    System.out.println(error);
                }
            }
            System.out.println(log.GetLog());
        }
    }

}
