.version 52 0 
.class super Curve25519$1 
.super java/lang/Object 
.implements ECLookupTable 
.field final synthetic this$0 LCurve25519; 

.method <init> : (LCurve25519;)V 
    .code stack 2 locals 2 
L0:     aload_0 
L1:     aload_1 
L2:     putfield Field Curve25519$1 this$0 LCurve25519; 
L5:     aload_0 
L6:     invokespecial Method java/lang/Object <init> ()V 
L9:     return 
L10:    
        .linenumbertable 
            L0 65 
        .end linenumbertable 
        .localvariabletable 
            0 is this LCurve25519$1; from L0 to L10 
            1 is this$0 LCurve25519; from L0 to L10 
        .end localvariabletable 
    .end code 
.end method 

.method public getSize : ()I 
    .code stack 1 locals 1 
L0:     iconst_0 
L1:     ireturn 
L2:     
        .linenumbertable 
            L0 69 
        .end linenumbertable 
        .localvariabletable 
            0 is this LCurve25519$1; from L0 to L2 
        .end localvariabletable 
    .end code 
.end method 

.method public lookup : (I)LECPoint; 
    .code stack 1 locals 2 
L0:     aconst_null 
L1:     areturn 
L2:     
        .linenumbertable 
            L0 73 
        .end linenumbertable 
        .localvariabletable 
            0 is this LCurve25519$1; from L0 to L2 
            1 is index I from L0 to L2 
        .end localvariabletable 
    .end code 
.end method 
.sourcefile 'Curve25519.java' 
.enclosing method Curve25519 createCacheSafeLookupTable ([LECPoint;II)LECLookupTable; 
.innerclasses 
    Curve25519$1 [0] [0] 
.end innerclasses 
.end class 
