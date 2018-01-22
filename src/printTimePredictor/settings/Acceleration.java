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
package printTimePredictor.settings;

import printTimePredictor.AccelerationVector;

/**
 *
 * @author mlabr
 */
public class Acceleration
{
    public AccelerationVector XY = new AccelerationVector(3000,3000);
    public AccelerationVector XYprinting = new AccelerationVector(4000,4000);
    public AccelerationVector Z = new AccelerationVector(4000,4000);
    public AccelerationVector Retraction = new AccelerationVector(3500,3500);
    public AccelerationVector Default = new AccelerationVector(3500,3500);
    
    
    public String ToString()
    {
        StringBuilder sb = new StringBuilder();
        
        sb.append(String.format("  XY start: %1$.3f\n  XY stop: %2$.3f", XY.GetStartValue(), XY.GetStopValue()));
        sb.append(String.format("\n  XYprinting start: %1$.3f\n  XYprinting stop: %2$.3f", XYprinting.GetStartValue(), XYprinting.GetStopValue()));
        sb.append(String.format("\n  Z start: %1$.3f\n  Z stop: %2$.3f", Z.GetStartValue(), Z.GetStopValue()));
        sb.append(String.format("\n  Retraction start: %1$.3f\n  Retraction stop: %2$.3f", Retraction.GetStartValue(), Retraction.GetStopValue()));
        sb.append(String.format("\n  Default start: %1$.3f\n  Default stop: %2$.3f", Default.GetStartValue(), Default.GetStopValue()));

        return sb.toString();
    }
}
