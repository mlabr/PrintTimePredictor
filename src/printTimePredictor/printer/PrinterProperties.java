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
package printTimePredictor.printer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author mlabr
 */
public class PrinterProperties
{
    private ArrayList<String> propertyNameList = new ArrayList<>();
    private Map<String, Float> propertyMap = new HashMap<String, Float>();
    
    private final String AccXYStart = "AccXYStart";
    private final String AccXYStop = "AccXYStop";
    private final String AccXYPrintintgStart = "AccXYPrintintgStart";
    private final String AccXYPrintintgStop = "AccXYPrintintgStop";
    private final String AccZStart = "AccZStart";
    private final String AccZStop = "AccZStop";
    private final String AccRetractionStart = "AccRetractionStart";
    private final String AccRetractionStop = "AccRetractionStop";
    private final String AccDefaultStart = "AccDefaultStart";
    private final String AccDefaultStop = "AccDefaultStop";
    
    private final String SpeedXYLimit = "SpeedXYLimit";
    private final String SpeedXYPrintintgLimit = "SpeedXYPrintintgLimit";
    private final String SpeedZLimit = "SpeedZLimit";
    private final String SpeedRetractionLimit =  "SpeedRetractionLimit";
    private final String SpeedDefaultLimit =  "SpeedDefaultLimit";
    
    
    public AccelerationContainer Acceleration;
    
    public PrinterProperties()
    {
        //Default values
        propertyMap.put(AccXYStart, 3000f);
        propertyMap.put(AccXYStop, 3000f);
        propertyMap.put(AccXYPrintintgStart, 4000f);
        propertyMap.put(AccXYPrintintgStop, 4000f);
        propertyMap.put(AccZStart, 4000f);
        propertyMap.put(AccZStop, 4000f);
        propertyMap.put(AccRetractionStart, 3500f);
        propertyMap.put(AccRetractionStop, 3500f);
        propertyMap.put(AccDefaultStart, 3000f);
        propertyMap.put(AccDefaultStop, 3000f);
        
        propertyMap.put(SpeedXYLimit, 3000f);
        propertyMap.put(SpeedXYPrintintgLimit, 3000f);
        propertyMap.put(SpeedZLimit, 3000f);
        propertyMap.put(SpeedRetractionLimit, 3000f);
        propertyMap.put(SpeedDefaultLimit, 3000f);
        
        propertyNameList.add(AccXYStart);
        propertyNameList.add(AccXYStop);
        propertyNameList.add(AccXYPrintintgStart);
        propertyNameList.add(AccXYPrintintgStop);
        propertyNameList.add(AccZStart);
        propertyNameList.add(AccZStop);
        
        propertyNameList.add(AccRetractionStart);
        propertyNameList.add(AccRetractionStart);
        propertyNameList.add(AccDefaultStart);
        propertyNameList.add(AccDefaultStop);
        
        propertyNameList.add(SpeedXYLimit);
        propertyNameList.add(SpeedXYPrintintgLimit);
        propertyNameList.add(SpeedZLimit);
        propertyNameList.add(SpeedRetractionLimit);
        propertyNameList.add(SpeedDefaultLimit);

        initContainer();
    }
    
    
    
    public ArrayList<String> GetPropertyNameList()
    {
        return propertyNameList;
    }
    
    
    public Map<String, Float> GetPropertyMap()
    {
        return propertyMap;
    }
    
    private void initContainer()
    {
        Acceleration = new AccelerationContainer();
        Acceleration.XY = new AccelerationBase(propertyMap.get(AccXYStart), propertyMap.get(AccXYStop));
        Acceleration.XYPrinting = new AccelerationBase(propertyMap.get(AccXYPrintintgStart), propertyMap.get(AccXYPrintintgStop));
        Acceleration.Z = new AccelerationBase(propertyMap.get(AccZStart), propertyMap.get(AccZStop));
        Acceleration.Retraction = new AccelerationBase(propertyMap.get(AccRetractionStart), propertyMap.get(AccRetractionStop));
        Acceleration.Default = new AccelerationBase(propertyMap.get(AccDefaultStart), propertyMap.get(AccDefaultStop));
    }
    
    /*
    public static float AccXYStart = 3000;
    public static float AccXYStop = 3000;
    public static float AccXYPrintintgStart = 4000;
    public static float AccXYPrintintgStop = 4000;
    public static float AccZStart = 4000;
    public static float AccZStop = 4000;
    public static float AccRetractionStart = 3500;
    public static float AccRetractionStop = 3500;
    public static float AccDefaultStart = 3500;
    public static float AccDefaultStop = 3500;
    
    public static float SpeedXYLimit = 0;
    public static float SpeedXYPrintintgLimit = 0;
    public static float SpeedZLimit = 0;
    public static float SpeedRetractionLimit = 0;
    public static float SpeedDefaultLimit = 0;
    */
    
    
}
