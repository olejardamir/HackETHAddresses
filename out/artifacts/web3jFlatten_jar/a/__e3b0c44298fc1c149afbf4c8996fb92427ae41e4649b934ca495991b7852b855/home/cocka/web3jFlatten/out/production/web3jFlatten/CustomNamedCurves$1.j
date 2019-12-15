.version 52 0 
.class final super CustomNamedCurves$1 
.super X9ECParametersHolder 

.method <init> : ()V 
    .code stack 1 locals 1 
L0:     aload_0 
L1:     invokespecial Method X9ECParametersHolder <init> ()V 
L4:     return 
L5:     
        .linenumbertable 
            L0 13 
        .end linenumbertable 
        .localvariabletable 
            0 is this LCustomNamedCurves$1; from L0 to L5 
        .end localvariabletable 
    .end code 
.end method 

.method protected createParameters : ()LX9ECParameters; 
    .code stack 7 locals 3 
L0:     new SecP256K1Curve 
L3:     dup 
L4:     invokespecial Method SecP256K1Curve <init> ()V 
L7:     invokestatic Method CustomNamedCurves access$000 (LECCurve;)LECCurve; 
L10:    astore_1 
L11:    new X9ECPoint 
L14:    dup 
L15:    aload_1 
L16:    ldc '0479BE667EF9DCBBAC55A06295CE870B07029BFCDB2DCE28D959F2815B16F81798483ADA7726A3C4655DA4FBFC0E1108A8FD17B448A68554199C47D08FFB10D4B8' 
L18:    invokestatic Method Hex decode (Ljava/lang/String;)[B 
L21:    invokespecial Method X9ECPoint <init> (LECCurve;[B)V 
L24:    astore_2 
L25:    new X9ECParameters 
L28:    dup 
L29:    aload_1 
L30:    aload_2 
L31:    aload_1 
L32:    invokevirtual Method ECCurve getOrder ()Ljava/math/BigInteger; 
L35:    aload_1 
L36:    invokevirtual Method ECCurve getCofactor ()Ljava/math/BigInteger; 
L39:    aconst_null 
L40:    invokespecial Method X9ECParameters <init> (LECCurve;LX9ECPoint;Ljava/math/BigInteger;Ljava/math/BigInteger;[B)V 
L43:    areturn 
L44:    
        .linenumbertable 
            L0 15 
            L11 16 
            L25 19 
        .end linenumbertable 
        .localvariabletable 
            0 is this LCustomNamedCurves$1; from L0 to L44 
            1 is curve LECCurve; from L11 to L44 
            2 is G LX9ECPoint; from L25 to L44 
        .end localvariabletable 
    .end code 
    .exceptions java/lang/Exception 
.end method 
.sourcefile 'CustomNamedCurves.java' 
.enclosing method CustomNamedCurves [0] 
.innerclasses 
    CustomNamedCurves$1 [0] [0] static 
.end innerclasses 
.end class 
