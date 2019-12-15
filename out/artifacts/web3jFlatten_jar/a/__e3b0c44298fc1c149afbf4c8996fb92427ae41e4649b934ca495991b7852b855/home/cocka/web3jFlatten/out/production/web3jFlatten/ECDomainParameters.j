.version 52 0 
.class super ECDomainParameters 
.super java/lang/Object 
.implements ECConstants 
.field private curve LECCurve; 
.field private G LECPoint; 
.field private n Ljava/math/BigInteger; 
.field private h Ljava/math/BigInteger; 

.method public <init> : (LECCurve;LECPoint;Ljava/math/BigInteger;Ljava/math/BigInteger;)V 
    .code stack 3 locals 5 
L0:     aload_0 
L1:     invokespecial Method java/lang/Object <init> ()V 
L4:     aload_1 
L5:     ifnonnull L18 
L8:     new java/lang/NullPointerException 
L11:    dup 
L12:    ldc 'curve' 
L14:    invokespecial Method java/lang/NullPointerException <init> (Ljava/lang/String;)V 
L17:    athrow 

        .stack full 
            locals Object ECDomainParameters Object ECCurve Object ECPoint Object java/math/BigInteger Object java/math/BigInteger 
            stack 
        .end stack 
L18:    aload_3 
L19:    ifnonnull L32 
L22:    new java/lang/NullPointerException 
L25:    dup 
L26:    ldc 'n' 
L28:    invokespecial Method java/lang/NullPointerException <init> (Ljava/lang/String;)V 
L31:    athrow 

        .stack same 
L32:    aload_0 
L33:    aload_1 
L34:    putfield Field ECDomainParameters curve LECCurve; 
L37:    aload_0 
L38:    aload_1 
L39:    aload_2 
L40:    invokestatic Method ECDomainParameters validate (LECCurve;LECPoint;)LECPoint; 
L43:    putfield Field ECDomainParameters G LECPoint; 
L46:    aload_0 
L47:    aload_3 
L48:    putfield Field ECDomainParameters n Ljava/math/BigInteger; 
L51:    aload_0 
L52:    aload 4 
L54:    putfield Field ECDomainParameters h Ljava/math/BigInteger; 
L57:    return 
L58:    
        .linenumbertable 
            L0 18 
            L4 19 
            L8 21 
            L18 23 
            L22 25 
            L32 29 
            L37 30 
            L46 31 
            L51 32 
            L57 33 
        .end linenumbertable 
        .localvariabletable 
            0 is this LECDomainParameters; from L0 to L58 
            1 is curve LECCurve; from L0 to L58 
            2 is G LECPoint; from L0 to L58 
            3 is n Ljava/math/BigInteger; from L0 to L58 
            4 is h Ljava/math/BigInteger; from L0 to L58 
        .end localvariabletable 
    .end code 
    .exceptions java/lang/CloneNotSupportedException 
.end method 

.method public getG : ()LECPoint; 
    .code stack 1 locals 1 
L0:     aload_0 
L1:     getfield Field ECDomainParameters G LECPoint; 
L4:     areturn 
L5:     
        .linenumbertable 
            L0 37 
        .end linenumbertable 
        .localvariabletable 
            0 is this LECDomainParameters; from L0 to L5 
        .end localvariabletable 
    .end code 
.end method 

.method public getN : ()Ljava/math/BigInteger; 
    .code stack 1 locals 1 
L0:     aload_0 
L1:     getfield Field ECDomainParameters n Ljava/math/BigInteger; 
L4:     areturn 
L5:     
        .linenumbertable 
            L0 42 
        .end linenumbertable 
        .localvariabletable 
            0 is this LECDomainParameters; from L0 to L5 
        .end localvariabletable 
    .end code 
.end method 

.method public equals : (Ljava/lang/Object;)Z 
    .code stack 2 locals 4 
L0:     aload_0 
L1:     aload_1 
L2:     if_acmpne L7 
L5:     iconst_1 
L6:     ireturn 

        .stack same 
L7:     aload_1 
L8:     instanceof ECDomainParameters 
L11:    ifeq L86 
L14:    aload_1 
L15:    checkcast ECDomainParameters 
L18:    astore_2 
        .catch java/lang/CloneNotSupportedException from L19 to L80 using L81 
L19:    aload_0 
L20:    getfield Field ECDomainParameters curve LECCurve; 
L23:    aload_2 
L24:    getfield Field ECDomainParameters curve LECCurve; 
L27:    invokevirtual Method ECCurve equals (LECCurve;)Z 
L30:    ifeq L79 
L33:    aload_0 
L34:    getfield Field ECDomainParameters G LECPoint; 
L37:    aload_2 
L38:    getfield Field ECDomainParameters G LECPoint; 
L41:    invokevirtual Method ECPoint equals (LECPoint;)Z 
L44:    ifeq L79 
L47:    aload_0 
L48:    getfield Field ECDomainParameters n Ljava/math/BigInteger; 
L51:    aload_2 
L52:    getfield Field ECDomainParameters n Ljava/math/BigInteger; 
L55:    invokevirtual Method java/math/BigInteger equals (Ljava/lang/Object;)Z 
L58:    ifeq L79 
L61:    aload_0 
L62:    getfield Field ECDomainParameters h Ljava/math/BigInteger; 
L65:    aload_2 
L66:    getfield Field ECDomainParameters h Ljava/math/BigInteger; 
L69:    invokevirtual Method java/math/BigInteger equals (Ljava/lang/Object;)Z 
L72:    ifeq L79 
L75:    iconst_1 
L76:    goto L80 

        .stack append Object ECDomainParameters 
