.version 52 0 
.class super StreamUtil 
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
            0 is this LStreamUtil; from L0 to L5 
        .end localvariabletable 
    .end code 
.end method 

.method static calculateBodyLength : (I)I 
    .code stack 2 locals 4 
L0:     iload_0 
L1:     bipush 127 
L3:     if_icmpgt L11 
L6:     iconst_1 
L7:     istore_1 
L8:     goto L59 

        .stack same 
L11:    iconst_1 
L12:    istore_2 

        .stack append Top Integer 
L13:    iload_0 
L14:    bipush 8 
L16:    iushr 
L17:    istore_3 
L18:    iload_3 
L19:    ifne L25 
L22:    goto L34 

        .stack append Integer 
L25:    iload_2 
L26:    iconst_1 
L27:    iadd 
L28:    istore_2 
L29:    iload_3 
L30:    istore_0 
L31:    goto L13 

        .stack chop 1 
L34:    iload_2 
L35:    iconst_1 
L36:    isub 
L37:    bipush 8 
L39:    imul 
L40:    istore_3 
L41:    iconst_1 
L42:    istore_1 

        .stack full 
            locals Integer Integer Integer Integer 
            stack 
        .end stack 
L43:    iload_3 
L44:    iflt L59 
L47:    iload_1 
L48:    iconst_1 
L49:    iadd 
L50:    istore_1 
L51:    iload_3 
L52:    bipush -8 
L54:    iadd 
L55:    istore_3 
L56:    goto L43 

        .stack chop 2 
L59:    iload_1 
L60:    ireturn 
L61:    
        .linenumbertable 
            L0 6 
            L6 7 
            L11 9 
            L13 11 
            L18 12 
            L22 13 
            L25 15 
            L29 16 
            L31 17 
            L34 18 
            L41 19 
            L43 20 
            L47 21 
            L51 20 
            L59 24 
        .end linenumbertable 
        .localvariabletable 
            1 is i0 I from L8 to L11 
            3 is i2 I from L18 to L31 
            2 is i1 I from L13 to L59 
            3 is i3 I from L41 to L59 
            0 is i I from L0 to L61 
            1 is i0 I from L43 to L61 
        .end localvariabletable 
    .end code 
.end method 
.sourcefile 'StreamUtil.java' 
.end class 
