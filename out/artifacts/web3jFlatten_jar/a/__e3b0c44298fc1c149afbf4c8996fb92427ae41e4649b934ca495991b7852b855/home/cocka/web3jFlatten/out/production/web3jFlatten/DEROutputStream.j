.version 52 0 
.class public super DEROutputStream 
.super ASN1OutputStream 

.method public <init> : (Ljava/io/OutputStream;)V 
    .code stack 2 locals 2 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial Method ASN1OutputStream <init> (Ljava/io/OutputStream;)V 
L5:     return 
L6:     
        .linenumbertable 
            L0 11 
            L5 12 
        .end linenumbertable 
        .localvariabletable 
            0 is this LDEROutputStream; from L0 to L6 
            1 is os Ljava/io/OutputStream; from L0 to L6 
        .end localvariabletable 
    .end code 
.end method 

.method public writeObject : (LASN1Encodable;)V 
    .code stack 2 locals 2 
L0:     aload_1 
L1:     invokeinterface InterfaceMethod ASN1Encodable toASN1Primitive ()LASN1Primitive; 1 
L6:     invokevirtual Method ASN1Primitive toDERObject ()LASN1Primitive; 
L9:     aload_0 
L10:    invokevirtual Method ASN1Primitive encode (LASN1OutputStream;)V 
L13:    return 
L14:    
        .linenumbertable 
            L0 19 
            L13 22 
        .end linenumbertable 
        .localvariabletable 
            0 is this LDEROutputStream; from L0 to L14 
            1 is obj LASN1Encodable; from L0 to L14 
        .end localvariabletable 
    .end code 
    .exceptions java/lang/Exception 
.end method 

.method getDERSubStream : ()LASN1OutputStream; 
    .code stack 1 locals 1 
L0:     aload_0 
L1:     areturn 
L2:     
        .linenumbertable 
            L0 26 
        .end linenumbertable 
        .localvariabletable 
            0 is this LDEROutputStream; from L0 to L2 
        .end localvariabletable 
    .end code 
.end method 
.sourcefile 'DEROutputStream.java' 
.end class 
