.version 52 0 
.class public super ASN1ObjectIdentifier 
.super ASN1Primitive 
.field private final identifier Ljava/lang/String; 
.field private body [B 

.method public <init> : (Ljava/lang/String;)V 
    .code stack 4 locals 2 
L0:     aload_0 
L1:     invokespecial Method ASN1Primitive <init> ()V 
L4:     aload_1 
L5:     ifnonnull L18 
L8:     new java/lang/IllegalArgumentException 
L11:    dup 
L12:    ldc "'identifier' cannot be null" 
L14:    invokespecial Method java/lang/IllegalArgumentException <init> (Ljava/lang/String;)V 
L17:    athrow 

        .stack full 
            locals Object ASN1ObjectIdentifier Object java/lang/String 
            stack 
        .end stack 
L18:    aload_1 
L19:    invokestatic Method ASN1ObjectIdentifier isValidIdentifier (Ljava/lang/String;)Z 
L22:    ifne L57 
L25:    new java/lang/IllegalArgumentException 
L28:    dup 
L29:    new java/lang/StringBuilder 
L32:    dup 
L33:    invokespecial Method java/lang/StringBuilder <init> ()V 
L36:    ldc 'string ' 
L38:    invokevirtual Method java/lang/StringBuilder append (Ljava/lang/String;)Ljava/lang/StringBuilder; 
L41:    aload_1 
L42:    invokevirtual Method java/lang/StringBuilder append (Ljava/lang/String;)Ljava/lang/StringBuilder; 
L45:    ldc ' not an OID' 
L47:    invokevirtual Method java/lang/StringBuilder append (Ljava/lang/String;)Ljava/lang/StringBuilder; 
L50:    invokevirtual Method java/lang/StringBuilder toString ()Ljava/lang/String; 
L53:    invokespecial Method java/lang/IllegalArgumentException <init> (Ljava/lang/String;)V 
L56:    athrow 

        .stack same 
L57:    aload_0 
L58:    aload_1 
L59:    putfield Field ASN1ObjectIdentifier identifier Ljava/lang/String; 
L62:    return 
L63:    
        .linenumbertable 
            L0 17 
            L4 18 
            L8 20 
            L18 22 
            L25 24 
            L57 27 
            L62 28 
        .end linenumbertable 
        .localvariabletable 
            0 is this LASN1ObjectIdentifier; from L0 to L63 
            1 is identifier Ljava/lang/String; from L0 to L63 
        .end localvariabletable 
    .end code 
.end method 

.method private <init> : (LASN1ObjectIdentifier;Ljava/lang/String;)V 
    .code stack 4 locals 3 
L0:     aload_0 
L1:     invokespecial Method ASN1Primitive <init> ()V 
L4:     aload_2 
L5:     iconst_0 
L6:     invokestatic Method ASN1ObjectIdentifier isValidBranchID (Ljava/lang/String;I)Z 
L9:     ifne L44 
L12:    new java/lang/IllegalArgumentException 
L15:    dup 
L16:    new java/lang/StringBuilder 
L19:    dup 
L20:    invokespecial Method java/lang/StringBuilder <init> ()V 
L23:    ldc 'string ' 
L25:    invokevirtual Method java/lang/StringBuilder append (Ljava/lang/String;)Ljava/lang/StringBuilder; 
L28:    aload_2 
L29:    invokevirtual Method java/lang/StringBuilder append (Ljava/lang/String;)Ljava/lang/StringBuilder; 
L32:    ldc ' not a valid OID branch' 
L34:    invokevirtual Method java/lang/StringBuilder append (Ljava/lang/String;)Ljava/lang/StringBuilder; 
L37:    invokevirtual Method java/lang/StringBuilder toString ()Ljava/lang/String; 
L40:    invokespecial Method java/lang/IllegalArgumentException <init> (Ljava/lang/String;)V 
L43:    athrow 

        .stack full 
            locals Object ASN1ObjectIdentifier Object ASN1ObjectIdentifier Object java/lang/String 
            stack 
        .end stack 
L44:    aload_0 
L45:    new java/lang/StringBuilder 
L48:    dup 
L49:    invokespecial Method java/lang/StringBuilder <init> ()V 
L52:    aload_1 
L53:    invokespecial Method ASN1ObjectIdentifier getId ()Ljava/lang/String; 
L56:    invokevirtual Method java/lang/StringBuilder append (Ljava/lang/String;)Ljava/lang/StringBuilder; 
L59:    ldc '.' 
L61:    invokevirtual Method java/lang/StringBuilder append (Ljava/lang/String;)Ljava/lang/StringBuilder; 
L64:    aload_2 
L65:    invokevirtual Method java/lang/StringBuilder append (Ljava/lang/String;)Ljava/lang/StringBuilder; 
L68:    invokevirtual Method java/lang/StringBuilder toString ()Ljava/lang/String; 
L71:    putfield Field ASN1ObjectIdentifier identifier Ljava/lang/String; 
L74:    return 
L75:    
        .linenumbertable 
            L0 32 
            L4 33 
            L12 35 
            L44 38 
            L74 39 
        .end linenumbertable 
        .localvariabletable 
            0 is this LASN1ObjectIdentifier; from L0 to L75 
            1 is oid LASN1ObjectIdentifier; from L0 to L75 
            2 is branchID Ljava/lang/String; from L0 to L75 
        .end localvariabletable 
    .end code 
.end method 

.method private getId : ()Ljava/lang/String; 
    .code stack 1 locals 1 
L0:     aload_0 
L1:     getfield Field ASN1ObjectIdentifier identifier Ljava/lang/String; 
L4:     areturn 
L5:     
        .linenumbertable 
            L0 44 
        .end linenumbertable 
        .localvariabletable 
            0 is this LASN1ObjectIdentifier; from L0 to L5 
        .end localvariabletable 
    .end code 
.end method 

.method public branch : (Ljava/lang/String;)LASN1ObjectIdentifier; 
    .code stack 4 locals 2 
L0:     new ASN1ObjectIdentifier 
L3:     dup 
L4:     aload_0 
L5:     aload_1 
L6:     invokespecial Method ASN1ObjectIdentifier <init> (LASN1ObjectIdentifier;Ljava/lang/String;)V 
L9:     areturn 
L10:    
        .linenumbertable 
            L0 50 
        .end linenumbertable 
        .localvariabletable 
            0 is this LASN1ObjectIdentifier; from L0 to L10 
            1 is branchID Ljava/lang/String; from L0 to L10 
        .end localvariabletable 
    .end code 
.end method 

.method private writeField : (Ljava/io/ByteArrayOutputStream;J)V 
    .code stack 5 locals 6 
L0:     bipush 9 
L2:     newarray byte 
L4:     astore 4 
L6:     bipush 8 
L8:     istore 5 
L10:    aload 4 
L12:    iload 5 
L14:    lload_2 
L15:    l2i 
L16:    bipush 127 
L18:    iand 
L19:    i2b 
L20:    bastore 

        .stack append Object [B Integer 
L21:    lload_2 
L22:    ldc2_w 128L 
L25:    lcmp 
L26:    iflt L55 
L29:    lload_2 
L30:    bipush 7 
L32:    lshr 
L33:    lstore_2 
L34:    aload 4 
L36:    iinc 5 -1 
L39:    iload 5 
L41:    lload_2 
L42:    l2i 
L43:    bipush 127 
L45:    iand 
L46:    sipush 128 
L49:    ior 
L50:    i2b 
L51:    bastore 
L52:    goto L21 

        .stack same 
L55:    aload_1 
L56:    aload 4 
L58:    iload 5 
L60:    bipush 9 
L62:    iload 5 
L64:    isub 
L65:    invokevirtual Method java/io/ByteArrayOutputStream write ([BII)V 
L68:    return 
L69:    
        .linenumbertable 
            L0 57 
            L6 58 
            L10 59 
            L21 60 
            L29 62 
            L34 63 
            L55 65 
            L68 66 
        .end linenumbertable 
        .localvariabletable 
            0 is this LASN1ObjectIdentifier; from L0 to L69 
            1 is out Ljava/io/ByteArrayOutputStream; from L0 to L69 
            2 is fieldValue J from L0 to L69 
            4 is result [B from L6 to L69 
            5 is pos I from L10 to L69 
        .end localvariabletable 
    .end code 
.end method 

.method private writeField : (Ljava/io/ByteArrayOutputStream;Ljava/math/BigInteger;)V 
    .code stack 4 locals 7 
L0:     aload_2 
L1:     invokevirtual Method java/math/BigInteger bitLength ()I 
L4:     bipush 6 
L6:     iadd 
L7:     bipush 7 
L9:     idiv 
L10:    istore_3 
L11:    iload_3 
L12:    ifne L23 
L15:    aload_1 
L16:    iconst_0 
L17:    invokevirtual Method java/io/ByteArrayOutputStream write (I)V 
L20:    goto L96 

        .stack append Integer 
L23:    aload_2 
L24:    astore 4 
L26:    iload_3 
L27:    newarray byte 
L29:    astore 5 
L31:    iload_3 
L32:    iconst_1 
L33:    isub 
L34:    istore 6 

        .stack append Object java/math/BigInteger Object [B Integer 
L36:    iload 6 
L38:    iflt L74 
L41:    aload 5 
L43:    iload 6 
L45:    aload 4 
L47:    invokevirtual Method java/math/BigInteger intValue ()I 
L50:    bipush 127 
L52:    iand 
L53:    sipush 128 
L56:    ior 
L57:    i2b 
L58:    bastore 
L59:    aload 4 
L61:    bipush 7 
L63:    invokevirtual Method java/math/BigInteger shiftRight (I)Ljava/math/BigInteger; 
L66:    astore 4 
L68:    iinc 6 -1 
L71:    goto L36 

        .stack chop 1 
L74:    aload 5 
L76:    iload_3 
L77:    iconst_1 
L78:    isub 
L79:    dup2 
L80:    baload 
L81:    bipush 127 
L83:    iand 
L84:    i2b 
L85:    bastore 
L86:    aload_1 
L87:    aload 5 
L89:    iconst_0 
L90:    aload 5 
L92:    arraylength 
L93:    invokevirtual Method java/io/ByteArrayOutputStream write ([BII)V 

        .stack chop 2 
L96:    return 
L97:    
        .linenumbertable 
            L0 72 
            L11 73 
            L15 75 
            L23 79 
            L26 80 
            L31 81 
            L41 83 
            L59 84 
            L68 81 
            L74 86 
            L86 87 
            L96 89 
        .end linenumbertable 
        .localvariabletable 
            6 is i I from L36 to L74 
            4 is tmpValue Ljava/math/BigInteger; from L26 to L96 
            5 is tmp [B from L31 to L96 
            0 is this LASN1ObjectIdentifier; from L0 to L97 
            1 is out Ljava/io/ByteArrayOutputStream; from L0 to L97 
            2 is fieldValue Ljava/math/BigInteger; from L0 to L97 
            3 is byteCount I from L11 to L97 
        .end localvariabletable 
    .end code 
.end method 

.method private doOutput : (Ljava/io/ByteArrayOutputStream;)V 
    .code stack 6 locals 6 
L0:     new OIDTokenizer 
L3:     dup 
L4:     aload_0 
L5:     getfield Field ASN1ObjectIdentifier identifier Ljava/lang/String; 
L8:     invokespecial Method OIDTokenizer <init> (Ljava/lang/String;)V 
L11:    astore_2 
L12:    aload_2 
L13:    invokevirtual Method OIDTokenizer nextToken ()Ljava/lang/String; 
L16:    invokestatic Method java/lang/Integer parseInt (Ljava/lang/String;)I 
L19:    bipush 40 
L21:    imul 
L22:    istore_3 
L23:    aload_2 
L24:    invokevirtual Method OIDTokenizer nextToken ()Ljava/lang/String; 
L27:    astore 4 
L29:    aload 4 
L31:    invokevirtual Method java/lang/String length ()I 
L34:    bipush 18 
L36:    if_icmpgt L55 
L39:    aload_0 
L40:    aload_1 
L41:    iload_3 
L42:    i2l 
L43:    aload 4 
L45:    invokestatic Method java/lang/Long parseLong (Ljava/lang/String;)J 
L48:    ladd 
L49:    invokespecial Method ASN1ObjectIdentifier writeField (Ljava/io/ByteArrayOutputStream;J)V 
L52:    goto L77 

        .stack append Object OIDTokenizer Integer Object java/lang/String 
L55:    aload_0 
L56:    aload_1 
L57:    new java/math/BigInteger 
L60:    dup 
L61:    aload 4 
L63:    invokespecial Method java/math/BigInteger <init> (Ljava/lang/String;)V 
L66:    iload_3 
L67:    i2l 
L68:    invokestatic Method java/math/BigInteger valueOf (J)Ljava/math/BigInteger; 
L71:    invokevirtual Method java/math/BigInteger add (Ljava/math/BigInteger;)Ljava/math/BigInteger; 
L74:    invokespecial Method ASN1ObjectIdentifier writeField (Ljava/io/ByteArrayOutputStream;Ljava/math/BigInteger;)V 

        .stack same 
L77:    aload_2 
L78:    invokevirtual Method OIDTokenizer hasMoreTokens ()Z 
L81:    ifeq L130 
L84:    aload_2 
L85:    invokevirtual Method OIDTokenizer nextToken ()Ljava/lang/String; 
L88:    astore 5 
L90:    aload 5 
L92:    invokevirtual Method java/lang/String length ()I 
L95:    bipush 18 
L97:    if_icmpgt L113 
L100:   aload_0 
L101:   aload_1 
L102:   aload 5 
L104:   invokestatic Method java/lang/Long parseLong (Ljava/lang/String;)J 
L107:   invokespecial Method ASN1ObjectIdentifier writeField (Ljava/io/ByteArrayOutputStream;J)V 
L110:   goto L127 

        .stack append Object java/lang/String 
L113:   aload_0 
L114:   aload_1 
L115:   new java/math/BigInteger 
L118:   dup 
L119:   aload 5 
L121:   invokespecial Method java/math/BigInteger <init> (Ljava/lang/String;)V 
L124:   invokespecial Method ASN1ObjectIdentifier writeField (Ljava/io/ByteArrayOutputStream;Ljava/math/BigInteger;)V 

        .stack chop 1 
L127:   goto L77 

        .stack same 
L130:   return 
L131:   
        .linenumbertable 
            L0 93 
            L12 94 
            L23 96 
            L29 97 
            L39 99 
            L55 103 
            L77 106 
            L84 108 
            L90 109 
            L100 111 
            L113 115 
            L127 117 
            L130 118 
        .end linenumbertable 
        .localvariabletable 
            5 is token Ljava/lang/String; from L90 to L127 
            0 is this LASN1ObjectIdentifier; from L0 to L131 
            1 is aOut Ljava/io/ByteArrayOutputStream; from L0 to L131 
            2 is tok LOIDTokenizer; from L12 to L131 
            3 is first I from L23 to L131 
            4 is secondToken Ljava/lang/String; from L29 to L131 
        .end localvariabletable 
    .end code 
.end method 

.method private synchronized getBody : ()[B 
    .code stack 2 locals 2 
L0:     aload_0 
L1:     getfield Field ASN1ObjectIdentifier body [B 
L4:     ifnonnull L28 
L7:     new java/io/ByteArrayOutputStream 
L10:    dup 
L11:    invokespecial Method java/io/ByteArrayOutputStream <init> ()V 
L14:    astore_1 
L15:    aload_0 
L16:    aload_1 
L17:    invokespecial Method ASN1ObjectIdentifier doOutput (Ljava/io/ByteArrayOutputStream;)V 
L20:    aload_0 
L21:    aload_1 
L22:    invokevirtual Method java/io/ByteArrayOutputStream toByteArray ()[B 
L25:    putfield Field ASN1ObjectIdentifier body [B 

        .stack same 
L28:    aload_0 
L29:    getfield Field ASN1ObjectIdentifier body [B 
L32:    areturn 
L33:    
        .linenumbertable 
            L0 122 
            L7 124 
            L15 126 
            L20 128 
            L28 131 
        .end linenumbertable 
        .localvariabletable 
            1 is bOut Ljava/io/ByteArrayOutputStream; from L15 to L28 
            0 is this LASN1ObjectIdentifier; from L0 to L33 
        .end localvariabletable 
    .end code 
.end method 

.method encodedLength : ()I 
    .code stack 2 locals 2 
L0:     aload_0 
L1:     invokespecial Method ASN1ObjectIdentifier getBody ()[B 
L4:     arraylength 
L5:     istore_1 
L6:     iconst_1 
L7:     iload_1 
L8:     invokestatic Method StreamUtil calculateBodyLength (I)I 
L11:    iadd 
L12:    iload_1 
L13:    iadd 
L14:    ireturn 
L15:    
        .linenumbertable 
            L0 135 
            L6 137 
        .end linenumbertable 
        .localvariabletable 
            0 is this LASN1ObjectIdentifier; from L0 to L15 
            1 is length I from L6 to L15 
        .end localvariabletable 
    .end code 
.end method 

.method encode : (LASN1OutputStream;)V 
    .code stack 2 locals 3 
L0:     aload_0 
L1:     invokespecial Method ASN1ObjectIdentifier getBody ()[B 
L4:     astore_2 
L5:     aload_1 
L6:     bipush 6 
L8:     invokevirtual Method ASN1OutputStream write (I)V 
L11:    aload_1 
L12:    aload_2 
L13:    arraylength 
L14:    invokevirtual Method ASN1OutputStream writeLength (I)V 
L17:    aload_1 
L18:    aload_2 
L19:    invokevirtual Method ASN1OutputStream write ([B)V 
L22:    return 
L23:    
        .linenumbertable 
            L0 144 
            L5 146 
            L11 147 
            L17 148 
            L22 149 
        .end linenumbertable 
        .localvariabletable 
            0 is this LASN1ObjectIdentifier; from L0 to L23 
            1 is out LASN1OutputStream; from L0 to L23 
            2 is enc [B from L5 to L23 
        .end localvariabletable 
    .end code 
    .exceptions java/lang/Exception 
.end method 

.method public hashCode : ()I 
    .code stack 1 locals 1 
L0:     aload_0 
L1:     getfield Field ASN1ObjectIdentifier identifier Ljava/lang/String; 
L4:     invokevirtual Method java/lang/String hashCode ()I 
L7:     ireturn 
L8:     
        .linenumbertable 
            L0 153 
        .end linenumbertable 
        .localvariabletable 
            0 is this LASN1ObjectIdentifier; from L0 to L8 
        .end localvariabletable 
    .end code 
.end method 

.method asn1Equals : (LASN1Primitive;)Z 
    .code stack 2 locals 2 
L0:     aload_1 
L1:     aload_0 
L2:     if_acmpne L7 
L5:     iconst_1 
L6:     ireturn 

        .stack same 
L7:     aload_1 
L8:     instanceof ASN1ObjectIdentifier 
L11:    ifne L16 
L14:    iconst_0 
L15:    ireturn 

        .stack same 
L16:    aload_0 
L17:    getfield Field ASN1ObjectIdentifier identifier Ljava/lang/String; 
L20:    aload_1 
L21:    checkcast ASN1ObjectIdentifier 
L24:    getfield Field ASN1ObjectIdentifier identifier Ljava/lang/String; 
L27:    invokevirtual Method java/lang/String equals (Ljava/lang/Object;)Z 
L30:    ireturn 
L31:    
        .linenumbertable 
            L0 159 
            L5 161 
            L7 164 
            L14 166 
            L16 169 
        .end linenumbertable 
        .localvariabletable 
            0 is this LASN1ObjectIdentifier; from L0 to L31 
            1 is o LASN1Primitive; from L0 to L31 
        .end localvariabletable 
    .end code 
.end method 

.method public toString : ()Ljava/lang/String; 
    .code stack 1 locals 1 
L0:     aload_0 
L1:     invokespecial Method ASN1ObjectIdentifier getId ()Ljava/lang/String; 
L4:     areturn 
L5:     
        .linenumbertable 
            L0 174 
        .end linenumbertable 
        .localvariabletable 
            0 is this LASN1ObjectIdentifier; from L0 to L5 
        .end localvariabletable 
    .end code 
.end method 

.method private static isValidBranchID : (Ljava/lang/String;I)Z 
    .code stack 2 locals 5 
L0:     iconst_0 
L1:     istore_2 
L2:     aload_0 
L3:     invokevirtual Method java/lang/String length ()I 
L6:     istore_3 

        .stack append Integer Integer 
L7:     iinc 3 -1 
L10:    iload_3 
L11:    iload_1 
L12:    if_icmplt L61 
L15:    aload_0 
L16:    iload_3 
L17:    invokevirtual Method java/lang/String charAt (I)C 
L20:    istore 4 
L22:    bipush 48 
L24:    iload 4 
L26:    if_icmpgt L41 
L29:    iload 4 
L31:    bipush 57 
L33:    if_icmpgt L41 
L36:    iconst_1 
L37:    istore_2 
L38:    goto L7 

        .stack append Integer 
L41:    iload 4 
L43:    bipush 46 
L45:    if_icmpne L59 
L48:    iload_2 
L49:    ifne L54 
L52:    iconst_0 
L53:    ireturn 

        .stack same 
L54:    iconst_0 
L55:    istore_2 
L56:    goto L7 

        .stack same 
L59:    iconst_0 
L60:    ireturn 

        .stack chop 1 
L61:    iload_2 
L62:    ireturn 
L63:    
        .linenumbertable 
            L0 180 
            L2 182 
            L7 183 
            L15 185 
            L22 188 
            L36 190 
            L38 191 
            L41 194 
            L48 196 
            L52 198 
            L54 201 
            L56 202 
            L59 205 
            L61 208 
        .end linenumbertable 
        .localvariabletable 
            4 is ch C from L22 to L61 
            0 is branchID Ljava/lang/String; from L0 to L63 
            1 is start I from L0 to L63 
            2 is periodAllowed Z from L2 to L63 
            3 is pos I from L7 to L63 
        .end localvariabletable 
    .end code 
.end method 

.method private static isValidIdentifier : (Ljava/lang/String;)Z 
    .code stack 2 locals 2 
L0:     aload_0 
L1:     invokevirtual Method java/lang/String length ()I 
L4:     iconst_3 
L5:     if_icmplt L18 
L8:     aload_0 
L9:     iconst_1 
L10:    invokevirtual Method java/lang/String charAt (I)C 
L13:    bipush 46 
L15:    if_icmpeq L20 

        .stack same 
L18:    iconst_0 
L19:    ireturn 

        .stack same 
L20:    aload_0 
L21:    iconst_0 
L22:    invokevirtual Method java/lang/String charAt (I)C 
L25:    istore_1 
L26:    iload_1 
L27:    bipush 48 
L29:    if_icmplt L38 
L32:    iload_1 
L33:    bipush 50 
L35:    if_icmple L40 

        .stack append Integer 
L38:    iconst_0 
L39:    ireturn 

        .stack same 
L40:    aload_0 
L41:    iconst_2 
L42:    invokestatic Method ASN1ObjectIdentifier isValidBranchID (Ljava/lang/String;I)Z 
L45:    ireturn 
L46:    
        .linenumbertable 
            L0 214 
            L18 216 
            L20 219 
            L26 220 
            L38 222 
            L40 225 
        .end linenumbertable 
        .localvariabletable 
            0 is identifier Ljava/lang/String; from L0 to L46 
            1 is first C from L26 to L46 
        .end localvariabletable 
    .end code 
.end method 
.sourcefile 'ASN1ObjectIdentifier.java' 
.end class 
