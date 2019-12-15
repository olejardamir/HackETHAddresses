.version 52 0 
.class public super abstract ECCurve 
.super java/lang/Object 
.field public static final COORD_AFFINE I = 0 
.field public static final COORD_HOMOGENEOUS I = 1 
.field public static final COORD_JACOBIAN I = 2 
.field public static final COORD_JACOBIAN_CHUDNOVSKY I = 3 
.field public static final COORD_JACOBIAN_MODIFIED I = 4 
.field public static final COORD_LAMBDA_AFFINE I = 5 
.field public static final COORD_LAMBDA_PROJECTIVE I = 6 
.field private field LGenericPolynomialExtensionField; 
.field a LECFieldElement; 
.field b LECFieldElement; 
.field order Ljava/math/BigInteger; 
.field cofactor Ljava/math/BigInteger; 
.field coord I 
.field private multiplier LAbstractECMultiplier; 

.method public <init> : ()V 
    .code stack 2 locals 1 
L0:     aload_0 
L1:     invokespecial Method java/lang/Object <init> ()V 
L4:     aload_0 
L5:     iconst_0 
L6:     putfield Field ECCurve coord I 
L9:     aload_0 
L10:    aconst_null 
L11:    putfield Field ECCurve multiplier LAbstractECMultiplier; 
L14:    return 
L15:    
        .linenumbertable 
            L0 15 
            L4 60 
            L9 61 
            L14 17 
        .end linenumbertable 
        .localvariabletable 
            0 is this LECCurve; from L0 to L15 
        .end localvariabletable 
    .end code 
.end method 

.method <init> : (LGenericPolynomialExtensionField;)V 
    .code stack 2 locals 2 
L0:     aload_0 
L1:     invokespecial Method java/lang/Object <init> ()V 
L4:     aload_0 
L5:     iconst_0 
L6:     putfield Field ECCurve coord I 
L9:     aload_0 
L10:    aconst_null 
L11:    putfield Field ECCurve multiplier LAbstractECMultiplier; 
L14:    aload_0 
L15:    aload_1 
L16:    putfield Field ECCurve field LGenericPolynomialExtensionField; 
L19:    return 
L20:    
        .linenumbertable 
            L0 64 
            L4 60 
            L9 61 
            L14 65 
            L19 66 
        .end linenumbertable 
        .localvariabletable 
            0 is this LECCurve; from L0 to L20 
            1 is field LGenericPolynomialExtensionField; from L0 to L20 
        .end localvariabletable 
    .end code 
.end method 

.method public abstract getFieldSize : ()I 
.end method 

.method public abstract fromBigInteger : (Ljava/math/BigInteger;)LECFieldElement; 
.end method 

.method public synchronized configure : ()LECCurve$Config; 
    .code stack 4 locals 1 
L0:     new ECCurve$Config 
L3:     dup 
L4:     aload_0 
L5:     aload_0 
L6:     getfield Field ECCurve coord I 
L9:     invokespecial Method ECCurve$Config <init> (LECCurve;I)V 
L12:    areturn 
L13:    
        .linenumbertable 
            L0 74 
        .end linenumbertable 
        .localvariabletable 
            0 is this LECCurve; from L0 to L13 
        .end localvariabletable 
    .end code 
.end method 

.method private validatePoint : (Ljava/math/BigInteger;Ljava/math/BigInteger;)LECPoint; 
    .code stack 3 locals 4 
L0:     aload_0 
L1:     aload_1 
L2:     aload_2 
L3:     invokespecial Method ECCurve createPoint (Ljava/math/BigInteger;Ljava/math/BigInteger;)LECPoint; 
L6:     astore_3 
L7:     aload_3 
L8:     invokevirtual Method ECPoint isValid ()Z 
L11:    ifeq L24 
L14:    new java/lang/IllegalArgumentException 
L17:    dup 
L18:    ldc 'Invalid point coordinates' 
L20:    invokespecial Method java/lang/IllegalArgumentException <init> (Ljava/lang/String;)V 
L23:    athrow 

        .stack append Object ECPoint 
L24:    aload_3 
L25:    areturn 
L26:    
        .linenumbertable 
            L0 78 
            L7 79 
            L14 81 
            L24 83 
        .end linenumbertable 
        .localvariabletable 
            0 is this LECCurve; from L0 to L26 
            1 is x Ljava/math/BigInteger; from L0 to L26 
            2 is y Ljava/math/BigInteger; from L0 to L26 
            3 is p LECPoint; from L7 to L26 
        .end localvariabletable 
    .end code 
    .exceptions java/lang/CloneNotSupportedException 
.end method 

.method private createPoint : (Ljava/math/BigInteger;Ljava/math/BigInteger;)LECPoint; 
    .code stack 4 locals 3 
L0:     aload_0 
L1:     aload_1 
L2:     aload_2 
L3:     iconst_0 
L4:     invokevirtual Method ECCurve createPoint (Ljava/math/BigInteger;Ljava/math/BigInteger;Z)LECPoint; 
L7:     areturn 
L8:     
        .linenumbertable 
            L0 89 
        .end linenumbertable 
        .localvariabletable 
            0 is this LECCurve; from L0 to L8 
            1 is x Ljava/math/BigInteger; from L0 to L8 
            2 is y Ljava/math/BigInteger; from L0 to L8 
        .end localvariabletable 
    .end code 
