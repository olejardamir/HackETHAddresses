.version 52 0 
.class public super ECCurve$Config 
.super java/lang/Object 
.field final coord I 
.field final synthetic this$0 LECCurve; 

.method <init> : (LECCurve;I)V 
    .code stack 2 locals 3 
L0:     aload_0 
L1:     aload_1 
L2:     putfield Field ECCurve$Config this$0 LECCurve; 
L5:     aload_0 
L6:     invokespecial Method java/lang/Object <init> ()V 
L9:     aload_0 
L10:    iload_2 
L11:    putfield Field ECCurve$Config coord I 
L14:    return 
L15:    
        .linenumbertable 
            L0 24 
            L9 25 
            L14 26 
        .end linenumbertable 
        .localvariabletable 
            0 is this LECCurve$Config; from L0 to L15 
            1 is this$0 LECCurve; from L0 to L15 
            2 is coord I from L0 to L15 
        .end localvariabletable 
    .end code 
.end method 

.method public setEndomorphism : ()LECCurve$Config; 
    .code stack 1 locals 1 
L0:     aload_0 
L1:     areturn 
L2:     
        .linenumbertable 
            L0 30 
        .end linenumbertable 
        .localvariabletable 
            0 is this LECCurve$Config; from L0 to L2 
        .end localvariabletable 
    .end code 
.end method 

.method public create : ()LECCurve; 
    .code stack 3 locals 2 
L0:     aload_0 
L1:     getfield Field ECCurve$Config this$0 LECCurve; 
L4:     aload_0 
L5:     getfield Field ECCurve$Config coord I 
L8:     invokevirtual Method ECCurve supportsCoordinateSystem (I)Z 
L11:    ifne L24 
L14:    new java/lang/IllegalStateException 
L17:    dup 
L18:    ldc 'unsupported coordinate system' 
L20:    invokespecial Method java/lang/IllegalStateException <init> (Ljava/lang/String;)V 
L23:    athrow 

        .stack same 
L24:    aload_0 
L25:    getfield Field ECCurve$Config this$0 LECCurve; 
L28:    invokevirtual Method ECCurve cloneCurve ()LECCurve; 
L31:    astore_1 
L32:    aload_1 
L33:    aload_0 
L34:    getfield Field ECCurve$Config this$0 LECCurve; 
L37:    if_acmpne L50 
L40:    new java/lang/IllegalStateException 
L43:    dup 
L44:    ldc 'implementation returned current curve' 
L46:    invokespecial Method java/lang/IllegalStateException <init> (Ljava/lang/String;)V 
L49:    athrow 

        .stack append Object ECCurve 
L50:    aload_1 
L51:    aload_0 
L52:    getfield Field ECCurve$Config coord I 
L55:    putfield Field ECCurve coord I 
L58:    aload_1 
L59:    aload_0 
L60:    getfield Field ECCurve$Config this$0 LECCurve; 
L63:    invokestatic Method ECCurve access$000 (LECCurve;)LAbstractECMultiplier; 
L66:    invokestatic Method ECCurve access$002 (LECCurve;LAbstractECMultiplier;)LAbstractECMultiplier; 
L69:    pop 
L70:    aload_1 
L71:    areturn 
L72:    
        .linenumbertable 
            L0 34 
            L14 36 
            L24 39 
            L32 40 
            L40 42 
            L50 46 
            L58 47 
            L70 50 
        .end linenumbertable 
        .localvariabletable 
            0 is this LECCurve$Config; from L0 to L72 
            1 is c LECCurve; from L32 to L72 
        .end localvariabletable 
    .end code 
    .exceptions java/lang/Exception 
.end method 
.sourcefile 'ECCurve.java' 
.innerclasses 
    ECCurve$Config ECCurve Config public 
.end innerclasses 
.end class 
