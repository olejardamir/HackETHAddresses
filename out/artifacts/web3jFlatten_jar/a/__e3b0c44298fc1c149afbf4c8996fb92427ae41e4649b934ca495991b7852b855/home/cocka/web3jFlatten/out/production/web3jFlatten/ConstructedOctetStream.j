.version 52 0 
.class super ConstructedOctetStream 
.super java/io/InputStream 
.field private final _parser LASN1StreamParser; 
.field private _first Z 
.field private _currentStream Ljava/io/InputStream; 

.method <init> : (LASN1StreamParser;)V 
    .code stack 2 locals 2 
L0:     aload_0 
L1:     invokespecial Method java/io/InputStream <init> ()V 
L4:     aload_0 
L5:     iconst_1 
L6:     putfield Field ConstructedOctetStream _first Z 
L9:     aload_0 
L10:    aload_1 
L11:    putfield Field ConstructedOctetStream _parser LASN1StreamParser; 
L14:    return 
L15:    
        .linenumbertable 
            L0 15 
            L4 10 
            L9 16 
            L14 17 
        .end linenumbertable 
        .localvariabletable 
            0 is this LConstructedOctetStream; from L0 to L15 
            1 is parser LASN1StreamParser; from L0 to L15 
        .end localvariabletable 
    .end code 
.end method 

