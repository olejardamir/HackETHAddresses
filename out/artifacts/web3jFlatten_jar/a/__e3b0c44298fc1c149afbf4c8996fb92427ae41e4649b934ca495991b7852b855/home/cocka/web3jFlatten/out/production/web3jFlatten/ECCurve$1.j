.version 52 0 
.class super ECCurve$1 
.super java/lang/Object 
.implements ECLookupTable 
.field final synthetic val$len I 
.field final synthetic val$FE_BYTES I 
.field final synthetic val$table [B 
.field final synthetic this$0 LECCurve; 

.method <init> : (LECCurve;II[B)V 
    .code stack 2 locals 5 
L0:     aload_0 
L1:     aload_1 
L2:     putfield Field ECCurve$1 this$0 LECCurve; 
L5:     aload_0 
L6:     iload_2 
L7:     putfield Field ECCurve$1 val$len I 
L10:    aload_0 
L11:    iload_3 
L12:    putfield Field ECCurve$1 val$FE_BYTES I 
L15:    aload_0 
L16:    aload 4 
L18:    putfield Field ECCurve$1 val$table [B 
L21:    aload_0 
L22:    invokespecial Method java/lang/Object <init> ()V 
L25:    return 
L26:    
        .linenumbertable 
            L0 333 
        .end linenumbertable 
        .localvariabletable 
            0 is this LECCurve$1; from L0 to L26 
            1 is this$0 LECCurve; from L0 to L26 
        .end localvariabletable 
    .end code 
.end method 

.method public getSize : ()I 
    .code stack 1 locals 1 
L0:     aload_0 
L1:     getfield Field ECCurve$1 val$len I 
L4:     ireturn 
L5:     
        .linenumbertable 
            L0 336 
        .end linenumbertable 
        .localvariabletable 
            0 is this LECCurve$1; from L0 to L5 
        .end localvariabletable 
    .end code 
.end method 

.method public lookup : (I)LECPoint; 
    .code stack 7 locals 8 
L0:     aload_0 
L1:     getfield Field ECCurve$1 val$FE_BYTES I 
L4:     newarray byte 
L6:     astore_2 
L7:     aload_0 
L8:     getfield Field ECCurve$1 val$FE_BYTES I 
L11:    newarray byte 
L13:    astore_3 
L14:    iconst_0 
L15:    istore 4 
L17:    iconst_0 
L18:    istore 5 

        .stack full 
            locals Object ECCurve$1 Integer Object [B Object [B Integer Integer 
            stack 
        .end stack 
L20:    iload 5 
L22:    aload_0 
L23:    getfield Field ECCurve$1 val$len I 
L26:    if_icmpge L122 
L29:    iload 5 
L31:    iload_1 
L32:    ixor 
L33:    iconst_1 
L34:    isub 
L35:    bipush 31 
L37:    ishr 
L38:    istore 6 
L40:    iconst_0 
L41:    istore 7 

        .stack append Integer Integer 
L43:    iload 7 
L45:    aload_0 
L46:    getfield Field ECCurve$1 val$FE_BYTES I 
L49:    if_icmpge L105 
L52:    aload_2 
L53:    iload 7 
L55:    dup2 
L56:    baload 
L57:    aload_0 
L58:    getfield Field ECCurve$1 val$table [B 
L61:    iload 4 
L63:    iload 7 
L65:    iadd 
L66:    baload 
L67:    iload 6 
L69:    iand 
L70:    ixor 
L71:    i2b 
L72:    bastore 
L73:    aload_3 
L74:    iload 7 
L76:    dup2 
L77:    baload 
L78:    aload_0 
L79:    getfield Field ECCurve$1 val$table [B 
L82:    iload 4 
L84:    aload_0 
L85:    getfield Field ECCurve$1 val$FE_BYTES I 
L88:    iadd 
L89:    iload 7 
L91:    iadd 
L92:    baload 
L93:    iload 6 
L95:    iand 
L96:    ixor 
L97:    i2b 
L98:    bastore 
L99:    iinc 7 1 
L102:   goto L43 

        .stack chop 1 
L105:   iload 4 
L107:   aload_0 
L108:   getfield Field ECCurve$1 val$FE_BYTES I 
L111:   iconst_2 
L112:   imul 
L113:   iadd 
L114:   istore 4 
L116:   iinc 5 1 
L119:   goto L20 

        .stack chop 2 
L122:   aload_0 
L123:   getfield Field ECCurve$1 this$0 LECCurve; 
L126:   aload_0 
L127:   getfield Field ECCurve$1 this$0 LECCurve; 
L130:   new java/math/BigInteger 
L133:   dup 
L134:   iconst_1 
L135:   aload_2 
L136:   invokespecial Method java/math/BigInteger <init> (I[B)V 
L139:   invokevirtual Method ECCurve fromBigInteger (Ljava/math/BigInteger;)LECFieldElement; 
L142:   aload_0 
L143:   getfield Field ECCurve$1 this$0 LECCurve; 
L146:   new java/math/BigInteger 
L149:   dup 
L150:   iconst_1 
L151:   aload_3 
L152:   invokespecial Method java/math/BigInteger <init> (I[B)V 
L155:   invokevirtual Method ECCurve fromBigInteger (Ljava/math/BigInteger;)LECFieldElement; 
L158:   iconst_0 
L159:   invokevirtual Method ECCurve createRawPoint (LECFieldElement;LECFieldElement;Z)LECPoint; 
L162:   areturn 
L163:   
        .linenumbertable 
            L0 341 
            L14 342 
            L17 344 
            L29 346 
            L40 348 
            L52 350 
            L73 351 
            L99 348 
            L105 354 
            L116 344 
            L122 357 
        .end linenumbertable 
        .localvariabletable 
            7 is j I from L43 to L105 
            6 is MASK I from L40 to L116 
            5 is i I from L20 to L122 
            0 is this LECCurve$1; from L0 to L163 
            1 is index I from L0 to L163 
            2 is x [B from L7 to L163 
            3 is y [B from L14 to L163 
            4 is pos I from L17 to L163 
        .end localvariabletable 
    .end code 
.end method 
.sourcefile 'ECCurve.java' 
.enclosing method ECCurve createCacheSafeLookupTable ([LECPoint;II)LECLookupTable; 
.innerclasses 
    ECCurve$1 [0] [0] 
.end innerclasses 
.end class 
