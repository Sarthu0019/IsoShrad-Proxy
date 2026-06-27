// Generated from IsoShardSql.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class IsoShardSqlLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, SELECT=5, FROM=6, WHERE=7, INSERT=8, INTO=9, 
		VALUES=10, UPDATE=11, SET=12, EQ=13, NEQ=14, GT=15, LT=16, GTE=17, LTE=18, 
		IDENTIFIER=19, STRING_LITERAL=20, NUMERIC_LITERAL=21, WS=22;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "SELECT", "FROM", "WHERE", "INSERT", 
			"INTO", "VALUES", "UPDATE", "SET", "EQ", "NEQ", "GT", "LT", "GTE", "LTE", 
			"IDENTIFIER", "STRING_LITERAL", "NUMERIC_LITERAL", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "','", "'*'", null, null, null, null, null, null, 
			null, null, "'='", null, "'>'", "'<'", "'>='", "'<='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, "SELECT", "FROM", "WHERE", "INSERT", "INTO", 
			"VALUES", "UPDATE", "SET", "EQ", "NEQ", "GT", "LT", "GTE", "LTE", "IDENTIFIER", 
			"STRING_LITERAL", "NUMERIC_LITERAL", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public IsoShardSqlLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "IsoShardSql.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\u0016\u009b\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0002\u0015\u0007\u0015\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0003\rl\b\r\u0001\u000e\u0001\u000e\u0001\u000f\u0001"+
		"\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0012\u0001\u0012\u0005\u0012z\b\u0012\n\u0012\f\u0012}\t"+
		"\u0012\u0001\u0013\u0001\u0013\u0005\u0013\u0081\b\u0013\n\u0013\f\u0013"+
		"\u0084\t\u0013\u0001\u0013\u0001\u0013\u0001\u0014\u0004\u0014\u0089\b"+
		"\u0014\u000b\u0014\f\u0014\u008a\u0001\u0014\u0001\u0014\u0004\u0014\u008f"+
		"\b\u0014\u000b\u0014\f\u0014\u0090\u0003\u0014\u0093\b\u0014\u0001\u0015"+
		"\u0004\u0015\u0096\b\u0015\u000b\u0015\f\u0015\u0097\u0001\u0015\u0001"+
		"\u0015\u0000\u0000\u0016\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004"+
		"\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017"+
		"\f\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010!\u0011#\u0012%\u0013\'"+
		"\u0014)\u0015+\u0016\u0001\u0000\u0017\u0002\u0000SSss\u0002\u0000EEe"+
		"e\u0002\u0000LLll\u0002\u0000CCcc\u0002\u0000TTtt\u0002\u0000FFff\u0002"+
		"\u0000RRrr\u0002\u0000OOoo\u0002\u0000MMmm\u0002\u0000WWww\u0002\u0000"+
		"HHhh\u0002\u0000IIii\u0002\u0000NNnn\u0002\u0000VVvv\u0002\u0000AAaa\u0002"+
		"\u0000UUuu\u0002\u0000PPpp\u0002\u0000DDdd\u0002\u0000AZaz\u0004\u0000"+
		"09AZ__az\u0003\u0000\n\n\r\r\'\'\u0001\u000009\u0003\u0000\t\n\r\r  \u00a1"+
		"\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000"+
		"\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000"+
		"\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000"+
		"\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011"+
		"\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015"+
		"\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019"+
		"\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d"+
		"\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000\u0000\u0000\u0000!\u0001"+
		"\u0000\u0000\u0000\u0000#\u0001\u0000\u0000\u0000\u0000%\u0001\u0000\u0000"+
		"\u0000\u0000\'\u0001\u0000\u0000\u0000\u0000)\u0001\u0000\u0000\u0000"+
		"\u0000+\u0001\u0000\u0000\u0000\u0001-\u0001\u0000\u0000\u0000\u0003/"+
		"\u0001\u0000\u0000\u0000\u00051\u0001\u0000\u0000\u0000\u00073\u0001\u0000"+
		"\u0000\u0000\t5\u0001\u0000\u0000\u0000\u000b<\u0001\u0000\u0000\u0000"+
		"\rA\u0001\u0000\u0000\u0000\u000fG\u0001\u0000\u0000\u0000\u0011N\u0001"+
		"\u0000\u0000\u0000\u0013S\u0001\u0000\u0000\u0000\u0015Z\u0001\u0000\u0000"+
		"\u0000\u0017a\u0001\u0000\u0000\u0000\u0019e\u0001\u0000\u0000\u0000\u001b"+
		"k\u0001\u0000\u0000\u0000\u001dm\u0001\u0000\u0000\u0000\u001fo\u0001"+
		"\u0000\u0000\u0000!q\u0001\u0000\u0000\u0000#t\u0001\u0000\u0000\u0000"+
		"%w\u0001\u0000\u0000\u0000\'~\u0001\u0000\u0000\u0000)\u0088\u0001\u0000"+
		"\u0000\u0000+\u0095\u0001\u0000\u0000\u0000-.\u0005(\u0000\u0000.\u0002"+
		"\u0001\u0000\u0000\u0000/0\u0005)\u0000\u00000\u0004\u0001\u0000\u0000"+
		"\u000012\u0005,\u0000\u00002\u0006\u0001\u0000\u0000\u000034\u0005*\u0000"+
		"\u00004\b\u0001\u0000\u0000\u000056\u0007\u0000\u0000\u000067\u0007\u0001"+
		"\u0000\u000078\u0007\u0002\u0000\u000089\u0007\u0001\u0000\u00009:\u0007"+
		"\u0003\u0000\u0000:;\u0007\u0004\u0000\u0000;\n\u0001\u0000\u0000\u0000"+
		"<=\u0007\u0005\u0000\u0000=>\u0007\u0006\u0000\u0000>?\u0007\u0007\u0000"+
		"\u0000?@\u0007\b\u0000\u0000@\f\u0001\u0000\u0000\u0000AB\u0007\t\u0000"+
		"\u0000BC\u0007\n\u0000\u0000CD\u0007\u0001\u0000\u0000DE\u0007\u0006\u0000"+
		"\u0000EF\u0007\u0001\u0000\u0000F\u000e\u0001\u0000\u0000\u0000GH\u0007"+
		"\u000b\u0000\u0000HI\u0007\f\u0000\u0000IJ\u0007\u0000\u0000\u0000JK\u0007"+
		"\u0001\u0000\u0000KL\u0007\u0006\u0000\u0000LM\u0007\u0004\u0000\u0000"+
		"M\u0010\u0001\u0000\u0000\u0000NO\u0007\u000b\u0000\u0000OP\u0007\f\u0000"+
		"\u0000PQ\u0007\u0004\u0000\u0000QR\u0007\u0007\u0000\u0000R\u0012\u0001"+
		"\u0000\u0000\u0000ST\u0007\r\u0000\u0000TU\u0007\u000e\u0000\u0000UV\u0007"+
		"\u0002\u0000\u0000VW\u0007\u000f\u0000\u0000WX\u0007\u0001\u0000\u0000"+
		"XY\u0007\u0000\u0000\u0000Y\u0014\u0001\u0000\u0000\u0000Z[\u0007\u000f"+
		"\u0000\u0000[\\\u0007\u0010\u0000\u0000\\]\u0007\u0011\u0000\u0000]^\u0007"+
		"\u000e\u0000\u0000^_\u0007\u0004\u0000\u0000_`\u0007\u0001\u0000\u0000"+
		"`\u0016\u0001\u0000\u0000\u0000ab\u0007\u0000\u0000\u0000bc\u0007\u0001"+
		"\u0000\u0000cd\u0007\u0004\u0000\u0000d\u0018\u0001\u0000\u0000\u0000"+
		"ef\u0005=\u0000\u0000f\u001a\u0001\u0000\u0000\u0000gh\u0005<\u0000\u0000"+
		"hl\u0005>\u0000\u0000ij\u0005!\u0000\u0000jl\u0005=\u0000\u0000kg\u0001"+
		"\u0000\u0000\u0000ki\u0001\u0000\u0000\u0000l\u001c\u0001\u0000\u0000"+
		"\u0000mn\u0005>\u0000\u0000n\u001e\u0001\u0000\u0000\u0000op\u0005<\u0000"+
		"\u0000p \u0001\u0000\u0000\u0000qr\u0005>\u0000\u0000rs\u0005=\u0000\u0000"+
		"s\"\u0001\u0000\u0000\u0000tu\u0005<\u0000\u0000uv\u0005=\u0000\u0000"+
		"v$\u0001\u0000\u0000\u0000w{\u0007\u0012\u0000\u0000xz\u0007\u0013\u0000"+
		"\u0000yx\u0001\u0000\u0000\u0000z}\u0001\u0000\u0000\u0000{y\u0001\u0000"+
		"\u0000\u0000{|\u0001\u0000\u0000\u0000|&\u0001\u0000\u0000\u0000}{\u0001"+
		"\u0000\u0000\u0000~\u0082\u0005\'\u0000\u0000\u007f\u0081\b\u0014\u0000"+
		"\u0000\u0080\u007f\u0001\u0000\u0000\u0000\u0081\u0084\u0001\u0000\u0000"+
		"\u0000\u0082\u0080\u0001\u0000\u0000\u0000\u0082\u0083\u0001\u0000\u0000"+
		"\u0000\u0083\u0085\u0001\u0000\u0000\u0000\u0084\u0082\u0001\u0000\u0000"+
		"\u0000\u0085\u0086\u0005\'\u0000\u0000\u0086(\u0001\u0000\u0000\u0000"+
		"\u0087\u0089\u0007\u0015\u0000\u0000\u0088\u0087\u0001\u0000\u0000\u0000"+
		"\u0089\u008a\u0001\u0000\u0000\u0000\u008a\u0088\u0001\u0000\u0000\u0000"+
		"\u008a\u008b\u0001\u0000\u0000\u0000\u008b\u0092\u0001\u0000\u0000\u0000"+
		"\u008c\u008e\u0005.\u0000\u0000\u008d\u008f\u0007\u0015\u0000\u0000\u008e"+
		"\u008d\u0001\u0000\u0000\u0000\u008f\u0090\u0001\u0000\u0000\u0000\u0090"+
		"\u008e\u0001\u0000\u0000\u0000\u0090\u0091\u0001\u0000\u0000\u0000\u0091"+
		"\u0093\u0001\u0000\u0000\u0000\u0092\u008c\u0001\u0000\u0000\u0000\u0092"+
		"\u0093\u0001\u0000\u0000\u0000\u0093*\u0001\u0000\u0000\u0000\u0094\u0096"+
		"\u0007\u0016\u0000\u0000\u0095\u0094\u0001\u0000\u0000\u0000\u0096\u0097"+
		"\u0001\u0000\u0000\u0000\u0097\u0095\u0001\u0000\u0000\u0000\u0097\u0098"+
		"\u0001\u0000\u0000\u0000\u0098\u0099\u0001\u0000\u0000\u0000\u0099\u009a"+
		"\u0006\u0015\u0000\u0000\u009a,\u0001\u0000\u0000\u0000\b\u0000k{\u0082"+
		"\u008a\u0090\u0092\u0097\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}