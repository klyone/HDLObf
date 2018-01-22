//*************************************************************************
// DESCRIPTION: HDLObf: VHDL Lexer Grammer
//
// Code available from: https://sourceforge.net/projects/hdlobf/
//
// AUTHORS: Vispi Cassod
// Contributions (Fixes Provided by):
//          Joseph Chapman
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
//
// V1.2 : Includes fix provided by Joseph Chapman
//
//*************************************************************************
options {
    language="Java";
}
{
import java.io.*;
import java.util.*;
}

class VhdlNoSkipLexer extends Lexer ;
options {
        exportVocab     =   VHDLNoSkip    ;       // Call its vocabulary "vhdl"
        charVocabulary = '\0'..'\377';
        k=9;
        testLiterals=true ;
        caseSensitive=false ;
        caseSensitiveLiterals=false ;
}

tokens
{
ABS           = "abs" ;
ACCESS        = "access" ;
ACROSS        = "across" ;
AFTER         = "after" ;
ALIAS         = "alias" ;
ALL           = "all" ;
AND           = "and" ;
ARCHITECTURE  = "architecture" ;
ARRAY         = "array" ;
ASSERT        = "assert" ;
ATTRIBUTE     = "attribute" ;
BEGIN         = "begin" ;
BLOCK         = "block" ;
BODY          = "body" ;
BREAK         = "break" ;
BUFFER        = "buffer" ;
BUS           = "bus" ;
CASE          = "case" ;
COMPONENT     = "component" ;
CONFIGURATION = "configuration" ;
CONSTANT      = "constant" ;
DISCONNECT    = "disconnect" ;
DOWNTO        = "downto" ;
ELSE          = "else" ;
ELSIF         = "elsif" ;
END           = "end" ;
ENTITY        = "entity" ;
EXIT          = "exit" ;
FILE          = "file" ;
FOR           = "for" ;
FUNCTION      = "function" ;
GENERATE      = "generate" ;
GENERIC       = "generic" ;
GROUP         = "group" ;
GUARDED       = "guarded" ;
IF            = "if" ;
IMPURE        = "impure" ;
IN            = "in" ;
INERTIAL      = "inertial" ;
INOUT         = "inout" ;
IS            = "is" ;
LABEL         = "label" ;
LIBRARY       = "library" ;
LIMIT         = "limit " ;
LINKAGE       = "linkage" ;
LITERAL       = "literal" ;
LOOP          = "loop" ;
MAP           = "map" ;
MOD           = "mod" ;
NAND          = "nand" ;
NATURE        = "nature " ;
NEW           = "new" ;
NEXT          = "next" ;
NOISE         = "noise " ;
NOR           = "nor" ;
NOT           = "not" ;
NULL          = "null" ;
OF            = "of" ;
ON            = "on" ;
OPEN          = "open" ;
OR            = "or" ;
OTHERS        = "others" ;
OUT           = "out" ;
PACKAGE       = "package" ;
PORT          = "port" ;
POSTPONED     = "postponed" ;
PROCEDURAL    = "procedural" ;
PROCEDURE     = "procedure" ;
PROCESS       = "process" ;
PROTECTED     = "protected" ;
PURE          = "pure" ;
QUANTITY      = "quantity" ;
RANGE         = "range" ;
RECORD        = "record" ;
REFERENCE     = "reference" ;
REGISTER      = "register" ;
REJECT        = "reject" ;
REM           = "rem" ;
REPORT        = "report" ;
RETURN        = "return" ;
ROL           = "rol" ;
ROR           = "ror" ;
SELECT        = "select" ;
SEVERITY      = "severity" ;
SHARED        = "shared" ;
SIGNAL        = "signal" ;
SLA           = "sla" ;
SLL           = "sll" ;
SPECTRUM      = "spectrum" ;
SRA           = "sra" ;
SRL           = "srl" ;
SUBNATURE     = "subnature" ;
SUBTYPE       = "subtype" ;
TERMINAL      = "terminal" ;
THEN          = "then" ;
THROUGH       = "through" ;
TO            = "to" ;
TOLERANCE     = "tolerance" ;
TRANSPORT     = "transport" ;
TYPE          = "type" ;
UNAFFECTED    = "unaffected" ;
UNITS         = "units" ;
UNTIL         = "until" ;
USE           = "use" ;
VARIABLE      = "variable" ;
WAIT          = "wait" ;
WHEN          = "when" ;
WHILE         = "while" ;
WITH          = "with" ;
XNOR          = "xnor" ;
XOR           = "xor" ;
}

