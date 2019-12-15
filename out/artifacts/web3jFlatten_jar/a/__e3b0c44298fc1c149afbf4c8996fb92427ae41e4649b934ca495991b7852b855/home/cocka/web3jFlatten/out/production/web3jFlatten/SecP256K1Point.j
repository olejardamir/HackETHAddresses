.version 52 0 
.class public super SecP256K1Point 
.super ECPoint$AbstractFp 

.method public <init> : (LECCurve;LECFieldElement;LECFieldElement;)V 
    .code stack 5 locals 4 
L0:     aload_0 
L1:     aload_1 
L2:     aload_2 
L3:     aload_3 
L4:     iconst_0 
L5:     invokespecial Method SecP256K1Point <init> (LECCurve;LECFieldElement;LECFieldElement;Z)V 
L8:     return 
L9:     
        .linenumbertable 
            L0 7 
            L8 8 
        .end linenumbertable 
        .localvariabletable 
            0 is this LSecP256K1Point; from L0 to L9 
            1 is curve LECCurve; from L0 to L9 
            2 is x LECFieldElement; from L0 to L9 
            3 is y LECFieldElement; from L0 to L9 
        .end localvariabletable 
    .end code 
.end method 

.method public <init> : (LECCurve;LECFieldElement;LECFieldElement;Z)V 
    .code stack 4 locals 5 
L0:     aload_0 
L1:     aload_1 
L2:     aload_2 
L3:     aload_3 
L4:     invokespecial Method ECPoint$AbstractFp <init> (LECCurve;LECFieldElement;LECFieldElement;)V 
L7:     aload_2 
L8:     ifnonnull L15 
L11:    iconst_1 
L12:    goto L16 

        .stack full 
            locals Object SecP256K1Point Object ECCurve Object ECFieldElement Object ECFieldElement Integer 
            stack 
        .end stack 
L15:    iconst_0 

        .stack stack_1 Integer 
L16:    aload_3 
L17:    ifnonnull L24 
L20:    iconst_1 
L21:    goto L25 

        .stack stack_1 Integer 
L24:    iconst_0 

        .stack full 
            locals Object SecP256K1Point Object ECCurve Object ECFieldElement Object ECFieldElement Integer 
            stack Integer Integer 
        .end stack 
L25:    if_icmpeq L38 
L28:    new java/lang/IllegalArgumentException 
L31:    dup 
L32:    ldc 'Exactly one of the field elements is null' 
L34:    invokespecial Method java/lang/IllegalArgumentException <init> (Ljava/lang/String;)V 
L37:    athrow 

        .stack same 
L38:    aload_0 
L39:    iload 4 
L41:    putfield Field SecP256K1Point withCompression Z 
L44:    return 
L45:    
        .linenumbertable 
            L0 14 
            L7 16 
            L28 18 
            L38 21 
            L44 22 
        .end linenumbertable 
        .localvariabletable 
            0 is this LSecP256K1Point; from L0 to L45 
            1 is curve LECCurve; from L0 to L45 
            2 is x LECFieldElement; from L0 to L45 
            3 is y LECFieldElement; from L0 to L45 
            4 is withCompression Z from L0 to L45 
        .end localvariabletable 
    .end code 
.end method 

