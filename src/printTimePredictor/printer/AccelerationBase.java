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

/**
 *
 * @author mlabr
 */
public class AccelerationBase
{
    private double start;
    private double stop;
    
    public AccelerationBase(double start, double stop)
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