.end method 

.method public createPoint : (Ljava/math/BigInteger;Ljava/math/BigInteger;Z)LECPoint; 
    .code stack 4 locals 4 
L0:     aload_0 
L1:     aload_0 
L2:     aload_1 
L3:     invokevirtual Method ECCurve fromBigInteger (Ljava/math/BigInteger;)LECFieldElement; 
L6:     aload_0 
L7:     aload_2 
L8:     invokevirtual Method ECCurve fromBigInteger (Ljava/math/BigInteger;)LECFieldElement; 
L11:    iload_3 
L12:    invokevirtual Method ECCurve createRawPoint (LECFieldElement;LECFieldElement;Z)LECPoint; 
L15:    areturn 
L16:    
        .linenumbertable 
            L0 95 
        .end linenumbertable 
        .localvariabletable 
            0 is this LECCurve; from L0 to L16 
            1 is x Ljava/math/BigInteger; from L0 to L16 
            2 is y Ljava/math/BigInteger; from L0 to L16 
            3 is withCompression Z from L0 to L16 
        .end localvariabletable 
    .end code 
.end method 

.method protected abstract cloneCurve : ()LECCurve; 
    .exceptions java/lang/Exception 
.end method 

.method protected abstract createRawPoint : (LECFieldElement;LECFieldElement;Z)LECPoint; 
.end method 

.method supportsCoordinateSystem : (I)Z 
    .code stack 1 locals 2 
L0:     iload_1 
L1:     ifne L8 
L4:     iconst_1 
L5:     goto L9 

        .stack same 
L8:     iconst_0 

        .stack stack_1 Integer 
L9:     ireturn 
L10:    
        .linenumbertable 
            L0 104 
        .end linenumbertable 
        .localvariabletable 
            0 is this LECCurve; from L0 to L10 
            1 is coord I from L0 to L10 
        .end localvariabletable 
    .end code 
.end method 

.method public precompute : (LECPoint;Ljava/lang/String;LPreCompCallback;)LPreCompInfo; 
    .code stack 4 locals 7 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial Method ECCurve checkPoint (LECPoint;)V 
L5:     aload_1 
L6:     getfield Field ECPoint preCompTable Ljava/util/Hashtable; 
L9:     astore 4 
L11:    aconst_null 
L12:    aload 4 
L14:    if_acmpne L32 
L17:    aload_1 
L18:    new java/util/Hashtable 
L21:    dup 
L22:    iconst_4 
L23:    invokespecial Method java/util/Hashtable <init> (I)V 
L26:    dup 
L27:    astore 4 
L29:    putfield Field ECPoint preCompTable Ljava/util/Hashtable; 

        .stack append Object java/util/Hashtable 
L32:    aload 4 
L34:    aload_2 
L35:    invokevirtual Method java/util/Hashtable get (Ljava/lang/Object;)Ljava/lang/Object; 
L38:    checkcast PreCompInfo 
L41:    astore 5 
L43:    aload_3 
L44:    aload 5 
L46:    invokeinterface InterfaceMethod PreCompCallback precompute (LPreCompInfo;)LPreCompInfo; 2 
L51:    astore 6 
L53:    aload 6 
L55:    aload 5 
L57:    if_acmpeq L69 
L60:    aload 4 
L62:    aload_2 
L63:    aload 6 
L65:    invokevirtual Method java/util/Hashtable put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 
L68:    pop 

        .stack append Object PreCompInfo Object PreCompInfo 
L69:    aload 6 
L71:    areturn 
L72:    
        .linenumbertable 
            L0 109 
            L5 113 
            L11 114 
            L17 116 
            L32 121 
            L43 122 
            L53 124 
            L60 126 
            L69 129 
        .end linenumbertable 
        .localvariabletable 
            0 is this LECCurve; from L0 to L72 
            1 is point LECPoint; from L0 to L72 
            2 is name Ljava/lang/String; from L0 to L72 
            3 is callback LPreCompCallback; from L0 to L72 
            4 is table Ljava/util/Hashtable; from L11 to L72 
            5 is existing LPreCompInfo; from L43 to L72 
            6 is result LPreCompInfo; from L53 to L72 
        .end localvariabletable 
    .end code 
    .exceptions java/lang/CloneNotSupportedException 
.end method 

.method public importPoint : (LECPoint;)LECPoint; 
    .code stack 4 locals 2 
L0:     aload_0 
L1:     aload_1 
L2:     invokevirtual Method ECPoint getCurve ()LECCurve; 
L5:     if_acmpne L10 
L8:     aload_1 
L9:     areturn 

        .stack same 
L10:    aload_1 
L11:    invokevirtual Method ECPoint isInfinity ()Z 
L14:    ifeq L22 
L17:    aload_0 
L18:    invokevirtual Method ECCurve getInfinity ()LECPoint; 
L21:    areturn 

        .stack same 
