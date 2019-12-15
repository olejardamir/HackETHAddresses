.version 52 0 
.class public super abstract ASN1OctetString 
.super ASN1Primitive 
.field string [B 

.method <init> : ([B)V 
    .code stack 3 locals 2 
L0:     aload_0 
L1:     invokespecial Method ASN1Primitive <init> ()V 
L4:     aload_1 
L5:     ifnonnull L18 
L8:     new java/lang/NullPointerException 
L11:    dup 
L12:    ldc 'string cannot be null' 
L14:    invokespecial Method java/lang/NullPointerException <init> (Ljava/lang/String;)V 
L17:    athrow 

        .stack full 
            locals Object ASN1OctetString Object [B 
            stack 
        .end stack 
L18:    aload_0 
L19:    aload_1 
L20:    putfield Field ASN1OctetString string [B 
L23:    return 
L24:    
        .linenumbertable 
            L0 101 
            L4 102 
            L8 104 
            L18 106 
            L23 107 
        .end linenumbertable 
        .localvariabletable 
            0 is this LASN1OctetString; from L0 to L24 
            1 is string [B from L0 to L24 
        .end localvariabletable 
    .end code 
.end method 

.method public <init> : ()V 
    .code stack 1 locals 1 
L0:     aload_0 
L1:     invokespecial Method ASN1Primitive <init> ()V 
L4:     return 
L5:     
        .linenumbertable 
            L0 109 
            L4 111 
        .end linenumbertable 
        .localvariabletable 
            0 is this LASN1OctetString; from L0 to L5 
        .end localvariabletable 
    .end code 
.end method 

.method public getOctets : ()[B 
    .code stack 1 locals 1 
L0:     aload_0 
L1:     getfield Field ASN1OctetString string [B 
L4:     areturn 
L5:     
        .linenumbertable 
            L0 120 
        .end linenumbertable 
        .localvariabletable 
            0 is this LASN1OctetString; from L0 to L5 
        .end localvariabletable 
    .end code 
.end method 

.method public hashCode : ()I 
    .code stack 1 locals 1 
L0:     aload_0 
L1:     invokevirtual Method ASN1OctetString getOctets ()[B 
L4:     invokestatic Method Arrays hashCode ([B)I 
L7:     ireturn 
L8:     
        .linenumbertable 
            L0 125 
        .end linenumbertable 
        .localvariabletable 
            0 is this LASN1OctetString; from L0 to L8 
        .end localvariabletable 
    .end code 
.end method 

.method asn1Equals : (LASN1Primitive;)Z 
    .code stack 2 locals 3 
L0:     aload_1 
L1:     instanceof ASN1OctetString 
L4:     ifne L9 
L7:     iconst_0 
L8:     ireturn 

        .stack same 
L9:     aload_1 
L10:    checkcast ASN1OctetString 
L13:    astore_2 
L14:    aload_0 
L15:    getfield Field ASN1OctetString string [B 
L18:    aload_2 
L19:    getfield Field ASN1OctetString string [B 
L22:    invokestatic Method Arrays areEqual ([B[B)Z 
L25:    ireturn 
L26:    
        .linenumbertable 
            L0 131 
            L7 133 
            L9 136 
            L14 138 
        .end linenumbertable 
        .localvariabletable 
            0 is this LASN1OctetString; from L0 to L26 
            1 is o LASN1Primitive; from L0 to L26 
            2 is other LASN1OctetString; from L14 to L26 
        .end localvariabletable 
    .end code 
.end method 

.method toDERObject : ()LASN1Primitive; 
    .code stack 3 locals 1 
L0:     new DEROctetString 
L3:     dup 
L4:     aload_0 
L5:     getfield Field ASN1OctetString string [B 
L8:     invokespecial Method DEROctetString <init> ([B)V 
L11:    areturn 
L12:    
        .linenumbertable 
            L0 143 
        .end linenumbertable 
        .localvariabletable 
            0 is this LASN1OctetString; from L0 to L12 
        .end localvariabletable 
    .end code 
.end method 

.method abstract encode : (LASN1OutputStream;)V 
    .exceptions java/lang/Exception 
.end method 

.method public toString : ()Ljava/lang/String; 
    .code stack 2 locals 2 
        .catch java/lang/Exception from L0 to L28 using L29 
L0:     new java/lang/StringBuilder 
L3:     dup 
L4:     invokespecial Method java/lang/StringBuilder <init> ()V 
L7:     ldc '#' 
L9:     invokevirtual Method java/lang/StringBuilder append (Ljava/lang/String;)Ljava/lang/StringBuilder; 
L12:    aload_0 
L13:    getfield Field ASN1OctetString string [B 
L16:    invokestatic Method Hex encode ([B)[B 
L19:    invokestatic Method Strings fromByteArray ([B)Ljava/lang/String; 
L22:    invokevirtual Method java/lang/StringBuilder append (Ljava/lang/String;)Ljava/lang/StringBuilder; 
L25:    invokevirtual Method java/lang/StringBuilder toString ()Ljava/lang/String; 
L28:    areturn 

        .stack stack_1 Object java/lang/Exception 
L29:    astore_1 
L30:    aload_1 
L31:    invokevirtual Method java/lang/Exception printStackTrace ()V 
L34:    aconst_null 
L35:    areturn 
L36:    
        .linenumbertable 
            L0 153 
            L29 154 
            L30 155 
            L34 157 
        .end linenumbertable 
        .localvariabletable 
            1 is e Ljava/lang/Exception; from L30 to L34 
            0 is this LASN1OctetString; from L0 to L36 
        .end localvariabletable 
    .end code 
.end method 
.sourcefile 'ASN1OctetString.java' 
.end class 
