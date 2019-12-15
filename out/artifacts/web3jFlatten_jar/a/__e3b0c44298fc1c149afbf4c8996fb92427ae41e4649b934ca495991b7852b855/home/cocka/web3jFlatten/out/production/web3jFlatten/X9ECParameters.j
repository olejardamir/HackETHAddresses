.version 52 0 
.class public super X9ECParameters 
.super java/lang/Object 
.field private static final ONE Ljava/math/BigInteger; 
.field private fieldID LX9FieldID; 
.field private final curve LECCurve; 
.field private final g LX9ECPoint; 
.field private final n Ljava/math/BigInteger; 
.field private final h Ljava/math/BigInteger; 
.field private final seed [B 

.method public <init> : (LECCurve;LX9ECPoint;Ljava/math/BigInteger;Ljava/math/BigInteger;[B)V 
    .code stack 4 locals 6 
L0:     aload_0 
L1:     invokespecial Method java/lang/Object <init> ()V 
L4:     aload_0 
L5:     aload_1 
L6:     putfield Field X9ECParameters curve LECCurve; 
L9:     aload_0 
L10:    aload_2 
L11:    putfield Field X9ECParameters g LX9ECPoint; 
L14:    aload_0 
L15:    aload_3 
L16:    putfield Field X9ECParameters n Ljava/math/BigInteger; 
L19:    aload_0 
L20:    aload 4 
L22:    putfield Field X9ECParameters h Ljava/math/BigInteger; 
L25:    aload_0 
L26:    aload 5 
L28:    invokestatic Method Arrays clone ([B)[B 
L31:    putfield Field X9ECParameters seed [B 
L34:    aload_0 
L35:    new X9FieldID 
L38:    dup 
L39:    aload_1 
L40:    invokevirtual Method ECCurve getField ()LGenericPolynomialExtensionField; 
L43:    invokevirtual Method GenericPolynomialExtensionField getCharacteristic ()Ljava/math/BigInteger; 
L46:    invokespecial Method X9FieldID <init> (Ljava/math/BigInteger;)V 
L49:    putfield Field X9ECParameters fieldID LX9FieldID; 
L52:    return 
L53:    
        .linenumbertable 
            L0 23 
            L4 24 
            L9 25 
            L14 26 
            L19 27 
            L25 28 
            L34 31 
            L52 35 
        .end linenumbertable 
        .localvariabletable 
            0 is this LX9ECParameters; from L0 to L53 
            1 is curve LECCurve; from L0 to L53 
            2 is g LX9ECPoint; from L0 to L53 
            3 is n Ljava/math/BigInteger; from L0 to L53 
            4 is h Ljava/math/BigInteger; from L0 to L53 
            5 is seed [B from L0 to L53 
        .end localvariabletable 
    .end code 
.end method 

.method public getCurve : ()LECCurve; 
    .code stack 1 locals 1 
L0:     aload_0 
L1:     getfield Field X9ECParameters curve LECCurve; 
L4:     areturn 
L5:     
        .linenumbertable 
            L0 39 
        .end linenumbertable 
        .localvariabletable 
            0 is this LX9ECParameters; from L0 to L5 
        .end localvariabletable 
    .end code 
.end method 

.method public getG : ()LECPoint; 
    .code stack 1 locals 1 
L0:     aload_0 
L1:     getfield Field X9ECParameters g LX9ECPoint; 
L4:     invokevirtual Method X9ECPoint getPoint ()LECPoint; 
L7:     areturn 
L8:     
        .linenumbertable 
            L0 43 
        .end linenumbertable 
        .localvariabletable 
            0 is this LX9ECParameters; from L0 to L8 
        .end localvariabletable 
    .end code 
    .exceptions java/lang/CloneNotSupportedException 
.end method 

.method public getN : ()Ljava/math/BigInteger; 
    .code stack 1 locals 1 
L0:     aload_0 
L1:     getfield Field X9ECParameters n Ljava/math/BigInteger; 
L4:     areturn 
L5:     
        .linenumbertable 
            L0 48 
        .end linenumbertable 
        .localvariabletable 
            0 is this LX9ECParameters; from L0 to L5 
        .end localvariabletable 
    .end code 
.end method 

.method public getH : ()Ljava/math/BigInteger; 
    .code stack 1 locals 1 
L0:     aload_0 
L1:     getfield Field X9ECParameters h Ljava/math/BigInteger; 
L4:     areturn 
L5:     
        .linenumbertable 
            L0 53 
        .end linenumbertable 
        .localvariabletable 
            0 is this LX9ECParameters; from L0 to L5 
        .end localvariabletable 
    .end code 
.end method 

.method private toASN1Primitive : ()LASN1Primitive; 
    .code stack 5 locals 2 
L0:     new ASN1EncodableVector 
L3:     dup 
L4:     invokespecial Method ASN1EncodableVector <init> ()V 
L7:     astore_1 
L8:     aload_1 
L9:     new ASN1Integer 
L12:    dup 
L13:    getstatic Field X9ECParameters ONE Ljava/math/BigInteger; 
L16:    invokespecial Method ASN1Integer <init> (Ljava/math/BigInteger;)V 
L19:    invokevirtual Method ASN1EncodableVector add (LASN1Encodable;)V 
L22:    aload_1 
L23:    aload_0 
L24:    getfield Field X9ECParameters fieldID LX9FieldID; 
L27:    checkcast ASN1Encodable 
L30:    invokevirtual Method ASN1EncodableVector add (LASN1Encodable;)V 
L33:    aload_1 
L34:    new X9Curve 
L37:    dup 
L38:    aload_0 
L39:    getfield Field X9ECParameters curve LECCurve; 
L42:    aload_0 
L43:    getfield Field X9ECParameters seed [B 
L46:    invokespecial Method X9Curve <init> (LECCurve;[B)V 
L49:    invokevirtual Method ASN1EncodableVector add (LASN1Encodable;)V 
L52:    aload_1 
L53:    aload_0 
L54:    getfield Field X9ECParameters g LX9ECPoint; 
L57:    checkcast ASN1Encodable 
L60:    invokevirtual Method ASN1EncodableVector add (LASN1Encodable;)V 
L63:    aload_1 
L64:    new ASN1Integer 
L67:    dup 
L68:    aload_0 
L69:    getfield Field X9ECParameters n Ljava/math/BigInteger; 
L72:    invokespecial Method ASN1Integer <init> (Ljava/math/BigInteger;)V 
L75:    invokevirtual Method ASN1EncodableVector add (LASN1Encodable;)V 
L78:    aload_0 
L79:    getfield Field X9ECParameters h Ljava/math/BigInteger; 
L82:    ifnull L100 
L85:    aload_1 
L86:    new ASN1Integer 
L89:    dup 
L90:    aload_0 
L91:    getfield Field X9ECParameters h Ljava/math/BigInteger; 
L94:    invokespecial Method ASN1Integer <init> (Ljava/math/BigInteger;)V 
L97:    invokevirtual Method ASN1EncodableVector add (LASN1Encodable;)V 

        .stack append Object ASN1EncodableVector 
L100:   new DERSequence 
L103:   dup 
L104:   aload_1 
L105:   invokespecial Method DERSequence <init> (LASN1EncodableVector;)V 
L108:   areturn 
L109:   
        .linenumbertable 
            L0 60 
            L8 62 
            L22 63 
            L33 64 
            L52 65 
            L63 66 
            L78 68 
            L85 70 
            L100 73 
        .end linenumbertable 
        .localvariabletable 
            0 is this LX9ECParameters; from L0 to L109 
            1 is v LASN1EncodableVector; from L8 to L109 
        .end localvariabletable 
    .end code 
.end method 

.method public hashCode : ()I 
    .code stack 1 locals 1 
L0:     aload_0 
L1:     invokespecial Method X9ECParameters toASN1Primitive ()LASN1Primitive; 
L4:     invokevirtual Method ASN1Primitive hashCode ()I 
L7:     ireturn 
L8:     
        .linenumbertable 
            L0 78 
        .end linenumbertable 
        .localvariabletable 
            0 is this LX9ECParameters; from L0 to L8 
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
L8:     instanceof X9ECParameters 
L11:    ifne L16 
L14:    iconst_0 
L15:    ireturn 

        .stack same 
L16:    aload_1 
L17:    checkcast X9ECParameters 
L20:    astore_2 
L21:    aload_0 
L22:    invokespecial Method X9ECParameters toASN1Primitive ()LASN1Primitive; 
L25:    aload_2 
L26:    invokespecial Method X9ECParameters toASN1Primitive ()LASN1Primitive; 
L29:    invokevirtual Method ASN1Primitive equals (Ljava/lang/Object;)Z 
L32:    ireturn 
L33:    
        .linenumbertable 
            L0 84 
            L5 86 
            L7 89 
            L14 91 
            L16 94 
            L21 96 
        .end linenumbertable 
        .localvariabletable 
            0 is this LX9ECParameters; from L0 to L33 
            1 is o Ljava/lang/Object; from L0 to L33 
            2 is other LX9ECParameters; from L21 to L33 
        .end localvariabletable 
    .end code 
.end method 

.method static <clinit> : ()V 
    .code stack 2 locals 0 
L0:     lconst_1 
L1:     invokestatic Method java/math/BigInteger valueOf (J)Ljava/math/BigInteger; 
L4:     putstatic Field X9ECParameters ONE Ljava/math/BigInteger; 
L7:     return 
L8:     
        .linenumbertable 
            L0 6 
        .end linenumbertable 
    .end code 
.end method 
.sourcefile 'X9ECParameters.java' 
.end class 
