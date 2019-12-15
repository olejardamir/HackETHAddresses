.version 52 0 
.class public super DERNull 
.super ASN1Primitive 
.field public static final INSTANCE LDERNull; 

.method public <init> : ()V 
    .code stack 1 locals 1 
L0:     aload_0 
L1:     invokespecial Method ASN1Primitive <init> ()V 
L4:     return 
L5:     
        .linenumbertable 
            L0 9 
            L4 11 
        .end linenumbertable 
        .localvariabletable 
            0 is this LDERNull; from L0 to L5 
        .end localvariabletable 
    .end code 
.end method 

.method public hashCode : ()I 
    .code stack 1 locals 1 
L0:     iconst_m1 
L1:     ireturn 
L2:     
        .linenumbertable 
            L0 18 
        .end linenumbertable 
        .localvariabletable 
            0 is this LDERNull; from L0 to L2 
        .end localvariabletable 
    .end code 
.end method 

.method encodedLength : ()I 
    .code stack 1 locals 1 
L0:     iconst_0 
L1:     ireturn 
L2:     
        .linenumbertable 
            L0 22 
        .end linenumbertable 
        .localvariabletable 
            0 is this LDERNull; from L0 to L2 
        .end localvariabletable 
    .end code 
.end method 

.method encode : (LASN1OutputStream;)V 
    .code stack 0 locals 2 
L0:     return 
L1:     
        .linenumbertable 
            L0 27 
        .end linenumbertable 
        .localvariabletable 
            0 is this LDERNull; from L0 to L1 
            1 is out LASN1OutputStream; from L0 to L1 
        .end localvariabletable 
    .end code 
.end method 

.method asn1Equals : (LASN1Primitive;)Z 
    .code stack 1 locals 2 
L0:     iconst_0 
L1:     ireturn 
L2:     
        .linenumbertable 
            L0 30 
        .end linenumbertable 
        .localvariabletable 
            0 is this LDERNull; from L0 to L2 
            1 is o LASN1Primitive; from L0 to L2 
        .end localvariabletable 
    .end code 
.end method 

.method public toString : ()Ljava/lang/String; 
    .code stack 1 locals 1 
L0:     ldc 'NULL' 
L2:     areturn 
L3:     
        .linenumbertable 
            L0 36 
        .end linenumbertable 
        .localvariabletable 
            0 is this LDERNull; from L0 to L3 
        .end localvariabletable 
    .end code 
.end method 

.method static <clinit> : ()V 
    .code stack 2 locals 0 
L0:     new DERNull 
L3:     dup 
L4:     invokespecial Method DERNull <init> ()V 
L7:     putstatic Field DERNull INSTANCE LDERNull; 
L10:    return 
L11:    
        .linenumbertable 
            L0 4 
        .end linenumbertable 
    .end code 
.end method 
.sourcefile 'DERNull.java' 
.end class 