L_PAREN       : '(' ;
EQUAL_EQUAL   : "==" ;
AMPERSAND     : '&' ;
R_PAREN       : ')' ;
L_BRACKET     : '[' ;
R_BRACKET     : ']' ;
COMMA         : ',' ;
COLON_EQUAL   : ":=" ;
COLON         : ':' ;
SEMI_COLON    : ';' ;
LESS_GREATER  : "<>" ;
LESS_EQUAL    : "<=" ;
LESS          : "<" ;
EQUAL_GREATER : "=>" ;
EQUAL         : '=' ;
GREATER_EQUAL : ">=" ;
GREATER       : '>' ;
CHOICE1       : '|' ;
// CHOICE2       : '!' ;
NOT_EQUAL     : "/=" ;
DOT           : '.' ;
EXPONENT      : "**" ;
MULTIPLY      : '*'  ;
DIVIDE        : '/' ;
PLUS          : '+' ;
MINUS         : '-' ;
UNDERSCORE    : '_' ;

//BIT_STRING_LITERAL
//  : 'b' '"' ('0' | '1') ( ('_')? ('0' | '1') ) '"'
//  | 'b' '%' ('0' | '1') ( ('_')? ('0' | '1') ) '%'
//  | 'o' '"' ('0'..'7') ( ('_')? ('0'..'7') ) '"'
//  | 'o' '%' ('0'..'7') ( ('_')? ('0'..'7') ) '%'
//  | 'x' '"' ('0'..'9' | 'a'..'f') ( ('_')? ('0'..'9' | 'a'..'f') ) '"'
//  | 'x' '%' ('0'..'9' | 'a'..'f') ( ('_')? ('0'..'9' | 'a'..'f') ) '%'


BIT_STRING_LITERAL
  : 'b' '"' ('0' | '1' | '_')* '"'
  | 'b' '%' ('0' | '1' | '_')* '%'
  | 'o' '"' ('0'..'7' | '_')* '"'
  | 'o' '%' ('0'..'7' | '_')* '%'
  | 'x' '"' ('0'..'9' | 'a'..'f' | '_')* '"'
  | 'x' '%' ('0'..'9' | 'a'..'f' | '_')* '%' ;



STRING_LITERAL :
           '"'
             ((~('\n'|'\r'|'"')))*
           '"'
           { $setType(STRING_LITERAL); };

protected
QUOTE : '\''  ;

protected
CHARACTER_LITERAL :
           '\'' (~('\n'|'\r')) '\''
           ;

CHARACTER_LITERAL_OR_QUOTE :
          ( '\'' (~('\n'|'\r')) '\'') => CHARACTER_LITERAL { $setType(CHARACTER_LITERAL) ;}
        | ('\'' ) => QUOTE { $setType(QUOTE) ;}
  ;

WS
  : ( ' ' |
      '\t'
    | '\f'
    | ( "\r\n"
      | '\n'
      )
      { newline(); }
    )
  ;



protected
DIGIT : '0'..'9' ;

protected
LETTER :   'a'..'z' ;

SIMPLE_IDENTIFIER
options {testLiterals=true ; }
  : LETTER ( LETTER | DIGIT | '_' )*   { setText(getText().toLowerCase());}
  ;


BASED_INTEGER_LITERAL_OR_DECIMAL_INTEGER_LITERAL :
      (INTEGER '#') => BASED_INTEGER_LITERAL { $setType(BASED_INTEGER_LITERAL) ;}
    | (INTEGER) =>  DECIMAL_INTEGER_LITERAL { $setType(DECIMAL_INTEGER_LITERAL) ;}
;

protected
DECIMAL_INTEGER_LITERAL : INTEGER ( DOT INTEGER )? ( EXP )? ;

protected
BASED_INTEGER_LITERAL :
   INTEGER '#' BASED_INTEGER ( DOT BASED_INTEGER )? '#' ( EXP )?
 ;

protected
INTEGER : DIGIT (( UNDERSCORE )? DIGIT)*  ;

protected
BASED_INTEGER
:  (DIGIT | LETTER) ( ( UNDERSCORE )? (DIGIT | LETTER) )*
;

protected
EXP
: ('e') (PLUS|MINUS)? INTEGER
;

COMMENT
:
  "--" (~('\n'|'\r'))*   //{ $setType(Token.SKIP); }
;
