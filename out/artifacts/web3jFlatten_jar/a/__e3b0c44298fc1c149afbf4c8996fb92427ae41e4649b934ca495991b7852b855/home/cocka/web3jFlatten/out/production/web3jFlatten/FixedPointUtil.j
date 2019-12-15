.version 52 0 
.class super FixedPointUtil 
.super java/lang/Object 
.field private static final PRECOMP_NAME Ljava/lang/String; = 'bc_fixed_point' 

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
            0 is this LFixedPointUtil; from L0 to L5 
        .end localvariabletable 
    .end code 
.end method 

.method public static getCombSize : (LECCurve;)I 
    .code stack 2 locals 2 
L0:     aload_0 
L1:     invokevirtual Method ECCurve getOrder ()Ljava/math/BigInteger; 
L4:     astore_1 
L5:     aload_1 
L6:     ifnonnull L18 
L9:     aload_0 
L10:    invokevirtual Method ECCurve getFieldSize ()I 
L13:    iconst_1 
L14:    iadd 
L15:    goto L22 

        .stack append Object java/math/BigInteger 
L18:    aload_1 
L19:    invokevirtual Method java/math/BigInteger bitLength ()I 

        .stack stack_1 Integer 
L22:    ireturn 
L23:    
        .linenumbertable 
            L0 10 
            L5 11 
        .end linenumbertable 
        .localvariabletable 
            0 is c LECCurve; from L0 to L23 
            1 is order Ljava/math/BigInteger; from L5 to L23 
        .end localvariabletable 
    .end code 
.end method 

.method public static precompute : (LECPoint;)LFixedPointPreCompInfo; 
    .code stack 7 locals 2 
L0:     aload_0 
L1:     invokevirtual Method ECPoint getCurve ()LECCurve; 
L4:     astore_1 
L5:     aload_1 
L6:     aload_0 
L7:     ldc 'bc_fixed_point' 
L9:     new FixedPointUtil$1 
L12:    dup 
L13:    aload_1 
L14:    aload_0 
L15:    invokespecial Method FixedPointUtil$1 <init> (LECCurve;LECPoint;)V 
L18:    invokevirtual Method ECCurve precompute (LECPoint;Ljava/lang/String;LPreCompCallback;)LPreCompInfo; 
L21:    checkcast FixedPointPreCompInfo 
L24:    areturn 
L25:    
        .linenumbertable 
            L0 15 
            L5 17 
        .end linenumbertable 
        .localvariabletable 
            0 is p LECPoint; from L0 to L25 
            1 is c LECCurve; from L5 to L25 
        .end localvariabletable 
    .end code 
    .exceptions java/lang/CloneNotSupportedException 
.end method 
.sourcefile 'FixedPointUtil.java' 
.innerclasses 
    FixedPointUtil$1 [0] [0] static 
.end innerclasses 
.end class 
