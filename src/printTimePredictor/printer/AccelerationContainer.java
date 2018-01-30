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
public class AccelerationContainer
{
    public AccelerationBase XY;// = new AccelerationBase(0, 0);
    public AccelerationBase XYPrinting;// = new AccelerationBase(0, 0);
    public AccelerationBase Z;// = new AccelerationBase(0, 0);
    public AccelerationBase Retraction;// = new AccelerationBase(0, 0);
    public AccelerationBase Default;// = new AccelerationBase(0, 0);
    
    /*
    public AccelerationVector XY = new AccelerationVector(PrinterProperties.AccXYStart, PrinterProperties.AccXYStop);
    public AccelerationVector XYprinting = new AccelerationVector(PrinterProperties.AccXYPrintintgStart, PrinterProperties.AccXYPrintintgStop);
    public AccelerationVector Z = new AccelerationVector(PrinterProperties.AccZStart, PrinterProperties.AccZStop);
    public AccelerationVector Retraction = new AccelerationVector(PrinterProperties.AccRetractionStart, PrinterProperties.AccRetractionStop);
    public AccelerationVector Default = new AccelerationVector(PrinterProperties.AccDefaultStart, PrinterProperties.AccDefaultStop);
    */
    
    public String ToString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(" Acceleration (mm/s^2)\n");
        sb.append(String.format("  XY start: %1$.3f\n  XY stop: %2$.3f", XY.GetStartValue(), XY.GetStopValue()));
        sb.append(String.format("\n  XYprinting start: %1$.3f\n  XYprinting stop: %2$.3f", XYPrinting.GetStartValue(), XYPrinting.GetStopValue()));
        sb.append(String.format("\n  Z start: %1$.3f\n  Z stop: %2$.3f", Z.GetStartValue(), Z.GetStopValue()));
        sb.append(String.format("\n  Retraction start: %1$.3f\n  Retraction stop: %2$.3f", Retraction.GetStartValue(), Retraction.GetStopValue()));
        sb.append(String.format("\n  Default start: %1$.3f\n  Default stop: %2$.3f", Default.GetStartValue(), Default.GetStopValue()));

        return sb.toString();
    }
}
