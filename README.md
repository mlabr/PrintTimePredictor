# PrintTimePredictor
Simple console program to estimate time of 3d printing from gcode file. Works only with FFF (FDM) printers with orthogonal system (no delta yet, sorry). The output from this program is displayed in seconds or more detailed if verbose mode is used. You can also process multiple time at once. The result will be summarized.

Writen in Java to run everywhere.

1) To run, open console (in Windows run command "cmd", in Linux... you know)
2) Write and execute: java -jar PrintTimePredictor.jar --help

Program will show you help, so you will se arguments, that you can use.

--help                  Show help.
--version               Show version of program.
-v                      Run in verbose mode for testing and development.
-filename.gcode         Type one or more filename.gcode to specify file or files to load and process.
-a                      Load and procces all gcode files from current directory.
-printerName.conf       Use configuration in external configuration file named "printerName.conf"


Example 1:
cmd: java -jar PrintTimePredictor.jar -Vystuha_rohu_v1.gcode
result: Program try to read the file "Vystuha_rohu_v1.gcode" and calculate the time that it is need to print. The result number is written into console.

Example 2:
cmd: java -jar PrintTimePredictor.jar -Vystuha_rohu_v1.gcode -Pojezd_Z_LP_rameno_v1.1.gcode
result: Program try to read the file "Vystuha_rohu_v1.gcode" and "Pojezd_Z_LP_rameno_v1.1.gcode", then calculate the time that it is need to print. The result number is written into console.

Keep in mind that this program is still under development, so the calculated time is not 100% accurate and need some testing.
