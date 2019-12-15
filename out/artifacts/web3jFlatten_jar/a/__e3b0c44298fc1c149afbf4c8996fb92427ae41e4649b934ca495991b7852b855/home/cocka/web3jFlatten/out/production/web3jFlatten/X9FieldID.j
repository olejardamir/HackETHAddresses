.version 52 0 
.class super X9FieldID 
.super java/lang/Object 
.field private parameters LASN1Primitive; 

.method public <init> : (Ljava/math/BigInteger;)V 
    .code stack 4 locals 2 
L0:     aload_0 
L1:     invokespecial Method java/lang/Object <init> ()V 
L4:     aload_0 
L5:     new ASN1Integer 
L8:     dup 
L9:     aload_1 
L10:    invokespecial Method ASN1Integer <init> (Ljava/math/BigInteger;)V 
L13:    putfield Field X9FieldID parameters LASN1Primitive; 
L16:    return 
L17:    
        .linenumbertable 
            L0 10 
            L4 11 
            L16 12 
        .end linenumbertable 
        .localvariabletable 
            0 is this LX9FieldID; from L0 to L17 
            1 is primeP Ljava/math/BigInteger; from L0 to L17 
        .end localvariabletable 
    .end code 
.end method 

.method private toASN1Primitive : ()LASN1Primitive; 
    .code stack 3 locals 2 
L0:     new ASN1EncodableVector 
L3:     dup 
L4:     invokespecial Method ASN1EncodableVector <init> ()V 
L7:     astore_1 
L8:     aload_1 
L9:     aload_0 
L10:    getfield Field X9FieldID parameters LASN1Primitive; 
L13:    invokevirtual Method ASN1EncodableVector add (LASN1Encodable;)V 
L16:    new DERSequence 
L19:    dup 
L20:    aload_1 
L21:    invokespecial Method DERSequence <init> (LASN1EncodableVector;)V 
L24:    areturn 
L25:    
        .linenumbertable 
            L0 17 
            L8 19 
            L16 21 
        .end linenumbertable 
        .localvariabletable 
            0 is this LX9FieldID; from L0 to L25 
            1 is v LASN1EncodableVector; from L8 to L25 
        .end localvariabletable 
    .end code 
.end method 

.method public hashCode : ()I 
    .code stack 1 locals 1 
L0:     aload_0 
L1:     invokespecial Method X9FieldID toASN1Primitive ()LASN1Primitive; 
L4:     invokevirtual Method ASN1Primitive hashCode ()I 
L7:     ireturn 
L8:     
        .linenumbertable 
            L0 26 
        .end linenumbertable 
        .localvariabletable 
            0 is this LX9FieldID; from L0 to L8 
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
L8:     instanceof X9FieldID 
L11:    ifne L16 
L14:    iconst_0 
L15:    ireturn 

        .stack same 
L16:    aload_1 
L17:    checkcast X9FieldID 
L20:    astore_2 
L21:    aload_0 
L22:    invokespecial Method X9FieldID toASN1Primitive ()LASN1Primitive; 
L25:    aload_2 
L26:    invokespecial Method X9FieldID toASN1Primitive ()LASN1Primitive; 
L29:    invokevirtual Method ASN1Primitive equals (Ljava/lang/Object;)Z 
L32:    ireturn 
L33:    
        .linenumbertable 
            L0 32 
            L5 34 
            L7 37 
            L14 39 
            L16 42 
            L21 44 
        .end linenumbertable 
        .localvariabletable 
            0 is this LX9FieldID; from L0 to L33 
            1 is o Ljava/lang/Object; from L0 to L33 
            2 is other LX9FieldID; from L21 to L33 
        .end localvariabletable 
    .end code 
.end method 
.sourcefile 'X9FieldID.java' 
.end class 
