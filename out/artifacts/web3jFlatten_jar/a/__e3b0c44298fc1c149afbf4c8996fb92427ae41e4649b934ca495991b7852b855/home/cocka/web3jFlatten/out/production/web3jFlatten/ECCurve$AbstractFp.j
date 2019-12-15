.version 52 0 
.class public super abstract ECCurve$AbstractFp 
.super ECCurve 

.method <init> : (Ljava/math/BigInteger;)V 
    .code stack 2 locals 2 
L0:     aload_0 
L1:     aload_1 
L2:     invokestatic Method FiniteFields getPrimeField (Ljava/math/BigInteger;)LGenericPolynomialExtensionField; 
L5:     invokespecial Method ECCurve <init> (LGenericPolynomialExtensionField;)V 
L8:     return 
L9:     
        .linenumbertable 
            L0 416 
            L8 417 
        .end linenumbertable 
        .localvariabletable 
            0 is this LECCurve$AbstractFp; from L0 to L9 
            1 is q Ljava/math/BigInteger; from L0 to L9 
        .end localvariabletable 
    .end code 
.end method 

.method public <init> : ()V 
    .code stack 1 locals 1 
L0:     aload_0 
L1:     invokespecial Method ECCurve <init> ()V 
L4:     return 
L5:     
        .linenumbertable 
            L0 420 
            L4 421 
        .end linenumbertable 
        .localvariabletable 
            0 is this LECCurve$AbstractFp; from L0 to L5 
        .end localvariabletable 
    .end code 
.end method 

.method protected decompressPoint : (ILjava/math/BigInteger;)LECPoint; 
    .code stack 4 locals 6 
L0:     aload_0 
L1:     aload_2 
L2:     invokevirtual Method ECCurve$AbstractFp fromBigInteger (Ljava/math/BigInteger;)LECFieldElement; 
L5:     astore_3 
L6:     aload_3 
L7:     invokevirtual Method ECFieldElement square ()LECFieldElement; 
L10:    aload_0 
L11:    getfield Field ECCurve$AbstractFp a LECFieldElement; 
L14:    invokevirtual Method ECFieldElement add (LECFieldElement;)LECFieldElement; 
L17:    aload_3 
L18:    invokevirtual Method ECFieldElement multiply (LECFieldElement;)LECFieldElement; 
L21:    aload_0 
L22:    getfield Field ECCurve$AbstractFp b LECFieldElement; 
L25:    invokevirtual Method ECFieldElement add (LECFieldElement;)LECFieldElement; 
L28:    astore 4 
L30:    aload 4 
L32:    invokevirtual Method ECFieldElement sqrt ()LECFieldElement; 
L35:    astore 5 
L37:    aload 5 
L39:    ifnonnull L52 
L42:    new java/lang/IllegalArgumentException 
L45:    dup 
L46:    ldc 'Invalid point compression' 
L48:    invokespecial Method java/lang/IllegalArgumentException <init> (Ljava/lang/String;)V 
L51:    athrow 

        .stack append Object ECFieldElement Object ECFieldElement Object ECFieldElement 
L52:    aload 5 
L54:    invokevirtual Method ECFieldElement testBitZero ()Z 
L57:    iload_1 
L58:    iconst_1 
L59:    if_icmpne L66 
L62:    iconst_1 
L63:    goto L67 

        .stack stack_1 Integer 
L66:    iconst_0 

        .stack full 
            locals Object ECCurve$AbstractFp Integer Object java/math/BigInteger Object ECFieldElement Object ECFieldElement Object ECFieldElement 
            stack Integer Integer 
        .end stack 
L67:    if_icmpeq L77 
L70:    aload 5 
L72:    invokevirtual Method ECFieldElement negate ()LECFieldElement; 
L75:    astore 5 

        .stack same 
L77:    aload_0 
L78:    aload_3 
L79:    aload 5 
L81:    iconst_1 
L82:    invokevirtual Method ECCurve$AbstractFp createRawPoint (LECFieldElement;LECFieldElement;Z)LECPoint; 
L85:    areturn 
L86:    
        .linenumbertable 
            L0 424 
            L6 425 
            L30 426 
            L37 429 
            L42 431 
            L52 434 
            L70 437 
            L77 440 
        .end linenumbertable 
        .localvariabletable 
            0 is this LECCurve$AbstractFp; from L0 to L86 
            1 is yTilde I from L0 to L86 
            2 is X1 Ljava/math/BigInteger; from L0 to L86 
            3 is x LECFieldElement; from L6 to L86 
            4 is rhs LECFieldElement; from L30 to L86 
            5 is y LECFieldElement; from L37 to L86 
        .end localvariabletable 
    .end code 
.end method 
.sourcefile 'ECCurve.java' 
.innerclasses 
    ECCurve$AbstractFp ECCurve AbstractFp protected static abstract 
.end innerclasses 
.end class 
