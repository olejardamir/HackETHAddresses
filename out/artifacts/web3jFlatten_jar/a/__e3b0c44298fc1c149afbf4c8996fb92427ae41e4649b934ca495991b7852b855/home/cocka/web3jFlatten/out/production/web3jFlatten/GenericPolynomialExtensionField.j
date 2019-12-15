.version 52 0 
.class super GenericPolynomialExtensionField 
.super java/lang/Object 

.method public <init> : ()V 
    .code stack 1 locals 1 
L0:     aload_0 
L1:     invokespecial Method java/lang/Object <init> ()V 
L4:     return 
L5:     
        .linenumbertable 
            L0 8 
            L4 10 
        .end linenumbertable 
        .localvariabletable 
            0 is this LGenericPolynomialExtensionField; from L0 to L5 
        .end localvariabletable 
    .end code 
.end method 

.method public equals : (Ljava/lang/Object;)Z 
    .code stack 2 locals 2 
L0:     aload_0 
L1:     aload_1 
L2:     if_acmpne L7 
L5:     iconst_1 
L6:     ireturn 

        .stack same 
L7:     iconst_0 
L8:     ireturn 
L9:     
        .linenumbertable 
            L0 14 
            L5 16 
            L7 19 
        .end linenumbertable 
        .localvariabletable 
            0 is this LGenericPolynomialExtensionField; from L0 to L9 
            1 is obj Ljava/lang/Object; from L0 to L9 
        .end localvariabletable 
    .end code 
.end method 

.method public hashCode : ()I 
    .code stack 1 locals 1 
L0:     iconst_0 
L1:     ireturn 
L2:     
        .linenumbertable 
            L0 25 
        .end linenumbertable 
        .localvariabletable 
            0 is this LGenericPolynomialExtensionField; from L0 to L2 
        .end localvariabletable 
    .end code 
.end method 

.method public getCharacteristic : ()Ljava/math/BigInteger; 
    .code stack 1 locals 1 
L0:     aconst_null 
L1:     areturn 
L2:     
        .linenumbertable 
            L0 29 
        .end linenumbertable 
        .localvariabletable 
            0 is this LGenericPolynomialExtensionField; from L0 to L2 
        .end localvariabletable 
    .end code 
.end method 
.sourcefile 'GenericPolynomialExtensionField.java' 
.end class 
