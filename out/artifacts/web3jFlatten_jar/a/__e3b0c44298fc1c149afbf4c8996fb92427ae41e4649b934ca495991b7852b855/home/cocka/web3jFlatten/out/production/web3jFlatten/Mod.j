.version 52 0 
.class super abstract Mod 
.super java/lang/Object 

.method <init> : ()V 
    .code stack 1 locals 1 
L0:     aload_0 
L1:     invokespecial Method java/lang/Object <init> ()V 
L4:     return 
L5:     
        .linenumbertable 
            L0 1 
        .end linenumbertable 
        .localvariabletable 
            0 is this LMod; from L0 to L5 
        .end localvariabletable 
    .end code 
.end method 

.method public static invert : ([I[I[I)V 
    .code stack 5 locals 11 
L0:     aload_0 
L1:     arraylength 
L2:     istore_3 
L3:     iload_3 
L4:     aload_1 
L5:     invokestatic Method Nat isZero (I[I)Z 
L8:     ifeq L21 
L11:    new java/lang/IllegalArgumentException 
L14:    dup 
L15:    ldc "'x' cannot be 0" 
L17:    invokespecial Method java/lang/IllegalArgumentException <init> (Ljava/lang/String;)V 
L20:    athrow 

        .stack append Integer 
L21:    iload_3 
L22:    aload_1 
L23:    invokestatic Method Nat isOne (I[I)Z 
L26:    ifeq L38 
L29:    aload_1 
L30:    iconst_0 
L31:    aload_2 
L32:    iconst_0 
L33:    iload_3 
L34:    invokestatic Method java/lang/System arraycopy (Ljava/lang/Object;ILjava/lang/Object;II)V 
L37:    return 

        .stack same 
L38:    iload_3 
L39:    aload_1 
L40:    invokestatic Method Nat copy (I[I)[I 
L43:    astore 4 
L45:    iload_3 
L46:    invokestatic Method Nat create (I)[I 
L49:    astore 5 
L51:    aload 5 
L53:    iconst_0 
L54:    iconst_1 
L55:    iastore 
L56:    iconst_0 
L57:    istore 6 
L59:    aload 4 
L61:    iconst_0 
L62:    iaload 
L63:    iconst_1 
L64:    iand 
L65:    ifne L81 
L68:    aload_0 
L69:    aload 4 
L71:    iload_3 
L72:    aload 5 
L74:    iload 6 
L76:    invokestatic Method Mod inversionStep ([I[II[II)I 
L79:    istore 6 

        .stack append Object [I Object [I Integer 
L81:    iload_3 
L82:    aload 4 
L84:    invokestatic Method Nat isOne (I[I)Z 
L87:    ifeq L100 
L90:    aload_0 
L91:    iload 6 
L93:    aload 5 
L95:    aload_2 
L96:    invokestatic Method Mod inversionResult ([II[I[I)V 
L99:    return 

        .stack same 
L100:   iload_3 
L101:   aload_0 
L102:   invokestatic Method Nat copy (I[I)[I 
L105:   astore 7 
L107:   iload_3 
L108:   invokestatic Method Nat create (I)[I 
L111:   astore 8 
L113:   iconst_0 
L114:   istore 9 
L116:   iload_3 
L117:   istore 10 

        .stack full 
            locals Object [I Object [I Object [I Integer Object [I Object [I Integer Object [I Object [I Integer Integer 
            stack 
        .end stack 
L119:   aload 4 
L121:   iload 10 
L123:   iconst_1 
L124:   isub 
L125:   iaload 
L126:   ifne L145 
L129:   aload 7 
L131:   iload 10 
L133:   iconst_1 
L134:   isub 
L135:   iaload 
L136:   ifne L145 
L139:   iinc 10 -1 
L142:   goto L119 

        .stack same 
L145:   iload 10 
L147:   aload 4 
L149:   aload 7 
L151:   invokestatic Method Nat gte (I[I[I)Z 
L154:   ifeq L217 
L157:   iload 10 
L159:   aload 7 
L161:   aload 4 
L163:   invokestatic Method Nat subFrom (I[I[I)I 
L166:   pop 
L167:   iload 6 
L169:   iload_3 
L170:   aload 8 
L172:   aload 5 
L174:   invokestatic Method Nat subFrom (I[I[I)I 
L177:   iload 9 
L179:   isub 
L180:   iadd 
L181:   istore 6 
L183:   aload_0 
L184:   aload 4 
L186:   iload 10 
L188:   aload 5 
L190:   iload 6 
L192:   invokestatic Method Mod inversionStep ([I[II[II)I 
L195:   istore 6 
L197:   iload 10 
L199:   aload 4 
L201:   invokestatic Method Nat isOne (I[I)Z 
L204:   ifeq L119 
L207:   aload_0 
L208:   iload 6 
L210:   aload 5 
L212:   aload_2 
L213:   invokestatic Method Mod inversionResult ([II[I[I)V 
L216:   return 

        .stack same_extended 
L217:   iload 10 
L219:   aload 4 
L221:   aload 7 
L223:   invokestatic Method Nat subFrom (I[I[I)I 
L226:   pop 
L227:   iload 9 
L229:   iload_3 
L230:   aload 5 
L232:   aload 8 
L234:   invokestatic Method Nat subFrom (I[I[I)I 
L237:   iload 6 
L239:   isub 
L240:   iadd 
L241:   istore 9 
L243:   aload_0 
L244:   aload 7 
L246:   iload 10 
L248:   aload 8 
L250:   iload 9 
L252:   invokestatic Method Mod inversionStep ([I[II[II)I 
L255:   istore 9 
L257:   iload 10 
L259:   aload 7 
L261:   invokestatic Method Nat isOne (I[I)Z 
L264:   ifeq L119 
L267:   aload_0 
L268:   iload 9 
L270:   aload 8 
L272:   aload_2 
L273:   invokestatic Method Mod inversionResult ([II[I[I)V 
L276:   return 
L277:   
        .linenumbertable 
            L0 7 
            L3 8 
            L11 10 
            L21 12 
            L29 14 
            L37 15 
            L38 18 
            L45 19 
            L51 20 
            L56 21 
            L59 23 
            L68 25 
            L81 27 
            L90 29 
            L99 30 
            L100 33 
            L107 34 
            L113 35 
            L116 37 
            L119 41 
            L139 43 
            L145 46 
            L157 48 
            L167 50 
            L183 51 
            L197 52 
            L207 54 
            L216 55 
            L217 60 
            L227 62 
            L243 63 
            L257 64 
            L267 66 
            L276 67 
        .end linenumbertable 
        .localvariabletable 
            0 is p [I from L0 to L277 
            1 is x [I from L0 to L277 
            2 is z [I from L0 to L277 
            3 is len I from L3 to L277 
            4 is u [I from L45 to L277 
            5 is a [I from L51 to L277 
            6 is ac I from L59 to L277 
            7 is v [I from L107 to L277 
            8 is b [I from L113 to L277 
            9 is bc I from L116 to L277 
            10 is uvLen I from L119 to L277 
        .end localvariabletable 
    .end code 
.end method 

.method private static inversionResult : ([II[I[I)V 
    .code stack 5 locals 4 
L0:     iload_1 
L1:     ifge L15 
L4:     aload_0 
L5:     arraylength 
L6:     aload_2 
L7:     aload_0 
L8:     aload_3 
L9:     invokestatic Method Nat add (I[I[I[I)V 
L12:    goto L24 

        .stack same 
L15:    aload_2 
L16:    iconst_0 
L17:    aload_3 
L18:    iconst_0 
L19:    aload_0 
L20:    arraylength 
L21:    invokestatic Method java/lang/System arraycopy (Ljava/lang/Object;ILjava/lang/Object;II)V 

        .stack same 
L24:    return 
L25:    
        .linenumbertable 
            L0 76 
            L4 78 
            L15 82 
            L24 84 
        .end linenumbertable 
        .localvariabletable 
            0 is p [I from L0 to L25 
            1 is ac I from L0 to L25 
            2 is a [I from L0 to L25 
            3 is z [I from L0 to L25 
        .end localvariabletable 
    .end code 
.end method 

.method private static inversionStep : ([I[II[II)I 
    .code stack 4 locals 8 
L0:     aload_0 
L1:     arraylength 
L2:     istore 5 
L4:     iconst_0 
L5:     istore 6 

        .stack append Integer Integer 
L7:     aload_1 
L8:     iconst_0 
L9:     iaload 
L10:    ifne L25 
L13:    iload_2 
L14:    aload_1 
L15:    iconst_0 
L16:    invokestatic Method Nat shiftDownWord (I[II)V 
L19:    iinc 6 32 
L22:    goto L7 

        .stack same 
L25:    aload_1 
L26:    iconst_0 
L27:    iaload 
L28:    invokestatic Method Mod getTrailingZeroes (I)I 
L31:    istore 7 
L33:    iload 7 
L35:    ifle L53 
L38:    iload_2 
L39:    aload_1 
L40:    iload 7 
L42:    iconst_0 
L43:    invokestatic Method Nat shiftDownBits (I[III)V 
L46:    iload 6 
L48:    iload 7 
L50:    iadd 
L51:    istore 6 

        .stack same 
L53:    iconst_0 
L54:    istore 7 

        .stack append Integer 
L56:    iload 7 
L58:    iload 6 
L60:    if_icmpge L117 
L63:    aload_3 
L64:    iconst_0 
L65:    iaload 
L66:    iconst_1 
L67:    iand 
L68:    ifeq L103 
L71:    iload 4 
L73:    ifge L91 
L76:    iload 4 
L78:    iload 5 
L80:    aload_0 
L81:    aload_3 
L82:    invokestatic Method Nat addTo (I[I[I)I 
L85:    iadd 
L86:    istore 4 
L88:    goto L103 

        .stack same 
L91:    iload 4 
L93:    iload 5 
L95:    aload_0 
L96:    aload_3 
L97:    invokestatic Method Nat subFrom (I[I[I)I 
L100:   iadd 
L101:   istore 4 

        .stack same 
L103:   iload 5 
L105:   aload_3 
L106:   iload 4 
L108:   invokestatic Method Nat shiftDownBit (I[II)V 
L111:   iinc 7 1 
L114:   goto L56 

        .stack chop 1 
L117:   iload 4 
L119:   ireturn 
L120:   
        .linenumbertable 
            L0 88 
            L4 89 
            L7 90 
            L13 92 
            L19 93 
            L25 97 
            L33 98 
            L38 100 
            L46 101 
            L53 105 
            L63 107 
            L71 109 
            L76 111 
            L91 115 
            L103 119 
            L111 105 
            L117 122 
        .end linenumbertable 
        .localvariabletable 
            7 is zeroes I from L33 to L53 
            7 is i I from L56 to L117 
            0 is p [I from L0 to L120 
            1 is u [I from L0 to L120 
            2 is uLen I from L0 to L120 
            3 is x [I from L0 to L120 
            4 is xc I from L0 to L120 
            5 is len I from L4 to L120 
            6 is count I from L7 to L120 
        .end localvariabletable 
    .end code 
.end method 

.method private static getTrailingZeroes : (I)I 
    .code stack 2 locals 2 
L0:     iconst_0 
L1:     istore_1 

        .stack append Integer 
L2:     iload_0 
L3:     iconst_1 
L4:     iand 
L5:     ifne L18 
L8:     iload_0 
L9:     iconst_1 
L10:    iushr 
L11:    istore_0 
L12:    iinc 1 1 
L15:    goto L2 

        .stack same 
L18:    iload_1 
L19:    ireturn 
L20:    
        .linenumbertable 
            L0 129 
            L2 130 
            L8 132 
            L12 133 
            L18 135 
        .end linenumbertable 
        .localvariabletable 
            0 is x I from L0 to L20 
            1 is count I from L2 to L20 
        .end localvariabletable 
    .end code 
.end method 
.sourcefile 'Mod.java' 
.end class 
