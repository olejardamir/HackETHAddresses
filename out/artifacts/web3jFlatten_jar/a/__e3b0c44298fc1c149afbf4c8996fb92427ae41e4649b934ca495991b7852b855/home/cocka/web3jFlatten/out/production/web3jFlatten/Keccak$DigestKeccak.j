.version 52 0 
.class public super Keccak$DigestKeccak 
.super BCMessageDigest 
.implements java/lang/Cloneable 

.method <init> : ()V 
    .code stack 4 locals 1 
L0:     aload_0 
L1:     new KeccakDigest 
L4:     dup 
L5:     sipush 256 
L8:     invokespecial Method KeccakDigest <init> (I)V 
L11:    invokespecial Method BCMessageDigest <init> (LExtendedDigest;)V 
L14:    return 
L15:    
        .linenumbertable 
            L0 14 
            L14 15 
        .end linenumbertable 
        .localvariabletable 
            0 is this LKeccak$DigestKeccak; from L0 to L15 
        .end localvariabletable 
    .end code 
.end method 

.method public clone : ()Ljava/lang/Object; 
    .code stack 4 locals 2 
L0:     aload_0 
L1:     invokespecial Method BCMessageDigest clone ()Ljava/lang/Object; 
L4:     checkcast BCMessageDigest 
L7:     astore_1 
L8:     aload_1 
L9:     new KeccakDigest 
L12:    dup 
L13:    aload_0 
L14:    getfield Field Keccak$DigestKeccak digest LExtendedDigest; 
L17:    checkcast KeccakDigest 
L20:    invokespecial Method KeccakDigest <init> (LKeccakDigest;)V 
L23:    putfield Field BCMessageDigest digest LExtendedDigest; 
L26:    aload_1 
L27:    areturn 
L28:    
        .linenumbertable 
            L0 20 
            L8 21 
            L26 23 
        .end linenumbertable 
        .localvariabletable 
            0 is this LKeccak$DigestKeccak; from L0 to L28 
            1 is d LBCMessageDigest; from L8 to L28 
        .end localvariabletable 
    .end code 
    .exceptions java/lang/CloneNotSupportedException 
.end method 

.method public bridge synthetic engineDigest : ()[B 
    .code stack 1 locals 1 
L0:     aload_0 
L1:     invokespecial Method BCMessageDigest engineDigest ()[B 
L4:     areturn 
L5:     
        .linenumbertable 
            L0 8 
        .end linenumbertable 
        .localvariabletable 
            0 is this LKeccak$DigestKeccak; from L0 to L5 
        .end localvariabletable 
    .end code 
.end method 

.method public bridge synthetic engineUpdate : ([BII)V 
    .code stack 4 locals 4 
L0:     aload_0 
L1:     aload_1 
L2:     iload_2 
L3:     iload_3 
L4:     invokespecial Method BCMessageDigest engineUpdate ([BII)V 
L7:     return 
L8:     
        .linenumbertable 
            L0 8 
        .end linenumbertable 
        .localvariabletable 
            0 is this LKeccak$DigestKeccak; from L0 to L8 
        .end localvariabletable 
    .end code 
.end method 

.method public bridge synthetic engineUpdate : (B)V 
    .code stack 2 locals 2 
L0:     aload_0 
L1:     iload_1 
L2:     invokespecial Method BCMessageDigest engineUpdate (B)V 
L5:     return 
L6:     
        .linenumbertable 
            L0 8 
        .end linenumbertable 
        .localvariabletable 
            0 is this LKeccak$DigestKeccak; from L0 to L6 
        .end localvariabletable 
    .end code 
.end method 

.method public bridge synthetic engineReset : ()V 
    .code stack 1 locals 1 
L0:     aload_0 
L1:     invokespecial Method BCMessageDigest engineReset ()V 
L4:     return 
L5:     
        .linenumbertable 
            L0 8 
        .end linenumbertable 
        .localvariabletable 
            0 is this LKeccak$DigestKeccak; from L0 to L5 
        .end localvariabletable 
    .end code 
.end method 
.sourcefile 'Keccak.java' 
.innerclasses 
    Keccak$DigestKeccak Keccak DigestKeccak public static 
.end innerclasses 
.end class 
