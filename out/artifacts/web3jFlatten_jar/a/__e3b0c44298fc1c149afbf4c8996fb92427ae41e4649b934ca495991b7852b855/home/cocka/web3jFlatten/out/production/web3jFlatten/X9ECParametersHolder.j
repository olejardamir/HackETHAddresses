.version 52 0 
.class super abstract X9ECParametersHolder 
.super java/lang/Object 

.method <init> : ()V 
    .code stack 1 locals 1 
L0:     aload_0 
L1:     invokespecial Method java/lang/Object <init> ()V 
L4:     return 
L5:     
        .linenumbertable 
            L0 2 
            L4 3 
        .end linenumbertable 
        .localvariabletable 
            0 is this LX9ECParametersHolder; from L0 to L5 
        .end localvariabletable 
    .end code 
.end method 

.method public synchronized getParameters : ()LX9ECParameters; 
    .code stack 1 locals 1 
L0:     aload_0 
L1:     invokevirtual Method X9ECParametersHolder createParameters ()LX9ECParameters; 
L4:     areturn 
L5:     
        .linenumbertable 
            L0 6 
        .end linenumbertable 
        .localvariabletable 
            0 is this LX9ECParametersHolder; from L0 to L5 
        .end localvariabletable 
    .end code 
    .exceptions java/lang/Exception 
.end method 

.method protected abstract createParameters : ()LX9ECParameters; 
    .exceptions java/lang/Exception 
.end method 
.sourcefile 'X9ECParametersHolder.java' 
.end class 
