.version 52 0 
.class final super Arrays 
.super java/lang/Object 

.method <init> : ()V 
    .code stack 1 locals 1 
L0:     aload_0 
L1:     invokespecial Method java/lang/Object <init> ()V 
L4:     return 
L5:     
        .linenumbertable 
            L0 1 
        .end linenumbertable 
        .localvariabletable 
            0 is this LArrays; from L0 to L5 
        .end localvariabletable 
    .end code 
.end method 

.method public static areEqual : ([B[B)Z 
    .code stack 3 locals 3 
L0:     aload_0 
L1:     aload_1 
L2:     if_acmpne L7 
L5:     iconst_1 
L6:     ireturn 

        .stack same 
L7:     aload_0 
L8:     ifnull L15 
L11:    aload_1 
L12:    ifnonnull L17 

        .stack same 
L15:    iconst_0 
L16:    ireturn 

        .stack same 
L17:    aload_0 
L18:    arraylength 
L19:    aload_1 
L20:    arraylength 
L21:    if_icmpeq L26 
L24:    iconst_0 
L25:    ireturn 

        .stack same 
L26:    iconst_0 
L27:    istore_2 

        .stack append Integer 
L28:    iload_2 
L29:    aload_0 
L30:    arraylength 
L31:    if_icmpeq L51 
L34:    aload_0 
L35:    iload_2 
L36:    baload 
L37:    aload_1 
L38:    iload_2 
L39:    baload 
L40:    if_icmpeq L45 
L43:    iconst_0 
L44:    ireturn 

        .stack same 
L45:    iinc 2 1 
L48:    goto L28 

        .stack chop 1 
L51:    iconst_1 
L52:    ireturn 
L53:    
        .linenumbertable 
            L0 8 
            L5 10 
            L7 13 
            L15 15 
            L17 18 
            L24 20 
            L26 23 
            L34 25 
            L43 27 
            L45 23 
            L51 31 
        .end linenumbertable 
        .localvariabletable 
            2 is i I from L28 to L51 
            0 is a [B from L0 to L53 
            1 is b [B from L0 to L53 
        .end localvariabletable 
    .end code 
.end method 

.method public static fill : ([BB)V 
    .code stack 3 locals 3 
L0:     iconst_0 
L1:     istore_2 

        .stack append Integer 
L2:     iload_2 
L3:     aload_0 
L4:     arraylength 
L5:     if_icmpge L18 
L8:     aload_0 
L9:     iload_2 
L10:    iload_1 
L11:    bastore 
L12:    iinc 2 1 
L15:    goto L2 

        .stack chop 1 
L18:    return 
L19:    
        .linenumbertable 
            L0 40 
            L8 42 
            L12 40 
            L18 44 
        .end linenumbertable 
        .localvariabletable 
            2 is i I from L2 to L18 
            0 is array [B from L0 to L19 
            1 is value B from L0 to L19 
        .end localvariabletable 
    .end code 
.end method 

.method public static hashCode : ([B)I 
    .code stack 3 locals 3 
L0:     aload_0 
L1:     ifnonnull L6 
L4:     iconst_0 
L5:     ireturn 

        .stack same 
L6:     aload_0 
L7:     arraylength 
L8:     istore_1 
L9:     iload_1 
L10:    iconst_1 
L11:    iadd 
L12:    istore_2 

        .stack append Integer Integer 
L13:    iinc 1 -1 
L16:    iload_1 
L17:    iflt L35 
L20:    iload_2 
L21:    sipush 257 
L24:    imul 
L25:    istore_2 
L26:    iload_2 
L27:    aload_0 
L28:    iload_1 
L29:    baload 
L30:    ixor 
L31:    istore_2 
L32:    goto L13 

        .stack same 
L35:    iload_2 
L36:    ireturn 
L37:    
        .linenumbertable 
            L0 48 
            L4 50 
            L6 53 
            L9 54 
            L13 56 
            L20 58 
            L26 59 
            L35 62 
        .end linenumbertable 
        .localvariabletable 
            0 is data [B from L0 to L37 
            1 is i I from L9 to L37 
            2 is hc I from L13 to L37 
        .end localvariabletable 
    .end code 
.end method 

.method public static hashCode : ([III)I 
    .code stack 4 locals 5 
L0:     aload_0 
L1:     ifnonnull L6 
L4:     iconst_0 
L5:     ireturn 

        .stack same 
L6:     iload_2 
L7:     istore_3 
L8:     iload_3 
L9:     iconst_1 
L10:    iadd 
L11:    istore 4 

        .stack append Integer Integer 
L13:    iinc 3 -1 
L16:    iload_3 
L17:    iflt L41 
L20:    iload 4 
L22:    sipush 257 
L25:    imul 
L26:    istore 4 
L28:    iload 4 
L30:    aload_0 
L31:    iload_1 
L32:    iload_3 
L33:    iadd 
L34:    iaload 
L35:    ixor 
L36:    istore 4 
L38:    goto L13 

        .stack same 
L41:    iload 4 
L43:    ireturn 
L44:    
        .linenumbertable 
            L0 69 
            L4 71 
            L6 74 
            L8 75 
            L13 77 
            L20 79 
            L28 80 
            L41 83 
        .end linenumbertable 
        .localvariabletable 
            0 is data [I from L0 to L44 
            1 is off I from L0 to L44 
            2 is len I from L0 to L44 
            3 is i I from L8 to L44 
            4 is hc I from L13 to L44 
        .end localvariabletable 
    .end code 
.end method 

.method public static clone : ([B)[B 
    .code stack 5 locals 2 
L0:     aload_0 
L1:     ifnonnull L6 
L4:     aconst_null 
L5:     areturn 

        .stack same 
L6:     aload_0 
L7:     arraylength 
L8:     newarray byte 
L10:    astore_1 
L11:    aload_0 
L12:    iconst_0 
L13:    aload_1 
L14:    iconst_0 
L15:    aload_0 
L16:    arraylength 
L17:    invokestatic Method java/lang/System arraycopy (Ljava/lang/Object;ILjava/lang/Object;II)V 
L20:    aload_1 
L21:    areturn 
L22:    
        .linenumbertable 
            L0 88 
            L4 90 
            L6 92 
            L11 94 
            L20 96 
        .end linenumbertable 
        .localvariabletable 
            0 is data [B from L0 to L22 
            1 is copy [B from L11 to L22 
        .end localvariabletable 
    .end code 
.end method 
.sourcefile 'Arrays.java' 
.end class 
