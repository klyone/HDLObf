// $ANTLR 2.7.4: "VHDLLexer.g" -> "VhdlNoSkipLexer.java"$

import java.io.InputStream;
import antlr.TokenStreamException;
import antlr.TokenStreamIOException;
import antlr.TokenStreamRecognitionException;
import antlr.CharStreamException;
import antlr.CharStreamIOException;
import antlr.ANTLRException;
import java.io.Reader;
import java.util.Hashtable;
import antlr.CharScanner;
import antlr.InputBuffer;
import antlr.ByteBuffer;
import antlr.CharBuffer;
import antlr.Token;
import antlr.CommonToken;
import antlr.RecognitionException;
import antlr.NoViableAltForCharException;
import antlr.MismatchedCharException;
import antlr.TokenStream;
import antlr.ANTLRHashString;
import antlr.LexerSharedInputState;
import antlr.collections.impl.BitSet;
import antlr.SemanticException;

import java.io.*;
import java.util.*;

public class VhdlNoSkipLexer extends antlr.CharScanner implements VHDLNoSkipTokenTypes, TokenStream
 {
public VhdlNoSkipLexer(InputStream in) {
	this(new ByteBuffer(in));
}
public VhdlNoSkipLexer(Reader in) {
	this(new CharBuffer(in));
}
public VhdlNoSkipLexer(InputBuffer ib) {
	this(new LexerSharedInputState(ib));
}
public VhdlNoSkipLexer(LexerSharedInputState state) {
	super(state);
	caseSensitiveLiterals = false;
	setCaseSensitive(false);
	literals = new Hashtable();
	literals.put(new ANTLRHashString("architecture", this), new Integer(11));
	literals.put(new ANTLRHashString("type", this), new Integer(103));
	literals.put(new ANTLRHashString("constant", this), new Integer(24));
	literals.put(new ANTLRHashString("literal", this), new Integer(49));
	literals.put(new ANTLRHashString("through", this), new Integer(99));
	literals.put(new ANTLRHashString("case", this), new Integer(21));
	literals.put(new ANTLRHashString("next", this), new Integer(56));
	literals.put(new ANTLRHashString("while", this), new Integer(111));
	literals.put(new ANTLRHashString("break", this), new Integer(18));
	literals.put(new ANTLRHashString("new", this), new Integer(55));
	literals.put(new ANTLRHashString("terminal", this), new Integer(97));
	literals.put(new ANTLRHashString("end", this), new Integer(29));
	literals.put(new ANTLRHashString("unaffected", this), new Integer(104));
	literals.put(new ANTLRHashString("abs", this), new Integer(4));
	literals.put(new ANTLRHashString("limit ", this), new Integer(47));
	literals.put(new ANTLRHashString("variable", this), new Integer(108));
	literals.put(new ANTLRHashString("shared", this), new Integer(88));
	literals.put(new ANTLRHashString("then", this), new Integer(98));
	literals.put(new ANTLRHashString("select", this), new Integer(86));
	literals.put(new ANTLRHashString("until", this), new Integer(106));
	literals.put(new ANTLRHashString("to", this), new Integer(100));
	literals.put(new ANTLRHashString("severity", this), new Integer(87));
	literals.put(new ANTLRHashString("and", this), new Integer(10));
	literals.put(new ANTLRHashString("spectrum", this), new Integer(92));
	literals.put(new ANTLRHashString("pure", this), new Integer(74));
	literals.put(new ANTLRHashString("not", this), new Integer(59));
	literals.put(new ANTLRHashString("package", this), new Integer(67));
	literals.put(new ANTLRHashString("return", this), new Integer(83));
	literals.put(new ANTLRHashString("signal", this), new Integer(89));
	literals.put(new ANTLRHashString("inout", this), new Integer(43));
	literals.put(new ANTLRHashString("ror", this), new Integer(85));
	literals.put(new ANTLRHashString("reference", this), new Integer(78));
	literals.put(new ANTLRHashString("null", this), new Integer(60));
	literals.put(new ANTLRHashString("wait", this), new Integer(109));
	literals.put(new ANTLRHashString("protected", this), new Integer(73));
	literals.put(new ANTLRHashString("mod", this), new Integer(52));
	literals.put(new ANTLRHashString("open", this), new Integer(63));
	literals.put(new ANTLRHashString("sra", this), new Integer(93));
	literals.put(new ANTLRHashString("when", this), new Integer(110));
	literals.put(new ANTLRHashString("guarded", this), new Integer(38));
	literals.put(new ANTLRHashString("generate", this), new Integer(35));
	literals.put(new ANTLRHashString("exit", this), new Integer(31));
	literals.put(new ANTLRHashString("range", this), new Integer(76));
	literals.put(new ANTLRHashString("function", this), new Integer(34));
	literals.put(new ANTLRHashString("sla", this), new Integer(90));
	literals.put(new ANTLRHashString("body", this), new Integer(17));
	literals.put(new ANTLRHashString("impure", this), new Integer(40));
	literals.put(new ANTLRHashString("with", this), new Integer(112));
	literals.put(new ANTLRHashString("out", this), new Integer(66));
	literals.put(new ANTLRHashString("nor", this), new Integer(58));
	literals.put(new ANTLRHashString("entity", this), new Integer(30));
	literals.put(new ANTLRHashString("library", this), new Integer(46));
	literals.put(new ANTLRHashString("procedural", this), new Integer(70));
	literals.put(new ANTLRHashString("srl", this), new Integer(94));
	literals.put(new ANTLRHashString("nature ", this), new Integer(54));
	literals.put(new ANTLRHashString("across", this), new Integer(6));
	literals.put(new ANTLRHashString("map", this), new Integer(51));
	literals.put(new ANTLRHashString("configuration", this), new Integer(23));
	literals.put(new ANTLRHashString("subtype", this), new Integer(96));
	literals.put(new ANTLRHashString("of", this), new Integer(61));
	literals.put(new ANTLRHashString("is", this), new Integer(44));
	literals.put(new ANTLRHashString("array", this), new Integer(12));
	literals.put(new ANTLRHashString("sll", this), new Integer(91));
	literals.put(new ANTLRHashString("file", this), new Integer(32));
	literals.put(new ANTLRHashString("subnature", this), new Integer(95));
	literals.put(new ANTLRHashString("or", this), new Integer(64));
	literals.put(new ANTLRHashString("access", this), new Integer(5));
	literals.put(new ANTLRHashString("if", this), new Integer(39));
	literals.put(new ANTLRHashString("inertial", this), new Integer(42));
	literals.put(new ANTLRHashString("record", this), new Integer(77));
	literals.put(new ANTLRHashString("noise ", this), new Integer(57));
	literals.put(new ANTLRHashString("xor", this), new Integer(114));
	literals.put(new ANTLRHashString("transport", this), new Integer(102));
	literals.put(new ANTLRHashString("assert", this), new Integer(13));
	literals.put(new ANTLRHashString("nand", this), new Integer(53));
	literals.put(new ANTLRHashString("report", this), new Integer(82));
	literals.put(new ANTLRHashString("all", this), new Integer(9));
	literals.put(new ANTLRHashString("quantity", this), new Integer(75));
	literals.put(new ANTLRHashString("register", this), new Integer(79));
	literals.put(new ANTLRHashString("units", this), new Integer(105));
	literals.put(new ANTLRHashString("bus", this), new Integer(20));
	literals.put(new ANTLRHashString("for", this), new Integer(33));
	literals.put(new ANTLRHashString("postponed", this), new Integer(69));
	literals.put(new ANTLRHashString("others", this), new Integer(65));
	literals.put(new ANTLRHashString("label", this), new Integer(45));
	literals.put(new ANTLRHashString("tolerance", this), new Integer(101));
	literals.put(new ANTLRHashString("downto", this), new Integer(26));
	literals.put(new ANTLRHashString("loop", this), new Integer(50));
	literals.put(new ANTLRHashString("linkage", this), new Integer(48));
	literals.put(new ANTLRHashString("alias", this), new Integer(8));
	literals.put(new ANTLRHashString("port", this), new Integer(68));
	literals.put(new ANTLRHashString("disconnect", this), new Integer(25));
	literals.put(new ANTLRHashString("reject", this), new Integer(80));
	literals.put(new ANTLRHashString("generic", this), new Integer(36));
	literals.put(new ANTLRHashString("rol", this), new Integer(84));
	literals.put(new ANTLRHashString("rem", this), new Integer(81));
	literals.put(new ANTLRHashString("buffer", this), new Integer(19));
	literals.put(new ANTLRHashString("attribute", this), new Integer(14));
	literals.put(new ANTLRHashString("component", this), new Integer(22));
	literals.put(new ANTLRHashString("process", this), new Integer(72));
	literals.put(new ANTLRHashString("on", this), new Integer(62));
	literals.put(new ANTLRHashString("after", this), new Integer(7));
	literals.put(new ANTLRHashString("begin", this), new Integer(15));
	literals.put(new ANTLRHashString("else", this), new Integer(27));
	literals.put(new ANTLRHashString("in", this), new Integer(41));
	literals.put(new ANTLRHashString("elsif", this), new Integer(28));
	literals.put(new ANTLRHashString("block", this), new Integer(16));
	literals.put(new ANTLRHashString("procedure", this), new Integer(71));
	literals.put(new ANTLRHashString("use", this), new Integer(107));
	literals.put(new ANTLRHashString("xnor", this), new Integer(113));
	literals.put(new ANTLRHashString("group", this), new Integer(37));
}

public Token nextToken() throws TokenStreamException {
	Token theRetToken=null;
tryAgain:
	for (;;) {
		Token _token = null;
		int _ttype = Token.INVALID_TYPE;
		resetText();
		try {   // for char stream error handling
			try {   // for lexical error handling
				switch ( LA(1)) {
				case '(':
				{
					mL_PAREN(true);
					theRetToken=_returnToken;
					break;
				}
				case '&':
				{
					mAMPERSAND(true);
					theRetToken=_returnToken;
					break;
				}
				case ')':
				{
					mR_PAREN(true);
					theRetToken=_returnToken;
					break;
				}
				case '[':
				{
					mL_BRACKET(true);
					theRetToken=_returnToken;
					break;
				}
				case ']':
				{
					mR_BRACKET(true);
					theRetToken=_returnToken;
					break;
				}
				case ',':
				{
					mCOMMA(true);
					theRetToken=_returnToken;
					break;
				}
				case ';':
				{
					mSEMI_COLON(true);
					theRetToken=_returnToken;
					break;
				}
				case '|':
				{
					mCHOICE1(true);
					theRetToken=_returnToken;
					break;
				}
				case '.':
				{
					mDOT(true);
					theRetToken=_returnToken;
					break;
				}
				case '+':
				{
					mPLUS(true);
					theRetToken=_returnToken;
					break;
				}
				case '_':
				{
					mUNDERSCORE(true);
					theRetToken=_returnToken;
					break;
				}
				case '"':
				{
					mSTRING_LITERAL(true);
					theRetToken=_returnToken;
					break;
				}
				case '\'':
				{
					mCHARACTER_LITERAL_OR_QUOTE(true);
					theRetToken=_returnToken;
					break;
				}
				case '\t':  case '\n':  case '\u000c':  case '\r':
				case ' ':
				{
					mWS(true);
					theRetToken=_returnToken;
					break;
				}
				case '0':  case '1':  case '2':  case '3':
				case '4':  case '5':  case '6':  case '7':
				case '8':  case '9':
				{
					mBASED_INTEGER_LITERAL_OR_DECIMAL_INTEGER_LITERAL(true);
					theRetToken=_returnToken;
					break;
				}
				default:
					if ((LA(1)=='=') && (LA(2)=='=')) {
						mEQUAL_EQUAL(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)==':') && (LA(2)=='=')) {
						mCOLON_EQUAL(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='<') && (LA(2)=='>')) {
						mLESS_GREATER(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='<') && (LA(2)=='=')) {
						mLESS_EQUAL(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='=') && (LA(2)=='>')) {
						mEQUAL_GREATER(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='>') && (LA(2)=='=')) {
						mGREATER_EQUAL(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='/') && (LA(2)=='=')) {
						mNOT_EQUAL(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='*') && (LA(2)=='*')) {
						mEXPONENT(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='b'||LA(1)=='o'||LA(1)=='x') && (LA(2)=='"'||LA(2)=='%')) {
						mBIT_STRING_LITERAL(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='-') && (LA(2)=='-')) {
						mCOMMENT(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)==':') && (true)) {
						mCOLON(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='<') && (true)) {
						mLESS(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='=') && (true)) {
						mEQUAL(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='>') && (true)) {
						mGREATER(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='*') && (true)) {
						mMULTIPLY(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='/') && (true)) {
						mDIVIDE(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='-') && (true)) {
						mMINUS(true);
						theRetToken=_returnToken;
					}
					else if (((LA(1) >= 'a' && LA(1) <= 'z')) && (true)) {
						mSIMPLE_IDENTIFIER(true);
						theRetToken=_returnToken;
					}
				else {
					if (LA(1)==EOF_CHAR) {uponEOF(); _returnToken = makeToken(Token.EOF_TYPE);}
				else {throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());}
				}
				}
				if ( _returnToken==null ) continue tryAgain; // found SKIP token
				_ttype = _returnToken.getType();
				_ttype = testLiteralsTable(_ttype);
				_returnToken.setType(_ttype);
				return _returnToken;
			}
			catch (RecognitionException e) {
				throw new TokenStreamRecognitionException(e);
			}
		}
		catch (CharStreamException cse) {
			if ( cse instanceof CharStreamIOException ) {
				throw new TokenStreamIOException(((CharStreamIOException)cse).io);
			}
			else {
				throw new TokenStreamException(cse.getMessage());
			}
		}
	}
}

	public final void mL_PAREN(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = L_PAREN;
		int _saveIndex;
		
		match('(');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mEQUAL_EQUAL(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = EQUAL_EQUAL;
		int _saveIndex;
		
		match("==");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mAMPERSAND(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = AMPERSAND;
		int _saveIndex;
		
		match('&');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mR_PAREN(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = R_PAREN;
		int _saveIndex;
		
		match(')');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mL_BRACKET(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = L_BRACKET;
		int _saveIndex;
		
		match('[');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mR_BRACKET(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = R_BRACKET;
		int _saveIndex;
		
		match(']');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mCOMMA(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = COMMA;
		int _saveIndex;
		
		match(',');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mCOLON_EQUAL(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = COLON_EQUAL;
		int _saveIndex;
		
		match(":=");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mCOLON(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = COLON;
		int _saveIndex;
		
		match(':');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mSEMI_COLON(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = SEMI_COLON;
		int _saveIndex;
		
		match(';');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mLESS_GREATER(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = LESS_GREATER;
		int _saveIndex;
		
		match("<>");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mLESS_EQUAL(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = LESS_EQUAL;
		int _saveIndex;
		
		match("<=");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mLESS(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = LESS;
		int _saveIndex;
		
		match("<");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mEQUAL_GREATER(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = EQUAL_GREATER;
		int _saveIndex;
		
		match("=>");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mEQUAL(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = EQUAL;
		int _saveIndex;
		
		match('=');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mGREATER_EQUAL(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = GREATER_EQUAL;
		int _saveIndex;
		
		match(">=");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mGREATER(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = GREATER;
		int _saveIndex;
		
		match('>');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mCHOICE1(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = CHOICE1;
		int _saveIndex;
		
		match('|');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mNOT_EQUAL(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = NOT_EQUAL;
		int _saveIndex;
		
		match("/=");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mDOT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = DOT;
		int _saveIndex;
		
		match('.');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mEXPONENT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = EXPONENT;
		int _saveIndex;
		
		match("**");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mMULTIPLY(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = MULTIPLY;
		int _saveIndex;
		
		match('*');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mDIVIDE(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = DIVIDE;
		int _saveIndex;
		
		match('/');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mPLUS(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = PLUS;
		int _saveIndex;
		
		match('+');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mMINUS(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = MINUS;
		int _saveIndex;
		
		match('-');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mUNDERSCORE(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = UNDERSCORE;
		int _saveIndex;
		
		match('_');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mBIT_STRING_LITERAL(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = BIT_STRING_LITERAL;
		int _saveIndex;
		
		if ((LA(1)=='b') && (LA(2)=='"')) {
			match('b');
			match('"');
			{
			_loop29:
			do {
				switch ( LA(1)) {
				case '0':
				{
					match('0');
					break;
				}
				case '1':
				{
					match('1');
					break;
				}
				case '_':
				{
					match('_');
					break;
				}
				default:
				{
					break _loop29;
				}
				}
			} while (true);
			}
			match('"');
		}
		else if ((LA(1)=='b') && (LA(2)=='%')) {
			match('b');
			match('%');
			{
			_loop31:
			do {
				switch ( LA(1)) {
				case '0':
				{
					match('0');
					break;
				}
				case '1':
				{
					match('1');
					break;
				}
				case '_':
				{
					match('_');
					break;
				}
				default:
				{
					break _loop31;
				}
				}
			} while (true);
			}
			match('%');
		}
		else if ((LA(1)=='o') && (LA(2)=='"')) {
			match('o');
			match('"');
			{
			_loop33:
			do {
				switch ( LA(1)) {
				case '0':  case '1':  case '2':  case '3':
				case '4':  case '5':  case '6':  case '7':
				{
					matchRange('0','7');
					break;
				}
				case '_':
				{
					match('_');
					break;
				}
				default:
				{
					break _loop33;
				}
				}
			} while (true);
			}
			match('"');
		}
		else if ((LA(1)=='o') && (LA(2)=='%')) {
			match('o');
			match('%');
			{
			_loop35:
			do {
				switch ( LA(1)) {
				case '0':  case '1':  case '2':  case '3':
				case '4':  case '5':  case '6':  case '7':
				{
					matchRange('0','7');
					break;
				}
				case '_':
				{
					match('_');
					break;
				}
				default:
				{
					break _loop35;
				}
				}
			} while (true);
			}
			match('%');
		}
		else if ((LA(1)=='x') && (LA(2)=='"')) {
			match('x');
			match('"');
			{
			_loop37:
			do {
				switch ( LA(1)) {
				case '0':  case '1':  case '2':  case '3':
				case '4':  case '5':  case '6':  case '7':
				case '8':  case '9':
				{
					matchRange('0','9');
					break;
				}
				case 'a':  case 'b':  case 'c':  case 'd':
				case 'e':  case 'f':
				{
					matchRange('a','f');
					break;
				}
				case '_':
				{
					match('_');
					break;
				}
				default:
				{
					break _loop37;
				}
				}
			} while (true);
			}
			match('"');
		}
		else if ((LA(1)=='x') && (LA(2)=='%')) {
			match('x');
			match('%');
			{
			_loop39:
			do {
				switch ( LA(1)) {
				case '0':  case '1':  case '2':  case '3':
				case '4':  case '5':  case '6':  case '7':
				case '8':  case '9':
				{
					matchRange('0','9');
					break;
				}
				case 'a':  case 'b':  case 'c':  case 'd':
				case 'e':  case 'f':
				{
					matchRange('a','f');
					break;
				}
				case '_':
				{
					match('_');
					break;
				}
				default:
				{
					break _loop39;
				}
				}
			} while (true);
			}
			match('%');
		}
		else {
			throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
		}
		
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mSTRING_LITERAL(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = STRING_LITERAL;
		int _saveIndex;
		
		match('"');
		{
		_loop44:
		do {
			if ((_tokenSet_0.member(LA(1)))) {
				{
				{
				match(_tokenSet_0);
				}
				}
			}
			else {
				break _loop44;
			}
			
		} while (true);
		}
		match('"');
		if ( inputState.guessing==0 ) {
			_ttype = STRING_LITERAL;
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mQUOTE(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = QUOTE;
		int _saveIndex;
		
		match('\'');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mCHARACTER_LITERAL(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = CHARACTER_LITERAL;
		int _saveIndex;
		
		match('\'');
		{
		{
		match(_tokenSet_1);
		}
		}
		match('\'');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mCHARACTER_LITERAL_OR_QUOTE(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = CHARACTER_LITERAL_OR_QUOTE;
		int _saveIndex;
		
		boolean synPredMatched53 = false;
		if (((LA(1)=='\'') && (_tokenSet_1.member(LA(2))))) {
			int _m53 = mark();
			synPredMatched53 = true;
			inputState.guessing++;
			try {
				{
				match('\'');
				{
				{
				match(_tokenSet_1);
				}
				}
				match('\'');
				}
			}
			catch (RecognitionException pe) {
				synPredMatched53 = false;
			}
			rewind(_m53);
			inputState.guessing--;
		}
		if ( synPredMatched53 ) {
			mCHARACTER_LITERAL(false);
			if ( inputState.guessing==0 ) {
				_ttype = CHARACTER_LITERAL ;
			}
		}
		else {
			boolean synPredMatched55 = false;
			if (((LA(1)=='\'') && (true))) {
				int _m55 = mark();
				synPredMatched55 = true;
				inputState.guessing++;
				try {
					{
					match('\'');
					}
				}
				catch (RecognitionException pe) {
					synPredMatched55 = false;
				}
				rewind(_m55);
				inputState.guessing--;
			}
			if ( synPredMatched55 ) {
				mQUOTE(false);
				if ( inputState.guessing==0 ) {
					_ttype = QUOTE ;
				}
			}
			else {
				throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
			}
			}
			if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
				_token = makeToken(_ttype);
				_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
			}
			_returnToken = _token;
		}
		
	public final void mWS(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = WS;
		int _saveIndex;
		
		{
		switch ( LA(1)) {
		case ' ':
		{
			match(' ');
			break;
		}
		case '\t':
		{
			match('\t');
			break;
		}
		case '\u000c':
		{
			match('\f');
			break;
		}
		case '\n':  case '\r':
		{
			{
			switch ( LA(1)) {
			case '\r':
			{
				match("\r\n");
				break;
			}
			case '\n':
			{
				match('\n');
				break;
			}
			default:
			{
				throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
			}
			}
			}
			if ( inputState.guessing==0 ) {
				newline();
			}
			break;
		}
		default:
		{
			throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
		}
		}
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mDIGIT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = DIGIT;
		int _saveIndex;
		
		matchRange('0','9');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mLETTER(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = LETTER;
		int _saveIndex;
		
		matchRange('a','z');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mSIMPLE_IDENTIFIER(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = SIMPLE_IDENTIFIER;
		int _saveIndex;
		
		mLETTER(false);
		{
		_loop63:
		do {
			switch ( LA(1)) {
			case 'a':  case 'b':  case 'c':  case 'd':
			case 'e':  case 'f':  case 'g':  case 'h':
			case 'i':  case 'j':  case 'k':  case 'l':
			case 'm':  case 'n':  case 'o':  case 'p':
			case 'q':  case 'r':  case 's':  case 't':
			case 'u':  case 'v':  case 'w':  case 'x':
			case 'y':  case 'z':
			{
				mLETTER(false);
				break;
			}
			case '0':  case '1':  case '2':  case '3':
			case '4':  case '5':  case '6':  case '7':
			case '8':  case '9':
			{
				mDIGIT(false);
				break;
			}
			case '_':
			{
				match('_');
				break;
			}
			default:
			{
				break _loop63;
			}
			}
		} while (true);
		}
		if ( inputState.guessing==0 ) {
			setText(getText().toLowerCase());
		}
		_ttype = testLiteralsTable(_ttype);
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mBASED_INTEGER_LITERAL_OR_DECIMAL_INTEGER_LITERAL(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = BASED_INTEGER_LITERAL_OR_DECIMAL_INTEGER_LITERAL;
		int _saveIndex;
		
		boolean synPredMatched66 = false;
		if ((((LA(1) >= '0' && LA(1) <= '9')) && (_tokenSet_2.member(LA(2))) && (_tokenSet_3.member(LA(3))) && (_tokenSet_4.member(LA(4))) && (true) && (true) && (true) && (true) && (true))) {
			int _m66 = mark();
			synPredMatched66 = true;
			inputState.guessing++;
			try {
				{
				mINTEGER(false);
				match('#');
				}
			}
			catch (RecognitionException pe) {
				synPredMatched66 = false;
			}
			rewind(_m66);
			inputState.guessing--;
		}
		if ( synPredMatched66 ) {
			mBASED_INTEGER_LITERAL(false);
			if ( inputState.guessing==0 ) {
				_ttype = BASED_INTEGER_LITERAL ;
			}
		}
		else {
			boolean synPredMatched68 = false;
			if ((((LA(1) >= '0' && LA(1) <= '9')) && (true) && (true) && (true) && (true) && (true) && (true) && (true) && (true))) {
				int _m68 = mark();
				synPredMatched68 = true;
				inputState.guessing++;
				try {
					{
					mINTEGER(false);
					}
				}
				catch (RecognitionException pe) {
					synPredMatched68 = false;
				}
				rewind(_m68);
				inputState.guessing--;
			}
			if ( synPredMatched68 ) {
				mDECIMAL_INTEGER_LITERAL(false);
				if ( inputState.guessing==0 ) {
					_ttype = DECIMAL_INTEGER_LITERAL ;
				}
			}
			else {
				throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
			}
			}
			if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
				_token = makeToken(_ttype);
				_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
			}
			_returnToken = _token;
		}
		
	protected final void mINTEGER(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = INTEGER;
		int _saveIndex;
		
		mDIGIT(false);
		{
		_loop78:
		do {
			if ((_tokenSet_5.member(LA(1)))) {
				{
				switch ( LA(1)) {
				case '_':
				{
					mUNDERSCORE(false);
					break;
				}
				case '0':  case '1':  case '2':  case '3':
				case '4':  case '5':  case '6':  case '7':
				case '8':  case '9':
				{
					break;
				}
				default:
				{
					throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
				}
				}
				}
				mDIGIT(false);
			}
			else {
				break _loop78;
			}
			
		} while (true);
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mBASED_INTEGER_LITERAL(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = BASED_INTEGER_LITERAL;
		int _saveIndex;
		
		mINTEGER(false);
		match('#');
		mBASED_INTEGER(false);
		{
		switch ( LA(1)) {
		case '.':
		{
			mDOT(false);
			mBASED_INTEGER(false);
			break;
		}
		case '#':
		{
			break;
		}
		default:
		{
			throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
		}
		}
		}
		match('#');
		{
		if ((LA(1)=='e')) {
			mEXP(false);
		}
		else {
		}
		
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mDECIMAL_INTEGER_LITERAL(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = DECIMAL_INTEGER_LITERAL;
		int _saveIndex;
		
		mINTEGER(false);
		{
		if ((LA(1)=='.')) {
			mDOT(false);
			mINTEGER(false);
		}
		else {
		}
		
		}
		{
		if ((LA(1)=='e')) {
			mEXP(false);
		}
		else {
		}
		
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mEXP(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = EXP;
		int _saveIndex;
		
		{
		match('e');
		}
		{
		switch ( LA(1)) {
		case '+':
		{
			mPLUS(false);
			break;
		}
		case '-':
		{
			mMINUS(false);
			break;
		}
		case '0':  case '1':  case '2':  case '3':
		case '4':  case '5':  case '6':  case '7':
		case '8':  case '9':
		{
			break;
		}
		default:
		{
			throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
		}
		}
		}
		mINTEGER(false);
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mBASED_INTEGER(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = BASED_INTEGER;
		int _saveIndex;
		
		{
		switch ( LA(1)) {
		case '0':  case '1':  case '2':  case '3':
		case '4':  case '5':  case '6':  case '7':
		case '8':  case '9':
		{
			mDIGIT(false);
			break;
		}
		case 'a':  case 'b':  case 'c':  case 'd':
		case 'e':  case 'f':  case 'g':  case 'h':
		case 'i':  case 'j':  case 'k':  case 'l':
		case 'm':  case 'n':  case 'o':  case 'p':
		case 'q':  case 'r':  case 's':  case 't':
		case 'u':  case 'v':  case 'w':  case 'x':
		case 'y':  case 'z':
		{
			mLETTER(false);
			break;
		}
		default:
		{
			throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
		}
		}
		}
		{
		_loop84:
		do {
			if ((_tokenSet_6.member(LA(1)))) {
				{
				switch ( LA(1)) {
				case '_':
				{
					mUNDERSCORE(false);
					break;
				}
				case '0':  case '1':  case '2':  case '3':
				case '4':  case '5':  case '6':  case '7':
				case '8':  case '9':  case 'a':  case 'b':
				case 'c':  case 'd':  case 'e':  case 'f':
				case 'g':  case 'h':  case 'i':  case 'j':
				case 'k':  case 'l':  case 'm':  case 'n':
				case 'o':  case 'p':  case 'q':  case 'r':
				case 's':  case 't':  case 'u':  case 'v':
				case 'w':  case 'x':  case 'y':  case 'z':
				{
					break;
				}
				default:
				{
					throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
				}
				}
				}
				{
				switch ( LA(1)) {
				case '0':  case '1':  case '2':  case '3':
				case '4':  case '5':  case '6':  case '7':
				case '8':  case '9':
				{
					mDIGIT(false);
					break;
				}
				case 'a':  case 'b':  case 'c':  case 'd':
				case 'e':  case 'f':  case 'g':  case 'h':
				case 'i':  case 'j':  case 'k':  case 'l':
				case 'm':  case 'n':  case 'o':  case 'p':
				case 'q':  case 'r':  case 's':  case 't':
				case 'u':  case 'v':  case 'w':  case 'x':
				case 'y':  case 'z':
				{
					mLETTER(false);
					break;
				}
				default:
				{
					throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
				}
				}
				}
			}
			else {
				break _loop84;
			}
			
		} while (true);
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mCOMMENT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = COMMENT;
		int _saveIndex;
		
		match("--");
		{
		_loop91:
		do {
			if ((_tokenSet_1.member(LA(1)))) {
				{
				match(_tokenSet_1);
				}
			}
			else {
				break _loop91;
			}
			
		} while (true);
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	
	private static final long[] mk_tokenSet_0() {
		long[] data = new long[8];
		data[0]=-17179878401L;
		for (int i = 1; i<=3; i++) { data[i]=-1L; }
		return data;
	}
	public static final BitSet _tokenSet_0 = new BitSet(mk_tokenSet_0());
	private static final long[] mk_tokenSet_1() {
		long[] data = new long[8];
		data[0]=-9217L;
		for (int i = 1; i<=3; i++) { data[i]=-1L; }
		return data;
	}
	public static final BitSet _tokenSet_1 = new BitSet(mk_tokenSet_1());
	private static final long[] mk_tokenSet_2() {
		long[] data = { 287948935534739456L, 2147483648L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_2 = new BitSet(mk_tokenSet_2());
	private static final long[] mk_tokenSet_3() {
		long[] data = { 287948935534739456L, 576460745860972544L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_3 = new BitSet(mk_tokenSet_3());
	private static final long[] mk_tokenSet_4() {
		long[] data = { 288019304278917120L, 576460745860972544L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_4 = new BitSet(mk_tokenSet_4());
	private static final long[] mk_tokenSet_5() {
		long[] data = { 287948901175001088L, 2147483648L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_5 = new BitSet(mk_tokenSet_5());
	private static final long[] mk_tokenSet_6() {
		long[] data = { 287948901175001088L, 576460745860972544L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_6 = new BitSet(mk_tokenSet_6());
	
	}
