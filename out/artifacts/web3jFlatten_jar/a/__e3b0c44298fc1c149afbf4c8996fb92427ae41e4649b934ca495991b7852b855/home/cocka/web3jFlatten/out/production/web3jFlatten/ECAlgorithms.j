.version 52 0 
.class super ECAlgorithms 
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
            0 is this LECAlgorithms; from L0 to L5 
        .end localvariabletable 
    .end code 
.end method 

.method public static importPoint : (LECCurve;LECPoint;)LECPoint; 
    .code stack 3 locals 3 
L0:     aload_1 
L1:     invokevirtual Method ECPoint getCurve ()LECCurve; 
L4:     astore_2 
L5:     aload_0 
L6:     aload_2 
L7:     invokevirtual Method ECCurve equals (LECCurve;)Z 
L10:    ifne L23 
L13:    new java/lang/IllegalArgumentException 
L16:    dup 
L17:    ldc 'Point must be on the same curve' 
L19:    invokespecial Method java/lang/IllegalArgumentException <init> (Ljava/lang/String;)V 
L22:    athrow 

        .stack append Object ECCurve 
L23:    aload_0 
L24:    aload_1 
L25:    invokevirtual Method ECCurve importPoint (LECPoint;)LECPoint; 
L28:    areturn 
L29:    
        .linenumbertable 
            L0 8 
            L5 9 
            L13 11 
            L23 13 
        .end linenumbertable 
        .localvariabletable 
            0 is c LECCurve; from L0 to L29 
            1 is p LECPoint; from L0 to L29 
            2 is cp LECCurve; from L5 to L29 
        .end localvariabletable 
    .end code 
    .exceptions java/lang/CloneNotSupportedException 
.end method 

.method public static montgomeryTrick : ([LECFieldElement;IILECFieldElement;)V 
    .code stack 6 locals 9 
L0:     iload_2 
L1:     anewarray ECFieldElement 
L4:     astore 4 
L6:     aload 4 
L8:     iconst_0 
L9:     aload_0 
L10:    iload_1 
L11:    aaload 
L12:    aastore 
L13:    iconst_0 
L14:    istore 5 

        .stack append Object [LECFieldElement; Integer 
L16:    iinc 5 1 
L19:    iload 5 
L21:    iload_2 
L22:    if_icmpge L49 
L25:    aload 4 
L27:    iload 5 
L29:    aload 4 
L31:    iload 5 
L33:    iconst_1 
L34:    isub 
L35:    aaload 
L36:    aload_0 
L37:    iload_1 
L38:    iload 5 
L40:    iadd 
L41:    aaload 
L42:    invokevirtual Method ECFieldElement multiply (LECFieldElement;)LECFieldElement; 
L45:    aastore 
L46:    goto L16 

        .stack same 
L49:    iinc 5 -1 
L52:    aload_3 
L53:    ifnull L70 
L56:    aload 4 
L58:    iload 5 
L60:    aload 4 
L62:    iload 5 
L64:    aaload 
L65:    aload_3 
L66:    invokevirtual Method ECFieldElement multiply (LECFieldElement;)LECFieldElement; 
L69:    aastore 

        .stack same 
L70:    aload 4 
L72:    iload 5 
L74:    aaload 
L75:    invokevirtual Method ECFieldElement invert ()LECFieldElement; 
L78:    astore 6 

        .stack append Object ECFieldElement 
L80:    iload 5 
L82:    ifle L126 
L85:    iload_1 
L86:    iload 5 
L88:    iinc 5 -1 
L91:    iadd 
L92:    istore 7 
L94:    aload_0 
L95:    iload 7 
L97:    aaload 
L98:    astore 8 
L100:   aload_0 
L101:   iload 7 
L103:   aload 4 
L105:   iload 5 
L107:   aaload 
L108:   aload 6 
L110:   invokevirtual Method ECFieldElement multiply (LECFieldElement;)LECFieldElement; 
L113:   aastore 
L114:   aload 6 
L116:   aload 8 
L118:   invokevirtual Method ECFieldElement multiply (LECFieldElement;)LECFieldElement; 
L121:   astore 6 
L123:   goto L80 

        .stack same 
L126:   aload_0 
L127:   iload_1 
L128:   aload 6 
L130:   aastore 
L131:   return 
L132:   
        .linenumbertable 
            L0 20 
            L6 21 
            L13 23 
            L16 24 
            L25 26 
            L49 29 
            L52 31 
            L56 33 
            L70 36 
            L80 38 
            L85 40 
            L94 41 
            L100 42 
            L114 43 
            L123 44 
            L126 46 
            L131 47 
        .end linenumbertable 
        .localvariabletable 
            7 is j I from L94 to L123 
            8 is tmp LECFieldElement; from L100 to L123 
            0 is zs [LECFieldElement; from L0 to L132 
            1 is off I from L0 to L132 
            2 is len I from L0 to L132 
            3 is scale LECFieldElement; from L0 to L132 
            4 is c [LECFieldElement; from L6 to L132 
            5 is i I from L16 to L132 
            6 is u LECFieldElement; from L80 to L132 
        .end localvariabletable 
    .end code 
.end method 

.method static implCheckResult : (LECPoint;)LECPoint; 
    .code stack 3 locals 1 
L0:     aload_0 
L1:     invokevirtual Method ECPoint isValidPartial ()Z 
L4:     ifne L17 
L7:     new java/lang/IllegalStateException 
L10:    dup 
L11:    ldc 'Invalid result' 
L13:    invokespecial Method java/lang/IllegalStateException <init> (Ljava/lang/String;)V 
L16:    athrow 

        .stack same 
L17:    aload_0 
L18:    areturn 
L19:    
        .linenumbertable 
            L0 52 
            L7 54 
            L17 57 
        .end linenumbertable 
        .localvariabletable 
            0 is p LECPoint; from L0 to L19 
        .end localvariabletable 
    .end code 
    .exceptions java/lang/CloneNotSupportedException 
.end method 
.sourcefile 'ECAlgorithms.java' 
.end class 
