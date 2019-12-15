.version 52 0 
.class public super SecP256K1FieldElement 
.super ECFieldElement$AbstractFp 
.field private static final Q Ljava/math/BigInteger; 
.field x [I 

.method public <init> : (Ljava/math/BigInteger;)V 
    .code stack 3 locals 2 
L0:     aload_0 
L1:     invokespecial Method ECFieldElement$AbstractFp <init> ()V 
L4:     aload_1 
L5:     ifnull L25 
L8:     aload_1 
L9:     invokevirtual Method java/math/BigInteger signum ()I 
L12:    iflt L25 
L15:    aload_1 
L16:    getstatic Field SecP256K1FieldElement Q Ljava/math/BigInteger; 
L19:    invokevirtual Method java/math/BigInteger compareTo (Ljava/math/BigInteger;)I 
L22:    iflt L35 

        .stack full 
            locals Object SecP256K1FieldElement Object java/math/BigInteger 
            stack 
        .end stack 
L25:    new java/lang/IllegalArgumentException 
L28:    dup 
L29:    ldc 'x value invalid for SecP256K1FieldElement' 
L31:    invokespecial Method java/lang/IllegalArgumentException <init> (Ljava/lang/String;)V 
L34:    athrow 

        .stack same 
L35:    aload_0 
L36:    aload_1 
L37:    invokestatic Method SecP256K1Field fromBigInteger (Ljava/math/BigInteger;)[I 
L40:    putfield Field SecP256K1FieldElement x [I 
L43:    return 
L44:    
        .linenumbertable 
            L0 11 
            L4 12 
            L25 14 
            L35 17 
            L43 18 
        .end linenumbertable 
        .localvariabletable 
            0 is this LSecP256K1FieldElement; from L0 to L44 
            1 is x Ljava/math/BigInteger; from L0 to L44 
        .end localvariabletable 
    .end code 
.end method 

.method <init> : ([I)V 
    .code stack 2 locals 2 
L0:     aload_0 
L1:     invokespecial Method ECFieldElement$AbstractFp <init> ()V 
L4:     aload_0 
L5:     aload_1 
L6:     putfield Field SecP256K1FieldElement x [I 
L9:     return 
L10:    
        .linenumbertable 
            L0 21 
            L4 22 
            L9 23 
        .end linenumbertable 
        .localvariabletable 
            0 is this LSecP256K1FieldElement; from L0 to L10 
            1 is x [I from L0 to L10 
        .end localvariabletable 
    .end code 
.end method 

.method public isZero : ()Z 
    .code stack 1 locals 1 
L0:     aload_0 
L1:     getfield Field SecP256K1FieldElement x [I 
L4:     invokestatic Method Nat256 isZero ([I)Z 
L7:     ireturn 
L8:     
        .linenumbertable 
            L0 27 
        .end linenumbertable 
        .localvariabletable 
            0 is this LSecP256K1FieldElement; from L0 to L8 
        .end localvariabletable 
    .end code 
.end method 

.method public isOne : ()Z 
    .code stack 1 locals 1 
L0:     aload_0 
L1:     getfield Field SecP256K1FieldElement x [I 
L4:     invokestatic Method Nat256 isOne ([I)Z 
L7:     ireturn 
L8:     
        .linenumbertable 
            L0 32 
        .end linenumbertable 
        .localvariabletable 
            0 is this LSecP256K1FieldElement; from L0 to L8 
        .end localvariabletable 
    .end code 
.end method 

.method public testBitZero : ()Z 
    .code stack 2 locals 1 
L0:     aload_0 
L1:     getfield Field SecP256K1FieldElement x [I 
L4:     iconst_0 
L5:     invokestatic Method Nat256 getBit ([II)I 
L8:     iconst_1 
L9:     if_icmpne L16 
L12:    iconst_1 
L13:    goto L17 

        .stack same 
L16:    iconst_0 

        .stack stack_1 Integer 
L17:    ireturn 
L18:    
        .linenumbertable 
            L0 37 
        .end linenumbertable 
        .localvariabletable 
            0 is this LSecP256K1FieldElement; from L0 to L18 
        .end localvariabletable 
    .end code 
.end method 

.method public toBigInteger : ()Ljava/math/BigInteger; 
    .code stack 1 locals 1 
L0:     aload_0 
L1:     getfield Field SecP256K1FieldElement x [I 
L4:     invokestatic Method Nat256 toBigInteger ([I)Ljava/math/BigInteger; 
L7:     areturn 
L8:     
        .linenumbertable 
            L0 42 
        .end linenumbertable 
        .localvariabletable 
            0 is this LSecP256K1FieldElement; from L0 to L8 
        .end localvariabletable 
    .end code 
.end method 

.method public getFieldSize : ()I 
    .code stack 1 locals 1 
L0:     getstatic Field SecP256K1FieldElement Q Ljava/math/BigInteger; 
L3:     invokevirtual Method java/math/BigInteger bitLength ()I 
L6:     ireturn 
L7:     
        .linenumbertable 
            L0 47 
        .end linenumbertable 
        .localvariabletable 
            0 is this LSecP256K1FieldElement; from L0 to L7 
        .end localvariabletable 
    .end code 
.end method 

.method public add : (LECFieldElement;)LECFieldElement; 
    .code stack 3 locals 3 
L0:     invokestatic Method Nat256 create ()[I 
L3:     astore_2 
L4:     aload_0 
L5:     getfield Field SecP256K1FieldElement x [I 
L8:     aload_1 
L9:     checkcast SecP256K1FieldElement 
L12:    getfield Field SecP256K1FieldElement x [I 
L15:    aload_2 
L16:    invokestatic Method SecP256K1Field add ([I[I[I)V 
L19:    new SecP256K1FieldElement 
L22:    dup 
L23:    aload_2 
L24:    invokespecial Method SecP256K1FieldElement <init> ([I)V 
L27:    areturn 
L28:    
        .linenumbertable 
            L0 52 
            L4 53 
            L19 54 
        .end linenumbertable 
        .localvariabletable 
            0 is this LSecP256K1FieldElement; from L0 to L28 
            1 is b LECFieldElement; from L0 to L28 
            2 is z [I from L4 to L28 
        .end localvariabletable 
    .end code 
.end method 

.method public multiply : (LECFieldElement;)LECFieldElement; 
    .code stack 3 locals 3 
L0:     invokestatic Method Nat256 create ()[I 
L3:     astore_2 
L4:     aload_0 
L5:     getfield Field SecP256K1FieldElement x [I 
L8:     aload_1 
L9:     checkcast SecP256K1FieldElement 
L12:    getfield Field SecP256K1FieldElement x [I 
L15:    aload_2 
L16:    invokestatic Method SecP256K1Field multiply ([I[I[I)V 
L19:    new SecP256K1FieldElement 
L22:    dup 
L23:    aload_2 
L24:    invokespecial Method SecP256K1FieldElement <init> ([I)V 
L27:    areturn 
L28:    
        .linenumbertable 
            L0 61 
            L4 62 
            L19 63 
        .end linenumbertable 
        .localvariabletable 
            0 is this LSecP256K1FieldElement; from L0 to L28 
            1 is b LECFieldElement; from L0 to L28 
            2 is z [I from L4 to L28 
        .end localvariabletable 
    .end code 
.end method 

.method public negate : ()LECFieldElement; 
    .code stack 3 locals 2 
L0:     invokestatic Method Nat256 create ()[I 
L3:     astore_1 
L4:     aload_0 
L5:     getfield Field SecP256K1FieldElement x [I 
L8:     aload_1 
L9:     invokestatic Method SecP256K1Field negate ([I[I)V 
L12:    new SecP256K1FieldElement 
L15:    dup 
L16:    aload_1 
L17:    invokespecial Method SecP256K1FieldElement <init> ([I)V 
L20:    areturn 
L21:    
        .linenumbertable 
            L0 69 
            L4 70 
            L12 71 
        .end linenumbertable 
        .localvariabletable 
            0 is this LSecP256K1FieldElement; from L0 to L21 
            1 is z [I from L4 to L21 
        .end localvariabletable 
    .end code 
.end method 

.method public square : ()LECFieldElement; 
    .code stack 3 locals 2 
L0:     invokestatic Method Nat256 create ()[I 
L3:     astore_1 
L4:     aload_0 
L5:     getfield Field SecP256K1FieldElement x [I 
L8:     aload_1 
L9:     invokestatic Method SecP256K1Field square ([I[I)V 
L12:    new SecP256K1FieldElement 
L15:    dup 
L16:    aload_1 
L17:    invokespecial Method SecP256K1FieldElement <init> ([I)V 
L20:    areturn 
L21:    
        .linenumbertable 
            L0 76 
            L4 77 
            L12 78 
        .end linenumbertable 
        .localvariabletable 
            0 is this LSecP256K1FieldElement; from L0 to L21 
            1 is z [I from L4 to L21 
        .end localvariabletable 
    .end code 
.end method 

.method public invert : ()LECFieldElement; 
    .code stack 3 locals 2 
L0:     invokestatic Method Nat256 create ()[I 
L3:     astore_1 
L4:     getstatic Field SecP256K1Field P [I 
L7:     aload_0 
L8:     getfield Field SecP256K1FieldElement x [I 
L11:    aload_1 
L12:    invokestatic Method Mod invert ([I[I[I)V 
L15:    new SecP256K1FieldElement 
L18:    dup 
L19:    aload_1 
L20:    invokespecial Method SecP256K1FieldElement <init> ([I)V 
L23:    areturn 
L24:    
        .linenumbertable 
            L0 84 
            L4 85 
            L15 86 
        .end linenumbertable 
        .localvariabletable 
            0 is this LSecP256K1FieldElement; from L0 to L24 
            1 is z [I from L4 to L24 
        .end localvariabletable 
    .end code 
.end method 

.method public sqrt : ()LECFieldElement; 
    .code stack 3 locals 8 
L0:     aload_0 
L1:     getfield Field SecP256K1FieldElement x [I 
L4:     astore_1 
L5:     aload_1 
L6:     invokestatic Method Nat256 isZero ([I)Z 
L9:     ifne L19 
L12:    aload_1 
L13:    invokestatic Method Nat256 isOne ([I)Z 
L16:    ifeq L21 

        .stack append Object [I 
L19:    aload_0 
L20:    areturn 

        .stack same 
L21:    invokestatic Method Nat256 create ()[I 
L24:    astore_2 
L25:    aload_1 
L26:    aload_2 
L27:    invokestatic Method SecP256K1Field square ([I[I)V 
L30:    aload_2 
L31:    aload_1 
L32:    aload_2 
L33:    invokestatic Method SecP256K1Field multiply ([I[I[I)V 
L36:    invokestatic Method Nat256 create ()[I 
L39:    astore_3 
L40:    aload_2 
L41:    aload_3 
L42:    invokestatic Method SecP256K1Field square ([I[I)V 
L45:    aload_3 
L46:    aload_1 
L47:    aload_3 
L48:    invokestatic Method SecP256K1Field multiply ([I[I[I)V 
L51:    invokestatic Method Nat256 create ()[I 
L54:    astore 4 
L56:    aload_3 
L57:    iconst_3 
L58:    aload 4 
L60:    invokestatic Method SecP256K1Field squareN ([II[I)V 
L63:    aload 4 
L65:    aload_3 
L66:    aload 4 
L68:    invokestatic Method SecP256K1Field multiply ([I[I[I)V 
L71:    aload 4 
L73:    iconst_3 
L74:    aload 4 
L76:    invokestatic Method SecP256K1Field squareN ([II[I)V 
L79:    aload 4 
L81:    aload_3 
L82:    aload 4 
L84:    invokestatic Method SecP256K1Field multiply ([I[I[I)V 
L87:    aload 4 
L89:    iconst_2 
L90:    aload 4 
L92:    invokestatic Method SecP256K1Field squareN ([II[I)V 
L95:    aload 4 
L97:    aload_2 
L98:    aload 4 
L100:   invokestatic Method SecP256K1Field multiply ([I[I[I)V 
L103:   invokestatic Method Nat256 create ()[I 
L106:   astore 5 
L108:   aload 4 
L110:   bipush 11 
L112:   aload 5 
L114:   invokestatic Method SecP256K1Field squareN ([II[I)V 
L117:   aload 5 
L119:   aload 4 
L121:   aload 5 
L123:   invokestatic Method SecP256K1Field multiply ([I[I[I)V 
L126:   aload 5 
L128:   bipush 22 
L130:   aload 4 
L132:   invokestatic Method SecP256K1Field squareN ([II[I)V 
L135:   aload 4 
L137:   aload 5 
L139:   aload 4 
L141:   invokestatic Method SecP256K1Field multiply ([I[I[I)V 
L144:   invokestatic Method Nat256 create ()[I 
L147:   astore 6 
L149:   aload 4 
L151:   bipush 44 
L153:   aload 6 
L155:   invokestatic Method SecP256K1Field squareN ([II[I)V 
L158:   aload 6 
L160:   aload 4 
L162:   aload 6 
L164:   invokestatic Method SecP256K1Field multiply ([I[I[I)V 
L167:   invokestatic Method Nat256 create ()[I 
L170:   astore 7 
L172:   aload 6 
L174:   bipush 88 
L176:   aload 7 
L178:   invokestatic Method SecP256K1Field squareN ([II[I)V 
L181:   aload 7 
L183:   aload 6 
L185:   aload 7 
L187:   invokestatic Method SecP256K1Field multiply ([I[I[I)V 
L190:   aload 7 
L192:   bipush 44 
L194:   aload 6 
L196:   invokestatic Method SecP256K1Field squareN ([II[I)V 
L199:   aload 6 
L201:   aload 4 
L203:   aload 6 
L205:   invokestatic Method SecP256K1Field multiply ([I[I[I)V 
L208:   aload 6 
L210:   iconst_3 
L211:   aload 4 
L213:   invokestatic Method SecP256K1Field squareN ([II[I)V 
L216:   aload 4 
L218:   aload_3 
L219:   aload 4 
L221:   invokestatic Method SecP256K1Field multiply ([I[I[I)V 
L224:   aload 4 
L226:   bipush 23 
L228:   aload 4 
L230:   invokestatic Method SecP256K1Field squareN ([II[I)V 
L233:   aload 4 
L235:   aload 5 
L237:   aload 4 
L239:   invokestatic Method SecP256K1Field multiply ([I[I[I)V 
L242:   aload 4 
L244:   bipush 6 
L246:   aload 4 
L248:   invokestatic Method SecP256K1Field squareN ([II[I)V 
L251:   aload 4 
L253:   aload_2 
L254:   aload 4 
L256:   invokestatic Method SecP256K1Field multiply ([I[I[I)V 
L259:   aload 4 
L261:   iconst_2 
L262:   aload 4 
L264:   invokestatic Method SecP256K1Field squareN ([II[I)V 
L267:   aload 4 
L269:   aload_2 
L270:   invokestatic Method SecP256K1Field square ([I[I)V 
L273:   aload_1 
L274:   aload_2 
L275:   invokestatic Method Nat256 eq ([I[I)Z 
L278:   ifeq L293 
L281:   new SecP256K1FieldElement 
L284:   dup 
L285:   aload 4 
L287:   invokespecial Method SecP256K1FieldElement <init> ([I)V 
L290:   goto L294 

        .stack full 
            locals Object SecP256K1FieldElement Object [I Object [I Object [I Object [I Object [I Object [I Object [I 
            stack 
        .end stack 
L293:   aconst_null 

        .stack stack_1 Object ECFieldElement 
L294:   areturn 
L295:   
        .linenumbertable 
            L0 95 
            L5 96 
            L19 98 
            L21 101 
            L25 102 
            L30 103 
            L36 104 
            L40 105 
            L45 106 
            L51 107 
            L56 108 
            L63 109 
            L71 110 
            L79 111 
            L87 112 
            L95 113 
            L103 114 
            L108 115 
            L117 116 
            L126 117 
            L135 118 
            L144 119 
            L149 120 
            L158 121 
            L167 122 
            L172 123 
            L181 124 
            L190 125 
            L199 126 
            L208 127 
            L216 128 
            L224 130 
            L233 131 
            L242 132 
            L251 133 
            L259 134 
            L267 136 
            L273 138 
        .end linenumbertable 
        .localvariabletable 
            0 is this LSecP256K1FieldElement; from L0 to L295 
            1 is x1 [I from L5 to L295 
            2 is x2 [I from L25 to L295 
            3 is x3 [I from L40 to L295 
            4 is x6 [I from L56 to L295 
            5 is x22 [I from L108 to L295 
            6 is x88 [I from L149 to L295 
            7 is x176 [I from L172 to L295 
        .end localvariabletable 
    .end code 
.end method 

.method public equals : (Ljava/lang/Object;)Z 
    .code stack 2 locals 3 
L0:     aload_1 
L1:     aload_0 
L2:     if_acmpne L7 
L5:     iconst_1 
L6:     ireturn 

        .stack same 
L7:     aload_1 
L8:     instanceof SecP256K1FieldElement 
L11:    ifne L16 
L14:    iconst_0 
L15:    ireturn 

        .stack same 
L16:    aload_1 
L17:    checkcast SecP256K1FieldElement 
L20:    astore_2 
L21:    aload_0 
L22:    getfield Field SecP256K1FieldElement x [I 
L25:    aload_2 
L26:    getfield Field SecP256K1FieldElement x [I 
L29:    invokestatic Method Nat256 eq ([I[I)Z 
L32:    ireturn 
L33:    
        .linenumbertable 
            L0 143 
            L5 145 
            L7 148 
            L14 150 
            L16 153 
            L21 154 
        .end linenumbertable 
        .localvariabletable 
            0 is this LSecP256K1FieldElement; from L0 to L33 
            1 is other Ljava/lang/Object; from L0 to L33 
            2 is o LSecP256K1FieldElement; from L21 to L33 
        .end localvariabletable 
    .end code 
.end method 

.method public hashCode : ()I 
    .code stack 4 locals 1 
L0:     getstatic Field SecP256K1FieldElement Q Ljava/math/BigInteger; 
L3:     invokevirtual Method java/math/BigInteger hashCode ()I 
L6:     aload_0 
L7:     getfield Field SecP256K1FieldElement x [I 
L10:    iconst_0 
L11:    bipush 8 
L13:    invokestatic Method Arrays hashCode ([III)I 
L16:    ixor 
L17:    ireturn 
L18:    
        .linenumbertable 
            L0 159 
        .end linenumbertable 
        .localvariabletable 
            0 is this LSecP256K1FieldElement; from L0 to L18 
        .end localvariabletable 
    .end code 
.end method 

.method static <clinit> : ()V 
    .code stack 1 locals 0 
L0:     getstatic Field SecP256K1Curve q Ljava/math/BigInteger; 
L3:     putstatic Field SecP256K1FieldElement Q Ljava/math/BigInteger; 
L6:     return 
L7:     
        .linenumbertable 
            L0 6 
        .end linenumbertable 
    .end code 
.end method 
.sourcefile 'SecP256K1FieldElement.java' 
.innerclasses 
    ECFieldElement$AbstractFp ECFieldElement AbstractFp static abstract 
.end innerclasses 
.end class 
