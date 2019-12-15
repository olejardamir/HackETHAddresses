.version 52 0 
.class super BCMessageDigest 
.super java/security/MessageDigest 
.field digest LExtendedDigest; 

.method <init> : (LExtendedDigest;)V 
    .code stack 2 locals 2 
L0:     aload_0 
L1:     aload_1 
L2:     invokeinterface InterfaceMethod ExtendedDigest getAlgorithmName ()Ljava/lang/String; 1 
L7:     invokespecial Method java/security/MessageDigest <init> (Ljava/lang/String;)V 
L10:    aload_0 
L11:    aload_1 
L12:    putfield Field BCMessageDigest digest LExtendedDigest; 
L15:    return 
L16:    
        .linenumbertable 
            L0 11 
            L10 13 
            L15 14 
        .end linenumbertable 
        .localvariabletable 
            0 is this LBCMessageDigest; from L0 to L16 
            1 is digest LExtendedDigest; from L0 to L16 
        .end localvariabletable 
    .end code 
.end method 

.method public engineReset : ()V 
    .code stack 1 locals 1 
L0:     aload_0 
L1:     getfield Field BCMessageDigest digest LExtendedDigest; 
L4:     invokeinterface InterfaceMethod ExtendedDigest reset ()V 1 
L9:     return 
L10:    
        .linenumbertable 
            L0 18 
            L9 19 
        .end linenumbertable 
        .localvariabletable 
            0 is this LBCMessageDigest; from L0 to L10 
        .end localvariabletable 
    .end code 
.end method 

.method public engineUpdate : (B)V 
    .code stack 2 locals 2 
L0:     aload_0 
L1:     getfield Field BCMessageDigest digest LExtendedDigest; 
L4:     iload_1 
L5:     invokeinterface InterfaceMethod ExtendedDigest update (B)V 2 
L10:    return 
L11:    
        .linenumbertable 
            L0 24 
            L10 25 
        .end linenumbertable 
        .localvariabletable 
            0 is this LBCMessageDigest; from L0 to L11 
            1 is input B from L0 to L11 
        .end localvariabletable 
    .end code 
.end method 

.method public engineUpdate : ([BII)V 
    .code stack 4 locals 4 
L0:     aload_0 
L1:     getfield Field BCMessageDigest digest LExtendedDigest; 
L4:     aload_1 
L5:     iload_2 
L6:     iload_3 
L7:     invokeinterface InterfaceMethod ExtendedDigest update ([BII)V 4 
L12:    return 
L13:    
        .linenumbertable 
            L0 32 
            L12 33 
        .end linenumbertable 
        .localvariabletable 
            0 is this LBCMessageDigest; from L0 to L13 
            1 is input [B from L0 to L13 
            2 is offset I from L0 to L13 
            3 is len I from L0 to L13 
        .end localvariabletable 
    .end code 
.end method 

.method public engineDigest : ()[B 
    .code stack 3 locals 2 
L0:     aload_0 
L1:     getfield Field BCMessageDigest digest LExtendedDigest; 
L4:     invokeinterface InterfaceMethod ExtendedDigest getDigestSize ()I 1 
L9:     newarray byte 
L11:    astore_1 
L12:    aload_0 
L13:    getfield Field BCMessageDigest digest LExtendedDigest; 
L16:    aload_1 
L17:    iconst_0 
L18:    invokeinterface InterfaceMethod ExtendedDigest doFinal ([BI)V 3 
L23:    aload_1 
L24:    areturn 
L25:    
        .linenumbertable 
            L0 37 
            L12 39 
            L23 41 
        .end linenumbertable 
        .localvariabletable 
            0 is this LBCMessageDigest; from L0 to L25 
            1 is digestBytes [B from L12 to L25 
        .end localvariabletable 
    .end code 
.end method 
.sourcefile 'BCMessageDigest.java' 
.end class 
