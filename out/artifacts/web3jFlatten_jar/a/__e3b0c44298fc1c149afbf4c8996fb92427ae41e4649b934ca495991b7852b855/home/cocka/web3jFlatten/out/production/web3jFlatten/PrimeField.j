.version 52 0 
.class super PrimeField 
.super GenericPolynomialExtensionField 
.field private final characteristic Ljava/math/BigInteger; 

.method <init> : (Ljava/math/BigInteger;)V 
    .code stack 2 locals 2 
L0:     aload_0 
L1:     invokespecial Method GenericPolynomialExtensionField <init> ()V 
L4:     aload_0 
L5:     aload_1 
L6:     putfield Field PrimeField characteristic Ljava/math/BigInteger; 
L9:     return 
L10:    
        .linenumbertable 
            L0 9 
            L4 10 
            L9 11 
        .end linenumbertable 
        .localvariabletable 
            0 is this LPrimeField; from L0 to L10 
            1 is characteristic Ljava/math/BigInteger; from L0 to L10 
        .end localvariabletable 
    .end code 
.end method 

.method public getCharacteristic : ()Ljava/math/BigInteger; 
    .code stack 1 locals 1 
L0:     aload_0 
L1:     getfield Field PrimeField characteristic Ljava/math/BigInteger; 
L4:     areturn 
L5:     
        .linenumbertable 
            L0 15 
        .end linenumbertable 
        .localvariabletable 
            0 is this LPrimeField; from L0 to L5 
        .end localvariabletable 
    .end code 
.end method 

.method public equals : (Ljava/lang/Object;)Z 
    .code stack 2 locals 3 
L0:     aload_0 
L1:     aload_1 
L2:     if_acmpne L7 
L5:     iconst_1 
L6:     ireturn 

        .stack same 
L7:     aload_1 
L8:     instanceof PrimeField 
L11:    ifne L16 
L14:    iconst_0 
L15:    ireturn 

        .stack same 
L16:    aload_1 
L17:    checkcast PrimeField 
L20:    astore_2 
L21:    aload_0 
L22:    getfield Field PrimeField characteristic Ljava/math/BigInteger; 
L25:    aload_2 
L26:    getfield Field PrimeField characteristic Ljava/math/BigInteger; 
L29:    invokevirtual Method java/math/BigInteger equals (Ljava/lang/Object;)Z 
L32:    ireturn 
L33:    
        .linenumbertable 
            L0 22 
            L5 24 
            L7 26 
            L14 28 
            L16 30 
            L21 31 
        .end linenumbertable 
        .localvariabletable 
            0 is this LPrimeField; from L0 to L33 
            1 is obj Ljava/lang/Object; from L0 to L33 
            2 is other LPrimeField; from L21 to L33 
        .end localvariabletable 
    .end code 
.end method 

.method public hashCode : ()I 
    .code stack 1 locals 1 
L0:     aload_0 
L1:     getfield Field PrimeField characteristic Ljava/math/BigInteger; 
L4:     invokevirtual Method java/math/BigInteger hashCode ()I 
L7:     ireturn 
L8:     
        .linenumbertable 
            L0 36 
        .end linenumbertable 
        .localvariabletable 
            0 is this LPrimeField; from L0 to L8 
        .end localvariabletable 
    .end code 
.end method 
.sourcefile 'PrimeField.java' 
.end class 
