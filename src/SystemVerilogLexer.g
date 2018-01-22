//*************************************************************************
// DESCRIPTION: HDLObf: System Verilog Lexer Grammer
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


/////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////
/// LEXER decleration
/////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////
class SystemVerilogNoSkipLexer extends Lexer;

options {
    exportVocab = SystemVerilogNoSkip;  // call the vocabulary "SystemVerilogNoSkip"
    testLiterals = false;               // don't automatically test for literals
    k = 6;                              //6   
}


tokens
{
ALIAS                            = "alias"               ;
ALWAYS                           = "always"              ;
ALWAYS_COMB                      = "always_comb"         ;
ALWAYS_FF                        = "always_ff"           ;
ALWAYS_LATCH                     = "always_latch"        ;
AND                              = "and"                 ;
ASSERT                           = "assert"              ;
ASSIGN                           = "assign"              ;
ASSUME                           = "assume"              ;
AUTOMATIC                        = "automatic"           ;
BEFORE                           = "before"              ;
BEGIN                            = "begin"               ;
BIND                             = "bind"                ;
BINS                             = "bins"                ;
BINSOF                           = "binsof"              ;
BIT                              = "bit"                 ;
BREAK                            = "break"               ;
BUF                              = "buf"                 ;
BUFIF0                           = "bufif0"              ;
BUFIF1                           = "bufif1"              ;
BYTE                             = "byte"                ;
CASE                             = "case"                ;
CASEX                            = "casex"               ;
CASEZ                            = "casez"               ;
CELL                             = "cell"                ;
CHANDLE                          = "chandle"             ;
CLASS                            = "class"               ;
CLOCKING                         = "clocking"            ;
CMOS                             = "cmos"                ;
CONFIG                           = "config"              ;
CONST                            = "const"               ;
CONSTRAINT                       = "constraint"          ;
CONTEXT                          = "context"             ;
CONTINUE                         = "continue"            ;
COVER                            = "cover"               ;
COVERGROUP                       = "covergroup"          ;
COVERPOINT                       = "coverpoint"          ;
CROSS                            = "cross"               ;
DEASSIGN                         = "deassign"            ;
DEFAULT                          = "default"             ;
DEFPARAM                         = "defparam"            ;
DESIGN                           = "design"              ;
DISABLE                          = "disable"             ;
DIST                             = "dist"                ;
DO                               = "do"                  ;
EDGE                             = "edge"                ;
ELSE                             = "else"                ;
END                              = "end"                 ;
ENDCASE                          = "endcase"             ;
ENDCLASS                         = "endclass"            ;
ENDCLOCKING                      = "endclocking"         ;
ENDCONFIG                        = "endconfig"           ;
ENDFUNCTION                      = "endfunction"         ;
ENDGENERATE                      = "endgenerate"         ;
ENDGROUP                         = "endgroup"            ;
ENDINTERFACE                     = "endinterface"        ;
ENDMODULE                        = "endmodule"           ;
ENDPACKAGE                       = "endpackage"          ;
ENDPRIMITIVE                     = "endprimitive"        ;
ENDPROGRAM                       = "endprogram"          ;
ENDPROPERTY                      = "endproperty"         ;
ENDSPECIFY                       = "endspecify"          ;
ENDSEQUENCE                      = "endsequence"         ;
ENDTABLE                         = "endtable"            ;
ENDTASK                          = "endtask"             ;
ENUM                             = "enum"                ;
EVENT                            = "event"               ;
EXPECT                           = "expect"              ;
EXPORT                           = "export"              ;
EXTENDS                          = "extends"             ;
EXTERN                           = "extern"              ;
FINAL                            = "final"               ;
FIRST_MATCH                      = "first_match"         ;
FOR                              = "for"                 ;
FORCE                            = "force"               ;
FOREACH                          = "foreach"             ;
FOREVER                          = "forever"             ;
FORK                             = "fork"                ;
FORKJOIN                         = "forkjoin"            ;
FUNCTION                         = "function"            ;
GENERATE                         = "generate"            ;
GENVAR                           = "genvar"              ;
HIGHZ0                           = "highz0"              ;
HIGHZ1                           = "highz1"              ;
IF                               = "if"                  ;
IFF                              = "iff"                 ;
IFNONE                           = "ifnone"              ;
IGNORE_BINS                      = "ignore_bins"         ;
ILLEGAL_BINS                     = "illegal_bins"        ;
IMPORT                           = "import"              ;
INCDIR                           = "incdir"              ;
INCLUDE                          = "include"             ;
INITIAL                          = "initial"             ;
INOUT                            = "inout"               ;
INPUT                            = "input"               ;
INSIDE                           = "inside"              ;
INSTANCE                         = "instance"            ;
INT                              = "int"                 ;
INTEGER                          = "integer"             ;
INTERFACE                        = "interface"           ;
INTERSECT                        = "intersect"           ;
JOIN                             = "join"                ;
JOIN_ANY                         = "join_any"            ;
JOIN_NONE                        = "join_none"           ;
LARGE                            = "large"               ;
LIBLIST                          = "liblist"             ;
LIBRARY                          = "library"             ;
LOCAL                            = "local"               ;
LOCALPARAM                       = "localparam"          ;
LOGIC                            = "logic"               ;
LONGINT                          = "longint"             ;
MACROMODULE                      = "macromodule"         ;
MATCHES                          = "matches"             ;
MEDIUM                           = "medium"              ;
MODPORT                          = "modport"             ;
MODULE                           = "module"              ;
NAND                             = "nand"                ;
NEGEDGE                          = "negedge"             ;
NEW                              = "new"                 ;
NMOS                             = "nmos"                ;
NOR                              = "nor"                 ;
NOSHOWCANCELLED                  = "noshowcancelled"     ;
NOT                              = "not"                 ;
NOTIF0                           = "notif0"              ;
NOTIF1                           = "notif1"              ;
NULL                             = "null"                ;
OR                               = "or"                  ;
OUTPUT                           = "output"              ;
PACKAGE                          = "package"             ;
PACKED                           = "packed"              ;
PARAMETER                        = "parameter"           ;
PMOS                             = "pmos"                ;
POSEDGE                          = "posedge"             ;
PRIMITIVE                        = "primitive"           ;
PRIORITY                         = "priority"            ;
PROGRAM                          = "program"             ;
PROPERTY                         = "property"            ;
PROTECTED                        = "protected"           ;
PULL0                            = "pull0"               ;
PULL1                            = "pull1"               ;
PULLDOWN                         = "pulldown"            ;
PULLUP                           = "pullup"              ;
PULSESTYLE_ONEVENT               = "pulsestyle_onevent"  ;
PULSESTYLE_ONDETEC               = "pulsestyle_ondetect" ;
PURE                             = "pure"                ;
RAND                             = "rand"                ;
RANDC                            = "randc"               ;
RANDCASE                         = "randcase"            ;
RANDSEQUENCE                     = "randsequence"        ;
RCMOS                            = "rcmos"               ;
REAL                             = "real"                ;
REALTIME                         = "realtime"            ;
REF                              = "ref"                 ;
REG                              = "reg"                 ;
RELEASE                          = "release"             ;
REPEAT                           = "repeat"              ;
RETURN                           = "return"              ;
RNMOS                            = "rnmos"               ;
RPMOS                            = "rpmos"               ;
RTRAN                            = "rtran"               ;
RTRANIF0                         = "rtranif0"            ;
RTRANIF1                         = "rtranif1"            ;
SCALARED                         = "scalared"            ;
SEQUENCE                         = "sequence"            ;
SHORTINT                         = "shortint"            ;
SHORTREAL                        = "shortreal"           ;
SHOWCANCELLED                    = "showcancelled"       ;
SIGNED                           = "signed"              ;
SMALL                            = "small"               ;
SOLVE                            = "solve"               ;
SPECIFY                          = "specify"             ;
SPECPARAM                        = "specparam"           ;
STATIC                           = "static"              ;
STRINGDECLARATION                = "string"              ;
STRONG0                          = "strong0"             ;
STRONG1                          = "strong1"             ;
STRUCT                           = "struct"              ;
SUPER                            = "super"               ;
SUPPLY0                          = "supply0"             ;
SUPPLY1                          = "supply1"             ;
TABLE                            = "table"               ;
TAGGED                           = "tagged"              ;
TASK                             = "task"                ;
THIS                             = "this"                ;
THROUGHOUT                       = "throughout"          ;
TIME                             = "time"                ;
TIMEPRECISION                    = "timeprecision"       ;
TIMEUNIT                         = "timeunit"            ;
TRAN                             = "tran"                ;
TRANIF0                          = "tranif0"             ;
TRANIF1                          = "tranif1"             ;
TRI                              = "tri"                 ;
TRI0                             = "tri0"                ;
TRI1                             = "tri1"                ;
TRIAND                           = "triand"              ;
TRIOR                            = "trior"               ;
TRIREG                           = "trireg"              ;
TYPE                             = "type"                ;
TYPEDEF                          = "typedef"             ;
UNION                            = "union"               ;
UNIQUE                           = "unique"              ;
UNSIGNED                         = "unsigned"            ;
USE                              = "use"                 ;
VAR                              = "var"                 ;
VECTORED                         = "vectored"            ;
VIRTUAL                          = "virtual"             ;
VOID                             = "void"                ;
WAIT                             = "wait"                ;
WAIT_ORDER                       = "wait_order"          ;
WAND                             = "wand"                ;
WEAK0                            = "weak0"               ;
WEAK1                            = "weak1"               ;
WHILE                            = "while"               ;
WILDCARD                         = "wildcard"            ;
WIRE                             = "wire"                ;
WITH                             = "with"                ;
WITHIN                           = "within"              ;
WOR                              = "wor"                 ;
XNOR                             = "xnor"                ;
XOR                              = "xor"                 ;
OPTION                           = "option"              ;
TYPE_OPTION                      = "type_option"         ;
PATHPLUSDOLLAR                   = "PATHPULSE$"          ;
FULLSKEW                         = "$fullskew"           ;
HOLD                             = "$hold"               ;
NOCHANGE                         = "$nochange"           ;
PERIOD                           = "$period"             ;
RECOVERY                         = "$recovery"           ;
RECREM                           = "$recrem"             ;
REMOVAL                          = "$removal"            ;
ROOT                             = "$root"               ;
SETUP                            = "$setup"              ;
SETUPHOLD                        = "$setuphold"          ;
SKEW                             = "$skew"               ;
TIMESKEW                         = "$timeskew"           ;
UNIT                             = "$unit"               ;
WIDTH                            = "$width"              ;
RANDOMIZE                        = "randomize"           ;
UNDERSCORE                       = "_"                   ;
DPIDECLERATION                   = "\"DPI\""             ;
TIME_UNIT_S                      = "s"                   ;
TIME_UNIT_MS                     = "ms"                  ;
TIME_UNIT_US                     = "us"                  ;
TIME_UNIT_NS                     = "ns"                  ;
TIME_UNIT_PS                     = "ps"                  ;
TIME_UNIT_FS                     = "fs"                  ;
TIME_UNIT_STEP                   = "step"                ;

}

