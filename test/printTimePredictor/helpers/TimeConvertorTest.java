/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package printTimePredictor.helpers;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import printTimePredictor.parser.Vector;

/**
 *
 * @author mlabr
 */
public class TimeConvertorTest
{
    public TimeConvertorTest()
    {
        
    }
    
    /**
     * Test of GetSize method, of class Vector.
     */
    @Test
    public void SecondsToHmsTest()
    {
        System.out.println("--SecondsToHmsTest--");
        int value  = 60;
        String expResult = "0:01:00";
        System.out.println("Test: " + value + " seconds equals "+ expResult);
        
        String result = TimeConvertor.ConvertSecondsToHMS((long) value);
        assertEquals(expResult, result);
        System.out.println("Result: " + result);
        
        
        
        value  = 3600;
        expResult = "1:00:00";
        System.out.println("Test: " + value + " seconds equals "+ expResult);
        
        result = TimeConvertor.ConvertSecondsToHMS((long) value);
        assertEquals(expResult, result);
        System.out.println("Result: " + result);
    }
    
}
