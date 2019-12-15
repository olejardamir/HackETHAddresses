.version 52 0 
.class super abstract Pack 
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
            0 is this LPack; from L0 to L5 
        .end localvariabletable 
    .end code 
.end method 

.method public static intToBigEndian : (I[BI)V 
    .code stack 4 locals 3 
L0:     aload_1 
L1:     iload_2 
L2:     iload_0 
L3:     bipush 24 
L5:     iushr 
L6:     i2b 
L7:     bastore 
L8:     aload_1 
L9:     iinc 2 1 
L12:    iload_2 
L13:    iload_0 
L14:    bipush 16 
L16:    iushr 
L17:    i2b 
L18:    bastore 
L19:    aload_1 
L20:    iinc 2 1 
L23:    iload_2 
L24:    iload_0 
L25:    bipush 8 
L27:    iushr 
L28:    i2b 
L29:    bastore 
L30:    aload_1 
L31:    iinc 2 1 
L34:    iload_2 
L35:    iload_0 
L36:    i2b 
L37:    bastore 
L38:    return 
L39:    
        .linenumbertable 
            L0 8 
            L8 9 
            L19 10 
            L30 11 
            L38 12 
        .end linenumbertable 
        .localvariabletable 
            0 is n I from L0 to L39 
            1 is bs [B from L0 to L39 
            2 is off I from L0 to L39 
        .end localvariabletable 
    .end code 
.end method 

.method private static littleEndianToInt : ([BI)I 
    .code stack 3 locals 3 
L0:     aload_0 
L1:     iload_1 
L2:     baload 
L3:     sipush 255 
L6:     iand 
L7:     istore_2 
L8:     iload_2 
L9:     aload_0 
L10:    iinc 1 1 
L13:    iload_1 
L14:    baload 
L15:    sipush 255 
L18:    iand 
L19:    bipush 8 
L21:    ishl 
L22:    ior 
L23:    istore_2 
L24:    iload_2 
L25:    aload_0 
L26:    iinc 1 1 
L29:    iload_1 
L30:    baload 
L31:    sipush 255 
L34:    iand 
L35:    bipush 16 
L37:    ishl 
L38:    ior 
L39:    istore_2 
L40:    iload_2 
L41:    aload_0 
L42:    iinc 1 1 
L45:    iload_1 
L46:    baload 
L47:    bipush 24 
L49:    ishl 
L50:    ior 
L51:    istore_2 
L52:    iload_2 
L53:    ireturn 
L54:    
        .linenumbertable 
            L0 16 
            L8 17 
            L24 18 
            L40 19 
            L52 20 
        .end linenumbertable 
        .localvariabletable 
            0 is bs [B from L0 to L54 
            1 is off I from L0 to L54 
            2 is n I from L8 to L54 
        .end localvariabletable 
    .end code 
.end method 

.method private static intToLittleEndian : (I[BI)V 
    .code stack 4 locals 3 
L0:     aload_1 
L1:     iload_2 
L2:     iload_0 
L3:     i2b 
L4:     bastore 
L5:     aload_1 
L6:     iinc 2 1 
L9:     iload_2 
L10:    iload_0 
L11:    bipush 8 
L13:    iushr 
L14:    i2b 
L15:    bastore 
L16:    aload_1 
L17:    iinc 2 1 
L20:    iload_2 
L21:    iload_0 
L22:    bipush 16 
L24:    iushr 
L25:    i2b 
L26:    bastore 
L27:    aload_1 
L28:    iinc 2 1 
L31:    iload_2 
L32:    iload_0 
L33:    bipush 24 
L35:    iushr 
L36:    i2b 
L37:    bastore 
L38:    return 
L39:    
        .linenumbertable 
            L0 25 
            L5 26 
            L16 27 
            L27 28 
            L38 29 
        .end linenumbertable 
        .localvariabletable 
            0 is n I from L0 to L39 
            1 is bs [B from L0 to L39 
            2 is off I from L0 to L39 
        .end localvariabletable 
    .end code 
.end method 

.method public static littleEndianToLong : ([BI)J 
    .code stack 6 locals 4 
L0:     aload_0 
L1:     iload_1 
L2:     invokestatic Method Pack littleEndianToInt ([BI)I 
L5:     istore_2 
L6:     aload_0 
L7:     iload_1 
L8:     iconst_4 
L9:     iadd 
L10:    invokestatic Method Pack littleEndianToInt ([BI)I 
L13:    istore_3 
L14:    iload_3 
L15:    i2l 
L16:    ldc2_w 4294967295L 
L19:    land 
L20:    bipush 32 
L22:    lshl 
L23:    iload_2 
L24:    i2l 
L25:    ldc2_w 4294967295L 
L28:    land 
L29:    lor 
L30:    lreturn 
L31:    
        .linenumbertable 
            L0 33 
            L6 34 
            L14 35 
        .end linenumbertable 
        .localvariabletable 
            0 is bs [B from L0 to L31 
            1 is off I from L0 to L31 
            2 is lo I from L6 to L31 
            3 is hi I from L14 to L31 
        .end localvariabletable 
    .end code 
.end method 

.method private static longToLittleEndian : (J[BI)V 
    .code stack 4 locals 4 
L0:     lload_0 
L1:     ldc2_w 4294967295L 
L4:     land 
L5:     l2i 
L6:     aload_2 
L7:     iload_3 
L8:     invokestatic Method Pack intToLittleEndian (I[BI)V 
L11:    lload_0 
L12:    bipush 32 
L14:    lushr 
L15:    l2i 
L16:    aload_2 
L17:    iload_3 
L18:    iconst_4 
L19:    iadd 
L20:    invokestatic Method Pack intToLittleEndian (I[BI)V 
L23:    return 
L24:    
        .linenumbertable 
            L0 40 
            L11 41 
            L23 42 
        .end linenumbertable 
        .localvariabletable 
            0 is n J from L0 to L24 
            2 is bs [B from L0 to L24 
            3 is off I from L0 to L24 
        .end localvariabletable 
    .end code 
.end method 

.method public static longToLittleEndian : ([JII[BI)V 
    .code stack 4 locals 6 
L0:     iconst_0 
L1:     istore 5 

        .stack append Integer 
L3:     iload 5 
L5:     iload_2 
L6:     if_icmpge L30 
L9:     aload_0 
L10:    iload_1 
L11:    iload 5 
L13:    iadd 
L14:    laload 
L15:    aload_3 
L16:    iload 4 
L18:    invokestatic Method Pack longToLittleEndian (J[BI)V 
L21:    iinc 4 8 
L24:    iinc 5 1 
L27:    goto L3 

        .stack chop 1 
L30:    return 
L31:    
        .linenumbertable 
            L0 46 
            L9 48 
            L21 49 
            L24 46 
            L30 51 
        .end linenumbertable 
        .localvariabletable 
            5 is i I from L3 to L30 
            0 is ns [J from L0 to L31 
            1 is nsOff I from L0 to L31 
            2 is nsLen I from L0 to L31 
            3 is bs [B from L0 to L31 
            4 is bsOff I from L0 to L31 
        .end localvariabletable 
    .end code 
.end method 
.sourcefile 'Pack.java' 
.end class 
