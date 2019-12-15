.version 52 0 
.class public super SecP256K1Curve 
.super ECCurve$AbstractFp 
.field public static q Ljava/math/BigInteger; 
.field private static final SECP256K1_DEFAULT_COORDS I = 2 
.field private infinity LSecP256K1Point; 

.method public <init> : ()V 
    .code stack 6 locals 1 
L0:     aload_0 
L1:     getstatic Field SecP256K1Curve q Ljava/math/BigInteger; 
L4:     invokespecial Method ECCurve$AbstractFp <init> (Ljava/math/BigInteger;)V 
L7:     aload_0 
L8:     new SecP256K1Point 
L11:    dup 
L12:    aload_0 
L13:    aconst_null 
L14:    aconst_null 
L15:    invokespecial Method SecP256K1Point <init> (LECCurve;LECFieldElement;LECFieldElement;)V 
L18:    putfield Field SecP256K1Curve infinity LSecP256K1Point; 
L21:    aload_0 
L22:    aload_0 
L23:    getstatic Field ECConstants ZERO Ljava/math/BigInteger; 
L26:    invokevirtual Method SecP256K1Curve fromBigInteger (Ljava/math/BigInteger;)LECFieldElement; 
L29:    putfield Field SecP256K1Curve a LECFieldElement; 
L32:    aload_0 
L33:    aload_0 
L34:    ldc2_w 7L 
L37:    invokestatic Method java/math/BigInteger valueOf (J)Ljava/math/BigInteger; 
L40:    invokevirtual Method SecP256K1Curve fromBigInteger (Ljava/math/BigInteger;)LECFieldElement; 
L43:    putfield Field SecP256K1Curve b LECFieldElement; 
L46:    aload_0 
L47:    new java/math/BigInteger 
L50:    dup 
L51:    iconst_1 
L52:    ldc 'FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEBAAEDCE6AF48A03BBFD25E8CD0364141' 
L54:    invokestatic Method Hex decode (Ljava/lang/String;)[B 
L57:    invokespecial Method java/math/BigInteger <init> (I[B)V 
L60:    putfield Field SecP256K1Curve order Ljava/math/BigInteger; 
L63:    aload_0 
L64:    lconst_1 
L65:    invokestatic Method java/math/BigInteger valueOf (J)Ljava/math/BigInteger; 
L68:    putfield Field SecP256K1Curve cofactor Ljava/math/BigInteger; 
L71:    aload_0 
L72:    iconst_2 
L73:    putfield Field SecP256K1Curve coord I 
L76:    return 
L77:    
        .linenumbertable 
            L0 21 
            L7 23 
            L21 25 
            L32 26 
            L46 27 
            L63 28 
            L71 29 
            L76 30 
        .end linenumbertable 
        .localvariabletable 
            0 is this LSecP256K1Curve; from L0 to L77 
        .end localvariabletable 
    .end code 
    .exceptions java/lang/Exception 
.end method 

.method protected cloneCurve : ()LECCurve; 
    .code stack 2 locals 1 
L0:     new SecP256K1Curve 
L3:     dup 
L4:     invokespecial Method SecP256K1Curve <init> ()V 
L7:     areturn 
L8:     
        .linenumbertable 
            L0 33 
        .end linenumbertable 
        .localvariabletable 
            0 is this LSecP256K1Curve; from L0 to L8 
        .end localvariabletable 
    .end code 
    .exceptions java/lang/Exception 
.end method 

.method public supportsCoordinateSystem : (I)Z 
    .code stack 2 locals 2 
L0:     iload_1 
L1:     iconst_2 
L2:     if_icmpne L9 
L5:     iconst_1 
L6:     goto L10 

        .stack same 
L9:     iconst_0 

        .stack stack_1 Integer 
L10:    ireturn 
L11:    
        .linenumbertable 
            L0 38 
        .end linenumbertable 
        .localvariabletable 
            0 is this LSecP256K1Curve; from L0 to L11 
            1 is coord I from L0 to L11 
        .end localvariabletable 
    .end code 
.end method 

.method public getFieldSize : ()I 
    .code stack 1 locals 1 
L0:     getstatic Field SecP256K1Curve q Ljava/math/BigInteger; 
L3:     invokevirtual Method java/math/BigInteger bitLength ()I 
L6:     ireturn 
L7:     
        .linenumbertable 
            L0 43 
        .end linenumbertable 
        .localvariabletable 
            0 is this LSecP256K1Curve; from L0 to L7 
        .end localvariabletable 
    .end code 
.end method 

.method public fromBigInteger : (Ljava/math/BigInteger;)LECFieldElement; 
    .code stack 3 locals 2 
L0:     new SecP256K1FieldElement 
L3:     dup 
L4:     aload_1 
L5:     invokespecial Method SecP256K1FieldElement <init> (Ljava/math/BigInteger;)V 
L8:     areturn 
L9:     
        .linenumbertable 
            L0 48 
        .end linenumbertable 
        .localvariabletable 
            0 is this LSecP256K1Curve; from L0 to L9 
            1 is x Ljava/math/BigInteger; from L0 to L9 
        .end localvariabletable 
    .end code 
.end method 

.method protected createRawPoint : (LECFieldElement;LECFieldElement;Z)LECPoint; 
    .code stack 6 locals 4 
L0:     new SecP256K1Point 
L3:     dup 
L4:     aload_0 
L5:     aload_1 
L6:     aload_2 
L7:     iload_3 
L8:     invokespecial Method SecP256K1Point <init> (LECCurve;LECFieldElement;LECFieldElement;Z)V 
L11:    areturn 
L12:    
        .linenumbertable 
            L0 53 
        .end linenumbertable 
        .localvariabletable 
            0 is this LSecP256K1Curve; from L0 to L12 
            1 is x LECFieldElement; from L0 to L12 
            2 is y LECFieldElement; from L0 to L12 
            3 is withCompression Z from L0 to L12 
        .end localvariabletable 
    .end code 
.end method 

.method public getInfinity : ()LECPoint; 
    .code stack 1 locals 1 
L0:     aload_0 
L1:     getfield Field SecP256K1Curve infinity LSecP256K1Point; 
L4:     areturn 
L5:     
        .linenumbertable 
            L0 58 
        .end linenumbertable 
        .localvariabletable 
            0 is this LSecP256K1Curve; from L0 to L5 
        .end localvariabletable 
    .end code 
.end method 

.method public createCacheSafeLookupTable : ([LECPoint;II)LECLookupTable; 
    .code stack 5 locals 9 
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
            locals Object SecP256K1Curve Object [LECPoint; Integer Integer Integer Object [I Integer Integer 
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
L39:    checkcast SecP256K1FieldElement 
L42:    getfield Field SecP256K1FieldElement x [I 
L45:    iconst_0 
L46:    aload 5 
L48:    iload 6 
L50:    invokestatic Method Nat256 copy ([II[II)V 
L53:    iinc 6 8 
L56:    aload 8 
L58:    invokevirtual Method ECPoint getRawYCoord ()LECFieldElement; 
L61:    checkcast SecP256K1FieldElement 
L64:    getfield Field SecP256K1FieldElement x [I 
L67:    iconst_0 
L68:    aload 5 
L70:    iload 6 
L72:    invokestatic Method Nat256 copy ([II[II)V 
L75:    iinc 6 8 
L78:    iinc 7 1 
L81:    goto L20 

        .stack chop 2 
L84:    new SecP256K1Curve$1 
L87:    dup 
L88:    aload_0 
L89:    iload_3 
L90:    aload 5 
L92:    invokespecial Method SecP256K1Curve$1 <init> (LSecP256K1Curve;I[I)V 
L95:    areturn 
L96:    
        .linenumbertable 
            L0 63 
            L4 65 
            L14 67 
            L17 68 
            L26 70 
            L34 71 
            L56 72 
            L78 68 
            L84 76 
        .end linenumbertable 
        .localvariabletable 
            8 is p LECPoint; from L34 to L78 
            7 is i I from L20 to L84 
            6 is pos I from L17 to L84 
            0 is this LSecP256K1Curve; from L0 to L96 
            1 is points [LECPoint; from L0 to L96 
            2 is off I from L0 to L96 
            3 is len I from L0 to L96 
            4 is FE_INTS I from L4 to L96 
            5 is table [I from L14 to L96 
        .end localvariabletable 
    .end code 
.end method 

.method static <clinit> : ()V 
    .code stack 4 locals 1 
        .catch java/lang/Exception from L0 to L16 using L19 
L0:     new java/math/BigInteger 
L3:     dup 
L4:     iconst_1 
L5:     ldc 'FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFC2F' 
L7:     invokestatic Method Hex decode (Ljava/lang/String;)[B 
L10:    invokespecial Method java/math/BigInteger <init> (I[B)V 
L13:    putstatic Field SecP256K1Curve q Ljava/math/BigInteger; 
L16:    goto L24 

        .stack stack_1 Object java/lang/Exception 
L19:    astore_0 
L20:    aload_0 
L21:    invokevirtual Method java/lang/Exception printStackTrace ()V 

        .stack same 
L24:    return 
L25:    
        .linenumbertable 
            L0 9 
            L7 10 
            L16 13 
            L19 11 
            L20 12 
            L24 14 
        .end linenumbertable 
        .localvariabletable 
            0 is e Ljava/lang/Exception; from L20 to L24 
        .end localvariabletable 
    .end code 
.end method 
.sourcefile 'SecP256K1Curve.java' 
.innerclasses 
    SecP256K1Curve$1 [0] [0] 
    ECCurve$AbstractFp ECCurve AbstractFp protected static abstract 
.end innerclasses 
.end class 