.method public read : ([BII)I 
    .code stack 5 locals 7 
L0:     aload_0 
L1:     getfield Field ConstructedOctetStream _currentStream Ljava/io/InputStream; 
L4:     ifnonnull L51 
L7:     aload_0 
L8:     getfield Field ConstructedOctetStream _first Z 
L11:    ifne L16 
L14:    iconst_m1 
L15:    ireturn 

        .stack same 
L16:    aload_0 
L17:    getfield Field ConstructedOctetStream _parser LASN1StreamParser; 
L20:    invokevirtual Method ASN1StreamParser readObject ()LASN1Encodable; 
L23:    checkcast ASN1OctetStringParser 
L26:    astore 4 
L28:    aload 4 
L30:    ifnonnull L35 
L33:    iconst_m1 
L34:    ireturn 

        .stack append Object ASN1OctetStringParser 
L35:    aload_0 
L36:    iconst_0 
L37:    putfield Field ConstructedOctetStream _first Z 
L40:    aload_0 
L41:    aload 4 
L43:    invokeinterface InterfaceMethod ASN1OctetStringParser getOctetStream ()Ljava/io/InputStream; 1 
L48:    putfield Field ConstructedOctetStream _currentStream Ljava/io/InputStream; 

        .stack chop 1 
L51:    iconst_0 
L52:    istore 4 

        .stack append Integer 
L54:    aload_0 
L55:    getfield Field ConstructedOctetStream _currentStream Ljava/io/InputStream; 
L58:    aload_1 
L59:    iload_2 
L60:    iload 4 
L62:    iadd 
L63:    iload_3 
L64:    iload 4 
L66:    isub 
L67:    invokevirtual Method java/io/InputStream read ([BII)I 
L70:    istore 5 
L72:    iload 5 
L74:    iflt L93 
L77:    iload 4 
L79:    iload 5 
L81:    iadd 
L82:    istore 4 
L84:    iload 4 
L86:    iload_3 
L87:    if_icmpne L139 
L90:    iload 4 
L92:    ireturn 

        .stack append Integer 
L93:    aload_0 
L94:    getfield Field ConstructedOctetStream _parser LASN1StreamParser; 
L97:    invokevirtual Method ASN1StreamParser readObject ()LASN1Encodable; 
L100:   checkcast ASN1OctetStringParser 
L103:   astore 6 
L105:   aload 6 
L107:   ifnonnull L128 
L110:   aload_0 
L111:   aconst_null 
L112:   putfield Field ConstructedOctetStream _currentStream Ljava/io/InputStream; 
L115:   iload 4 
L117:   iconst_1 
L118:   if_icmpge L125 
L121:   iconst_m1 
L122:   goto L127 

        .stack append Object ASN1OctetStringParser 
L125:   iload 4 

        .stack stack_1 Integer 
L127:   ireturn 

        .stack same 
L128:   aload_0 
L129:   aload 6 
L131:   invokeinterface InterfaceMethod ASN1OctetStringParser getOctetStream ()Ljava/io/InputStream; 1 
L136:   putfield Field ConstructedOctetStream _currentStream Ljava/io/InputStream; 

        .stack chop 2 
L139:   goto L54 
L142:   
        .linenumbertable 
            L0 21 
            L7 23 
            L14 25 
            L16 28 
            L28 30 
            L33 32 
            L35 35 
            L40 36 
            L51 39 
            L54 43 
            L72 45 
            L77 47 
            L84 49 
            L90 51 
            L93 56 
            L105 58 
            L110 60 
            L115 61 
            L128 64 
            L139 66 
        .end linenumbertable 
        .localvariabletable 
            4 is s LASN1OctetStringParser; from L28 to L51 
            6 is aos LASN1OctetStringParser; from L105 to L139 
            5 is numRead I from L72 to L139 
            0 is this LConstructedOctetStream; from L0 to L142 
            1 is b [B from L0 to L142 
            2 is off I from L0 to L142 
            3 is len I from L0 to L142 
            4 is totalRead I from L54 to L142 
        .end localvariabletable 
    .end code 
    .exceptions java/io/IOException 
.end method 

.method public read : ()I 
    .code stack 2 locals 3 
L0:     aload_0 
L1:     getfield Field ConstructedOctetStream _currentStream Ljava/io/InputStream; 
L4:     ifnonnull L48 
L7:     aload_0 
L8:     getfield Field ConstructedOctetStream _first Z 
L11:    ifne L16 
L14:    iconst_m1 
L15:    ireturn 

        .stack same 
L16:    aload_0 
L17:    getfield Field ConstructedOctetStream _parser LASN1StreamParser; 
L20:    invokevirtual Method ASN1StreamParser readObject ()LASN1Encodable; 
L23:    checkcast ASN1OctetStringParser 
L26:    astore_1 
L27:    aload_1 
L28:    ifnonnull L33 
L31:    iconst_m1 
L32:    ireturn 

        .stack append Object ASN1OctetStringParser 
L33:    aload_0 
L34:    iconst_0 
L35:    putfield Field ConstructedOctetStream _first Z 
L38:    aload_0 
L39:    aload_1 
L40:    invokeinterface InterfaceMethod ASN1OctetStringParser getOctetStream ()Ljava/io/InputStream; 1 
L45:    putfield Field ConstructedOctetStream _currentStream Ljava/io/InputStream; 

        .stack chop 1 
L48:    aload_0 
L49:    getfield Field ConstructedOctetStream _currentStream Ljava/io/InputStream; 
L52:    invokevirtual Method java/io/InputStream read ()I 
L55:    istore_1 
L56:    iload_1 
L57:    iflt L62 
L60:    iload_1 
L61:    ireturn 

        .stack append Integer 
L62:    aload_0 
L63:    getfield Field ConstructedOctetStream _parser LASN1StreamParser; 
L66:    invokevirtual Method ASN1StreamParser readObject ()LASN1Encodable; 
L69:    checkcast ASN1OctetStringParser 
L72:    astore_2 
L73:    aload_2 
L74:    ifnonnull L84 
L77:    aload_0 
L78:    aconst_null 
L79:    putfield Field ConstructedOctetStream _currentStream Ljava/io/InputStream; 
L82:    iconst_m1 
L83:    ireturn 

        .stack append Object ASN1OctetStringParser 
L84:    aload_0 
L85:    aload_2 
L86:    invokeinterface InterfaceMethod ASN1OctetStringParser getOctetStream ()Ljava/io/InputStream; 1 
L91:    putfield Field ConstructedOctetStream _currentStream Ljava/io/InputStream; 
L94:    goto L48 
L97:    
        .linenumbertable 
            L0 72 
            L7 74 
            L14 76 
            L16 79 
            L27 81 
            L31 83 
            L33 86 
            L38 87 
            L48 92 
            L56 94 
            L60 96 
            L62 99 
            L73 101 
            L77 103 
            L82 104 
            L84 107 
            L94 108 
        .end linenumbertable 
        .localvariabletable 
            1 is s LASN1OctetStringParser; from L27 to L48 
            1 is b I from L56 to L94 
            2 is s LASN1OctetStringParser; from L73 to L94 
            0 is this LConstructedOctetStream; from L0 to L97 
        .end localvariabletable 
    .end code 
    .exceptions java/io/IOException 
.end method 
.sourcefile 'ConstructedOctetStream.java' 
.end class 
