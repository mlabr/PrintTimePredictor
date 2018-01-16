/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package printTimePredictor.helpers;

/**
 *
 * @author mlabr
 */
public class TimeConvertor
{
    public static String ConvertSecondsToHMS(long seconds)
    {
        long s = seconds % 60;
        long m = (seconds / 60) % 60;
        long h = (seconds / (60 * 60)) % 24;
        return String.format("%d:%02d:%02d", h,m,s);
    }
}
