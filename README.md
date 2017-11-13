# PrintTimePredictor
Simple console program to calculate time for 3d print from gcode file. The output is in seconds. You can proces multiple time at once. The result will be summarized.

Writen in Java to run everywhere.

1) To run, open console (in Windows run command "cmd", in Linux... you know)
2) write and execute: java -jar PrintTimePredictor.jar --help

Program will show you help, so you will se arguments, that you can use.

--help                  Show help.
--version               Show version of program.
-v                      Run in verbose mode for testing and development.
-filename.gcode         Type one or more filename.gcode to specify file or files to load and process.


Example 1:
cmd: java -jar PrintTimePredictor.jar -Vystuha_rohu_v1.gcode
result: Program try to read the file "Vystuha_rohu_v1.gcode" and calculate the time that it is need to print. The result number is written into console.

Example 2:
cmd: java -jar PrintTimePredictor.jar -Vystuha_rohu_v1.gcode -Pojezd_Z_LP_rameno_v1.1.gcode
result: Program try to read the file "Vystuha_rohu_v1.gcode" and "Pojezd_Z_LP_rameno_v1.1.gcode", then calculate the time that it is need to print. The result number is written into console.