.method <init> : (LECCurve;LECFieldElement;LECFieldElement;[LECFieldElement;Z)V 
    .code stack 5 locals 6 
L0:     aload_0 
L1:     aload_1 
L2:     aload_2 
L3:     aload_3 
L4:     aload 4 
L6:     invokespecial Method ECPoint$AbstractFp <init> (LECCurve;LECFieldElement;LECFieldElement;[LECFieldElement;)V 
L9:     aload_0 
L10:    iload 5 
L12:    putfield Field SecP256K1Point withCompression Z 
L15:    return 
L16:    
        .linenumbertable 
            L0 27 
            L9 29 
            L15 30 
        .end linenumbertable 
        .localvariabletable 
            0 is this LSecP256K1Point; from L0 to L16 
            1 is curve LECCurve; from L0 to L16 
            2 is x LECFieldElement; from L0 to L16 
            3 is y LECFieldElement; from L0 to L16 
            4 is zs [LECFieldElement; from L0 to L16 
            5 is withCompression Z from L0 to L16 
        .end localvariabletable 
    .end code 
.end method 

.method public add : (LECPoint;)LECPoint; 
    .code stack 7 locals 26 
L0:     aload_0 
L1:     invokevirtual Method SecP256K1Point isInfinity ()Z 
L4:     ifeq L9 
L7:     aload_1 
L8:     areturn 

        .stack same 
L9:     aload_1 
L10:    invokevirtual Method ECPoint isInfinity ()Z 
L13:    ifeq L18 
L16:    aload_0 
L17:    areturn 

        .stack same 
L18:    aload_0 
L19:    aload_1 
L20:    if_acmpne L28 
L23:    aload_0 
L24:    invokevirtual Method SecP256K1Point twice ()LECPoint; 
L27:    areturn 

        .stack same 
L28:    aload_0 
L29:    invokevirtual Method SecP256K1Point getCurve ()LECCurve; 
L32:    astore_2 
L33:    aload_0 
L34:    getfield Field SecP256K1Point x LECFieldElement; 
L37:    checkcast SecP256K1FieldElement 
L40:    astore_3 
L41:    aload_0 
L42:    getfield Field SecP256K1Point y LECFieldElement; 
L45:    checkcast SecP256K1FieldElement 
L48:    astore 4 
L50:    aload_1 
L51:    invokevirtual Method ECPoint getXCoord ()LECFieldElement; 
L54:    checkcast SecP256K1FieldElement 
L57:    astore 5 
L59:    aload_1 
L60:    invokevirtual Method ECPoint getYCoord ()LECFieldElement; 
L63:    checkcast SecP256K1FieldElement 
L66:    astore 6 
L68:    aload_0 
L69:    getfield Field SecP256K1Point zs [LECFieldElement; 
L72:    iconst_0 
L73:    aaload 
L74:    checkcast SecP256K1FieldElement 
L77:    astore 7 
L79:    aload_1 
L80:    iconst_0 
L81:    invokevirtual Method ECPoint getZCoord (I)LECFieldElement; 
L84:    checkcast SecP256K1FieldElement 
L87:    astore 8 
L89:    invokestatic Method Nat256 createExt ()[I 
L92:    astore 10 
L94:    invokestatic Method Nat256 create ()[I 
L97:    astore 11 
L99:    invokestatic Method Nat256 create ()[I 
L102:   astore 12 
L104:   invokestatic Method Nat256 create ()[I 
L107:   astore 13 
L109:   aload 7 
L111:   invokevirtual Method SecP256K1FieldElement isOne ()Z 
L114:   istore 14 
L116:   iload 14 
L118:   ifeq L138 
L121:   aload 5 
L123:   getfield Field SecP256K1FieldElement x [I 
L126:   astore 15 
L128:   aload 6 
L130:   getfield Field SecP256K1FieldElement x [I 
L133:   astore 16 
L135:   goto L192 

        .stack full 
            locals Object SecP256K1Point Object ECPoint Object ECCurve Object SecP256K1FieldElement Object SecP256K1FieldElement Object SecP256K1FieldElement Object SecP256K1FieldElement Object SecP256K1FieldElement Object SecP256K1FieldElement Top Object [I Object [I Object [I Object [I Integer 
            stack 
        .end stack 
L138:   aload 12 
L140:   astore 16 
L142:   aload 7 
L144:   getfield Field SecP256K1FieldElement x [I 
L147:   aload 16 
L149:   invokestatic Method SecP256K1Field square ([I[I)V 
L152:   aload 11 
L154:   astore 15 
L156:   aload 16 
L158:   aload 5 
L160:   getfield Field SecP256K1FieldElement x [I 
L163:   aload 15 
L165:   invokestatic Method SecP256K1Field multiply ([I[I[I)V 
L168:   aload 16 
L170:   aload 7 
L172:   getfield Field SecP256K1FieldElement x [I 
L175:   aload 16 
L177:   invokestatic Method SecP256K1Field multiply ([I[I[I)V 
L180:   aload 16 
L182:   aload 6 
L184:   getfield Field SecP256K1FieldElement x [I 
L187:   aload 16 
L189:   invokestatic Method SecP256K1Field multiply ([I[I[I)V 

        .stack append Object [I Object [I 
L192:   aload 8 
L194:   invokevirtual Method SecP256K1FieldElement isOne ()Z 
L197:   istore 17 
L199:   iload 17 
L201:   ifeq L220 
L204:   aload_3 
L205:   getfield Field SecP256K1FieldElement x [I 
L208:   astore 18 
L210:   aload 4 
L212:   getfield Field SecP256K1FieldElement x [I 
L215:   astore 19 
L217:   goto L273 

        .stack append Integer 
L220:   aload 13 
L222:   astore 19 
L224:   aload 8 
L226:   getfield Field SecP256K1FieldElement x [I 
L229:   aload 19 
L231:   invokestatic Method SecP256K1Field square ([I[I)V 
L234:   aload 10 
L236:   astore 18 
L238:   aload 19 
L240:   aload_3 
L241:   getfield Field SecP256K1FieldElement x [I 
L244:   aload 18 
L246:   invokestatic Method SecP256K1Field multiply ([I[I[I)V 
L249:   aload 19 
L251:   aload 8 
L253:   getfield Field SecP256K1FieldElement x [I 
L256:   aload 19 
L258:   invokestatic Method SecP256K1Field multiply ([I[I[I)V 
L261:   aload 19 
L263:   aload 4 
L265:   getfield Field SecP256K1FieldElement x [I 
L268:   aload 19 
L270:   invokestatic Method SecP256K1Field multiply ([I[I[I)V 

        .stack append Object [I Object [I 
L273:   invokestatic Method Nat256 create ()[I 
L276:   astore 20 
L278:   aload 18 
L280:   aload 15 
L282:   aload 20 
L284:   invokestatic Method SecP256K1Field subtract ([I[I[I)V 
L287:   aload 19 
L289:   aload 16 
L291:   aload 11 
L293:   invokestatic Method SecP256K1Field subtract ([I[I[I)V 
L296:   aload 20 
L298:   invokestatic Method Nat256 isZero ([I)Z 
L301:   ifeq L322 
L304:   aload 11 
L306:   invokestatic Method Nat256 isZero ([I)Z 
L309:   ifeq L317 
L312:   aload_0 
L313:   invokevirtual Method SecP256K1Point twice ()LECPoint; 
L316:   areturn 

        .stack append Object [I 
L317:   aload_2 
L318:   invokevirtual Method ECCurve getInfinity ()LECPoint; 
L321:   areturn 

        .stack same 
L322:   aload 20 
L324:   aload 12 
L326:   invokestatic Method SecP256K1Field square ([I[I)V 
L329:   invokestatic Method Nat256 create ()[I 
L332:   astore 21 
L334:   aload 12 
L336:   aload 20 
L338:   aload 21 
L340:   invokestatic Method SecP256K1Field multiply ([I[I[I)V 
L343:   aload 12 
L345:   aload 18 
L347:   aload 12 
L349:   invokestatic Method SecP256K1Field multiply ([I[I[I)V 
L352:   aload 21 
L354:   aload 21 
L356:   invokestatic Method SecP256K1Field negate ([I[I)V 
L359:   aload 19 
L361:   aload 21 
L363:   aload 10 
L365:   invokestatic Method Nat256 mul ([I[I[I)V 
L368:   aload 12 
L370:   aload 12 
L372:   aload 21 
L374:   invokestatic Method Nat256 addBothTo ([I[I[I)I 
L377:   istore 9 
L379:   iload 9 
L381:   aload 21 
L383:   invokestatic Method SecP256K1Field reduce32 (I[I)V 
L386:   new SecP256K1FieldElement 
L389:   dup 
L390:   aload 13 
L392:   invokespecial Method SecP256K1FieldElement <init> ([I)V 
L395:   astore 22 
L397:   aload 11 
L399:   aload 22 
L401:   getfield Field SecP256K1FieldElement x [I 
L404:   invokestatic Method SecP256K1Field square ([I[I)V 
L407:   aload 22 
L409:   getfield Field SecP256K1FieldElement x [I 
L412:   aload 21 
L414:   aload 22 
L416:   getfield Field SecP256K1FieldElement x [I 
L419:   invokestatic Method SecP256K1Field subtract ([I[I[I)V 
L422:   new SecP256K1FieldElement 
L425:   dup 
L426:   aload 21 
L428:   invokespecial Method SecP256K1FieldElement <init> ([I)V 
L431:   astore 23 
L433:   aload 12 
L435:   aload 22 
L437:   getfield Field SecP256K1FieldElement x [I 
L440:   aload 23 
L442:   getfield Field SecP256K1FieldElement x [I 
L445:   invokestatic Method SecP256K1Field subtract ([I[I[I)V 
L448:   aload 23 
L450:   getfield Field SecP256K1FieldElement x [I 
L453:   aload 11 
L455:   aload 10 
L457:   invokestatic Method SecP256K1Field multiplyAddToExt ([I[I[I)V 
L460:   aload 10 
L462:   aload 23 
L464:   getfield Field SecP256K1FieldElement x [I 
L467:   invokestatic Method SecP256K1Field reduce ([I[I)V 
L470:   new SecP256K1FieldElement 
L473:   dup 
L474:   aload 20 
L476:   invokespecial Method SecP256K1FieldElement <init> ([I)V 
L479:   astore 24 
L481:   iload 14 
L483:   ifne L504 
L486:   aload 24 
L488:   getfield Field SecP256K1FieldElement x [I 
L491:   aload 7 
L493:   getfield Field SecP256K1FieldElement x [I 
L496:   aload 24 
L498:   getfield Field SecP256K1FieldElement x [I 
L501:   invokestatic Method SecP256K1Field multiply ([I[I[I)V 

        .stack full 
            locals Object SecP256K1Point Object ECPoint Object ECCurve Object SecP256K1FieldElement Object SecP256K1FieldElement Object SecP256K1FieldElement Object SecP256K1FieldElement Object SecP256K1FieldElement Object SecP256K1FieldElement Integer Object [I Object [I Object [I Object [I Integer Object [I Object [I Integer Object [I Object [I Object [I Object [I Object SecP256K1FieldElement Object SecP256K1FieldElement Object SecP256K1FieldElement 
            stack 
        .end stack 
L504:   iload 17 
L506:   ifne L527 
L509:   aload 24 
L511:   getfield Field SecP256K1FieldElement x [I 
L514:   aload 8 
L516:   getfield Field SecP256K1FieldElement x [I 
L519:   aload 24 
L521:   getfield Field SecP256K1FieldElement x [I 
L524:   invokestatic Method SecP256K1Field multiply ([I[I[I)V 

        .stack same 
L527:   iconst_1 
L528:   anewarray ECFieldElement 
L531:   dup 
L532:   iconst_0 
L533:   aload 24 
L535:   aastore 
L536:   astore 25 
L538:   new SecP256K1Point 
L541:   dup 
L542:   aload_2 
L543:   aload 22 
L545:   aload 23 
L547:   aload 25 
L549:   aload_0 
L550:   getfield Field SecP256K1Point withCompression Z 
L553:   invokespecial Method SecP256K1Point <init> (LECCurve;LECFieldElement;LECFieldElement;[LECFieldElement;Z)V 
L556:   areturn 
L557:   
        .linenumbertable 
            L0 33 
            L7 35 
            L9 37 
            L16 39 
            L18 41 
            L23 43 
            L28 46 
            L33 48 
            L50 49 
            L68 51 
            L79 52 
            L89 55 
            L94 56 
            L99 57 
            L104 58 
            L109 60 
            L116 62 
            L121 64 
            L128 65 
            L138 69 
            L142 70 
            L152 72 
            L156 73 
            L168 75 
            L180 76 
            L192 79 
            L199 81 
            L204 83 
            L210 84 
            L220 88 
            L224 89 
            L234 91 
            L238 92 
            L249 94 
            L261 95 
            L273 98 
            L278 99 
            L287 101 
            L296 104 
            L304 106 
            L312 109 
            L317 113 
            L322 116 
            L329 118 
            L334 119 
            L343 121 
            L352 123 
            L359 124 
            L368 126 
            L379 127 
            L386 129 
            L397 130 
            L407 131 
            L422 133 
            L433 134 
            L448 135 
            L460 136 
            L470 138 
            L481 139 
            L486 141 
            L504 143 
            L509 145 
            L527 148 
            L538 150 
        .end linenumbertable 
        .localvariabletable 
            15 is U2 [I from L128 to L138 
            16 is S2 [I from L135 to L138 
            18 is U1 [I from L210 to L220 
            19 is S1 [I from L217 to L220 
            0 is this LSecP256K1Point; from L0 to L557 
            1 is b LECPoint; from L0 to L557 
            2 is curve LECCurve; from L33 to L557 
            3 is X1 LSecP256K1FieldElement; from L41 to L557 
            4 is Y1 LSecP256K1FieldElement; from L50 to L557 
            5 is X2 LSecP256K1FieldElement; from L59 to L557 
            6 is Y2 LSecP256K1FieldElement; from L68 to L557 
            7 is Z1 LSecP256K1FieldElement; from L79 to L557 
            8 is Z2 LSecP256K1FieldElement; from L89 to L557 
            9 is c I from L379 to L557 
            10 is tt1 [I from L94 to L557 
            11 is t2 [I from L99 to L557 
            12 is t3 [I from L104 to L557 
            13 is t4 [I from L109 to L557 
            14 is Z1IsOne Z from L116 to L557 
            15 is U2 [I from L156 to L557 
            16 is S2 [I from L142 to L557 
            17 is Z2IsOne Z from L199 to L557 
            18 is U1 [I from L238 to L557 
            19 is S1 [I from L224 to L557 
            20 is H [I from L278 to L557 
            21 is G [I from L334 to L557 
            22 is X3 LSecP256K1FieldElement; from L397 to L557 
            23 is Y3 LSecP256K1FieldElement; from L433 to L557 
            24 is Z3 LSecP256K1FieldElement; from L481 to L557 
            25 is zs [LECFieldElement; from L538 to L557 
        .end localvariabletable 
    .end code 
.end method 

.method public twice : ()LECPoint; 
    .code stack 9 locals 13 
L0:     aload_0 
L1:     invokevirtual Method SecP256K1Point isInfinity ()Z 
L4:     ifeq L9 
L7:     aload_0 
L8:     areturn 

        .stack same 
L9:     aload_0 
L10:    invokevirtual Method SecP256K1Point getCurve ()LECCurve; 
L13:    astore_1 
L14:    aload_0 
L15:    getfield Field SecP256K1Point y LECFieldElement; 
L18:    checkcast SecP256K1FieldElement 
L21:    astore_2 
L22:    aload_2 
L23:    invokevirtual Method SecP256K1FieldElement isZero ()Z 
L26:    ifeq L34 
L29:    aload_1 
L30:    invokevirtual Method ECCurve getInfinity ()LECPoint; 
L33:    areturn 

        .stack append Object ECCurve Object SecP256K1FieldElement 
L34:    aload_0 
L35:    getfield Field SecP256K1Point x LECFieldElement; 
L38:    checkcast SecP256K1FieldElement 
L41:    astore_3 
L42:    aload_0 
L43:    getfield Field SecP256K1Point zs [LECFieldElement; 
L46:    iconst_0 
L47:    aaload 
L48:    checkcast SecP256K1FieldElement 
L51:    astore 4 
L53:    invokestatic Method Nat256 create ()[I 
L56:    astore 6 
L58:    aload_2 
L59:    getfield Field SecP256K1FieldElement x [I 
L62:    aload 6 
L64:    invokestatic Method SecP256K1Field square ([I[I)V 
L67:    invokestatic Method Nat256 create ()[I 
L70:    astore 7 
L72:    aload 6 
L74:    aload 7 
L76:    invokestatic Method SecP256K1Field square ([I[I)V 
L79:    invokestatic Method Nat256 create ()[I 
L82:    astore 8 
L84:    aload_3 
L85:    getfield Field SecP256K1FieldElement x [I 
L88:    aload 8 
L90:    invokestatic Method SecP256K1Field square ([I[I)V 
L93:    aload 8 
L95:    aload 8 
L97:    aload 8 
L99:    invokestatic Method Nat256 addBothTo ([I[I[I)I 
L102:   istore 5 
L104:   iload 5 
L106:   aload 8 
L108:   invokestatic Method SecP256K1Field reduce32 (I[I)V 
L111:   aload 6 
L113:   aload_3 
L114:   getfield Field SecP256K1FieldElement x [I 
L117:   aload 6 
L119:   invokestatic Method SecP256K1Field multiply ([I[I[I)V 
L122:   bipush 8 
L124:   aload 6 
L126:   iconst_2 
L127:   iconst_0 
L128:   invokestatic Method Nat shiftUpBits (I[III)I 
L131:   istore 5 
L133:   iload 5 
L135:   aload 6 
L137:   invokestatic Method SecP256K1Field reduce32 (I[I)V 
L140:   invokestatic Method Nat256 create ()[I 
L143:   astore 9 
L145:   bipush 8 
L147:   aload 7 
L149:   iconst_3 
L150:   iconst_0 
L151:   aload 9 
L153:   invokestatic Method Nat shiftUpBits (I[III[I)I 
L156:   istore 5 
L158:   iload 5 
L160:   aload 9 
L162:   invokestatic Method SecP256K1Field reduce32 (I[I)V 
L165:   new SecP256K1FieldElement 
L168:   dup 
L169:   aload 7 
L171:   invokespecial Method SecP256K1FieldElement <init> ([I)V 
L174:   astore 10 
L176:   aload 8 
L178:   aload 10 
L180:   getfield Field SecP256K1FieldElement x [I 
L183:   invokestatic Method SecP256K1Field square ([I[I)V 
L186:   aload 10 
L188:   getfield Field SecP256K1FieldElement x [I 
L191:   aload 6 
L193:   aload 10 
L195:   getfield Field SecP256K1FieldElement x [I 
L198:   invokestatic Method SecP256K1Field subtract ([I[I[I)V 
L201:   aload 10 
L203:   getfield Field SecP256K1FieldElement x [I 
L206:   aload 6 
L208:   aload 10 
L210:   getfield Field SecP256K1FieldElement x [I 
L213:   invokestatic Method SecP256K1Field subtract ([I[I[I)V 
L216:   new SecP256K1FieldElement 
L219:   dup 
L220:   aload 6 
L222:   invokespecial Method SecP256K1FieldElement <init> ([I)V 
L225:   astore 11 
L227:   aload 6 
L229:   aload 10 
L231:   getfield Field SecP256K1FieldElement x [I 
L234:   aload 11 
L236:   getfield Field SecP256K1FieldElement x [I 
L239:   invokestatic Method SecP256K1Field subtract ([I[I[I)V 
L242:   aload 11 
L244:   getfield Field SecP256K1FieldElement x [I 
L247:   aload 8 
L249:   aload 11 
L251:   getfield Field SecP256K1FieldElement x [I 
L254:   invokestatic Method SecP256K1Field multiply ([I[I[I)V 
L257:   aload 11 
L259:   getfield Field SecP256K1FieldElement x [I 
L262:   aload 9 
L264:   aload 11 
L266:   getfield Field SecP256K1FieldElement x [I 
L269:   invokestatic Method SecP256K1Field subtract ([I[I[I)V 
L272:   new SecP256K1FieldElement 
L275:   dup 
L276:   aload 8 
L278:   invokespecial Method SecP256K1FieldElement <init> ([I)V 
L281:   astore 12 
L283:   aload_2 
L284:   getfield Field SecP256K1FieldElement x [I 
L287:   aload 12 
L289:   getfield Field SecP256K1FieldElement x [I 
L292:   invokestatic Method SecP256K1Field twice ([I[I)V 
L295:   aload 4 
L297:   invokevirtual Method SecP256K1FieldElement isOne ()Z 
L300:   ifne L321 
L303:   aload 12 
L305:   getfield Field SecP256K1FieldElement x [I 
L308:   aload 4 
L310:   getfield Field SecP256K1FieldElement x [I 
L313:   aload 12 
L315:   getfield Field SecP256K1FieldElement x [I 
L318:   invokestatic Method SecP256K1Field multiply ([I[I[I)V 

        .stack full 
            locals Object SecP256K1Point Object ECCurve Object SecP256K1FieldElement Object SecP256K1FieldElement Object SecP256K1FieldElement Integer Object [I Object [I Object [I Object [I Object SecP256K1FieldElement Object SecP256K1FieldElement Object SecP256K1FieldElement 
            stack 
        .end stack 
L321:   new SecP256K1Point 
L324:   dup 
L325:   aload_1 
L326:   aload 10 
L328:   aload 11 
L330:   iconst_1 
L331:   anewarray ECFieldElement 
L334:   dup 
L335:   iconst_0 
L336:   aload 12 
L338:   aastore 
L339:   aload_0 
L340:   getfield Field SecP256K1Point withCompression Z 
L343:   invokespecial Method SecP256K1Point <init> (LECCurve;LECFieldElement;LECFieldElement;[LECFieldElement;Z)V 
L346:   areturn 
L347:   
        .linenumbertable 
            L0 156 
            L7 158 
            L9 161 
            L14 163 
            L22 164 
            L29 166 
            L34 169 
            L53 173 
            L58 174 
            L67 176 
            L72 177 
            L79 179 
            L84 180 
            L93 181 
            L104 182 
            L111 184 
            L122 185 
            L133 186 
            L140 188 
            L145 189 
            L158 190 
            L165 192 
            L176 193 
            L186 194 
            L201 195 
            L216 197 
            L227 198 
            L242 199 
            L257 200 
            L272 202 
            L283 203 
            L295 204 
            L303 206 
            L321 209 
        .end linenumbertable 
        .localvariabletable 
            0 is this LSecP256K1Point; from L0 to L347 
            1 is curve LECCurve; from L14 to L347 
            2 is Y1 LSecP256K1FieldElement; from L22 to L347 
            3 is X1 LSecP256K1FieldElement; from L42 to L347 
            4 is Z1 LSecP256K1FieldElement; from L53 to L347 
            5 is c I from L104 to L347 
            6 is Y1Squared [I from L58 to L347 
            7 is T [I from L72 to L347 
            8 is M [I from L84 to L347 
            9 is t1 [I from L145 to L347 
            10 is X3 LSecP256K1FieldElement; from L176 to L347 
            11 is Y3 LSecP256K1FieldElement; from L227 to L347 
            12 is Z3 LSecP256K1FieldElement; from L283 to L347 
        .end localvariabletable 
    .end code 
.end method 

.method public twicePlus : (LECPoint;)LECPoint; 
    .code stack 2 locals 2 
L0:     aload_0 
L1:     aload_1 
L2:     if_acmpne L10 
L5:     aload_0 
L6:     invokespecial Method SecP256K1Point threeTimes ()LECPoint; 
L9:     areturn 

        .stack same 
L10:    aload_0 
L11:    invokevirtual Method SecP256K1Point isInfinity ()Z 
L14:    ifeq L19 
L17:    aload_1 
L18:    areturn 

        .stack same 
L19:    aload_1 
L20:    invokevirtual Method ECPoint isInfinity ()Z 
L23:    ifeq L31 
L26:    aload_0 
L27:    invokevirtual Method SecP256K1Point twice ()LECPoint; 
L30:    areturn 

        .stack same 
L31:    aload_0 
L32:    getfield Field SecP256K1Point y LECFieldElement; 
L35:    invokevirtual Method ECFieldElement isZero ()Z 
L38:    ifeq L43 
L41:    aload_1 
L42:    areturn 

        .stack same 
L43:    aload_0 
L44:    invokevirtual Method SecP256K1Point twice ()LECPoint; 
L47:    aload_1 
L48:    invokevirtual Method ECPoint add (LECPoint;)LECPoint; 
L51:    areturn 
L52:    
        .linenumbertable 
            L0 213 
            L5 215 
            L10 217 
            L17 219 
            L19 221 
            L26 223 
            L31 226 
            L41 228 
            L43 231 
        .end linenumbertable 
        .localvariabletable 
            0 is this LSecP256K1Point; from L0 to L52 
            1 is b LECPoint; from L0 to L52 
        .end localvariabletable 
    .end code 
    .exceptions java/lang/CloneNotSupportedException 
.end method 

.method private threeTimes : ()LECPoint; 
    .code stack 2 locals 1 
L0:     aload_0 
L1:     invokevirtual Method SecP256K1Point isInfinity ()Z 
L4:     ifne L17 
L7:     aload_0 
L8:     getfield Field SecP256K1Point y LECFieldElement; 
L11:    invokevirtual Method ECFieldElement isZero ()Z 
L14:    ifeq L19 

        .stack same 
L17:    aload_0 
L18:    areturn 

        .stack same 
L19:    aload_0 
L20:    invokevirtual Method SecP256K1Point twice ()LECPoint; 
L23:    aload_0 
L24:    invokevirtual Method ECPoint add (LECPoint;)LECPoint; 
L27:    areturn 
L28:    
        .linenumbertable 
            L0 235 
            L17 237 
            L19 241 
        .end linenumbertable 
        .localvariabletable 
            0 is this LSecP256K1Point; from L0 to L28 
        .end localvariabletable 
    .end code 
    .exceptions java/lang/CloneNotSupportedException 
.end method 

.method public negate : ()LECPoint; 
    .code stack 7 locals 1 
L0:     aload_0 
L1:     invokevirtual Method SecP256K1Point isInfinity ()Z 
L4:     ifeq L9 
L7:     aload_0 
L8:     areturn 

        .stack same 
L9:     new SecP256K1Point 
L12:    dup 
L13:    aload_0 
L14:    getfield Field SecP256K1Point curve LECCurve; 
L17:    aload_0 
L18:    getfield Field SecP256K1Point x LECFieldElement; 
L21:    aload_0 
L22:    getfield Field SecP256K1Point y LECFieldElement; 
L25:    invokevirtual Method ECFieldElement negate ()LECFieldElement; 
L28:    aload_0 
L29:    getfield Field SecP256K1Point zs [LECFieldElement; 
L32:    aload_0 
L33:    getfield Field SecP256K1Point withCompression Z 
L36:    invokespecial Method SecP256K1Point <init> (LECCurve;LECFieldElement;LECFieldElement;[LECFieldElement;Z)V 
L39:    areturn 
L40:    
        .linenumbertable 
            L0 246 
            L7 248 
            L9 251 
        .end linenumbertable 
        .localvariabletable 
            0 is this LSecP256K1Point; from L0 to L40 
        .end localvariabletable 
    .end code 
.end method 
.sourcefile 'SecP256K1Point.java' 
.innerclasses 
    ECPoint$AbstractFp ECPoint AbstractFp public static abstract 
.end innerclasses 
.end class 
