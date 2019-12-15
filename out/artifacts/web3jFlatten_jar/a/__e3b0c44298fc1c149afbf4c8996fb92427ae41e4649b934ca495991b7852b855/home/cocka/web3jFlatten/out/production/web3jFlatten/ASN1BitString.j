.version 52 0 
.class public super abstract ASN1BitString 
.super ASN1Primitive 
.field private static final table [C 
.field final data [B 
.field final padBits I 

.method <init> : ([BI)V 
    .code stack 3 locals 3 
L0:     aload_0 
L1:     invokespecial Method ASN1Primitive <init> ()V 
L4:     aload_1 
L5:     ifnonnull L18 
L8:     new java/lang/NullPointerException 
L11:    dup 
L12:    ldc 'data cannot be null' 
L14:    invokespecial Method java/lang/NullPointerException <init> (Ljava/lang/String;)V 
L17:    athrow 

        .stack full 
            locals Object ASN1BitString Object [B Integer 
            stack 
        .end stack 
L18:    aload_1 
L19:    arraylength 
L20:    ifne L37 
L23:    iload_2 
L24:    ifeq L37 
L27:    new java/lang/IllegalArgumentException 
L30:    dup 
L31:    ldc 'zero length data with non-zero pad bits' 
L33:    invokespecial Method java/lang/IllegalArgumentException <init> (Ljava/lang/String;)V 
L36:    athrow 

        .stack same 
L37:    iload_2 
L38:    bipush 7 
L40:    if_icmpgt L47 
L43:    iload_2 
L44:    ifge L57 

        .stack same 
L47:    new java/lang/IllegalArgumentException 
L50:    dup 
L51:    ldc 'pad bits cannot be greater than 7 or less than 0' 
L53:    invokespecial Method java/lang/IllegalArgumentException <init> (Ljava/lang/String;)V 
L56:    athrow 

        .stack same 
L57:    aload_0 
L58:    aload_1 
L59:    invokestatic Method Arrays clone ([B)[B 
L62:    putfield Field ASN1BitString data [B 
L65:    aload_0 
L66:    iload_2 
L67:    putfield Field ASN1BitString padBits I 
L70:    return 
L71:    
        .linenumbertable 
            L0 15 
            L4 16 
            L8 18 
            L18 20 
            L27 22 
            L37 24 
            L47 26 
            L57 29 
            L65 30 
            L70 31 
        .end linenumbertable 
        .localvariabletable 
            0 is this LASN1BitString; from L0 to L71 
            1 is data [B from L0 to L71 
            2 is padBits I from L0 to L71 
        .end localvariabletable 
    .end code 
.end method 

.method private getString : ()Ljava/lang/String; 
    .code stack 4 locals 6 
L0:     new java/lang/StringBuilder 
L3:     dup 
L4:     ldc '#' 
L6:     invokespecial Method java/lang/StringBuilder <init> (Ljava/lang/String;)V 
L9:     astore_1 
L10:    new java/io/ByteArrayOutputStream 
L13:    dup 
L14:    invokespecial Method java/io/ByteArrayOutputStream <init> ()V 
L17:    astore_2 
L18:    new ASN1OutputStream 
L21:    dup 
L22:    aload_2 
L23:    invokespecial Method ASN1OutputStream <init> (Ljava/io/OutputStream;)V 
L26:    astore_3 
L27:    aload_3 
L28:    aload_0 
L29:    invokevirtual Method ASN1OutputStream writeObject (LASN1Encodable;)V 
L32:    aload_2 
L33:    invokevirtual Method java/io/ByteArrayOutputStream toByteArray ()[B 
L36:    astore 4 
L38:    iconst_0 
L39:    istore 5 

        .stack full 
            locals Object ASN1BitString Object java/lang/StringBuilder Object java/io/ByteArrayOutputStream Object ASN1OutputStream Object [B Integer 
            stack 
        .end stack 
L41:    iload 5 
L43:    aload 4 
L45:    arraylength 
L46:    if_icmpeq L91 
L49:    aload_1 
L50:    getstatic Field ASN1BitString table [C 
L53:    aload 4 
L55:    iload 5 
L57:    baload 
L58:    iconst_4 
L59:    iushr 
L60:    bipush 15 
L62:    iand 
L63:    caload 
L64:    invokevirtual Method java/lang/StringBuilder append (C)Ljava/lang/StringBuilder; 
L67:    pop 
L68:    aload_1 
L69:    getstatic Field ASN1BitString table [C 
L72:    aload 4 
L74:    iload 5 
L76:    baload 
L77:    bipush 15 
L79:    iand 
L80:    caload 
L81:    invokevirtual Method java/lang/StringBuilder append (C)Ljava/lang/StringBuilder; 
L84:    pop 
L85:    iinc 5 1 
L88:    goto L41 

        .stack chop 1 
L91:    aload_1 
L92:    invokevirtual Method java/lang/StringBuilder toString ()Ljava/lang/String; 
L95:    areturn 
L96:    
        .linenumbertable 
            L0 35 
            L10 36 
            L18 37 
            L27 40 
            L32 42 
            L38 44 
            L49 46 
            L68 47 
            L85 44 
            L91 50 
        .end linenumbertable 
        .localvariabletable 
            5 is i I from L41 to L91 
            0 is this LASN1BitString; from L0 to L96 
            1 is buf Ljava/lang/StringBuilder; from L10 to L96 
            2 is bOut Ljava/io/ByteArrayOutputStream; from L18 to L96 
            3 is aOut LASN1OutputStream; from L27 to L96 
            4 is string [B from L38 to L96 
        .end localvariabletable 
    .end code 
    .exceptions java/lang/Exception 
.end method 

.method private getBytes : ()[B 
    .code stack 2 locals 1 
L0:     aload_0 
L1:     getfield Field ASN1BitString data [B 
L4:     aload_0 
L5:     getfield Field ASN1BitString padBits I 
L8:     invokestatic Method ASN1BitString derForm ([BI)[B 
L11:    areturn 
L12:    
        .linenumbertable 
            L0 55 
        .end linenumbertable 
        .localvariabletable 
            0 is this LASN1BitString; from L0 to L12 
        .end localvariabletable 
    .end code 
.end method 

.method getPadBits : ()I 
    .code stack 1 locals 1 
L0:     aload_0 
L1:     getfield Field ASN1BitString padBits I 
L4:     ireturn 
L5:     
        .linenumbertable 
            L0 60 
        .end linenumbertable 
        .localvariabletable 
            0 is this LASN1BitString; from L0 to L5 
        .end localvariabletable 
    .end code 
.end method 

.method public toString : ()Ljava/lang/String; 
    .code stack 1 locals 2 
        .catch java/lang/Exception from L0 to L4 using L5 
L0:     aload_0 
L1:     invokespecial Method ASN1BitString getString ()Ljava/lang/String; 
L4:     areturn 

        .stack stack_1 Object java/lang/Exception 
L5:     astore_1 
L6:     aload_1 
L7:     invokevirtual Method java/lang/Exception printStackTrace ()V 
L10:    aconst_null 
L11:    areturn 
L12:    
        .linenumbertable 
            L0 66 
            L5 67 
            L6 68 
            L10 70 
        .end linenumbertable 
        .localvariabletable 
            1 is e Ljava/lang/Exception; from L6 to L10 
            0 is this LASN1BitString; from L0 to L12 
        .end localvariabletable 
    .end code 
.end method 

.method public hashCode : ()I 
    .code stack 2 locals 1 
L0:     aload_0 
L1:     getfield Field ASN1BitString padBits I 
L4:     aload_0 
L5:     invokespecial Method ASN1BitString getBytes ()[B 
L8:     invokestatic Method Arrays hashCode ([B)I 
L11:    ixor 
L12:    ireturn 
L13:    
        .linenumbertable 
            L0 75 
        .end linenumbertable 
        .localvariabletable 
            0 is this LASN1BitString; from L0 to L13 
        .end localvariabletable 
    .end code 
.end method 

.method protected asn1Equals : (LASN1Primitive;)Z 
    .code stack 2 locals 3 
L0:     aload_1 
L1:     instanceof ASN1BitString 
L4:     ifne L9 
L7:     iconst_0 
L8:     ireturn 

        .stack same 
L9:     aload_1 
L10:    checkcast ASN1BitString 
L13:    astore_2 
L14:    aload_0 
L15:    getfield Field ASN1BitString padBits I 
L18:    aload_2 
L19:    getfield Field ASN1BitString padBits I 
L22:    if_icmpne L43 
L25:    aload_0 
L26:    invokespecial Method ASN1BitString getBytes ()[B 
L29:    aload_2 
L30:    invokespecial Method ASN1BitString getBytes ()[B 
L33:    invokestatic Method Arrays areEqual ([B[B)Z 
L36:    ifeq L43 
L39:    iconst_1 
L40:    goto L44 

        .stack append Object ASN1BitString 
L43:    iconst_0 

        .stack stack_1 Integer 
L44:    ireturn 
L45:    
        .linenumbertable 
            L0 81 
            L7 83 
            L9 86 
            L14 88 
            L26 89 
            L44 88 
        .end linenumbertable 
        .localvariabletable 
            0 is this LASN1BitString; from L0 to L45 
            1 is o LASN1Primitive; from L0 to L45 
            2 is other LASN1BitString; from L14 to L45 
        .end localvariabletable 
    .end code 
.end method 

.method static derForm : ([BI)[B 
    .code stack 5 locals 3 
L0:     aload_0 
L1:     invokestatic Method Arrays clone ([B)[B 
L4:     astore_2 
L5:     iload_1 
L6:     ifle L24 
L9:     aload_2 
L10:    aload_0 
L11:    arraylength 
L12:    iconst_1 
L13:    isub 
L14:    dup2 
L15:    baload 
L16:    sipush 255 
L19:    iload_1 
L20:    ishl 
L21:    iand 
L22:    i2b 
L23:    bastore 

        .stack append Object [B 
L24:    aload_2 
L25:    areturn 
L26:    
        .linenumbertable 
            L0 94 
            L5 96 
            L9 98 
            L24 101 
        .end linenumbertable 
        .localvariabletable 
            0 is data [B from L0 to L26 
            1 is padBits I from L0 to L26 
            2 is rv [B from L5 to L26 
        .end localvariabletable 
    .end code 
.end method 

.method toDERObject : ()LASN1Primitive; 
    .code stack 4 locals 1 
L0:     new DERBitString 
L3:     dup 
L4:     aload_0 
L5:     getfield Field ASN1BitString data [B 
L8:     aload_0 
L9:     getfield Field ASN1BitString padBits I 
L12:    invokespecial Method DERBitString <init> ([BI)V 
L15:    areturn 
L16:    
        .linenumbertable 
            L0 106 
        .end linenumbertable 
        .localvariabletable 
            0 is this LASN1BitString; from L0 to L16 
        .end localvariabletable 
    .end code 
.end method 

.method abstract encode : (LASN1OutputStream;)V 
    .exceptions java/lang/Exception 
.end method 

.method static <clinit> : ()V 
    .code stack 4 locals 0 
L0:     bipush 16 
L2:     newarray char 
L4:     dup 
L5:     iconst_0 
L6:     bipush 48 
L8:     castore 
L9:     dup 
L10:    iconst_1 
L11:    bipush 49 
L13:    castore 
L14:    dup 
L15:    iconst_2 
L16:    bipush 50 
L18:    castore 
L19:    dup 
L20:    iconst_3 
L21:    bipush 51 
L23:    castore 
L24:    dup 
L25:    iconst_4 
L26:    bipush 52 
L28:    castore 
L29:    dup 
L30:    iconst_5 
L31:    bipush 53 
L33:    castore 
L34:    dup 
L35:    bipush 6 
L37:    bipush 54 
L39:    castore 
L40:    dup 
L41:    bipush 7 
L43:    bipush 55 
L45:    castore 
L46:    dup 
L47:    bipush 8 
L49:    bipush 56 
L51:    castore 
L52:    dup 
L53:    bipush 9 
L55:    bipush 57 
L57:    castore 
L58:    dup 
L59:    bipush 10 
L61:    bipush 65 
L63:    castore 
L64:    dup 
L65:    bipush 11 
L67:    bipush 66 
L69:    castore 
L70:    dup 
L71:    bipush 12 
L73:    bipush 67 
L75:    castore 
L76:    dup 
L77:    bipush 13 
L79:    bipush 68 
L81:    castore 
L82:    dup 
L83:    bipush 14 
L85:    bipush 69 
L87:    castore 
L88:    dup 
L89:    bipush 15 
L91:    bipush 70 
L93:    castore 
L94:    putstatic Field ASN1BitString table [C 
L97:    return 
L98:    
        .linenumbertable 
            L0 6 
        .end linenumbertable 
    .end code 
.end method 
.sourcefile 'ASN1BitString.java' 
.end class 
