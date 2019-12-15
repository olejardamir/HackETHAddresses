.version 52 0 
.class public super abstract ASN1Object 
.super java/lang/Object 
.implements ASN1Encodable 

.method public <init> : ()V 
    .code stack 1 locals 1 
L0:     aload_0 
L1:     invokespecial Method java/lang/Object <init> ()V 
L4:     return 
L5:     
        .linenumbertable 
            L0 4 
        .end linenumbertable 
        .localvariabletable 
            0 is this LASN1Object; from L0 to L5 
        .end localvariabletable 
    .end code 
.end method 

.method public hashCode : ()I 
    .code stack 1 locals 1 
L0:     aload_0 
L1:     invokevirtual Method ASN1Object toASN1Primitive ()LASN1Primitive; 
L4:     invokevirtual Method ASN1Primitive hashCode ()I 
L7:     ireturn 
L8:     
        .linenumbertable 
            L0 10 
        .end linenumbertable 
        .localvariabletable 
            0 is this LASN1Object; from L0 to L8 
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
L8:     instanceof ASN1Encodable 
L11:    ifne L16 
L14:    iconst_0 
L15:    ireturn 

        .stack same 
L16:    aload_1 
L17:    checkcast ASN1Encodable 
L20:    astore_2 
L21:    aload_0 
L22:    invokevirtual Method ASN1Object toASN1Primitive ()LASN1Primitive; 
L25:    aload_2 
L26:    invokeinterface InterfaceMethod ASN1Encodable toASN1Primitive ()LASN1Primitive; 1 
L31:    invokevirtual Method ASN1Primitive equals (Ljava/lang/Object;)Z 
L34:    ireturn 
L35:    
        .linenumbertable 
            L0 16 
            L5 18 
            L7 21 
            L14 23 
            L16 26 
            L21 28 
        .end linenumbertable 
        .localvariabletable 
            0 is this LASN1Object; from L0 to L35 
            1 is o Ljava/lang/Object; from L0 to L35 
            2 is other LASN1Encodable; from L21 to L35 
        .end localvariabletable 
    .end code 
.end method 

.method public abstract toASN1Primitive : ()LASN1Primitive; 
.end method 
.sourcefile 'ASN1Object.java' 
.end class 
