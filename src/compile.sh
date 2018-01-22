#! /bin/bash

SV_GRAMMAR="Sv2012.g4"
VERILOG_GRAMMAR="Verilog2001.g4"

source ./source_classpath.sh
(java org.antlr.v4.Tool -o ./generated ${VERILOG_GRAMMAR} > ../log/SystemVerilogLexer_OutputLog.dat)  >& ../log/SystemVerilogLexer_ErrorLog.dat
(java org.antlr.v4.Tool -o ./generated ${SV_GRAMMAR} > ../log/SystemVerilogLexer_OutputLog.dat)  >& ../log/SystemVerilogLexer_ErrorLog.dat
(javac -d ../bin  ./generated/*.java *.java ) >& ../log/JavacErrorLog.dat
echo please view ../log/JavacErrorLog.dat for errors
