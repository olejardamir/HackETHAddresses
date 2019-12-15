.version 52 0 
.class public super ASN1Integer 
.super ASN1Primitive 
.field private final bytes [B 

.method public <init> : (Ljava/math/BigInteger;)V 
    .code stack 2 locals 2 
L0:     aload_0 
L1:     invokespecial Method ASN1Primitive <init> ()V 
L4:     aload_0 
L5:     aload_1 
L6:     invokevirtual Method java/math/BigInteger toByteArray ()[B 
L9:     putfield Field ASN1Integer bytes [B 
L12:    return 
L13:    
        .linenumbertable 
            L0 13 
            L4 14 
            L12 15 
        .end linenumbertable 
        .localvariabletable 
            0 is this LASN1Integer; from L0 to L13 
            1 is value Ljava/math/BigInteger; from L0 to L13 
        .end localvariabletable 
    .end code 
.end method 

.method private getValue : ()Ljava/math/BigInteger; 
    .code stack 3 locals 1 
L0:     new java/math/BigInteger 
L3:     dup 
L4:     aload_0 
L5:     getfield Field ASN1Integer bytes [B 
L8:     invokespecial Method java/math/BigInteger <init> ([B)V 
L11:    areturn 
L12:    
        .linenumbertable 
            L0 19 
        .end linenumbertable 
        .localvariabletable 
            0 is this LASN1Integer; from L0 to L12 
        .end localvariabletable 
    .end code 
.end method 

.method encodedLength : ()I 
    .code stack 2 locals 1 
L0:     iconst_1 
L1:     aload_0 
L2:     getfield Field ASN1Integer bytes [B 
L5:     arraylength 
L6:     invokestatic Method StreamUtil calculateBodyLength (I)I 
L9:     iadd 
L10:    aload_0 
L11:    getfield Field ASN1Integer bytes [B 
L14:    arraylength 
L15:    iadd 
L16:    ireturn 
L17:    
        .linenumbertable 
            L0 24 
        .end linenumbertable 
        .localvariabletable 
            0 is this LASN1Integer; from L0 to L17 
        .end localvariabletable 
    .end code 
.end method 

.method encode : (LASN1OutputStream;)V 
    .code stack 3 locals 2 
L0:     aload_1 
L1:     iconst_2 
L2:     aload_0 
L3:     getfield Field ASN1Integer bytes [B 
L6:     invokevirtual Method ASN1OutputStream writeEncoded (I[B)V 
L9:     return 
L10:    
        .linenumbertable 
            L0 31 
            L9 32 
        .end linenumbertable 
        .localvariabletable 
            0 is this LASN1Integer; from L0 to L10 
            1 is out LASN1OutputStream; from L0 to L10 
        .end localvariabletable 
    .end code 
    .exceptions java/lang/Exception 
.end method 

.method public hashCode : ()I 
    .code stack 4 locals 3 
L0:     iconst_0 
L1:     istore_1 
L2:     iconst_0 
L3:     istore_2 

        .stack append Integer Integer 
L4:     iload_2 
L5:     aload_0 
L6:     getfield Field ASN1Integer bytes [B 
L9:     arraylength 
L10:    if_icmpeq L36 
L13:    iload_1 
L14:    aload_0 
L15:    getfield Field ASN1Integer bytes [B 
L18:    iload_2 
L19:    baload 
L20:    sipush 255 
L23:    iand 
L24:    iload_2 
L25:    iconst_4 
L26:    irem 
L27:    ishl 
L28:    ixor 
L29:    istore_1 
L30:    iinc 2 1 
L33:    goto L4 

        .stack chop 1 
L36:    iload_1 
L37:    ireturn 
L38:    
        .linenumbertable 
            L0 36 
            L2 38 
            L13 40 
            L30 38 
            L36 43 
        .end linenumbertable 
        .localvariabletable 
            2 is i I from L4 to L36 
            0 is this LASN1Integer; from L0 to L38 
            1 is value I from L2 to L38 
        .end localvariabletable 
    .end code 
.end method 

.method asn1Equals : (LASN1Primitive;)Z 
    .code stack 2 locals 3 
L0:     aload_1 
L1:     instanceof ASN1Integer 
L4:     ifne L9 
L7:     iconst_0 
L8:     ireturn 

        .stack same 
L9:     aload_1 
L10:    checkcast ASN1Integer 
L13:    astore_2 
L14:    aload_0 
L15:    getfield Field ASN1Integer bytes [B 
L18:    aload_2 
L19:    getfield Field ASN1Integer bytes [B 
L22:    invokestatic Method Arrays areEqual ([B[B)Z 
L25:    ireturn 
L26:    
        .linenumbertable 
            L0 49 
            L7 51 
            L9 54 
            L14 56 
        .end linenumbertable 
        .localvariabletable 
            0 is this LASN1Integer; from L0 to L26 
            1 is o LASN1Primitive; from L0 to L26 
            2 is other LASN1Integer; from L14 to L26 
        .end localvariabletable 
    .end code 
.end method 

.method public toString : ()Ljava/lang/String; 
    .code stack 1 locals 1 
L0:     aload_0 
L1:     invokespecial Method ASN1Integer getValue ()Ljava/math/BigInteger; 
L4:     invokevirtual Method java/math/BigInteger toString ()Ljava/lang/String; 
L7:     areturn 
L8:     
        .linenumbertable 
            L0 61 
        .end linenumbertable 
        .localvariabletable 
            0 is this LASN1Integer; from L0 to L8 
        .end localvariabletable 
    .end code 
.end method 
.sourcefile 'ASN1Integer.java' 
.end class 
