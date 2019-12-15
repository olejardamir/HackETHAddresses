.version 52 0 
.class super X9ECPoint 
.super java/lang/Object 
.field private final encoding LASN1OctetString; 
.field private final c LECCurve; 
.field private p LECPoint; 

.method public <init> : (LECCurve;[B)V 
    .code stack 4 locals 3 
L0:     aload_0 
L1:     invokespecial Method java/lang/Object <init> ()V 
L4:     aload_0 
L5:     aload_1 
L6:     putfield Field X9ECPoint c LECCurve; 
L9:     aload_0 
L10:    new DEROctetString 
L13:    dup 
L14:    aload_2 
L15:    invokestatic Method Arrays clone ([B)[B 
L18:    invokespecial Method DEROctetString <init> ([B)V 
L21:    putfield Field X9ECPoint encoding LASN1OctetString; 
L24:    return 
L25:    
        .linenumbertable 
            L0 13 
            L4 14 
            L9 15 
            L24 16 
        .end linenumbertable 
        .localvariabletable 
            0 is this LX9ECPoint; from L0 to L25 
            1 is c LECCurve; from L0 to L25 
            2 is encoding [B from L0 to L25 
        .end localvariabletable 
    .end code 
.end method 

.method public synchronized getPoint : ()LECPoint; 
    .code stack 3 locals 1 
L0:     aload_0 
L1:     getfield Field X9ECPoint p LECPoint; 
L4:     ifnonnull L28 
L7:     aload_0 
L8:     aload_0 
L9:     getfield Field X9ECPoint c LECCurve; 
L12:    aload_0 
L13:    getfield Field X9ECPoint encoding LASN1OctetString; 
L16:    invokevirtual Method ASN1OctetString getOctets ()[B 
L19:    invokevirtual Method ECCurve decodePoint ([B)LECPoint; 
L22:    invokevirtual Method ECPoint normalize ()LECPoint; 
L25:    putfield Field X9ECPoint p LECPoint; 

        .stack same 
L28:    aload_0 
L29:    getfield Field X9ECPoint p LECPoint; 
L32:    areturn 
L33:    
        .linenumbertable 
            L0 21 
            L7 23 
            L28 26 
        .end linenumbertable 
        .localvariabletable 
            0 is this LX9ECPoint; from L0 to L33 
        .end localvariabletable 
    .end code 
    .exceptions java/lang/CloneNotSupportedException 
.end method 

.method private toASN1Primitive : ()LASN1Primitive; 
    .code stack 1 locals 1 
L0:     aload_0 
L1:     getfield Field X9ECPoint encoding LASN1OctetString; 
L4:     areturn 
L5:     
        .linenumbertable 
            L0 32 
        .end linenumbertable 
        .localvariabletable 
            0 is this LX9ECPoint; from L0 to L5 
        .end localvariabletable 
    .end code 
.end method 

.method public hashCode : ()I 
    .code stack 1 locals 1 
L0:     aload_0 
L1:     invokespecial Method X9ECPoint toASN1Primitive ()LASN1Primitive; 
L4:     invokevirtual Method ASN1Primitive hashCode ()I 
L7:     ireturn 
L8:     
        .linenumbertable 
            L0 37 
        .end linenumbertable 
        .localvariabletable 
            0 is this LX9ECPoint; from L0 to L8 
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
L8:     instanceof X9ECPoint 
L11:    ifne L16 
L14:    iconst_0 
L15:    ireturn 

        .stack same 
L16:    aload_1 
L17:    checkcast X9ECPoint 
L20:    astore_2 
L21:    aload_0 
L22:    invokespecial Method X9ECPoint toASN1Primitive ()LASN1Primitive; 
L25:    aload_2 
L26:    invokespecial Method X9ECPoint toASN1Primitive ()LASN1Primitive; 
L29:    invokevirtual Method ASN1Primitive equals (Ljava/lang/Object;)Z 
L32:    ireturn 
L33:    
        .linenumbertable 
            L0 43 
            L5 45 
            L7 48 
            L14 50 
            L16 53 
            L21 55 
        .end linenumbertable 
        .localvariabletable 
            0 is this LX9ECPoint; from L0 to L33 
            1 is o Ljava/lang/Object; from L0 to L33 
            2 is other LX9ECPoint; from L21 to L33 
        .end localvariabletable 
    .end code 
.end method 
.sourcefile 'X9ECPoint.java' 
.end class 