AT                               : "@"                   ;
COLON                            : ":"                   ;
COMMA                            : ","                   ;
DOT                              : "."                   ;
ASSINGMENT                       : "="                   ;
MINUS                            : "-"                   ;
MINUSMINUS                       : "--"                  ;
LBRACK                           : "["                   ;
RBRACK                           : "]"                   ;
LCURLY                           : "{"                   ;
RCURLY                           : "}"                   ;
LPAREN                           : "("                   ;
RPAREN                           : ")"                   ;
POUND                            : "#"                   ;
QUESTION                         : "?"                   ;
SEMI                             : ";"                   ;
PLUS                             : "+"                   ;
PLUSPLUS                         : "++"                  ;
LNOT                             : "!"                   ;
BNOT                             : "~"                   ;
BAND                             : "&"                   ;
RNAND                            : "~&"                  ;
BOR                              : "|"                   ;
RNOR                             : "~|"                  ;
BXOR                             : "^"                   ;
RXNOR                            : "~^" | "^~"           ;
DIV                              : "/"                   ;
FORWARD                          : '\\'                  ;
TRIGGER                          : "->"                  ;
PPATH                            : "=>"                  ;
FPATH                            : "*>"                  ;
SPECIAL_BKT_DOT_STAR_BKT_SPECIAL : "(.*)"                ;
COLONEQ                          : ":="                  ;
COLONDIV                         : ":/"                  ;
COLONCOLON                       : "::"                  ;
DOLLAR                           : "$"                   ;
OR_TRIGGER                       : "|->"                 ;
POUNDPOUND                       : "##"                  ;
OR_PPATH                         : "|=>"                 ;
BRACE_STAR                       : "[*"                  ;
BRACE_EQ                         : "[="                  ;
BRACE_TRIGGER                    : "[->"                 ;
ATAT                             : "@@"                  ;
DOTSTAR                          : ".*"                  ;
TRIGGER_GT                       : "->>"                 ;
PLUSEQ                           : "+="                  ;
TRIPLEAND                        : "&&&"                 ;
MULT                             : "*"                   ;
PERCENT                          : "%"                   ;
EQEQ                             : "=="                  ;
NOTEQ                            : "!="                  ;
EQEQEQ                           : "==="                 ;
NOTEQEQ                          : "!=="                 ;
EQQUESTEQ                        : "=?="                 ;
NOTQUESTEQ                       : "!?="                 ;
ANDAND                           : "&&"                  ;
OROR                             : "||"                  ;
MULTMULT                         : "**"                  ;
LE                               : "<"                   ;
LEEQ                             : "<="                  ;
GT                               : ">"                   ;
GTEQ                             : ">="                  ;
GTGT                             : ">>"                  ;
LELE                             : "<<"                  ;
GTGTGT                           : ">>>"                 ;
LELELE                           : "<<<"                 ;
MINUSEQ                          : "-="                  ;
MULTEQ                           : "*="                  ;
DIVEQ                            : "/="                  ;
PERCENTEQ                        : "%="                  ;
ANDEQ                            : "&="                  ;
OREQ                             : "|="                  ;
XOREQ                            : "^="                  ;
LELEEQ                           : "<<="                 ;
GTGTEQ                           : ">>="                 ;
LELELEEQ                         : "<<<="                ;
GTGTGTEQ                         : ">>>="                ;
MINUSCOLON                       : "-:"                  ;
PLUSCOLON                        : "+:"                  ;



