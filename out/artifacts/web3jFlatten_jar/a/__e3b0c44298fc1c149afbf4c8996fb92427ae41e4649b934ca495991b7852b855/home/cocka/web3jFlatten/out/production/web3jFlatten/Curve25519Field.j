.version 52 0 
.class super Curve25519Field 
.super java/lang/Object 
.field private static final M J = 4294967295L 
.field static final P [I 
.field private static final P7 I = 2147483647 
.field private static final PExt [I 
.field private static final PInv I = 19 

.method <init> : ()V 
    .code stack 1 locals 1 
L0:     aload_0 
L1:     invokespecial Method java/lang/Object <init> ()V 
L4:     return 
L5:     
        .linenumbertable 
            L0 2 
        .end linenumbertable 
        .localvariabletable 
            0 is this LCurve25519Field; from L0 to L5 
        .end localvariabletable 
    .end code 
.end method 

.method public static multiply : ([I[I[I)V 
    .code stack 3 locals 4 
L0:     invokestatic Method Nat256 createExt ()[I 
L3:     astore_3 
L4:     aload_0 
L5:     aload_1 
L6:     aload_3 
L7:     invokestatic Method Nat256 mul ([I[I[I)V 
L10:    aload_3 
L11:    aload_2 
L12:    invokestatic Method Curve25519Field reduce ([I[I)V 
L15:    return 
L16:    
        .linenumbertable 
            L0 22 
            L4 23 
            L10 24 
            L15 25 
        .end linenumbertable 
        .localvariabletable 
            0 is x [I from L0 to L16 
            1 is y [I from L0 to L16 
            2 is z [I from L0 to L16 
            3 is tt [I from L4 to L16 
        .end localvariabletable 
    .end code 
.end method 

.method public static reduce : ([I[I)V 
    .code stack 6 locals 5 
L0:     aload_0 
L1:     bipush 7 
L3:     iaload 
L4:     istore_2 
L5:     bipush 8 
L7:     aload_0 
L8:     bipush 8 
L10:    iload_2 
L11:    aload_1 
L12:    iconst_0 
L13:    invokestatic Method Nat shiftUpBit (I[III[II)V 
L16:    bipush 19 
L18:    aload_0 
L19:    aload_1 
L20:    invokestatic Method Nat256 mulByWordAddTo (I[I[I)I 
L23:    iconst_1 
L24:    ishl 
L25:    istore_3 
L26:    aload_1 
L27:    bipush 7 
L29:    iaload 
L30:    istore 4 
L32:    iload_3 
L33:    iload 4 
L35:    bipush 31 
L37:    iushr 
L38:    iload_2 
L39:    bipush 31 
L41:    iushr 
L42:    isub 
L43:    iadd 
L44:    istore_3 
L45:    iload 4 
L47:    ldc 2147483647 
L49:    iand 
L50:    istore 4 
L52:    iload 4 
L54:    bipush 7 
L56:    iload_3 
L57:    bipush 19 
L59:    imul 
L60:    aload_1 
L61:    invokestatic Method Nat addWordTo (II[I)I 
L64:    iadd 
L65:    istore 4 
L67:    aload_1 
L68:    bipush 7 
L70:    iload 4 
L72:    iastore 
L73:    aload_1 
L74:    getstatic Field Curve25519Field P [I 
L77:    invokestatic Method Nat256 gte ([I[I)Z 
L80:    ifeq L87 
L83:    aload_1 
L84:    invokestatic Method Curve25519Field subPFrom ([I)V 

        .stack append Integer Integer Integer 
L87:    return 
L88:    
        .linenumbertable 
            L0 34 
            L5 35 
            L16 36 
            L26 37 
            L32 38 
            L45 39 
            L52 40 
            L67 41 
            L73 42 
            L83 44 
            L87 46 
        .end linenumbertable 
        .localvariabletable 
            0 is xx [I from L0 to L88 
            1 is z [I from L0 to L88 
            2 is xx07 I from L5 to L88 
            3 is c I from L26 to L88 
            4 is z7 I from L32 to L88 
        .end localvariabletable 
    .end code 
.end method 

.method public static reduce27 : (I[I)V 
    .code stack 4 locals 4 
L0:     aload_1 
L1:     bipush 7 
L3:     iaload 
L4:     istore_2 
L5:     iload_0 
L6:     iconst_1 
L7:     ishl 
L8:     iload_2 
L9:     bipush 31 
L11:    iushr 
L12:    ior 
L13:    istore_3 
L14:    iload_2 
L15:    ldc 2147483647 
L17:    iand 
L18:    istore_2 
L19:    iload_2 
L20:    bipush 7 
L22:    iload_3 
L23:    bipush 19 
L25:    imul 
L26:    aload_1 
L27:    invokestatic Method Nat addWordTo (II[I)I 
L30:    iadd 
L31:    istore_2 
L32:    aload_1 
L33:    bipush 7 
L35:    iload_2 
L36:    iastore 
L37:    aload_1 
L38:    getstatic Field Curve25519Field P [I 
L41:    invokestatic Method Nat256 gte ([I[I)Z 
L44:    ifeq L51 
L47:    aload_1 
L48:    invokestatic Method Curve25519Field subPFrom ([I)V 

        .stack append Integer Integer 
L51:    return 
L52:    
        .linenumbertable 
            L0 52 
            L5 53 
            L14 54 
            L19 55 
            L32 56 
            L37 57 
            L47 59 
            L51 61 
        .end linenumbertable 
        .localvariabletable 
            0 is x I from L0 to L52 
            1 is z [I from L0 to L52 
            2 is z7 I from L5 to L52 
            3 is c I from L14 to L52 
        .end localvariabletable 
    .end code 
.end method 

.method public static square : ([I[I)V 
    .code stack 2 locals 3 
L0:     invokestatic Method Nat256 createExt ()[I 
L3:     astore_2 
L4:     aload_0 
L5:     aload_2 
L6:     invokestatic Method Nat256 square ([I[I)V 
L9:     aload_2 
L10:    aload_1 
L11:    invokestatic Method Curve25519Field reduce ([I[I)V 
L14:    return 
L15:    
        .linenumbertable 
            L0 65 
            L4 66 
            L9 67 
            L14 68 
        .end linenumbertable 
        .localvariabletable 
            0 is x [I from L0 to L15 
            1 is z [I from L0 to L15 
            2 is tt [I from L4 to L15 
        .end localvariabletable 
    .end code 
.end method 

.method public static subtract : ([I[I[I)V 
    .code stack 3 locals 4 
L0:     aload_0 
L1:     aload_1 
L2:     aload_2 
L3:     invokestatic Method Nat256 sub ([I[I[I)I 
L6:     istore_3 
L7:     iload_3 
L8:     ifeq L15 
L11:    aload_2 
L12:    invokestatic Method Curve25519Field addPTo ([I)V 

        .stack append Integer 
L15:    return 
L16:    
        .linenumbertable 
            L0 74 
            L7 75 
            L11 77 
            L15 79 
        .end linenumbertable 
        .localvariabletable 
            0 is x [I from L0 to L16 
            1 is y [I from L0 to L16 
            2 is z [I from L0 to L16 
            3 is c I from L7 to L16 
        .end localvariabletable 
    .end code 
.end method 

.method public static twice : ([I[I)V 
    .code stack 4 locals 2 
L0:     bipush 8 
L2:     aload_0 
L3:     iconst_0 
L4:     aload_1 
L5:     invokestatic Method Nat shiftUpBit (I[II[I)I 
L8:     pop 
L9:     aload_1 
L10:    getstatic Field Curve25519Field P [I 
L13:    invokestatic Method Nat256 gte ([I[I)Z 
L16:    ifeq L23 
L19:    aload_1 
L20:    invokestatic Method Curve25519Field subPFrom ([I)V 

        .stack same 
L23:    return 
L24:    
        .linenumbertable 
            L0 83 
            L9 84 
            L19 86 
            L23 88 
        .end linenumbertable 
        .localvariabletable 
            0 is x [I from L0 to L24 
            1 is z [I from L0 to L24 
        .end localvariabletable 
    .end code 
.end method 

.method private static addPTo : ([I)V 
    .code stack 6 locals 3 
L0:     aload_0 
L1:     iconst_0 
L2:     iaload 
L3:     i2l 
L4:     ldc2_w 4294967295L 
L7:     land 
L8:     ldc2_w 19L 
L11:    lsub 
L12:    lstore_1 
L13:    aload_0 
L14:    iconst_0 
L15:    lload_1 
L16:    l2i 
L17:    iastore 
L18:    lload_1 
L19:    bipush 32 
L21:    lshr 
L22:    lstore_1 
L23:    lload_1 
L24:    lconst_0 
L25:    lcmp 
L26:    ifeq L38 
L29:    bipush 7 
L31:    aload_0 
L32:    iconst_1 
L33:    invokestatic Method Nat decAt (I[II)I 
L36:    i2l 
L37:    lstore_1 

        .stack append Long 
L38:    lload_1 
L39:    aload_0 
L40:    bipush 7 
L42:    iaload 
L43:    i2l 
L44:    ldc2_w 4294967295L 
L47:    land 
L48:    ldc2_w 2147483648L 
L51:    ladd 
L52:    ladd 
L53:    lstore_1 
L54:    aload_0 
L55:    bipush 7 
L57:    lload_1 
L58:    l2i 
L59:    iastore 
L60:    return 
L61:    
        .linenumbertable 
            L0 92 
            L13 93 
            L18 94 
            L23 95 
            L29 97 
            L38 99 
            L54 100 
            L60 101 
        .end linenumbertable 
        .localvariabletable 
            0 is z [I from L0 to L61 
            1 is c J from L13 to L61 
        .end localvariabletable 
    .end code 
.end method 

.method private static subPFrom : ([I)V 
    .code stack 6 locals 3 
L0:     aload_0 
L1:     iconst_0 
L2:     iaload 
L3:     i2l 
L4:     ldc2_w 4294967295L 
L7:     land 
L8:     ldc2_w 19L 
L11:    ladd 
L12:    lstore_1 
L13:    aload_0 
L14:    iconst_0 
L15:    lload_1 
L16:    l2i 
L17:    iastore 
L18:    lload_1 
L19:    bipush 32 
L21:    lshr 
L22:    lstore_1 
L23:    lload_1 
L24:    lconst_0 
L25:    lcmp 
L26:    ifeq L38 
L29:    bipush 7 
L31:    aload_0 
L32:    iconst_1 
L33:    invokestatic Method Nat incAt (I[II)I 
L36:    i2l 
L37:    lstore_1 

        .stack append Long 
L38:    lload_1 
L39:    aload_0 
L40:    bipush 7 
L42:    iaload 
L43:    i2l 
L44:    ldc2_w 4294967295L 
L47:    land 
L48:    ldc2_w 2147483648L 
L51:    lsub 
L52:    ladd 
L53:    lstore_1 
L54:    aload_0 
L55:    bipush 7 
L57:    lload_1 
L58:    l2i 
L59:    iastore 
L60:    return 
L61:    
        .linenumbertable 
            L0 105 
            L13 106 
            L18 107 
            L23 108 
            L29 110 
            L38 112 
            L54 113 
            L60 114 
        .end linenumbertable 
        .localvariabletable 
            0 is z [I from L0 to L61 
            1 is c J from L13 to L61 
        .end localvariabletable 
    .end code 
.end method 

.method private static subPExtFrom : ([I)V 
    .code stack 8 locals 3 
L0:     aload_0 
L1:     iconst_0 
L2:     iaload 
L3:     i2l 
L4:     ldc2_w 4294967295L 
L7:     land 
L8:     getstatic Field Curve25519Field PExt [I 
L11:    iconst_0 
L12:    iaload 
L13:    i2l 
L14:    ldc2_w 4294967295L 
L17:    land 
L18:    lsub 
L19:    lstore_1 
L20:    aload_0 
L21:    iconst_0 
L22:    lload_1 
L23:    l2i 
L24:    iastore 
L25:    lload_1 
L26:    bipush 32 
L28:    lshr 
L29:    lstore_1 
L30:    lload_1 
L31:    lconst_0 
L32:    lcmp 
L33:    ifeq L45 
L36:    bipush 8 
L38:    aload_0 
L39:    iconst_1 
L40:    invokestatic Method Nat decAt (I[II)I 
L43:    i2l 
L44:    lstore_1 

        .stack append Long 
L45:    lload_1 
L46:    aload_0 
L47:    bipush 8 
L49:    iaload 
L50:    i2l 
L51:    ldc2_w 4294967295L 
L54:    land 
L55:    ldc2_w 19L 
L58:    ladd 
L59:    ladd 
L60:    lstore_1 
L61:    aload_0 
L62:    bipush 8 
L64:    lload_1 
L65:    l2i 
L66:    iastore 
L67:    lload_1 
L68:    bipush 32 
L70:    lshr 
L71:    lstore_1 
L72:    lload_1 
L73:    lconst_0 
L74:    lcmp 
L75:    ifeq L88 
L78:    bipush 15 
L80:    aload_0 
L81:    bipush 9 
L83:    invokestatic Method Nat incAt (I[II)I 
L86:    i2l 
L87:    lstore_1 

        .stack same 
L88:    lload_1 
L89:    aload_0 
L90:    bipush 15 
L92:    iaload 
L93:    i2l 
L94:    ldc2_w 4294967295L 
L97:    land 
L98:    getstatic Field Curve25519Field PExt [I 
L101:   bipush 15 
L103:   iaload 
L104:   iconst_1 
L105:   iadd 
L106:   i2l 
L107:   ldc2_w 4294967295L 
L110:   land 
L111:   lsub 
L112:   ladd 
L113:   lstore_1 
L114:   aload_0 
L115:   bipush 15 
L117:   lload_1 
L118:   l2i 
L119:   iastore 
L120:   return 
L121:   
        .linenumbertable 
            L0 118 
            L20 119 
            L25 120 
            L30 121 
            L36 123 
            L45 125 
            L61 126 
            L67 127 
            L72 128 
            L78 130 
            L88 132 
            L114 133 
            L120 134 
        .end linenumbertable 
        .localvariabletable 
            0 is zz [I from L0 to L121 
            1 is c J from L20 to L121 
        .end localvariabletable 
    .end code 
.end method 

.method static <clinit> : ()V 
    .code stack 4 locals 0 
L0:     bipush 8 
L2:     newarray int 
L4:     dup 
L5:     iconst_0 
L6:     bipush -19 
L8:     iastore 
L9:     dup 
L10:    iconst_1 
L11:    iconst_m1 
L12:    iastore 
L13:    dup 
L14:    iconst_2 
L15:    iconst_m1 
L16:    iastore 
L17:    dup 
L18:    iconst_3 
L19:    iconst_m1 
L20:    iastore 
L21:    dup 
L22:    iconst_4 
L23:    iconst_m1 
L24:    iastore 
L25:    dup 
L26:    iconst_5 
L27:    iconst_m1 
L28:    iastore 
L29:    dup 
L30:    bipush 6 
L32:    iconst_m1 
L33:    iastore 
L34:    dup 
L35:    bipush 7 
L37:    ldc 2147483647 
L39:    iastore 
L40:    putstatic Field Curve25519Field P [I 
L43:    bipush 16 
L45:    newarray int 
L47:    dup 
L48:    iconst_0 
L49:    sipush 361 
L52:    iastore 
L53:    dup 
L54:    iconst_1 
L55:    iconst_0 
L56:    iastore 
L57:    dup 
L58:    iconst_2 
L59:    iconst_0 
L60:    iastore 
L61:    dup 
L62:    iconst_3 
L63:    iconst_0 
L64:    iastore 
L65:    dup 
L66:    iconst_4 
L67:    iconst_0 
L68:    iastore 
L69:    dup 
L70:    iconst_5 
L71:    iconst_0 
L72:    iastore 
L73:    dup 
L74:    bipush 6 
L76:    iconst_0 
L77:    iastore 
L78:    dup 
L79:    bipush 7 
L81:    iconst_0 
L82:    iastore 
L83:    dup 
L84:    bipush 8 
L86:    bipush -19 
L88:    iastore 
L89:    dup 
L90:    bipush 9 
L92:    iconst_m1 
L93:    iastore 
L94:    dup 
L95:    bipush 10 
L97:    iconst_m1 
L98:    iastore 
L99:    dup 
L100:   bipush 11 
L102:   iconst_m1 
L103:   iastore 
L104:   dup 
L105:   bipush 12 
L107:   iconst_m1 
L108:   iastore 
L109:   dup 
L110:   bipush 13 
L112:   iconst_m1 
L113:   iastore 
L114:   dup 
L115:   bipush 14 
L117:   iconst_m1 
L118:   iastore 
L119:   dup 
L120:   bipush 15 
L122:   ldc 1073741823 
L124:   iastore 
L125:   putstatic Field Curve25519Field PExt [I 
L128:   return 
L129:   
        .linenumbertable 
            L0 7 
            L43 10 
        .end linenumbertable 
    .end code 
.end method 
.sourcefile 'Curve25519Field.java' 
.end class 
