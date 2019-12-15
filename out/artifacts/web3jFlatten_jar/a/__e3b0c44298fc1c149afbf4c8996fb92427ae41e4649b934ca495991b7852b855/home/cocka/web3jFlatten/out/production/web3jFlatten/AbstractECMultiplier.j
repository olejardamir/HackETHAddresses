.version 52 0 
.class super abstract AbstractECMultiplier 
.super java/lang/Object 

.method <init> : ()V 
    .code stack 1 locals 1 
L0:     aload_0 
L1:     invokespecial Method java/lang/Object <init> ()V 
L4:     return 
L5:     
        .linenumbertable 
            L0 4 
        .end linenumbertable 
        .localvariabletable 
            0 is this LAbstractECMultiplier; from L0 to L5 
        .end localvariabletable 
    .end code 
.end method 

.method public multiply : (LECPoint;Ljava/math/BigInteger;)LECPoint; 
    .code stack 3 locals 6 
L0:     aload_2 
L1:     invokevirtual Method java/math/BigInteger signum ()I 
L4:     istore_3 
L5:     iload_3 
L6:     ifeq L16 
L9:     aload_1 
L10:    invokevirtual Method ECPoint isInfinity ()Z 
L13:    ifeq L24 

        .stack append Integer 
L16:    aload_1 
L17:    invokevirtual Method ECPoint getCurve ()LECCurve; 
L20:    invokevirtual Method ECCurve getInfinity ()LECPoint; 
L23:    areturn 

        .stack same 
L24:    aload_0 
L25:    aload_1 
L26:    aload_2 
L27:    invokevirtual Method java/math/BigInteger abs ()Ljava/math/BigInteger; 
L30:    invokevirtual Method AbstractECMultiplier multiplyPositive (LECPoint;Ljava/math/BigInteger;)LECPoint; 
L33:    astore 4 
L35:    iload_3 
L36:    ifle L44 
L39:    aload 4 
L41:    goto L49 

        .stack append Object ECPoint 
L44:    aload 4 
L46:    invokevirtual Method ECPoint negate ()LECPoint; 

        .stack stack_1 Object ECPoint 
L49:    astore 5 
L51:    aload_0 
L52:    aload 5 
L54:    invokespecial Method AbstractECMultiplier checkResult (LECPoint;)LECPoint; 
L57:    areturn 
L58:    
        .linenumbertable 
            L0 6 
            L5 7 
            L16 9 
            L24 12 
            L35 13 
            L51 16 
        .end linenumbertable 
        .localvariabletable 
            0 is this LAbstractECMultiplier; from L0 to L58 
            1 is p LECPoint; from L0 to L58 
            2 is k Ljava/math/BigInteger; from L0 to L58 
            3 is sign I from L5 to L58 
            4 is positive LECPoint; from L35 to L58 
            5 is result LECPoint; from L51 to L58 
        .end localvariabletable 
    .end code 
    .exceptions java/lang/CloneNotSupportedException 
.end method 

.method protected abstract multiplyPositive : (LECPoint;Ljava/math/BigInteger;)LECPoint; 
    .exceptions java/lang/CloneNotSupportedException 
.end method 

.method private checkResult : (LECPoint;)LECPoint; 
    .code stack 1 locals 2 
L0:     aload_1 
L1:     invokestatic Method ECAlgorithms implCheckResult (LECPoint;)LECPoint; 
L4:     areturn 
L5:     
        .linenumbertable 
            L0 22 
        .end linenumbertable 
        .localvariabletable 
            0 is this LAbstractECMultiplier; from L0 to L5 
            1 is p LECPoint; from L0 to L5 
        .end localvariabletable 
    .end code 
    .exceptions java/lang/CloneNotSupportedException 
.end method 
.sourcefile 'AbstractECMultiplier.java' 
.end class 
