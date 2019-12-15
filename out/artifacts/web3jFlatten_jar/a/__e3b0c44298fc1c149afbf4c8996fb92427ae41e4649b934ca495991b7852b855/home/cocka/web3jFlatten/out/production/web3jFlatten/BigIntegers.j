.version 52 0 
.class final super BigIntegers 
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
            0 is this LBigIntegers; from L0 to L5 
        .end localvariabletable 
    .end code 
.end method 

.method public static asUnsignedByteArray : (ILjava/math/BigInteger;)[B 
    .code stack 5 locals 6 
L0:     aload_1 
L1:     invokevirtual Method java/math/BigInteger toByteArray ()[B 
L4:     astore_2 
L5:     aload_2 
L6:     arraylength 
L7:     iload_0 
L8:     if_icmpne L13 
L11:    aload_2 
L12:    areturn 

        .stack append Object [B 
L13:    aload_2 
L14:    iconst_0 
L15:    baload 
L16:    ifne L23 
L19:    iconst_1 
L20:    goto L24 

        .stack same 
L23:    iconst_0 

        .stack stack_1 Integer 
L24:    istore_3 
L25:    aload_2 
L26:    arraylength 
L27:    iload_3 
L28:    isub 
L29:    istore 4 
L31:    iload 4 
L33:    iload_0 
L34:    if_icmple L47 
L37:    new java/lang/IllegalArgumentException 
L40:    dup 
L41:    ldc 'standard length exceeded for value' 
L43:    invokespecial Method java/lang/IllegalArgumentException <init> (Ljava/lang/String;)V 
L46:    athrow 

        .stack append Integer Integer 
L47:    iload_0 
L48:    newarray byte 
L50:    astore 5 
L52:    aload_2 
L53:    iload_3 
L54:    aload 5 
L56:    aload 5 
L58:    arraylength 
L59:    iload 4 
L61:    isub 
L62:    iload 4 
L64:    invokestatic Method java/lang/System arraycopy (Ljava/lang/Object;ILjava/lang/Object;II)V 
L67:    aload 5 
L69:    areturn 
L70:    
        .linenumbertable 
            L0 10 
            L5 11 
            L11 13 
            L13 16 
            L25 17 
            L31 19 
            L37 21 
            L47 24 
            L52 25 
            L67 26 
        .end linenumbertable 
        .localvariabletable 
            0 is length I from L0 to L70 
            1 is value Ljava/math/BigInteger; from L0 to L70 
            2 is bytes [B from L5 to L70 
            3 is start I from L25 to L70 
            4 is count I from L31 to L70 
            5 is tmp [B from L52 to L70 
        .end localvariabletable 
    .end code 
.end method 

.method public static fromUnsignedByteArray : ([BII)Ljava/math/BigInteger; 
    .code stack 5 locals 4 
L0:     aload_0 
L1:     astore_3 
L2:     iload_1 
L3:     ifne L12 
L6:     iload_2 
L7:     aload_0 
L8:     arraylength 
L9:     if_icmpeq L24 

        .stack append Object [B 
L12:    iload_2 
L13:    newarray byte 
L15:    astore_3 
L16:    aload_0 
L17:    iload_1 
L18:    aload_3 
L19:    iconst_0 
L20:    iload_2 
L21:    invokestatic Method java/lang/System arraycopy (Ljava/lang/Object;ILjava/lang/Object;II)V 

        .stack same 
L24:    new java/math/BigInteger 
L27:    dup 
L28:    iconst_1 
L29:    aload_3 
L30:    invokespecial Method java/math/BigInteger <init> (I[B)V 
L33:    areturn 
L34:    
        .linenumbertable 
            L0 31 
            L2 32 
            L12 34 
            L16 35 
            L24 37 
        .end linenumbertable 
        .localvariabletable 
            0 is buf [B from L0 to L34 
            1 is off I from L0 to L34 
            2 is length I from L0 to L34 
            3 is mag [B from L2 to L34 
        .end localvariabletable 
    .end code 
.end method 
.sourcefile 'BigIntegers.java' 
.end class 
