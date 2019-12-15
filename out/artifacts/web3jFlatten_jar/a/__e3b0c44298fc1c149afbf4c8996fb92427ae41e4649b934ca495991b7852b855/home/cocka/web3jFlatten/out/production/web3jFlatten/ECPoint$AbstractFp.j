.version 52 0 
.class public super abstract ECPoint$AbstractFp 
.super ECPoint 

.method <init> : (LECCurve;LECFieldElement;LECFieldElement;)V 
    .code stack 4 locals 4 
L0:     aload_0 
L1:     aload_1 
L2:     aload_2 
L3:     aload_3 
L4:     invokespecial Method ECPoint <init> (LECCurve;LECFieldElement;LECFieldElement;)V 
L7:     return 
L8:     
        .linenumbertable 
            L0 423 
            L7 424 
        .end linenumbertable 
        .localvariabletable 
            0 is this LECPoint$AbstractFp; from L0 to L8 
            1 is curve LECCurve; from L0 to L8 
            2 is x LECFieldElement; from L0 to L8 
            3 is y LECFieldElement; from L0 to L8 
        .end localvariabletable 
    .end code 
.end method 

.method <init> : (LECCurve;LECFieldElement;LECFieldElement;[LECFieldElement;)V 
    .code stack 5 locals 5 
L0:     aload_0 
L1:     aload_1 
L2:     aload_2 
L3:     aload_3 
L4:     aload 4 
L6:     invokespecial Method ECPoint <init> (LECCurve;LECFieldElement;LECFieldElement;[LECFieldElement;)V 
L9:     return 
L10:    
        .linenumbertable 
            L0 428 
            L9 429 
        .end linenumbertable 
        .localvariabletable 
            0 is this LECPoint$AbstractFp; from L0 to L10 
            1 is curve LECCurve; from L0 to L10 
            2 is x LECFieldElement; from L0 to L10 
            3 is y LECFieldElement; from L0 to L10 
            4 is zs [LECFieldElement; from L0 to L10 
        .end localvariabletable 
    .end code 
.end method 

.method protected getCompressionYTilde : ()Z 
    .code stack 1 locals 1 
L0:     aload_0 
L1:     invokevirtual Method ECPoint$AbstractFp getAffineYCoord ()LECFieldElement; 
L4:     invokevirtual Method ECFieldElement testBitZero ()Z 
L7:     ireturn 
L8:     
        .linenumbertable 
            L0 432 
        .end linenumbertable 
        .localvariabletable 
            0 is this LECPoint$AbstractFp; from L0 to L8 
        .end localvariabletable 
    .end code 
    .exceptions java/lang/CloneNotSupportedException 
.end method 

.method protected satisfiesCurveEquation : ()Z 
    .code stack 3 locals 9 
L0:     aload_0 
L1:     getfield Field ECPoint$AbstractFp x LECFieldElement; 
L4:     astore_1 
L5:     aload_0 
L6:     getfield Field ECPoint$AbstractFp curve LECCurve; 
L9:     invokevirtual Method ECCurve getA ()LECFieldElement; 
L12:    astore_2 
L13:    aload_0 
L14:    getfield Field ECPoint$AbstractFp curve LECCurve; 
L17:    invokevirtual Method ECCurve getB ()LECFieldElement; 
L20:    astore_3 
L21:    aload_0 
L22:    getfield Field ECPoint$AbstractFp y LECFieldElement; 
L25:    invokevirtual Method ECFieldElement square ()LECFieldElement; 
L28:    astore 4 
L30:    aload_0 
L31:    invokevirtual Method ECPoint$AbstractFp getCurveCoordinateSystem ()I 
L34:    tableswitch 0 
            L68 
            L71 
            L129 
            L129 
            L129 
            default : L185 


        .stack full 
            locals Object ECPoint$AbstractFp Object ECFieldElement Object ECFieldElement Object ECFieldElement Object ECFieldElement 
            stack 
        .end stack 
L68:    goto L195 

        .stack same 
L71:    aload_0 
L72:    getfield Field ECPoint$AbstractFp zs [LECFieldElement; 
L75:    iconst_0 
L76:    aaload 
L77:    astore 5 
L79:    aload 5 
L81:    invokevirtual Method ECFieldElement isOne ()Z 
L84:    ifne L195 
L87:    aload 5 
L89:    invokevirtual Method ECFieldElement square ()LECFieldElement; 
L92:    astore 6 
L94:    aload 5 
L96:    aload 6 
L98:    invokevirtual Method ECFieldElement multiply (LECFieldElement;)LECFieldElement; 
L101:   astore 7 
L103:   aload 4 
L105:   aload 5 
L107:   invokevirtual Method ECFieldElement multiply (LECFieldElement;)LECFieldElement; 
L110:   astore 4 
L112:   aload_2 
L113:   aload 6 
L115:   invokevirtual Method ECFieldElement multiply (LECFieldElement;)LECFieldElement; 
L118:   astore_2 
L119:   aload_3 
L120:   aload 7 
L122:   invokevirtual Method ECFieldElement multiply (LECFieldElement;)LECFieldElement; 
L125:   astore_3 
L126:   goto L195 

        .stack same 
L129:   aload_0 
L130:   getfield Field ECPoint$AbstractFp zs [LECFieldElement; 
L133:   iconst_0 
L134:   aaload 
L135:   astore 5 
L137:   aload 5 
L139:   invokevirtual Method ECFieldElement isOne ()Z 
L142:   ifne L195 
L145:   aload 5 
L147:   invokevirtual Method ECFieldElement square ()LECFieldElement; 
L150:   astore 6 
L152:   aload 6 
L154:   invokevirtual Method ECFieldElement square ()LECFieldElement; 
L157:   astore 7 
L159:   aload 6 
L161:   aload 7 
L163:   invokevirtual Method ECFieldElement multiply (LECFieldElement;)LECFieldElement; 
L166:   astore 8 
L168:   aload_2 
L169:   aload 7 
L171:   invokevirtual Method ECFieldElement multiply (LECFieldElement;)LECFieldElement; 
L174:   astore_2 
L175:   aload_3 
L176:   aload 8 
L178:   invokevirtual Method ECFieldElement multiply (LECFieldElement;)LECFieldElement; 
L181:   astore_3 
L182:   goto L195 

        .stack same 
L185:   new java/lang/IllegalStateException 
L188:   dup 
L189:   ldc 'unsupported coordinate system' 
L191:   invokespecial Method java/lang/IllegalStateException <init> (Ljava/lang/String;)V 
L194:   athrow 

        .stack same 
L195:   aload_1 
L196:   invokevirtual Method ECFieldElement square ()LECFieldElement; 
L199:   aload_2 
L200:   invokevirtual Method ECFieldElement add (LECFieldElement;)LECFieldElement; 
L203:   aload_1 
L204:   invokevirtual Method ECFieldElement multiply (LECFieldElement;)LECFieldElement; 
L207:   aload_3 
L208:   invokevirtual Method ECFieldElement add (LECFieldElement;)LECFieldElement; 
L211:   astore 5 
L213:   aload 4 
L215:   aload 5 
L217:   invokevirtual Method java/lang/Object equals (Ljava/lang/Object;)Z 
L220:   ireturn 
L221:   
        .linenumbertable 
            L0 436 
            L21 437 
            L30 439 
            L68 442 
            L71 445 
            L79 446 
            L87 448 
            L103 449 
            L112 450 
            L119 451 
            L126 452 
            L129 459 
            L137 460 
            L145 462 
            L168 463 
            L175 464 
            L182 465 
            L185 469 
            L195 472 
            L213 473 
        .end linenumbertable 
        .localvariabletable 
            6 is Z2 LECFieldElement; from L94 to L126 
            7 is Z3 LECFieldElement; from L103 to L126 
            5 is Z LECFieldElement; from L79 to L129 
            6 is Z2 LECFieldElement; from L152 to L182 
            7 is Z4 LECFieldElement; from L159 to L182 
            8 is Z6 LECFieldElement; from L168 to L182 
            5 is Z LECFieldElement; from L137 to L185 
            0 is this LECPoint$AbstractFp; from L0 to L221 
            1 is X LECFieldElement; from L5 to L221 
            2 is A LECFieldElement; from L13 to L221 
            3 is B LECFieldElement; from L21 to L221 
            4 is lhs LECFieldElement; from L30 to L221 
            5 is rhs LECFieldElement; from L213 to L221 
        .end localvariabletable 
    .end code 
.end method 

.method public subtract : (LECPoint;)LECPoint; 
    .code stack 2 locals 2 
L0:     aload_1 
L1:     invokevirtual Method ECPoint isInfinity ()Z 
L4:     ifeq L9 
L7:     aload_0 
L8:     areturn 

        .stack same 
L9:     aload_0 
L10:    aload_1 
L11:    invokevirtual Method ECPoint negate ()LECPoint; 
L14:    invokevirtual Method ECPoint$AbstractFp add (LECPoint;)LECPoint; 
L17:    areturn 
L18:    
        .linenumbertable 
            L0 477 
            L7 479 
            L9 483 
        .end linenumbertable 
        .localvariabletable 
            0 is this LECPoint$AbstractFp; from L0 to L18 
            1 is b LECPoint; from L0 to L18 
        .end localvariabletable 
    .end code 
    .exceptions java/lang/CloneNotSupportedException 
.end method 
.sourcefile 'ECPoint.java' 
.innerclasses 
    ECPoint$AbstractFp ECPoint AbstractFp public static abstract 
.end innerclasses 
.end class 
