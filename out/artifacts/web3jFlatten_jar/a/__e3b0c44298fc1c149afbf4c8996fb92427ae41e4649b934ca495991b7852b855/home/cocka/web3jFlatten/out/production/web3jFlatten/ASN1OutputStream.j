.version 52 0 
.class super ASN1OutputStream 
.super java/lang/Object 
.field private final os Ljava/io/OutputStream; 

.method public <init> : (Ljava/io/OutputStream;)V 
    .code stack 2 locals 2 
L0:     aload_0 
L1:     invokespecial Method java/lang/Object <init> ()V 
L4:     aload_0 
L5:     aload_1 
L6:     putfield Field ASN1OutputStream os Ljava/io/OutputStream; 
L9:     return 
L10:    
        .linenumbertable 
            L0 12 
            L4 13 
            L9 14 
        .end linenumbertable 
        .localvariabletable 
            0 is this LASN1OutputStream; from L0 to L10 
            1 is os Ljava/io/OutputStream; from L0 to L10 
        .end localvariabletable 
    .end code 
.end method 

.method writeLength : (I)V 
    .code stack 3 locals 5 
L0:     iload_1 
L1:     bipush 127 
L3:     if_icmple L66 
L6:     iconst_1 
L7:     istore_2 
L8:     iload_1 
L9:     istore_3 

        .stack append Integer Integer 
L10:    iload_3 
L11:    bipush 8 
L13:    iushr 
L14:    dup 
L15:    istore_3 
L16:    ifeq L25 
L19:    iinc 2 1 
L22:    goto L10 

        .stack same 
L25:    aload_0 
L26:    iload_2 
L27:    sipush 128 
L30:    ior 
L31:    i2b 
L32:    invokevirtual Method ASN1OutputStream write (I)V 
L35:    iload_2 
L36:    iconst_1 
L37:    isub 
L38:    bipush 8 
L40:    imul 
L41:    istore 4 

        .stack append Integer 
L43:    iload 4 
L45:    iflt L63 
L48:    aload_0 
L49:    iload_1 
L50:    iload 4 
L52:    ishr 
L53:    i2b 
L54:    invokevirtual Method ASN1OutputStream write (I)V 
L57:    iinc 4 -8 
L60:    goto L43 

        .stack chop 3 
L63:    goto L72 

        .stack same 
L66:    aload_0 
L67:    iload_1 
L68:    i2b 
L69:    invokevirtual Method ASN1OutputStream write (I)V 

        .stack same 
L72:    return 
L73:    
        .linenumbertable 
            L0 20 
            L6 22 
            L8 23 
            L10 25 
            L19 27 
            L25 30 
            L35 32 
            L48 34 
            L57 32 
            L63 36 
            L66 39 
            L72 41 
        .end linenumbertable 
        .localvariabletable 
            4 is i I from L43 to L63 
            2 is size I from L8 to L63 
            3 is val I from L10 to L63 
            0 is this LASN1OutputStream; from L0 to L73 
            1 is length I from L0 to L73 
        .end localvariabletable 
    .end code 
    .exceptions java/lang/Exception 
.end method 

.method write : (I)V 
    .code stack 2 locals 2 
L0:     aload_0 
L1:     getfield Field ASN1OutputStream os Ljava/io/OutputStream; 
L4:     iload_1 
L5:     invokevirtual Method java/io/OutputStream write (I)V 
L8:     return 
L9:     
        .linenumbertable 
            L0 46 
            L8 47 
        .end linenumbertable 
        .localvariabletable 
            0 is this LASN1OutputStream; from L0 to L9 
            1 is b I from L0 to L9 
        .end localvariabletable 
    .end code 
    .exceptions java/lang/Exception 
.end method 

.method write : ([B)V 
    .code stack 2 locals 2 
L0:     aload_0 
L1:     getfield Field ASN1OutputStream os Ljava/io/OutputStream; 
L4:     aload_1 
L5:     invokevirtual Method java/io/OutputStream write ([B)V 
L8:     return 
L9:     
        .linenumbertable 
            L0 52 
            L8 53 
        .end linenumbertable 
        .localvariabletable 
            0 is this LASN1OutputStream; from L0 to L9 
            1 is bytes [B from L0 to L9 
        .end localvariabletable 
    .end code 
    .exceptions java/lang/Exception 
.end method 

.method writeEncoded : (I[B)V 
    .code stack 2 locals 3 
L0:     aload_0 
L1:     iload_1 
L2:     invokevirtual Method ASN1OutputStream write (I)V 
L5:     aload_0 
L6:     aload_2 
L7:     arraylength 
L8:     invokevirtual Method ASN1OutputStream writeLength (I)V 
L11:    aload_0 
L12:    aload_2 
L13:    invokevirtual Method ASN1OutputStream write ([B)V 
L16:    return 
L17:    
        .linenumbertable 
            L0 60 
            L5 61 
            L11 62 
            L16 63 
        .end linenumbertable 
        .localvariabletable 
            0 is this LASN1OutputStream; from L0 to L17 
            1 is tag I from L0 to L17 
            2 is bytes [B from L0 to L17 
        .end localvariabletable 
    .end code 
    .exceptions java/lang/Exception 
.end method 

.method public writeObject : (LASN1Encodable;)V 
    .code stack 3 locals 2 
L0:     aload_1 
L1:     ifnull L17 
L4:     aload_1 
L5:     invokeinterface InterfaceMethod ASN1Encodable toASN1Primitive ()LASN1Primitive; 1 
L10:    aload_0 
L11:    invokevirtual Method ASN1Primitive encode (LASN1OutputStream;)V 
L14:    goto L27 

        .stack same 
L17:    new java/io/IOException 
L20:    dup 
L21:    ldc 'null object detected' 
L23:    invokespecial Method java/io/IOException <init> (Ljava/lang/String;)V 
L26:    athrow 

        .stack same 
L27:    return 
L28:    
        .linenumbertable 
            L0 69 
            L4 71 
            L17 75 
            L27 77 
        .end linenumbertable 
        .localvariabletable 
            0 is this LASN1OutputStream; from L0 to L28 
            1 is obj LASN1Encodable; from L0 to L28 
        .end localvariabletable 
    .end code 
    .exceptions java/lang/Exception 
.end method 

.method getDERSubStream : ()LASN1OutputStream; 
    .code stack 3 locals 1 
L0:     new DEROutputStream 
L3:     dup 
L4:     aload_0 
L5:     getfield Field ASN1OutputStream os Ljava/io/OutputStream; 
L8:     invokespecial Method DEROutputStream <init> (Ljava/io/OutputStream;)V 
L11:    areturn 
L12:    
        .linenumbertable 
            L0 81 
        .end linenumbertable 
        .localvariabletable 
            0 is this LASN1OutputStream; from L0 to L12 
        .end localvariabletable 
    .end code 
.end method 
.sourcefile 'ASN1OutputStream.java' 
.end class 
