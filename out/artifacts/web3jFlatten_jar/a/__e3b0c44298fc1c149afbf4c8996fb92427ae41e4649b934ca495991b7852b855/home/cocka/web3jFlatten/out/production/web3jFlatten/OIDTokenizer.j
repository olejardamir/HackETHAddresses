.version 52 0 
.class super OIDTokenizer 
.super java/lang/Object 
.field private final oid Ljava/lang/String; 
.field private index I 

.method public <init> : (Ljava/lang/String;)V 
    .code stack 2 locals 2 
L0:     aload_0 
L1:     invokespecial Method java/lang/Object <init> ()V 
L4:     aload_0 
L5:     aload_1 
L6:     putfield Field OIDTokenizer oid Ljava/lang/String; 
L9:     aload_0 
L10:    iconst_0 
L11:    putfield Field OIDTokenizer index I 
L14:    return 
L15:    
        .linenumbertable 
            L0 11 
            L4 12 
            L9 13 
            L14 14 
        .end linenumbertable 
        .localvariabletable 
            0 is this LOIDTokenizer; from L0 to L15 
            1 is oid Ljava/lang/String; from L0 to L15 
        .end localvariabletable 
    .end code 
.end method 

.method public hasMoreTokens : ()Z 
    .code stack 2 locals 1 
L0:     aload_0 
L1:     getfield Field OIDTokenizer index I 
L4:     iconst_m1 
L5:     if_icmpeq L12 
L8:     iconst_1 
L9:     goto L13 

        .stack same 
L12:    iconst_0 

        .stack stack_1 Integer 
L13:    ireturn 
L14:    
        .linenumbertable 
            L0 19 
        .end linenumbertable 
        .localvariabletable 
            0 is this LOIDTokenizer; from L0 to L14 
        .end localvariabletable 
    .end code 
.end method 

.method public nextToken : ()Ljava/lang/String; 
    .code stack 3 locals 3 
L0:     aload_0 
L1:     getfield Field OIDTokenizer index I 
L4:     iconst_m1 
L5:     if_icmpne L10 
L8:     aconst_null 
L9:     areturn 

        .stack same 
L10:    aload_0 
L11:    getfield Field OIDTokenizer oid Ljava/lang/String; 
L14:    bipush 46 
L16:    aload_0 
L17:    getfield Field OIDTokenizer index I 
L20:    invokevirtual Method java/lang/String indexOf (II)I 
L23:    istore_2 
L24:    iload_2 
L25:    iconst_m1 
L26:    if_icmpne L48 
L29:    aload_0 
L30:    getfield Field OIDTokenizer oid Ljava/lang/String; 
L33:    aload_0 
L34:    getfield Field OIDTokenizer index I 
L37:    invokevirtual Method java/lang/String substring (I)Ljava/lang/String; 
L40:    astore_1 
L41:    aload_0 
L42:    iconst_m1 
L43:    putfield Field OIDTokenizer index I 
L46:    aload_1 
L47:    areturn 

        .stack append Top Integer 
L48:    aload_0 
L49:    getfield Field OIDTokenizer oid Ljava/lang/String; 
L52:    aload_0 
L53:    getfield Field OIDTokenizer index I 
L56:    iload_2 
L57:    invokevirtual Method java/lang/String substring (II)Ljava/lang/String; 
L60:    astore_1 
L61:    aload_0 
L62:    iload_2 
L63:    iconst_1 
L64:    iadd 
L65:    putfield Field OIDTokenizer index I 
L68:    aload_1 
L69:    areturn 
L70:    
        .linenumbertable 
            L0 25 
            L8 27 
            L10 31 
            L24 33 
            L29 35 
            L41 36 
            L46 37 
            L48 40 
            L61 42 
            L68 43 
        .end linenumbertable 
        .localvariabletable 
            1 is token Ljava/lang/String; from L41 to L48 
            0 is this LOIDTokenizer; from L0 to L70 
            1 is token Ljava/lang/String; from L61 to L70 
            2 is end I from L24 to L70 
        .end localvariabletable 
    .end code 
.end method 
.sourcefile 'OIDTokenizer.java' 
.end class 
