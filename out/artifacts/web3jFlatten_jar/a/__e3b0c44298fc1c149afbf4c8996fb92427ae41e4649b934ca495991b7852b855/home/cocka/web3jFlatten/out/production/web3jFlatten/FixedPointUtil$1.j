.version 52 0 
.class final super FixedPointUtil$1 
.super java/lang/Object 
.implements PreCompCallback 
.field final synthetic val$c LECCurve; 
.field final synthetic val$p LECPoint; 

.method <init> : (LECCurve;LECPoint;)V 
    .code stack 2 locals 3 
L0:     aload_0 
L1:     aload_1 
L2:     putfield Field FixedPointUtil$1 val$c LECCurve; 
L5:     aload_0 
L6:     aload_2 
L7:     putfield Field FixedPointUtil$1 val$p LECPoint; 
L10:    aload_0 
L11:    invokespecial Method java/lang/Object <init> ()V 
L14:    return 
L15:    
        .linenumbertable 
            L0 18 
        .end linenumbertable 
        .localvariabletable 
            0 is this LFixedPointUtil$1; from L0 to L15 
        .end localvariabletable 
    .end code 
.end method 

.method public precompute : (LPreCompInfo;)LPreCompInfo; 
    .code stack 5 locals 13 
L0:     aload_1 
L1:     instanceof FixedPointPreCompInfo 
L4:     ifeq L14 
L7:     aload_1 
L8:     checkcast FixedPointPreCompInfo 
L11:    goto L15 

        .stack same 
L14:    aconst_null 

        .stack stack_1 Object FixedPointPreCompInfo 
L15:    astore_2 
L16:    aload_0 
L17:    getfield Field FixedPointUtil$1 val$c LECCurve; 
L20:    invokestatic Method FixedPointUtil getCombSize (LECCurve;)I 
L23:    istore_3 
L24:    iload_3 
L25:    sipush 250 
L28:    if_icmple L36 
L31:    bipush 6 
L33:    goto L37 

        .stack append Object FixedPointPreCompInfo Integer 
L36:    iconst_5 

        .stack stack_1 Integer 
L37:    istore 4 
L39:    iconst_1 
L40:    iload 4 
L42:    ishl 
L43:    istore 5 
L45:    aload_0 
L46:    aload_2 
L47:    iload 5 
L49:    invokespecial Method FixedPointUtil$1 checkExisting (LFixedPointPreCompInfo;I)Z 
L52:    ifeq L57 
L55:    aload_2 
L56:    areturn 

        .stack append Integer Integer 