//
// A.9.2 Comments
//

// Single-line comments
ONE_LINE_COMMENT :
        "//" (~'\n')* '\n'
        //{ _ttype = Token.SKIP; newline(); }
        ;
// multiple-line comments
BLOCK_COMMENT
    :    "/*"
        (    { LA(2)!='/' }? '*'
        |    '\n' { newline(); }
        |    ~('*'|'\n')
        )*
        "*/"
        //{ _ttype = Token.SKIP; }
    ;
    
//
// Attributes
//

// multiple-line attributes
BLOCK_ATTRIBUTE
    :    "(*"
        (    { LA(2)!='/' }? '*'
        |    '\n' { newline(); }
        |    ~('*'|'\n')
        )*
        "*)"
        //{ _ttype = Token.SKIP; }
    ;

// a numeric literal
//
protected  SIZED_NUMBER     : (SIZE)? BASE SIZED_DIGIT (SIZED_DIGIT | '_')* ;
protected  SIZE             : (DIGIT)+ ;
protected  BASE             : '\'' ( 'd' | 'D' | 'h' | 'H' | 'o' | 'O' | 'b' | 'B' );
protected  SIZED_DIGIT      : DIGIT | HEXDIGIT | 'x' | 'X' | 'z' | 'Z' | '?';
protected  UNSIZED_NUMBER   : DIGIT (DIGIT | '_')* ( '.' (DIGIT | '_')* )? (EXPONENT)?;
protected  DIGIT            : ('0'..'9');
protected  HEXDIGIT         : ('A'..'F'|'a'..'f');
protected  EXPONENT         : ('e'|'E') ('+'|'-')? ('0'..'9')+;

NUMBER
        :
          ((SIZE)? ('_' | '.' | EXPONENT))  => UNSIZED_NUMBER
        | ((SIZE)? BASE)                    => SIZED_NUMBER
        | SIZE
        ;



//
// A.9.4 White space
//
// Whitespace
WHITE_SPACE :
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
        //{ _ttype = Token.SKIP; }
        ;

//
// A.9.3 Identifiers
//
ESCAPED_IDENTIFIER      :   '\\'! (~ '\040')+ ('\040'|'\t'|'\n')LNOT ;

// string literals
STRING
        options {testLiterals=true; /*generateAmbigWarnings=false;*/}
        :
            '"' (~('"'|'\n'))* '"'
        ;

SIMPLE_IDENTIFIER
    options {testLiterals=true; /*generateAmbigWarnings=false;*/}
    :
        ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'$'|'0'..'9')*
        ;

SYSTEM_TF_IDENTIFIER
    options {testLiterals=true; /*generateAmbigWarnings=false;*/}
    : '$' SIMPLE_IDENTIFIER ;


COMPILER_DIRECTIVE
    : '`' SIMPLE_IDENTIFIER  (~'\n')* '\n';
