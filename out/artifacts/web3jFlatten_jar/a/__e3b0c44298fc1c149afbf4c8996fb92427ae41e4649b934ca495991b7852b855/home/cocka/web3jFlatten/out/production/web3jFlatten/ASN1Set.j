.version 52 0 
.class public super abstract ASN1Set 
.super ASN1Primitive 
.field private set Ljava/util/Vector; 

.method <init> : ()V 
    .code stack 3 locals 1 
L0:     aload_0 
L1:     invokespecial Method ASN1Primitive <init> ()V 
L4:     aload_0 
L5:     new java/util/Vector 
L8:     dup 
L9:     invokespecial Method java/util/Vector <init> ()V 
L12:    putfield Field ASN1Set set Ljava/util/Vector; 
L15:    return 
L16:    
        .linenumbertable 
            L0 12 
            L4 9 
            L15 13 
        .end linenumbertable 
        .localvariabletable 
            0 is this LASN1Set; from L0 to L16 
        .end localvariabletable 
    .end code 
.end method 

.method getObjects : ()Ljava/util/Enumeration; 
    .code stack 1 locals 1 
L0:     aload_0 
L1:     getfield Field ASN1Set set Ljava/util/Vector; 
L4:     invokevirtual Method java/util/Vector elements ()Ljava/util/Enumeration; 
L7:     areturn 
L8:     
        .linenumbertable 
            L0 18 
        .end linenumbertable 
        .localvariabletable 
            0 is this LASN1Set; from L0 to L8 
        .end localvariabletable 
    .end code 
.end method 

.method private size : ()I 
    .code stack 1 locals 1 
L0:     aload_0 
L1:     getfield Field ASN1Set set Ljava/util/Vector; 
L4:     invokevirtual Method java/util/Vector size ()I 
L7:     ireturn 
L8:     
        .linenumbertable 
            L0 24 
        .end linenumbertable 
        .localvariabletable 
            0 is this LASN1Set; from L0 to L8 
        .end localvariabletable 
    .end code 
.end method 

.method public hashCode : ()I 
    .code stack 2 locals 4 
L0:     aload_0 
L1:     invokevirtual Method ASN1Set getObjects ()Ljava/util/Enumeration; 
L4:     astore_1 
L5:     aload_0 
L6:     invokespecial Method ASN1Set size ()I 
L9:     istore_2 

        .stack append Object java/util/Enumeration Integer 
L10:    aload_1 
L11:    invokeinterface InterfaceMethod java/util/Enumeration hasMoreElements ()Z 1 
L16:    ifeq L40 
L19:    aload_0 
L20:    aload_1 
L21:    invokespecial Method ASN1Set getNext (Ljava/util/Enumeration;)LASN1Encodable; 
L24:    astore_3 
L25:    iload_2 
L26:    bipush 17 
L28:    imul 
L29:    istore_2 
L30:    iload_2 
L31:    aload_3 
L32:    invokevirtual Method java/lang/Object hashCode ()I 
L35:    ixor 
L36:    istore_2 
L37:    goto L10 

        .stack same 
L40:    iload_2 
L41:    ireturn 
L42:    
        .linenumbertable 
            L0 29 
            L5 30 
            L10 32 
            L19 34 
            L25 35 
            L30 37 
            L37 38 
            L40 40 
        .end linenumbertable 
        .localvariabletable 
            3 is o Ljava/lang/Object; from L25 to L37 
            0 is this LASN1Set; from L0 to L42 
            1 is e Ljava/util/Enumeration; from L5 to L42 
            2 is hashCode I from L10 to L42 
        .end localvariabletable 
    .end code 
.end method 

.method private getNext : (Ljava/util/Enumeration;)LASN1Encodable; 
    .code stack 1 locals 3 
L0:     aload_1 
L1:     invokeinterface InterfaceMethod java/util/Enumeration nextElement ()Ljava/lang/Object; 1 
L6:     checkcast ASN1Encodable 
L9:     astore_2 
L10:    aload_2 
L11:    ifnonnull L18 
L14:    getstatic Field DERNull INSTANCE LDERNull; 
L17:    areturn 

        .stack append Object ASN1Encodable 
L18:    aload_2 
L19:    areturn 
L20:    
        .linenumbertable 
            L0 47 
            L10 50 
            L14 52 
            L18 55 
        .end linenumbertable 
        .localvariabletable 
            0 is this LASN1Set; from L0 to L20 
            1 is e Ljava/util/Enumeration; from L0 to L20 
            2 is encObj LASN1Encodable; from L10 to L20 
        .end localvariabletable 
    .end code 
.end method 

.method public toString : ()Ljava/lang/String; 
    .code stack 1 locals 1 
L0:     aload_0 
L1:     getfield Field ASN1Set set Ljava/util/Vector; 
L4:     invokevirtual Method java/util/Vector toString ()Ljava/lang/String; 
L7:     areturn 
L8:     
        .linenumbertable 
            L0 60 
        .end linenumbertable 
        .localvariabletable 
            0 is this LASN1Set; from L0 to L8 
        .end localvariabletable 
    .end code 
.end method 
.sourcefile 'ASN1Set.java' 
.end class 