L57:    iload_3 
L58:    iload 4 
L60:    iadd 
L61:    iconst_1 
L62:    isub 
L63:    iload 4 
L65:    idiv 
L66:    istore 6 
L68:    iload 4 
L70:    iconst_1 
L71:    iadd 
L72:    anewarray ECPoint 
L75:    astore 7 
L77:    aload 7 
L79:    iconst_0 
L80:    aload_0 
L81:    getfield Field FixedPointUtil$1 val$p LECPoint; 
L84:    aastore 
L85:    iconst_1 
L86:    istore 8 

        .stack append Integer Object [LECPoint; Integer 
L88:    iload 8 
L90:    iload 4 
L92:    if_icmpge L118 
L95:    aload 7 
L97:    iload 8 
L99:    aload 7 
L101:   iload 8 
L103:   iconst_1 
L104:   isub 
L105:   aaload 
L106:   iload 6 
L108:   invokevirtual Method ECPoint timesPow2 (I)LECPoint; 
L111:   aastore 
L112:   iinc 8 1 
L115:   goto L88 

        .stack chop 1 
L118:   aload 7 
L120:   iload 4 
L122:   aload 7 
L124:   iconst_0 
L125:   aaload 
L126:   aload 7 
L128:   iconst_1 
L129:   aaload 
L130:   invokevirtual Method ECPoint subtract (LECPoint;)LECPoint; 
L133:   aastore 
L134:   aload_0 
L135:   getfield Field FixedPointUtil$1 val$c LECCurve; 
L138:   aload 7 
L140:   invokevirtual Method ECCurve normalizeAll ([LECPoint;)V 
L143:   iload 5 
L145:   anewarray ECPoint 
L148:   astore 8 
L150:   aload 8 
L152:   iconst_0 
L153:   aload 7 
L155:   iconst_0 
L156:   aaload 
L157:   aastore 
L158:   iload 4 
L160:   iconst_1 
L161:   isub 
L162:   istore 9 

        .stack append Object [LECPoint; Integer 
L164:   iload 9 
L166:   iflt L229 
L169:   aload 7 
L171:   iload 9 
L173:   aaload 
L174:   astore 10 
L176:   iconst_1 
L177:   iload 9 
L179:   ishl 
L180:   istore 11 
L182:   iload 11 
L184:   istore 12 

        .stack append Object ECPoint Integer Integer 
L186:   iload 12 
L188:   iload 5 
L190:   if_icmpge L223 
L193:   aload 8 
L195:   iload 12 
L197:   aload 8 
L199:   iload 12 
L201:   iload 11 
L203:   isub 
L204:   aaload 
L205:   aload 10 
L207:   invokevirtual Method ECPoint add (LECPoint;)LECPoint; 
L210:   aastore 
L211:   iload 12 
L213:   iload 11 
L215:   iconst_1 
L216:   ishl 
L217:   iadd 
L218:   istore 12 
L220:   goto L186 

        .stack chop 3 
L223:   iinc 9 -1 
L226:   goto L164 

        .stack chop 1 
L229:   aload_0 
L230:   getfield Field FixedPointUtil$1 val$c LECCurve; 
L233:   aload 8 
L235:   invokevirtual Method ECCurve normalizeAll ([LECPoint;)V 
L238:   new FixedPointPreCompInfo 
L241:   dup 
L242:   invokespecial Method FixedPointPreCompInfo <init> ()V 
L245:   astore 9 
L247:   aload 9 
L249:   aload_0 
L250:   getfield Field FixedPointUtil$1 val$c LECCurve; 
L253:   aload 8 
L255:   iconst_0 
L256:   aload 8 
L258:   arraylength 
L259:   invokevirtual Method ECCurve createCacheSafeLookupTable ([LECPoint;II)LECLookupTable; 
L262:   invokevirtual Method FixedPointPreCompInfo setLookupTable (LECLookupTable;)V 
L265:   aload 9 
L267:   aload 7 
L269:   iload 4 
L271:   aaload 
L272:   invokevirtual Method FixedPointPreCompInfo setOffset (LECPoint;)V 
L275:   aload 9 
L277:   iload 4 
L279:   invokevirtual Method FixedPointPreCompInfo setWidth (I)V 
L282:   aload 9 
L284:   areturn 
L285:   
        .linenumbertable 
            L0 20 
            L16 22 
            L24 23 
            L39 24 
            L45 26 
            L55 28 
            L57 31 
            L68 33 
            L77 34 
            L85 35 
            L95 37 
            L112 35 
            L118 41 
            L134 43 
            L143 45 
            L150 46 
            L158 48 
            L169 50 
            L176 52 
            L182 53 
            L193 55 
            L211 53 
            L223 48 
            L229 59 
            L238 61 
            L247 62 
            L265 63 
            L275 64 
            L282 65 
        .end linenumbertable 
        .localvariabletable 
            8 is i I from L88 to L118 
            12 is i I from L186 to L223 
            10 is pow2 LECPoint; from L176 to L223 
            11 is step I from L182 to L223 
            9 is bit I from L164 to L229 
            0 is this LFixedPointUtil$1; from L0 to L285 
            1 is existing LPreCompInfo; from L0 to L285 
            2 is existingFP LFixedPointPreCompInfo; from L16 to L285 
            3 is bits I from L24 to L285 
            4 is minWidth I from L39 to L285 
            5 is n I from L45 to L285 
            6 is d I from L68 to L285 
            7 is pow2Table [LECPoint; from L77 to L285 
            8 is lookupTable [LECPoint; from L150 to L285 
            9 is result LFixedPointPreCompInfo; from L247 to L285 
        .end localvariabletable 
    .end code 
    .exceptions java/lang/CloneNotSupportedException 
.end method 

.method private checkExisting : (LFixedPointPreCompInfo;I)Z 
    .code stack 3 locals 3 
L0:     aload_1 
L1:     ifnull L20 
L4:     aload_0 
L5:     aload_1 
L6:     invokevirtual Method FixedPointPreCompInfo getLookupTable ()LECLookupTable; 
L9:     iload_2 
L10:    invokespecial Method FixedPointUtil$1 checkTable (LECLookupTable;I)Z 
L13:    ifeq L20 
L16:    iconst_1 
L17:    goto L21 

        .stack same 
L20:    iconst_0 

        .stack stack_1 Integer 
L21:    ireturn 
L22:    
        .linenumbertable 
            L0 70 
        .end linenumbertable 
        .localvariabletable 
            0 is this LFixedPointUtil$1; from L0 to L22 
            1 is existingFP LFixedPointPreCompInfo; from L0 to L22 
            2 is n I from L0 to L22 
        .end localvariabletable 
    .end code 
.end method 

.method private checkTable : (LECLookupTable;I)Z 
    .code stack 2 locals 3 
L0:     aload_1 
L1:     ifnull L18 
L4:     aload_1 
L5:     invokeinterface InterfaceMethod ECLookupTable getSize ()I 1 
L10:    iload_2 
L11:    if_icmplt L18 
L14:    iconst_1 
L15:    goto L19 

        .stack same 
L18:    iconst_0 

        .stack stack_1 Integer 
L19:    ireturn 
L20:    
        .linenumbertable 
            L0 75 
        .end linenumbertable 
        .localvariabletable 
            0 is this LFixedPointUtil$1; from L0 to L20 
            1 is table LECLookupTable; from L0 to L20 
            2 is n I from L0 to L20 
        .end localvariabletable 
    .end code 
.end method 
.sourcefile 'FixedPointUtil.java' 
.enclosing method FixedPointUtil precompute (LECPoint;)LFixedPointPreCompInfo; 
.innerclasses 
    FixedPointUtil$1 [0] [0] static 
.end innerclasses 
.end class 
