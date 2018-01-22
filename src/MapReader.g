//*************************************************************************
// DESCRIPTION: HDLObf: Identifier Map Parser
//
// Code available from: https://sourceforge.net/projects/hdlobf/
//
// AUTHORS: Vispi Cassod
//
//*************************************************************************
//
// This program is free software; you can redistribute it and/or modify
// it under the terms of either the GNU General Public License or the
// Perl Artistic License.
//
// Verilator is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.
//
//*************************************************************************

options {
    language="Java";
}
{
import java.io.*;
import java.util.*;
}

//-----------------------------------------------------------------------------
// The Map parser
//-----------------------------------------------------------------------------

class IDMapLoader extends Parser;
options {
    k = 2;                      // two token lookahead
    exportVocab = IDMap;        // Call its vocabulary "Map"
    //analyzerDebug = true;     // Debug ANTLR LLkAnalyzer
}

{

      public static HashMap idHMap      =  new HashMap();
      public static boolean DebugTrue   = false;

      public static void main(String[] args) {
        try{
            DebugTrue = true;
            if(args.length > 0)
            {
               IDMapLoaderProcess(args[0]);
            }
            else
            {
               IDMapLoaderProcess("..\\test\\test.map");
            }
        }catch (Exception e)
        {
            System.out.println("Main Error: " + e.getMessage());
            e.printStackTrace();
        }
      }
      public static void IDMapLoaderProcess(String fn) {
       FileInputStream ins;
       DataInputStream dis;
       IDMapLexer lexer;
       IDMapLoader IDMapLoaderPars;
       try
       {
            antlr.Token t = antlr.Token.badToken;
            ins = new  FileInputStream(fn);
            dis = new DataInputStream(ins);
            lexer = new IDMapLexer(dis);
            IDMapLoaderPars = new IDMapLoader(lexer);
            IDMapLoaderPars.source_text();
       }
       catch(Exception e)
       {
           System.out.println("Error in private LinkedList getFileToken(StringBuffer inStrBuf) : " + e.getMessage());
           e.printStackTrace();
       }
      }
      
}

//-----------------------------------------------------------------------------
// Source Text
//-----------------------------------------------------------------------------

source_text  {String strKey="", strValue="";}:
        ( strKey=key_value ASSIGN strValue=key_value { idHMap.put(strKey , strValue ); if(DebugTrue)System.out.println("Key:" + strKey + " = Identifier:" + strValue );} )*
        EOF
        ;

key_value returns [String retString] {retString = "";}:
            idStr:IDENTIFIER
            {retString = idStr.getText();}
          ;
//----------------------------------------------------------------------------
//----------------------------------------------------------------------------
// The Verilog scanner
//----------------------------------------------------------------------------

class IDMapLexer extends Lexer;

options {
    exportVocab = IDMap;  // call the vocabulary "Verilog"
    testLiterals = false;   // don't automatically test for literals
    k = 3;                  // 3 characters of lookahead
}

  // Operators
ASSIGN      : "="   ;

    // an identifier.  Note that testLiterals is set to true!  This means
    // that after we match the rule, we look in the Literals table to see
    // if it's a literal or really an identifer.
IDENTIFIER
      options {testLiterals=true;}
    :
        ('a'..'z'|'A'..'Z'|'_'|'$') ('a'..'z'|'A'..'Z'|'_'|'$'|'0'..'9')*
        ;



// a dummy rule to force vocabulary to be all characters (except special
//   ones that ANTLR uses internally (0 to 2)
protected
VOCAB :
        '\3'..'\177'
        ;

// Whitespace -- ignored
WS_ :
        (  ' '
         | '\t'
         | '\f'
              // handle newlines
         | (  "\r\n"  // Evil DOS
            | '\r'    // Macintosh
            | '\n'    // Unix (the right way)
           )
            { newline(); }
        )
        { _ttype = Token.SKIP; }
        ;

// Single-line comments
SL_COMMENT :
        "//" (~'\n')* '\n'
        { _ttype = Token.SKIP; newline(); }
        ;

// multiple-line comments
ML_COMMENT
    :    "/*"
        (    { LA(2)!='/' }? '*'
        |    '\n' { newline(); }
        |    ~('*'|'\n')
        )*
        "*/"
            { _ttype = Token.SKIP; }
    ;

