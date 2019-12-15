.version 52 0 
.class super ASN1InputStream 
.super java/io/FilterInputStream 
.field public static final INTEGER I = 2 
.field public static final BIT_STRING I = 3 
.field public static final OCTET_STRING I = 4 
.field public static final OBJECT_IDENTIFIER I = 6 
.field public static final SEQUENCE I = 16 
.field public static final CONSTRUCTED I = 32 

.method protected <init> : (Ljava/io/InputStream;)V 
    .code stack 2 locals 2 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial Method java/io/FilterInputStream <init> (Ljava/io/InputStream;)V 
L5:     return 
L6:     
        .linenumbertable 
            L0 18 
            L5 19 
        .end linenumbertable 
        .localvariabletable 
            0 is this LASN1InputStream; from L0 to L6 
            1 is in Ljava/io/InputStream; from L0 to L6 
        .end localvariabletable 
    .end code 
.end method 
.sourcefile 'ASN1InputStream.java' 
.end class 
