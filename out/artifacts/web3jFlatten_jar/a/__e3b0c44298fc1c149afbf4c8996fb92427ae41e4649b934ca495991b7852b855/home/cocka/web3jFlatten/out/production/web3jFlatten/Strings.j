.version 52 0 
.class final super Strings 
.super java/lang/Object 

.method <init> : ()V 
    .code stack 1 locals 1 
L0:     aload_0 
L1:     invokespecial Method java/lang/Object <init> ()V 
L4:     return 
L5:     
        .linenumbertable 
            L0 2 
        .end linenumbertable 
        .localvariabletable 
            0 is this LStrings; from L0 to L5 
        .end localvariabletable 
    .end code 
.end method 

.method public static toLowerCase : (Ljava/lang/String;)Ljava/lang/String; 
    .code stack 4 locals 5 
L0:     iconst_0 
L1:     istore_1 
L2:     aload_0 
L3:     invokevirtual Method java/lang/String toCharArray ()[C 
L6:     astore_2 
L7:     iconst_0 
L8:     istore_3 

        .stack append Integer Object [C Integer 
L9:     iload_3 
L10:    aload_2 
L11:    arraylength 
L12:    if_icmpeq L54 
L15:    aload_2 
L16:    iload_3 
L17:    caload 
L18:    istore 4 
L20:    bipush 65 
L22:    iload 4 
L24:    if_icmpgt L48 
L27:    bipush 90 
L29:    iload 4 
L31:    if_icmplt L48 
L34:    iconst_1 
L35:    istore_1 
L36:    aload_2 
L37:    iload_3 
L38:    iload 4 
L40:    bipush 65 
L42:    isub 
L43:    bipush 97 
L45:    iadd 
L46:    i2c 
L47:    castore 

        .stack same 
L48:    iinc 3 1 
L51:    goto L9 

        .stack chop 1 
L54:    iload_1 
L55:    ifeq L67 
L58:    new java/lang/String 
L61:    dup 
L62:    aload_2 
L63:    invokespecial Method java/lang/String <init> ([C)V 
L66:    areturn 

        .stack same 
L67:    aload_0 
L68:    areturn 
L69:    
        .linenumbertable 
            L0 9 
            L2 10 
            L7 12 
            L15 14 
            L20 15 
            L34 17 
            L36 18 
            L48 12 
            L54 22 
            L58 24 
            L67 27 
        .end linenumbertable 
        .localvariabletable 
            4 is ch C from L20 to L48 
            3 is i I from L9 to L54 
            0 is string Ljava/lang/String; from L0 to L69 
            1 is changed Z from L2 to L69 
            2 is chars [C from L7 to L69 
        .end localvariabletable 
    .end code 
.end method 

.method public static fromByteArray : ([B)Ljava/lang/String; 
    .code stack 3 locals 1 
L0:     new java/lang/String 
L3:     dup 
L4:     aload_0 
L5:     invokestatic Method Strings asCharArray ([B)[C 
L8:     invokespecial Method java/lang/String <init> ([C)V 
L11:    areturn 
L12:    
        .linenumbertable 
            L0 33 
        .end linenumbertable 
        .localvariabletable 
            0 is bytes [B from L0 to L12 
        .end localvariabletable 
    .end code 
.end method 

.method private static asCharArray : ([B)[C 
    .code stack 4 locals 3 
L0:     aload_0 
L1:     arraylength 
L2:     newarray char 
L4:     astore_1 
L5:     iconst_0 
L6:     istore_2 

        .stack append Object [C Integer 
L7:     iload_2 
L8:     aload_1 
L9:     arraylength 
L10:    if_icmpeq L30 
L13:    aload_1 
L14:    iload_2 
L15:    aload_0 
L16:    iload_2 
L17:    baload 
L18:    sipush 255 
L21:    iand 
L22:    i2c 
L23:    castore 
L24:    iinc 2 1 
L27:    goto L7 

        .stack chop 1 
L30:    aload_1 
L31:    areturn 
L32:    
        .linenumbertable 
            L0 38 
            L5 40 
            L13 42 
            L24 40 
            L30 45 
        .end linenumbertable 
        .localvariabletable 
            2 is i I from L7 to L30 
            0 is bytes [B from L0 to L32 
            1 is chars [C from L5 to L32 
        .end localvariabletable 
    .end code 
.end method 
.sourcefile 'Strings.java' 
.end class 
