.version 52 0 
.class public super abstract ECPoint 
.super java/lang/Object 
.field private static final EMPTY_ZS [LECFieldElement; 
.field final curve LECCurve; 
.field final x LECFieldElement; 
.field final y LECFieldElement; 
.field final zs [LECFieldElement; 
.field withCompression Z 
.field preCompTable Ljava/util/Hashtable; 
.field static final synthetic $assertionsDisabled Z 

.method private static getInitialZCoords : (LECCurve;)[LECFieldElement; 
    .code stack 4 locals 3 
L0:     aconst_null 
L1:     aload_0 
L2:     if_acmpne L9 
L5:     iconst_0 
L6:     goto L13 

        .stack same 
L9:     aload_0 
L10:    invokevirtual Method ECCurve getCoordinateSystem ()I 

        .stack stack_1 Integer 
L13:    istore_1 
L14:    iload_1 
L15:    lookupswitch 
            0 : L40 
            5 : L40 
            default : L44 


        .stack append Integer 
L40:    getstatic Field ECPoint EMPTY_ZS [LECFieldElement; 
L43:    areturn 

        .stack same 
L44:    aload_0 
L45:    getstatic Field ECConstants ONE Ljava/math/BigInteger; 
L48:    invokevirtual Method ECCurve fromBigInteger (Ljava/math/BigInteger;)LECFieldElement; 
L51:    astore_2 
L52:    iload_1 
L53:    tableswitch 1 
            L92 
            L92 
            L101 
            L118 
            L134 
            L92 
            default : L134 


        .stack append Object ECFieldElement 
L92:    iconst_1 
L93:    anewarray ECFieldElement 
L96:    dup 
L97:    iconst_0 
L98:    aload_2 
L99:    aastore 
L100:   areturn 

        .stack same 
L101:   iconst_3 
L102:   anewarray ECFieldElement 
L105:   dup 
L106:   iconst_0 
L107:   aload_2 
L108:   aastore 
L109:   dup 
L110:   iconst_1 
L111:   aload_2 
L112:   aastore 
L113:   dup 
L114:   iconst_2 
L115:   aload_2 
L116:   aastore 
L117:   areturn 

        .stack same 
L118:   iconst_2 
L119:   anewarray ECFieldElement 
L122:   dup 
L123:   iconst_0 
L124:   aload_2 
L125:   aastore 
L126:   dup 
L127:   iconst_1 
L128:   aload_0 
L129:   invokevirtual Method ECCurve getA ()LECFieldElement; 
L132:   aastore 
L133:   areturn 

        .stack same 
L134:   new java/lang/IllegalArgumentException 
L137:   dup 
L138:   ldc 'unknown coordinate system' 
L140:   invokespecial Method java/lang/IllegalArgumentException <init> (Ljava/lang/String;)V 
L143:   athrow 
L144:   
        .linenumbertable 
            L0 12 
            L14 14 
            L40 18 
            L44 23 
            L52 25 
            L92 30 
            L101 32 
            L118 34 
            L134 36 
        .end linenumbertable 
        .localvariabletable 
            0 is curve LECCurve; from L0 to L144 
            1 is coord I from L14 to L144 
            2 is one LECFieldElement; from L52 to L144 
        .end localvariabletable 
    .end code 
.end method 

.method <init> : (LECCurve;LECFieldElement;LECFieldElement;)V 
    .code stack 5 locals 4 
L0:     aload_0 
L1:     aload_1 
L2:     aload_2 
L3:     aload_3 
L4:     aload_1 
L5:     invokestatic Method ECPoint getInitialZCoords (LECCurve;)[LECFieldElement; 
L8:     invokespecial Method ECPoint <init> (LECCurve;LECFieldElement;LECFieldElement;[LECFieldElement;)V 
L11:    return 
L12:    
        .linenumbertable 
            L0 52 
            L11 53 
        .end linenumbertable 
        .localvariabletable 
            0 is this LECPoint; from L0 to L12 
            1 is curve LECCurve; from L0 to L12 
            2 is x LECFieldElement; from L0 to L12 
            3 is y LECFieldElement; from L0 to L12 
        .end localvariabletable 
    .end code 
.end method 

.method <init> : (LECCurve;LECFieldElement;LECFieldElement;[LECFieldElement;)V 
    .code stack 2 locals 5 
L0:     aload_0 
L1:     invokespecial Method java/lang/Object <init> ()V 
L4:     aload_0 
L5:     aconst_null 
L6:     putfield Field ECPoint preCompTable Ljava/util/Hashtable; 
L9:     aload_0 
L10:    aload_1 
L11:    putfield Field ECPoint curve LECCurve; 
L14:    aload_0 
L15:    aload_2 
L16:    putfield Field ECPoint x LECFieldElement; 
L19:    aload_0 
L20:    aload_3 
L21:    putfield Field ECPoint y LECFieldElement; 
L24:    aload_0 
L25:    aload 4 
L27:    putfield Field ECPoint zs [LECFieldElement; 
L30:    return 
L31:    
        .linenumbertable 
            L0 56 
            L4 48 
            L9 57 
            L14 58 
            L19 59 
            L24 60 
            L30 61 
        .end linenumbertable 
        .localvariabletable 
            0 is this LECPoint; from L0 to L31 
            1 is curve LECCurve; from L0 to L31 
            2 is x LECFieldElement; from L0 to L31 
            3 is y LECFieldElement; from L0 to L31 
            4 is zs [LECFieldElement; from L0 to L31 
        .end localvariabletable 
    .end code 
.end method 

.method protected abstract satisfiesCurveEquation : ()Z 
.end method 

.method public getCurve : ()LECCurve; 
    .code stack 1 locals 1 
L0:     aload_0 
L1:     getfield Field ECPoint curve LECCurve; 
L4:     areturn 
L5:     
        .linenumbertable 
            L0 80 
        .end linenumbertable 
        .localvariabletable 
            0 is this LECPoint; from L0 to L5 
        .end localvariabletable 
    .end code 
.end method 

.method getCurveCoordinateSystem : ()I 
    .code stack 2 locals 1 
L0:     aconst_null 
L1:     aload_0 
L2:     getfield Field ECPoint curve LECCurve; 
L5:     if_acmpne L12 
L8:     iconst_0 
L9:     goto L19 

        .stack same 
L12:    aload_0 
L13:    getfield Field ECPoint curve LECCurve; 
L16:    invokevirtual Method ECCurve getCoordinateSystem ()I 

        .stack stack_1 Integer 
L19:    ireturn 
L20:    
        .linenumbertable 
            L0 86 
        .end linenumbertable 
        .localvariabletable 
            0 is this LECPoint; from L0 to L20 
        .end localvariabletable 
    .end code 
.end method 

.method getAffineYCoord : ()LECFieldElement; 
    .code stack 1 locals 1 
L0:     aload_0 
L1:     invokespecial Method ECPoint checkNormalized ()V 
L4:     aload_0 
L5:     invokevirtual Method ECPoint getYCoord ()LECFieldElement; 
L8:     areturn 
L9:     
        .linenumbertable 
            L0 91 
            L4 92 
        .end linenumbertable 
        .localvariabletable 
            0 is this LECPoint; from L0 to L9 
        .end localvariabletable 
    .end code 
.end method 

.method public getXCoord : ()LECFieldElement; 
    .code stack 1 locals 1 
L0:     aload_0 
L1:     getfield Field ECPoint x LECFieldElement; 
L4:     areturn 
L5:     
        .linenumbertable 
            L0 98 
        .end linenumbertable 
        .localvariabletable 
            0 is this LECPoint; from L0 to L5 
        .end localvariabletable 
    .end code 
.end method 

.method public getYCoord : ()LECFieldElement; 
    .code stack 1 locals 1 
L0:     aload_0 
L1:     getfield Field ECPoint y LECFieldElement; 
L4:     areturn 
L5:     
        .linenumbertable 
            L0 103 
        .end linenumbertable 
        .localvariabletable 
            0 is this LECPoint; from L0 to L5 
        .end localvariabletable 
    .end code 
.end method 

.method public getZCoord : (I)LECFieldElement; 
    .code stack 2 locals 2 
L0:     iload_1 
L1:     iflt L13 
L4:     iload_1 
L5:     aload_0 
L6:     getfield Field ECPoint zs [LECFieldElement; 
L9:     arraylength 
L10:    if_icmplt L17 

        .stack same 
L13:    aconst_null 
L14:    goto L23 

        .stack same 
L17:    aload_0 
L18:    getfield Field ECPoint zs [LECFieldElement; 
L21:    iload_1 
L22:    aaload 

        .stack stack_1 Object ECFieldElement 
L23:    areturn 
L24:    
        .linenumbertable 
            L0 108 
        .end linenumbertable 
        .localvariabletable 
            0 is this LECPoint; from L0 to L24 
            1 is index I from L0 to L24 
        .end localvariabletable 
    .end code 
.end method 

.method public final getRawXCoord : ()LECFieldElement; 
    .code stack 1 locals 1 
L0:     aload_0 
L1:     getfield Field ECPoint x LECFieldElement; 
L4:     areturn 
L5:     
        .linenumbertable 
            L0 113 
        .end linenumbertable 
        .localvariabletable 
            0 is this LECPoint; from L0 to L5 
        .end localvariabletable 
    .end code 
.end method 

.method public final getRawYCoord : ()LECFieldElement; 
    .code stack 1 locals 1 
L0:     aload_0 
L1:     getfield Field ECPoint y LECFieldElement; 
L4:     areturn 
L5:     
        .linenumbertable 
            L0 118 
        .end linenumbertable 
        .localvariabletable 
            0 is this LECPoint; from L0 to L5 
        .end localvariabletable 
    .end code 
.end method 

.method private checkNormalized : ()V 
    .code stack 3 locals 1 
L0:     aload_0 
L1:     invokevirtual Method ECPoint isNormalized ()Z 
L4:     ifeq L17 
L7:     new java/lang/IllegalStateException 
L10:    dup 
L11:    ldc 'point not in normal form' 
L13:    invokespecial Method java/lang/IllegalStateException <init> (Ljava/lang/String;)V 
L16:    athrow 

        .stack same 
L17:    return 
L18:    
        .linenumbertable 
            L0 123 
            L7 125 
            L17 127 
        .end linenumbertable 
        .localvariabletable 
            0 is this LECPoint; from L0 to L18 
        .end localvariabletable 
    .end code 
.end method 

.method public isNormalized : ()Z 
    .code stack 2 locals 2 
L0:     aload_0 
L1:     invokevirtual Method ECPoint getCurveCoordinateSystem ()I 
L4:     istore_1 
L5:     iload_1 
L6:     ifeq L37 
L9:     iload_1 
L10:    iconst_5 
L11:    if_icmpeq L37 
L14:    aload_0 
L15:    invokevirtual Method ECPoint isInfinity ()Z 
L18:    ifne L37 
L21:    aload_0 
L22:    getfield Field ECPoint zs [LECFieldElement; 
L25:    iconst_0 
L26:    aaload 
L27:    invokevirtual Method ECFieldElement isOne ()Z 
L30:    ifne L37 
L33:    iconst_1 
L34:    goto L38 

        .stack append Integer 
L37:    iconst_0 

        .stack stack_1 Integer 
L38:    ireturn 
L39:    
        .linenumbertable 
            L0 131 
            L5 133 
            L15 135 
            L27 136 
            L38 133 
        .end linenumbertable 
        .localvariabletable 
            0 is this LECPoint; from L0 to L39 
            1 is coord I from L5 to L39 
        .end localvariabletable 
    .end code 
.end method 

.method public normalize : ()LECPoint; 
    .code stack 2 locals 2 
L0:     aload_0 
L1:     invokevirtual Method ECPoint isInfinity ()Z 
L4:     ifeq L9 
L7:     aload_0 
L8:     areturn 

        .stack same 
L9:     aload_0 
L10:    invokevirtual Method ECPoint getCurveCoordinateSystem ()I 
L13:    lookupswitch 
            0 : L40 
            5 : L40 
            default : L42 


        .stack same 
L40:    aload_0 
L41:    areturn 

        .stack same 
L42:    aload_0 
L43:    iconst_0 
L44:    invokevirtual Method ECPoint getZCoord (I)LECFieldElement; 
L47:    astore_1 
L48:    aload_1 
L49:    invokevirtual Method ECFieldElement isOne ()Z 
L52:    ifeq L57 
L55:    aload_0 
L56:    areturn 

        .stack append Object ECFieldElement 
L57:    aload_0 
L58:    aload_1 
L59:    invokevirtual Method ECFieldElement invert ()LECFieldElement; 
L62:    invokevirtual Method ECPoint normalize (LECFieldElement;)LECPoint; 
L65:    areturn 
L66:    
        .linenumbertable 
            L0 141 
            L7 143 
            L9 146 
            L40 151 
            L42 155 
            L48 156 
            L55 158 
            L57 161 
        .end linenumbertable 
        .localvariabletable 
            1 is Z1 LECFieldElement; from L48 to L66 
            0 is this LECPoint; from L0 to L66 
        .end localvariabletable 
    .end code 
.end method 

.method normalize : (LECFieldElement;)LECPoint; 
    .code stack 3 locals 4 
L0:     aload_0 
L1:     invokevirtual Method ECPoint getCurveCoordinateSystem ()I 
L4:     tableswitch 1 
            L44 
            L51 
            L51 
            L51 
            L69 
            L44 
            default : L69 


        .stack same 
L44:    aload_0 
L45:    aload_1 
L46:    aload_1 
L47:    invokespecial Method ECPoint createScaledPoint (LECFieldElement;LECFieldElement;)LECPoint; 
L50:    areturn 

        .stack same 
L51:    aload_1 
L52:    invokevirtual Method ECFieldElement square ()LECFieldElement; 
L55:    astore_2 
L56:    aload_2 
L57:    aload_1 
L58:    invokevirtual Method ECFieldElement multiply (LECFieldElement;)LECFieldElement; 
L61:    astore_3 
L62:    aload_0 
L63:    aload_2 
L64:    aload_3 
L65:    invokespecial Method ECPoint createScaledPoint (LECFieldElement;LECFieldElement;)LECPoint; 
L68:    areturn 

        .stack same 
L69:    new java/lang/IllegalStateException 
L72:    dup 
L73:    ldc 'not a projective coordinate system' 
L75:    invokespecial Method java/lang/IllegalStateException <init> (Ljava/lang/String;)V 
L78:    athrow 
L79:    
        .linenumbertable 
            L0 168 
            L44 173 
            L51 179 
            L62 180 
            L69 184 
        .end linenumbertable 
        .localvariabletable 
            2 is zInv2 LECFieldElement; from L56 to L69 
            3 is zInv3 LECFieldElement; from L62 to L69 
            0 is this LECPoint; from L0 to L79 
            1 is zInv LECFieldElement; from L0 to L79 
        .end localvariabletable 
    .end code 
.end method 

.method private createScaledPoint : (LECFieldElement;LECFieldElement;)LECPoint; 
    .code stack 4 locals 3 
L0:     aload_0 
L1:     invokevirtual Method ECPoint getCurve ()LECCurve; 
L4:     aload_0 
L5:     invokevirtual Method ECPoint getRawXCoord ()LECFieldElement; 
L8:     aload_1 
L9:     invokevirtual Method ECFieldElement multiply (LECFieldElement;)LECFieldElement; 
L12:    aload_0 
L13:    invokevirtual Method ECPoint getRawYCoord ()LECFieldElement; 
L16:    aload_2 
L17:    invokevirtual Method ECFieldElement multiply (LECFieldElement;)LECFieldElement; 
L20:    aload_0 
L21:    getfield Field ECPoint withCompression Z 
L24:    invokevirtual Method ECCurve createRawPoint (LECFieldElement;LECFieldElement;Z)LECPoint; 
L27:    areturn 
L28:    
        .linenumbertable 
            L0 191 
        .end linenumbertable 
        .localvariabletable 
            0 is this LECPoint; from L0 to L28 
            1 is sx LECFieldElement; from L0 to L28 
            2 is sy LECFieldElement; from L0 to L28 
        .end localvariabletable 
    .end code 
.end method 

.method public isInfinity : ()Z 
    .code stack 2 locals 1 
L0:     aload_0 
L1:     getfield Field ECPoint x LECFieldElement; 
L4:     ifnull L34 
L7:     aload_0 
L8:     getfield Field ECPoint y LECFieldElement; 
L11:    ifnull L34 
L14:    aload_0 
L15:    getfield Field ECPoint zs [LECFieldElement; 
L18:    arraylength 
L19:    ifle L38 
L22:    aload_0 
L23:    getfield Field ECPoint zs [LECFieldElement; 
L26:    iconst_0 
L27:    aaload 
L28:    invokevirtual Method ECFieldElement isZero ()Z 
L31:    ifeq L38 

        .stack same 
L34:    iconst_1 
L35:    goto L39 

        .stack same 
L38:    iconst_0 

        .stack stack_1 Integer 
L39:    ireturn 
L40:    
        .linenumbertable 
            L0 196 
        .end linenumbertable 
        .localvariabletable 
            0 is this LECPoint; from L0 to L40 
        .end localvariabletable 
    .end code 
.end method 

.method public isValid : ()Z 
    .code stack 3 locals 1 
L0:     aload_0 
L1:     iconst_0 
L2:     iconst_1 
L3:     invokevirtual Method ECPoint implIsValid (ZZ)Z 
L6:     ifne L13 
L9:     iconst_1 
L10:    goto L14 

        .stack same 
L13:    iconst_0 

        .stack stack_1 Integer 
L14:    ireturn 
L15:    
        .linenumbertable 
            L0 202 
        .end linenumbertable 
        .localvariabletable 
            0 is this LECPoint; from L0 to L15 
        .end localvariabletable 
    .end code 
    .exceptions java/lang/CloneNotSupportedException 
.end method 

.method isValidPartial : ()Z 
    .code stack 3 locals 1 
L0:     aload_0 
L1:     iconst_0 
L2:     iconst_0 
L3:     invokevirtual Method ECPoint implIsValid (ZZ)Z 
L6:     ireturn 
L7:     
        .linenumbertable 
            L0 206 
        .end linenumbertable 
        .localvariabletable 
            0 is this LECPoint; from L0 to L7 
        .end localvariabletable 
    .end code 
    .exceptions java/lang/CloneNotSupportedException 
.end method 

.method implIsValid : (ZZ)Z 
    .code stack 8 locals 4 
L0:     aload_0 
L1:     invokevirtual Method ECPoint isInfinity ()Z 
L4:     ifeq L9 
L7:     iconst_1 
L8:     ireturn 

        .stack same 
L9:     aload_0 
L10:    invokevirtual Method ECPoint getCurve ()LECCurve; 
L13:    aload_0 
L14:    ldc 'bc_validity' 
L16:    new ECPoint$1 
L19:    dup 
L20:    aload_0 
L21:    iload_1 
L22:    iload_2 
L23:    invokespecial Method ECPoint$1 <init> (LECPoint;ZZ)V 
L26:    invokevirtual Method ECCurve precompute (LECPoint;Ljava/lang/String;LPreCompCallback;)LPreCompInfo; 
L29:    checkcast ValidityPrecompInfo 
L32:    astore_3 
L33:    aload_3 
L34:    invokevirtual Method ValidityPrecompInfo hasFailed ()Z 
L37:    ifne L44 
L40:    iconst_1 
L41:    goto L45 

        .stack append Object ValidityPrecompInfo 
L44:    iconst_0 

        .stack stack_1 Integer 
L45:    ireturn 
L46:    
        .linenumbertable 
            L0 210 
            L7 212 
            L9 215 
            L33 250 
        .end linenumbertable 
        .localvariabletable 
            0 is this LECPoint; from L0 to L46 
            1 is decompressed Z from L0 to L46 
            2 is checkOrder Z from L0 to L46 
            3 is validity LValidityPrecompInfo; from L33 to L46 
        .end localvariabletable 
    .end code 
    .exceptions java/lang/CloneNotSupportedException 
.end method 

.method public equals : (LECPoint;)Z 
    .code stack 5 locals 11 
L0:     aconst_null 
L1:     aload_1 
L2:     if_acmpne L7 
L5:     iconst_0 
L6:     ireturn 

        .stack same 
L7:     aload_0 
L8:     invokevirtual Method ECPoint getCurve ()LECCurve; 
L11:    astore_2 
L12:    aload_1 
L13:    invokevirtual Method ECPoint getCurve ()LECCurve; 
L16:    astore_3 
L17:    aconst_null 
L18:    aload_2 
L19:    if_acmpne L26 
L22:    iconst_1 
L23:    goto L27 

        .stack append Object ECCurve Object ECCurve 
L26:    iconst_0 

        .stack stack_1 Integer 
L27:    istore 4 
L29:    aconst_null 
L30:    aload_3 
L31:    if_acmpne L38 
L34:    iconst_1 
L35:    goto L39 

        .stack append Integer 
L38:    iconst_0 

        .stack stack_1 Integer 
L39:    istore 5 
L41:    aload_0 
L42:    invokevirtual Method ECPoint isInfinity ()Z 
L45:    istore 6 
L47:    aload_1 
L48:    invokevirtual Method ECPoint isInfinity ()Z 
L51:    istore 7 
L53:    iload 6 
L55:    ifne L63 
L58:    iload 7 
L60:    ifeq L97 

        .stack append Integer Integer Integer 
L63:    iload 6 
L65:    ifeq L95 
L68:    iload 7 
L70:    ifeq L95 
L73:    iload 4 
L75:    ifne L91 
L78:    iload 5 
L80:    ifne L91 
L83:    aload_2 
L84:    aload_3 
L85:    invokevirtual Method ECCurve equals (LECCurve;)Z 
L88:    ifeq L95 

        .stack same 
L91:    iconst_1 
L92:    goto L96 

        .stack same 
L95:    iconst_0 

        .stack stack_1 Integer 
L96:    ireturn 

        .stack same 
L97:    aload_0 
L98:    astore 8 
L100:   aload_1 
L101:   astore 9 
L103:   iload 4 
L105:   ifeq L118 
L108:   aload 9 
L110:   invokevirtual Method ECPoint normalize ()LECPoint; 
L113:   astore 9 
L115:   goto L180 

        .stack append Object ECPoint Object ECPoint 
L118:   iload 5 
L120:   ifeq L133 
L123:   aload 8 
L125:   invokevirtual Method ECPoint normalize ()LECPoint; 
L128:   astore 8 
L130:   goto L180 

        .stack same 
L133:   aload_2 
L134:   aload_3 
L135:   invokevirtual Method ECCurve equals (LECCurve;)Z 
L138:   ifne L143 
L141:   iconst_0 
L142:   ireturn 

        .stack same 
L143:   iconst_2 
L144:   anewarray ECPoint 
L147:   dup 
L148:   iconst_0 
L149:   aload_0 
L150:   aastore 
L151:   dup 
L152:   iconst_1 
L153:   aload_2 
L154:   aload 9 
L156:   invokevirtual Method ECCurve importPoint (LECPoint;)LECPoint; 
L159:   aastore 
L160:   astore 10 
L162:   aload_2 
L163:   aload 10 
L165:   invokevirtual Method ECCurve normalizeAll ([LECPoint;)V 
L168:   aload 10 
L170:   iconst_0 
L171:   aaload 
L172:   astore 8 
L174:   aload 10 
L176:   iconst_1 
L177:   aaload 
L178:   astore 9 

        .stack same 
L180:   aload 8 
L182:   invokevirtual Method ECPoint getXCoord ()LECFieldElement; 
L185:   aload 9 
L187:   invokevirtual Method ECPoint getXCoord ()LECFieldElement; 
L190:   invokevirtual Method java/lang/Object equals (Ljava/lang/Object;)Z 
L193:   ifeq L216 
L196:   aload 8 
L198:   invokevirtual Method ECPoint getYCoord ()LECFieldElement; 
L201:   aload 9 
L203:   invokevirtual Method ECPoint getYCoord ()LECFieldElement; 
L206:   invokevirtual Method java/lang/Object equals (Ljava/lang/Object;)Z 
L209:   ifeq L216 
L212:   iconst_1 
L213:   goto L217 

        .stack same 
L216:   iconst_0 

        .stack stack_1 Integer 
L217:   ireturn 
L218:   
        .linenumbertable 
            L0 254 
            L5 256 
            L7 259 
            L17 260 
            L41 261 
            L53 263 
            L63 265 
            L97 268 
            L103 270 
            L108 272 
            L118 274 
            L123 276 
            L133 278 
            L141 280 
            L143 286 
            L162 289 
            L168 291 
            L174 292 
            L180 295 
        .end linenumbertable 
        .localvariabletable 
            10 is points [LECPoint; from L162 to L180 
            0 is this LECPoint; from L0 to L218 
            1 is other LECPoint; from L0 to L218 
            2 is c1 LECCurve; from L12 to L218 
            3 is c2 LECCurve; from L17 to L218 
            4 is n1 Z from L29 to L218 
            5 is n2 Z from L41 to L218 
            6 is i1 Z from L47 to L218 
            7 is i2 Z from L53 to L218 
            8 is p1 LECPoint; from L100 to L218 
            9 is p2 LECPoint; from L103 to L218 
        .end localvariabletable 
    .end code 
    .exceptions java/lang/CloneNotSupportedException 
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
L8:     instanceof ECPoint 
L11:    ifne L16 
L14:    iconst_0 
L15:    ireturn 
        .catch java/lang/CloneNotSupportedException from L16 to L24 using L25 

        .stack same 
L16:    aload_0 
L17:    aload_1 
L18:    checkcast ECPoint 
L21:    invokevirtual Method ECPoint equals (LECPoint;)Z 
L24:    ireturn 

        .stack stack_1 Object java/lang/CloneNotSupportedException 
L25:    astore_2 
L26:    aload_2 
L27:    invokevirtual Method java/lang/CloneNotSupportedException printStackTrace ()V 
L30:    iconst_0 
L31:    ireturn 
L32:    
        .linenumbertable 
            L0 300 
            L5 302 
            L7 305 
            L14 307 
            L16 311 
            L25 312 
            L26 313 
            L30 315 
        .end linenumbertable 
        .localvariabletable 
            2 is e Ljava/lang/CloneNotSupportedException; from L26 to L30 
            0 is this LECPoint; from L0 to L32 
            1 is other Ljava/lang/Object; from L0 to L32 
        .end localvariabletable 
    .end code 
.end method 

.method public hashCode : ()I 
    .code stack 3 locals 4 
L0:     aload_0 
L1:     invokevirtual Method ECPoint getCurve ()LECCurve; 
L4:     astore_1 
L5:     aconst_null 
L6:     aload_1 
L7:     if_acmpne L14 
L10:    iconst_0 
L11:    goto L20 

        .stack append Object ECCurve 
L14:    aload_1 
L15:    invokevirtual Method ECCurve hashCode ()I 
L18:    iconst_m1 
L19:    ixor 

        .stack stack_1 Integer 
L20:    istore_2 
L21:    aload_0 
L22:    invokevirtual Method ECPoint isInfinity ()Z 
L25:    ifne L78 
L28:    aload_0 
L29:    invokevirtual Method ECPoint normalize ()LECPoint; 
L32:    astore_3 
L33:    getstatic Field ECPoint $assertionsDisabled Z 
L36:    ifne L51 
L39:    aload_3 
L40:    ifnonnull L51 
L43:    new java/lang/AssertionError 
L46:    dup 
L47:    invokespecial Method java/lang/AssertionError <init> ()V 
L50:    athrow 

        .stack append Integer Object ECPoint 
L51:    iload_2 
L52:    aload_3 
L53:    invokevirtual Method ECPoint getXCoord ()LECFieldElement; 
L56:    invokevirtual Method java/lang/Object hashCode ()I 
L59:    bipush 17 
L61:    imul 
L62:    ixor 
L63:    istore_2 
L64:    iload_2 
L65:    aload_3 
L66:    invokevirtual Method ECPoint getYCoord ()LECFieldElement; 
L69:    invokevirtual Method java/lang/Object hashCode ()I 
L72:    sipush 257 
L75:    imul 
L76:    ixor 
L77:    istore_2 

        .stack chop 1 
L78:    iload_2 
L79:    ireturn 
L80:    
        .linenumbertable 
            L0 320 
            L5 321 
            L21 323 
            L28 328 
            L33 331 
            L51 332 
            L64 334 
            L78 338 
        .end linenumbertable 
        .localvariabletable 
            3 is p LECPoint; from L33 to L78 
            0 is this LECPoint; from L0 to L80 
            1 is c LECCurve; from L5 to L80 
            2 is hc I from L21 to L80 
        .end localvariabletable 
    .end code 
.end method 

.method public toString : ()Ljava/lang/String; 
    .code stack 2 locals 6 
L0:     aload_0 
L1:     invokevirtual Method ECPoint isInfinity ()Z 
L4:     ifeq L10 
L7:     ldc 'INF' 
L9:     areturn 

        .stack same 
L10:    new java/lang/StringBuilder 
L13:    dup 
L14:    invokespecial Method java/lang/StringBuilder <init> ()V 
L17:    astore_1 
L18:    aload_1 
L19:    bipush 40 
L21:    invokevirtual Method java/lang/StringBuilder append (C)Ljava/lang/StringBuilder; 
L24:    pop 
L25:    aload_1 
L26:    aload_0 
L27:    invokevirtual Method ECPoint getRawXCoord ()LECFieldElement; 
L30:    invokevirtual Method java/lang/StringBuilder append (Ljava/lang/Object;)Ljava/lang/StringBuilder; 
L33:    pop 
L34:    aload_1 
L35:    bipush 44 
L37:    invokevirtual Method java/lang/StringBuilder append (C)Ljava/lang/StringBuilder; 
L40:    pop 
L41:    aload_1 
L42:    aload_0 
L43:    invokevirtual Method ECPoint getRawYCoord ()LECFieldElement; 
L46:    invokevirtual Method java/lang/StringBuilder append (Ljava/lang/Object;)Ljava/lang/StringBuilder; 
L49:    pop 
L50:    aload_0 
L51:    getfield Field ECPoint zs [LECFieldElement; 
L54:    astore_2 
L55:    aload_2 
L56:    arraylength 
L57:    istore_3 
L58:    iconst_0 
L59:    istore 4 

        .stack full 
            locals Object ECPoint Object java/lang/StringBuilder Object [LECFieldElement; Integer Integer 
            stack 
        .end stack 
L61:    iload 4 
L63:    iload_3 
L64:    if_icmpge L93 
L67:    aload_2 
L68:    iload 4 
L70:    aaload 
L71:    astore 5 
L73:    aload_1 
L74:    bipush 44 
L76:    invokevirtual Method java/lang/StringBuilder append (C)Ljava/lang/StringBuilder; 
L79:    pop 
L80:    aload_1 
L81:    aload 5 
L83:    invokevirtual Method java/lang/StringBuilder append (Ljava/lang/Object;)Ljava/lang/StringBuilder; 
L86:    pop 
L87:    iinc 4 1 
L90:    goto L61 

        .stack chop 3 
L93:    aload_1 
L94:    bipush 41 
L96:    invokevirtual Method java/lang/StringBuilder append (C)Ljava/lang/StringBuilder; 
L99:    pop 
L100:   aload_1 
L101:   invokevirtual Method java/lang/StringBuilder toString ()Ljava/lang/String; 
L104:   areturn 
L105:   
        .linenumbertable 
            L0 343 
            L7 345 
            L10 348 
            L18 349 
            L25 350 
            L34 351 
            L41 352 
            L50 353 
            L73 354 
            L80 355 
            L87 353 
            L93 357 
            L100 358 
        .end linenumbertable 
        .localvariabletable 
            5 is z LECFieldElement; from L73 to L87 
            0 is this LECPoint; from L0 to L105 
            1 is sb Ljava/lang/StringBuilder; from L18 to L105 
        .end localvariabletable 
    .end code 
.end method 

.method public getEncoded : (Z)[B 
    .code stack 5 locals 6 
L0:     aload_0 
L1:     invokevirtual Method ECPoint isInfinity ()Z 
L4:     ifeq L11 
L7:     iconst_1 
L8:     newarray byte 
L10:    areturn 

        .stack same 
L11:    aload_0 
L12:    invokevirtual Method ECPoint normalize ()LECPoint; 
L15:    astore_2 
L16:    aload_2 
L17:    invokevirtual Method ECPoint getXCoord ()LECFieldElement; 
L20:    invokevirtual Method ECFieldElement getEncoded ()[B 
L23:    astore_3 
L24:    iload_1 
L25:    ifeq L66 
L28:    aload_3 
L29:    arraylength 
L30:    iconst_1 
L31:    iadd 
L32:    newarray byte 
L34:    astore 4 
L36:    aload 4 
L38:    iconst_0 
L39:    aload_2 
L40:    invokevirtual Method ECPoint getCompressionYTilde ()Z 
L43:    ifeq L50 
L46:    iconst_3 
L47:    goto L51 

        .stack full 
            locals Object ECPoint Integer Object ECPoint Object [B Object [B 
            stack Object [B Integer 
        .end stack 
L50:    iconst_2 

        .stack full 
            locals Object ECPoint Integer Object ECPoint Object [B Object [B 
            stack Object [B Integer Integer 
        .end stack 
L51:    i2b 
L52:    bastore 
L53:    aload_3 
L54:    iconst_0 
L55:    aload 4 
L57:    iconst_1 
L58:    aload_3 
L59:    arraylength 
L60:    invokestatic Method java/lang/System arraycopy (Ljava/lang/Object;ILjava/lang/Object;II)V 
L63:    aload 4 
L65:    areturn 

        .stack chop 1 
L66:    aload_2 
L67:    invokevirtual Method ECPoint getYCoord ()LECFieldElement; 
L70:    invokevirtual Method ECFieldElement getEncoded ()[B 
L73:    astore 4 
L75:    aload_3 
L76:    arraylength 
L77:    aload 4 
L79:    arraylength 
L80:    iadd 
L81:    iconst_1 
L82:    iadd 
L83:    newarray byte 
L85:    astore 5 
L87:    aload 5 
L89:    iconst_0 
L90:    iconst_4 
L91:    bastore 
L92:    aload_3 
L93:    iconst_0 
L94:    aload 5 
L96:    iconst_1 
L97:    aload_3 
L98:    arraylength 
L99:    invokestatic Method java/lang/System arraycopy (Ljava/lang/Object;ILjava/lang/Object;II)V 
L102:   aload 4 
L104:   iconst_0 
L105:   aload 5 
L107:   aload_3 
L108:   arraylength 
L109:   iconst_1 
L110:   iadd 
L111:   aload 4 
L113:   arraylength 
L114:   invokestatic Method java/lang/System arraycopy (Ljava/lang/Object;ILjava/lang/Object;II)V 
L117:   aload 5 
L119:   areturn 
L120:   
        .linenumbertable 
            L0 365 
            L7 367 
            L11 370 
            L16 372 
            L24 374 
            L28 376 
            L36 377 
            L53 378 
            L63 379 
            L66 382 
            L75 384 
            L87 385 
            L92 386 
            L102 387 
            L117 388 
        .end linenumbertable 
        .localvariabletable 
            4 is PO [B from L36 to L66 
            0 is this LECPoint; from L0 to L120 
            1 is compressed Z from L0 to L120 
            2 is normed LECPoint; from L16 to L120 
            3 is X [B from L24 to L120 
            4 is Y [B from L75 to L120 
            5 is PO [B from L87 to L120 
        .end localvariabletable 
    .end code 
    .exceptions java/lang/CloneNotSupportedException 
.end method 

.method protected abstract getCompressionYTilde : ()Z 
    .exceptions java/lang/CloneNotSupportedException 
.end method 

.method public abstract add : (LECPoint;)LECPoint; 
.end method 

.method public abstract negate : ()LECPoint; 
.end method 

.method public abstract subtract : (LECPoint;)LECPoint; 
    .exceptions java/lang/CloneNotSupportedException 
.end method 

.method public timesPow2 : (I)LECPoint; 
    .code stack 3 locals 3 
L0:     iload_1 
L1:     ifge L14 
L4:     new java/lang/IllegalArgumentException 
L7:     dup 
L8:     ldc "'e' cannot be negative" 
L10:    invokespecial Method java/lang/IllegalArgumentException <init> (Ljava/lang/String;)V 
L13:    athrow 

        .stack same 
L14:    aload_0 
L15:    astore_2 

        .stack append Object ECPoint 
L16:    iinc 1 -1 
L19:    iload_1 
L20:    iflt L31 
L23:    aload_2 
L24:    invokevirtual Method ECPoint twice ()LECPoint; 
L27:    astore_2 
L28:    goto L16 

        .stack same 
L31:    aload_2 
L32:    areturn 
L33:    
        .linenumbertable 
            L0 400 
            L4 402 
            L14 405 
            L16 406 
            L23 408 
            L31 410 
        .end linenumbertable 
        .localvariabletable 
            0 is this LECPoint; from L0 to L33 
            1 is e I from L0 to L33 
            2 is p LECPoint; from L16 to L33 
        .end localvariabletable 
    .end code 
    .exceptions java/lang/CloneNotSupportedException 
.end method 

.method public abstract twice : ()LECPoint; 
.end method 

.method public twicePlus : (LECPoint;)LECPoint; 
    .code stack 2 locals 2 
L0:     aload_0 
L1:     invokevirtual Method ECPoint twice ()LECPoint; 
L4:     aload_1 
L5:     invokevirtual Method ECPoint add (LECPoint;)LECPoint; 
L8:     areturn 
L9:     
        .linenumbertable 
            L0 416 
        .end linenumbertable 
        .localvariabletable 
            0 is this LECPoint; from L0 to L9 
            1 is b LECPoint; from L0 to L9 
        .end localvariabletable 
    .end code 
    .exceptions java/lang/CloneNotSupportedException 
.end method 

.method static <clinit> : ()V 
    .code stack 1 locals 0 
L0:     ldc Class ECPoint 
L2:     invokevirtual Method java/lang/Class desiredAssertionStatus ()Z 
L5:     ifne L12 
L8:     iconst_1 
L9:     goto L13 

        .stack same 
L12:    iconst_0 

        .stack stack_1 Integer 
L13:    putstatic Field ECPoint $assertionsDisabled Z 
L16:    iconst_0 
L17:    anewarray ECFieldElement 
L20:    putstatic Field ECPoint EMPTY_ZS [LECFieldElement; 
L23:    return 
L24:    
        .linenumbertable 
            L0 5 
            L16 7 
        .end linenumbertable 
    .end code 
.end method 
.sourcefile 'ECPoint.java' 
.innerclasses 
    ECPoint$AbstractFp ECPoint AbstractFp public static abstract 
    ECPoint$1 [0] [0] 
.end innerclasses 
.end class 
