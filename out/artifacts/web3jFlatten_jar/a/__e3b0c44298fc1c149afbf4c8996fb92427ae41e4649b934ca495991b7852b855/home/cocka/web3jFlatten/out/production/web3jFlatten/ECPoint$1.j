.version 52 0 
.class super ECPoint$1 
.super java/lang/Object 
.implements PreCompCallback 
.field final synthetic val$decompressed Z 
.field final synthetic val$checkOrder Z 
.field final synthetic this$0 LECPoint; 

.method <init> : (LECPoint;ZZ)V 
    .code stack 2 locals 4 
L0:     aload_0 
L1:     aload_1 
L2:     putfield Field ECPoint$1 this$0 LECPoint; 
L5:     aload_0 
L6:     iload_2 
L7:     putfield Field ECPoint$1 val$decompressed Z 
L10:    aload_0 
L11:    iload_3 
L12:    putfield Field ECPoint$1 val$checkOrder Z 
L15:    aload_0 
L16:    invokespecial Method java/lang/Object <init> ()V 
L19:    return 
L20:    
        .linenumbertable 
            L0 216 
        .end linenumbertable 
        .localvariabletable 
            0 is this LECPoint$1; from L0 to L20 
            1 is this$0 LECPoint; from L0 to L20 
        .end localvariabletable 
    .end code 
.end method 

.method public precompute : (LPreCompInfo;)LPreCompInfo; 
    .code stack 2 locals 3 
L0:     aload_1 
L1:     instanceof ValidityPrecompInfo 
L4:     ifeq L14 
L7:     aload_1 
L8:     checkcast ValidityPrecompInfo 
L11:    goto L15 

        .stack same 
L14:    aconst_null 

        .stack stack_1 Object ValidityPrecompInfo 
L15:    astore_2 
L16:    aload_2 
L17:    ifnonnull L28 
L20:    new ValidityPrecompInfo 
L23:    dup 
L24:    invokespecial Method ValidityPrecompInfo <init> ()V 
L27:    astore_2 

        .stack append Object ValidityPrecompInfo 
L28:    aload_2 
L29:    invokevirtual Method ValidityPrecompInfo hasFailed ()Z 
L32:    ifeq L37 
L35:    aload_2 
L36:    areturn 

        .stack same 
L37:    aload_2 
L38:    invokevirtual Method ValidityPrecompInfo hasCurveEquationPassed ()Z 
L41:    ifne L71 
L44:    aload_0 
L45:    getfield Field ECPoint$1 val$decompressed Z 
L48:    ifne L67 
L51:    aload_0 
L52:    getfield Field ECPoint$1 this$0 LECPoint; 
L55:    invokevirtual Method ECPoint satisfiesCurveEquation ()Z 
L58:    ifne L67 
L61:    aload_2 
L62:    invokevirtual Method ValidityPrecompInfo reportFailed ()V 
L65:    aload_2 
L66:    areturn 

        .stack same 
L67:    aload_2 
L68:    invokevirtual Method ValidityPrecompInfo reportCurveEquationPassed ()V 

        .stack same 
L71:    aload_0 
L72:    getfield Field ECPoint$1 val$checkOrder Z 
L75:    ifeq L89 
L78:    aload_2 
L79:    invokevirtual Method ValidityPrecompInfo hasOrderPassed ()Z 
L82:    ifne L89 
L85:    aload_2 
L86:    invokevirtual Method ValidityPrecompInfo reportOrderPassed ()V 

        .stack same 
L89:    aload_2 
L90:    areturn 
L91:    
        .linenumbertable 
            L0 218 
            L16 219 
            L20 221 
            L28 224 
            L35 226 
            L37 228 
            L44 230 
            L61 232 
            L65 233 
            L67 235 
            L71 237 
            L85 244 
            L89 246 
        .end linenumbertable 
        .localvariabletable 
            0 is this LECPoint$1; from L0 to L91 
            1 is existing LPreCompInfo; from L0 to L91 
            2 is info LValidityPrecompInfo; from L16 to L91 
        .end localvariabletable 
    .end code 
.end method 
.sourcefile 'ECPoint.java' 
.enclosing method ECPoint implIsValid (ZZ)Z 
.innerclasses 
    ECPoint$1 [0] [0] 
.end innerclasses 
.end class 
