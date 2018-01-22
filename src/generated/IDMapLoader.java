// $ANTLR 2.7.4: "MapReader.g" -> "IDMapLoader.java"$

import antlr.TokenBuffer;
import antlr.TokenStreamException;
import antlr.TokenStreamIOException;
import antlr.ANTLRException;
import antlr.LLkParser;
import antlr.Token;
import antlr.TokenStream;
import antlr.RecognitionException;
import antlr.NoViableAltException;
import antlr.MismatchedTokenException;
import antlr.SemanticException;
import antlr.ParserSharedInputState;
import antlr.collections.impl.BitSet;

import java.io.*;
import java.util.*;

public class IDMapLoader extends antlr.LLkParser       implements IDMapTokenTypes
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
      

protected IDMapLoader(TokenBuffer tokenBuf, int k) {
  super(tokenBuf,k);
  tokenNames = _tokenNames;
}

public IDMapLoader(TokenBuffer tokenBuf) {
  this(tokenBuf,2);
}

protected IDMapLoader(TokenStream lexer, int k) {
  super(lexer,k);
  tokenNames = _tokenNames;
}

public IDMapLoader(TokenStream lexer) {
  this(lexer,2);
}

public IDMapLoader(ParserSharedInputState state) {
  super(state,2);
  tokenNames = _tokenNames;
}

	public final void source_text() throws RecognitionException, TokenStreamException {
		
		String strKey="", strValue="";
		
		try {      // for error handling
			{
			_loop3:
			do {
				if ((LA(1)==IDENTIFIER)) {
					strKey=key_value();
					match(ASSIGN);
					strValue=key_value();
					idHMap.put(strKey , strValue ); if(DebugTrue)System.out.println("Key:" + strKey + " = Identifier:" + strValue );
				}
				else {
					break _loop3;
				}
				
			} while (true);
			}
			match(Token.EOF_TYPE);
		}
		catch (RecognitionException ex) {
			reportError(ex);
			consume();
			consumeUntil(_tokenSet_0);
		}
	}
	
	public final String  key_value() throws RecognitionException, TokenStreamException {
		String retString;
		
		Token  idStr = null;
		retString = "";
		
		try {      // for error handling
			idStr = LT(1);
			match(IDENTIFIER);
			retString = idStr.getText();
		}
		catch (RecognitionException ex) {
			reportError(ex);
			consume();
			consumeUntil(_tokenSet_1);
		}
		return retString;
	}
	
	
	public static final String[] _tokenNames = {
		"<0>",
		"EOF",
		"<2>",
		"NULL_TREE_LOOKAHEAD",
		"ASSIGN",
		"IDENTIFIER",
		"VOCAB",
		"WS_",
		"SL_COMMENT",
		"ML_COMMENT"
	};
	
	private static final long[] mk_tokenSet_0() {
		long[] data = { 2L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_0 = new BitSet(mk_tokenSet_0());
	private static final long[] mk_tokenSet_1() {
		long[] data = { 50L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_1 = new BitSet(mk_tokenSet_1());
	
	}
