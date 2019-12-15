.version 52 0 
.class super abstract FiniteFields 
.super java/lang/Object 
.field static final GF_2 LPrimeField; 
.field private static final GF_3 LPrimeField; 

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
            0 is this LFiniteFields; from L0 to L5 
        .end localvariabletable 
    .end code 
.end method 

.method public static getPrimeField : (Ljava/math/BigInteger;)LGenericPolynomialExtensionField; 
    .code stack 3 locals 2 
L0:     aload_0 
L1:     invokevirtual Method java/math/BigInteger bitLength ()I 
L4:     istore_1 
L5:     aload_0 
L6:     invokevirtual Method java/math/BigInteger signum ()I 
L9:     ifle L69 
L12:    iload_1 
L13:    iconst_2 
L14:    if_icmplt L69 
L17:    iload_1 
L18:    iconst_3 
L19:    if_icmpge L60 
L22:    aload_0 
L23:    invokevirtual Method java/math/BigInteger intValue ()I 
L26:    lookupswitch 
            2 : L56 
            3 : L52 
            default : L60 


        .stack append Integer 
L52:    getstatic Field FiniteFields GF_3 LPrimeField; 
L55:    areturn 

        .stack same 
L56:    getstatic Field FiniteFields GF_2 LPrimeField; 
L59:    areturn 

        .stack same 
L60:    new PrimeField 
L63:    dup 
L64:    aload_0 
L65:    invokespecial Method PrimeField <init> (Ljava/math/BigInteger;)V 
L68:    areturn 

        .stack same 
L69:    aconst_null 
L70:    areturn 
L71:    
        .linenumbertable 
            L0 13 
            L5 14 
            L17 15 
            L22 16 
            L52 18 
            L56 21 
            L60 25 
            L69 27 
        .end linenumbertable 
        .localvariabletable 
            0 is a Ljava/math/BigInteger; from L0 to L71 
            1 is i I from L5 to L71 
        .end localvariabletable 
    .end code 
.end method 

.method static <clinit> : ()V 
    .code stack 4 locals 0 
L0:     new PrimeField 
L3:     dup 
L4:     ldc2_w 2L 
L7:     invokestatic Method java/math/BigInteger valueOf (J)Ljava/math/BigInteger; 
L10:    invokespecial Method PrimeField <init> (Ljava/math/BigInteger;)V 
L13:    putstatic Field FiniteFields GF_2 LPrimeField; 
L16:    new PrimeField 
L19:    dup 
L20:    ldc2_w 3L 
L23:    invokestatic Method java/math/BigInteger valueOf (J)Ljava/math/BigInteger; 
L26:    invokespecial Method PrimeField <init> (Ljava/math/BigInteger;)V 
L29:    putstatic Field FiniteFields GF_3 LPrimeField; 
L32:    return 
L33:    
        .linenumbertable 
            L0 6 
            L16 7 
        .end linenumbertable 
    .end code 
.end method 
.sourcefile 'FiniteFields.java' 
.end class 
