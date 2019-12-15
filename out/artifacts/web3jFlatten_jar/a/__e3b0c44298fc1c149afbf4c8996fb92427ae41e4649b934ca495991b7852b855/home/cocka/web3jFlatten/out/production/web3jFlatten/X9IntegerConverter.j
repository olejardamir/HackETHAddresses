.version 52 0 
.class super X9IntegerConverter 
.super java/lang/Object 

.method <init> : ()V 
    .code stack 1 locals 1 
L0:     aload_0 
L1:     invokespecial Method java/lang/Object <init> ()V 
L4:     return 
L5:     
        .linenumbertable 
            L0 4 
        .end linenumbertable 
        .localvariabletable 
            0 is this LX9IntegerConverter; from L0 to L5 
        .end localvariabletable 
    .end code 
.end method 

.method public getByteLength : (LECFieldElement;)I 
    .code stack 2 locals 2 
L0:     aload_1 
L1:     invokevirtual Method ECFieldElement getFieldSize ()I 
L4:     bipush 7 
L6:     iadd 
L7:     bipush 8 
L9:     idiv 
L10:    ireturn 
L11:    
        .linenumbertable 
            L0 11 
        .end linenumbertable 
        .localvariabletable 
            0 is this LX9IntegerConverter; from L0 to L11 
            1 is fe LECFieldElement; from L0 to L11 
        .end localvariabletable 
    .end code 
.end method 

.method public integerToBytes : (Ljava/math/BigInteger;I)[B 
    .code stack 5 locals 5 
L0:     aload_1 
L1:     invokevirtual Method java/math/BigInteger toByteArray ()[B 
L4:     astore_3 
L5:     iload_2 
L6:     aload_3 
L7:     arraylength 
L8:     if_icmpge L35 
L11:    iload_2 
L12:    newarray byte 
L14:    astore 4 
L16:    aload_3 
L17:    aload_3 
L18:    arraylength 
L19:    aload 4 
L21:    arraylength 
L22:    isub 
L23:    aload 4 
L25:    iconst_0 
L26:    aload 4 
L28:    arraylength 
L29:    invokestatic Method java/lang/System arraycopy (Ljava/lang/Object;ILjava/lang/Object;II)V 
L32:    aload 4 
L34:    areturn 

        .stack append Object [B 
L35:    iload_2 
L36:    aload_3 
L37:    arraylength 
L38:    if_icmple L64 
L41:    iload_2 
L42:    newarray byte 
L44:    astore 4 
L46:    aload_3 
L47:    iconst_0 
L48:    aload 4 
L50:    aload 4 
L52:    arraylength 
L53:    aload_3 
L54:    arraylength 
L55:    isub 
L56:    aload_3 
L57:    arraylength 
L58:    invokestatic Method java/lang/System arraycopy (Ljava/lang/Object;ILjava/lang/Object;II)V 
L61:    aload 4 
L63:    areturn 

        .stack same 
L64:    aload_3 
L65:    areturn 
L66:    
        .linenumbertable 
            L0 19 
            L5 21 
            L11 23 
            L16 25 
            L32 27 
            L35 29 
            L41 31 
            L46 33 
            L61 35 
            L64 38 
        .end linenumbertable 
        .localvariabletable 
            4 is tmp [B from L16 to L35 
            4 is tmp [B from L46 to L64 
            0 is this LX9IntegerConverter; from L0 to L66 
            1 is s Ljava/math/BigInteger; from L0 to L66 
            2 is qLength I from L0 to L66 
            3 is bytes [B from L5 to L66 
        .end localvariabletable 
    .end code 
.end method 
.sourcefile 'X9IntegerConverter.java' 
.end class 