L22:    aload_1 
L23:    invokevirtual Method ECPoint normalize ()LECPoint; 
L26:    astore_1 
L27:    aload_0 
L28:    aload_1 
L29:    invokevirtual Method ECPoint getXCoord ()LECFieldElement; 
L32:    invokevirtual Method ECFieldElement toBigInteger ()Ljava/math/BigInteger; 
L35:    aload_1 
L36:    invokevirtual Method ECPoint getYCoord ()LECFieldElement; 
L39:    invokevirtual Method ECFieldElement toBigInteger ()Ljava/math/BigInteger; 
L42:    aload_1 
L43:    getfield Field ECPoint withCompression Z 
L46:    invokevirtual Method ECCurve createPoint (Ljava/math/BigInteger;Ljava/math/BigInteger;Z)LECPoint; 
L49:    areturn 
L50:    
        .linenumbertable 
            L0 134 
            L8 136 
            L10 138 
            L17 140 
            L22 144 
            L27 146 
        .end linenumbertable 
        .localvariabletable 
            0 is this LECCurve; from L0 to L50 
            1 is p LECPoint; from L0 to L50 
        .end localvariabletable 
    .end code 
.end method 

.method public normalizeAll : ([LECPoint;)V 
    .code stack 3 locals 2 
L0:     aload_0 
L1:     aload_1 
L2:     aload_1 
L3:     arraylength 
L4:     invokespecial Method ECCurve normalizeAll ([LECPoint;I)V 
L7:     return 
L8:     
        .linenumbertable 
            L0 151 
            L7 152 
        .end linenumbertable 
        .localvariabletable 
            0 is this LECCurve; from L0 to L8 
            1 is points [LECPoint; from L0 to L8 
        .end localvariabletable 
    .end code 
.end method 

.method private normalizeAll : ([LECPoint;I)V 
    .code stack 5 locals 8 
L0:     aload_0 
L1:     aload_1 
L2:     iload_2 
L3:     invokespecial Method ECCurve checkPoints ([LECPoint;I)V 
L6:     aload_0 
L7:     invokevirtual Method ECCurve getCoordinateSystem ()I 
L10:    lookupswitch 
            0 : L36 
            5 : L36 
            default : L37 


        .stack same 
L36:    return 

        .stack same 
L37:    iload_2 
L38:    anewarray ECFieldElement 
L41:    astore_3 
L42:    iload_2 
L43:    newarray int 
L45:    astore 4 
L47:    iconst_0 
L48:    istore 5 
L50:    iconst_0 
L51:    istore 6 

        .stack full 
            locals Object ECCurve Object [LECPoint; Integer Object [LECFieldElement; Object [I Integer Integer 
            stack 
        .end stack 
L53:    iload 6 
L55:    iload_2 
L56:    if_icmpge L105 
L59:    aload_1 
L60:    iload 6 
L62:    aaload 
L63:    astore 7 
L65:    aconst_null 
L66:    aload 7 
L68:    if_acmpeq L99 
L71:    aload 7 
L73:    invokevirtual Method ECPoint isNormalized ()Z 
L76:    ifeq L99 
L79:    aload_3 
L80:    iload 5 
L82:    aload 7 
L84:    iconst_0 
L85:    invokevirtual Method ECPoint getZCoord (I)LECFieldElement; 
L88:    aastore 
L89:    aload 4 
L91:    iload 5 
L93:    iinc 5 1 
L96:    iload 6 
L98:    iastore 

        .stack same 
L99:    iinc 6 1 
L102:   goto L53 

        .stack chop 1 
L105:   iload 5 
L107:   ifne L111 
L110:   return 

        .stack same 
L111:   aload_3 
L112:   iconst_0 
L113:   iload 5 
L115:   aconst_null 
L116:   invokestatic Method ECAlgorithms montgomeryTrick ([LECFieldElement;IILECFieldElement;)V 
L119:   iconst_0 
L120:   istore 6 

        .stack append Integer 
L122:   iload 6 
L124:   iload 5 
L126:   if_icmpge L157 
L129:   aload 4 
L131:   iload 6 
L133:   iaload 
L134:   istore 7 
L136:   aload_1 
L137:   iload 7 
L139:   aload_1 
L140:   iload 7 
L142:   aaload 
L143:   aload_3 
L144:   iload 6 
L146:   aaload 
L147:   invokevirtual Method ECPoint normalize (LECFieldElement;)LECPoint; 
L150:   aastore 
L151:   iinc 6 1 
L154:   goto L122 

        .stack chop 1 
L157:   return 
L158:   
        .linenumbertable 
            L0 156 
            L6 158 
            L36 163 
            L37 168 
            L42 169 
            L47 170 
            L50 171 
            L59 173 
            L65 174 
            L79 176 
            L89 177 
            L99 171 
            L105 181 
            L110 183 
            L111 186 
            L119 188 
            L129 190 
            L136 191 
            L151 188 
            L157 193 
        .end linenumbertable 
        .localvariabletable 
            7 is p LECPoint; from L65 to L99 
            6 is i I from L53 to L105 
            7 is index I from L136 to L151 
            6 is j I from L122 to L157 
            0 is this LECCurve; from L0 to L158 
            1 is points [LECPoint; from L0 to L158 
            2 is len I from L0 to L158 
            3 is zs [LECFieldElement; from L42 to L158 
            4 is indices [I from L47 to L158 
            5 is count I from L50 to L158 
        .end localvariabletable 
    .end code 
.end method 

.method public abstract getInfinity : ()LECPoint; 
.end method 

.method public getField : ()LGenericPolynomialExtensionField; 
    .code stack 1 locals 1 
L0:     aload_0 
L1:     getfield Field ECCurve field LGenericPolynomialExtensionField; 
L4:     areturn 
L5:     
        .linenumbertable 
            L0 199 
        .end linenumbertable 
        .localvariabletable 
            0 is this LECCurve; from L0 to L5 
        .end localvariabletable 
    .end code 
.end method 

.method public getA : ()LECFieldElement; 
    .code stack 1 locals 1 
L0:     aload_0 
L1:     getfield Field ECCurve a LECFieldElement; 
L4:     areturn 
L5:     
        .linenumbertable 
            L0 204 
        .end linenumbertable 
        .localvariabletable 
            0 is this LECCurve; from L0 to L5 
        .end localvariabletable 
    .end code 
.end method 

.method public getB : ()LECFieldElement; 
    .code stack 1 locals 1 
L0:     aload_0 
L1:     getfield Field ECCurve b LECFieldElement; 
L4:     areturn 
L5:     
        .linenumbertable 
            L0 209 
        .end linenumbertable 
        .localvariabletable 
            0 is this LECCurve; from L0 to L5 
        .end localvariabletable 
    .end code 
.end method 

.method public getOrder : ()Ljava/math/BigInteger; 
    .code stack 1 locals 1 
L0:     aload_0 
L1:     getfield Field ECCurve order Ljava/math/BigInteger; 
L4:     areturn 
L5:     
        .linenumbertable 
            L0 214 
        .end linenumbertable 
        .localvariabletable 
            0 is this LECCurve; from L0 to L5 
        .end localvariabletable 
    .end code 
.end method 

.method public getCofactor : ()Ljava/math/BigInteger; 
    .code stack 1 locals 1 
L0:     aload_0 
L1:     getfield Field ECCurve cofactor Ljava/math/BigInteger; 
L4:     areturn 
L5:     
        .linenumbertable 
            L0 219 
        .end linenumbertable 
        .localvariabletable 
            0 is this LECCurve; from L0 to L5 
        .end localvariabletable 
    .end code 
.end method 

.method public getCoordinateSystem : ()I 
    .code stack 1 locals 1 
L0:     aload_0 
L1:     getfield Field ECCurve coord I 
L4:     ireturn 
L5:     
        .linenumbertable 
            L0 224 
        .end linenumbertable 
        .localvariabletable 
            0 is this LECCurve; from L0 to L5 
        .end localvariabletable 
    .end code 
.end method 

.method protected abstract decompressPoint : (ILjava/math/BigInteger;)LECPoint; 
.end method 

.method public decodePoint : ([B)LECPoint; 
    .code stack 5 locals 7 
L0:     aload_0 
L1:     invokevirtual Method ECCurve getFieldSize ()I 
L4:     bipush 7 
L6:     iadd 
L7:     bipush 8 
L9:     idiv 
L10:    istore_3 
L11:    aload_1 
L12:    iconst_0 
L13:    baload 
L14:    istore 4 
L16:    iload 4 
L18:    tableswitch 0 
            L64 
            L279 
            L88 
            L88 
            L148 
            L279 
            L198 
            L198 
            default : L279 


        .stack append Top Integer Integer 
L64:    aload_1 
L65:    arraylength 
L66:    iconst_1 
L67:    if_icmpeq L80 
L70:    new java/lang/IllegalArgumentException 
L73:    dup 
L74:    ldc 'Incorrect length for infinity encoding' 
L76:    invokespecial Method java/lang/IllegalArgumentException <init> (Ljava/lang/String;)V 
L79:    athrow 

        .stack same 
L80:    aload_0 
L81:    invokevirtual Method ECCurve getInfinity ()LECPoint; 
L84:    astore_2 
L85:    goto L312 

        .stack same 
L88:    aload_1 
L89:    arraylength 
L90:    iload_3 
L91:    iconst_1 
L92:    iadd 
L93:    if_icmpeq L106 
L96:    new java/lang/IllegalArgumentException 
L99:    dup 
L100:   ldc 'Incorrect length for compressed encoding' 
L102:   invokespecial Method java/lang/IllegalArgumentException <init> (Ljava/lang/String;)V 
L105:   athrow 

        .stack same 
L106:   iload 4 
L108:   iconst_1 
L109:   iand 
L110:   istore 5 
L112:   aload_1 
L113:   iconst_1 
L114:   iload_3 
L115:   invokestatic Method BigIntegers fromUnsignedByteArray ([BII)Ljava/math/BigInteger; 
L118:   astore 6 
L120:   aload_0 
L121:   iload 5 
L123:   aload 6 
L125:   invokevirtual Method ECCurve decompressPoint (ILjava/math/BigInteger;)LECPoint; 
L128:   astore_2 
L129:   aload_2 
L130:   iconst_1 
L131:   iconst_1 
L132:   invokevirtual Method ECPoint implIsValid (ZZ)Z 
L135:   ifne L312 
L138:   new java/lang/IllegalArgumentException 
L141:   dup 
L142:   ldc 'Invalid point' 
L144:   invokespecial Method java/lang/IllegalArgumentException <init> (Ljava/lang/String;)V 
L147:   athrow 

        .stack same 
L148:   aload_1 
L149:   arraylength 
L150:   iconst_2 
L151:   iload_3 
L152:   imul 
L153:   iconst_1 
L154:   iadd 
L155:   if_icmpeq L168 
L158:   new java/lang/IllegalArgumentException 
L161:   dup 
L162:   ldc 'Incorrect length for uncompressed encoding' 
L164:   invokespecial Method java/lang/IllegalArgumentException <init> (Ljava/lang/String;)V 
L167:   athrow 

        .stack same 
L168:   aload_1 
L169:   iconst_1 
L170:   iload_3 
L171:   invokestatic Method BigIntegers fromUnsignedByteArray ([BII)Ljava/math/BigInteger; 
L174:   astore 5 
L176:   aload_1 
L177:   iconst_1 
L178:   iload_3 
L179:   iadd 
L180:   iload_3 
L181:   invokestatic Method BigIntegers fromUnsignedByteArray ([BII)Ljava/math/BigInteger; 
L184:   astore 6 
L186:   aload_0 
L187:   aload 5 
L189:   aload 6 
L191:   invokespecial Method ECCurve validatePoint (Ljava/math/BigInteger;Ljava/math/BigInteger;)LECPoint; 
L194:   astore_2 
L195:   goto L312 

        .stack same 
L198:   aload_1 
L199:   arraylength 
L200:   iconst_2 
L201:   iload_3 
L202:   imul 
L203:   iconst_1 
L204:   iadd 
L205:   if_icmpeq L218 
L208:   new java/lang/IllegalArgumentException 
L211:   dup 
L212:   ldc 'Incorrect length for hybrid encoding' 
L214:   invokespecial Method java/lang/IllegalArgumentException <init> (Ljava/lang/String;)V 
L217:   athrow 

        .stack same 
L218:   aload_1 
L219:   iconst_1 
L220:   iload_3 
L221:   invokestatic Method BigIntegers fromUnsignedByteArray ([BII)Ljava/math/BigInteger; 
L224:   astore 5 
L226:   aload_1 
L227:   iconst_1 
L228:   iload_3 
L229:   iadd 
L230:   iload_3 
L231:   invokestatic Method BigIntegers fromUnsignedByteArray ([BII)Ljava/math/BigInteger; 
L234:   astore 6 
L236:   aload 6 
L238:   iconst_0 
L239:   invokevirtual Method java/math/BigInteger testBit (I)Z 
L242:   iload 4 
L244:   bipush 7 
L246:   if_icmpne L253 
L249:   iconst_1 
L250:   goto L254 

        .stack full 
            locals Object ECCurve Object [B Top Integer Integer Object java/math/BigInteger Object java/math/BigInteger 
            stack Integer 
        .end stack 
L253:   iconst_0 

        .stack full 
            locals Object ECCurve Object [B Top Integer Integer Object java/math/BigInteger Object java/math/BigInteger 
            stack Integer Integer 
        .end stack 
L254:   if_icmpeq L267 
L257:   new java/lang/IllegalArgumentException 
L260:   dup 
L261:   ldc 'Inconsistent Y coordinate in hybrid encoding' 
L263:   invokespecial Method java/lang/IllegalArgumentException <init> (Ljava/lang/String;)V 
L266:   athrow 

        .stack same 
L267:   aload_0 
L268:   aload 5 
L270:   aload 6 
L272:   invokespecial Method ECCurve validatePoint (Ljava/math/BigInteger;Ljava/math/BigInteger;)LECPoint; 
L275:   astore_2 
L276:   goto L312 

        .stack chop 2 
L279:   new java/lang/IllegalArgumentException 
L282:   dup 
L283:   new java/lang/StringBuilder 
L286:   dup 
L287:   invokespecial Method java/lang/StringBuilder <init> ()V 
L290:   ldc 'Invalid point encoding 0x' 
L292:   invokevirtual Method java/lang/StringBuilder append (Ljava/lang/String;)Ljava/lang/StringBuilder; 
L295:   iload 4 
L297:   bipush 16 
L299:   invokestatic Method java/lang/Integer toString (II)Ljava/lang/String; 
L302:   invokevirtual Method java/lang/StringBuilder append (Ljava/lang/String;)Ljava/lang/StringBuilder; 
L305:   invokevirtual Method java/lang/StringBuilder toString ()Ljava/lang/String; 
L308:   invokespecial Method java/lang/IllegalArgumentException <init> (Ljava/lang/String;)V 
L311:   athrow 

        .stack full 
            locals Object ECCurve Object [B Object ECPoint Integer Integer 
            stack 
        .end stack 
L312:   iload 4 
L314:   ifeq L334 
L317:   aload_2 
L318:   invokevirtual Method ECPoint isInfinity ()Z 
L321:   ifeq L334 
L324:   new java/lang/IllegalArgumentException 
L327:   dup 
L328:   ldc 'Invalid infinity encoding' 
L330:   invokespecial Method java/lang/IllegalArgumentException <init> (Ljava/lang/String;)V 
L333:   athrow 

        .stack same 
L334:   aload_2 
L335:   areturn 
L336:   
        .linenumbertable 
            L0 232 
            L11 234 
            L16 235 
            L64 239 
            L70 241 
            L80 244 
            L85 245 
            L88 250 
            L96 252 
            L106 255 
            L112 256 
            L120 258 
            L129 259 
            L138 261 
            L148 268 
            L158 270 
            L168 273 
            L176 274 
            L186 276 
            L195 277 
            L198 282 
            L208 284 
            L218 287 
            L226 288 
            L236 290 
            L257 292 
            L267 295 
            L276 296 
            L279 299 
            L312 302 
            L324 304 
            L334 307 
        .end linenumbertable 
        .localvariabletable 
            2 is p LECPoint; from L85 to L88 
            5 is yTilde I from L112 to L148 
            6 is X Ljava/math/BigInteger; from L120 to L148 
            2 is p LECPoint; from L129 to L148 
            5 is X Ljava/math/BigInteger; from L176 to L198 
            6 is Y Ljava/math/BigInteger; from L186 to L198 
            2 is p LECPoint; from L195 to L198 
            5 is X Ljava/math/BigInteger; from L226 to L279 
            6 is Y Ljava/math/BigInteger; from L236 to L279 
            2 is p LECPoint; from L276 to L279 
            0 is this LECCurve; from L0 to L336 
            1 is encoded [B from L0 to L336 
            2 is p LECPoint; from L312 to L336 
            3 is expectedLength I from L11 to L336 
            4 is type B from L16 to L336 
        .end localvariabletable 
    .end code 
    .exceptions java/lang/CloneNotSupportedException 
.end method 

.method public createCacheSafeLookupTable : ([LECPoint;II)LECLookupTable; 
    .code stack 6 locals 15 
L0:     aload_0 
L1:     invokevirtual Method ECCurve getFieldSize ()I 
L4:     bipush 7 
L6:     iadd 
L7:     iconst_3 
L8:     iushr 
L9:     istore 4 
L11:    iload_3 
L12:    iload 4 
L14:    imul 
L15:    iconst_2 
L16:    imul 
L17:    newarray byte 
L19:    astore 5 
L21:    iconst_0 
L22:    istore 6 
L24:    iconst_0 
L25:    istore 7 

        .stack full 
            locals Object ECCurve Object [LECPoint; Integer Integer Integer Object [B Integer Integer 
            stack 
        .end stack 
L27:    iload 7 
L29:    iload_3 
L30:    if_icmpge L171 
L33:    aload_1 
L34:    iload_2 
L35:    iload 7 
L37:    iadd 
L38:    aaload 
L39:    astore 8 
L41:    aload 8 
L43:    invokevirtual Method ECPoint getRawXCoord ()LECFieldElement; 
L46:    invokevirtual Method ECFieldElement toBigInteger ()Ljava/math/BigInteger; 
L49:    invokevirtual Method java/math/BigInteger toByteArray ()[B 
L52:    astore 9 
L54:    aload 8 
L56:    invokevirtual Method ECPoint getRawYCoord ()LECFieldElement; 
L59:    invokevirtual Method ECFieldElement toBigInteger ()Ljava/math/BigInteger; 
L62:    invokevirtual Method java/math/BigInteger toByteArray ()[B 
L65:    astore 10 
L67:    aload 9 
L69:    arraylength 
L70:    iload 4 
L72:    if_icmple L79 
L75:    iconst_1 
L76:    goto L80 

        .stack append Object ECPoint Object [B Object [B 
L79:    iconst_0 

        .stack stack_1 Integer 
L80:    istore 11 
L82:    aload 9 
L84:    arraylength 
L85:    iload 11 
L87:    isub 
L88:    istore 12 
L90:    aload 10 
L92:    arraylength 
L93:    iload 4 
L95:    if_icmple L102 
L98:    iconst_1 
L99:    goto L103 

        .stack append Integer Integer 
L102:   iconst_0 

        .stack stack_1 Integer 
L103:   istore 13 
L105:   aload 10 
L107:   arraylength 
L108:   iload 13 
L110:   isub 
L111:   istore 14 
L113:   aload 9 
L115:   iload 11 
L117:   aload 5 
L119:   iload 6 
L121:   iload 4 
L123:   iadd 
L124:   iload 12 
L126:   isub 
L127:   iload 12 
L129:   invokestatic Method java/lang/System arraycopy (Ljava/lang/Object;ILjava/lang/Object;II)V 
L132:   iload 6 
L134:   iload 4 
L136:   iadd 
L137:   istore 6 
L139:   aload 10 
L141:   iload 13 
L143:   aload 5 
L145:   iload 6 
L147:   iload 4 
L149:   iadd 
L150:   iload 14 
L152:   isub 
L153:   iload 14 
L155:   invokestatic Method java/lang/System arraycopy (Ljava/lang/Object;ILjava/lang/Object;II)V 
L158:   iload 6 
L160:   iload 4 
L162:   iadd 
L163:   istore 6 
L165:   iinc 7 1 
L168:   goto L27 

        .stack full 
            locals Object ECCurve Object [LECPoint; Integer Integer Integer Object [B 
            stack 
        .end stack 
L171:   new ECCurve$1 
L174:   dup 
L175:   aload_0 
L176:   iload_3 
L177:   iload 4 
L179:   aload 5 
L181:   invokespecial Method ECCurve$1 <init> (LECCurve;II[B)V 
L184:   areturn 
L185:   
        .linenumbertable 
            L0 313 
            L11 315 
            L21 317 
            L24 318 
            L33 320 
            L41 321 
            L54 322 
            L67 324 
            L90 325 
            L113 327 
            L139 328 
            L165 318 
            L171 332 
        .end linenumbertable 
        .localvariabletable 
            8 is p LECPoint; from L41 to L165 
            9 is px [B from L54 to L165 
            10 is py [B from L67 to L165 
            11 is pxStart I from L82 to L165 
            12 is pxLen I from L90 to L165 
            13 is pyStart I from L105 to L165 
            14 is pyLen I from L113 to L165 
            7 is i I from L27 to L171 
            6 is pos I from L24 to L171 
            0 is this LECCurve; from L0 to L185 
            1 is points [LECPoint; from L0 to L185 
            2 is off I from L0 to L185 
            3 is len I from L0 to L185 
            4 is FE_BYTES I from L11 to L185 
            5 is table [B from L21 to L185 
        .end localvariabletable 
    .end code 
.end method 

.method private checkPoint : (LECPoint;)V 
    .code stack 3 locals 2 
L0:     aconst_null 
L1:     aload_1 
L2:     if_acmpeq L13 
L5:     aload_0 
L6:     aload_1 
L7:     invokevirtual Method ECPoint getCurve ()LECCurve; 
L10:    if_acmpeq L23 

        .stack same 
L13:    new java/lang/IllegalArgumentException 
L16:    dup 
L17:    ldc "'point' must be non-null and on this curve" 
L19:    invokespecial Method java/lang/IllegalArgumentException <init> (Ljava/lang/String;)V 
L22:    athrow 

        .stack same 
L23:    return 
L24:    
        .linenumbertable 
            L0 364 
            L13 366 
            L23 368 
        .end linenumbertable 
        .localvariabletable 
            0 is this LECCurve; from L0 to L24 
            1 is point LECPoint; from L0 to L24 
        .end localvariabletable 
    .end code 
.end method 

.method private checkPoints : ([LECPoint;I)V 
    .code stack 3 locals 5 
L0:     aload_1 
L1:     ifnonnull L14 
L4:     new java/lang/IllegalArgumentException 
L7:     dup 
L8:     ldc "'points' cannot be null" 
L10:    invokespecial Method java/lang/IllegalArgumentException <init> (Ljava/lang/String;)V 
L13:    athrow 

        .stack same 
L14:    iload_2 
L15:    iflt L26 
L18:    iconst_0 
L19:    aload_1 
L20:    arraylength 
L21:    iload_2 
L22:    isub 
L23:    if_icmple L36 

        .stack same 
L26:    new java/lang/IllegalArgumentException 
L29:    dup 
L30:    ldc "invalid range specified for 'points'" 
L32:    invokespecial Method java/lang/IllegalArgumentException <init> (Ljava/lang/String;)V 
L35:    athrow 

        .stack same 
L36:    iconst_0 
L37:    istore_3 

        .stack append Integer 
L38:    iload_3 
L39:    iload_2 
L40:    if_icmpge L79 
L43:    aload_1 
L44:    iload_3 
L45:    aaload 
L46:    astore 4 
L48:    aconst_null 
L49:    aload 4 
L51:    if_acmpeq L73 
L54:    aload_0 
L55:    aload 4 
L57:    invokevirtual Method ECPoint getCurve ()LECCurve; 
L60:    if_acmpeq L73 
L63:    new java/lang/IllegalArgumentException 
L66:    dup 
L67:    ldc "'points' entries must be null or on this curve" 
L69:    invokespecial Method java/lang/IllegalArgumentException <init> (Ljava/lang/String;)V 
L72:    athrow 

        .stack same 
L73:    iinc 3 1 
L76:    goto L38 

        .stack chop 1 
L79:    return 
L80:    
        .linenumbertable 
            L0 372 
            L4 374 
            L14 376 
            L26 378 
            L36 381 
            L43 383 
            L48 384 
            L63 386 
            L73 381 
            L79 389 
        .end linenumbertable 
        .localvariabletable 
            4 is point LECPoint; from L48 to L73 
            3 is i I from L38 to L79 
            0 is this LECCurve; from L0 to L80 
            1 is points [LECPoint; from L0 to L80 
            2 is len I from L0 to L80 
        .end localvariabletable 
    .end code 
.end method 

.method public equals : (LECCurve;)Z 
    .code stack 2 locals 2 
L0:     aload_0 
L1:     aload_1 
L2:     if_acmpeq L64 
L5:     aconst_null 
L6:     aload_1 
L7:     if_acmpeq L68 
L10:    aload_0 
L11:    invokevirtual Method ECCurve getField ()LGenericPolynomialExtensionField; 
L14:    aload_1 
L15:    invokevirtual Method ECCurve getField ()LGenericPolynomialExtensionField; 
L18:    invokevirtual Method GenericPolynomialExtensionField equals (Ljava/lang/Object;)Z 
L21:    ifeq L68 
L24:    aload_0 
L25:    invokevirtual Method ECCurve getA ()LECFieldElement; 
L28:    invokevirtual Method ECFieldElement toBigInteger ()Ljava/math/BigInteger; 
L31:    aload_1 
L32:    invokevirtual Method ECCurve getA ()LECFieldElement; 
L35:    invokevirtual Method ECFieldElement toBigInteger ()Ljava/math/BigInteger; 
L38:    invokevirtual Method java/math/BigInteger equals (Ljava/lang/Object;)Z 
L41:    ifeq L68 
L44:    aload_0 
L45:    invokevirtual Method ECCurve getB ()LECFieldElement; 
L48:    invokevirtual Method ECFieldElement toBigInteger ()Ljava/math/BigInteger; 
L51:    aload_1 
L52:    invokevirtual Method ECCurve getB ()LECFieldElement; 
L55:    invokevirtual Method ECFieldElement toBigInteger ()Ljava/math/BigInteger; 
L58:    invokevirtual Method java/math/BigInteger equals (Ljava/lang/Object;)Z 
L61:    ifeq L68 

        .stack same_extended 
L64:    iconst_1 
L65:    goto L69 

        .stack same 
L68:    iconst_0 

        .stack stack_1 Integer 
L69:    ireturn 
L70:    
        .linenumbertable 
            L0 393 
            L11 395 
            L25 396 
            L45 397 
            L69 393 
        .end linenumbertable 
        .localvariabletable 
            0 is this LECCurve; from L0 to L70 
            1 is other LECCurve; from L0 to L70 
        .end localvariabletable 
    .end code 
.end method 

.method public equals : (Ljava/lang/Object;)Z 
    .code stack 2 locals 2 
L0:     aload_0 
L1:     aload_1 
L2:     if_acmpeq L23 
L5:     aload_1 
L6:     instanceof ECCurve 
L9:     ifeq L27 
L12:    aload_0 
L13:    aload_1 
L14:    checkcast ECCurve 
L17:    invokevirtual Method ECCurve equals (LECCurve;)Z 
L20:    ifeq L27 

        .stack same 
L23:    iconst_1 
L24:    goto L28 

        .stack same 
L27:    iconst_0 

        .stack stack_1 Integer 
L28:    ireturn 
L29:    
        .linenumbertable 
            L0 402 
        .end linenumbertable 
        .localvariabletable 
            0 is this LECCurve; from L0 to L29 
            1 is obj Ljava/lang/Object; from L0 to L29 
        .end localvariabletable 
    .end code 
.end method 

.method public hashCode : ()I 
    .code stack 3 locals 1 
L0:     aload_0 
L1:     invokevirtual Method ECCurve getField ()LGenericPolynomialExtensionField; 
L4:     invokevirtual Method GenericPolynomialExtensionField hashCode ()I 
L7:     aload_0 
L8:     invokevirtual Method ECCurve getA ()LECFieldElement; 
L11:    invokevirtual Method ECFieldElement toBigInteger ()Ljava/math/BigInteger; 
L14:    invokevirtual Method java/math/BigInteger hashCode ()I 
L17:    bipush 8 
L19:    invokestatic Method Integers rotateLeft (II)I 
L22:    ixor 
L23:    aload_0 
L24:    invokevirtual Method ECCurve getB ()LECFieldElement; 
L27:    invokevirtual Method ECFieldElement toBigInteger ()Ljava/math/BigInteger; 
L30:    invokevirtual Method java/math/BigInteger hashCode ()I 
L33:    bipush 16 
L35:    invokestatic Method Integers rotateLeft (II)I 
L38:    ixor 
L39:    ireturn 
L40:    
        .linenumbertable 
            L0 407 
            L8 408 
            L24 409 
            L39 407 
        .end linenumbertable 
        .localvariabletable 
            0 is this LECCurve; from L0 to L40 
        .end localvariabletable 
    .end code 
.end method 

.method static synthetic access$002 : (LECCurve;LAbstractECMultiplier;)LAbstractECMultiplier; 
    .code stack 3 locals 2 
L0:     aload_0 
L1:     aload_1 
L2:     dup_x1 
L3:     putfield Field ECCurve multiplier LAbstractECMultiplier; 
L6:     areturn 
L7:     
        .linenumbertable 
            L0 5 
        .end linenumbertable 
        .localvariabletable 
            0 is x0 LECCurve; from L0 to L7 
            1 is x1 LAbstractECMultiplier; from L0 to L7 
        .end localvariabletable 
    .end code 
.end method 

.method static synthetic access$000 : (LECCurve;)LAbstractECMultiplier; 
    .code stack 1 locals 1 
L0:     aload_0 
L1:     getfield Field ECCurve multiplier LAbstractECMultiplier; 
L4:     areturn 
L5:     
        .linenumbertable 
            L0 5 
        .end linenumbertable 
        .localvariabletable 
            0 is x0 LECCurve; from L0 to L5 
        .end localvariabletable 
    .end code 
.end method 
.sourcefile 'ECCurve.java' 
.innerclasses 
    ECCurve$AbstractFp ECCurve AbstractFp protected static abstract 
    ECCurve$Config ECCurve Config public 
    ECCurve$1 [0] [0] 
.end innerclasses 
.end class 
