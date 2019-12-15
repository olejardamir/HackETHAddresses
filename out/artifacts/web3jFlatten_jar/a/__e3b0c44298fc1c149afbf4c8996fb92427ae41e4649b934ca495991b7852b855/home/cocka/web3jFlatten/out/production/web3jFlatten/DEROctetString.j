.version 52 0 
.class super DEROctetString 
.super ASN1OctetString 

.method public <init> : ([B)V 
    .code stack 2 locals 2 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial Method ASN1OctetString <init> ([B)V 
L5:     return 
L6:     
        .linenumbertable 
            L0 9 
            L5 10 
        .end linenumbertable 
        .localvariabletable 
            0 is this LDEROctetString; from L0 to L6 
            1 is string [B from L0 to L6 
        .end localvariabletable 
    .end code 
.end method 

.method encodedLength : ()I 
    .code stack 2 locals 1 
L0:     iconst_1 
L1:     aload_0 
L2:     getfield Field DEROctetString string [B 
L5:     arraylength 
L6:     invokestatic Method StreamUtil calculateBodyLength (I)I 
L9:     iadd 
L10:    aload_0 
L11:    getfield Field DEROctetString string [B 
L14:    arraylength 
L15:    iadd 
L16:    ireturn 
L17:    
        .linenumbertable 
            L0 14 
        .end linenumbertable 
        .localvariabletable 
            0 is this LDEROctetString; from L0 to L17 
        .end localvariabletable 
    .end code 
.end method 

.method encode : (LASN1OutputStream;)V 
    .code stack 3 locals 2 
L0:     aload_1 
L1:     iconst_4 
L2:     aload_0 
L3:     getfield Field DEROctetString string [B 
L6:     invokevirtual Method ASN1OutputStream writeEncoded (I[B)V 
L9:     return 
L10:    
        .linenumbertable 
            L0 21 
            L9 22 
        .end linenumbertable 
        .localvariabletable 
            0 is this LDEROctetString; from L0 to L10 
            1 is out LASN1OutputStream; from L0 to L10 
        .end localvariabletable 
    .end code 
    .exceptions java/lang/Exception 
.end method 
.sourcefile 'DEROctetString.java' 
.end class 
