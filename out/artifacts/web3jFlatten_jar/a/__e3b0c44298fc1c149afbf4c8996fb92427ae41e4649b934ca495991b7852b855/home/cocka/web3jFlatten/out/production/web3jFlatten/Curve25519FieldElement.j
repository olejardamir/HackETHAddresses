.version 52 0 
.class public super Curve25519FieldElement 
.super ECFieldElement$AbstractFp 
.field private static final Q Ljava/math/BigInteger; 
.field x [I 

.method <init> : ([I)V 
    .code stack 2 locals 2 
L0:     aload_0 
L1:     invokespecial Method ECFieldElement$AbstractFp <init> ()V 
L4:     aload_0 
L5:     aload_1 
L6:     putfield Field Curve25519FieldElement x [I 
L9:     return 
L10:    
        .linenumbertable 
            L0 14 
            L4 15 
            L9 16 
        .end linenumbertable 
        .localvariabletable 
            0 is this LCurve25519FieldElement; from L0 to L10 
            1 is x [I from L0 to L10 
        .end localvariabletable 
    .end code 
.end method 

.method public toBigInteger : ()Ljava/math/BigInteger; 
    .code stack 1 locals 1 
L0:     aconst_null 
L1:     areturn 
L2:     
        .linenumbertable 
            L0 20 
        .end linenumbertable 
        .localvariabletable 
            0 is this LCurve25519FieldElement; from L0 to L2 
        .end localvariabletable 
    .end code 
.end method 

.method public getFieldSize : ()I 
    .code stack 1 locals 1 
L0:     iconst_0 
L1:     ireturn 
L2:     
        .linenumbertable 
            L0 24 
        .end linenumbertable 
        .localvariabletable 
            0 is this LCurve25519FieldElement; from L0 to L2 
        .end localvariabletable 
    .end code 
.end method 

.method public add : (LECFieldElement;)LECFieldElement; 
    .code stack 1 locals 2 
L0:     aconst_null 
L1:     areturn 
L2:     
        .linenumbertable 
            L0 28 
        .end linenumbertable 
        .localvariabletable 
            0 is this LCurve25519FieldElement; from L0 to L2 
            1 is b LECFieldElement; from L0 to L2 
        .end localvariabletable 
    .end code 
.end method 

.method public multiply : (LECFieldElement;)LECFieldElement; 
    .code stack 1 locals 2 
L0:     aconst_null 
L1:     areturn 
L2:     
        .linenumbertable 
            L0 32 
        .end linenumbertable 
        .localvariabletable 
            0 is this LCurve25519FieldElement; from L0 to L2 
            1 is b LECFieldElement; from L0 to L2 
        .end localvariabletable 
    .end code 
.end method 

.method public negate : ()LECFieldElement; 
    .code stack 1 locals 1 
L0:     aconst_null 
L1:     areturn 
L2:     
        .linenumbertable 
            L0 36 
        .end linenumbertable 
        .localvariabletable 
            0 is this LCurve25519FieldElement; from L0 to L2 
        .end localvariabletable 
    .end code 
.end method 

.method public square : ()LECFieldElement; 
    .code stack 1 locals 1 
L0:     aconst_null 
L1:     areturn 
L2:     
        .linenumbertable 
            L0 40 
        .end linenumbertable 
        .localvariabletable 
            0 is this LCurve25519FieldElement; from L0 to L2 
        .end localvariabletable 
    .end code 
.end method 

.method public invert : ()LECFieldElement; 
    .code stack 1 locals 1 
L0:     aconst_null 
L1:     areturn 
L2:     
        .linenumbertable 
            L0 44 
        .end linenumbertable 
        .localvariabletable 
            0 is this LCurve25519FieldElement; from L0 to L2 
        .end localvariabletable 
    .end code 
.end method 

.method public sqrt : ()LECFieldElement; 
    .code stack 1 locals 1 
L0:     aconst_null 
L1:     areturn 
L2:     
        .linenumbertable 
            L0 48 
        .end linenumbertable 
        .localvariabletable 
            0 is this LCurve25519FieldElement; from L0 to L2 
        .end localvariabletable 
    .end code 
.end method 

.method public isOne : ()Z 
    .code stack 1 locals 1 
L0:     aload_0 
L1:     getfield Field Curve25519FieldElement x [I 
L4:     invokestatic Method Nat256 isOne ([I)Z 
L7:     ireturn 
L8:     
        .linenumbertable 
            L0 53 
        .end linenumbertable 
        .localvariabletable 
            0 is this LCurve25519FieldElement; from L0 to L8 
        .end localvariabletable 
    .end code 
.end method 

.method public equals : (Ljava/lang/Object;)Z 
    .code stack 2 locals 3 
L0:     aload_1 
L1:     aload_0 
L2:     if_acmpne L7 
L5:     iconst_1 
L6:     ireturn 

        .stack same 
L7:     aload_1 
L8:     instanceof Curve25519FieldElement 
L11:    ifne L16 
L14:    iconst_0 
L15:    ireturn 

        .stack same 
L16:    aload_1 
L17:    checkcast Curve25519FieldElement 
L20:    astore_2 
L21:    aload_0 
L22:    getfield Field Curve25519FieldElement x [I 
L25:    aload_2 
L26:    getfield Field Curve25519FieldElement x [I 
L29:    invokestatic Method Nat256 eq ([I[I)Z 
L32:    ireturn 
L33:    
        .linenumbertable 
            L0 65 
            L5 67 
            L7 70 
            L14 72 
            L16 75 
            L21 76 
        .end linenumbertable 
        .localvariabletable 
            0 is this LCurve25519FieldElement; from L0 to L33 
            1 is other Ljava/lang/Object; from L0 to L33 
            2 is o LCurve25519FieldElement; from L21 to L33 
        .end localvariabletable 
    .end code 
.end method 

.method public hashCode : ()I 
    .code stack 4 locals 1 
L0:     getstatic Field Curve25519FieldElement Q Ljava/math/BigInteger; 
L3:     invokevirtual Method java/math/BigInteger hashCode ()I 
L6:     aload_0 
L7:     getfield Field Curve25519FieldElement x [I 
L10:    iconst_0 
L11:    bipush 8 
L13:    invokestatic Method Arrays hashCode ([III)I 
L16:    ixor 
L17:    ireturn 
L18:    
        .linenumbertable 
            L0 81 
        .end linenumbertable 
        .localvariabletable 
            0 is this LCurve25519FieldElement; from L0 to L18 
        .end localvariabletable 
    .end code 
.end method 

.method static <clinit> : ()V 
    .code stack 1 locals 0 
L0:     getstatic Field Curve25519 q Ljava/math/BigInteger; 
L3:     putstatic Field Curve25519FieldElement Q Ljava/math/BigInteger; 
L6:     return 
L7:     
        .linenumbertable 
            L0 5 
        .end linenumbertable 
    .end code 
.end method 
.sourcefile 'Curve25519FieldElement.java' 
.innerclasses 
    ECFieldElement$AbstractFp ECFieldElement AbstractFp static abstract 
.end innerclasses 
.end class 
