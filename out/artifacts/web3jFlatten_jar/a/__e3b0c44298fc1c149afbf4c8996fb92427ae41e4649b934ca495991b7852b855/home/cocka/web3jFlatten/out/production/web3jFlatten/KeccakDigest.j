.version 52 0 
.class public super KeccakDigest 
.super java/lang/Object 
.implements ExtendedDigest 
.field private static final KeccakRoundConstants [J 
.field private final state [J 
.field private final dataQueue [B 
.field private rate I 
.field private bitsInQueue I 
.field private fixedOutputLength I 
.field private squeezing Z 

.method public <init> : (I)V 
    .code stack 2 locals 2 
L0:     aload_0 
L1:     invokespecial Method java/lang/Object <init> ()V 
L4:     aload_0 
L5:     bipush 25 
L7:     newarray long 
L9:     putfield Field KeccakDigest state [J 
L12:    aload_0 
L13:    sipush 192 
L16:    newarray byte 
L18:    putfield Field KeccakDigest dataQueue [B 
L21:    aload_0 
L22:    iload_1 
L23:    invokespecial Method KeccakDigest init (I)V 
L26:    return 
L27:    
        .linenumbertable 
            L0 20 
            L4 12 
            L12 13 
            L21 21 
            L26 22 
        .end linenumbertable 
        .localvariabletable 
            0 is this LKeccakDigest; from L0 to L27 
            1 is bitLength I from L0 to L27 
        .end localvariabletable 
    .end code 
.end method 

.method public <init> : (LKeccakDigest;)V 
    .code stack 5 locals 2 
L0:     aload_0 
L1:     invokespecial Method java/lang/Object <init> ()V 
L4:     aload_0 
L5:     bipush 25 
L7:     newarray long 
L9:     putfield Field KeccakDigest state [J 
L12:    aload_0 
L13:    sipush 192 
L16:    newarray byte 
L18:    putfield Field KeccakDigest dataQueue [B 
L21:    aload_1 
L22:    getfield Field KeccakDigest state [J 
L25:    iconst_0 
L26:    aload_0 
L27:    getfield Field KeccakDigest state [J 
L30:    iconst_0 
L31:    aload_1 
L32:    getfield Field KeccakDigest state [J 
L35:    arraylength 
L36:    invokestatic Method java/lang/System arraycopy (Ljava/lang/Object;ILjava/lang/Object;II)V 
L39:    aload_1 
L40:    getfield Field KeccakDigest dataQueue [B 
L43:    iconst_0 
L44:    aload_0 
L45:    getfield Field KeccakDigest dataQueue [B 
L48:    iconst_0 
L49:    aload_1 
L50:    getfield Field KeccakDigest dataQueue [B 
L53:    arraylength 
L54:    invokestatic Method java/lang/System arraycopy (Ljava/lang/Object;ILjava/lang/Object;II)V 
L57:    aload_0 
L58:    aload_1 
L59:    getfield Field KeccakDigest rate I 
L62:    putfield Field KeccakDigest rate I 
L65:    aload_0 
L66:    aload_1 
L67:    getfield Field KeccakDigest bitsInQueue I 
L70:    putfield Field KeccakDigest bitsInQueue I 
L73:    aload_0 
L74:    aload_1 
L75:    getfield Field KeccakDigest fixedOutputLength I 
L78:    putfield Field KeccakDigest fixedOutputLength I 
L81:    aload_0 
L82:    aload_1 
L83:    getfield Field KeccakDigest squeezing Z 
L86:    putfield Field KeccakDigest squeezing Z 
L89:    return 
L90:    
        .linenumbertable 
            L0 25 
            L4 12 
            L12 13 
            L21 26 
            L39 27 
            L57 28 
            L65 29 
            L73 30 
            L81 31 
            L89 32 
        .end linenumbertable 
        .localvariabletable 
            0 is this LKeccakDigest; from L0 to L90 
            1 is source LKeccakDigest; from L0 to L90 
        .end localvariabletable 
    .end code 
.end method 

.method public getAlgorithmName : ()Ljava/lang/String; 
    .code stack 2 locals 1 
L0:     new java/lang/StringBuilder 
L3:     dup 
L4:     invokespecial Method java/lang/StringBuilder <init> ()V 
L7:     ldc 'Keccak-' 
L9:     invokevirtual Method java/lang/StringBuilder append (Ljava/lang/String;)Ljava/lang/StringBuilder; 
L12:    aload_0 
L13:    getfield Field KeccakDigest fixedOutputLength I 
L16:    invokevirtual Method java/lang/StringBuilder append (I)Ljava/lang/StringBuilder; 
L19:    invokevirtual Method java/lang/StringBuilder toString ()Ljava/lang/String; 
L22:    areturn 
L23:    
        .linenumbertable 
            L0 36 
        .end linenumbertable 
        .localvariabletable 
            0 is this LKeccakDigest; from L0 to L23 
        .end localvariabletable 
    .end code 
.end method 

.method public getDigestSize : ()I 
    .code stack 2 locals 1 
L0:     aload_0 
L1:     getfield Field KeccakDigest fixedOutputLength I 
L4:     bipush 8 
L6:     idiv 
L7:     ireturn 
L8:     
        .linenumbertable 
            L0 41 
        .end linenumbertable 
        .localvariabletable 
            0 is this LKeccakDigest; from L0 to L8 
        .end localvariabletable 
    .end code 
.end method 

.method public update : (B)V 
    .code stack 5 locals 2 
L0:     aload_0 
L1:     iconst_1 
L2:     newarray byte 
L4:     dup 
L5:     iconst_0 
L6:     iload_1 
L7:     bastore 
L8:     iconst_0 
L9:     iconst_1 
L10:    invokespecial Method KeccakDigest absorb ([BII)V 
L13:    return 
L14:    
        .linenumbertable 
            L0 46 
            L13 47 
        .end linenumbertable 
        .localvariabletable 
            0 is this LKeccakDigest; from L0 to L14 
            1 is in B from L0 to L14 
        .end localvariabletable 
    .end code 
.end method 

.method public update : ([BII)V 
    .code stack 4 locals 4 
L0:     aload_0 
L1:     aload_1 
L2:     iload_2 
L3:     iload_3 
L4:     invokespecial Method KeccakDigest absorb ([BII)V 
L7:     return 
L8:     
        .linenumbertable 
            L0 51 
            L7 52 
        .end linenumbertable 
        .localvariabletable 
            0 is this LKeccakDigest; from L0 to L8 
            1 is in [B from L0 to L8 
            2 is inOff I from L0 to L8 
            3 is len I from L0 to L8 
        .end localvariabletable 
    .end code 
.end method 

.method public doFinal : ([BI)V 
    .code stack 5 locals 3 
L0:     aload_0 
L1:     aload_1 
L2:     iload_2 
L3:     aload_0 
L4:     getfield Field KeccakDigest fixedOutputLength I 
L7:     i2l 
L8:     invokespecial Method KeccakDigest squeeze ([BIJ)V 
L11:    aload_0 
L12:    invokevirtual Method KeccakDigest reset ()V 
L15:    aload_0 
L16:    invokevirtual Method KeccakDigest getDigestSize ()I 
L19:    pop 
L20:    return 
L21:    
        .linenumbertable 
            L0 56 
            L11 58 
            L15 60 
            L20 61 
        .end linenumbertable 
        .localvariabletable 
            0 is this LKeccakDigest; from L0 to L21 
            1 is out [B from L0 to L21 
            2 is outOff I from L0 to L21 
        .end localvariabletable 
    .end code 
.end method 

.method public reset : ()V 
    .code stack 2 locals 1 
L0:     aload_0 
L1:     aload_0 
L2:     getfield Field KeccakDigest fixedOutputLength I 
L5:     invokespecial Method KeccakDigest init (I)V 
L8:     return 
L9:     
        .linenumbertable 
            L0 65 
            L8 66 
        .end linenumbertable 
        .localvariabletable 
            0 is this LKeccakDigest; from L0 to L9 
        .end localvariabletable 
    .end code 
.end method 

.method private init : (I)V 
    .code stack 4 locals 2 
L0:     iload_1 
L1:     lookupswitch 
            128 : L60 
            224 : L60 
            256 : L60 
            288 : L60 
            384 : L60 
            512 : L60 
            default : L74 


        .stack same 
L60:    aload_0 
L61:    sipush 1600 
L64:    iload_1 
L65:    iconst_1 
L66:    ishl 
L67:    isub 
L68:    invokespecial Method KeccakDigest initSponge (I)V 
L71:    goto L84 

        .stack same 
L74:    new java/lang/IllegalArgumentException 
L77:    dup 
L78:    ldc 'bitLength must be one of 128, 224, 256, 288, 384, or 512.' 
L80:    invokespecial Method java/lang/IllegalArgumentException <init> (Ljava/lang/String;)V 
L83:    athrow 

        .stack same 
L84:    return 
L85:    
        .linenumbertable 
            L0 70 
            L60 78 
            L71 79 
            L74 81 
            L84 83 
        .end linenumbertable 
        .localvariabletable 
            0 is this LKeccakDigest; from L0 to L85 
            1 is bitLength I from L0 to L85 
        .end localvariabletable 
    .end code 
.end method 

.method private initSponge : (I)V 
    .code stack 4 locals 3 
L0:     iload_1 
L1:     ifle L18 
L4:     iload_1 
L5:     sipush 1600 
L8:     if_icmpge L18 
L11:    iload_1 
L12:    bipush 64 
L14:    irem 
L15:    ifeq L28 

        .stack same 
L18:    new java/lang/IllegalStateException 
L21:    dup 
L22:    ldc 'invalid rate value' 
L24:    invokespecial Method java/lang/IllegalStateException <init> (Ljava/lang/String;)V 
L27:    athrow 

        .stack same 
L28:    aload_0 
L29:    iload_1 
L30:    putfield Field KeccakDigest rate I 
L33:    iconst_0 
L34:    istore_2 

        .stack append Integer 
L35:    iload_2 
L36:    aload_0 
L37:    getfield Field KeccakDigest state [J 
L40:    arraylength 
L41:    if_icmpge L57 
L44:    aload_0 
L45:    getfield Field KeccakDigest state [J 
L48:    iload_2 
L49:    lconst_0 
L50:    lastore 
L51:    iinc 2 1 
L54:    goto L35 

        .stack chop 1 
L57:    aload_0 
L58:    getfield Field KeccakDigest dataQueue [B 
L61:    iconst_0 
L62:    invokestatic Method Arrays fill ([BB)V 
L65:    aload_0 
L66:    iconst_0 
L67:    putfield Field KeccakDigest bitsInQueue I 
L70:    aload_0 
L71:    iconst_0 
L72:    putfield Field KeccakDigest squeezing Z 
L75:    aload_0 
L76:    sipush 1600 
L79:    iload_1 
L80:    isub 
L81:    iconst_2 
L82:    idiv 
L83:    putfield Field KeccakDigest fixedOutputLength I 
L86:    return 
L87:    
        .linenumbertable 
            L0 87 
            L18 89 
            L28 92 
            L33 93 
            L44 95 
            L51 93 
            L57 97 
            L65 98 
            L70 99 
            L75 100 
            L86 101 
        .end linenumbertable 
        .localvariabletable 
            2 is i I from L35 to L57 
            0 is this LKeccakDigest; from L0 to L87 
            1 is rate I from L0 to L87 
        .end localvariabletable 
    .end code 
.end method 

.method private absorb : ([BII)V 
    .code stack 5 locals 8 
L0:     aload_0 
L1:     getfield Field KeccakDigest bitsInQueue I 
L4:     bipush 8 
L6:     irem 
L7:     ifeq L20 
L10:    new java/lang/IllegalStateException 
L13:    dup 
L14:    ldc 'attempt to absorb with odd length queue' 
L16:    invokespecial Method java/lang/IllegalStateException <init> (Ljava/lang/String;)V 
L19:    athrow 

        .stack same 
L20:    aload_0 
L21:    getfield Field KeccakDigest squeezing Z 
L24:    ifeq L37 
L27:    new java/lang/IllegalStateException 
L30:    dup 
L31:    ldc 'attempt to absorb while squeezing' 
L33:    invokespecial Method java/lang/IllegalStateException <init> (Ljava/lang/String;)V 
L36:    athrow 

        .stack same 
L37:    aload_0 
L38:    getfield Field KeccakDigest bitsInQueue I 
L41:    iconst_3 
L42:    ishr 
L43:    istore 4 
L45:    aload_0 
L46:    getfield Field KeccakDigest rate I 
L49:    iconst_3 
L50:    ishr 
L51:    istore 5 
L53:    iconst_0 
L54:    istore 6 

        .stack append Integer Integer Integer 
L56:    iload 6 
L58:    iload_3 
L59:    if_icmpge L170 
L62:    iload 4 
L64:    ifne L104 
L67:    iload 6 
L69:    iload_3 
L70:    iload 5 
L72:    isub 
L73:    if_icmpgt L104 

        .stack same 
L76:    aload_0 
L77:    aload_1 
L78:    iload_2 
L79:    iload 6 
L81:    iadd 
L82:    invokespecial Method KeccakDigest KeccakAbsorb ([BI)V 
L85:    iload 6 
L87:    iload 5 
L89:    iadd 
L90:    istore 6 
L92:    iload 6 
L94:    iload_3 
L95:    iload 5 
L97:    isub 
L98:    if_icmple L76 
L101:   goto L56 

        .stack same 
L104:   iload 5 
L106:   iload 4 
L108:   isub 
L109:   iload_3 
L110:   iload 6 
L112:   isub 
L113:   invokestatic Method java/lang/Math min (II)I 
L116:   istore 7 
L118:   aload_1 
L119:   iload_2 
L120:   iload 6 
L122:   iadd 
L123:   aload_0 
L124:   getfield Field KeccakDigest dataQueue [B 
L127:   iload 4 
L129:   iload 7 
L131:   invokestatic Method java/lang/System arraycopy (Ljava/lang/Object;ILjava/lang/Object;II)V 
L134:   iload 4 
L136:   iload 7 
L138:   iadd 
L139:   istore 4 
L141:   iload 6 
L143:   iload 7 
L145:   iadd 
L146:   istore 6 
L148:   iload 4 
L150:   iload 5 
L152:   if_icmpne L167 
L155:   aload_0 
L156:   aload_0 
L157:   getfield Field KeccakDigest dataQueue [B 
L160:   iconst_0 
L161:   invokespecial Method KeccakDigest KeccakAbsorb ([BI)V 
L164:   iconst_0 
L165:   istore 4 

        .stack same 
L167:   goto L56 

        .stack same 
L170:   aload_0 
L171:   iload 4 
L173:   iconst_3 
L174:   ishl 
L175:   putfield Field KeccakDigest bitsInQueue I 
L178:   return 
L179:   
        .linenumbertable 
            L0 105 
            L10 107 
            L20 109 
            L27 111 
            L37 114 
            L45 115 
            L53 117 
            L56 118 
            L62 120 
            L76 124 
            L85 125 
            L92 127 
            L104 131 
            L118 132 
            L134 134 
            L141 135 
            L148 137 
            L155 139 
            L164 140 
            L167 142 
            L170 145 
            L178 146 
        .end linenumbertable 
        .localvariabletable 
            7 is partialBlock I from L118 to L167 
            0 is this LKeccakDigest; from L0 to L179 
            1 is data [B from L0 to L179 
            2 is off I from L0 to L179 
            3 is len I from L0 to L179 
            4 is bytesInQueue I from L45 to L179 
            5 is rateBytes I from L53 to L179 
            6 is count I from L56 to L179 
        .end localvariabletable 
    .end code 
.end method 

.method private padAndSwitchToSqueezingPhase : ()V 
    .code stack 8 locals 6 
L0:     aload_0 
L1:     getfield Field KeccakDigest dataQueue [B 
L4:     aload_0 
L5:     getfield Field KeccakDigest bitsInQueue I 
L8:     iconst_3 
L9:     ishr 
L10:    dup2 
L11:    baload 
L12:    lconst_1 
L13:    aload_0 
L14:    getfield Field KeccakDigest bitsInQueue I 
L17:    bipush 7 
L19:    iand 
L20:    lshl 
L21:    l2i 
L22:    i2b 
L23:    ior 
L24:    i2b 
L25:    bastore 
L26:    aload_0 
L27:    dup 
L28:    getfield Field KeccakDigest bitsInQueue I 
L31:    iconst_1 
L32:    iadd 
L33:    dup_x1 
L34:    putfield Field KeccakDigest bitsInQueue I 
L37:    aload_0 
L38:    getfield Field KeccakDigest rate I 
L41:    if_icmpne L58 
L44:    aload_0 
L45:    aload_0 
L46:    getfield Field KeccakDigest dataQueue [B 
L49:    iconst_0 
L50:    invokespecial Method KeccakDigest KeccakAbsorb ([BI)V 
L53:    aload_0 
L54:    iconst_0 
L55:    putfield Field KeccakDigest bitsInQueue I 

        .stack same 
L58:    aload_0 
L59:    getfield Field KeccakDigest bitsInQueue I 
L62:    bipush 6 
L64:    ishr 
L65:    istore_1 
L66:    aload_0 
L67:    getfield Field KeccakDigest bitsInQueue I 
L70:    bipush 63 
L72:    iand 
L73:    istore_2 
L74:    iconst_0 
L75:    istore_3 
L76:    iconst_0 
L77:    istore 4 

        .stack full 
            locals Object KeccakDigest Integer Integer Integer Integer 
            stack 
        .end stack 
L79:    iload 4 
L81:    iload_1 
L82:    if_icmpge L112 
L85:    aload_0 
L86:    getfield Field KeccakDigest state [J 
L89:    iload 4 
L91:    dup2 
L92:    laload 
L93:    aload_0 
L94:    getfield Field KeccakDigest dataQueue [B 
L97:    iload_3 
L98:    invokestatic Method Pack littleEndianToLong ([BI)J 
L101:   lxor 
L102:   lastore 
L103:   iinc 3 8 
L106:   iinc 4 1 
L109:   goto L79 

        .stack chop 1 
L112:   iload_2 
L113:   ifle L143 
L116:   lconst_1 
L117:   iload_2 
L118:   lshl 
L119:   lconst_1 
L120:   lsub 
L121:   lstore 4 
L123:   aload_0 
L124:   getfield Field KeccakDigest state [J 
L127:   iload_1 
L128:   dup2 
L129:   laload 
L130:   aload_0 
L131:   getfield Field KeccakDigest dataQueue [B 
L134:   iload_3 
L135:   invokestatic Method Pack littleEndianToLong ([BI)J 
L138:   lload 4 
L140:   land 
L141:   lxor 
L142:   lastore 

        .stack same 
L143:   aload_0 
L144:   getfield Field KeccakDigest state [J 
L147:   aload_0 
L148:   getfield Field KeccakDigest rate I 
L151:   iconst_1 
L152:   isub 
L153:   bipush 6 
L155:   ishr 
L156:   dup2 
L157:   laload 
L158:   ldc2_w -9223372036854775808L 
L161:   lxor 
L162:   lastore 
L163:   aload_0 
L164:   invokespecial Method KeccakDigest KeccakPermutation ()V 
L167:   aload_0 
L168:   invokespecial Method KeccakDigest KeccakExtract ()V 
L171:   aload_0 
L172:   aload_0 
L173:   getfield Field KeccakDigest rate I 
L176:   putfield Field KeccakDigest bitsInQueue I 
L179:   aload_0 
L180:   iconst_1 
L181:   putfield Field KeccakDigest squeezing Z 
L184:   return 
L185:   
        .linenumbertable 
            L0 150 
            L26 152 
            L44 154 
            L53 155 
            L58 159 
            L74 160 
            L76 161 
            L85 163 
            L103 164 
            L106 161 
            L112 166 
            L116 168 
            L123 169 
            L143 171 
            L163 174 
            L167 176 
            L171 177 
            L179 179 
            L184 180 
        .end linenumbertable 
        .localvariabletable 
            4 is i I from L79 to L112 
            4 is mask J from L123 to L143 
            1 is full I from L66 to L163 
            2 is partial I from L74 to L163 
            3 is off I from L76 to L163 
            0 is this LKeccakDigest; from L0 to L185 
        .end localvariabletable 
    .end code 
.end method 

.method private squeeze : ([BIJ)V 
    .code stack 8 locals 8 
L0:     aload_0 
L1:     getfield Field KeccakDigest squeezing Z 
L4:     ifne L11 
L7:     aload_0 
L8:     invokespecial Method KeccakDigest padAndSwitchToSqueezingPhase ()V 

        .stack same 
L11:    lload_3 
L12:    ldc2_w 8L 
L15:    lrem 
L16:    lconst_0 
L17:    lcmp 
L18:    ifeq L31 
L21:    new java/lang/IllegalStateException 
L24:    dup 
L25:    ldc 'outputLength not a multiple of 8' 
L27:    invokespecial Method java/lang/IllegalStateException <init> (Ljava/lang/String;)V 
L30:    athrow 

        .stack same 
L31:    lconst_0 
L32:    lstore 5 

        .stack append Long 
L34:    lload 5 
L36:    lload_3 
L37:    lcmp 
L38:    ifge L135 
L41:    aload_0 
L42:    getfield Field KeccakDigest bitsInQueue I 
L45:    ifne L64 
L48:    aload_0 
L49:    invokespecial Method KeccakDigest KeccakPermutation ()V 
L52:    aload_0 
L53:    invokespecial Method KeccakDigest KeccakExtract ()V 
L56:    aload_0 
L57:    aload_0 
L58:    getfield Field KeccakDigest rate I 
L61:    putfield Field KeccakDigest bitsInQueue I 

        .stack same 
L64:    aload_0 
L65:    getfield Field KeccakDigest bitsInQueue I 
L68:    i2l 
L69:    lload_3 
L70:    lload 5 
L72:    lsub 
L73:    invokestatic Method java/lang/Math min (JJ)J 
L76:    l2i 
L77:    istore 7 
L79:    aload_0 
L80:    getfield Field KeccakDigest dataQueue [B 
L83:    aload_0 
L84:    getfield Field KeccakDigest rate I 
L87:    aload_0 
L88:    getfield Field KeccakDigest bitsInQueue I 
L91:    isub 
L92:    bipush 8 
L94:    idiv 
L95:    aload_1 
L96:    iload_2 
L97:    lload 5 
L99:    ldc2_w 8L 
L102:   ldiv 
L103:   l2i 
L104:   iadd 
L105:   iload 7 
L107:   bipush 8 
L109:   idiv 
L110:   invokestatic Method java/lang/System arraycopy (Ljava/lang/Object;ILjava/lang/Object;II)V 
L113:   aload_0 
L114:   dup 
L115:   getfield Field KeccakDigest bitsInQueue I 
L118:   iload 7 
L120:   isub 
L121:   putfield Field KeccakDigest bitsInQueue I 
L124:   lload 5 
L126:   iload 7 
L128:   i2l 
L129:   ladd 
L130:   lstore 5 
L132:   goto L34 

        .stack same_extended 
L135:   return 
L136:   
        .linenumbertable 
            L0 184 
            L7 186 
            L11 188 
            L21 190 
            L31 193 
            L34 194 
            L41 196 
            L48 198 
            L52 199 
            L56 200 
            L64 202 
            L79 203 
            L113 204 
            L124 205 
            L132 206 
            L135 207 
        .end linenumbertable 
        .localvariabletable 
            7 is partialBlock I from L79 to L132 
            0 is this LKeccakDigest; from L0 to L136 
            1 is output [B from L0 to L136 
            2 is offset I from L0 to L136 
            3 is outputLength J from L0 to L136 
            5 is i J from L34 to L136 
        .end localvariabletable 
    .end code 
.end method 

.method private KeccakAbsorb : ([BI)V 
    .code stack 6 locals 5 
L0:     aload_0 
L1:     getfield Field KeccakDigest rate I 
L4:     bipush 6 
L6:     ishr 
L7:     istore_3 
L8:     iconst_0 
L9:     istore 4 

        .stack append Integer Integer 
L11:    iload 4 
L13:    iload_3 
L14:    if_icmpge L41 
L17:    aload_0 
L18:    getfield Field KeccakDigest state [J 
L21:    iload 4 
L23:    dup2 
L24:    laload 
L25:    aload_1 
L26:    iload_2 
L27:    invokestatic Method Pack littleEndianToLong ([BI)J 
L30:    lxor 
L31:    lastore 
L32:    iinc 2 8 
L35:    iinc 4 1 
L38:    goto L11 

        .stack chop 1 
L41:    aload_0 
L42:    invokespecial Method KeccakDigest KeccakPermutation ()V 
L45:    return 
L46:    
        .linenumbertable 
            L0 211 
            L8 212 
            L17 214 
            L32 215 
            L35 212 
            L41 218 
            L45 219 
        .end linenumbertable 
        .localvariabletable 
            4 is i I from L11 to L41 
            0 is this LKeccakDigest; from L0 to L46 
            1 is data [B from L0 to L46 
            2 is off I from L0 to L46 
            3 is count I from L8 to L46 
        .end localvariabletable 
    .end code 
.end method 

.method private KeccakExtract : ()V 
    .code stack 5 locals 1 
L0:     aload_0 
L1:     getfield Field KeccakDigest state [J 
L4:     iconst_0 
L5:     aload_0 
L6:     getfield Field KeccakDigest rate I 
L9:     bipush 6 
L11:    ishr 
L12:    aload_0 
L13:    getfield Field KeccakDigest dataQueue [B 
L16:    iconst_0 
L17:    invokestatic Method Pack longToLittleEndian ([JII[BI)V 
L20:    return 
L21:    
        .linenumbertable 
            L0 223 
            L20 224 
        .end linenumbertable 
        .localvariabletable 
            0 is this LKeccakDigest; from L0 to L21 
        .end localvariabletable 
    .end code 
.end method 

.method private KeccakPermutation : ()V 
    .code stack 6 locals 73 
L0:     aload_0 
L1:     getfield Field KeccakDigest state [J 
L4:     astore_1 
L5:     aload_1 
L6:     iconst_0 
L7:     laload 
L8:     lstore_2 
L9:     aload_1 
L10:    iconst_1 
L11:    laload 
L12:    lstore 4 
L14:    aload_1 
L15:    iconst_2 
L16:    laload 
L17:    lstore 6 
L19:    aload_1 
L20:    iconst_3 
L21:    laload 
L22:    lstore 8 
L24:    aload_1 
L25:    iconst_4 
L26:    laload 
L27:    lstore 10 
L29:    aload_1 
L30:    iconst_5 
L31:    laload 
L32:    lstore 12 
L34:    aload_1 
L35:    bipush 6 
L37:    laload 
L38:    lstore 14 
L40:    aload_1 
L41:    bipush 7 
L43:    laload 
L44:    lstore 16 
L46:    aload_1 
L47:    bipush 8 
L49:    laload 
L50:    lstore 18 
L52:    aload_1 
L53:    bipush 9 
L55:    laload 
L56:    lstore 20 
L58:    aload_1 
L59:    bipush 10 
L61:    laload 
L62:    lstore 22 
L64:    aload_1 
L65:    bipush 11 
L67:    laload 
L68:    lstore 24 
L70:    aload_1 
L71:    bipush 12 
L73:    laload 
L74:    lstore 26 
L76:    aload_1 
L77:    bipush 13 
L79:    laload 
L80:    lstore 28 
L82:    aload_1 
L83:    bipush 14 
L85:    laload 
L86:    lstore 30 
L88:    aload_1 
L89:    bipush 15 
L91:    laload 
L92:    lstore 32 
L94:    aload_1 
L95:    bipush 16 
L97:    laload 
L98:    lstore 34 
L100:   aload_1 
L101:   bipush 17 
L103:   laload 
L104:   lstore 36 
L106:   aload_1 
L107:   bipush 18 
L109:   laload 
L110:   lstore 38 
L112:   aload_1 
L113:   bipush 19 
L115:   laload 
L116:   lstore 40 
L118:   aload_1 
L119:   bipush 20 
L121:   laload 
L122:   lstore 42 
L124:   aload_1 
L125:   bipush 21 
L127:   laload 
L128:   lstore 44 
L130:   aload_1 
L131:   bipush 22 
L133:   laload 
L134:   lstore 46 
L136:   aload_1 
L137:   bipush 23 
L139:   laload 
L140:   lstore 48 
L142:   aload_1 
L143:   bipush 24 
L145:   laload 
L146:   lstore 50 
L148:   iconst_0 
L149:   istore 52 

        .stack full 
            locals Object KeccakDigest Object [J Long Long Long Long Long Long Long Long Long Long Long Long Long Long Long Long Long Long Long Long Long Long Long Long Long Integer 
            stack 
        .end stack 
L151:   iload 52 
L153:   bipush 24 
L155:   if_icmpge L1197 
L158:   lload_2 
L159:   lload 12 
L161:   lxor 
L162:   lload 22 
L164:   lxor 
L165:   lload 32 
L167:   lxor 
L168:   lload 42 
L170:   lxor 
L171:   lstore 53 
L173:   lload 4 
L175:   lload 14 
L177:   lxor 
L178:   lload 24 
L180:   lxor 
L181:   lload 34 
L183:   lxor 
L184:   lload 44 
L186:   lxor 
L187:   lstore 55 
L189:   lload 6 
L191:   lload 16 
L193:   lxor 
L194:   lload 26 
L196:   lxor 
L197:   lload 36 
L199:   lxor 
L200:   lload 46 
L202:   lxor 
L203:   lstore 57 
L205:   lload 8 
L207:   lload 18 
L209:   lxor 
L210:   lload 28 
L212:   lxor 
L213:   lload 38 
L215:   lxor 
L216:   lload 48 
L218:   lxor 
L219:   lstore 59 
L221:   lload 10 
L223:   lload 20 
L225:   lxor 
L226:   lload 30 
L228:   lxor 
L229:   lload 40 
L231:   lxor 
L232:   lload 50 
L234:   lxor 
L235:   lstore 61 
L237:   lload 55 
L239:   iconst_1 
L240:   lshl 
L241:   lload 55 
L243:   bipush 63 
L245:   lushr 
L246:   lor 
L247:   lload 61 
L249:   lxor 
L250:   lstore 63 
L252:   lload 57 
L254:   iconst_1 
L255:   lshl 
L256:   lload 57 
L258:   bipush 63 
L260:   lushr 
L261:   lor 
L262:   lload 53 
L264:   lxor 
L265:   lstore 65 
L267:   lload 59 
L269:   iconst_1 
L270:   lshl 
L271:   lload 59 
L273:   bipush 63 
L275:   lushr 
L276:   lor 
L277:   lload 55 
L279:   lxor 
L280:   lstore 67 
L282:   lload 61 
L284:   iconst_1 
L285:   lshl 
L286:   lload 61 
L288:   bipush 63 
L290:   lushr 
L291:   lor 
L292:   lload 57 
L294:   lxor 
L295:   lstore 69 
L297:   lload 53 
L299:   iconst_1 
L300:   lshl 
L301:   lload 53 
L303:   bipush 63 
L305:   lushr 
L306:   lor 
L307:   lload 59 
L309:   lxor 
L310:   lstore 71 
L312:   lload_2 
L313:   lload 63 
L315:   lxor 
L316:   lstore_2 
L317:   lload 12 
L319:   lload 63 
L321:   lxor 
L322:   lstore 12 
L324:   lload 22 
L326:   lload 63 
L328:   lxor 
L329:   lstore 22 
L331:   lload 32 
L333:   lload 63 
L335:   lxor 
L336:   lstore 32 
L338:   lload 42 
L340:   lload 63 
L342:   lxor 
L343:   lstore 42 
L345:   lload 4 
L347:   lload 65 
L349:   lxor 
L350:   lstore 4 
L352:   lload 14 
L354:   lload 65 
L356:   lxor 
L357:   lstore 14 
L359:   lload 24 
L361:   lload 65 
L363:   lxor 
L364:   lstore 24 
L366:   lload 34 
L368:   lload 65 
L370:   lxor 
L371:   lstore 34 
L373:   lload 44 
L375:   lload 65 
L377:   lxor 
L378:   lstore 44 
L380:   lload 6 
L382:   lload 67 
L384:   lxor 
L385:   lstore 6 
L387:   lload 16 
L389:   lload 67 
L391:   lxor 
L392:   lstore 16 
L394:   lload 26 
L396:   lload 67 
L398:   lxor 
L399:   lstore 26 
L401:   lload 36 
L403:   lload 67 
L405:   lxor 
L406:   lstore 36 
L408:   lload 46 
L410:   lload 67 
L412:   lxor 
L413:   lstore 46 
L415:   lload 8 
L417:   lload 69 
L419:   lxor 
L420:   lstore 8 
L422:   lload 18 
L424:   lload 69 
L426:   lxor 
L427:   lstore 18 
L429:   lload 28 
L431:   lload 69 
L433:   lxor 
L434:   lstore 28 
L436:   lload 38 
L438:   lload 69 
L440:   lxor 
L441:   lstore 38 
L443:   lload 48 
L445:   lload 69 
L447:   lxor 
L448:   lstore 48 
L450:   lload 10 
L452:   lload 71 
L454:   lxor 
L455:   lstore 10 
L457:   lload 20 
L459:   lload 71 
L461:   lxor 
L462:   lstore 20 
L464:   lload 30 
L466:   lload 71 
L468:   lxor 
L469:   lstore 30 
L471:   lload 40 
L473:   lload 71 
L475:   lxor 
L476:   lstore 40 
L478:   lload 50 
L480:   lload 71 
L482:   lxor 
L483:   lstore 50 
L485:   lload 4 
L487:   iconst_1 
L488:   lshl 
L489:   lload 4 
L491:   bipush 63 
L493:   lushr 
L494:   lor 
L495:   lstore 55 
L497:   lload 14 
L499:   bipush 44 
L501:   lshl 
L502:   lload 14 
L504:   bipush 20 
L506:   lushr 
L507:   lor 
L508:   lstore 4 
L510:   lload 20 
L512:   bipush 20 
L514:   lshl 
L515:   lload 20 
L517:   bipush 44 
L519:   lushr 
L520:   lor 
L521:   lstore 14 
L523:   lload 46 
L525:   bipush 61 
L527:   lshl 
L528:   lload 46 
L530:   iconst_3 
L531:   lushr 
L532:   lor 
L533:   lstore 20 
L535:   lload 30 
L537:   bipush 39 
L539:   lshl 
L540:   lload 30 
L542:   bipush 25 
L544:   lushr 
L545:   lor 
L546:   lstore 46 
L548:   lload 42 
L550:   bipush 18 
L552:   lshl 
L553:   lload 42 
L555:   bipush 46 
L557:   lushr 
L558:   lor 
L559:   lstore 30 
L561:   lload 6 
L563:   bipush 62 
L565:   lshl 
L566:   lload 6 
L568:   iconst_2 
L569:   lushr 
L570:   lor 
L571:   lstore 42 
L573:   lload 26 
L575:   bipush 43 
L577:   lshl 
L578:   lload 26 
L580:   bipush 21 
L582:   lushr 
L583:   lor 
L584:   lstore 6 
L586:   lload 28 
L588:   bipush 25 
L590:   lshl 
L591:   lload 28 
L593:   bipush 39 
L595:   lushr 
L596:   lor 
L597:   lstore 26 
L599:   lload 40 
L601:   bipush 8 
L603:   lshl 
L604:   lload 40 
L606:   bipush 56 
L608:   lushr 
L609:   lor 
L610:   lstore 28 
L612:   lload 48 
L614:   bipush 56 
L616:   lshl 
L617:   lload 48 
L619:   bipush 8 
L621:   lushr 
L622:   lor 
L623:   lstore 40 
L625:   lload 32 
L627:   bipush 41 
L629:   lshl 
L630:   lload 32 
L632:   bipush 23 
L634:   lushr 
L635:   lor 
L636:   lstore 48 
L638:   lload 10 
L640:   bipush 27 
L642:   lshl 
L643:   lload 10 
L645:   bipush 37 
L647:   lushr 
L648:   lor 
L649:   lstore 32 
L651:   lload 50 
L653:   bipush 14 
L655:   lshl 
L656:   lload 50 
L658:   bipush 50 
L660:   lushr 
L661:   lor 
L662:   lstore 10 
L664:   lload 44 
L666:   iconst_2 
L667:   lshl 
L668:   lload 44 
L670:   bipush 62 
L672:   lushr 
L673:   lor 
L674:   lstore 50 
L676:   lload 18 
L678:   bipush 55 
L680:   lshl 
L681:   lload 18 
L683:   bipush 9 
L685:   lushr 
L686:   lor 
L687:   lstore 44 
L689:   lload 34 
L691:   bipush 45 
L693:   lshl 
L694:   lload 34 
L696:   bipush 19 
L698:   lushr 
L699:   lor 
L700:   lstore 18 
L702:   lload 12 
L704:   bipush 36 
L706:   lshl 
L707:   lload 12 
L709:   bipush 28 
L711:   lushr 
L712:   lor 
L713:   lstore 34 
L715:   lload 8 
L717:   bipush 28 
L719:   lshl 
L720:   lload 8 
L722:   bipush 36 
L724:   lushr 
L725:   lor 
L726:   lstore 12 
L728:   lload 38 
L730:   bipush 21 
L732:   lshl 
L733:   lload 38 
L735:   bipush 43 
L737:   lushr 
L738:   lor 
L739:   lstore 8 
L741:   lload 36 
L743:   bipush 15 
L745:   lshl 
L746:   lload 36 
L748:   bipush 49 
L750:   lushr 
L751:   lor 
L752:   lstore 38 
L754:   lload 24 
L756:   bipush 10 
L758:   lshl 
L759:   lload 24 
L761:   bipush 54 
L763:   lushr 
L764:   lor 
L765:   lstore 36 
L767:   lload 16 
L769:   bipush 6 
L771:   lshl 
L772:   lload 16 
L774:   bipush 58 
L776:   lushr 
L777:   lor 
L778:   lstore 24 
L780:   lload 22 
L782:   iconst_3 
L783:   lshl 
L784:   lload 22 
L786:   bipush 61 
L788:   lushr 
L789:   lor 
L790:   lstore 16 
L792:   lload 55 
L794:   lstore 22 
L796:   lload_2 
L797:   lload 4 
L799:   ldc2_w -1L 
L802:   lxor 
L803:   lload 6 
L805:   land 
L806:   lxor 
L807:   lstore 53 
L809:   lload 4 
L811:   lload 6 
L813:   ldc2_w -1L 
L816:   lxor 
L817:   lload 8 
L819:   land 
L820:   lxor 
L821:   lstore 55 
L823:   lload 6 
L825:   lload 8 
L827:   ldc2_w -1L 
L830:   lxor 
L831:   lload 10 
L833:   land 
L834:   lxor 
L835:   lstore 6 
L837:   lload 8 
L839:   lload 10 
L841:   ldc2_w -1L 
L844:   lxor 
L845:   lload_2 
L846:   land 
L847:   lxor 
L848:   lstore 8 
L850:   lload 10 
L852:   lload_2 
L853:   ldc2_w -1L 
L856:   lxor 
L857:   lload 4 
L859:   land 
L860:   lxor 
L861:   lstore 10 
L863:   lload 53 
L865:   lstore_2 
L866:   lload 55 
L868:   lstore 4 
L870:   lload 12 
L872:   lload 14 
L874:   ldc2_w -1L 
L877:   lxor 
L878:   lload 16 
L880:   land 
L881:   lxor 
L882:   lstore 53 
L884:   lload 14 
L886:   lload 16 
L888:   ldc2_w -1L 
L891:   lxor 
L892:   lload 18 
L894:   land 
L895:   lxor 
L896:   lstore 55 
L898:   lload 16 
L900:   lload 18 
L902:   ldc2_w -1L 
L905:   lxor 
L906:   lload 20 
L908:   land 
L909:   lxor 
L910:   lstore 16 
L912:   lload 18 
L914:   lload 20 
L916:   ldc2_w -1L 
L919:   lxor 
L920:   lload 12 
L922:   land 
L923:   lxor 
L924:   lstore 18 
L926:   lload 20 
L928:   lload 12 
L930:   ldc2_w -1L 
L933:   lxor 
L934:   lload 14 
L936:   land 
L937:   lxor 
L938:   lstore 20 
L940:   lload 53 
L942:   lstore 12 
L944:   lload 55 
L946:   lstore 14 
L948:   lload 22 
L950:   lload 24 
L952:   ldc2_w -1L 
L955:   lxor 
L956:   lload 26 
L958:   land 
L959:   lxor 
L960:   lstore 53 
L962:   lload 24 
L964:   lload 26 
L966:   ldc2_w -1L 
L969:   lxor 
L970:   lload 28 
L972:   land 
L973:   lxor 
L974:   lstore 55 
L976:   lload 26 
L978:   lload 28 
L980:   ldc2_w -1L 
L983:   lxor 
L984:   lload 30 
L986:   land 
L987:   lxor 
L988:   lstore 26 
L990:   lload 28 
L992:   lload 30 
L994:   ldc2_w -1L 
L997:   lxor 
L998:   lload 22 
L1000:  land 
L1001:  lxor 
L1002:  lstore 28 
L1004:  lload 30 
L1006:  lload 22 
L1008:  ldc2_w -1L 
L1011:  lxor 
L1012:  lload 24 
L1014:  land 
L1015:  lxor 
L1016:  lstore 30 
L1018:  lload 53 
L1020:  lstore 22 
L1022:  lload 55 
L1024:  lstore 24 
L1026:  lload 32 
L1028:  lload 34 
L1030:  ldc2_w -1L 
L1033:  lxor 
L1034:  lload 36 
L1036:  land 
L1037:  lxor 
L1038:  lstore 53 
L1040:  lload 34 
L1042:  lload 36 
L1044:  ldc2_w -1L 
L1047:  lxor 
L1048:  lload 38 
L1050:  land 
L1051:  lxor 
L1052:  lstore 55 
L1054:  lload 36 
L1056:  lload 38 
L1058:  ldc2_w -1L 
L1061:  lxor 
L1062:  lload 40 
L1064:  land 
L1065:  lxor 
L1066:  lstore 36 
L1068:  lload 38 
L1070:  lload 40 
L1072:  ldc2_w -1L 
L1075:  lxor 
L1076:  lload 32 
L1078:  land 
L1079:  lxor 
L1080:  lstore 38 
L1082:  lload 40 
L1084:  lload 32 
L1086:  ldc2_w -1L 
L1089:  lxor 
L1090:  lload 34 
L1092:  land 
L1093:  lxor 
L1094:  lstore 40 
L1096:  lload 53 
L1098:  lstore 32 
L1100:  lload 55 
L1102:  lstore 34 
L1104:  lload 42 
L1106:  lload 44 
L1108:  ldc2_w -1L 
L1111:  lxor 
L1112:  lload 46 
L1114:  land 
L1115:  lxor 
L1116:  lstore 53 
L1118:  lload 44 
L1120:  lload 46 
L1122:  ldc2_w -1L 
L1125:  lxor 
L1126:  lload 48 
L1128:  land 
L1129:  lxor 
L1130:  lstore 55 
L1132:  lload 46 
L1134:  lload 48 
L1136:  ldc2_w -1L 
L1139:  lxor 
L1140:  lload 50 
L1142:  land 
L1143:  lxor 
L1144:  lstore 46 
L1146:  lload 48 
L1148:  lload 50 
L1150:  ldc2_w -1L 
L1153:  lxor 
L1154:  lload 42 
L1156:  land 
L1157:  lxor 
L1158:  lstore 48 
L1160:  lload 50 
L1162:  lload 42 
L1164:  ldc2_w -1L 
L1167:  lxor 
L1168:  lload 44 
L1170:  land 
L1171:  lxor 
L1172:  lstore 50 
L1174:  lload 53 
L1176:  lstore 42 
L1178:  lload 55 
L1180:  lstore 44 
L1182:  lload_2 
L1183:  getstatic Field KeccakDigest KeccakRoundConstants [J 
L1186:  iload 52 
L1188:  laload 
L1189:  lxor 
L1190:  lstore_2 
L1191:  iinc 52 1 
L1194:  goto L151 

        .stack chop 1 
L1197:  aload_1 
L1198:  iconst_0 
L1199:  lload_2 
L1200:  lastore 
L1201:  aload_1 
L1202:  iconst_1 
L1203:  lload 4 
L1205:  lastore 
L1206:  aload_1 
L1207:  iconst_2 
L1208:  lload 6 
L1210:  lastore 
L1211:  aload_1 
L1212:  iconst_3 
L1213:  lload 8 
L1215:  lastore 
L1216:  aload_1 
L1217:  iconst_4 
L1218:  lload 10 
L1220:  lastore 
L1221:  aload_1 
L1222:  iconst_5 
L1223:  lload 12 
L1225:  lastore 
L1226:  aload_1 
L1227:  bipush 6 
L1229:  lload 14 
L1231:  lastore 
L1232:  aload_1 
L1233:  bipush 7 
L1235:  lload 16 
L1237:  lastore 
L1238:  aload_1 
L1239:  bipush 8 
L1241:  lload 18 
L1243:  lastore 
L1244:  aload_1 
L1245:  bipush 9 
L1247:  lload 20 
L1249:  lastore 
L1250:  aload_1 
L1251:  bipush 10 
L1253:  lload 22 
L1255:  lastore 
L1256:  aload_1 
L1257:  bipush 11 
L1259:  lload 24 
L1261:  lastore 
L1262:  aload_1 
L1263:  bipush 12 
L1265:  lload 26 
L1267:  lastore 
L1268:  aload_1 
L1269:  bipush 13 
L1271:  lload 28 
L1273:  lastore 
L1274:  aload_1 
L1275:  bipush 14 
L1277:  lload 30 
L1279:  lastore 
L1280:  aload_1 
L1281:  bipush 15 
L1283:  lload 32 
L1285:  lastore 
L1286:  aload_1 
L1287:  bipush 16 
L1289:  lload 34 
L1291:  lastore 
L1292:  aload_1 
L1293:  bipush 17 
L1295:  lload 36 
L1297:  lastore 
L1298:  aload_1 
L1299:  bipush 18 
L1301:  lload 38 
L1303:  lastore 
L1304:  aload_1 
L1305:  bipush 19 
L1307:  lload 40 
L1309:  lastore 
L1310:  aload_1 
L1311:  bipush 20 
L1313:  lload 42 
L1315:  lastore 
L1316:  aload_1 
L1317:  bipush 21 
L1319:  lload 44 
L1321:  lastore 
L1322:  aload_1 
L1323:  bipush 22 
L1325:  lload 46 
L1327:  lastore 
L1328:  aload_1 
L1329:  bipush 23 
L1331:  lload 48 
L1333:  lastore 
L1334:  aload_1 
L1335:  bipush 24 
L1337:  lload 50 
L1339:  lastore 
L1340:  return 
L1341:  
        .linenumbertable 
            L0 228 
            L5 230 
            L29 231 
            L58 232 
            L88 233 
            L118 234 
            L148 236 
            L158 239 
            L173 240 
            L189 241 
            L205 242 
            L221 243 
            L237 245 
            L252 246 
            L267 247 
            L282 248 
            L297 249 
            L312 251 
            L345 252 
            L380 253 
            L415 254 
            L450 255 
            L485 258 
            L497 259 
            L510 260 
            L523 261 
            L535 262 
            L548 263 
            L561 264 
            L573 265 
            L586 266 
            L599 267 
            L612 268 
            L625 269 
            L638 270 
            L651 271 
            L664 272 
            L676 273 
            L689 274 
            L702 275 
            L715 276 
            L728 277 
            L741 278 
            L754 279 
            L767 280 
            L780 281 
            L792 282 
            L796 285 
            L809 286 
            L823 287 
            L837 288 
            L850 289 
            L863 290 
            L866 291 
            L870 293 
            L884 294 
            L898 295 
            L912 296 
            L926 297 
            L940 298 
            L944 299 
            L948 301 
            L962 302 
            L976 303 
            L990 304 
            L1004 305 
            L1018 306 
            L1022 307 
            L1026 309 
            L1040 310 
            L1054 311 
            L1068 312 
            L1082 313 
            L1096 314 
            L1100 315 
            L1104 317 
            L1118 318 
            L1132 319 
            L1146 320 
            L1160 321 
            L1174 322 
            L1178 323 
            L1182 326 
            L1191 236 
            L1197 329 
            L1221 330 
            L1250 331 
            L1280 332 
            L1310 333 
            L1340 334 
        .end linenumbertable 
        .localvariabletable 
            53 is c0 J from L173 to L1191 
            55 is c1 J from L189 to L1191 
            57 is c2 J from L205 to L1191 
            59 is c3 J from L221 to L1191 
            61 is c4 J from L237 to L1191 
            63 is d1 J from L252 to L1191 
            65 is d2 J from L267 to L1191 
            67 is d3 J from L282 to L1191 
            69 is d4 J from L297 to L1191 
            71 is d0 J from L312 to L1191 
            52 is i I from L151 to L1197 
            0 is this LKeccakDigest; from L0 to L1341 
            1 is A [J from L5 to L1341 
            2 is a00 J from L9 to L1341 
            4 is a01 J from L14 to L1341 
            6 is a02 J from L19 to L1341 
            8 is a03 J from L24 to L1341 
            10 is a04 J from L29 to L1341 
            12 is a05 J from L34 to L1341 
            14 is a06 J from L40 to L1341 
            16 is a07 J from L46 to L1341 
            18 is a08 J from L52 to L1341 
            20 is a09 J from L58 to L1341 
            22 is a10 J from L64 to L1341 
            24 is a11 J from L70 to L1341 
            26 is a12 J from L76 to L1341 
            28 is a13 J from L82 to L1341 
            30 is a14 J from L88 to L1341 
            32 is a15 J from L94 to L1341 
            34 is a16 J from L100 to L1341 
            36 is a17 J from L106 to L1341 
            38 is a18 J from L112 to L1341 
            40 is a19 J from L118 to L1341 
            42 is a20 J from L124 to L1341 
            44 is a21 J from L130 to L1341 
            46 is a22 J from L136 to L1341 
            48 is a23 J from L142 to L1341 
            50 is a24 J from L148 to L1341 
        .end localvariabletable 
    .end code 
.end method 

.method static <clinit> : ()V 
    .code stack 5 locals 0 
L0:     bipush 24 
L2:     newarray long 
L4:     dup 
L5:     iconst_0 
L6:     lconst_1 
L7:     lastore 
L8:     dup 
L9:     iconst_1 
L10:    ldc2_w 32898L 
L13:    lastore 
L14:    dup 
L15:    iconst_2 
L16:    ldc2_w -9223372036854742902L 
L19:    lastore 
L20:    dup 
L21:    iconst_3 
L22:    ldc2_w -9223372034707259392L 
L25:    lastore 
L26:    dup 
L27:    iconst_4 
L28:    ldc2_w 32907L 
L31:    lastore 
L32:    dup 
L33:    iconst_5 
L34:    ldc2_w 2147483649L 
L37:    lastore 
L38:    dup 
L39:    bipush 6 
L41:    ldc2_w -9223372034707259263L 
L44:    lastore 
L45:    dup 
L46:    bipush 7 
L48:    ldc2_w -9223372036854743031L 
L51:    lastore 
L52:    dup 
L53:    bipush 8 
L55:    ldc2_w 138L 
L58:    lastore 
L59:    dup 
L60:    bipush 9 
L62:    ldc2_w 136L 
L65:    lastore 
L66:    dup 
L67:    bipush 10 
L69:    ldc2_w 2147516425L 
L72:    lastore 
L73:    dup 
L74:    bipush 11 
L76:    ldc2_w 2147483658L 
L79:    lastore 
L80:    dup 
L81:    bipush 12 
L83:    ldc2_w 2147516555L 
L86:    lastore 
L87:    dup 
L88:    bipush 13 
L90:    ldc2_w -9223372036854775669L 
L93:    lastore 
L94:    dup 
L95:    bipush 14 
L97:    ldc2_w -9223372036854742903L 
L100:   lastore 
L101:   dup 
L102:   bipush 15 
L104:   ldc2_w -9223372036854743037L 
L107:   lastore 
L108:   dup 
L109:   bipush 16 
L111:   ldc2_w -9223372036854743038L 
L114:   lastore 
L115:   dup 
L116:   bipush 17 
L118:   ldc2_w -9223372036854775680L 
L121:   lastore 
L122:   dup 
L123:   bipush 18 
L125:   ldc2_w 32778L 
L128:   lastore 
L129:   dup 
L130:   bipush 19 
L132:   ldc2_w -9223372034707292150L 
L135:   lastore 
L136:   dup 
L137:   bipush 20 
L139:   ldc2_w -9223372034707259263L 
L142:   lastore 
L143:   dup 
L144:   bipush 21 
L146:   ldc2_w -9223372036854742912L 
L149:   lastore 
L150:   dup 
L151:   bipush 22 
L153:   ldc2_w 2147483649L 
L156:   lastore 
L157:   dup 
L158:   bipush 23 
L160:   ldc2_w -9223372034707259384L 
L163:   lastore 
L164:   putstatic Field KeccakDigest KeccakRoundConstants [J 
L167:   return 
L168:   
        .linenumbertable 
            L0 5 
        .end linenumbertable 
    .end code 
.end method 
.sourcefile 'KeccakDigest.java' 
.end class 
