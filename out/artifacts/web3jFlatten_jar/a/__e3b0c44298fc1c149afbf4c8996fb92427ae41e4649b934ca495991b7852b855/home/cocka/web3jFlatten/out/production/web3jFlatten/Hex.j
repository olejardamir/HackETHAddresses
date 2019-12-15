.version 52 0 
.class super Hex 
.super java/lang/Object 
.field private static final encoder LEncoder; 

.method <init> : ()V 
    .code stack 1 locals 1 
L0:     aload_0 
L1:     invokespecial Method java/lang/Object <init> ()V 
L4:     return 
L5:     
        .linenumbertable 
            L0 4 
        .end linenumbertable 
        .localvariabletable 
            0 is this LHex; from L0 to L5 
        .end localvariabletable 
    .end code 
.end method 

.method public static encode : ([B)[B 
    .code stack 2 locals 1 
L0:     aload_0 
L1:     aload_0 
L2:     arraylength 
L3:     invokestatic Method Hex encode ([BI)[B 
L6:     areturn 
L7:     
        .linenumbertable 
            L0 15 
        .end linenumbertable 
        .localvariabletable 
            0 is data [B from L0 to L7 
        .end localvariabletable 
    .end code 
    .exceptions java/lang/Exception 
.end method 

.method private static encode : ([BI)[B 
    .code stack 5 locals 3 
L0:     new java/io/ByteArrayOutputStream 
L3:     dup 
L4:     invokespecial Method java/io/ByteArrayOutputStream <init> ()V 
L7:     astore_2 
L8:     getstatic Field Hex encoder LEncoder; 
L11:    aload_0 
L12:    iconst_0 
L13:    iload_1 
L14:    aload_2 
L15:    invokeinterface InterfaceMethod Encoder encode ([BIILjava/io/OutputStream;)V 5 
L20:    aload_2 
L21:    invokevirtual Method java/io/ByteArrayOutputStream toByteArray ()[B 
L24:    areturn 
L25:    
        .linenumbertable 
            L0 22 
            L8 25 
            L20 28 
        .end linenumbertable 
        .localvariabletable 
            0 is data [B from L0 to L25 
            1 is length I from L0 to L25 
            2 is bOut Ljava/io/ByteArrayOutputStream; from L8 to L25 
        .end localvariabletable 
    .end code 
    .exceptions java/lang/Exception 
.end method 

.method public static decode : (Ljava/lang/String;)[B 
    .code stack 3 locals 2 
L0:     new java/io/ByteArrayOutputStream 
L3:     dup 
L4:     invokespecial Method java/io/ByteArrayOutputStream <init> ()V 
L7:     astore_1 
L8:     getstatic Field Hex encoder LEncoder; 
L11:    aload_0 
L12:    aload_1 
L13:    invokeinterface InterfaceMethod Encoder decode (Ljava/lang/String;Ljava/io/OutputStream;)V 3 
L18:    aload_1 
L19:    invokevirtual Method java/io/ByteArrayOutputStream toByteArray ()[B 
L22:    areturn 
L23:    
        .linenumbertable 
            L0 34 
            L8 37 
            L18 40 
        .end linenumbertable 
        .localvariabletable 
            0 is data Ljava/lang/String; from L0 to L23 
            1 is bOut Ljava/io/ByteArrayOutputStream; from L8 to L23 
        .end localvariabletable 
    .end code 
    .exceptions java/lang/Exception 
.end method 

.method static <clinit> : ()V 
    .code stack 2 locals 0 
L0:     new HexEncoder 
L3:     dup 
L4:     invokespecial Method HexEncoder <init> ()V 
L7:     putstatic Field Hex encoder LEncoder; 
L10:    return 
L11:    
        .linenumbertable 
            L0 6 
        .end linenumbertable 
    .end code 
.end method 
.sourcefile 'Hex.java' 
.end class 
