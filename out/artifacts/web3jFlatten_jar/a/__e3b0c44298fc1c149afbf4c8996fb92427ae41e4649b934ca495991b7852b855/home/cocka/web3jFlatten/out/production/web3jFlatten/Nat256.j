.version 52 0 
.class super abstract Nat256 
.super java/lang/Object 
.field private static final M J = 4294967295L 

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
            0 is this LNat256; from L0 to L5 
        .end localvariabletable 
    .end code 
.end method 

.method public static add : ([I[I[I)I 
    .code stack 8 locals 5 
L0:     lconst_0 
L1:     lstore_3 
L2:     lload_3 
L3:     aload_0 
L4:     iconst_0 
L5:     iaload 
L6:     i2l 
L7:     ldc2_w 4294967295L 
L10:    land 
L11:    aload_1 
L12:    iconst_0 
L13:    iaload 
L14:    i2l 
L15:    ldc2_w 4294967295L 
L18:    land 
L19:    ladd 
L20:    ladd 
L21:    lstore_3 
L22:    aload_2 
L23:    iconst_0 
L24:    lload_3 
L25:    l2i 
L26:    iastore 
L27:    lload_3 
L28:    bipush 32 
L30:    lushr 
L31:    lstore_3 
L32:    lload_3 
L33:    aload_0 
L34:    iconst_1 
L35:    iaload 
L36:    i2l 
L37:    ldc2_w 4294967295L 
L40:    land 
L41:    aload_1 
L42:    iconst_1 
L43:    iaload 
L44:    i2l 
L45:    ldc2_w 4294967295L 
L48:    land 
L49:    ladd 
L50:    ladd 
L51:    lstore_3 
L52:    aload_2 
L53:    iconst_1 
L54:    lload_3 
L55:    l2i 
L56:    iastore 
L57:    lload_3 
L58:    bipush 32 
L60:    lushr 
L61:    lstore_3 
L62:    lload_3 
L63:    aload_0 
L64:    iconst_2 
L65:    iaload 
L66:    i2l 
L67:    ldc2_w 4294967295L 
L70:    land 
L71:    aload_1 
L72:    iconst_2 
L73:    iaload 
L74:    i2l 
L75:    ldc2_w 4294967295L 
L78:    land 
L79:    ladd 
L80:    ladd 
L81:    lstore_3 
L82:    aload_2 
L83:    iconst_2 
L84:    lload_3 
L85:    l2i 
L86:    iastore 
L87:    lload_3 
L88:    bipush 32 
L90:    lushr 
L91:    lstore_3 
L92:    lload_3 
L93:    aload_0 
L94:    iconst_3 
L95:    iaload 
L96:    i2l 
L97:    ldc2_w 4294967295L 
L100:   land 
L101:   aload_1 
L102:   iconst_3 
L103:   iaload 
L104:   i2l 
L105:   ldc2_w 4294967295L 
L108:   land 
L109:   ladd 
L110:   ladd 
L111:   lstore_3 
L112:   aload_2 
L113:   iconst_3 
L114:   lload_3 
L115:   l2i 
L116:   iastore 
L117:   lload_3 
L118:   bipush 32 
L120:   lushr 
L121:   lstore_3 
L122:   lload_3 
L123:   aload_0 
L124:   iconst_4 
L125:   iaload 
L126:   i2l 
L127:   ldc2_w 4294967295L 
L130:   land 
L131:   aload_1 
L132:   iconst_4 
L133:   iaload 
L134:   i2l 
L135:   ldc2_w 4294967295L 
L138:   land 
L139:   ladd 
L140:   ladd 
L141:   lstore_3 
L142:   aload_2 
L143:   iconst_4 
L144:   lload_3 
L145:   l2i 
L146:   iastore 
L147:   lload_3 
L148:   bipush 32 
L150:   lushr 
L151:   lstore_3 
L152:   lload_3 
L153:   aload_0 
L154:   iconst_5 
L155:   iaload 
L156:   i2l 
L157:   ldc2_w 4294967295L 
L160:   land 
L161:   aload_1 
L162:   iconst_5 
L163:   iaload 
L164:   i2l 
L165:   ldc2_w 4294967295L 
L168:   land 
L169:   ladd 
L170:   ladd 
L171:   lstore_3 
L172:   aload_2 
L173:   iconst_5 
L174:   lload_3 
L175:   l2i 
L176:   iastore 
L177:   lload_3 
L178:   bipush 32 
L180:   lushr 
L181:   lstore_3 
L182:   lload_3 
L183:   aload_0 
L184:   bipush 6 
L186:   iaload 
L187:   i2l 
L188:   ldc2_w 4294967295L 
L191:   land 
L192:   aload_1 
L193:   bipush 6 
L195:   iaload 
L196:   i2l 
L197:   ldc2_w 4294967295L 
L200:   land 
L201:   ladd 
L202:   ladd 
L203:   lstore_3 
L204:   aload_2 
L205:   bipush 6 
L207:   lload_3 
L208:   l2i 
L209:   iastore 
L210:   lload_3 
L211:   bipush 32 
L213:   lushr 
L214:   lstore_3 
L215:   lload_3 
L216:   aload_0 
L217:   bipush 7 
L219:   iaload 
L220:   i2l 
L221:   ldc2_w 4294967295L 
L224:   land 
L225:   aload_1 
L226:   bipush 7 
L228:   iaload 
L229:   i2l 
L230:   ldc2_w 4294967295L 
L233:   land 
L234:   ladd 
L235:   ladd 
L236:   lstore_3 
L237:   aload_2 
L238:   bipush 7 
L240:   lload_3 
L241:   l2i 
L242:   iastore 
L243:   lload_3 
L244:   bipush 32 
L246:   lushr 
L247:   lstore_3 
L248:   lload_3 
L249:   l2i 
L250:   ireturn 
L251:   
        .linenumbertable 
            L0 9 
            L2 10 
            L22 11 
            L27 12 
            L32 13 
            L52 14 
            L57 15 
            L62 16 
            L82 17 
            L87 18 
            L92 19 
            L112 20 
            L117 21 
            L122 22 
            L142 23 
            L147 24 
            L152 25 
            L172 26 
            L177 27 
            L182 28 
            L204 29 
            L210 30 
            L215 31 
            L237 32 
            L243 33 
            L248 34 
        .end linenumbertable 
        .localvariabletable 
            0 is x [I from L0 to L251 
            1 is y [I from L0 to L251 
            2 is z [I from L0 to L251 
            3 is c J from L2 to L251 
        .end localvariabletable 
    .end code 
.end method 

.method public static addBothTo : ([I[I[I)I 
    .code stack 8 locals 5 
L0:     lconst_0 
L1:     lstore_3 
L2:     lload_3 
L3:     aload_0 
L4:     iconst_0 
L5:     iaload 
L6:     i2l 
L7:     ldc2_w 4294967295L 
L10:    land 
L11:    aload_1 
L12:    iconst_0 
L13:    iaload 
L14:    i2l 
L15:    ldc2_w 4294967295L 
L18:    land 
L19:    ladd 
L20:    aload_2 
L21:    iconst_0 
L22:    iaload 
L23:    i2l 
L24:    ldc2_w 4294967295L 
L27:    land 
L28:    ladd 
L29:    ladd 
L30:    lstore_3 
L31:    aload_2 
L32:    iconst_0 
L33:    lload_3 
L34:    l2i 
L35:    iastore 
L36:    lload_3 
L37:    bipush 32 
L39:    lushr 
L40:    lstore_3 
L41:    lload_3 
L42:    aload_0 
L43:    iconst_1 
L44:    iaload 
L45:    i2l 
L46:    ldc2_w 4294967295L 
L49:    land 
L50:    aload_1 
L51:    iconst_1 
L52:    iaload 
L53:    i2l 
L54:    ldc2_w 4294967295L 
L57:    land 
L58:    ladd 
L59:    aload_2 
L60:    iconst_1 
L61:    iaload 
L62:    i2l 
L63:    ldc2_w 4294967295L 
L66:    land 
L67:    ladd 
L68:    ladd 
L69:    lstore_3 
L70:    aload_2 
L71:    iconst_1 
L72:    lload_3 
L73:    l2i 
L74:    iastore 
L75:    lload_3 
L76:    bipush 32 
L78:    lushr 
L79:    lstore_3 
L80:    lload_3 
L81:    aload_0 
L82:    iconst_2 
L83:    iaload 
L84:    i2l 
L85:    ldc2_w 4294967295L 
L88:    land 
L89:    aload_1 
L90:    iconst_2 
L91:    iaload 
L92:    i2l 
L93:    ldc2_w 4294967295L 
L96:    land 
L97:    ladd 
L98:    aload_2 
L99:    iconst_2 
L100:   iaload 
L101:   i2l 
L102:   ldc2_w 4294967295L 
L105:   land 
L106:   ladd 
L107:   ladd 
L108:   lstore_3 
L109:   aload_2 
L110:   iconst_2 
L111:   lload_3 
L112:   l2i 
L113:   iastore 
L114:   lload_3 
L115:   bipush 32 
L117:   lushr 
L118:   lstore_3 
L119:   lload_3 
L120:   aload_0 
L121:   iconst_3 
L122:   iaload 
L123:   i2l 
L124:   ldc2_w 4294967295L 
L127:   land 
L128:   aload_1 
L129:   iconst_3 
L130:   iaload 
L131:   i2l 
L132:   ldc2_w 4294967295L 
L135:   land 
L136:   ladd 
L137:   aload_2 
L138:   iconst_3 
L139:   iaload 
L140:   i2l 
L141:   ldc2_w 4294967295L 
L144:   land 
L145:   ladd 
L146:   ladd 
L147:   lstore_3 
L148:   aload_2 
L149:   iconst_3 
L150:   lload_3 
L151:   l2i 
L152:   iastore 
L153:   lload_3 
L154:   bipush 32 
L156:   lushr 
L157:   lstore_3 
L158:   lload_3 
L159:   aload_0 
L160:   iconst_4 
L161:   iaload 
L162:   i2l 
L163:   ldc2_w 4294967295L 
L166:   land 
L167:   aload_1 
L168:   iconst_4 
L169:   iaload 
L170:   i2l 
L171:   ldc2_w 4294967295L 
L174:   land 
L175:   ladd 
L176:   aload_2 
L177:   iconst_4 
L178:   iaload 
L179:   i2l 
L180:   ldc2_w 4294967295L 
L183:   land 
L184:   ladd 
L185:   ladd 
L186:   lstore_3 
L187:   aload_2 
L188:   iconst_4 
L189:   lload_3 
L190:   l2i 
L191:   iastore 
L192:   lload_3 
L193:   bipush 32 
L195:   lushr 
L196:   lstore_3 
L197:   lload_3 
L198:   aload_0 
L199:   iconst_5 
L200:   iaload 
L201:   i2l 
L202:   ldc2_w 4294967295L 
L205:   land 
L206:   aload_1 
L207:   iconst_5 
L208:   iaload 
L209:   i2l 
L210:   ldc2_w 4294967295L 
L213:   land 
L214:   ladd 
L215:   aload_2 
L216:   iconst_5 
L217:   iaload 
L218:   i2l 
L219:   ldc2_w 4294967295L 
L222:   land 
L223:   ladd 
L224:   ladd 
L225:   lstore_3 
L226:   aload_2 
L227:   iconst_5 
L228:   lload_3 
L229:   l2i 
L230:   iastore 
L231:   lload_3 
L232:   bipush 32 
L234:   lushr 
L235:   lstore_3 
L236:   lload_3 
L237:   aload_0 
L238:   bipush 6 
L240:   iaload 
L241:   i2l 
L242:   ldc2_w 4294967295L 
L245:   land 
L246:   aload_1 
L247:   bipush 6 
L249:   iaload 
L250:   i2l 
L251:   ldc2_w 4294967295L 
L254:   land 
L255:   ladd 
L256:   aload_2 
L257:   bipush 6 
L259:   iaload 
L260:   i2l 
L261:   ldc2_w 4294967295L 
L264:   land 
L265:   ladd 
L266:   ladd 
L267:   lstore_3 
L268:   aload_2 
L269:   bipush 6 
L271:   lload_3 
L272:   l2i 
L273:   iastore 
L274:   lload_3 
L275:   bipush 32 
L277:   lushr 
L278:   lstore_3 
L279:   lload_3 
L280:   aload_0 
L281:   bipush 7 
L283:   iaload 
L284:   i2l 
L285:   ldc2_w 4294967295L 
L288:   land 
L289:   aload_1 
L290:   bipush 7 
L292:   iaload 
L293:   i2l 
L294:   ldc2_w 4294967295L 
L297:   land 
L298:   ladd 
L299:   aload_2 
L300:   bipush 7 
L302:   iaload 
L303:   i2l 
L304:   ldc2_w 4294967295L 
L307:   land 
L308:   ladd 
L309:   ladd 
L310:   lstore_3 
L311:   aload_2 
L312:   bipush 7 
L314:   lload_3 
L315:   l2i 
L316:   iastore 
L317:   lload_3 
L318:   bipush 32 
L320:   lushr 
L321:   lstore_3 
L322:   lload_3 
L323:   l2i 
L324:   ireturn 
L325:   
        .linenumbertable 
            L0 39 
            L2 40 
            L31 41 
            L36 42 
            L41 43 
            L70 44 
            L75 45 
            L80 46 
            L109 47 
            L114 48 
            L119 49 
            L148 50 
            L153 51 
            L158 52 
            L187 53 
            L192 54 
            L197 55 
            L226 56 
            L231 57 
            L236 58 
            L268 59 
            L274 60 
            L279 61 
            L311 62 
            L317 63 
            L322 64 
        .end linenumbertable 
        .localvariabletable 
            0 is x [I from L0 to L325 
            1 is y [I from L0 to L325 
            2 is z [I from L0 to L325 
            3 is c J from L2 to L325 
        .end localvariabletable 
    .end code 
.end method 

.method public static addTo : ([I[I)I 
    .code stack 8 locals 4 
L0:     lconst_0 
L1:     lstore_2 
L2:     lload_2 
L3:     aload_0 
L4:     iconst_0 
L5:     iaload 
L6:     i2l 
L7:     ldc2_w 4294967295L 
L10:    land 
L11:    aload_1 
L12:    iconst_0 
L13:    iaload 
L14:    i2l 
L15:    ldc2_w 4294967295L 
L18:    land 
L19:    ladd 
L20:    ladd 
L21:    lstore_2 
L22:    aload_1 
L23:    iconst_0 
L24:    lload_2 
L25:    l2i 
L26:    iastore 
L27:    lload_2 
L28:    bipush 32 
L30:    lushr 
L31:    lstore_2 
L32:    lload_2 
L33:    aload_0 
L34:    iconst_1 
L35:    iaload 
L36:    i2l 
L37:    ldc2_w 4294967295L 
L40:    land 
L41:    aload_1 
L42:    iconst_1 
L43:    iaload 
L44:    i2l 
L45:    ldc2_w 4294967295L 
L48:    land 
L49:    ladd 
L50:    ladd 
L51:    lstore_2 
L52:    aload_1 
L53:    iconst_1 
L54:    lload_2 
L55:    l2i 
L56:    iastore 
L57:    lload_2 
L58:    bipush 32 
L60:    lushr 
L61:    lstore_2 
L62:    lload_2 
L63:    aload_0 
L64:    iconst_2 
L65:    iaload 
L66:    i2l 
L67:    ldc2_w 4294967295L 
L70:    land 
L71:    aload_1 
L72:    iconst_2 
L73:    iaload 
L74:    i2l 
L75:    ldc2_w 4294967295L 
L78:    land 
L79:    ladd 
L80:    ladd 
L81:    lstore_2 
L82:    aload_1 
L83:    iconst_2 
L84:    lload_2 
L85:    l2i 
L86:    iastore 
L87:    lload_2 
L88:    bipush 32 
L90:    lushr 
L91:    lstore_2 
L92:    lload_2 
L93:    aload_0 
L94:    iconst_3 
L95:    iaload 
L96:    i2l 
L97:    ldc2_w 4294967295L 
L100:   land 
L101:   aload_1 
L102:   iconst_3 
L103:   iaload 
L104:   i2l 
L105:   ldc2_w 4294967295L 
L108:   land 
L109:   ladd 
L110:   ladd 
L111:   lstore_2 
L112:   aload_1 
L113:   iconst_3 
L114:   lload_2 
L115:   l2i 
L116:   iastore 
L117:   lload_2 
L118:   bipush 32 
L120:   lushr 
L121:   lstore_2 
L122:   lload_2 
L123:   aload_0 
L124:   iconst_4 
L125:   iaload 
L126:   i2l 
L127:   ldc2_w 4294967295L 
L130:   land 
L131:   aload_1 
L132:   iconst_4 
L133:   iaload 
L134:   i2l 
L135:   ldc2_w 4294967295L 
L138:   land 
L139:   ladd 
L140:   ladd 
L141:   lstore_2 
L142:   aload_1 
L143:   iconst_4 
L144:   lload_2 
L145:   l2i 
L146:   iastore 
L147:   lload_2 
L148:   bipush 32 
L150:   lushr 
L151:   lstore_2 
L152:   lload_2 
L153:   aload_0 
L154:   iconst_5 
L155:   iaload 
L156:   i2l 
L157:   ldc2_w 4294967295L 
L160:   land 
L161:   aload_1 
L162:   iconst_5 
L163:   iaload 
L164:   i2l 
L165:   ldc2_w 4294967295L 
L168:   land 
L169:   ladd 
L170:   ladd 
L171:   lstore_2 
L172:   aload_1 
L173:   iconst_5 
L174:   lload_2 
L175:   l2i 
L176:   iastore 
L177:   lload_2 
L178:   bipush 32 
L180:   lushr 
L181:   lstore_2 
L182:   lload_2 
L183:   aload_0 
L184:   bipush 6 
L186:   iaload 
L187:   i2l 
L188:   ldc2_w 4294967295L 
L191:   land 
L192:   aload_1 
L193:   bipush 6 
L195:   iaload 
L196:   i2l 
L197:   ldc2_w 4294967295L 
L200:   land 
L201:   ladd 
L202:   ladd 
L203:   lstore_2 
L204:   aload_1 
L205:   bipush 6 
L207:   lload_2 
L208:   l2i 
L209:   iastore 
L210:   lload_2 
L211:   bipush 32 
L213:   lushr 
L214:   lstore_2 
L215:   lload_2 
L216:   aload_0 
L217:   bipush 7 
L219:   iaload 
L220:   i2l 
L221:   ldc2_w 4294967295L 
L224:   land 
L225:   aload_1 
L226:   bipush 7 
L228:   iaload 
L229:   i2l 
L230:   ldc2_w 4294967295L 
L233:   land 
L234:   ladd 
L235:   ladd 
L236:   lstore_2 
L237:   aload_1 
L238:   bipush 7 
L240:   lload_2 
L241:   l2i 
L242:   iastore 
L243:   lload_2 
L244:   bipush 32 
L246:   lushr 
L247:   lstore_2 
L248:   lload_2 
L249:   l2i 
L250:   ireturn 
L251:   
        .linenumbertable 
            L0 69 
            L2 70 
            L22 71 
            L27 72 
            L32 73 
            L52 74 
            L57 75 
            L62 76 
            L82 77 
            L87 78 
            L92 79 
            L112 80 
            L117 81 
            L122 82 
            L142 83 
            L147 84 
            L152 85 
            L172 86 
            L177 87 
            L182 88 
            L204 89 
            L210 90 
            L215 91 
            L237 92 
            L243 93 
            L248 94 
        .end linenumbertable 
        .localvariabletable 
            0 is x [I from L0 to L251 
            1 is z [I from L0 to L251 
            2 is c J from L2 to L251 
        .end localvariabletable 
    .end code 
.end method 

.method public static copy : ([II[II)V 
    .code stack 5 locals 4 
L0:     aload_2 
L1:     iload_3 
L2:     aload_0 
L3:     iload_1 
L4:     iaload 
L5:     iastore 
L6:     aload_2 
L7:     iload_3 
L8:     iconst_1 
L9:     iadd 
L10:    aload_0 
L11:    iload_1 
L12:    iconst_1 
L13:    iadd 
L14:    iaload 
L15:    iastore 
L16:    aload_2 
L17:    iload_3 
L18:    iconst_2 
L19:    iadd 
L20:    aload_0 
L21:    iload_1 
L22:    iconst_2 
L23:    iadd 
L24:    iaload 
L25:    iastore 
L26:    aload_2 
L27:    iload_3 
L28:    iconst_3 
L29:    iadd 
L30:    aload_0 
L31:    iload_1 
L32:    iconst_3 
L33:    iadd 
L34:    iaload 
L35:    iastore 
L36:    aload_2 
L37:    iload_3 
L38:    iconst_4 
L39:    iadd 
L40:    aload_0 
L41:    iload_1 
L42:    iconst_4 
L43:    iadd 
L44:    iaload 
L45:    iastore 
L46:    aload_2 
L47:    iload_3 
L48:    iconst_5 
L49:    iadd 
L50:    aload_0 
L51:    iload_1 
L52:    iconst_5 
L53:    iadd 
L54:    iaload 
L55:    iastore 
L56:    aload_2 
L57:    iload_3 
L58:    bipush 6 
L60:    iadd 
L61:    aload_0 
L62:    iload_1 
L63:    bipush 6 
L65:    iadd 
L66:    iaload 
L67:    iastore 
L68:    aload_2 
L69:    iload_3 
L70:    bipush 7 
L72:    iadd 
L73:    aload_0 
L74:    iload_1 
L75:    bipush 7 
L77:    iadd 
L78:    iaload 
L79:    iastore 
L80:    return 
L81:    
        .linenumbertable 
            L0 99 
            L6 100 
            L16 101 
            L26 102 
            L36 103 
            L46 104 
            L56 105 
            L68 106 
            L80 107 
        .end linenumbertable 
        .localvariabletable 
            0 is x [I from L0 to L81 
            1 is xOff I from L0 to L81 
            2 is z [I from L0 to L81 
            3 is zOff I from L0 to L81 
        .end localvariabletable 
    .end code 
.end method 

.method public static create : ()[I 
    .code stack 1 locals 0 
L0:     bipush 8 
L2:     newarray int 
L4:     areturn 
L5:     
        .linenumbertable 
            L0 111 
        .end linenumbertable 
    .end code 
.end method 

.method public static createExt : ()[I 
    .code stack 1 locals 0 
L0:     bipush 16 
L2:     newarray int 
L4:     areturn 
L5:     
        .linenumbertable 
            L0 116 
        .end linenumbertable 
    .end code 
.end method 

.method public static eq : ([I[I)Z 
    .code stack 3 locals 3 
L0:     bipush 7 
L2:     istore_2 

        .stack append Integer 
L3:     iload_2 
L4:     iflt L24 
L7:     aload_0 
L8:     iload_2 
L9:     iaload 
L10:    aload_1 
L11:    iload_2 
L12:    iaload 
L13:    if_icmpeq L18 
L16:    iconst_0 
L17:    ireturn 

        .stack same 
L18:    iinc 2 -1 
L21:    goto L3 

        .stack chop 1 
L24:    iconst_1 
L25:    ireturn 
L26:    
        .linenumbertable 
            L0 121 
            L7 123 
            L16 125 
            L18 121 
            L24 128 
        .end linenumbertable 
        .localvariabletable 
            2 is i I from L3 to L24 
            0 is x [I from L0 to L26 
            1 is y [I from L0 to L26 
        .end localvariabletable 
    .end code 
.end method 

.method public static fromBigInteger : (Ljava/math/BigInteger;)[I 
    .code stack 3 locals 3 
L0:     aload_0 
L1:     invokevirtual Method java/math/BigInteger signum ()I 
L4:     iflt L17 
L7:     aload_0 
L8:     invokevirtual Method java/math/BigInteger bitLength ()I 
L11:    sipush 256 
L14:    if_icmple L25 

        .stack same 
L17:    new java/lang/IllegalArgumentException 
L20:    dup 
L21:    invokespecial Method java/lang/IllegalArgumentException <init> ()V 
L24:    athrow 

        .stack same 
L25:    invokestatic Method Nat256 create ()[I 
L28:    astore_1 
L29:    iconst_0 
L30:    istore_2 

        .stack append Object [I Integer 
L31:    aload_0 
L32:    invokevirtual Method java/math/BigInteger signum ()I 
L35:    ifeq L58 
L38:    aload_1 
L39:    iload_2 
L40:    iinc 2 1 
L43:    aload_0 
L44:    invokevirtual Method java/math/BigInteger intValue ()I 
L47:    iastore 
L48:    aload_0 
L49:    bipush 32 
L51:    invokevirtual Method java/math/BigInteger shiftRight (I)Ljava/math/BigInteger; 
L54:    astore_0 
L55:    goto L31 

        .stack same 
L58:    aload_1 
L59:    areturn 
L60:    
        .linenumbertable 
            L0 133 
            L17 135 
            L25 138 
            L29 139 
            L31 140 
            L38 142 
            L48 143 
            L58 145 
        .end linenumbertable 
        .localvariabletable 
            0 is x Ljava/math/BigInteger; from L0 to L60 
            1 is z [I from L29 to L60 
            2 is i I from L31 to L60 
        .end localvariabletable 
    .end code 
.end method 

.method public static getBit : ([II)I 
    .code stack 2 locals 4 
L0:     iload_1 
L1:     ifne L10 
L4:     aload_0 
L5:     iconst_0 
L6:     iaload 
L7:     iconst_1 
L8:     iand 
L9:     ireturn 

        .stack same 
L10:    iload_1 
L11:    sipush 255 
L14:    iand 
L15:    iload_1 
L16:    if_icmpeq L21 
L19:    iconst_0 
L20:    ireturn 

        .stack same 
L21:    iload_1 
L22:    iconst_5 
L23:    iushr 
L24:    istore_2 
L25:    iload_1 
L26:    bipush 31 
L28:    iand 
L29:    istore_3 
L30:    aload_0 
L31:    iload_2 
L32:    iaload 
L33:    iload_3 
L34:    iushr 
L35:    iconst_1 
L36:    iand 
L37:    ireturn 
L38:    
        .linenumbertable 
            L0 150 
            L4 152 
            L10 154 
            L19 156 
            L21 158 
            L25 159 
            L30 160 
        .end linenumbertable 
        .localvariabletable 
            0 is x [I from L0 to L38 
            1 is bit I from L0 to L38 
            2 is w I from L25 to L38 
            3 is b I from L30 to L38 
        .end localvariabletable 
    .end code 
.end method 

.method public static gte : ([I[I)Z 
    .code stack 2 locals 5 
L0:     bipush 7 
L2:     istore_2 

        .stack append Integer 
L3:     iload_2 
L4:     iflt L44 
L7:     aload_0 
L8:     iload_2 
L9:     iaload 
L10:    ldc -2147483648 
L12:    ixor 
L13:    istore_3 
L14:    aload_1 
L15:    iload_2 
L16:    iaload 
L17:    ldc -2147483648 
L19:    ixor 
L20:    istore 4 
L22:    iload_3 
L23:    iload 4 
L25:    if_icmpge L30 
L28:    iconst_0 
L29:    ireturn 

        .stack append Integer Integer 
L30:    iload_3 
L31:    iload 4 
L33:    if_icmple L38 
L36:    iconst_1 
L37:    ireturn 

        .stack chop 2 
L38:    iinc 2 -1 
L41:    goto L3 

        .stack chop 1 
L44:    iconst_1 
L45:    ireturn 
L46:    
        .linenumbertable 
            L0 165 
            L7 167 
            L14 168 
            L22 169 
            L28 170 
            L30 171 
            L36 172 
            L38 165 
            L44 174 
        .end linenumbertable 
        .localvariabletable 
            3 is x_i I from L14 to L38 
            4 is y_i I from L22 to L38 
            2 is i I from L3 to L44 
            0 is x [I from L0 to L46 
            1 is y [I from L0 to L46 
        .end localvariabletable 
    .end code 
.end method 

.method public static isOne : ([I)Z 
    .code stack 2 locals 2 
L0:     aload_0 
L1:     iconst_0 
L2:     iaload 
L3:     iconst_1 
L4:     if_icmpeq L9 
L7:     iconst_0 
L8:     ireturn 

        .stack same 
L9:     iconst_1 
L10:    istore_1 

        .stack append Integer 
L11:    iload_1 
L12:    bipush 8 
L14:    if_icmpge L31 
L17:    aload_0 
L18:    iload_1 
L19:    iaload 
L20:    ifeq L25 
L23:    iconst_0 
L24:    ireturn 

        .stack same 
L25:    iinc 1 1 
L28:    goto L11 

        .stack chop 1 
L31:    iconst_1 
L32:    ireturn 
L33:    
        .linenumbertable 
            L0 179 
            L7 181 
            L9 183 
            L17 185 
            L23 187 
            L25 183 
            L31 190 
        .end linenumbertable 
        .localvariabletable 
            1 is i I from L11 to L31 
            0 is x [I from L0 to L33 
        .end localvariabletable 
    .end code 
.end method 

.method public static isZero : ([I)Z 
    .code stack 2 locals 2 
L0:     iconst_0 
L1:     istore_1 

        .stack append Integer 
L2:     iload_1 
L3:     bipush 8 
L5:     if_icmpge L22 
L8:     aload_0 
L9:     iload_1 
L10:    iaload 
L11:    ifeq L16 
L14:    iconst_0 
L15:    ireturn 

        .stack same 
L16:    iinc 1 1 
L19:    goto L2 

        .stack chop 1 
L22:    iconst_1 
L23:    ireturn 
L24:    
        .linenumbertable 
            L0 195 
            L8 197 
            L14 199 
            L16 195 
            L22 202 
        .end linenumbertable 
        .localvariabletable 
            1 is i I from L2 to L22 
            0 is x [I from L0 to L24 
        .end localvariabletable 
    .end code 
.end method 

.method public static mul : ([I[I[I)V 
    .code stack 8 locals 24 
L0:     aload_1 
L1:     iconst_0 
L2:     iaload 
L3:     i2l 
L4:     ldc2_w 4294967295L 
L7:     land 
L8:     lstore_3 
L9:     aload_1 
L10:    iconst_1 
L11:    iaload 
L12:    i2l 
L13:    ldc2_w 4294967295L 
L16:    land 
L17:    lstore 5 
L19:    aload_1 
L20:    iconst_2 
L21:    iaload 
L22:    i2l 
L23:    ldc2_w 4294967295L 
L26:    land 
L27:    lstore 7 
L29:    aload_1 
L30:    iconst_3 
L31:    iaload 
L32:    i2l 
L33:    ldc2_w 4294967295L 
L36:    land 
L37:    lstore 9 
L39:    aload_1 
L40:    iconst_4 
L41:    iaload 
L42:    i2l 
L43:    ldc2_w 4294967295L 
L46:    land 
L47:    lstore 11 
L49:    aload_1 
L50:    iconst_5 
L51:    iaload 
L52:    i2l 
L53:    ldc2_w 4294967295L 
L56:    land 
L57:    lstore 13 
L59:    aload_1 
L60:    bipush 6 
L62:    iaload 
L63:    i2l 
L64:    ldc2_w 4294967295L 
L67:    land 
L68:    lstore 15 
L70:    aload_1 
L71:    bipush 7 
L73:    iaload 
L74:    i2l 
L75:    ldc2_w 4294967295L 
L78:    land 
L79:    lstore 17 
L81:    lconst_0 
L82:    lstore 19 
L84:    aload_0 
L85:    iconst_0 
L86:    iaload 
L87:    i2l 
L88:    ldc2_w 4294967295L 
L91:    land 
L92:    lstore 21 
L94:    lload 19 
L96:    lload 21 
L98:    lload_3 
L99:    lmul 
L100:   ladd 
L101:   lstore 19 
L103:   aload_2 
L104:   iconst_0 
L105:   lload 19 
L107:   l2i 
L108:   iastore 
L109:   lload 19 
L111:   bipush 32 
L113:   lushr 
L114:   lstore 19 
L116:   lload 19 
L118:   lload 21 
L120:   lload 5 
L122:   lmul 
L123:   ladd 
L124:   lstore 19 
L126:   aload_2 
L127:   iconst_1 
L128:   lload 19 
L130:   l2i 
L131:   iastore 
L132:   lload 19 
L134:   bipush 32 
L136:   lushr 
L137:   lstore 19 
L139:   lload 19 
L141:   lload 21 
L143:   lload 7 
L145:   lmul 
L146:   ladd 
L147:   lstore 19 
L149:   aload_2 
L150:   iconst_2 
L151:   lload 19 
L153:   l2i 
L154:   iastore 
L155:   lload 19 
L157:   bipush 32 
L159:   lushr 
L160:   lstore 19 
L162:   lload 19 
L164:   lload 21 
L166:   lload 9 
L168:   lmul 
L169:   ladd 
L170:   lstore 19 
L172:   aload_2 
L173:   iconst_3 
L174:   lload 19 
L176:   l2i 
L177:   iastore 
L178:   lload 19 
L180:   bipush 32 
L182:   lushr 
L183:   lstore 19 
L185:   lload 19 
L187:   lload 21 
L189:   lload 11 
L191:   lmul 
L192:   ladd 
L193:   lstore 19 
L195:   aload_2 
L196:   iconst_4 
L197:   lload 19 
L199:   l2i 
L200:   iastore 
L201:   lload 19 
L203:   bipush 32 
L205:   lushr 
L206:   lstore 19 
L208:   lload 19 
L210:   lload 21 
L212:   lload 13 
L214:   lmul 
L215:   ladd 
L216:   lstore 19 
L218:   aload_2 
L219:   iconst_5 
L220:   lload 19 
L222:   l2i 
L223:   iastore 
L224:   lload 19 
L226:   bipush 32 
L228:   lushr 
L229:   lstore 19 
L231:   lload 19 
L233:   lload 21 
L235:   lload 15 
L237:   lmul 
L238:   ladd 
L239:   lstore 19 
L241:   aload_2 
L242:   bipush 6 
L244:   lload 19 
L246:   l2i 
L247:   iastore 
L248:   lload 19 
L250:   bipush 32 
L252:   lushr 
L253:   lstore 19 
L255:   lload 19 
L257:   lload 21 
L259:   lload 17 
L261:   lmul 
L262:   ladd 
L263:   lstore 19 
L265:   aload_2 
L266:   bipush 7 
L268:   lload 19 
L270:   l2i 
L271:   iastore 
L272:   lload 19 
L274:   bipush 32 
L276:   lushr 
L277:   lstore 19 
L279:   aload_2 
L280:   bipush 8 
L282:   lload 19 
L284:   l2i 
L285:   iastore 
L286:   iconst_1 
L287:   istore 19 

        .stack full 
            locals Object [I Object [I Object [I Long Long Long Long Long Long Long Long Integer 
            stack 
        .end stack 
L289:   iload 19 
L291:   bipush 8 
L293:   if_icmpge L629 
L296:   lconst_0 
L297:   lstore 20 
L299:   aload_0 
L300:   iload 19 
L302:   iaload 
L303:   i2l 
L304:   ldc2_w 4294967295L 
L307:   land 
L308:   lstore 22 
L310:   lload 20 
L312:   lload 22 
L314:   lload_3 
L315:   lmul 
L316:   aload_2 
L317:   iload 19 
L319:   iaload 
L320:   i2l 
L321:   ldc2_w 4294967295L 
L324:   land 
L325:   ladd 
L326:   ladd 
L327:   lstore 20 
L329:   aload_2 
L330:   iload 19 
L332:   lload 20 
L334:   l2i 
L335:   iastore 
L336:   lload 20 
L338:   bipush 32 
L340:   lushr 
L341:   lstore 20 
L343:   lload 20 
L345:   lload 22 
L347:   lload 5 
L349:   lmul 
L350:   aload_2 
L351:   iload 19 
L353:   iconst_1 
L354:   iadd 
L355:   iaload 
L356:   i2l 
L357:   ldc2_w 4294967295L 
L360:   land 
L361:   ladd 
L362:   ladd 
L363:   lstore 20 
L365:   aload_2 
L366:   iload 19 
L368:   iconst_1 
L369:   iadd 
L370:   lload 20 
L372:   l2i 
L373:   iastore 
L374:   lload 20 
L376:   bipush 32 
L378:   lushr 
L379:   lstore 20 
L381:   lload 20 
L383:   lload 22 
L385:   lload 7 
L387:   lmul 
L388:   aload_2 
L389:   iload 19 
L391:   iconst_2 
L392:   iadd 
L393:   iaload 
L394:   i2l 
L395:   ldc2_w 4294967295L 
L398:   land 
L399:   ladd 
L400:   ladd 
L401:   lstore 20 
L403:   aload_2 
L404:   iload 19 
L406:   iconst_2 
L407:   iadd 
L408:   lload 20 
L410:   l2i 
L411:   iastore 
L412:   lload 20 
L414:   bipush 32 
L416:   lushr 
L417:   lstore 20 
L419:   lload 20 
L421:   lload 22 
L423:   lload 9 
L425:   lmul 
L426:   aload_2 
L427:   iload 19 
L429:   iconst_3 
L430:   iadd 
L431:   iaload 
L432:   i2l 
L433:   ldc2_w 4294967295L 
L436:   land 
L437:   ladd 
L438:   ladd 
L439:   lstore 20 
L441:   aload_2 
L442:   iload 19 
L444:   iconst_3 
L445:   iadd 
L446:   lload 20 
L448:   l2i 
L449:   iastore 
L450:   lload 20 
L452:   bipush 32 
L454:   lushr 
L455:   lstore 20 
L457:   lload 20 
L459:   lload 22 
L461:   lload 11 
L463:   lmul 
L464:   aload_2 
L465:   iload 19 
L467:   iconst_4 
L468:   iadd 
L469:   iaload 
L470:   i2l 
L471:   ldc2_w 4294967295L 
L474:   land 
L475:   ladd 
L476:   ladd 
L477:   lstore 20 
L479:   aload_2 
L480:   iload 19 
L482:   iconst_4 
L483:   iadd 
L484:   lload 20 
L486:   l2i 
L487:   iastore 
L488:   lload 20 
L490:   bipush 32 
L492:   lushr 
L493:   lstore 20 
L495:   lload 20 
L497:   lload 22 
L499:   lload 13 
L501:   lmul 
L502:   aload_2 
L503:   iload 19 
L505:   iconst_5 
L506:   iadd 
L507:   iaload 
L508:   i2l 
L509:   ldc2_w 4294967295L 
L512:   land 
L513:   ladd 
L514:   ladd 
L515:   lstore 20 
L517:   aload_2 
L518:   iload 19 
L520:   iconst_5 
L521:   iadd 
L522:   lload 20 
L524:   l2i 
L525:   iastore 
L526:   lload 20 
L528:   bipush 32 
L530:   lushr 
L531:   lstore 20 
L533:   lload 20 
L535:   lload 22 
L537:   lload 15 
L539:   lmul 
L540:   aload_2 
L541:   iload 19 
L543:   bipush 6 
L545:   iadd 
L546:   iaload 
L547:   i2l 
L548:   ldc2_w 4294967295L 
L551:   land 
L552:   ladd 
L553:   ladd 
L554:   lstore 20 
L556:   aload_2 
L557:   iload 19 
L559:   bipush 6 
L561:   iadd 
L562:   lload 20 
L564:   l2i 
L565:   iastore 
L566:   lload 20 
L568:   bipush 32 
L570:   lushr 
L571:   lstore 20 
L573:   lload 20 
L575:   lload 22 
L577:   lload 17 
L579:   lmul 
L580:   aload_2 
L581:   iload 19 
L583:   bipush 7 
L585:   iadd 
L586:   iaload 
L587:   i2l 
L588:   ldc2_w 4294967295L 
L591:   land 
L592:   ladd 
L593:   ladd 
L594:   lstore 20 
L596:   aload_2 
L597:   iload 19 
L599:   bipush 7 
L601:   iadd 
L602:   lload 20 
L604:   l2i 
L605:   iastore 
L606:   lload 20 
L608:   bipush 32 
L610:   lushr 
L611:   lstore 20 
L613:   aload_2 
L614:   iload 19 
L616:   bipush 8 
L618:   iadd 
L619:   lload 20 
L621:   l2i 
L622:   iastore 
L623:   iinc 19 1 
L626:   goto L289 

        .stack chop 1 
L629:   return 
L630:   
        .linenumbertable 
            L0 207 
            L9 208 
            L19 209 
            L29 210 
            L39 211 
            L49 212 
            L59 213 
            L70 214 
            L81 217 
            L94 218 
            L103 219 
            L109 220 
            L116 221 
            L126 222 
            L132 223 
            L139 224 
            L149 225 
            L155 226 
            L162 227 
            L172 228 
            L178 229 
            L185 230 
            L195 231 
            L201 232 
            L208 233 
            L218 234 
            L224 235 
            L231 236 
            L241 237 
            L248 238 
            L255 239 
            L265 240 
            L272 241 
            L279 242 
            L286 245 
            L296 247 
            L310 248 
            L329 249 
            L336 250 
            L343 251 
            L365 252 
            L374 253 
            L381 254 
            L403 255 
            L412 256 
            L419 257 
            L441 258 
            L450 259 
            L457 260 
            L479 261 
            L488 262 
            L495 263 
            L517 264 
            L526 265 
            L533 266 
            L556 267 
            L566 268 
            L573 269 
            L596 270 
            L606 271 
            L613 272 
            L623 245 
            L629 274 
        .end linenumbertable 
        .localvariabletable 
            19 is c J from L84 to L286 
            21 is x_0 J from L94 to L286 
            20 is c J from L299 to L623 
            22 is x_i J from L310 to L623 
            19 is i I from L289 to L629 
            0 is x [I from L0 to L630 
            1 is y [I from L0 to L630 
            2 is zz [I from L0 to L630 
            3 is y_0 J from L9 to L630 
            5 is y_1 J from L19 to L630 
            7 is y_2 J from L29 to L630 
            9 is y_3 J from L39 to L630 
            11 is y_4 J from L49 to L630 
            13 is y_5 J from L59 to L630 
            15 is y_6 J from L70 to L630 
            17 is y_7 J from L81 to L630 
        .end localvariabletable 
    .end code 
.end method 

.method public static mulAddTo : ([I[I[I)I 
    .code stack 8 locals 26 
L0:     aload_1 
L1:     iconst_0 
L2:     iaload 
L3:     i2l 
L4:     ldc2_w 4294967295L 
L7:     land 
L8:     lstore_3 
L9:     aload_1 
L10:    iconst_1 
L11:    iaload 
L12:    i2l 
L13:    ldc2_w 4294967295L 
L16:    land 
L17:    lstore 5 
L19:    aload_1 
L20:    iconst_2 
L21:    iaload 
L22:    i2l 
L23:    ldc2_w 4294967295L 
L26:    land 
L27:    lstore 7 
L29:    aload_1 
L30:    iconst_3 
L31:    iaload 
L32:    i2l 
L33:    ldc2_w 4294967295L 
L36:    land 
L37:    lstore 9 
L39:    aload_1 
L40:    iconst_4 
L41:    iaload 
L42:    i2l 
L43:    ldc2_w 4294967295L 
L46:    land 
L47:    lstore 11 
L49:    aload_1 
L50:    iconst_5 
L51:    iaload 
L52:    i2l 
L53:    ldc2_w 4294967295L 
L56:    land 
L57:    lstore 13 
L59:    aload_1 
L60:    bipush 6 
L62:    iaload 
L63:    i2l 
L64:    ldc2_w 4294967295L 
L67:    land 
L68:    lstore 15 
L70:    aload_1 
L71:    bipush 7 
L73:    iaload 
L74:    i2l 
L75:    ldc2_w 4294967295L 
L78:    land 
L79:    lstore 17 
L81:    lconst_0 
L82:    lstore 19 
L84:    iconst_0 
L85:    istore 21 

        .stack full 
            locals Object [I Object [I Object [I Long Long Long Long Long Long Long Long Long Integer 
            stack 
        .end stack 
L87:    iload 21 
L89:    bipush 8 
L91:    if_icmpge L454 
L94:    lconst_0 
L95:    lstore 22 
L97:    aload_0 
L98:    iload 21 
L100:   iaload 
L101:   i2l 
L102:   ldc2_w 4294967295L 
L105:   land 
L106:   lstore 24 
L108:   lload 22 
L110:   lload 24 
L112:   lload_3 
L113:   lmul 
L114:   aload_2 
L115:   iload 21 
L117:   iaload 
L118:   i2l 
L119:   ldc2_w 4294967295L 
L122:   land 
L123:   ladd 
L124:   ladd 
L125:   lstore 22 
L127:   aload_2 
L128:   iload 21 
L130:   lload 22 
L132:   l2i 
L133:   iastore 
L134:   lload 22 
L136:   bipush 32 
L138:   lushr 
L139:   lstore 22 
L141:   lload 22 
L143:   lload 24 
L145:   lload 5 
L147:   lmul 
L148:   aload_2 
L149:   iload 21 
L151:   iconst_1 
L152:   iadd 
L153:   iaload 
L154:   i2l 
L155:   ldc2_w 4294967295L 
L158:   land 
L159:   ladd 
L160:   ladd 
L161:   lstore 22 
L163:   aload_2 
L164:   iload 21 
L166:   iconst_1 
L167:   iadd 
L168:   lload 22 
L170:   l2i 
L171:   iastore 
L172:   lload 22 
L174:   bipush 32 
L176:   lushr 
L177:   lstore 22 
L179:   lload 22 
L181:   lload 24 
L183:   lload 7 
L185:   lmul 
L186:   aload_2 
L187:   iload 21 
L189:   iconst_2 
L190:   iadd 
L191:   iaload 
L192:   i2l 
L193:   ldc2_w 4294967295L 
L196:   land 
L197:   ladd 
L198:   ladd 
L199:   lstore 22 
L201:   aload_2 
L202:   iload 21 
L204:   iconst_2 
L205:   iadd 
L206:   lload 22 
L208:   l2i 
L209:   iastore 
L210:   lload 22 
L212:   bipush 32 
L214:   lushr 
L215:   lstore 22 
L217:   lload 22 
L219:   lload 24 
L221:   lload 9 
L223:   lmul 
L224:   aload_2 
L225:   iload 21 
L227:   iconst_3 
L228:   iadd 
L229:   iaload 
L230:   i2l 
L231:   ldc2_w 4294967295L 
L234:   land 
L235:   ladd 
L236:   ladd 
L237:   lstore 22 
L239:   aload_2 
L240:   iload 21 
L242:   iconst_3 
L243:   iadd 
L244:   lload 22 
L246:   l2i 
L247:   iastore 
L248:   lload 22 
L250:   bipush 32 
L252:   lushr 
L253:   lstore 22 
L255:   lload 22 
L257:   lload 24 
L259:   lload 11 
L261:   lmul 
L262:   aload_2 
L263:   iload 21 
L265:   iconst_4 
L266:   iadd 
L267:   iaload 
L268:   i2l 
L269:   ldc2_w 4294967295L 
L272:   land 
L273:   ladd 
L274:   ladd 
L275:   lstore 22 
L277:   aload_2 
L278:   iload 21 
L280:   iconst_4 
L281:   iadd 
L282:   lload 22 
L284:   l2i 
L285:   iastore 
L286:   lload 22 
L288:   bipush 32 
L290:   lushr 
L291:   lstore 22 
L293:   lload 22 
L295:   lload 24 
L297:   lload 13 
L299:   lmul 
L300:   aload_2 
L301:   iload 21 
L303:   iconst_5 
L304:   iadd 
L305:   iaload 
L306:   i2l 
L307:   ldc2_w 4294967295L 
L310:   land 
L311:   ladd 
L312:   ladd 
L313:   lstore 22 
L315:   aload_2 
L316:   iload 21 
L318:   iconst_5 
L319:   iadd 
L320:   lload 22 
L322:   l2i 
L323:   iastore 
L324:   lload 22 
L326:   bipush 32 
L328:   lushr 
L329:   lstore 22 
L331:   lload 22 
L333:   lload 24 
L335:   lload 15 
L337:   lmul 
L338:   aload_2 
L339:   iload 21 
L341:   bipush 6 
L343:   iadd 
L344:   iaload 
L345:   i2l 
L346:   ldc2_w 4294967295L 
L349:   land 
L350:   ladd 
L351:   ladd 
L352:   lstore 22 
L354:   aload_2 
L355:   iload 21 
L357:   bipush 6 
L359:   iadd 
L360:   lload 22 
L362:   l2i 
L363:   iastore 
L364:   lload 22 
L366:   bipush 32 
L368:   lushr 
L369:   lstore 22 
L371:   lload 22 
L373:   lload 24 
L375:   lload 17 
L377:   lmul 
L378:   aload_2 
L379:   iload 21 
L381:   bipush 7 
L383:   iadd 
L384:   iaload 
L385:   i2l 
L386:   ldc2_w 4294967295L 
L389:   land 
L390:   ladd 
L391:   ladd 
L392:   lstore 22 
L394:   aload_2 
L395:   iload 21 
L397:   bipush 7 
L399:   iadd 
L400:   lload 22 
L402:   l2i 
L403:   iastore 
L404:   lload 22 
L406:   bipush 32 
L408:   lushr 
L409:   lstore 22 
L411:   lload 22 
L413:   lload 19 
L415:   aload_2 
L416:   iload 21 
L418:   bipush 8 
L420:   iadd 
L421:   iaload 
L422:   i2l 
L423:   ldc2_w 4294967295L 
L426:   land 
L427:   ladd 
L428:   ladd 
L429:   lstore 22 
L431:   aload_2 
L432:   iload 21 
L434:   bipush 8 
L436:   iadd 
L437:   lload 22 
L439:   l2i 
L440:   iastore 
L441:   lload 22 
L443:   bipush 32 
L445:   lushr 
L446:   lstore 19 
L448:   iinc 21 1 
L451:   goto L87 

        .stack chop 1 
L454:   lload 19 
L456:   l2i 
L457:   ireturn 
L458:   
        .linenumbertable 
            L0 278 
            L9 279 
            L19 280 
            L29 281 
            L39 282 
            L49 283 
            L59 284 
            L70 285 
            L81 287 
            L84 288 
            L94 290 
            L108 291 
            L127 292 
            L134 293 
            L141 294 
            L163 295 
            L172 296 
            L179 297 
            L201 298 
            L210 299 
            L217 300 
            L239 301 
            L248 302 
            L255 303 
            L277 304 
            L286 305 
            L293 306 
            L315 307 
            L324 308 
            L331 309 
            L354 310 
            L364 311 
            L371 312 
            L394 313 
            L404 314 
            L411 315 
            L431 316 
            L441 317 
            L448 288 
            L454 319 
        .end linenumbertable 
        .localvariabletable 
            22 is c J from L97 to L448 
            24 is x_i J from L108 to L448 
            21 is i I from L87 to L454 
            0 is x [I from L0 to L458 
            1 is y [I from L0 to L458 
            2 is zz [I from L0 to L458 
            3 is y_0 J from L9 to L458 
            5 is y_1 J from L19 to L458 
            7 is y_2 J from L29 to L458 
            9 is y_3 J from L39 to L458 
            11 is y_4 J from L49 to L458 
            13 is y_5 J from L59 to L458 
            15 is y_6 J from L70 to L458 
            17 is y_7 J from L81 to L458 
            19 is zc J from L84 to L458 
        .end localvariabletable 
    .end code 
.end method 

.method public static mul33Add : (I[II[II[II)J 
    .code stack 8 locals 27 
L0:     lconst_0 
L1:     lstore 7 
L3:     iload_0 
L4:     i2l 
L5:     ldc2_w 4294967295L 
L8:     land 
L9:     lstore 9 
L11:    aload_1 
L12:    iload_2 
L13:    iaload 
L14:    i2l 
L15:    ldc2_w 4294967295L 
L18:    land 
L19:    lstore 11 
L21:    lload 7 
L23:    lload 9 
L25:    lload 11 
L27:    lmul 
L28:    aload_3 
L29:    iload 4 
L31:    iaload 
L32:    i2l 
L33:    ldc2_w 4294967295L 
L36:    land 
L37:    ladd 
L38:    ladd 
L39:    lstore 7 
L41:    aload 5 
L43:    iload 6 
L45:    lload 7 
L47:    l2i 
L48:    iastore 
L49:    lload 7 
L51:    bipush 32 
L53:    lushr 
L54:    lstore 7 
L56:    aload_1 
L57:    iload_2 
L58:    iconst_1 
L59:    iadd 
L60:    iaload 
L61:    i2l 
L62:    ldc2_w 4294967295L 
L65:    land 
L66:    lstore 13 
L68:    lload 7 
L70:    lload 9 
L72:    lload 13 
L74:    lmul 
L75:    lload 11 
L77:    ladd 
L78:    aload_3 
L79:    iload 4 
L81:    iconst_1 
L82:    iadd 
L83:    iaload 
L84:    i2l 
L85:    ldc2_w 4294967295L 
L88:    land 
L89:    ladd 
L90:    ladd 
L91:    lstore 7 
L93:    aload 5 
L95:    iload 6 
L97:    iconst_1 
L98:    iadd 
L99:    lload 7 
L101:   l2i 
L102:   iastore 
L103:   lload 7 
L105:   bipush 32 
L107:   lushr 
L108:   lstore 7 
L110:   aload_1 
L111:   iload_2 
L112:   iconst_2 
L113:   iadd 
L114:   iaload 
L115:   i2l 
L116:   ldc2_w 4294967295L 
L119:   land 
L120:   lstore 15 
L122:   lload 7 
L124:   lload 9 
L126:   lload 15 
L128:   lmul 
L129:   lload 13 
L131:   ladd 
L132:   aload_3 
L133:   iload 4 
L135:   iconst_2 
L136:   iadd 
L137:   iaload 
L138:   i2l 
L139:   ldc2_w 4294967295L 
L142:   land 
L143:   ladd 
L144:   ladd 
L145:   lstore 7 
L147:   aload 5 
L149:   iload 6 
L151:   iconst_2 
L152:   iadd 
L153:   lload 7 
L155:   l2i 
L156:   iastore 
L157:   lload 7 
L159:   bipush 32 
L161:   lushr 
L162:   lstore 7 
L164:   aload_1 
L165:   iload_2 
L166:   iconst_3 
L167:   iadd 
L168:   iaload 
L169:   i2l 
L170:   ldc2_w 4294967295L 
L173:   land 
L174:   lstore 17 
L176:   lload 7 
L178:   lload 9 
L180:   lload 17 
L182:   lmul 
L183:   lload 15 
L185:   ladd 
L186:   aload_3 
L187:   iload 4 
L189:   iconst_3 
L190:   iadd 
L191:   iaload 
L192:   i2l 
L193:   ldc2_w 4294967295L 
L196:   land 
L197:   ladd 
L198:   ladd 
L199:   lstore 7 
L201:   aload 5 
L203:   iload 6 
L205:   iconst_3 
L206:   iadd 
L207:   lload 7 
L209:   l2i 
L210:   iastore 
L211:   lload 7 
L213:   bipush 32 
L215:   lushr 
L216:   lstore 7 
L218:   aload_1 
L219:   iload_2 
L220:   iconst_4 
L221:   iadd 
L222:   iaload 
L223:   i2l 
L224:   ldc2_w 4294967295L 
L227:   land 
L228:   lstore 19 
L230:   lload 7 
L232:   lload 9 
L234:   lload 19 
L236:   lmul 
L237:   lload 17 
L239:   ladd 
L240:   aload_3 
L241:   iload 4 
L243:   iconst_4 
L244:   iadd 
L245:   iaload 
L246:   i2l 
L247:   ldc2_w 4294967295L 
L250:   land 
L251:   ladd 
L252:   ladd 
L253:   lstore 7 
L255:   aload 5 
L257:   iload 6 
L259:   iconst_4 
L260:   iadd 
L261:   lload 7 
L263:   l2i 
L264:   iastore 
L265:   lload 7 
L267:   bipush 32 
L269:   lushr 
L270:   lstore 7 
L272:   aload_1 
L273:   iload_2 
L274:   iconst_5 
L275:   iadd 
L276:   iaload 
L277:   i2l 
L278:   ldc2_w 4294967295L 
L281:   land 
L282:   lstore 21 
L284:   lload 7 
L286:   lload 9 
L288:   lload 21 
L290:   lmul 
L291:   lload 19 
L293:   ladd 
L294:   aload_3 
L295:   iload 4 
L297:   iconst_5 
L298:   iadd 
L299:   iaload 
L300:   i2l 
L301:   ldc2_w 4294967295L 
L304:   land 
L305:   ladd 
L306:   ladd 
L307:   lstore 7 
L309:   aload 5 
L311:   iload 6 
L313:   iconst_5 
L314:   iadd 
L315:   lload 7 
L317:   l2i 
L318:   iastore 
L319:   lload 7 
L321:   bipush 32 
L323:   lushr 
L324:   lstore 7 
L326:   aload_1 
L327:   iload_2 
L328:   bipush 6 
L330:   iadd 
L331:   iaload 
L332:   i2l 
L333:   ldc2_w 4294967295L 
L336:   land 
L337:   lstore 23 
L339:   lload 7 
L341:   lload 9 
L343:   lload 23 
L345:   lmul 
L346:   lload 21 
L348:   ladd 
L349:   aload_3 
L350:   iload 4 
L352:   bipush 6 
L354:   iadd 
L355:   iaload 
L356:   i2l 
L357:   ldc2_w 4294967295L 
L360:   land 
L361:   ladd 
L362:   ladd 
L363:   lstore 7 
L365:   aload 5 
L367:   iload 6 
L369:   bipush 6 
L371:   iadd 
L372:   lload 7 
L374:   l2i 
L375:   iastore 
L376:   lload 7 
L378:   bipush 32 
L380:   lushr 
L381:   lstore 7 
L383:   aload_1 
L384:   iload_2 
L385:   bipush 7 
L387:   iadd 
L388:   iaload 
L389:   i2l 
L390:   ldc2_w 4294967295L 
L393:   land 
L394:   lstore 25 
L396:   lload 7 
L398:   lload 9 
L400:   lload 25 
L402:   lmul 
L403:   lload 23 
L405:   ladd 
L406:   aload_3 
L407:   iload 4 
L409:   bipush 7 
L411:   iadd 
L412:   iaload 
L413:   i2l 
L414:   ldc2_w 4294967295L 
L417:   land 
L418:   ladd 
L419:   ladd 
L420:   lstore 7 
L422:   aload 5 
L424:   iload 6 
L426:   bipush 7 
L428:   iadd 
L429:   lload 7 
L431:   l2i 
L432:   iastore 
L433:   lload 7 
L435:   bipush 32 
L437:   lushr 
L438:   lstore 7 
L440:   lload 7 
L442:   lload 25 
L444:   ladd 
L445:   lstore 7 
L447:   lload 7 
L449:   lreturn 
L450:   
        .linenumbertable 
            L0 326 
            L11 327 
            L21 328 
            L41 329 
            L49 330 
            L56 331 
            L68 332 
            L93 333 
            L103 334 
            L110 335 
            L122 336 
            L147 337 
            L157 338 
            L164 339 
            L176 340 
            L201 341 
            L211 342 
            L218 343 
            L230 344 
            L255 345 
            L265 346 
            L272 347 
            L284 348 
            L309 349 
            L319 350 
            L326 351 
            L339 352 
            L365 353 
            L376 354 
            L383 355 
            L396 356 
            L422 357 
            L433 358 
            L440 359 
            L447 360 
        .end linenumbertable 
        .localvariabletable 
            0 is w I from L0 to L450 
            1 is x [I from L0 to L450 
            2 is xOff I from L0 to L450 
            3 is y [I from L0 to L450 
            4 is yOff I from L0 to L450 
            5 is z [I from L0 to L450 
            6 is zOff I from L0 to L450 
            7 is c J from L3 to L450 
            9 is wVal J from L11 to L450 
            11 is x0 J from L21 to L450 
            13 is x1 J from L68 to L450 
            15 is x2 J from L122 to L450 
            17 is x3 J from L176 to L450 
            19 is x4 J from L230 to L450 
            21 is x5 J from L284 to L450 
            23 is x6 J from L339 to L450 
            25 is x7 J from L396 to L450 
        .end localvariabletable 
    .end code 
.end method 

.method public static mulByWordAddTo : (I[I[I)I 
    .code stack 8 locals 7 
L0:     lconst_0 
L1:     lstore_3 
L2:     iload_0 
L3:     i2l 
L4:     ldc2_w 4294967295L 
L7:     land 
L8:     lstore 5 
L10:    lload_3 
L11:    lload 5 
L13:    aload_2 
L14:    iconst_0 
L15:    iaload 
L16:    i2l 
L17:    ldc2_w 4294967295L 
L20:    land 
L21:    lmul 
L22:    aload_1 
L23:    iconst_0 
L24:    iaload 
L25:    i2l 
L26:    ldc2_w 4294967295L 
L29:    land 
L30:    ladd 
L31:    ladd 
L32:    lstore_3 
L33:    aload_2 
L34:    iconst_0 
L35:    lload_3 
L36:    l2i 
L37:    iastore 
L38:    lload_3 
L39:    bipush 32 
L41:    lushr 
L42:    lstore_3 
L43:    lload_3 
L44:    lload 5 
L46:    aload_2 
L47:    iconst_1 
L48:    iaload 
L49:    i2l 
L50:    ldc2_w 4294967295L 
L53:    land 
L54:    lmul 
L55:    aload_1 
L56:    iconst_1 
L57:    iaload 
L58:    i2l 
L59:    ldc2_w 4294967295L 
L62:    land 
L63:    ladd 
L64:    ladd 
L65:    lstore_3 
L66:    aload_2 
L67:    iconst_1 
L68:    lload_3 
L69:    l2i 
L70:    iastore 
L71:    lload_3 
L72:    bipush 32 
L74:    lushr 
L75:    lstore_3 
L76:    lload_3 
L77:    lload 5 
L79:    aload_2 
L80:    iconst_2 
L81:    iaload 
L82:    i2l 
L83:    ldc2_w 4294967295L 
L86:    land 
L87:    lmul 
L88:    aload_1 
L89:    iconst_2 
L90:    iaload 
L91:    i2l 
L92:    ldc2_w 4294967295L 
L95:    land 
L96:    ladd 
L97:    ladd 
L98:    lstore_3 
L99:    aload_2 
L100:   iconst_2 
L101:   lload_3 
L102:   l2i 
L103:   iastore 
L104:   lload_3 
L105:   bipush 32 
L107:   lushr 
L108:   lstore_3 
L109:   lload_3 
L110:   lload 5 
L112:   aload_2 
L113:   iconst_3 
L114:   iaload 
L115:   i2l 
L116:   ldc2_w 4294967295L 
L119:   land 
L120:   lmul 
L121:   aload_1 
L122:   iconst_3 
L123:   iaload 
L124:   i2l 
L125:   ldc2_w 4294967295L 
L128:   land 
L129:   ladd 
L130:   ladd 
L131:   lstore_3 
L132:   aload_2 
L133:   iconst_3 
L134:   lload_3 
L135:   l2i 
L136:   iastore 
L137:   lload_3 
L138:   bipush 32 
L140:   lushr 
L141:   lstore_3 
L142:   lload_3 
L143:   lload 5 
L145:   aload_2 
L146:   iconst_4 
L147:   iaload 
L148:   i2l 
L149:   ldc2_w 4294967295L 
L152:   land 
L153:   lmul 
L154:   aload_1 
L155:   iconst_4 
L156:   iaload 
L157:   i2l 
L158:   ldc2_w 4294967295L 
L161:   land 
L162:   ladd 
L163:   ladd 
L164:   lstore_3 
L165:   aload_2 
L166:   iconst_4 
L167:   lload_3 
L168:   l2i 
L169:   iastore 
L170:   lload_3 
L171:   bipush 32 
L173:   lushr 
L174:   lstore_3 
L175:   lload_3 
L176:   lload 5 
L178:   aload_2 
L179:   iconst_5 
L180:   iaload 
L181:   i2l 
L182:   ldc2_w 4294967295L 
L185:   land 
L186:   lmul 
L187:   aload_1 
L188:   iconst_5 
L189:   iaload 
L190:   i2l 
L191:   ldc2_w 4294967295L 
L194:   land 
L195:   ladd 
L196:   ladd 
L197:   lstore_3 
L198:   aload_2 
L199:   iconst_5 
L200:   lload_3 
L201:   l2i 
L202:   iastore 
L203:   lload_3 
L204:   bipush 32 
L206:   lushr 
L207:   lstore_3 
L208:   lload_3 
L209:   lload 5 
L211:   aload_2 
L212:   bipush 6 
L214:   iaload 
L215:   i2l 
L216:   ldc2_w 4294967295L 
L219:   land 
L220:   lmul 
L221:   aload_1 
L222:   bipush 6 
L224:   iaload 
L225:   i2l 
L226:   ldc2_w 4294967295L 
L229:   land 
L230:   ladd 
L231:   ladd 
L232:   lstore_3 
L233:   aload_2 
L234:   bipush 6 
L236:   lload_3 
L237:   l2i 
L238:   iastore 
L239:   lload_3 
L240:   bipush 32 
L242:   lushr 
L243:   lstore_3 
L244:   lload_3 
L245:   lload 5 
L247:   aload_2 
L248:   bipush 7 
L250:   iaload 
L251:   i2l 
L252:   ldc2_w 4294967295L 
L255:   land 
L256:   lmul 
L257:   aload_1 
L258:   bipush 7 
L260:   iaload 
L261:   i2l 
L262:   ldc2_w 4294967295L 
L265:   land 
L266:   ladd 
L267:   ladd 
L268:   lstore_3 
L269:   aload_2 
L270:   bipush 7 
L272:   lload_3 
L273:   l2i 
L274:   iastore 
L275:   lload_3 
L276:   bipush 32 
L278:   lushr 
L279:   lstore_3 
L280:   lload_3 
L281:   l2i 
L282:   ireturn 
L283:   
        .linenumbertable 
            L0 365 
            L10 366 
            L33 367 
            L38 368 
            L43 369 
            L66 370 
            L71 371 
            L76 372 
            L99 373 
            L104 374 
            L109 375 
            L132 376 
            L137 377 
            L142 378 
            L165 379 
            L170 380 
            L175 381 
            L198 382 
            L203 383 
            L208 384 
            L233 385 
            L239 386 
            L244 387 
            L269 388 
            L275 389 
            L280 390 
        .end linenumbertable 
        .localvariabletable 
            0 is x I from L0 to L283 
            1 is y [I from L0 to L283 
            2 is z [I from L0 to L283 
            3 is c J from L2 to L283 
            5 is xVal J from L10 to L283 
        .end localvariabletable 
    .end code 
.end method 

.method public static mul33DWordAdd : (IJ[II)I 
    .code stack 8 locals 13 
L0:     lconst_0 
L1:     lstore 5 
L3:     iload_0 
L4:     i2l 
L5:     ldc2_w 4294967295L 
L8:     land 
L9:     lstore 7 
L11:    lload_1 
L12:    ldc2_w 4294967295L 
L15:    land 
L16:    lstore 9 
L18:    lload 5 
L20:    lload 7 
L22:    lload 9 
L24:    lmul 
L25:    aload_3 
L26:    iload 4 
L28:    iaload 
L29:    i2l 
L30:    ldc2_w 4294967295L 
L33:    land 
L34:    ladd 
L35:    ladd 
L36:    lstore 5 
L38:    aload_3 
L39:    iload 4 
L41:    lload 5 
L43:    l2i 
L44:    iastore 
L45:    lload 5 
L47:    bipush 32 
L49:    lushr 
L50:    lstore 5 
L52:    lload_1 
L53:    bipush 32 
L55:    lushr 
L56:    lstore 11 
L58:    lload 5 
L60:    lload 7 
L62:    lload 11 
L64:    lmul 
L65:    lload 9 
L67:    ladd 
L68:    aload_3 
L69:    iload 4 
L71:    iconst_1 
L72:    iadd 
L73:    iaload 
L74:    i2l 
L75:    ldc2_w 4294967295L 
L78:    land 
L79:    ladd 
L80:    ladd 
L81:    lstore 5 
L83:    aload_3 
L84:    iload 4 
L86:    iconst_1 
L87:    iadd 
L88:    lload 5 
L90:    l2i 
L91:    iastore 
L92:    lload 5 
L94:    bipush 32 
L96:    lushr 
L97:    lstore 5 
L99:    lload 5 
L101:   lload 11 
L103:   aload_3 
L104:   iload 4 
L106:   iconst_2 
L107:   iadd 
L108:   iaload 
L109:   i2l 
L110:   ldc2_w 4294967295L 
L113:   land 
L114:   ladd 
L115:   ladd 
L116:   lstore 5 
L118:   aload_3 
L119:   iload 4 
L121:   iconst_2 
L122:   iadd 
L123:   lload 5 
L125:   l2i 
L126:   iastore 
L127:   lload 5 
L129:   bipush 32 
L131:   lushr 
L132:   lstore 5 
L134:   lload 5 
L136:   aload_3 
L137:   iload 4 
L139:   iconst_3 
L140:   iadd 
L141:   iaload 
L142:   i2l 
L143:   ldc2_w 4294967295L 
L146:   land 
L147:   ladd 
L148:   lstore 5 
L150:   aload_3 
L151:   iload 4 
L153:   iconst_3 
L154:   iadd 
L155:   lload 5 
L157:   l2i 
L158:   iastore 
L159:   lload 5 
L161:   bipush 32 
L163:   lushr 
L164:   lstore 5 
L166:   lload 5 
L168:   lconst_0 
L169:   lcmp 
L170:   ifne L177 
L173:   iconst_0 
L174:   goto L186 

        .stack full 
            locals Integer Long Object [I Integer Long Long Long Long 
            stack 
        .end stack 
L177:   bipush 8 
L179:   aload_3 
L180:   iload 4 
L182:   iconst_4 
L183:   invokestatic Method Nat incAt (I[III)I 

        .stack stack_1 Integer 
L186:   ireturn 
L187:   
        .linenumbertable 
            L0 398 
            L11 399 
            L18 400 
            L38 401 
            L45 402 
            L52 403 
            L58 404 
            L83 405 
            L92 406 
            L99 407 
            L118 408 
            L127 409 
            L134 410 
            L150 411 
            L159 412 
            L166 413 
        .end linenumbertable 
        .localvariabletable 
            0 is x I from L0 to L187 
            1 is y J from L0 to L187 
            3 is z [I from L0 to L187 
            4 is zOff I from L0 to L187 
            5 is c J from L3 to L187 
            7 is xVal J from L11 to L187 
            9 is y00 J from L18 to L187 
            11 is y01 J from L58 to L187 
        .end localvariabletable 
    .end code 
.end method 

.method public static mul33WordAdd : (II[II)I 
    .code stack 8 locals 10 
L0:     lconst_0 
L1:     lstore 4 
L3:     iload_0 
L4:     i2l 
L5:     ldc2_w 4294967295L 
L8:     land 
L9:     lstore 6 
L11:    iload_1 
L12:    i2l 
L13:    ldc2_w 4294967295L 
L16:    land 
L17:    lstore 8 
L19:    lload 4 
L21:    lload 8 
L23:    lload 6 
L25:    lmul 
L26:    aload_2 
L27:    iload_3 
L28:    iaload 
L29:    i2l 
L30:    ldc2_w 4294967295L 
L33:    land 
L34:    ladd 
L35:    ladd 
L36:    lstore 4 
L38:    aload_2 
L39:    iload_3 
L40:    lload 4 
L42:    l2i 
L43:    iastore 
L44:    lload 4 
L46:    bipush 32 
L48:    lushr 
L49:    lstore 4 
L51:    lload 4 
L53:    lload 8 
L55:    aload_2 
L56:    iload_3 
L57:    iconst_1 
L58:    iadd 
L59:    iaload 
L60:    i2l 
L61:    ldc2_w 4294967295L 
L64:    land 
L65:    ladd 
L66:    ladd 
L67:    lstore 4 
L69:    aload_2 
L70:    iload_3 
L71:    iconst_1 
L72:    iadd 
L73:    lload 4 
L75:    l2i 
L76:    iastore 
L77:    lload 4 
L79:    bipush 32 
L81:    lushr 
L82:    lstore 4 
L84:    lload 4 
L86:    aload_2 
L87:    iload_3 
L88:    iconst_2 
L89:    iadd 
L90:    iaload 
L91:    i2l 
L92:    ldc2_w 4294967295L 
L95:    land 
L96:    ladd 
L97:    lstore 4 
L99:    aload_2 
L100:   iload_3 
L101:   iconst_2 
L102:   iadd 
L103:   lload 4 
L105:   l2i 
L106:   iastore 
L107:   lload 4 
L109:   bipush 32 
L111:   lushr 
L112:   lstore 4 
L114:   lload 4 
L116:   lconst_0 
L117:   lcmp 
L118:   ifne L125 
L121:   iconst_0 
L122:   goto L133 

        .stack append Long Long Long 
L125:   bipush 8 
L127:   aload_2 
L128:   iload_3 
L129:   iconst_3 
L130:   invokestatic Method Nat incAt (I[III)I 

        .stack stack_1 Integer 
L133:   ireturn 
L134:   
        .linenumbertable 
            L0 421 
            L19 422 
            L38 423 
            L44 424 
            L51 425 
            L69 426 
            L77 427 
            L84 428 
            L99 429 
            L107 430 
            L114 431 
        .end linenumbertable 
        .localvariabletable 
            0 is x I from L0 to L134 
            1 is y I from L0 to L134 
            2 is z [I from L0 to L134 
            3 is zOff I from L0 to L134 
            4 is c J from L3 to L134 
            6 is xVal J from L11 to L134 
            8 is yVal J from L19 to L134 
        .end localvariabletable 
    .end code 
.end method 

.method public static square : ([I[I)V 
    .code stack 8 locals 48 
L0:     aload_0 
L1:     iconst_0 
L2:     iaload 
L3:     i2l 
L4:     ldc2_w 4294967295L 
L7:     land 
L8:     lstore_2 
L9:     iconst_0 
L10:    istore 6 
L12:    bipush 7 
L14:    istore 8 
L16:    bipush 16 
L18:    istore 9 

        .stack full 
            locals Object [I Object [I Long Top Top Integer Top Integer Integer 
            stack 
        .end stack 
L20:    aload_0 
L21:    iload 8 
L23:    iinc 8 -1 
L26:    iaload 
L27:    i2l 
L28:    ldc2_w 4294967295L 
L31:    land 
L32:    lstore 10 
L34:    lload 10 
L36:    lload 10 
L38:    lmul 
L39:    lstore 12 
L41:    aload_1 
L42:    iinc 9 -1 
L45:    iload 9 
L47:    iload 6 
L49:    bipush 31 
L51:    ishl 
L52:    lload 12 
L54:    bipush 33 
L56:    lushr 
L57:    l2i 
L58:    ior 
L59:    iastore 
L60:    aload_1 
L61:    iinc 9 -1 
L64:    iload 9 
L66:    lload 12 
L68:    iconst_1 
L69:    lushr 
L70:    l2i 
L71:    iastore 
L72:    lload 12 
L74:    l2i 
L75:    istore 6 
L77:    iload 8 
L79:    ifgt L20 
L82:    lload_2 
L83:    lload_2 
L84:    lmul 
L85:    lstore 10 
L87:    iload 6 
L89:    bipush 31 
L91:    ishl 
L92:    i2l 
L93:    ldc2_w 4294967295L 
L96:    land 
L97:    lload 10 
L99:    bipush 33 
L101:   lushr 
L102:   lor 
L103:   lstore 4 
L105:   aload_1 
L106:   iconst_0 
L107:   lload 10 
L109:   l2i 
L110:   iastore 
L111:   lload 10 
L113:   bipush 32 
L115:   lushr 
L116:   l2i 
L117:   iconst_1 
L118:   iand 
L119:   istore 6 
L121:   aload_0 
L122:   iconst_1 
L123:   iaload 
L124:   i2l 
L125:   ldc2_w 4294967295L 
L128:   land 
L129:   lstore 8 
L131:   aload_1 
L132:   iconst_2 
L133:   iaload 
L134:   i2l 
L135:   ldc2_w 4294967295L 
L138:   land 
L139:   lstore 10 
L141:   lload 4 
L143:   lload 8 
L145:   lload_2 
L146:   lmul 
L147:   ladd 
L148:   lstore 4 
L150:   lload 4 
L152:   l2i 
L153:   istore 7 
L155:   aload_1 
L156:   iconst_1 
L157:   iload 7 
L159:   iconst_1 
L160:   ishl 
L161:   iload 6 
L163:   ior 
L164:   iastore 
L165:   iload 7 
L167:   bipush 31 
L169:   iushr 
L170:   istore 6 
L172:   lload 10 
L174:   lload 4 
L176:   bipush 32 
L178:   lushr 
L179:   ladd 
L180:   lstore 10 
L182:   aload_0 
L183:   iconst_2 
L184:   iaload 
L185:   i2l 
L186:   ldc2_w 4294967295L 
L189:   land 
L190:   lstore 12 
L192:   aload_1 
L193:   iconst_3 
L194:   iaload 
L195:   i2l 
L196:   ldc2_w 4294967295L 
L199:   land 
L200:   lstore 14 
L202:   aload_1 
L203:   iconst_4 
L204:   iaload 
L205:   i2l 
L206:   ldc2_w 4294967295L 
L209:   land 
L210:   lstore 16 
L212:   lload 10 
L214:   lload 12 
L216:   lload_2 
L217:   lmul 
L218:   ladd 
L219:   lstore 10 
L221:   lload 10 
L223:   l2i 
L224:   istore 7 
L226:   aload_1 
L227:   iconst_2 
L228:   iload 7 
L230:   iconst_1 
L231:   ishl 
L232:   iload 6 
L234:   ior 
L235:   iastore 
L236:   iload 7 
L238:   bipush 31 
L240:   iushr 
L241:   istore 6 
L243:   lload 14 
L245:   lload 10 
L247:   bipush 32 
L249:   lushr 
L250:   lload 12 
L252:   lload 8 
L254:   lmul 
L255:   ladd 
L256:   ladd 
L257:   lstore 14 
L259:   lload 16 
L261:   lload 14 
L263:   bipush 32 
L265:   lushr 
L266:   ladd 
L267:   lstore 16 
L269:   lload 14 
L271:   ldc2_w 4294967295L 
L274:   land 
L275:   lstore 14 
L277:   aload_0 
L278:   iconst_3 
L279:   iaload 
L280:   i2l 
L281:   ldc2_w 4294967295L 
L284:   land 
L285:   lstore 18 
L287:   aload_1 
L288:   iconst_5 
L289:   iaload 
L290:   i2l 
L291:   ldc2_w 4294967295L 
L294:   land 
L295:   lload 16 
L297:   bipush 32 
L299:   lushr 
L300:   ladd 
L301:   lstore 20 
L303:   lload 16 
L305:   ldc2_w 4294967295L 
L308:   land 
L309:   lstore 16 
L311:   aload_1 
L312:   bipush 6 
L314:   iaload 
L315:   i2l 
L316:   ldc2_w 4294967295L 
L319:   land 
L320:   lload 20 
L322:   bipush 32 
L324:   lushr 
L325:   ladd 
L326:   lstore 22 
L328:   lload 20 
L330:   ldc2_w 4294967295L 
L333:   land 
L334:   lstore 20 
L336:   lload 14 
L338:   lload 18 
L340:   lload_2 
L341:   lmul 
L342:   ladd 
L343:   lstore 14 
L345:   lload 14 
L347:   l2i 
L348:   istore 7 
L350:   aload_1 
L351:   iconst_3 
L352:   iload 7 
L354:   iconst_1 
L355:   ishl 
L356:   iload 6 
L358:   ior 
L359:   iastore 
L360:   iload 7 
L362:   bipush 31 
L364:   iushr 
L365:   istore 6 
L367:   lload 16 
L369:   lload 14 
L371:   bipush 32 
L373:   lushr 
L374:   lload 18 
L376:   lload 8 
L378:   lmul 
L379:   ladd 
L380:   ladd 
L381:   lstore 16 
L383:   lload 20 
L385:   lload 16 
L387:   bipush 32 
L389:   lushr 
L390:   lload 18 
L392:   lload 12 
L394:   lmul 
L395:   ladd 
L396:   ladd 
L397:   lstore 20 
L399:   lload 16 
L401:   ldc2_w 4294967295L 
L404:   land 
L405:   lstore 16 
L407:   lload 22 
L409:   lload 20 
L411:   bipush 32 
L413:   lushr 
L414:   ladd 
L415:   lstore 22 
L417:   lload 20 
L419:   ldc2_w 4294967295L 
L422:   land 
L423:   lstore 20 
L425:   aload_0 
L426:   iconst_4 
L427:   iaload 
L428:   i2l 
L429:   ldc2_w 4294967295L 
L432:   land 
L433:   lstore 24 
L435:   aload_1 
L436:   bipush 7 
L438:   iaload 
L439:   i2l 
L440:   ldc2_w 4294967295L 
L443:   land 
L444:   lload 22 
L446:   bipush 32 
L448:   lushr 
L449:   ladd 
L450:   lstore 26 
L452:   lload 22 
L454:   ldc2_w 4294967295L 
L457:   land 
L458:   lstore 22 
L460:   aload_1 
L461:   bipush 8 
L463:   iaload 
L464:   i2l 
L465:   ldc2_w 4294967295L 
L468:   land 
L469:   lload 26 
L471:   bipush 32 
L473:   lushr 
L474:   ladd 
L475:   lstore 28 
L477:   lload 26 
L479:   ldc2_w 4294967295L 
L482:   land 
L483:   lstore 26 
L485:   lload 16 
L487:   lload 24 
L489:   lload_2 
L490:   lmul 
L491:   ladd 
L492:   lstore 16 
L494:   lload 16 
L496:   l2i 
L497:   istore 7 
L499:   aload_1 
L500:   iconst_4 
L501:   iload 7 
L503:   iconst_1 
L504:   ishl 
L505:   iload 6 
L507:   ior 
L508:   iastore 
L509:   iload 7 
L511:   bipush 31 
L513:   iushr 
L514:   istore 6 
L516:   lload 20 
L518:   lload 16 
L520:   bipush 32 
L522:   lushr 
L523:   lload 24 
L525:   lload 8 
L527:   lmul 
L528:   ladd 
L529:   ladd 
L530:   lstore 20 
L532:   lload 22 
L534:   lload 20 
L536:   bipush 32 
L538:   lushr 
L539:   lload 24 
L541:   lload 12 
L543:   lmul 
L544:   ladd 
L545:   ladd 
L546:   lstore 22 
L548:   lload 20 
L550:   ldc2_w 4294967295L 
L553:   land 
L554:   lstore 20 
L556:   lload 26 
L558:   lload 22 
L560:   bipush 32 
L562:   lushr 
L563:   lload 24 
L565:   lload 18 
L567:   lmul 
L568:   ladd 
L569:   ladd 
L570:   lstore 26 
L572:   lload 22 
L574:   ldc2_w 4294967295L 
L577:   land 
L578:   lstore 22 
L580:   lload 28 
L582:   lload 26 
L584:   bipush 32 
L586:   lushr 
L587:   ladd 
L588:   lstore 28 
L590:   lload 26 
L592:   ldc2_w 4294967295L 
L595:   land 
L596:   lstore 26 
L598:   aload_0 
L599:   iconst_5 
L600:   iaload 
L601:   i2l 
L602:   ldc2_w 4294967295L 
L605:   land 
L606:   lstore 30 
L608:   aload_1 
L609:   bipush 9 
L611:   iaload 
L612:   i2l 
L613:   ldc2_w 4294967295L 
L616:   land 
L617:   lload 28 
L619:   bipush 32 
L621:   lushr 
L622:   ladd 
L623:   lstore 32 
L625:   lload 28 
L627:   ldc2_w 4294967295L 
L630:   land 
L631:   lstore 28 
L633:   aload_1 
L634:   bipush 10 
L636:   iaload 
L637:   i2l 
L638:   ldc2_w 4294967295L 
L641:   land 
L642:   lload 32 
L644:   bipush 32 
L646:   lushr 
L647:   ladd 
L648:   lstore 34 
L650:   lload 32 
L652:   ldc2_w 4294967295L 
L655:   land 
L656:   lstore 32 
L658:   lload 20 
L660:   lload 30 
L662:   lload_2 
L663:   lmul 
L664:   ladd 
L665:   lstore 20 
L667:   lload 20 
L669:   l2i 
L670:   istore 7 
L672:   aload_1 
L673:   iconst_5 
L674:   iload 7 
L676:   iconst_1 
L677:   ishl 
L678:   iload 6 
L680:   ior 
L681:   iastore 
L682:   iload 7 
L684:   bipush 31 
L686:   iushr 
L687:   istore 6 
L689:   lload 22 
L691:   lload 20 
L693:   bipush 32 
L695:   lushr 
L696:   lload 30 
L698:   lload 8 
L700:   lmul 
L701:   ladd 
L702:   ladd 
L703:   lstore 22 
L705:   lload 26 
L707:   lload 22 
L709:   bipush 32 
L711:   lushr 
L712:   lload 30 
L714:   lload 12 
L716:   lmul 
L717:   ladd 
L718:   ladd 
L719:   lstore 26 
L721:   lload 22 
L723:   ldc2_w 4294967295L 
L726:   land 
L727:   lstore 22 
L729:   lload 28 
L731:   lload 26 
L733:   bipush 32 
L735:   lushr 
L736:   lload 30 
L738:   lload 18 
L740:   lmul 
L741:   ladd 
L742:   ladd 
L743:   lstore 28 
L745:   lload 26 
L747:   ldc2_w 4294967295L 
L750:   land 
L751:   lstore 26 
L753:   lload 32 
L755:   lload 28 
L757:   bipush 32 
L759:   lushr 
L760:   lload 30 
L762:   lload 24 
L764:   lmul 
L765:   ladd 
L766:   ladd 
L767:   lstore 32 
L769:   lload 28 
L771:   ldc2_w 4294967295L 
L774:   land 
L775:   lstore 28 
L777:   lload 34 
L779:   lload 32 
L781:   bipush 32 
L783:   lushr 
L784:   ladd 
L785:   lstore 34 
L787:   lload 32 
L789:   ldc2_w 4294967295L 
L792:   land 
L793:   lstore 32 
L795:   aload_0 
L796:   bipush 6 
L798:   iaload 
L799:   i2l 
L800:   ldc2_w 4294967295L 
L803:   land 
L804:   lstore 36 
L806:   aload_1 
L807:   bipush 11 
L809:   iaload 
L810:   i2l 
L811:   ldc2_w 4294967295L 
L814:   land 
L815:   lload 34 
L817:   bipush 32 
L819:   lushr 
L820:   ladd 
L821:   lstore 38 
L823:   lload 34 
L825:   ldc2_w 4294967295L 
L828:   land 
L829:   lstore 34 
L831:   aload_1 
L832:   bipush 12 
L834:   iaload 
L835:   i2l 
L836:   ldc2_w 4294967295L 
L839:   land 
L840:   lload 38 
L842:   bipush 32 
L844:   lushr 
L845:   ladd 
L846:   lstore 40 
L848:   lload 38 
L850:   ldc2_w 4294967295L 
L853:   land 
L854:   lstore 38 
L856:   lload 22 
L858:   lload 36 
L860:   lload_2 
L861:   lmul 
L862:   ladd 
L863:   lstore 22 
L865:   lload 22 
L867:   l2i 
L868:   istore 7 
L870:   aload_1 
L871:   bipush 6 
L873:   iload 7 
L875:   iconst_1 
L876:   ishl 
L877:   iload 6 
L879:   ior 
L880:   iastore 
L881:   iload 7 
L883:   bipush 31 
L885:   iushr 
L886:   istore 6 
L888:   lload 26 
L890:   lload 22 
L892:   bipush 32 
L894:   lushr 
L895:   lload 36 
L897:   lload 8 
L899:   lmul 
L900:   ladd 
L901:   ladd 
L902:   lstore 26 
L904:   lload 28 
L906:   lload 26 
L908:   bipush 32 
L910:   lushr 
L911:   lload 36 
L913:   lload 12 
L915:   lmul 
L916:   ladd 
L917:   ladd 
L918:   lstore 28 
L920:   lload 26 
L922:   ldc2_w 4294967295L 
L925:   land 
L926:   lstore 26 
L928:   lload 32 
L930:   lload 28 
L932:   bipush 32 
L934:   lushr 
L935:   lload 36 
L937:   lload 18 
L939:   lmul 
L940:   ladd 
L941:   ladd 
L942:   lstore 32 
L944:   lload 28 
L946:   ldc2_w 4294967295L 
L949:   land 
L950:   lstore 28 
L952:   lload 34 
L954:   lload 32 
L956:   bipush 32 
L958:   lushr 
L959:   lload 36 
L961:   lload 24 
L963:   lmul 
L964:   ladd 
L965:   ladd 
L966:   lstore 34 
L968:   lload 32 
L970:   ldc2_w 4294967295L 
L973:   land 
L974:   lstore 32 
L976:   lload 38 
L978:   lload 34 
L980:   bipush 32 
L982:   lushr 
L983:   lload 36 
L985:   lload 30 
L987:   lmul 
L988:   ladd 
L989:   ladd 
L990:   lstore 38 
L992:   lload 34 
L994:   ldc2_w 4294967295L 
L997:   land 
L998:   lstore 34 
L1000:  lload 40 
L1002:  lload 38 
L1004:  bipush 32 
L1006:  lushr 
L1007:  ladd 
L1008:  lstore 40 
L1010:  lload 38 
L1012:  ldc2_w 4294967295L 
L1015:  land 
L1016:  lstore 38 
L1018:  aload_0 
L1019:  bipush 7 
L1021:  iaload 
L1022:  i2l 
L1023:  ldc2_w 4294967295L 
L1026:  land 
L1027:  lstore 42 
L1029:  aload_1 
L1030:  bipush 13 
L1032:  iaload 
L1033:  i2l 
L1034:  ldc2_w 4294967295L 
L1037:  land 
L1038:  lload 40 
L1040:  bipush 32 
L1042:  lushr 
L1043:  ladd 
L1044:  lstore 44 
L1046:  lload 40 
L1048:  ldc2_w 4294967295L 
L1051:  land 
L1052:  lstore 40 
L1054:  aload_1 
L1055:  bipush 14 
L1057:  iaload 
L1058:  i2l 
L1059:  ldc2_w 4294967295L 
L1062:  land 
L1063:  lload 44 
L1065:  bipush 32 
L1067:  lushr 
L1068:  ladd 
L1069:  lstore 46 
L1071:  lload 44 
L1073:  ldc2_w 4294967295L 
L1076:  land 
L1077:  lstore 44 
L1079:  lload 26 
L1081:  lload 42 
L1083:  lload_2 
L1084:  lmul 
L1085:  ladd 
L1086:  lstore 26 
L1088:  lload 26 
L1090:  l2i 
L1091:  istore 7 
L1093:  aload_1 
L1094:  bipush 7 
L1096:  iload 7 
L1098:  iconst_1 
L1099:  ishl 
L1100:  iload 6 
L1102:  ior 
L1103:  iastore 
L1104:  iload 7 
L1106:  bipush 31 
L1108:  iushr 
L1109:  istore 6 
L1111:  lload 28 
L1113:  lload 26 
L1115:  bipush 32 
L1117:  lushr 
L1118:  lload 42 
L1120:  lload 8 
L1122:  lmul 
L1123:  ladd 
L1124:  ladd 
L1125:  lstore 28 
L1127:  lload 32 
L1129:  lload 28 
L1131:  bipush 32 
L1133:  lushr 
L1134:  lload 42 
L1136:  lload 12 
L1138:  lmul 
L1139:  ladd 
L1140:  ladd 
L1141:  lstore 32 
L1143:  lload 34 
L1145:  lload 32 
L1147:  bipush 32 
L1149:  lushr 
L1150:  lload 42 
L1152:  lload 18 
L1154:  lmul 
L1155:  ladd 
L1156:  ladd 
L1157:  lstore 34 
L1159:  lload 38 
L1161:  lload 34 
L1163:  bipush 32 
L1165:  lushr 
L1166:  lload 42 
L1168:  lload 24 
L1170:  lmul 
L1171:  ladd 
L1172:  ladd 
L1173:  lstore 38 
L1175:  lload 40 
L1177:  lload 38 
L1179:  bipush 32 
L1181:  lushr 
L1182:  lload 42 
L1184:  lload 30 
L1186:  lmul 
L1187:  ladd 
L1188:  ladd 
L1189:  lstore 40 
L1191:  lload 44 
L1193:  lload 40 
L1195:  bipush 32 
L1197:  lushr 
L1198:  lload 42 
L1200:  lload 36 
L1202:  lmul 
L1203:  ladd 
L1204:  ladd 
L1205:  lstore 44 
L1207:  lload 46 
L1209:  lload 44 
L1211:  bipush 32 
L1213:  lushr 
L1214:  ladd 
L1215:  lstore 46 
L1217:  lload 28 
L1219:  l2i 
L1220:  istore 7 
L1222:  aload_1 
L1223:  bipush 8 
L1225:  iload 7 
L1227:  iconst_1 
L1228:  ishl 
L1229:  iload 6 
L1231:  ior 
L1232:  iastore 
L1233:  iload 7 
L1235:  bipush 31 
L1237:  iushr 
L1238:  istore 6 
L1240:  lload 32 
L1242:  l2i 
L1243:  istore 7 
L1245:  aload_1 
L1246:  bipush 9 
L1248:  iload 7 
L1250:  iconst_1 
L1251:  ishl 
L1252:  iload 6 
L1254:  ior 
L1255:  iastore 
L1256:  iload 7 
L1258:  bipush 31 
L1260:  iushr 
L1261:  istore 6 
L1263:  lload 34 
L1265:  l2i 
L1266:  istore 7 
L1268:  aload_1 
L1269:  bipush 10 
L1271:  iload 7 
L1273:  iconst_1 
L1274:  ishl 
L1275:  iload 6 
L1277:  ior 
L1278:  iastore 
L1279:  iload 7 
L1281:  bipush 31 
L1283:  iushr 
L1284:  istore 6 
L1286:  lload 38 
L1288:  l2i 
L1289:  istore 7 
L1291:  aload_1 
L1292:  bipush 11 
L1294:  iload 7 
L1296:  iconst_1 
L1297:  ishl 
L1298:  iload 6 
L1300:  ior 
L1301:  iastore 
L1302:  iload 7 
L1304:  bipush 31 
L1306:  iushr 
L1307:  istore 6 
L1309:  lload 40 
L1311:  l2i 
L1312:  istore 7 
L1314:  aload_1 
L1315:  bipush 12 
L1317:  iload 7 
L1319:  iconst_1 
L1320:  ishl 
L1321:  iload 6 
L1323:  ior 
L1324:  iastore 
L1325:  iload 7 
L1327:  bipush 31 
L1329:  iushr 
L1330:  istore 6 
L1332:  lload 44 
L1334:  l2i 
L1335:  istore 7 
L1337:  aload_1 
L1338:  bipush 13 
L1340:  iload 7 
L1342:  iconst_1 
L1343:  ishl 
L1344:  iload 6 
L1346:  ior 
L1347:  iastore 
L1348:  iload 7 
L1350:  bipush 31 
L1352:  iushr 
L1353:  istore 6 
L1355:  lload 46 
L1357:  l2i 
L1358:  istore 7 
L1360:  aload_1 
L1361:  bipush 14 
L1363:  iload 7 
L1365:  iconst_1 
L1366:  ishl 
L1367:  iload 6 
L1369:  ior 
L1370:  iastore 
L1371:  iload 7 
L1373:  bipush 31 
L1375:  iushr 
L1376:  istore 6 
L1378:  aload_1 
L1379:  bipush 15 
L1381:  iaload 
L1382:  lload 46 
L1384:  bipush 32 
L1386:  lushr 
L1387:  l2i 
L1388:  iadd 
L1389:  istore 7 
L1391:  aload_1 
L1392:  bipush 15 
L1394:  iload 7 
L1396:  iconst_1 
L1397:  ishl 
L1398:  iload 6 
L1400:  ior 
L1401:  iastore 
L1402:  return 
L1403:  
        .linenumbertable 
            L0 436 
            L9 439 
            L12 441 
            L20 444 
            L34 445 
            L41 446 
            L60 447 
            L72 448 
            L77 450 
            L82 453 
            L87 454 
            L105 455 
            L111 456 
            L121 460 
            L131 461 
            L141 464 
            L150 465 
            L155 466 
            L165 467 
            L172 468 
            L182 471 
            L192 472 
            L202 473 
            L212 475 
            L221 476 
            L226 477 
            L236 478 
            L243 479 
            L259 480 
            L269 481 
            L277 484 
            L287 485 
            L311 486 
            L336 488 
            L345 489 
            L350 490 
            L360 491 
            L367 492 
            L383 493 
            L399 494 
            L407 495 
            L417 496 
            L425 499 
            L435 500 
            L460 501 
            L485 503 
            L494 504 
            L499 505 
            L509 506 
            L516 507 
            L532 508 
            L548 509 
            L556 510 
            L572 511 
            L580 512 
            L590 513 
            L598 516 
            L608 517 
            L633 518 
            L658 520 
            L667 521 
            L672 522 
            L682 523 
            L689 524 
            L705 525 
            L721 526 
            L729 527 
            L745 528 
            L753 529 
            L769 530 
            L777 531 
            L787 532 
            L795 535 
            L806 536 
            L831 537 
            L856 539 
            L865 540 
            L870 541 
            L881 542 
            L888 543 
            L904 544 
            L920 545 
            L928 546 
            L944 547 
            L952 548 
            L968 549 
            L976 550 
            L992 551 
            L1000 552 
            L1010 553 
            L1018 556 
            L1029 557 
            L1054 558 
            L1079 560 
            L1088 561 
            L1093 562 
            L1104 563 
            L1111 564 
            L1127 565 
            L1143 566 
            L1159 567 
            L1175 568 
            L1191 569 
            L1207 570 
            L1217 573 
            L1222 574 
            L1233 575 
            L1240 576 
            L1245 577 
            L1256 578 
            L1263 579 
            L1268 580 
            L1279 581 
            L1286 582 
            L1291 583 
            L1302 584 
            L1309 585 
            L1314 586 
            L1325 587 
            L1332 588 
            L1337 589 
            L1348 590 
            L1355 591 
            L1360 592 
            L1371 593 
            L1378 594 
            L1391 595 
            L1402 596 
        .end linenumbertable 
        .localvariabletable 
            10 is xVal J from L34 to L77 
            12 is p J from L41 to L77 
            10 is p J from L87 to L121 
            8 is i I from L16 to L121 
            9 is j I from L20 to L121 
            0 is x [I from L0 to L1403 
            1 is zz [I from L0 to L1403 
            2 is x_0 J from L9 to L1403 
            4 is zz_1 J from L105 to L1403 
            6 is c I from L12 to L1403 
            7 is w I from L155 to L1403 
            8 is x_1 J from L131 to L1403 
            10 is zz_2 J from L141 to L1403 
            12 is x_2 J from L192 to L1403 
            14 is zz_3 J from L202 to L1403 
            16 is zz_4 J from L212 to L1403 
            18 is x_3 J from L287 to L1403 
            20 is zz_5 J from L303 to L1403 
            22 is zz_6 J from L328 to L1403 
            24 is x_4 J from L435 to L1403 
            26 is zz_7 J from L452 to L1403 
            28 is zz_8 J from L477 to L1403 
            30 is x_5 J from L608 to L1403 
            32 is zz_9 J from L625 to L1403 
            34 is zz_10 J from L650 to L1403 
            36 is x_6 J from L806 to L1403 
            38 is zz_11 J from L823 to L1403 
            40 is zz_12 J from L848 to L1403 
            42 is x_7 J from L1029 to L1403 
            44 is zz_13 J from L1046 to L1403 
            46 is zz_14 J from L1071 to L1403 
        .end localvariabletable 
    .end code 
.end method 

.method public static sub : ([I[I[I)I 
    .code stack 8 locals 5 
L0:     lconst_0 
L1:     lstore_3 
L2:     lload_3 
L3:     aload_0 
L4:     iconst_0 
L5:     iaload 
L6:     i2l 
L7:     ldc2_w 4294967295L 
L10:    land 
L11:    aload_1 
L12:    iconst_0 
L13:    iaload 
L14:    i2l 
L15:    ldc2_w 4294967295L 
L18:    land 
L19:    lsub 
L20:    ladd 
L21:    lstore_3 
L22:    aload_2 
L23:    iconst_0 
L24:    lload_3 
L25:    l2i 
L26:    iastore 
L27:    lload_3 
L28:    bipush 32 
L30:    lshr 
L31:    lstore_3 
L32:    lload_3 
L33:    aload_0 
L34:    iconst_1 
L35:    iaload 
L36:    i2l 
L37:    ldc2_w 4294967295L 
L40:    land 
L41:    aload_1 
L42:    iconst_1 
L43:    iaload 
L44:    i2l 
L45:    ldc2_w 4294967295L 
L48:    land 
L49:    lsub 
L50:    ladd 
L51:    lstore_3 
L52:    aload_2 
L53:    iconst_1 
L54:    lload_3 
L55:    l2i 
L56:    iastore 
L57:    lload_3 
L58:    bipush 32 
L60:    lshr 
L61:    lstore_3 
L62:    lload_3 
L63:    aload_0 
L64:    iconst_2 
L65:    iaload 
L66:    i2l 
L67:    ldc2_w 4294967295L 
L70:    land 
L71:    aload_1 
L72:    iconst_2 
L73:    iaload 
L74:    i2l 
L75:    ldc2_w 4294967295L 
L78:    land 
L79:    lsub 
L80:    ladd 
L81:    lstore_3 
L82:    aload_2 
L83:    iconst_2 
L84:    lload_3 
L85:    l2i 
L86:    iastore 
L87:    lload_3 
L88:    bipush 32 
L90:    lshr 
L91:    lstore_3 
L92:    lload_3 
L93:    aload_0 
L94:    iconst_3 
L95:    iaload 
L96:    i2l 
L97:    ldc2_w 4294967295L 
L100:   land 
L101:   aload_1 
L102:   iconst_3 
L103:   iaload 
L104:   i2l 
L105:   ldc2_w 4294967295L 
L108:   land 
L109:   lsub 
L110:   ladd 
L111:   lstore_3 
L112:   aload_2 
L113:   iconst_3 
L114:   lload_3 
L115:   l2i 
L116:   iastore 
L117:   lload_3 
L118:   bipush 32 
L120:   lshr 
L121:   lstore_3 
L122:   lload_3 
L123:   aload_0 
L124:   iconst_4 
L125:   iaload 
L126:   i2l 
L127:   ldc2_w 4294967295L 
L130:   land 
L131:   aload_1 
L132:   iconst_4 
L133:   iaload 
L134:   i2l 
L135:   ldc2_w 4294967295L 
L138:   land 
L139:   lsub 
L140:   ladd 
L141:   lstore_3 
L142:   aload_2 
L143:   iconst_4 
L144:   lload_3 
L145:   l2i 
L146:   iastore 
L147:   lload_3 
L148:   bipush 32 
L150:   lshr 
L151:   lstore_3 
L152:   lload_3 
L153:   aload_0 
L154:   iconst_5 
L155:   iaload 
L156:   i2l 
L157:   ldc2_w 4294967295L 
L160:   land 
L161:   aload_1 
L162:   iconst_5 
L163:   iaload 
L164:   i2l 
L165:   ldc2_w 4294967295L 
L168:   land 
L169:   lsub 
L170:   ladd 
L171:   lstore_3 
L172:   aload_2 
L173:   iconst_5 
L174:   lload_3 
L175:   l2i 
L176:   iastore 
L177:   lload_3 
L178:   bipush 32 
L180:   lshr 
L181:   lstore_3 
L182:   lload_3 
L183:   aload_0 
L184:   bipush 6 
L186:   iaload 
L187:   i2l 
L188:   ldc2_w 4294967295L 
L191:   land 
L192:   aload_1 
L193:   bipush 6 
L195:   iaload 
L196:   i2l 
L197:   ldc2_w 4294967295L 
L200:   land 
L201:   lsub 
L202:   ladd 
L203:   lstore_3 
L204:   aload_2 
L205:   bipush 6 
L207:   lload_3 
L208:   l2i 
L209:   iastore 
L210:   lload_3 
L211:   bipush 32 
L213:   lshr 
L214:   lstore_3 
L215:   lload_3 
L216:   aload_0 
L217:   bipush 7 
L219:   iaload 
L220:   i2l 
L221:   ldc2_w 4294967295L 
L224:   land 
L225:   aload_1 
L226:   bipush 7 
L228:   iaload 
L229:   i2l 
L230:   ldc2_w 4294967295L 
L233:   land 
L234:   lsub 
L235:   ladd 
L236:   lstore_3 
L237:   aload_2 
L238:   bipush 7 
L240:   lload_3 
L241:   l2i 
L242:   iastore 
L243:   lload_3 
L244:   bipush 32 
L246:   lshr 
L247:   lstore_3 
L248:   lload_3 
L249:   l2i 
L250:   ireturn 
L251:   
        .linenumbertable 
            L0 600 
            L2 601 
            L22 602 
            L27 603 
            L32 604 
            L52 605 
            L57 606 
            L62 607 
            L82 608 
            L87 609 
            L92 610 
            L112 611 
            L117 612 
            L122 613 
            L142 614 
            L147 615 
            L152 616 
            L172 617 
            L177 618 
            L182 619 
            L204 620 
            L210 621 
            L215 622 
            L237 623 
            L243 624 
            L248 625 
        .end linenumbertable 
        .localvariabletable 
            0 is x [I from L0 to L251 
            1 is y [I from L0 to L251 
            2 is z [I from L0 to L251 
            3 is c J from L2 to L251 
        .end localvariabletable 
    .end code 
.end method 

.method public static subFrom : ([I[I)V 
    .code stack 8 locals 4 
L0:     lconst_0 
L1:     lstore_2 
L2:     lload_2 
L3:     aload_1 
L4:     iconst_0 
L5:     iaload 
L6:     i2l 
L7:     ldc2_w 4294967295L 
L10:    land 
L11:    aload_0 
L12:    iconst_0 
L13:    iaload 
L14:    i2l 
L15:    ldc2_w 4294967295L 
L18:    land 
L19:    lsub 
L20:    ladd 
L21:    lstore_2 
L22:    aload_1 
L23:    iconst_0 
L24:    lload_2 
L25:    l2i 
L26:    iastore 
L27:    lload_2 
L28:    bipush 32 
L30:    lshr 
L31:    lstore_2 
L32:    lload_2 
L33:    aload_1 
L34:    iconst_1 
L35:    iaload 
L36:    i2l 
L37:    ldc2_w 4294967295L 
L40:    land 
L41:    aload_0 
L42:    iconst_1 
L43:    iaload 
L44:    i2l 
L45:    ldc2_w 4294967295L 
L48:    land 
L49:    lsub 
L50:    ladd 
L51:    lstore_2 
L52:    aload_1 
L53:    iconst_1 
L54:    lload_2 
L55:    l2i 
L56:    iastore 
L57:    lload_2 
L58:    bipush 32 
L60:    lshr 
L61:    lstore_2 
L62:    lload_2 
L63:    aload_1 
L64:    iconst_2 
L65:    iaload 
L66:    i2l 
L67:    ldc2_w 4294967295L 
L70:    land 
L71:    aload_0 
L72:    iconst_2 
L73:    iaload 
L74:    i2l 
L75:    ldc2_w 4294967295L 
L78:    land 
L79:    lsub 
L80:    ladd 
L81:    lstore_2 
L82:    aload_1 
L83:    iconst_2 
L84:    lload_2 
L85:    l2i 
L86:    iastore 
L87:    lload_2 
L88:    bipush 32 
L90:    lshr 
L91:    lstore_2 
L92:    lload_2 
L93:    aload_1 
L94:    iconst_3 
L95:    iaload 
L96:    i2l 
L97:    ldc2_w 4294967295L 
L100:   land 
L101:   aload_0 
L102:   iconst_3 
L103:   iaload 
L104:   i2l 
L105:   ldc2_w 4294967295L 
L108:   land 
L109:   lsub 
L110:   ladd 
L111:   lstore_2 
L112:   aload_1 
L113:   iconst_3 
L114:   lload_2 
L115:   l2i 
L116:   iastore 
L117:   lload_2 
L118:   bipush 32 
L120:   lshr 
L121:   lstore_2 
L122:   lload_2 
L123:   aload_1 
L124:   iconst_4 
L125:   iaload 
L126:   i2l 
L127:   ldc2_w 4294967295L 
L130:   land 
L131:   aload_0 
L132:   iconst_4 
L133:   iaload 
L134:   i2l 
L135:   ldc2_w 4294967295L 
L138:   land 
L139:   lsub 
L140:   ladd 
L141:   lstore_2 
L142:   aload_1 
L143:   iconst_4 
L144:   lload_2 
L145:   l2i 
L146:   iastore 
L147:   lload_2 
L148:   bipush 32 
L150:   lshr 
L151:   lstore_2 
L152:   lload_2 
L153:   aload_1 
L154:   iconst_5 
L155:   iaload 
L156:   i2l 
L157:   ldc2_w 4294967295L 
L160:   land 
L161:   aload_0 
L162:   iconst_5 
L163:   iaload 
L164:   i2l 
L165:   ldc2_w 4294967295L 
L168:   land 
L169:   lsub 
L170:   ladd 
L171:   lstore_2 
L172:   aload_1 
L173:   iconst_5 
L174:   lload_2 
L175:   l2i 
L176:   iastore 
L177:   lload_2 
L178:   bipush 32 
L180:   lshr 
L181:   lstore_2 
L182:   lload_2 
L183:   aload_1 
L184:   bipush 6 
L186:   iaload 
L187:   i2l 
L188:   ldc2_w 4294967295L 
L191:   land 
L192:   aload_0 
L193:   bipush 6 
L195:   iaload 
L196:   i2l 
L197:   ldc2_w 4294967295L 
L200:   land 
L201:   lsub 
L202:   ladd 
L203:   lstore_2 
L204:   aload_1 
L205:   bipush 6 
L207:   lload_2 
L208:   l2i 
L209:   iastore 
L210:   lload_2 
L211:   bipush 32 
L213:   lshr 
L214:   lstore_2 
L215:   lload_2 
L216:   aload_1 
L217:   bipush 7 
L219:   iaload 
L220:   i2l 
L221:   ldc2_w 4294967295L 
L224:   land 
L225:   aload_0 
L226:   bipush 7 
L228:   iaload 
L229:   i2l 
L230:   ldc2_w 4294967295L 
L233:   land 
L234:   lsub 
L235:   ladd 
L236:   lstore_2 
L237:   aload_1 
L238:   bipush 7 
L240:   lload_2 
L241:   l2i 
L242:   iastore 
L243:   return 
L244:   
        .linenumbertable 
            L0 630 
            L2 631 
            L22 632 
            L27 633 
            L32 634 
            L52 635 
            L57 636 
            L62 637 
            L82 638 
            L87 639 
            L92 640 
            L112 641 
            L117 642 
            L122 643 
            L142 644 
            L147 645 
            L152 646 
            L172 647 
            L177 648 
            L182 649 
            L204 650 
            L210 651 
            L215 652 
            L237 653 
            L243 654 
        .end linenumbertable 
        .localvariabletable 
            0 is x [I from L0 to L244 
            1 is z [I from L0 to L244 
            2 is c J from L2 to L244 
        .end localvariabletable 
    .end code 
.end method 

.method public static toBigInteger : ([I)Ljava/math/BigInteger; 
    .code stack 4 locals 4 
L0:     bipush 32 
L2:     newarray byte 
L4:     astore_1 
L5:     iconst_0 
L6:     istore_2 

        .stack append Object [B Integer 
L7:     iload_2 
L8:     bipush 8 
L10:    if_icmpge L38 
L13:    aload_0 
L14:    iload_2 
L15:    iaload 
L16:    istore_3 
L17:    iload_3 
L18:    ifeq L32 
L21:    iload_3 
L22:    aload_1 
L23:    bipush 7 
L25:    iload_2 
L26:    isub 
L27:    iconst_2 
L28:    ishl 
L29:    invokestatic Method Pack intToBigEndian (I[BI)V 

        .stack same 
L32:    iinc 2 1 
L35:    goto L7 

        .stack chop 1 
L38:    new java/math/BigInteger 
L41:    dup 
L42:    iconst_1 
L43:    aload_1 
L44:    invokespecial Method java/math/BigInteger <init> (I[B)V 
L47:    areturn 
L48:    
        .linenumbertable 
            L0 658 
            L5 659 
            L13 661 
            L17 662 
            L21 664 
            L32 659 
            L38 667 
        .end linenumbertable 
        .localvariabletable 
            3 is x_i I from L17 to L32 
            2 is i I from L7 to L38 
            0 is x [I from L0 to L48 
            1 is bs [B from L5 to L48 
        .end localvariabletable 
    .end code 
.end method 

.method public static zero : ([I)V 
    .code stack 3 locals 1 
L0:     aload_0 
L1:     iconst_0 
L2:     iconst_0 
L3:     iastore 
L4:     aload_0 
L5:     iconst_1 
L6:     iconst_0 
L7:     iastore 
L8:     aload_0 
L9:     iconst_2 
L10:    iconst_0 
L11:    iastore 
L12:    aload_0 
L13:    iconst_3 
L14:    iconst_0 
L15:    iastore 
L16:    aload_0 
L17:    iconst_4 
L18:    iconst_0 
L19:    iastore 
L20:    aload_0 
L21:    iconst_5 
L22:    iconst_0 
L23:    iastore 
L24:    aload_0 
L25:    bipush 6 
L27:    iconst_0 
L28:    iastore 
L29:    aload_0 
L30:    bipush 7 
L32:    iconst_0 
L33:    iastore 
L34:    return 
L35:    
        .linenumbertable 
            L0 672 
            L4 673 
            L8 674 
            L12 675 
            L16 676 
            L20 677 
            L24 678 
            L29 679 
            L34 680 
        .end linenumbertable 
        .localvariabletable 
            0 is z [I from L0 to L35 
        .end localvariabletable 
    .end code 
.end method 
.sourcefile 'Nat256.java' 
.end class 
