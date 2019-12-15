.version 52 0 
.class super ValidityPrecompInfo 
.super java/lang/Object 
.implements PreCompInfo 
.field static final PRECOMP_NAME Ljava/lang/String; = 'bc_validity' 
.field private failed Z 
.field private curveEquationPassed Z 
.field private orderPassed Z 

.method <init> : ()V 
    .code stack 2 locals 1 
L0:     aload_0 
L1:     invokespecial Method java/lang/Object <init> ()V 
L4:     aload_0 
L5:     iconst_0 
L6:     putfield Field ValidityPrecompInfo failed Z 
L9:     aload_0 
L10:    iconst_0 
L11:    putfield Field ValidityPrecompInfo curveEquationPassed Z 
L14:    aload_0 
L15:    iconst_0 
L16:    putfield Field ValidityPrecompInfo orderPassed Z 
L19:    return 
L20:    
        .linenumbertable 
            L0 2 
            L4 6 
            L9 7 
            L14 8 
        .end linenumbertable 
        .localvariabletable 
            0 is this LValidityPrecompInfo; from L0 to L20 
        .end localvariabletable 
    .end code 
.end method 

.method hasFailed : ()Z 
    .code stack 1 locals 1 
L0:     aload_0 
L1:     getfield Field ValidityPrecompInfo failed Z 
L4:     ireturn 
L5:     
        .linenumbertable 
            L0 12 
        .end linenumbertable 
        .localvariabletable 
            0 is this LValidityPrecompInfo; from L0 to L5 
        .end localvariabletable 
    .end code 
.end method 

.method reportFailed : ()V 
    .code stack 2 locals 1 
L0:     aload_0 
L1:     iconst_1 
L2:     putfield Field ValidityPrecompInfo failed Z 
L5:     return 
L6:     
        .linenumbertable 
            L0 17 
            L5 18 
        .end linenumbertable 
        .localvariabletable 
            0 is this LValidityPrecompInfo; from L0 to L6 
        .end localvariabletable 
    .end code 
.end method 

.method hasCurveEquationPassed : ()Z 
    .code stack 1 locals 1 
L0:     aload_0 
L1:     getfield Field ValidityPrecompInfo curveEquationPassed Z 
L4:     ireturn 
L5:     
        .linenumbertable 
            L0 22 
        .end linenumbertable 
        .localvariabletable 
            0 is this LValidityPrecompInfo; from L0 to L5 
        .end localvariabletable 
    .end code 
.end method 

.method reportCurveEquationPassed : ()V 
    .code stack 2 locals 1 
L0:     aload_0 
L1:     iconst_1 
L2:     putfield Field ValidityPrecompInfo curveEquationPassed Z 
L5:     return 
L6:     
        .linenumbertable 
            L0 27 
            L5 28 
        .end linenumbertable 
        .localvariabletable 
            0 is this LValidityPrecompInfo; from L0 to L6 
        .end localvariabletable 
    .end code 
.end method 

.method hasOrderPassed : ()Z 
    .code stack 1 locals 1 
L0:     aload_0 
L1:     getfield Field ValidityPrecompInfo orderPassed Z 
L4:     ireturn 
L5:     
        .linenumbertable 
            L0 32 
        .end linenumbertable 
        .localvariabletable 
            0 is this LValidityPrecompInfo; from L0 to L5 
        .end localvariabletable 
    .end code 
.end method 

.method reportOrderPassed : ()V 
    .code stack 2 locals 1 
L0:     aload_0 
L1:     iconst_1 
L2:     putfield Field ValidityPrecompInfo orderPassed Z 
L5:     return 
L6:     
        .linenumbertable 
            L0 37 
            L5 38 
        .end linenumbertable 
        .localvariabletable 
            0 is this LValidityPrecompInfo; from L0 to L6 
        .end localvariabletable 
    .end code 
.end method 
.sourcefile 'ValidityPrecompInfo.java' 
.end class 
