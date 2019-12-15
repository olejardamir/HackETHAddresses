.version 52 0 
.class super DERExternal 
.super ASN1External 

.method public <init> : (LASN1EncodableVector;)V 
    .code stack 2 locals 2 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial Method ASN1External <init> (LASN1EncodableVector;)V 
L5:     return 
L6:     
        .linenumbertable 
            L0 25 
            L5 26 
        .end linenumbertable 
        .localvariabletable 
            0 is this LDERExternal; from L0 to L6 
            1 is vector LASN1EncodableVector; from L0 to L6 
        .end localvariabletable 
    .end code 
.end method 

.method public <init> : (LASN1ObjectIdentifier;LASN1Integer;LASN1Primitive;LDERTaggedObject;)V 
    .code stack 6 locals 5 
L0:     aload_0 
L1:     aload_1 
L2:     aload_2 
L3:     aload_3 
L4:     aload 4 
L6:     invokevirtual Method DERTaggedObject getTagNo ()I 
L9:     aload 4 
L11:    invokevirtual Method DERTaggedObject toASN1Primitive ()LASN1Primitive; 
L14:    invokespecial Method DERExternal <init> (LASN1ObjectIdentifier;LASN1Integer;LASN1Primitive;ILASN1Primitive;)V 
L17:    return 
L18:    
        .linenumbertable 
            L0 38 
            L17 39 
        .end linenumbertable 
        .localvariabletable 
            0 is this LDERExternal; from L0 to L18 
            1 is directReference LASN1ObjectIdentifier; from L0 to L18 
            2 is indirectReference LASN1Integer; from L0 to L18 
            3 is dataValueDescriptor LASN1Primitive; from L0 to L18 
            4 is externalData LDERTaggedObject; from L0 to L18 
        .end localvariabletable 
    .end code 
.end method 

.method private <init> : (LASN1ObjectIdentifier;LASN1Integer;LASN1Primitive;ILASN1Primitive;)V 
    .code stack 6 locals 6 
L0:     aload_0 
L1:     aload_1 
L2:     aload_2 
L3:     aload_3 
L4:     iload 4 
L6:     aload 5 
L8:     invokespecial Method ASN1External <init> (LASN1ObjectIdentifier;LASN1Integer;LASN1Primitive;ILASN1Primitive;)V 
L11:    return 
L12:    
        .linenumbertable 
            L0 52 
            L11 53 
        .end linenumbertable 
        .localvariabletable 
            0 is this LDERExternal; from L0 to L12 
            1 is directReference LASN1ObjectIdentifier; from L0 to L12 
            2 is indirectReference LASN1Integer; from L0 to L12 
            3 is dataValueDescriptor LASN1Primitive; from L0 to L12 
            4 is encoding I from L0 to L12 
            5 is externalData LASN1Primitive; from L0 to L12 
        .end localvariabletable 
    .end code 
.end method 

.method encodedLength : ()I 
    .code stack 1 locals 1 
L0:     aload_0 
L1:     invokevirtual Method DERExternal getEncoded ()[B 
L4:     arraylength 
L5:     ireturn 
L6:     
        .linenumbertable 
            L0 58 
        .end linenumbertable 
        .localvariabletable 
            0 is this LDERExternal; from L0 to L6 
        .end localvariabletable 
    .end code 
    .exceptions java/io/IOException 
.end method 

.method encode : (LASN1OutputStream;)V 
    .code stack 5 locals 4 
L0:     new java/io/ByteArrayOutputStream 
L3:     dup 
L4:     invokespecial Method java/io/ByteArrayOutputStream <init> ()V 
L7:     astore_2 
L8:     aload_0 
L9:     getfield Field DERExternal directReference LASN1ObjectIdentifier; 
L12:    ifnull L28 
L15:    aload_2 
L16:    aload_0 
L17:    getfield Field DERExternal directReference LASN1ObjectIdentifier; 
L20:    ldc 'DER' 
L22:    invokevirtual Method ASN1ObjectIdentifier getEncoded (Ljava/lang/String;)[B 
L25:    invokevirtual Method java/io/ByteArrayOutputStream write ([B)V 

        .stack append Object java/io/ByteArrayOutputStream 
L28:    aload_0 
L29:    getfield Field DERExternal indirectReference LASN1Integer; 
L32:    ifnull L48 
L35:    aload_2 
L36:    aload_0 
L37:    getfield Field DERExternal indirectReference LASN1Integer; 
L40:    ldc 'DER' 
L42:    invokevirtual Method ASN1Integer getEncoded (Ljava/lang/String;)[B 
L45:    invokevirtual Method java/io/ByteArrayOutputStream write ([B)V 

        .stack same 
L48:    aload_0 
L49:    getfield Field DERExternal dataValueDescriptor LASN1Primitive; 
L52:    ifnull L68 
L55:    aload_2 
L56:    aload_0 
L57:    getfield Field DERExternal dataValueDescriptor LASN1Primitive; 
L60:    ldc 'DER' 
L62:    invokevirtual Method ASN1Primitive getEncoded (Ljava/lang/String;)[B 
L65:    invokevirtual Method java/io/ByteArrayOutputStream write ([B)V 

        .stack same 
L68:    new DERTaggedObject 
L71:    dup 
L72:    iconst_1 
L73:    aload_0 
L74:    getfield Field DERExternal encoding I 
L77:    aload_0 
L78:    getfield Field DERExternal externalContent LASN1Primitive; 
L81:    invokespecial Method DERTaggedObject <init> (ZILASN1Encodable;)V 
L84:    astore_3 
L85:    aload_2 
L86:    aload_3 
L87:    ldc 'DER' 
L89:    invokevirtual Method DERTaggedObject getEncoded (Ljava/lang/String;)[B 
L92:    invokevirtual Method java/io/ByteArrayOutputStream write ([B)V 
L95:    aload_1 
L96:    bipush 32 
L98:    bipush 8 
L100:   aload_2 
L101:   invokevirtual Method java/io/ByteArrayOutputStream toByteArray ()[B 
L104:   invokevirtual Method ASN1OutputStream writeEncoded (II[B)V 
L107:   return 
L108:   
        .linenumbertable 
            L0 67 
            L8 68 
            L15 70 
            L28 72 
            L35 74 
            L48 76 
            L55 78 
            L68 80 
            L85 81 
            L95 82 
            L107 83 
        .end linenumbertable 
        .localvariabletable 
            0 is this LDERExternal; from L0 to L108 
            1 is out LASN1OutputStream; from L0 to L108 
            2 is baos Ljava/io/ByteArrayOutputStream; from L8 to L108 
            3 is obj LDERTaggedObject; from L85 to L108 
        .end localvariabletable 
    .end code 
    .exceptions java/io/IOException 
.end method 

.method asn1Equals : (LASN1Primitive;)Z 
    .code stack 1 locals 2 
L0:     iconst_0 
L1:     ireturn 
L2:     
        .linenumbertable 
            L0 87 
        .end linenumbertable 
        .localvariabletable 
            0 is this LDERExternal; from L0 to L2 
            1 is o LASN1Primitive; from L0 to L2 
        .end localvariabletable 
    .end code 
.end method 
.sourcefile 'DERExternal.java' 
.end class 
