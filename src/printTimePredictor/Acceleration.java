/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package printTimePredictor;

/**
 *
 * @author mlabr
 */
public class Acceleration
{
    private double start;
    private double stop;
    
    public Acceleration(double start, double stop)
    {
        this.start = start; // mm/s^2
        this.stop = stop; // mm/s^2
    }
    
    public double GetStartValue()
    {
        return start;
    }
    
    public double GetStopValue()
    {
        return stop;
    }
}
