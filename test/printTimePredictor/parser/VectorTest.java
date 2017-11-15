/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package printTimePredictor.parser;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Miroslav Labr
 */
public class VectorTest
{
    
    public VectorTest()
    {
    }


    /**
     * Test of GetSize method, of class Vector.
     */
    @Test
    public void testGetSize()
    {
        System.out.println("GetSize");
        Vector instance = new Vector(4,0,0,3);
        double expResult = 4.0;
        double result = instance.GetSize(); 
        assertEquals(expResult, result, 0.0);
        
        instance = new Vector(4,4,0,3);
        expResult = 5.6569;
        result = instance.GetSize();  
        assertEquals(expResult, result, 0.001);
        // TODO review the generated test code and remove the default call to fail.             
        //fail("The test case is a prototype.");
    }
/**
     * Test of GetSize method, of class Vector.
     */
    @Test
    public void testGetType()
    {
        //1 - moving
        //2 - retraction
        //3 - printing
        //4 - vertical
        //any other result cause that vector is unknown type.
        System.out.println("Test: GetType");
        System.out.println("  XY Move.");
        Vector instance = new Vector(4,0,0,0);
        double expResult = 1.0;
        double result = instance.GetType(); 
        assertEquals(expResult, result, 0.0);
        
        System.out.println("  XY Move.");
        instance = new Vector(4,4,0,0);
        expResult = 1.0;
        result = instance.GetType();  
        assertEquals(expResult, result, 0.0 );
        
        System.out.println("  Retraction.");
        instance = new Vector(0,0,0,3);
        expResult = 2.0;
        result = instance.GetType();  
        assertEquals(expResult, result, 0.0 );
        
        System.out.println("  Printing");
        instance = new Vector(4,4,0,3);
        expResult = 3.0;
        result = instance.GetType();  
        assertEquals(expResult, result, 0.0 );
        
        System.out.println("  Printing");
        instance = new Vector(4,0,0,3);
        expResult = 3.0;
        result = instance.GetType();  
        assertEquals(expResult, result, 0.0 );
        
        System.out.println("  Z Move");
        instance = new Vector(0,0,2,0);
        expResult = 4.0;
        result = instance.GetType();  
        assertEquals(expResult, result, 0.0 );
       
    }
    

    
}
