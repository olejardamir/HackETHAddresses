.version 52 0 
.class super abstract Nat 
.super java/lang/Object 
.field private static final M J = 4294967295L 

.method <init> : ()V 
    .code stack 1 locals 1 
L0:     aload_0 
L1:     invokespecial Method java/lang/Object <init> ()V 
L4:     return 
L5:     
        .linenumbertable 
            L0 5 
        .end linenumbertable 
        .localvariabletable 
            0 is this LNat; from L0 to L5 
        .end localvariabletable 
    .end code 
.end method 

.method public static add : (I[I[I[I)V 
    .code stack 8 locals 7 
L0:     lconst_0 
L1:     lstore 4 
L3:     iconst_0 
L4:     istore 6 

        .stack append Long Integer 
L6:     iload 6 
L8:     iload_0 
L9:     if_icmpge L56 
L12:    lload 4 
L14:    aload_1 
L15:    iload 6 
L17:    iaload 
L18:    i2l 
L19:    ldc2_w 4294967295L 
L22:    land 
L23:    aload_2 
L24:    iload 6 
L26:    iaload 
L27:    i2l 
L28:    ldc2_w 4294967295L 
L31:    land 
L32:    ladd 
L33:    ladd 
L34:    lstore 4 
L36:    aload_3 
L37:    iload 6 
L39:    lload 4 
L41:    l2i 
L42:    iastore 
L43:    lload 4 
L45:    bipush 32 
L47:    lushr 
L48:    lstore 4 
L50:    iinc 6 1 
L53:    goto L6 

        .stack chop 1 
L56:    return 
L57:    
        .linenumbertable 
            L0 11 
            L3 12 
            L12 14 
            L36 15 
            L43 16 
            L50 12 
            L56 18 
        .end linenumbertable 
        .localvariabletable 
            6 is i I from L6 to L56 
            0 is len I from L0 to L57 
            1 is x [I from L0 to L57 
            2 is y [I from L0 to L57 
            3 is z [I from L0 to L57 
            4 is c J from L3 to L57 
        .end localvariabletable 
    .end code 
.end method 

.method public static add33To : (II[I)V 
    .code stack 6 locals 5 
L0:     aload_2 
L1:     iconst_0 
L2:     iaload 
L3:     i2l 
L4:     ldc2_w 4294967295L 
L7:     land 
L8:     iload_1 
L9:     i2l 
L10:    ldc2_w 4294967295L 
L13:    land 
L14:    ladd 
L15:    lstore_3 
L16:    aload_2 
L17:    iconst_0 
L18:    lload_3 
L19:    l2i 
L20:    iastore 
L21:    lload_3 
L22:    bipush 32 
L24:    lushr 
L25:    lstore_3 
L26:    lload_3 
L27:    aload_2 
L28:    iconst_1 
L29:    iaload 
L30:    i2l 
L31:    ldc2_w 4294967295L 
L34:    land 
L35:    lconst_1 
L36:    ladd 
L37:    ladd 
L38:    lstore_3 
L39:    aload_2 
L40:    iconst_1 
L41:    lload_3 
L42:    l2i 
L43:    iastore 
L44:    lload_3 
L45:    bipush 32 
L47:    lushr 
L48:    lstore_3 
L49:    lload_3 
L50:    lconst_0 
L51:    lcmp 
L52:    ifeq L62 
L55:    iload_0 
L56:    aload_2 
L57:    iconst_2 
L58:    invokestatic Method Nat incAt (I[II)I 
L61:    pop 

        .stack append Long 
L62:    return 
L63:    
        .linenumbertable 
            L0 22 
            L16 23 
            L21 24 
            L26 25 
            L39 26 
            L44 27 
            L49 28 
            L55 29 
            L62 31 
        .end linenumbertable 
        .localvariabletable 
            0 is len I from L0 to L63 
            1 is x I from L0 to L63 
            2 is z [I from L0 to L63 
            3 is c J from L16 to L63 
        .end localvariabletable 
    .end code 
.end method 

.method public static addTo : (I[I[I)I 
    .code stack 8 locals 6 
L0:     lconst_0 
L1:     lstore_3 
L2:     iconst_0 
L3:     istore 5 

        .stack append Long Integer 
L5:     iload 5 
L7:     iload_0 
L8:     if_icmpge L50 
L11:    lload_3 
L12:    aload_1 
L13:    iload 5 
L15:    iaload 
L16:    i2l 
L17:    ldc2_w 4294967295L 
L20:    land 
L21:    aload_2 
L22:    iload 5 
L24:    iaload 
L25:    i2l 
L26:    ldc2_w 4294967295L 
L29:    land 
L30:    ladd 
L31:    ladd 
L32:    lstore_3 
L33:    aload_2 
L34:    iload 5 
L36:    lload_3 
L37:    l2i 
L38:    iastore 
L39:    lload_3 
L40:    bipush 32 
L42:    lushr 
L43:    lstore_3 
L44:    iinc 5 1 
L47:    goto L5 

        .stack chop 1 
L50:    lload_3 
L51:    l2i 
L52:    ireturn 
L53:    
        .linenumbertable 
            L0 35 
            L2 36 
            L11 38 
            L33 39 
            L39 40 
            L44 36 
            L50 42 
        .end linenumbertable 
        .localvariabletable 
            5 is i I from L5 to L50 
            0 is len I from L0 to L53 
            1 is x [I from L0 to L53 
            2 is z [I from L0 to L53 
            3 is c J from L2 to L53 
        .end localvariabletable 
    .end code 
.end method 

.method public static addWordTo : (II[I)I 
    .code stack 6 locals 5 
L0:     iload_1 
L1:     i2l 
L2:     ldc2_w 4294967295L 
L5:     land 
L6:     aload_2 
L7:     iconst_0 
L8:     iaload 
L9:     i2l 
L10:    ldc2_w 4294967295L 
L13:    land 
L14:    ladd 
L15:    lstore_3 
L16:    aload_2 
L17:    iconst_0 
L18:    lload_3 
L19:    l2i 
L20:    iastore 
L21:    lload_3 
L22:    bipush 32 
L24:    lushr 
L25:    lstore_3 
L26:    lload_3 
L27:    lconst_0 
L28:    lcmp 
L29:    ifne L36 
L32:    iconst_0 
L33:    goto L42 

        .stack append Long 
L36:    iload_0 
L37:    aload_2 
L38:    iconst_1 
L39:    invokestatic Method Nat incAt (I[II)I 

        .stack stack_1 Integer 
L42:    ireturn 
L43:    
        .linenumbertable 
            L0 47 
            L16 48 
            L21 49 
            L26 50 
        .end linenumbertable 
        .localvariabletable 
            0 is len I from L0 to L43 
            1 is x I from L0 to L43 
            2 is z [I from L0 to L43 
            3 is c J from L16 to L43 
        .end localvariabletable 
    .end code 
.end method 

.method public static copy : (I[I)[I 
    .code stack 5 locals 3 
L0:     iload_0 
L1:     newarray int 
L3:     astore_2 
L4:     aload_1 
L5:     iconst_0 
L6:     aload_2 
L7:     iconst_0 
L8:     iload_0 
L9:     invokestatic Method java/lang/System arraycopy (Ljava/lang/Object;ILjava/lang/Object;II)V 
L12:    aload_2 
L13:    areturn 
L14:    
        .linenumbertable 
            L0 55 
            L4 56 
            L12 57 
        .end linenumbertable 
        .localvariabletable 
            0 is len I from L0 to L14 
            1 is x [I from L0 to L14 
            2 is z [I from L4 to L14 
        .end localvariabletable 
    .end code 
.end method 

.method public static create : (I)[I 
    .code stack 1 locals 1 
L0:     iload_0 
L1:     newarray int 
L3:     areturn 
L4:     
        .linenumbertable 
            L0 62 
        .end linenumbertable 
        .localvariabletable 
            0 is len I from L0 to L4 
        .end localvariabletable 
    .end code 
.end method 

.method public static decAt : (I[II)I 
    .code stack 4 locals 4 
L0:     iload_2 
L1:     istore_3 

        .stack append Integer 
L2:     iload_3 
L3:     iload_0 
L4:     if_icmpge L27 
L7:     aload_1 
L8:     iload_3 
L9:     dup2 
L10:    iaload 
L11:    iconst_1 
L12:    isub 
L13:    dup_x2 
L14:    iastore 
L15:    iconst_m1 
L16:    if_icmpeq L21 
L19:    iconst_0 
L20:    ireturn 

        .stack same 
L21:    iinc 3 1 
L24:    goto L2 

        .stack chop 1 
L27:    iconst_m1 
L28:    ireturn 
L29:    
        .linenumbertable 
            L0 68 
            L7 70 
            L19 72 
            L21 68 
            L27 75 
        .end linenumbertable 
        .localvariabletable 
            3 is i I from L2 to L27 
            0 is len I from L0 to L29 
            1 is z [I from L0 to L29 
            2 is zPos I from L0 to L29 
        .end localvariabletable 
    .end code 
.end method 

.method public static fromBigInteger : (ILjava/math/BigInteger;)[I 
    .code stack 3 locals 5 
L0:     aload_1 
L1:     invokevirtual Method java/math/BigInteger signum ()I 
L4:     iflt L15 
L7:     aload_1 
L8:     invokevirtual Method java/math/BigInteger bitLength ()I 
L11:    iload_0 
L12:    if_icmple L23 

        .stack same 
L15:    new java/lang/IllegalArgumentException 
L18:    dup 
L19:    invokespecial Method java/lang/IllegalArgumentException <init> ()V 
L22:    athrow 

        .stack same 
L23:    iload_0 
L24:    bipush 31 
L26:    iadd 
L27:    iconst_5 
L28:    ishr 
L29:    istore_2 
L30:    iload_2 
L31:    invokestatic Method Nat create (I)[I 
L34:    astore_3 
L35:    iconst_0 
L36:    istore 4 

        .stack append Integer Object [I Integer 
L38:    aload_1 
L39:    invokevirtual Method java/math/BigInteger signum ()I 
L42:    ifeq L66 
L45:    aload_3 
L46:    iload 4 
L48:    iinc 4 1 
L51:    aload_1 
L52:    invokevirtual Method java/math/BigInteger intValue ()I 
L55:    iastore 
L56:    aload_1 
L57:    bipush 32 
L59:    invokevirtual Method java/math/BigInteger shiftRight (I)Ljava/math/BigInteger; 
L62:    astore_1 
L63:    goto L38 

        .stack same 
L66:    aload_3 
L67:    areturn 
L68:    
        .linenumbertable 
            L0 80 
            L15 82 
            L23 85 
            L30 86 
            L35 87 
            L38 88 
            L45 90 
            L56 91 
            L66 93 
        .end linenumbertable 
        .localvariabletable 
            0 is bits I from L0 to L68 
            1 is x Ljava/math/BigInteger; from L0 to L68 
            2 is len I from L30 to L68 
            3 is z [I from L35 to L68 
            4 is i I from L38 to L68 
        .end localvariabletable 
    .end code 
.end method 

.method public static gte : (I[I[I)Z 
    .code stack 2 locals 6 
L0:     iload_0 
L1:     iconst_1 
L2:     isub 
L3:     istore_3 

        .stack append Integer 
L4:     iload_3 
L5:     iflt L48 
L8:     aload_1 
L9:     iload_3 
L10:    iaload 
L11:    ldc -2147483648 
L13:    ixor 
L14:    istore 4 
L16:    aload_2 
L17:    iload_3 
L18:    iaload 
L19:    ldc -2147483648 
L21:    ixor 
L22:    istore 5 
L24:    iload 4 
L26:    iload 5 
L28:    if_icmpge L33 
L31:    iconst_0 
L32:    ireturn 

        .stack append Integer Integer 
L33:    iload 4 
L35:    iload 5 
L37:    if_icmple L42 
L40:    iconst_1 
L41:    ireturn 

        .stack chop 2 
L42:    iinc 3 -1 
L45:    goto L4 

        .stack chop 1 
L48:    iconst_1 
L49:    ireturn 
L50:    
        .linenumbertable 
            L0 98 
            L8 100 
            L16 101 
            L24 102 
            L31 103 
            L33 104 
            L40 105 
            L42 98 
            L48 107 
        .end linenumbertable 
        .localvariabletable 
            4 is x_i I from L16 to L42 
            5 is y_i I from L24 to L42 
            3 is i I from L4 to L48 
            0 is len I from L0 to L50 
            1 is x [I from L0 to L50 
            2 is y [I from L0 to L50 
        .end localvariabletable 
    .end code 
.end method 

.method public static incAt : (I[II)I 
    .code stack 4 locals 4 
L0:     iload_2 
L1:     istore_3 

        .stack append Integer 
L2:     iload_3 
L3:     iload_0 
L4:     if_icmpge L26 
L7:     aload_1 
L8:     iload_3 
L9:     dup2 
L10:    iaload 
L11:    iconst_1 
L12:    iadd 
L13:    dup_x2 
L14:    iastore 
L15:    ifeq L20 
L18:    iconst_0 
L19:    ireturn 

        .stack same 
L20:    iinc 3 1 
L23:    goto L2 

        .stack chop 1 
L26:    iconst_1 
L27:    ireturn 
L28:    
        .linenumbertable 
            L0 115 
            L7 117 
            L18 119 
            L20 115 
            L26 122 
        .end linenumbertable 
        .localvariabletable 
            3 is i I from L2 to L26 
            0 is len I from L0 to L28 
            1 is z [I from L0 to L28 
            2 is zPos I from L0 to L28 
        .end localvariabletable 
    .end code 
.end method 

.method public static incAt : (I[III)I 
    .code stack 4 locals 5 
L0:     iload_3 
L1:     istore 4 

        .stack append Integer 
L3:     iload 4 
L5:     iload_0 
L6:     if_icmpge L31 
L9:     aload_1 
L10:    iload_2 
L11:    iload 4 
L13:    iadd 
L14:    dup2 
L15:    iaload 
L16:    iconst_1 
L17:    iadd 
L18:    dup_x2 
L19:    iastore 
L20:    ifeq L25 
L23:    iconst_0 
L24:    ireturn 

        .stack same 
L25:    iinc 4 1 
L28:    goto L3 

        .stack chop 1 
L31:    iconst_1 
L32:    ireturn 
L33:    
        .linenumbertable 
            L0 128 
            L9 130 
            L23 132 
            L25 128 
            L31 135 
        .end linenumbertable 
        .localvariabletable 
            4 is i I from L3 to L31 
            0 is len I from L0 to L33 
            1 is z [I from L0 to L33 
            2 is zOff I from L0 to L33 
            3 is zPos I from L0 to L33 
        .end localvariabletable 
    .end code 
.end method 

.method public static isOne : (I[I)Z 
    .code stack 2 locals 3 
L0:     aload_1 
L1:     iconst_0 
L2:     iaload 
L3:     iconst_1 
L4:     if_icmpeq L9 
L7:     iconst_0 
L8:     ireturn 

        .stack same 
L9:     iconst_1 
L10:    istore_2 

        .stack append Integer 
L11:    iload_2 
L12:    iload_0 
L13:    if_icmpge L30 
L16:    aload_1 
L17:    iload_2 
L18:    iaload 
L19:    ifeq L24 
L22:    iconst_0 
L23:    ireturn 

        .stack same 
L24:    iinc 2 1 
L27:    goto L11 

        .stack chop 1 
L30:    iconst_1 
L31:    ireturn 
L32:    
        .linenumbertable 
            L0 140 
            L7 142 
            L9 144 
            L16 146 
            L22 148 
            L24 144 
            L30 151 
        .end linenumbertable 
        .localvariabletable 
            2 is i I from L11 to L30 
            0 is len I from L0 to L32 
            1 is x [I from L0 to L32 
        .end localvariabletable 
    .end code 
.end method 

.method public static isZero : (I[I)Z 
    .code stack 2 locals 3 
L0:     iconst_0 
L1:     istore_2 

        .stack append Integer 
L2:     iload_2 
L3:     iload_0 
L4:     if_icmpge L21 
L7:     aload_1 
L8:     iload_2 
L9:     iaload 
L10:    ifeq L15 
L13:    iconst_0 
L14:    ireturn 

        .stack same 
L15:    iinc 2 1 
L18:    goto L2 

        .stack chop 1 
L21:    iconst_1 
L22:    ireturn 
L23:    
        .linenumbertable 
            L0 156 
            L7 158 
            L13 160 
            L15 156 
            L21 163 
        .end linenumbertable 
        .localvariabletable 
            2 is i I from L2 to L21 
            0 is len I from L0 to L23 
            1 is x [I from L0 to L23 
        .end localvariabletable 
    .end code 
.end method 

.method public static shiftDownBit : (I[II)V 
    .code stack 5 locals 5 
L0:     iload_0 
L1:     istore_3 

        .stack append Integer 
L2:     iinc 3 -1 
L5:     iload_3 
L6:     iflt L32 
L9:     aload_1 
L10:    iload_3 
L11:    iaload 
L12:    istore 4 
L14:    aload_1 
L15:    iload_3 
L16:    iload 4 
L18:    iconst_1 
L19:    iushr 
L20:    iload_2 
L21:    bipush 31 
L23:    ishl 
L24:    ior 
L25:    iastore 
L26:    iload 4 
L28:    istore_2 
L29:    goto L2 

        .stack same 
L32:    return 
L33:    
        .linenumbertable 
            L0 168 
            L2 169 
            L9 171 
            L14 172 
            L26 173 
            L29 174 
            L32 175 
        .end linenumbertable 
        .localvariabletable 
            4 is next I from L14 to L29 
            0 is len I from L0 to L33 
            1 is z [I from L0 to L33 
            2 is c I from L0 to L33 
            3 is i I from L2 to L33 
        .end localvariabletable 
    .end code 
.end method 

.method public static shiftDownBits : (I[III)V 
    .code stack 5 locals 6 
L0:     iload_0 
L1:     istore 4 

        .stack append Integer 
L3:     iinc 4 -1 
L6:     iload 4 
L8:     iflt L36 
L11:    aload_1 
L12:    iload 4 
L14:    iaload 
L15:    istore 5 
L17:    aload_1 
L18:    iload 4 
L20:    iload 5 
L22:    iload_2 
L23:    iushr 
L24:    iload_3 
L25:    iload_2 
L26:    ineg 
L27:    ishl 
L28:    ior 
L29:    iastore 
L30:    iload 5 
L32:    istore_3 
L33:    goto L3 

        .stack same 
L36:    return 
L37:    
        .linenumbertable 
            L0 180 
            L3 181 
            L11 183 
            L17 184 
            L30 185 
            L33 186 
            L36 187 
        .end linenumbertable 
        .localvariabletable 
            5 is next I from L17 to L33 
            0 is len I from L0 to L37 
            1 is z [I from L0 to L37 
            2 is bits I from L0 to L37 
            3 is c I from L0 to L37 
            4 is i I from L3 to L37 
        .end localvariabletable 
    .end code 
.end method 

.method public static shiftDownWord : (I[II)V 
    .code stack 3 locals 5 
L0:     iload_0 
L1:     istore_3 

        .stack append Integer 
L2:     iinc 3 -1 
L5:     iload_3 
L6:     iflt L24 
L9:     aload_1 
L10:    iload_3 
L11:    iaload 
L12:    istore 4 
L14:    aload_1 
L15:    iload_3 
L16:    iload_2 
L17:    iastore 
L18:    iload 4 
L20:    istore_2 
L21:    goto L2 

        .stack same 
L24:    return 
L25:    
        .linenumbertable 
            L0 191 
            L2 192 
            L9 194 
            L14 195 
            L18 196 
            L21 197 
            L24 198 
        .end linenumbertable 
        .localvariabletable 
            4 is next I from L14 to L21 
            0 is len I from L0 to L25 
            1 is z [I from L0 to L25 
            2 is c I from L0 to L25 
            3 is i I from L2 to L25 
        .end localvariabletable 
    .end code 
.end method 

.method public static shiftUpBit : (I[II[I)I 
    .code stack 5 locals 6 
L0:     iconst_0 
L1:     istore 4 

        .stack append Integer 
L3:     iload 4 
L5:     iload_0 
L6:     if_icmpge L37 
L9:     aload_1 
L10:    iload 4 
L12:    iaload 
L13:    istore 5 
L15:    aload_3 
L16:    iload 4 
L18:    iload 5 
L20:    iconst_1 
L21:    ishl 
L22:    iload_2 
L23:    bipush 31 
L25:    iushr 
L26:    ior 
L27:    iastore 
L28:    iload 5 
L30:    istore_2 
L31:    iinc 4 1 
L34:    goto L3 

        .stack chop 1 
L37:    iload_2 
L38:    bipush 31 
L40:    iushr 
L41:    ireturn 
L42:    
        .linenumbertable 
            L0 202 
            L9 204 
            L15 205 
            L28 206 
            L31 202 
            L37 208 
        .end linenumbertable 
        .localvariabletable 
            5 is next I from L15 to L31 
            4 is i I from L3 to L37 
            0 is len I from L0 to L42 
            1 is x [I from L0 to L42 
            2 is c I from L0 to L42 
            3 is z [I from L0 to L42 
        .end localvariabletable 
    .end code 
.end method 

.method public static shiftUpBit : (I[III[II)V 
    .code stack 5 locals 8 
L0:     iconst_0 
L1:     istore 6 

        .stack append Integer 
L3:     iload 6 
L5:     iload_0 
L6:     if_icmpge L43 
L9:     aload_1 
L10:    iload_2 
L11:    iload 6 
L13:    iadd 
L14:    iaload 
L15:    istore 7 
L17:    aload 4 
L19:    iload 5 
L21:    iload 6 
L23:    iadd 
L24:    iload 7 
L26:    iconst_1 
L27:    ishl 
L28:    iload_3 
L29:    bipush 31 
L31:    iushr 
L32:    ior 
L33:    iastore 
L34:    iload 7 
L36:    istore_3 
L37:    iinc 6 1 
L40:    goto L3 

        .stack chop 1 
L43:    return 
L44:    
        .linenumbertable 
            L0 213 
            L9 215 
            L17 216 
            L34 217 
            L37 213 
            L43 219 
        .end linenumbertable 
        .localvariabletable 
            7 is next I from L17 to L37 
            6 is i I from L3 to L43 
            0 is len I from L0 to L44 
            1 is x [I from L0 to L44 
            2 is xOff I from L0 to L44 
            3 is c I from L0 to L44 
            4 is z [I from L0 to L44 
            5 is zOff I from L0 to L44 
        .end localvariabletable 
    .end code 
.end method 

.method public static shiftUpBits : (I[III)I 
    .code stack 5 locals 6 
L0:     iconst_0 
L1:     istore 4 

        .stack append Integer 
L3:     iload 4 
L5:     iload_0 
L6:     if_icmpge L37 
L9:     aload_1 
L10:    iload 4 
L12:    iaload 
L13:    istore 5 
L15:    aload_1 
L16:    iload 4 
L18:    iload 5 
L20:    iload_2 
L21:    ishl 
L22:    iload_3 
L23:    iload_2 
L24:    ineg 
L25:    iushr 
L26:    ior 
L27:    iastore 
L28:    iload 5 
L30:    istore_3 
L31:    iinc 4 1 
L34:    goto L3 

        .stack chop 1 
L37:    iload_3 
L38:    iload_2 
L39:    ineg 
L40:    iushr 
L41:    ireturn 
L42:    
        .linenumbertable 
            L0 224 
            L9 226 
            L15 227 
            L28 228 
            L31 224 
            L37 230 
        .end linenumbertable 
        .localvariabletable 
            5 is next I from L15 to L31 
            4 is i I from L3 to L37 
            0 is len I from L0 to L42 
            1 is z [I from L0 to L42 
            2 is bits I from L0 to L42 
            3 is c I from L0 to L42 
        .end localvariabletable 
    .end code 
.end method 

.method public static shiftUpBits : (I[III[I)I 
    .code stack 5 locals 7 
L0:     iconst_0 
L1:     istore 5 

        .stack append Integer 
L3:     iload 5 
L5:     iload_0 
L6:     if_icmpge L38 
L9:     aload_1 
L10:    iload 5 
L12:    iaload 
L13:    istore 6 
L15:    aload 4 
L17:    iload 5 
L19:    iload 6 
L21:    iload_2 
L22:    ishl 
L23:    iload_3 
L24:    iload_2 
L25:    ineg 
L26:    iushr 
L27:    ior 
L28:    iastore 
L29:    iload 6 
L31:    istore_3 
L32:    iinc 5 1 
L35:    goto L3 

        .stack chop 1 
L38:    iload_3 
L39:    iload_2 
L40:    ineg 
L41:    iushr 
L42:    ireturn 
L43:    
        .linenumbertable 
            L0 236 
            L9 238 
            L15 239 
            L29 240 
            L32 236 
            L38 242 
        .end linenumbertable 
        .localvariabletable 
            6 is next I from L15 to L32 
            5 is i I from L3 to L38 
            0 is len I from L0 to L43 
            1 is x [I from L0 to L43 
            2 is bits I from L0 to L43 
            3 is c I from L0 to L43 
            4 is z [I from L0 to L43 
        .end localvariabletable 
    .end code 
.end method 

.method public static sub33From : (II[I)V 
    .code stack 6 locals 5 
L0:     aload_2 
L1:     iconst_0 
L2:     iaload 
L3:     i2l 
L4:     ldc2_w 4294967295L 
L7:     land 
L8:     iload_1 
L9:     i2l 
L10:    ldc2_w 4294967295L 
L13:    land 
L14:    lsub 
L15:    lstore_3 
L16:    aload_2 
L17:    iconst_0 
L18:    lload_3 
L19:    l2i 
L20:    iastore 
L21:    lload_3 
L22:    bipush 32 
L24:    lshr 
L25:    lstore_3 
L26:    lload_3 
L27:    aload_2 
L28:    iconst_1 
L29:    iaload 
L30:    i2l 
L31:    ldc2_w 4294967295L 
L34:    land 
L35:    lconst_1 
L36:    lsub 
L37:    ladd 
L38:    lstore_3 
L39:    aload_2 
L40:    iconst_1 
L41:    lload_3 
L42:    l2i 
L43:    iastore 
L44:    lload_3 
L45:    bipush 32 
L47:    lshr 
L48:    lstore_3 
L49:    lload_3 
L50:    lconst_0 
L51:    lcmp 
L52:    ifeq L62 
L55:    iload_0 
L56:    aload_2 
L57:    iconst_2 
L58:    invokestatic Method Nat decAt (I[II)I 
L61:    pop 

        .stack append Long 
L62:    return 
L63:    
        .linenumbertable 
            L0 247 
            L16 248 
            L21 249 
            L26 250 
            L39 251 
            L44 252 
            L49 253 
            L55 254 
            L62 256 
        .end linenumbertable 
        .localvariabletable 
            0 is len I from L0 to L63 
            1 is x I from L0 to L63 
            2 is z [I from L0 to L63 
            3 is c J from L16 to L63 
        .end localvariabletable 
    .end code 
.end method 

.method public static subFrom : (I[I[I)I 
    .code stack 8 locals 6 
L0:     lconst_0 
L1:     lstore_3 
L2:     iconst_0 
L3:     istore 5 

        .stack append Long Integer 
L5:     iload 5 
L7:     iload_0 
L8:     if_icmpge L50 
L11:    lload_3 
L12:    aload_2 
L13:    iload 5 
L15:    iaload 
L16:    i2l 
L17:    ldc2_w 4294967295L 
L20:    land 
L21:    aload_1 
L22:    iload 5 
L24:    iaload 
L25:    i2l 
L26:    ldc2_w 4294967295L 
L29:    land 
L30:    lsub 
L31:    ladd 
L32:    lstore_3 
L33:    aload_2 
L34:    iload 5 
L36:    lload_3 
L37:    l2i 
L38:    iastore 
L39:    lload_3 
L40:    bipush 32 
L42:    lshr 
L43:    lstore_3 
L44:    iinc 5 1 
L47:    goto L5 

        .stack chop 1 
L50:    lload_3 
L51:    l2i 
L52:    ireturn 
L53:    
        .linenumbertable 
            L0 260 
            L2 261 
            L11 263 
            L33 264 
            L39 265 
            L44 261 
            L50 267 
        .end linenumbertable 
        .localvariabletable 
            5 is i I from L5 to L50 
            0 is len I from L0 to L53 
            1 is x [I from L0 to L53 
            2 is z [I from L0 to L53 
            3 is c J from L2 to L53 
        .end localvariabletable 
    .end code 
.end method 
.sourcefile 'Nat.java' 
.end class 
