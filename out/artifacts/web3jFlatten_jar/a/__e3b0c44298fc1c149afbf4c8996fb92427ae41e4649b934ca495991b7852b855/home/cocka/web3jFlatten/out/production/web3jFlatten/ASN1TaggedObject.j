.version 52 0 
.class public super abstract ASN1TaggedObject 
.super ASN1Primitive 
.implements ASN1Encodable 
.field final tagNo I 
.field final obj LASN1Encodable; 

.method <init> : (ZILASN1Encodable;)V 
    .code stack 2 locals 4 
L0:     aload_0 
L1:     invokespecial Method ASN1Primitive <init> ()V 
L4:     aload_0 
L5:     iload_2 
L6:     putfield Field ASN1TaggedObject tagNo I 
L9:     aload_0 
L10:    aload_3 
L11:    putfield Field ASN1TaggedObject obj LASN1Encodable; 
L14:    return 
L15:    
        .linenumbertable 
            L0 11 
            L4 12 
            L9 13 
            L14 16 
        .end linenumbertable 
        .localvariabletable 
            0 is this LASN1TaggedObject; from L0 to L15 
            1 is explicit Z from L0 to L15 
            2 is tagNo I from L0 to L15 
            3 is obj LASN1Encodable; from L0 to L15 
        .end localvariabletable 
    .end code 
.end method 

.method public hashCode : ()I 
    .code stack 2 locals 2 
L0:     aload_0 
L1:     getfield Field ASN1TaggedObject tagNo I 
L4:     istore_1 
L5:     aload_0 
L6:     getfield Field ASN1TaggedObject obj LASN1Encodable; 
L9:     ifnull L22 
L12:    iload_1 
L13:    aload_0 
L14:    getfield Field ASN1TaggedObject obj LASN1Encodable; 
L17:    invokevirtual Method java/lang/Object hashCode ()I 
L20:    ixor 
L21:    istore_1 

        .stack append Integer 
L22:    iload_1 
L23:    ireturn 
L24:    
        .linenumbertable 
            L0 19 
            L5 22 
            L12 23 
            L22 26 
        .end linenumbertable 
        .localvariabletable 
            0 is this LASN1TaggedObject; from L0 to L24 
            1 is code I from L5 to L24 
        .end localvariabletable 
    .end code 
.end method 

.method public toString : ()Ljava/lang/String; 
    .code stack 2 locals 1 
L0:     new java/lang/StringBuilder 
L3:     dup 
L4:     invokespecial Method java/lang/StringBuilder <init> ()V 
L7:     ldc '[' 
L9:     invokevirtual Method java/lang/StringBuilder append (Ljava/lang/String;)Ljava/lang/StringBuilder; 
L12:    aload_0 
L13:    getfield Field ASN1TaggedObject tagNo I 
L16:    invokevirtual Method java/lang/StringBuilder append (I)Ljava/lang/StringBuilder; 
L19:    ldc ']' 
L21:    invokevirtual Method java/lang/StringBuilder append (Ljava/lang/String;)Ljava/lang/StringBuilder; 
L24:    aload_0 
L25:    getfield Field ASN1TaggedObject obj LASN1Encodable; 
L28:    invokevirtual Method java/lang/StringBuilder append (Ljava/lang/Object;)Ljava/lang/StringBuilder; 
L31:    invokevirtual Method java/lang/StringBuilder toString ()Ljava/lang/String; 
L34:    areturn 
L35:    
        .linenumbertable 
            L0 32 
        .end linenumbertable 
        .localvariabletable 
            0 is this LASN1TaggedObject; from L0 to L35 
        .end localvariabletable 
    .end code 
.end method 
.sourcefile 'ASN1TaggedObject.java' 
.end class 
