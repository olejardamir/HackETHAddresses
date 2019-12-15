.version 52 0 
.class public super FixedPointPreCompInfo 
.super java/lang/Object 
.implements PreCompInfo 
.field private offset LECPoint; 
.field private lookupTable LECLookupTable; 
.field private width I 

.method public <init> : ()V 
    .code stack 2 locals 1 
L0:     aload_0 
L1:     invokespecial Method java/lang/Object <init> ()V 
L4:     aload_0 
L5:     aconst_null 
L6:     putfield Field FixedPointPreCompInfo offset LECPoint; 
L9:     aload_0 
L10:    aconst_null 
L11:    putfield Field FixedPointPreCompInfo lookupTable LECLookupTable; 
L14:    aload_0 
L15:    iconst_m1 
L16:    putfield Field FixedPointPreCompInfo width I 
L19:    return 
L20:    
        .linenumbertable 
            L0 3 
            L4 5 
            L9 8 
            L14 11 
        .end linenumbertable 
        .localvariabletable 
            0 is this LFixedPointPreCompInfo; from L0 to L20 
        .end localvariabletable 
    .end code 
.end method 

.method public getLookupTable : ()LECLookupTable; 
    .code stack 1 locals 1 
L0:     aload_0 
L1:     getfield Field FixedPointPreCompInfo lookupTable LECLookupTable; 
L4:     areturn 
L5:     
        .linenumbertable 
            L0 15 
        .end linenumbertable 
        .localvariabletable 
            0 is this LFixedPointPreCompInfo; from L0 to L5 
        .end localvariabletable 
    .end code 
.end method 

.method public setLookupTable : (LECLookupTable;)V 
    .code stack 2 locals 2 
L0:     aload_0 
L1:     aload_1 
L2:     putfield Field FixedPointPreCompInfo lookupTable LECLookupTable; 
L5:     return 
L6:     
        .linenumbertable 
            L0 20 
            L5 21 
        .end linenumbertable 
        .localvariabletable 
            0 is this LFixedPointPreCompInfo; from L0 to L6 
            1 is lookupTable LECLookupTable; from L0 to L6 
        .end localvariabletable 
    .end code 
.end method 

.method public getOffset : ()LECPoint; 
    .code stack 1 locals 1 
L0:     aload_0 
L1:     getfield Field FixedPointPreCompInfo offset LECPoint; 
L4:     areturn 
L5:     
        .linenumbertable 
            L0 25 
        .end linenumbertable 
        .localvariabletable 
            0 is this LFixedPointPreCompInfo; from L0 to L5 
        .end localvariabletable 
    .end code 
.end method 

.method public setOffset : (LECPoint;)V 
    .code stack 2 locals 2 
L0:     aload_0 
L1:     aload_1 
L2:     putfield Field FixedPointPreCompInfo offset LECPoint; 
L5:     return 
L6:     
        .linenumbertable 
            L0 30 
            L5 31 
        .end linenumbertable 
        .localvariabletable 
            0 is this LFixedPointPreCompInfo; from L0 to L6 
            1 is offset LECPoint; from L0 to L6 
        .end localvariabletable 
    .end code 
.end method 

.method public getWidth : ()I 
    .code stack 1 locals 1 
L0:     aload_0 
L1:     getfield Field FixedPointPreCompInfo width I 
L4:     ireturn 
L5:     
        .linenumbertable 
            L0 35 
        .end linenumbertable 
        .localvariabletable 
            0 is this LFixedPointPreCompInfo; from L0 to L5 
        .end localvariabletable 
    .end code 
.end method 

.method public setWidth : (I)V 
    .code stack 2 locals 2 
L0:     aload_0 
L1:     iload_1 
L2:     putfield Field FixedPointPreCompInfo width I 
L5:     return 
L6:     
        .linenumbertable 
            L0 40 
            L5 41 
        .end linenumbertable 
        .localvariabletable 
            0 is this LFixedPointPreCompInfo; from L0 to L6 
            1 is width I from L0 to L6 
        .end localvariabletable 
    .end code 
.end method 
.sourcefile 'FixedPointPreCompInfo.java' 
.end class 
