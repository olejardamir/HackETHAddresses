.version 52 0 
.class public super abstract ECFieldElement 
.super java/lang/Object 
.implements ECConstants 

.method <init> : ()V 
    .code stack 1 locals 1 
L0:     aload_0 
L1:     invokespecial Method java/lang/Object <init> ()V 
L4:     return 
L5:     
        .linenumbertable 
            L0 5 
            L4 7 
        .end linenumbertable 
        .localvariabletable 
            0 is this LECFieldElement; from L0 to L5 
        .end localvariabletable 
    .end code 
.end method 

.method public abstract toBigInteger : ()Ljava/math/BigInteger; 
.end method 

.method public abstract getFieldSize : ()I 
.end method 

.method public abstract add : (LECFieldElement;)LECFieldElement; 
.end method 

.method public abstract multiply : (LECFieldElement;)LECFieldElement; 
.end method 

.method public abstract negate : ()LECFieldElement; 
.end method 

.method public abstract square : ()LECFieldElement; 
.end method 

.method public abstract invert : ()LECFieldElement; 
.end method 

.method public abstract sqrt : ()LECFieldElement; 
.end method 

.method public bitLength : ()I 
    .code stack 1 locals 1 
L0:     aload_0 
L1:     invokevirtual Method ECFieldElement toBigInteger ()Ljava/math/BigInteger; 
L4:     invokevirtual Method java/math/BigInteger bitLength ()I 
L7:     ireturn 
L8:     
        .linenumbertable 
            L0 26 
        .end linenumbertable 
        .localvariabletable 
            0 is this LECFieldElement; from L0 to L8 
        .end localvariabletable 
    .end code 
.end method 

.method public isOne : ()Z 
    .code stack 2 locals 1 
L0:     aload_0 
L1:     invokevirtual Method ECFieldElement bitLength ()I 
L4:     iconst_1 
L5:     if_icmpne L12 
L8:     iconst_1 
L9:     goto L13 

        .stack same 
L12:    iconst_0 

        .stack stack_1 Integer 
L13:    ireturn 
L14:    
        .linenumbertable 
            L0 30 
        .end linenumbertable 
        .localvariabletable 
            0 is this LECFieldElement; from L0 to L14 
        .end localvariabletable 
    .end code 
.end method 

.method public isZero : ()Z 
    .code stack 2 locals 1 
L0:     iconst_0 
L1:     aload_0 
L2:     invokevirtual Method ECFieldElement toBigInteger ()Ljava/math/BigInteger; 
L5:     invokevirtual Method java/math/BigInteger signum ()I 
L8:     if_icmpne L15 
L11:    iconst_1 
L12:    goto L16 

        .stack same 
L15:    iconst_0 

        .stack stack_1 Integer 
L16:    ireturn 
L17:    
        .linenumbertable 
            L0 34 
        .end linenumbertable 
        .localvariabletable 
            0 is this LECFieldElement; from L0 to L17 
        .end localvariabletable 
    .end code 
.end method 

.method public testBitZero : ()Z 
    .code stack 2 locals 1 
L0:     aload_0 
L1:     invokevirtual Method ECFieldElement toBigInteger ()Ljava/math/BigInteger; 
L4:     iconst_0 
L5:     invokevirtual Method java/math/BigInteger testBit (I)Z 
L8:     ireturn 
L9:     
        .linenumbertable 
            L0 39 
        .end linenumbertable 
        .localvariabletable 
            0 is this LECFieldElement; from L0 to L9 
        .end localvariabletable 
    .end code 
.end method 

.method public toString : ()Ljava/lang/String; 
    .code stack 2 locals 1 
L0:     aload_0 
L1:     invokevirtual Method ECFieldElement toBigInteger ()Ljava/math/BigInteger; 
L4:     bipush 16 
L6:     invokevirtual Method java/math/BigInteger toString (I)Ljava/lang/String; 
L9:     areturn 
L10:    
        .linenumbertable 
            L0 43 
        .end linenumbertable 
        .localvariabletable 
            0 is this LECFieldElement; from L0 to L10 
        .end localvariabletable 
    .end code 
.end method 

.method public getEncoded : ()[B 
    .code stack 2 locals 1 
L0:     aload_0 
L1:     invokevirtual Method ECFieldElement getFieldSize ()I 
L4:     bipush 7 
L6:     iadd 
L7:     bipush 8 
L9:     idiv 
L10:    aload_0 
L11:    invokevirtual Method ECFieldElement toBigInteger ()Ljava/math/BigInteger; 
L14:    invokestatic Method BigIntegers asUnsignedByteArray (ILjava/math/BigInteger;)[B 
L17:    areturn 
L18:    
        .linenumbertable 
            L0 47 
        .end linenumbertable 
        .localvariabletable 
            0 is this LECFieldElement; from L0 to L18 
        .end localvariabletable 
    .end code 
.end method 
.sourcefile 'ECFieldElement.java' 
.innerclasses 
    ECFieldElement$AbstractFp ECFieldElement AbstractFp static abstract 
.end innerclasses 
.end class 