L79:    iconst_0 

        .stack stack_1 Integer 
L80:    ireturn 

        .stack stack_1 Object java/lang/CloneNotSupportedException 
L81:    astore_3 
L82:    aload_3 
L83:    invokevirtual Method java/lang/CloneNotSupportedException printStackTrace ()V 

        .stack chop 1 
L86:    iconst_0 
L87:    ireturn 
L88:    
        .linenumbertable 
            L0 48 
            L5 50 
            L7 53 
            L14 55 
            L19 58 
            L81 59 
            L82 60 
            L86 64 
        .end linenumbertable 
        .localvariabletable 
            3 is e Ljava/lang/CloneNotSupportedException; from L82 to L86 
            2 is other LECDomainParameters; from L19 to L86 
            0 is this LECDomainParameters; from L0 to L88 
            1 is obj Ljava/lang/Object; from L0 to L88 
        .end localvariabletable 
    .end code 
.end method 

.method public hashCode : ()I 
    .code stack 2 locals 2 
L0:     aload_0 
L1:     getfield Field ECDomainParameters curve LECCurve; 
L4:     invokevirtual Method ECCurve hashCode ()I 
L7:     istore_1 
L8:     iload_1 
L9:     bipush 37 
L11:    imul 
L12:    istore_1 
L13:    iload_1 
L14:    aload_0 
L15:    getfield Field ECDomainParameters G LECPoint; 
L18:    invokevirtual Method ECPoint hashCode ()I 
L21:    ixor 
L22:    istore_1 
L23:    iload_1 
L24:    bipush 37 
L26:    imul 
L27:    istore_1 
L28:    iload_1 
L29:    aload_0 
L30:    getfield Field ECDomainParameters n Ljava/math/BigInteger; 
L33:    invokevirtual Method java/math/BigInteger hashCode ()I 
L36:    ixor 
L37:    istore_1 
L38:    iload_1 
L39:    bipush 37 
L41:    imul 
L42:    istore_1 
L43:    iload_1 
L44:    aload_0 
L45:    getfield Field ECDomainParameters h Ljava/math/BigInteger; 
L48:    invokevirtual Method java/math/BigInteger hashCode ()I 
L51:    ixor 
L52:    istore_1 
L53:    iload_1 
L54:    ireturn 
L55:    
        .linenumbertable 
            L0 69 
            L8 70 
            L13 71 
            L23 72 
            L28 73 
            L38 74 
            L43 75 
            L53 76 
        .end linenumbertable 
        .localvariabletable 
            0 is this LECDomainParameters; from L0 to L55 
            1 is hc I from L8 to L55 
        .end localvariabletable 
    .end code 
.end method 

.method private static validate : (LECCurve;LECPoint;)LECPoint; 
    .code stack 3 locals 2 
L0:     aload_1 
L1:     ifnonnull L14 
L4:     new java/lang/IllegalArgumentException 
L7:     dup 
L8:     ldc 'Point has null value' 
L10:    invokespecial Method java/lang/IllegalArgumentException <init> (Ljava/lang/String;)V 
L13:    athrow 

        .stack same 
L14:    aload_0 
L15:    aload_1 
L16:    invokestatic Method ECAlgorithms importPoint (LECCurve;LECPoint;)LECPoint; 
L19:    invokevirtual Method ECPoint normalize ()LECPoint; 
L22:    astore_1 
L23:    aload_1 
L24:    invokevirtual Method ECPoint isInfinity ()Z 
L27:    ifeq L40 
L30:    new java/lang/IllegalArgumentException 
L33:    dup 
L34:    ldc 'Point at infinity' 
L36:    invokespecial Method java/lang/IllegalArgumentException <init> (Ljava/lang/String;)V 
L39:    athrow 

        .stack same 
L40:    aload_1 
L41:    invokevirtual Method ECPoint isValid ()Z 
L44:    ifeq L57 
L47:    new java/lang/IllegalArgumentException 
L50:    dup 
L51:    ldc 'Point not on curve' 
L53:    invokespecial Method java/lang/IllegalArgumentException <init> (Ljava/lang/String;)V 
L56:    athrow 

        .stack same 
L57:    aload_1 
L58:    areturn 
L59:    
        .linenumbertable 
            L0 80 
            L4 82 
            L14 85 
            L23 87 
            L30 89 
            L40 92 
            L47 94 
            L57 97 
        .end linenumbertable 
        .localvariabletable 
            0 is c LECCurve; from L0 to L59 
            1 is q LECPoint; from L0 to L59 
        .end localvariabletable 
    .end code 
    .exceptions java/lang/CloneNotSupportedException 
.end method 
.sourcefile 'ECDomainParameters.java' 
.end class 
