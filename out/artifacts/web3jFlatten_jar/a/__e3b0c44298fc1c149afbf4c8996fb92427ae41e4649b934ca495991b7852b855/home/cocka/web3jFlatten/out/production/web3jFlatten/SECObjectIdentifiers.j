.version 52 0 
.class interface abstract SECObjectIdentifiers 
.super java/lang/Object 
.field public static final ellipticCurve LASN1ObjectIdentifier; 
.field public static final secp256k1 LASN1ObjectIdentifier; 

.method static <clinit> : ()V 
    .code stack 3 locals 0 
L0:     new ASN1ObjectIdentifier 
L3:     dup 
L4:     ldc '1.3.132.0' 
L6:     invokespecial Method ASN1ObjectIdentifier <init> (Ljava/lang/String;)V 
L9:     putstatic Field SECObjectIdentifiers ellipticCurve LASN1ObjectIdentifier; 
L12:    getstatic Field SECObjectIdentifiers ellipticCurve LASN1ObjectIdentifier; 
L15:    ldc '10' 
L17:    invokevirtual Method ASN1ObjectIdentifier branch (Ljava/lang/String;)LASN1ObjectIdentifier; 
L20:    putstatic Field SECObjectIdentifiers secp256k1 LASN1ObjectIdentifier; 
L23:    return 
L24:    
        .linenumbertable 
            L0 3 
            L12 4 
        .end linenumbertable 
    .end code 
.end method 
.sourcefile 'SECObjectIdentifiers.java' 
.end class 
