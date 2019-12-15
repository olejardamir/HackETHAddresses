.version 52 0 
.class public super FixedPointCombMultiplier 
.super AbstractECMultiplier 

.method public <init> : ()V 
    .code stack 1 locals 1 
L0:     aload_0 
L1:     invokespecial Method AbstractECMultiplier <init> ()V 
L4:     return 
L5:     
        .linenumbertable 
            L0 3 
        .end linenumbertable 
        .localvariabletable 
            0 is this LFixedPointCombMultiplier; from L0 to L5 
        .end localvariabletable 
    .end code 
.end method 

.method protected multiplyPositive : (LECPoint;Ljava/math/BigInteger;)LECPoint; 
    .code stack 3 locals 17 
L0:     aload_1 
L1:     invokevirtual Method ECPoint getCurve ()LECCurve; 
L4:     astore_3 
L5:     aload_3 
L6:     invokestatic Method FixedPointUtil getCombSize (LECCurve;)I 
L9:     istore 4 
L11:    aload_2 
L12:    invokevirtual Method java/math/BigInteger bitLength ()I 
L15:    iload 4 
L17:    if_icmple L30 
L20:    new java/lang/IllegalStateException 
L23:    dup 
L24:    ldc "fixed-point comb doesn't support scalars larger than the curve order" 
L26:    invokespecial Method java/lang/IllegalStateException <init> (Ljava/lang/String;)V 
L29:    athrow 

        .stack append Object ECCurve Integer 
L30:    aload_1 
L31:    invokestatic Method FixedPointUtil precompute (LECPoint;)LFixedPointPreCompInfo; 
L34:    astore 5 
L36:    aload 5 
L38:    invokevirtual Method FixedPointPreCompInfo getLookupTable ()LECLookupTable; 
L41:    astore 6 
L43:    aload 5 
L45:    invokevirtual Method FixedPointPreCompInfo getWidth ()I 
L48:    istore 7 
L50:    iload 4 
L52:    iload 7 
L54:    iadd 
L55:    iconst_1 
L56:    isub 
L57:    iload 7 
L59:    idiv 
L60:    istore 8 
L62:    aload_3 
L63:    invokevirtual Method ECCurve getInfinity ()LECPoint; 
L66:    astore 9 
L68:    iload 8 
L70:    iload 7 
L72:    imul 
L73:    istore 10 
L75:    iload 10 
L77:    aload_2 
L78:    invokestatic Method Nat fromBigInteger (ILjava/math/BigInteger;)[I 
L81:    astore 11 
L83:    iload 10 
L85:    iconst_1 
L86:    isub 
L87:    istore 12 
L89:    iconst_0 
L90:    istore 13 

        .stack full 
            locals Object FixedPointCombMultiplier Object ECPoint Object java/math/BigInteger Object ECCurve Integer Object FixedPointPreCompInfo Object ECLookupTable Integer Integer Object ECPoint Integer Object [I Integer Integer 
            stack 
        .end stack 
L92:    iload 13 
L94:    iload 8 
L96:    if_icmpge L187 
L99:    iconst_0 
L100:   istore 14 
L102:   iload 12 
L104:   iload 13 
L106:   isub 
L107:   istore 15 

        .stack append Integer Integer 
L109:   iload 15 
L111:   iflt L161 
L114:   aload 11 
L116:   iload 15 
L118:   iconst_5 
L119:   iushr 
L120:   iaload 
L121:   iload 15 
L123:   bipush 31 
L125:   iand 
L126:   iushr 
L127:   istore 16 
L129:   iload 14 
L131:   iload 16 
L133:   iconst_1 
L134:   iushr 
L135:   ixor 
L136:   istore 14 
L138:   iload 14 
L140:   iconst_1 
L141:   ishl 
L142:   istore 14 
L144:   iload 14 
L146:   iload 16 
L148:   ixor 
L149:   istore 14 
L151:   iload 15 
L153:   iload 8 
L155:   isub 
L156:   istore 15 
L158:   goto L109 

        .stack chop 1 
L161:   aload 6 
L163:   iload 14 
L165:   invokeinterface InterfaceMethod ECLookupTable lookup (I)LECPoint; 2 
L170:   astore 15 
L172:   aload 9 
L174:   aload 15 
L176:   invokevirtual Method ECPoint twicePlus (LECPoint;)LECPoint; 
L179:   astore 9 
L181:   iinc 13 1 
L184:   goto L92 

        .stack chop 2 
L187:   aload 9 
L189:   aload 5 
L191:   invokevirtual Method FixedPointPreCompInfo getOffset ()LECPoint; 
L194:   invokevirtual Method ECPoint add (LECPoint;)LECPoint; 
L197:   areturn 
L198:   
        .linenumbertable 
            L0 7 
            L5 8 
            L11 10 
            L20 13 
            L30 16 
            L36 17 
            L43 18 
            L50 20 
            L62 22 
            L68 24 
            L75 25 
            L83 27 
            L89 28 
            L99 30 
            L102 32 
            L114 34 
            L129 35 
            L138 36 
            L144 37 
            L151 32 
            L161 40 
            L172 42 
            L181 28 
            L187 45 
        .end linenumbertable 
        .localvariabletable 
            16 is secretBit I from L129 to L151 
            15 is j I from L109 to L161 
            14 is secretIndex I from L102 to L181 
            15 is add LECPoint; from L172 to L181 
            13 is i I from L92 to L187 
            0 is this LFixedPointCombMultiplier; from L0 to L198 
            1 is p LECPoint; from L0 to L198 
            2 is k Ljava/math/BigInteger; from L0 to L198 
            3 is c LECCurve; from L5 to L198 
            4 is size I from L11 to L198 
            5 is info LFixedPointPreCompInfo; from L36 to L198 
            6 is lookupTable LECLookupTable; from L43 to L198 
            7 is width I from L50 to L198 
            8 is d I from L62 to L198 
            9 is R LECPoint; from L68 to L198 
            10 is fullComb I from L75 to L198 
            11 is K [I from L83 to L198 
            12 is top I from L89 to L198 
        .end localvariabletable 
    .end code 
    .exceptions java/lang/CloneNotSupportedException 
.end method 

.method public bridge synthetic multiply : (LECPoint;Ljava/math/BigInteger;)LECPoint; 
    .code stack 3 locals 3 
L0:     aload_0 
L1:     aload_1 
L2:     aload_2 
L3:     invokespecial Method AbstractECMultiplier multiply (LECPoint;Ljava/math/BigInteger;)LECPoint; 
L6:     areturn 
L7:     
        .linenumbertable 
            L0 3 
        .end linenumbertable 
        .localvariabletable 
            0 is this LFixedPointCombMultiplier; from L0 to L7 
            1 is x0 LECPoint; from L0 to L7 
            2 is x1 Ljava/math/BigInteger; from L0 to L7 
        .end localvariabletable 
    .end code 
    .exceptions java/lang/CloneNotSupportedException 
.end method 
.sourcefile 'FixedPointCombMultiplier.java' 
.end class 
