#! /bin/bash

source ./source_classpath.sh
(java antlr.Tool -o ./generated MapReader.g > ../log/MapReader_OutputLog.dat)                           >& ../log/MapReader_ErrorLog.dat
(java antlr.Tool -o ./generated SystemVerilogLexer.g > ../log/SystemVerilogLexer_OutputLog.dat)         >& ../log/SystemVerilogLexer_ErrorLog.dat
(java antlr.Tool -o ./generated VHDLLexer.g > ../log/VHDLLexer_OutputLog.dat)   >& ../log/VHDLLexer_ErrorLog.dat
(javac -d ../bin  ./generated/*.java *.java ) >& ../log/JavacErrorLog.dat
echo please view ../log/JavacErrorLog.dat for errors
