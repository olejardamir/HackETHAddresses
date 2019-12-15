.version 52 0 
.class super SecP256K1Field 
.super java/lang/Object 
.field static final P [I 
.field private static final PExt [I 
.field private static final PExtInv [I 
.field private static final P7 I = -1 
.field private static final PExt15 I = -1 
.field private static final PInv33 I = 977 

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
            0 is this LSecP256K1Field; from L0 to L5 
        .end localvariabletable 
    .end code 
.end method 

.method public static add : ([I[I[I)V 
    .code stack 3 locals 4 
L0:     aload_0 
L1:     aload_1 
L2:     aload_2 
L3:     invokestatic Method Nat256 add ([I[I[I)I 
L6:     istore_3 
L7:     iload_3 
L8:     ifne L29 
L11:    aload_2 
L12:    bipush 7 
L14:    iaload 
L15:    iconst_m1 
L16:    if_icmpne L38 
L19:    aload_2 
L20:    getstatic Field SecP256K1Field P [I 
L23:    invokestatic Method Nat256 gte ([I[I)Z 
L26:    ifeq L38 

        .stack append Integer 
L29:    bipush 8 
L31:    sipush 977 
L34:    aload_2 
L35:    invokestatic Method Nat add33To (II[I)V 

        .stack same 
L38:    return 
L39:    
        .linenumbertable 
            L0 61 
            L7 62 
            L29 64 
            L38 66 
        .end linenumbertable 
        .localvariabletable 
            0 is x [I from L0 to L39 
            1 is y [I from L0 to L39 
            2 is z [I from L0 to L39 
            3 is c I from L7 to L39 
        .end localvariabletable 
    .end code 
.end method 

.method public static fromBigInteger : (Ljava/math/BigInteger;)[I 
    .code stack 2 locals 2 
L0:     aload_0 
L1:     invokestatic Method Nat256 fromBigInteger (Ljava/math/BigInteger;)[I 
L4:     astore_1 
L5:     aload_1 
L6:     bipush 7 
L8:     iaload 
L9:     iconst_m1 
L10:    if_icmpne L30 
L13:    aload_1 
L14:    getstatic Field SecP256K1Field P [I 
L17:    invokestatic Method Nat256 gte ([I[I)Z 
L20:    ifeq L30 
L23:    getstatic Field SecP256K1Field P [I 
L26:    aload_1 
L27:    invokestatic Method Nat256 subFrom ([I[I)V 

        .stack append Object [I 
L30:    aload_1 
L31:    areturn 
L32:    
        .linenumbertable 
            L0 72 
            L5 73 
            L23 75 
            L30 77 
        .end linenumbertable 
        .localvariabletable 
            0 is x Ljava/math/BigInteger; from L0 to L32 
            1 is z [I from L5 to L32 
        .end localvariabletable 
    .end code 
.end method 

.method public static multiply : ([I[I[I)V 
    .code stack 3 locals 4 
L0:     invokestatic Method Nat256 createExt ()[I 
L3:     astore_3 
L4:     aload_0 
L5:     aload_1 
L6:     aload_3 
L7:     invokestatic Method Nat256 mul ([I[I[I)V 
L10:    aload_3 
L11:    aload_2 
L12:    invokestatic Method SecP256K1Field reduce ([I[I)V 
L15:    return 
L16:    
        .linenumbertable 
            L0 81 
            L4 82 
            L10 83 
            L15 84 
        .end linenumbertable 
        .localvariabletable 
            0 is a [I from L0 to L16 
            1 is a0 [I from L0 to L16 
            2 is a1 [I from L0 to L16 
            3 is a2 [I from L4 to L16 
        .end localvariabletable 
    .end code 
.end method 

.method public static multiplyAddToExt : ([I[I[I)V 
    .code stack 3 locals 4 
L0:     aload_0 
L1:     aload_1 
L2:     aload_2 
L3:     invokestatic Method Nat256 mulAddTo ([I[I[I)I 
L6:     istore_3 
L7:     iload_3 
L8:     ifne L31 
L11:    aload_2 
L12:    bipush 15 
L14:    iaload 
L15:    iconst_m1 
L16:    if_icmpne L56 
L19:    bipush 16 
L21:    aload_2 
L22:    getstatic Field SecP256K1Field PExt [I 
L25:    invokestatic Method Nat gte (I[I[I)Z 
L28:    ifeq L56 

        .stack append Integer 
L31:    getstatic Field SecP256K1Field PExtInv [I 
L34:    arraylength 
L35:    getstatic Field SecP256K1Field PExtInv [I 
L38:    aload_2 
L39:    invokestatic Method Nat addTo (I[I[I)I 
L42:    ifeq L56 
L45:    bipush 16 
L47:    aload_2 
L48:    getstatic Field SecP256K1Field PExtInv [I 
L51:    arraylength 
L52:    invokestatic Method Nat incAt (I[II)I 
L55:    pop 

        .stack same 
L56:    return 
L57:    
        .linenumbertable 
            L0 88 
            L7 89 
            L31 91 
            L45 93 
            L56 96 
        .end linenumbertable 
        .localvariabletable 
            0 is x [I from L0 to L57 
            1 is y [I from L0 to L57 
            2 is zz [I from L0 to L57 
            3 is c I from L7 to L57 
        .end localvariabletable 
    .end code 
.end method 

.method public static negate : ([I[I)V 
    .code stack 3 locals 2 
L0:     aload_0 
L1:     invokestatic Method Nat256 isZero ([I)Z 
L4:     ifeq L14 
L7:     aload_1 
L8:     invokestatic Method Nat256 zero ([I)V 
L11:    goto L23 

        .stack same 
L14:    getstatic Field SecP256K1Field P [I 
L17:    aload_0 
L18:    aload_1 
L19:    invokestatic Method Nat256 sub ([I[I[I)I 
L22:    pop 

        .stack same 
L23:    return 
L24:    
        .linenumbertable 
            L0 99 
            L7 100 
            L14 102 
            L23 104 
        .end linenumbertable 
        .localvariabletable 
            0 is a [I from L0 to L24 
            1 is a0 [I from L0 to L24 
        .end localvariabletable 
    .end code 
.end method 

.method public static reduce : ([I[I)V 
    .code stack 7 locals 5 
L0:     sipush 977 
L3:     aload_0 
L4:     bipush 8 
L6:     aload_0 
L7:     iconst_0 
L8:     aload_1 
L9:     iconst_0 
L10:    invokestatic Method Nat256 mul33Add (I[II[II[II)J 
L13:    lstore_2 
L14:    sipush 977 
L17:    lload_2 
L18:    aload_1 
L19:    iconst_0 
L20:    invokestatic Method Nat256 mul33DWordAdd (IJ[II)I 
L23:    istore 4 
L25:    iload 4 
L27:    ifne L48 
L30:    aload_1 
L31:    bipush 7 
L33:    iaload 
L34:    iconst_m1 
L35:    if_icmpne L57 
L38:    aload_1 
L39:    getstatic Field SecP256K1Field P [I 
L42:    invokestatic Method Nat256 gte ([I[I)Z 
L45:    ifeq L57 

        .stack append Long Integer 
L48:    bipush 8 
L50:    sipush 977 
L53:    aload_1 
L54:    invokestatic Method Nat add33To (II[I)V 

        .stack same 
L57:    return 
L58:    
        .linenumbertable 
            L0 108 
            L14 109 
            L25 113 
            L48 115 
            L57 117 
        .end linenumbertable 
        .localvariabletable 
            0 is xx [I from L0 to L58 
            1 is z [I from L0 to L58 
            2 is cc J from L14 to L58 
            4 is c I from L25 to L58 
        .end localvariabletable 
    .end code 
.end method 

.method public static reduce32 : (I[I)V 
    .code stack 4 locals 2 
L0:     iload_0 
L1:     ifeq L16 
L4:     sipush 977 
L7:     iload_0 
L8:     aload_1 
L9:     iconst_0 
L10:    invokestatic Method Nat256 mul33WordAdd (II[II)I 
L13:    ifne L34 

        .stack same 
L16:    aload_1 
L17:    bipush 7 
L19:    iaload 
L20:    iconst_m1 
L21:    if_icmpne L43 
L24:    aload_1 
L25:    getstatic Field SecP256K1Field P [I 
L28:    invokestatic Method Nat256 gte ([I[I)Z 
L31:    ifeq L43 

        .stack same 
L34:    bipush 8 
L36:    sipush 977 
L39:    aload_1 
L40:    invokestatic Method Nat add33To (II[I)V 

        .stack same 
L43:    return 
L44:    
        .linenumbertable 
            L0 121 
            L28 122 
            L34 124 
            L43 126 
        .end linenumbertable 
        .localvariabletable 
            0 is x I from L0 to L44 
            1 is z [I from L0 to L44 
        .end localvariabletable 
    .end code 
.end method 

.method public static square : ([I[I)V 
    .code stack 2 locals 3 
L0:     invokestatic Method Nat256 createExt ()[I 
L3:     astore_2 
L4:     aload_0 
L5:     aload_2 
L6:     invokestatic Method Nat256 square ([I[I)V 
L9:     aload_2 
L10:    aload_1 
L11:    invokestatic Method SecP256K1Field reduce ([I[I)V 
L14:    return 
L15:    
        .linenumbertable 
            L0 129 
            L4 130 
            L9 131 
            L14 132 
        .end linenumbertable 
        .localvariabletable 
            0 is a [I from L0 to L15 
            1 is a0 [I from L0 to L15 
            2 is a1 [I from L4 to L15 
        .end localvariabletable 
    .end code 
.end method 

.method public static squareN : ([II[I)V 
    .code stack 2 locals 5 
L0:     invokestatic Method Nat256 createExt ()[I 
L3:     astore_3 
L4:     aload_0 
L5:     aload_3 
L6:     invokestatic Method Nat256 square ([I[I)V 
L9:     aload_3 
L10:    aload_2 
L11:    invokestatic Method SecP256K1Field reduce ([I[I)V 

        .stack append Object [I 
L14:    iload_1 
L15:    iconst_m1 
L16:    iadd 
L17:    istore 4 
L19:    iload 4 
L21:    ifgt L25 
L24:    return 

        .stack append Integer 
L25:    aload_2 
L26:    aload_3 
L27:    invokestatic Method Nat256 square ([I[I)V 
L30:    aload_3 
L31:    aload_2 
L32:    invokestatic Method SecP256K1Field reduce ([I[I)V 
L35:    iload 4 
L37:    istore_1 
L38:    goto L14 
L41:    
        .linenumbertable 
            L0 135 
            L4 136 
            L9 137 
            L14 139 
            L19 140 
            L24 141 
            L25 143 
            L30 144 
            L35 145 
            L38 146 
        .end linenumbertable 
        .localvariabletable 
            4 is i0 I from L19 to L38 
            0 is a [I from L0 to L41 
            1 is i I from L0 to L41 
            2 is a0 [I from L0 to L41 
            3 is a1 [I from L4 to L41 
        .end localvariabletable 
    .end code 
.end method 

.method public static subtract : ([I[I[I)V 
    .code stack 3 locals 3 
L0:     aload_0 
L1:     aload_1 
L2:     aload_2 
L3:     invokestatic Method Nat256 sub ([I[I[I)I 
L6:     ifeq L18 
L9:     bipush 8 
L11:    sipush 977 
L14:    aload_2 
L15:    invokestatic Method Nat sub33From (II[I)V 

        .stack same 
L18:    return 
L19:    
        .linenumbertable 
            L0 150 
            L9 151 
            L18 153 
        .end linenumbertable 
        .localvariabletable 
            0 is a [I from L0 to L19 
            1 is a0 [I from L0 to L19 
            2 is a1 [I from L0 to L19 
        .end localvariabletable 
    .end code 
.end method 

.method public static twice : ([I[I)V 
    .code stack 4 locals 3 
L0:     bipush 8 
L2:     aload_0 
L3:     iconst_0 
L4:     aload_1 
L5:     invokestatic Method Nat shiftUpBit (I[II[I)I 
L8:     istore_2 
L9:     iload_2 
L10:    ifne L31 
L13:    aload_1 
L14:    bipush 7 
L16:    iaload 
L17:    iconst_m1 
L18:    if_icmpne L40 
L21:    aload_1 
L22:    getstatic Field SecP256K1Field P [I 
L25:    invokestatic Method Nat256 gte ([I[I)Z 
L28:    ifeq L40 

        .stack append Integer 
L31:    bipush 8 
L33:    sipush 977 
L36:    aload_1 
L37:    invokestatic Method Nat add33To (II[I)V 

        .stack same 
L40:    return 
L41:    
        .linenumbertable 
            L0 157 
            L9 158 
            L31 160 
            L40 162 
        .end linenumbertable 
        .localvariabletable 
            0 is x [I from L0 to L41 
            1 is z [I from L0 to L41 
            2 is c I from L9 to L41 
        .end localvariabletable 
    .end code 
.end method 

.method static <clinit> : ()V 
    .code stack 3 locals 3 
L0:     bipush 8 
L2:     newarray int 
L4:     astore_0 
L5:     aload_0 
L6:     iconst_0 
L7:     sipush -977 
L10:    iastore 
L11:    aload_0 
L12:    iconst_1 
L13:    bipush -2 
L15:    iastore 
L16:    aload_0 
L17:    iconst_2 
L18:    iconst_m1 
L19:    iastore 
L20:    aload_0 
L21:    iconst_3 
L22:    iconst_m1 
L23:    iastore 
L24:    aload_0 
L25:    iconst_4 
L26:    iconst_m1 
L27:    iastore 
L28:    aload_0 
L29:    iconst_5 
L30:    iconst_m1 
L31:    iastore 
L32:    aload_0 
L33:    bipush 6 
L35:    iconst_m1 
L36:    iastore 
L37:    aload_0 
L38:    bipush 7 
L40:    iconst_m1 
L41:    iastore 
L42:    aload_0 
L43:    putstatic Field SecP256K1Field P [I 
L46:    bipush 16 
L48:    newarray int 
L50:    astore_1 
L51:    aload_1 
L52:    iconst_0 
L53:    ldc 954529 
L55:    iastore 
L56:    aload_1 
L57:    iconst_1 
L58:    sipush 1954 
L61:    iastore 
L62:    aload_1 
L63:    iconst_2 
L64:    iconst_1 
L65:    iastore 
L66:    aload_1 
L67:    iconst_3 
L68:    iconst_0 
L69:    iastore 
L70:    aload_1 
L71:    iconst_4 
L72:    iconst_0 
L73:    iastore 
L74:    aload_1 
L75:    iconst_5 
L76:    iconst_0 
L77:    iastore 
L78:    aload_1 
L79:    bipush 6 
L81:    iconst_0 
L82:    iastore 
L83:    aload_1 
L84:    bipush 7 
L86:    iconst_0 
L87:    iastore 
L88:    aload_1 
L89:    bipush 8 
L91:    sipush -1954 
L94:    iastore 
L95:    aload_1 
L96:    bipush 9 
L98:    bipush -3 
L100:   iastore 
L101:   aload_1 
L102:   bipush 10 
L104:   iconst_m1 
L105:   iastore 
L106:   aload_1 
L107:   bipush 11 
L109:   iconst_m1 
L110:   iastore 
L111:   aload_1 
L112:   bipush 12 
L114:   iconst_m1 
L115:   iastore 
L116:   aload_1 
L117:   bipush 13 
L119:   iconst_m1 
L120:   iastore 
L121:   aload_1 
L122:   bipush 14 
L124:   iconst_m1 
L125:   iastore 
L126:   aload_1 
L127:   bipush 15 
L129:   iconst_m1 
L130:   iastore 
L131:   aload_1 
L132:   putstatic Field SecP256K1Field PExt [I 
L135:   bipush 10 
L137:   newarray int 
L139:   astore_2 
L140:   aload_2 
L141:   iconst_0 
L142:   ldc -954529 
L144:   iastore 
L145:   aload_2 
L146:   iconst_1 
L147:   sipush -1955 
L150:   iastore 
L151:   aload_2 
L152:   iconst_2 
L153:   bipush -2 
L155:   iastore 
L156:   aload_2 
L157:   iconst_3 
L158:   iconst_m1 
L159:   iastore 
L160:   aload_2 
L161:   iconst_4 
L162:   iconst_m1 
L163:   iastore 
L164:   aload_2 
L165:   iconst_5 
L166:   iconst_m1 
L167:   iastore 
L168:   aload_2 
L169:   bipush 6 
L171:   iconst_m1 
L172:   iastore 
L173:   aload_2 
L174:   bipush 7 
L176:   iconst_m1 
L177:   iastore 
L178:   aload_2 
L179:   bipush 8 
L181:   sipush 1953 
L184:   iastore 
L185:   aload_2 
L186:   bipush 9 
L188:   iconst_2 
L189:   iastore 
L190:   aload_2 
L191:   putstatic Field SecP256K1Field PExtInv [I 
L194:   return 
L195:   
        .linenumbertable 
            L0 14 
            L5 15 
            L11 16 
            L16 17 
            L20 18 
            L24 19 
            L28 20 
            L32 21 
            L37 22 
            L42 23 
            L46 24 
            L51 25 
            L56 26 
            L62 27 
            L66 28 
            L70 29 
            L74 30 
            L78 31 
            L83 32 
            L88 33 
            L95 34 
            L101 35 
            L106 36 
            L111 37 
            L116 38 
            L121 39 
            L126 40 
            L131 41 
            L135 42 
            L140 43 
            L145 44 
            L151 45 
            L156 46 
            L160 47 
            L164 48 
            L168 49 
            L173 50 
            L178 51 
            L185 52 
            L190 53 
            L194 54 
        .end linenumbertable 
        .localvariabletable 
            0 is a [I from L5 to L194 
            1 is a0 [I from L51 to L194 
            2 is a1 [I from L140 to L194 
        .end localvariabletable 
    .end code 
.end method 
.sourcefile 'SecP256K1Field.java' 
.end class 
