.version 52 0 
.class super Integers 
.super java/lang/Object 

.method <init> : ()V 
    .code stack 1 locals 1 
L0:     aload_0 
L1:     invokespecial Method java/lang/Object <init> ()V 
L4:     return 
L5:     
        .linenumbertable 
            L0 3 
        .end linenumbertable 
        .localvariabletable 
            0 is this LIntegers; from L0 to L5 
        .end localvariabletable 
    .end code 
.end method 

.method public static rotateLeft : (II)I 
    .code stack 2 locals 2 
L0:     iload_0 
L1:     iload_1 
L2:     invokestatic Method java/lang/Integer rotateLeft (II)I 
L5:     ireturn 
L6:     
        .linenumbertable 
            L0 7 
        .end linenumbertable 
        .localvariabletable 
            0 is i I from L0 to L6 
            1 is distance I from L0 to L6 
        .end localvariabletable 
    .end code 
.end method 
.sourcefile 'Integers.java' 
.end class 
