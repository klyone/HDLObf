#! /bin/bash

VERILOG_GRAMMAR="Verilog2001.g4"
VHDL_GRAMMAR="vhdl.g4"

source ./source_classpath.sh
(java org.antlr.v4.Tool -o ./generated ${VERILOG_GRAMMAR} > ../log/SystemVerilogLexer_OutputLog.dat)  >& ../log/SystemVerilogLexer_ErrorLog.dat
(java org.antlr.v4.Tool -o ./generated ${VHDL_GRAMMAR} > ../log/VHDLLexer_OutputLog.dat)  >& ../log/VHDLLexer_ErrorLog.dat
(javac -d ../bin  ./generated/*.java *.java ) >& ../log/JavacErrorLog.dat
echo please view ../log/JavacErrorLog.dat for errors
