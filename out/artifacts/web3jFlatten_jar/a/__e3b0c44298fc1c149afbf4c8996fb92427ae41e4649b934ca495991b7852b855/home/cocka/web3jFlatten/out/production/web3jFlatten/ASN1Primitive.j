.version 52 0 
.class public super abstract ASN1Primitive 
.super ASN1Object 

.method <init> : ()V 
    .code stack 1 locals 1 
L0:     aload_0 
L1:     invokespecial Method ASN1Object <init> ()V 
L4:     return 
L5:     
        .linenumbertable 
            L0 6 
            L4 8 
        .end linenumbertable 
        .localvariabletable 
            0 is this LASN1Primitive; from L0 to L5 
        .end localvariabletable 
    .end code 
.end method 

.method public final equals : (Ljava/lang/Object;)Z 
    .code stack 2 locals 2 
L0:     aload_0 
L1:     aload_1 
L2:     if_acmpne L7 
L5:     iconst_1 
L6:     ireturn 

        .stack same 
L7:     aload_1 
L8:     instanceof ASN1Encodable 
L11:    ifeq L34 
L14:    aload_0 
L15:    aload_1 
L16:    checkcast ASN1Encodable 
L19:    invokeinterface InterfaceMethod ASN1Encodable toASN1Primitive ()LASN1Primitive; 1 
L24:    invokevirtual Method ASN1Primitive asn1Equals (LASN1Primitive;)Z 
L27:    ifeq L34 
L30:    iconst_1 
L31:    goto L35 

        .stack same 
L34:    iconst_0 

        .stack stack_1 Integer 
L35:    ireturn 
L36:    
        .linenumbertable 
            L0 12 
            L5 14 
            L7 17 
        .end linenumbertable 
        .localvariabletable 
            0 is this LASN1Primitive; from L0 to L36 
            1 is o Ljava/lang/Object; from L0 to L36 
        .end localvariabletable 
    .end code 
.end method 

.method public toASN1Primitive : ()LASN1Primitive; 
    .code stack 1 locals 1 
L0:     aload_0 
L1:     areturn 
L2:     
        .linenumbertable 
            L0 22 
        .end linenumbertable 
        .localvariabletable 
            0 is this LASN1Primitive; from L0 to L2 
        .end localvariabletable 
    .end code 
.end method 

.method toDERObject : ()LASN1Primitive; 
    .code stack 1 locals 1 
L0:     aload_0 
L1:     areturn 
L2:     
        .linenumbertable 
            L0 28 
        .end linenumbertable 
        .localvariabletable 
            0 is this LASN1Primitive; from L0 to L2 
        .end localvariabletable 
    .end code 
.end method 

.method public abstract hashCode : ()I 
.end method 

.method abstract encodedLength : ()I 
    .exceptions java/lang/Exception 
.end method 

.method abstract encode : (LASN1OutputStream;)V 
    .exceptions java/lang/Exception 
.end method 

.method abstract asn1Equals : (LASN1Primitive;)Z 
.end method 
.sourcefile 'ASN1Primitive.java' 
.end class 
