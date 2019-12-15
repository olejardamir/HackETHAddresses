.version 52 0 
.class public super HexEncoder 
.super java/lang/Object 
.implements Encoder 
.field private final encodingTable [B 
.field private final decodingTable [B 

.method private initialiseDecodingTable : ()V 
    .code stack 4 locals 2 
L0:     iconst_0 
L1:     istore_1 

        .stack append Integer 
L2:     iload_1 
L3:     aload_0 
L4:     getfield Field HexEncoder decodingTable [B 
L7:     arraylength 
L8:     if_icmpge L24 
L11:    aload_0 
L12:    getfield Field HexEncoder decodingTable [B 
L15:    iload_1 
L16:    iconst_m1 
L17:    bastore 
L18:    iinc 1 1 
L21:    goto L2 

        .stack chop 1 
L24:    iconst_0 
L25:    istore_1 

        .stack append Integer 
L26:    iload_1 
L27:    aload_0 
L28:    getfield Field HexEncoder encodingTable [B 
L31:    arraylength 
L32:    if_icmpge L54 
L35:    aload_0 
L36:    getfield Field HexEncoder decodingTable [B 
L39:    aload_0 
L40:    getfield Field HexEncoder encodingTable [B 
L43:    iload_1 
L44:    baload 
L45:    iload_1 
L46:    i2b 
L47:    bastore 
L48:    iinc 1 1 
L51:    goto L26 

        .stack chop 1 
L54:    aload_0 
L55:    getfield Field HexEncoder decodingTable [B 
L58:    bipush 65 
L60:    aload_0 
L61:    getfield Field HexEncoder decodingTable [B 
L64:    bipush 97 
L66:    baload 
L67:    bastore 
L68:    aload_0 
L69:    getfield Field HexEncoder decodingTable [B 
L72:    bipush 66 
L74:    aload_0 
L75:    getfield Field HexEncoder decodingTable [B 
L78:    bipush 98 
L80:    baload 
L81:    bastore 
L82:    aload_0 
L83:    getfield Field HexEncoder decodingTable [B 
L86:    bipush 67 
L88:    aload_0 
L89:    getfield Field HexEncoder decodingTable [B 
L92:    bipush 99 
L94:    baload 
L95:    bastore 
L96:    aload_0 
L97:    getfield Field HexEncoder decodingTable [B 
L100:   bipush 68 
L102:   aload_0 
L103:   getfield Field HexEncoder decodingTable [B 
L106:   bipush 100 
L108:   baload 
L109:   bastore 
L110:   aload_0 
L111:   getfield Field HexEncoder decodingTable [B 
L114:   bipush 69 
L116:   aload_0 
L117:   getfield Field HexEncoder decodingTable [B 
L120:   bipush 101 
L122:   baload 
L123:   bastore 
L124:   aload_0 
L125:   getfield Field HexEncoder decodingTable [B 
L128:   bipush 70 
L130:   aload_0 
L131:   getfield Field HexEncoder decodingTable [B 
L134:   bipush 102 
L136:   baload 
L137:   bastore 
L138:   return 
L139:   
        .linenumbertable 
            L0 20 
            L11 22 
            L18 20 
            L24 25 
            L35 27 
            L48 25 
            L54 30 
            L68 31 
            L82 32 
            L96 33 
            L110 34 
            L124 35 
            L138 36 
        .end linenumbertable 
        .localvariabletable 
            1 is i I from L2 to L24 
            1 is i I from L26 to L54 
            0 is this LHexEncoder; from L0 to L139 
        .end localvariabletable 
    .end code 
.end method 

.method public <init> : ()V 
    .code stack 5 locals 1 
L0:     aload_0 
L1:     invokespecial Method java/lang/Object <init> ()V 
L4:     aload_0 
L5:     bipush 16 
L7:     newarray byte 
L9:     dup 
L10:    iconst_0 
L11:    bipush 48 
L13:    bastore 
L14:    dup 
L15:    iconst_1 
L16:    bipush 49 
L18:    bastore 
L19:    dup 
L20:    iconst_2 
L21:    bipush 50 
L23:    bastore 
L24:    dup 
L25:    iconst_3 
L26:    bipush 51 
L28:    bastore 
L29:    dup 
L30:    iconst_4 
L31:    bipush 52 
L33:    bastore 
L34:    dup 
L35:    iconst_5 
L36:    bipush 53 
L38:    bastore 
L39:    dup 
L40:    bipush 6 
L42:    bipush 54 
L44:    bastore 
L45:    dup 
L46:    bipush 7 
L48:    bipush 55 
L50:    bastore 
L51:    dup 
L52:    bipush 8 
L54:    bipush 56 
L56:    bastore 
L57:    dup 
L58:    bipush 9 
L60:    bipush 57 
L62:    bastore 
L63:    dup 
L64:    bipush 10 
L66:    bipush 97 
L68:    bastore 
L69:    dup 
L70:    bipush 11 
L72:    bipush 98 
L74:    bastore 
L75:    dup 
L76:    bipush 12 
L78:    bipush 99 
L80:    bastore 
L81:    dup 
L82:    bipush 13 
L84:    bipush 100 
L86:    bastore 
L87:    dup 
L88:    bipush 14 
L90:    bipush 101 
L92:    bastore 
L93:    dup 
L94:    bipush 15 
L96:    bipush 102 
L98:    bastore 
L99:    putfield Field HexEncoder encodingTable [B 
L102:   aload_0 
L103:   sipush 128 
L106:   newarray byte 
L108:   putfield Field HexEncoder decodingTable [B 
L111:   aload_0 
L112:   invokespecial Method HexEncoder initialiseDecodingTable ()V 
L115:   return 
L116:   
        .linenumbertable 
            L0 39 
            L4 9 
            L102 16 
            L111 40 
            L115 41 
        .end linenumbertable 
        .localvariabletable 
            0 is this LHexEncoder; from L0 to L116 
        .end localvariabletable 
    .end code 
.end method 

.method public encode : ([BIILjava/io/OutputStream;)V 
    .code stack 4 locals 7 
L0:     iload_2 
L1:     istore 5 

        .stack append Integer 
L3:     iload 5 
L5:     iload_2 
L6:     iload_3 
L7:     iadd 
L8:     if_icmpge L56 
L11:    aload_1 
L12:    iload 5 
L14:    baload 
L15:    sipush 255 
L18:    iand 
L19:    istore 6 
L21:    aload 4 
L23:    aload_0 
L24:    getfield Field HexEncoder encodingTable [B 
L27:    iload 6 
L29:    iconst_4 
L30:    iushr 
L31:    baload 
L32:    invokevirtual Method java/io/OutputStream write (I)V 
L35:    aload 4 
L37:    aload_0 
L38:    getfield Field HexEncoder encodingTable [B 
L41:    iload 6 
L43:    bipush 15 
L45:    iand 
L46:    baload 
L47:    invokevirtual Method java/io/OutputStream write (I)V 
L50:    iinc 5 1 
L53:    goto L3 

        .stack chop 1 
L56:    return 
L57:    
        .linenumbertable 
            L0 51 
            L11 53 
            L21 55 
            L35 56 
            L50 51 
            L56 59 
        .end linenumbertable 
        .localvariabletable 
            6 is v I from L21 to L50 
            5 is i I from L3 to L56 
            0 is this LHexEncoder; from L0 to L57 
            1 is data [B from L0 to L57 
            2 is off I from L0 to L57 
            3 is length I from L0 to L57 
            4 is out Ljava/io/OutputStream; from L0 to L57 
        .end localvariabletable 
    .end code 
    .exceptions java/lang/Exception 
.end method 

.method private static ignore : (C)Z 
    .code stack 2 locals 1 
L0:     iload_0 
L1:     bipush 10 
L3:     if_icmpeq L24 
L6:     iload_0 
L7:     bipush 13 
L9:     if_icmpeq L24 
L12:    iload_0 
L13:    bipush 9 
L15:    if_icmpeq L24 
L18:    iload_0 
L19:    bipush 32 
L21:    if_icmpne L28 

        .stack same 
L24:    iconst_1 
L25:    goto L29 

        .stack same 
L28:    iconst_0 

        .stack stack_1 Integer 
L29:    ireturn 
L30:    
        .linenumbertable 
            L0 64 
        .end linenumbertable 
        .localvariabletable 
            0 is c C from L0 to L30 
        .end localvariabletable 
    .end code 
.end method 

.method public decode : (Ljava/lang/String;Ljava/io/OutputStream;)V 
    .code stack 3 locals 8 
L0:     iconst_0 
L1:     istore 5 
L3:     aload_1 
L4:     invokevirtual Method java/lang/String length ()I 
L7:     istore 6 

        .stack full 
            locals Object HexEncoder Object java/lang/String Object java/io/OutputStream Top Top Integer Integer 
            stack 
        .end stack 
L9:     iload 6 
L11:    ifle L37 
L14:    aload_1 
L15:    iload 6 
L17:    iconst_1 
L18:    isub 
L19:    invokevirtual Method java/lang/String charAt (I)C 
L22:    invokestatic Method HexEncoder ignore (C)Z 
L25:    ifne L31 
L28:    goto L37 

        .stack same 
L31:    iinc 6 -1 
L34:    goto L9 

        .stack same 
L37:    iconst_0 
L38:    istore 7 

        .stack append Integer 
L40:    iload 7 
L42:    iload 6 
L44:    if_icmpge L161 

        .stack same 
L47:    iload 7 
L49:    iload 6 
L51:    if_icmpge L72 
L54:    aload_1 
L55:    iload 7 
L57:    invokevirtual Method java/lang/String charAt (I)C 
L60:    invokestatic Method HexEncoder ignore (C)Z 
L63:    ifeq L72 
L66:    iinc 7 1 
L69:    goto L47 

        .stack same 
L72:    aload_0 
L73:    getfield Field HexEncoder decodingTable [B 
L76:    aload_1 
L77:    iload 7 
L79:    iinc 7 1 
L82:    invokevirtual Method java/lang/String charAt (I)C 
L85:    baload 
L86:    istore_3 

        .stack full 
            locals Object HexEncoder Object java/lang/String Object java/io/OutputStream Integer Top Integer Integer Integer 
            stack 
        .end stack 
L87:    iload 7 
L89:    iload 6 
L91:    if_icmpge L112 
L94:    aload_1 
L95:    iload 7 
L97:    invokevirtual Method java/lang/String charAt (I)C 
L100:   invokestatic Method HexEncoder ignore (C)Z 
L103:   ifeq L112 
L106:   iinc 7 1 
L109:   goto L87 

        .stack same 
L112:   aload_0 
L113:   getfield Field HexEncoder decodingTable [B 
L116:   aload_1 
L117:   iload 7 
L119:   iinc 7 1 
L122:   invokevirtual Method java/lang/String charAt (I)C 
L125:   baload 
L126:   istore 4 
L128:   iload_3 
L129:   iload 4 
L131:   ior 
L132:   ifge L145 
L135:   new java/io/IOException 
L138:   dup 
L139:   ldc 'invalid characters encountered in Hex string' 
L141:   invokespecial Method java/io/IOException <init> (Ljava/lang/String;)V 
L144:   athrow 

        .stack full 
            locals Object HexEncoder Object java/lang/String Object java/io/OutputStream Integer Integer Integer Integer Integer 
            stack 
        .end stack 
L145:   aload_2 
L146:   iload_3 
L147:   iconst_4 
L148:   ishl 
L149:   iload 4 
L151:   ior 
L152:   invokevirtual Method java/io/OutputStream write (I)V 
L155:   iinc 5 1 
L158:   goto L40 

        .stack full 
            locals Object HexEncoder Object java/lang/String Object java/io/OutputStream Top Top Integer Integer Integer 
            stack 
        .end stack 
L161:   return 
L162:   
        .linenumbertable 
            L0 74 
            L3 76 
            L9 78 
            L14 80 
            L28 82 
            L31 85 
            L37 88 
            L40 89 
            L47 91 
            L66 93 
            L72 96 
            L87 98 
            L106 100 
            L112 103 
            L128 105 
            L135 107 
            L145 110 
            L155 112 
            L161 115 
        .end linenumbertable 
        .localvariabletable 
            3 is b1 B from L87 to L161 
            4 is b2 B from L128 to L161 
            0 is this LHexEncoder; from L0 to L162 
            1 is data Ljava/lang/String; from L0 to L162 
            2 is out Ljava/io/OutputStream; from L0 to L162 
            5 is length I from L3 to L162 
            6 is end I from L9 to L162 
            7 is i I from L40 to L162 
        .end localvariabletable 
    .end code 
    .exceptions java/lang/Exception 
.end method 
.sourcefile 'HexEncoder.java' 
.end class 
