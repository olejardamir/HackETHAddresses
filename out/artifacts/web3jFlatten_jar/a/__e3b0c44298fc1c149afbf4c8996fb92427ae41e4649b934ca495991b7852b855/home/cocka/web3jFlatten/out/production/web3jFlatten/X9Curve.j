.version 52 0 
.class public super X9Curve 
.super ASN1Object 
.field private final curve LECCurve; 
.field private final seed [B 
.field private fieldIdentifier LASN1ObjectIdentifier; 

.method public <init> : (LECCurve;[B)V 
    .code stack 2 locals 3 
L0:     aload_0 
L1:     invokespecial Method ASN1Object <init> ()V 
L4:     aload_0 
L5:     aload_1 
L6:     putfield Field X9Curve curve LECCurve; 
L9:     aload_0 
L10:    aload_2 
L11:    invokestatic Method Arrays clone ([B)[B 
L14:    putfield Field X9Curve seed [B 
L17:    aload_0 
L18:    invokespecial Method X9Curve setFieldIdentifier ()V 
L21:    return 
L22:    
        .linenumbertable 
            L0 17 
            L4 18 
            L9 19 
            L17 20 
            L21 21 
        .end linenumbertable 
        .localvariabletable 
            0 is this LX9Curve; from L0 to L22 
            1 is curve LECCurve; from L0 to L22 
            2 is seed [B from L0 to L22 
        .end localvariabletable 
    .end code 
.end method 

.method private setFieldIdentifier : ()V 
    .code stack 0 locals 1 
L0:     return 
L1:     
        .linenumbertable 
            L0 29 
        .end linenumbertable 
        .localvariabletable 
            0 is this LX9Curve; from L0 to L1 
        .end localvariabletable 
    .end code 
.end method 

.method public toASN1Primitive : ()LASN1Primitive; 
    .code stack 4 locals 2 
L0:     new ASN1EncodableVector 
L3:     dup 
L4:     invokespecial Method ASN1EncodableVector <init> ()V 
L7:     astore_1 
L8:     aload_0 
L9:     getfield Field X9Curve seed [B 
L12:    ifnull L30 
L15:    aload_1 
L16:    new DERBitString 
L19:    dup 
L20:    aload_0 
L21:    getfield Field X9Curve seed [B 
L24:    invokespecial Method DERBitString <init> ([B)V 
L27:    invokevirtual Method ASN1EncodableVector add (LASN1Encodable;)V 

        .stack append Object ASN1EncodableVector 
L30:    new DERSequence 
L33:    dup 
L34:    aload_1 
L35:    invokespecial Method DERSequence <init> (LASN1EncodableVector;)V 
L38:    areturn 
L39:    
        .linenumbertable 
            L0 33 
            L8 38 
            L15 40 
            L30 43 
        .end linenumbertable 
        .localvariabletable 
            0 is this LX9Curve; from L0 to L39 
            1 is v LASN1EncodableVector; from L8 to L39 
        .end localvariabletable 
    .end code 
.end method 
.sourcefile 'X9Curve.java' 
.end class 
