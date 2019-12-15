.version 52 0 
.class super DERBitString 
.super ASN1BitString 

.method public <init> : ([BI)V 
    .code stack 3 locals 3 
L0:     aload_0 
L1:     aload_1 
L2:     iload_2 
L3:     invokespecial Method ASN1BitString <init> ([BI)V 
L6:     return 
L7:     
        .linenumbertable 
            L0 11 
            L6 12 
        .end linenumbertable 
        .localvariabletable 
            0 is this LDERBitString; from L0 to L7 
            1 is data [B from L0 to L7 
            2 is padBits I from L0 to L7 
        .end localvariabletable 
    .end code 
.end method 

.method public <init> : ([B)V 
    .code stack 3 locals 2 
L0:     aload_0 
L1:     aload_1 
L2:     iconst_0 
L3:     invokespecial Method DERBitString <init> ([BI)V 
L6:     return 
L7:     
        .linenumbertable 
            L0 17 
            L6 18 
        .end linenumbertable 
        .localvariabletable 
            0 is this LDERBitString; from L0 to L7 
            1 is data [B from L0 to L7 
        .end localvariabletable 
    .end code 
.end method 

.method encodedLength : ()I 
    .code stack 3 locals 1 
L0:     iconst_1 
L1:     aload_0 
L2:     getfield Field DERBitString data [B 
L5:     arraylength 
L6:     iconst_1 
L7:     iadd 
L8:     invokestatic Method StreamUtil calculateBodyLength (I)I 
L11:    iadd 
L12:    aload_0 
L13:    getfield Field DERBitString data [B 
L16:    arraylength 
L17:    iadd 
L18:    iconst_1 
L19:    iadd 
L20:    ireturn 
L21:    
        .linenumbertable 
            L0 22 
        .end linenumbertable 
        .localvariabletable 
            0 is this LDERBitString; from L0 to L21 
        .end localvariabletable 
    .end code 
.end method 

.method encode : (LASN1OutputStream;)V 
    .code stack 6 locals 4 
L0:     aload_0 
L1:     getfield Field DERBitString data [B 
L4:     aload_0 
L5:     getfield Field DERBitString padBits I 
L8:     invokestatic Method DERBitString derForm ([BI)[B 
L11:    astore_2 
L12:    aload_2 
L13:    arraylength 
L14:    iconst_1 
L15:    iadd 
L16:    newarray byte 
L18:    astore_3 
L19:    aload_3 
L20:    iconst_0 
L21:    aload_0 
L22:    invokevirtual Method DERBitString getPadBits ()I 
L25:    i2b 
L26:    bastore 
L27:    aload_2 
L28:    iconst_0 
L29:    aload_3 
L30:    iconst_1 
L31:    aload_3 
L32:    arraylength 
L33:    iconst_1 
L34:    isub 
L35:    invokestatic Method java/lang/System arraycopy (Ljava/lang/Object;ILjava/lang/Object;II)V 
L38:    aload_1 
L39:    iconst_3 
L40:    aload_3 
L41:    invokevirtual Method ASN1OutputStream writeEncoded (I[B)V 
L44:    return 
L45:    
        .linenumbertable 
            L0 29 
            L12 30 
            L19 32 
            L27 33 
            L38 35 
            L44 36 
        .end linenumbertable 
        .localvariabletable 
            0 is this LDERBitString; from L0 to L45 
            1 is out LASN1OutputStream; from L0 to L45 
            2 is string [B from L12 to L45 
            3 is bytes [B from L19 to L45 
        .end localvariabletable 
    .end code 
    .exceptions java/lang/Exception 
.end method 
.sourcefile 'DERBitString.java' 
.end class 
