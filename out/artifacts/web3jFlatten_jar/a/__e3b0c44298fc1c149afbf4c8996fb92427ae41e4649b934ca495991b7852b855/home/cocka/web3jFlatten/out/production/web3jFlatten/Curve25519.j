.version 52 0 
.class public super Curve25519 
.super ECCurve$AbstractFp 
.field public static final q Ljava/math/BigInteger; 

.method private <init> : ()V 
    .code stack 6 locals 1 
L0:     aload_0 
L1:     getstatic Field Curve25519 q Ljava/math/BigInteger; 
L4:     invokespecial Method ECCurve$AbstractFp <init> (Ljava/math/BigInteger;)V 
L7:     aload_0 
L8:     aload_0 
L9:     new java/math/BigInteger 
L12:    dup 
L13:    iconst_1 
L14:    ldc '2AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA984914A144' 
L16:    invokestatic Method Hex decode (Ljava/lang/String;)[B 
L19:    invokespecial Method java/math/BigInteger <init> (I[B)V 
L22:    invokevirtual Method Curve25519 fromBigInteger (Ljava/math/BigInteger;)LECFieldElement; 
L25:    putfield Field Curve25519 a LECFieldElement; 
L28:    aload_0 
L29:    aload_0 
L30:    new java/math/BigInteger 
L33:    dup 
L34:    iconst_1 
L35:    ldc '7B425ED097B425ED097B425ED097B425ED097B425ED097B4260B5E9C7710C864' 
L37:    invokestatic Method Hex decode (Ljava/lang/String;)[B 
L40:    invokespecial Method java/math/BigInteger <init> (I[B)V 
L43:    invokevirtual Method Curve25519 fromBigInteger (Ljava/math/BigInteger;)LECFieldElement; 
L46:    putfield Field Curve25519 b LECFieldElement; 
L49:    aload_0 
L50:    new java/math/BigInteger 
L53:    dup 
L54:    iconst_1 
L55:    ldc '1000000000000000000000000000000014DEF9DEA2F79CD65812631A5CF5D3ED' 
L57:    invokestatic Method Hex decode (Ljava/lang/String;)[B 
L60:    invokespecial Method java/math/BigInteger <init> (I[B)V 
L63:    putfield Field Curve25519 order Ljava/math/BigInteger; 
L66:    aload_0 
L67:    ldc2_w 8L 
L70:    invokestatic Method java/math/BigInteger valueOf (J)Ljava/math/BigInteger; 
L73:    putfield Field Curve25519 cofactor Ljava/math/BigInteger; 
L76:    return 
L77:    
        .linenumbertable 
            L0 10 
            L7 13 
            L16 14 
            L22 13 
            L28 15 
            L37 16 
            L43 15 
            L49 17 
            L66 18 
            L76 20 
        .end linenumbertable 
        .localvariabletable 
            0 is this LCurve25519; from L0 to L77 
        .end localvariabletable 
    .end code 
    .exceptions java/lang/Exception 
.end method 

.method public getFieldSize : ()I 
    .code stack 1 locals 1 
L0:     iconst_0 
L1:     ireturn 
L2:     
        .linenumbertable 
            L0 23 
        .end linenumbertable 
        .localvariabletable 
            0 is this LCurve25519; from L0 to L2 
        .end localvariabletable 
    .end code 
.end method 

.method public fromBigInteger : (Ljava/math/BigInteger;)LECFieldElement; 
    .code stack 1 locals 2 
L0:     aconst_null 
L1:     areturn 
L2:     
        .linenumbertable 
            L0 27 
        .end linenumbertable 
        .localvariabletable 
            0 is this LCurve25519; from L0 to L2 
            1 is x Ljava/math/BigInteger; from L0 to L2 
        .end localvariabletable 
    .end code 
.end method 

.method protected cloneCurve : ()LECCurve; 
    .code stack 1 locals 1 
L0:     aconst_null 
L1:     areturn 
L2:     
        .linenumbertable 
            L0 31 
        .end linenumbertable 
        .localvariabletable 
            0 is this LCurve25519; from L0 to L2 
        .end localvariabletable 
    .end code 
.end method 

.method protected createRawPoint : (LECFieldElement;LECFieldElement;Z)LECPoint; 
    .code stack 1 locals 4 
L0:     aconst_null 
L1:     areturn 
L2:     
        .linenumbertable 
            L0 35 
        .end linenumbertable 
        .localvariabletable 
            0 is this LCurve25519; from L0 to L2 
            1 is x LECFieldElement; from L0 to L2 
            2 is y LECFieldElement; from L0 to L2 
            3 is withCompression Z from L0 to L2 
        .end localvariabletable 
    .end code 
.end method 

.method public getInfinity : ()LECPoint; 
    .code stack 1 locals 1 
L0:     aconst_null 
L1:     areturn 
L2:     
        .linenumbertable 
            L0 40 
        .end linenumbertable 
        .localvariabletable 
            0 is this LCurve25519; from L0 to L2 
        .end localvariabletable 
    .end code 
.end method 

.method public createCacheSafeLookupTable : ([LECPoint;II)LECLookupTable; 
    .code stack 4 locals 9 
L0:     bipush 8 
L2:     istore 4 
L4:     iload_3 
L5:     bipush 8 
L7:     imul 
L8:     iconst_2 
L9:     imul 
L10:    newarray int 
L12:    astore 5 
L14:    iconst_0 
L15:    istore 6 
L17:    iconst_0 
L18:    istore 7 

        .stack full 
            locals Object Curve25519 Object [LECPoint; Integer Integer Integer Object [I Integer Integer 
            stack 
        .end stack 
L20:    iload 7 
L22:    iload_3 
L23:    if_icmpge L84 
L26:    aload_1 
L27:    iload_2 
L28:    iload 7 
L30:    iadd 
L31:    aaload 
L32:    astore 8 
L34:    aload 8 
L36:    invokevirtual Method ECPoint getRawXCoord ()LECFieldElement; 
L39:    checkcast Curve25519FieldElement 
L42:    getfield Field Curve25519FieldElement x [I 
L45:    iconst_0 
L46:    aload 5 
L48:    iload 6 
L50:    invokestatic Method Nat256 copy ([II[II)V 
L53:    iinc 6 8 
L56:    aload 8 
L58:    invokevirtual Method ECPoint getRawYCoord ()LECFieldElement; 
L61:    checkcast Curve25519FieldElement 
L64:    getfield Field Curve25519FieldElement x [I 
L67:    iconst_0 
L68:    aload 5 
L70:    iload 6 
L72:    invokestatic Method Nat256 copy ([II[II)V 
L75:    iinc 6 8 
L78:    iinc 7 1 
L81:    goto L20 

        .stack chop 2 
L84:    new Curve25519$1 
L87:    dup 
L88:    aload_0 
L89:    invokespecial Method Curve25519$1 <init> (LCurve25519;)V 
L92:    areturn 
L93:    
        .linenumbertable 
            L0 51 
            L4 53 
            L14 55 
            L17 56 
            L26 58 
            L34 59 
            L56 60 
            L78 56 
            L84 64 
        .end linenumbertable 
        .localvariabletable 
            8 is p LECPoint; from L34 to L78 
            7 is i I from L20 to L84 
            6 is pos I from L17 to L84 
            0 is this LCurve25519; from L0 to L93 
            1 is points [LECPoint; from L0 to L93 
            2 is off I from L0 to L93 
            3 is len I from L0 to L93 
            4 is FE_INTS I from L4 to L93 
            5 is table [I from L14 to L93 
        .end localvariabletable 
    .end code 
.end method 

.method static <clinit> : ()V 
    .code stack 1 locals 0 
L0:     getstatic Field Curve25519Field P [I 
L3:     invokestatic Method Nat256 toBigInteger ([I)Ljava/math/BigInteger; 
L6:     putstatic Field Curve25519 q Ljava/math/BigInteger; 
L9:     return 
L10:    
        .linenumbertable 
            L0 5 
        .end linenumbertable 
    .end code 
.end method 
.sourcefile 'Curve25519.java' 
.innerclasses 
    Curve25519$1 [0] [0] 
    ECCurve$AbstractFp ECCurve AbstractFp protected static abstract 
.end innerclasses 
.end class 
