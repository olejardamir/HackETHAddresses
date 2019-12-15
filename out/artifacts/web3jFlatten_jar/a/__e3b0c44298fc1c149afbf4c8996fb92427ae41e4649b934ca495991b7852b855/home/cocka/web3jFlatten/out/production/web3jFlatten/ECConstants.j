.version 52 0 
.class interface abstract ECConstants 
.super java/lang/Object 
.field public static final ZERO Ljava/math/BigInteger; 
.field public static final ONE Ljava/math/BigInteger; 

.method static <clinit> : ()V 
    .code stack 2 locals 0 
L0:     lconst_0 
L1:     invokestatic Method java/math/BigInteger valueOf (J)Ljava/math/BigInteger; 
L4:     putstatic Field ECConstants ZERO Ljava/math/BigInteger; 
L7:     lconst_1 
L8:     invokestatic Method java/math/BigInteger valueOf (J)Ljava/math/BigInteger; 
L11:    putstatic Field ECConstants ONE Ljava/math/BigInteger; 
L14:    return 
L15:    
        .linenumbertable 
            L0 6 
            L7 7 
        .end linenumbertable 
    .end code 
.end method 
.sourcefile 'ECConstants.java' 
.end class 
