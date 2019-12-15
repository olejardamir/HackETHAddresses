.version 52 0 
.class super X9FieldElement 
.super java/lang/Object 
.field private final f LECFieldElement; 
.field private static final converter LX9IntegerConverter; 

.method public <init> : (LECFieldElement;)V 
    .code stack 2 locals 2 
L0:     aload_0 
L1:     invokespecial Method java/lang/Object <init> ()V 
L4:     aload_0 
L5:     aload_1 
L6:     putfield Field X9FieldElement f LECFieldElement; 
L9:     return 
L10:    
        .linenumbertable 
            L0 8 
            L4 9 
            L9 10 
        .end linenumbertable 
        .localvariabletable 
            0 is this LX9FieldElement; from L0 to L10 
            1 is f LECFieldElement; from L0 to L10 
        .end localvariabletable 
    .end code 
.end method 

.method public toASN1Primitive : ()LASN1Primitive; 
    .code stack 3 locals 3 
L0:     getstatic Field X9FieldElement converter LX9IntegerConverter; 
L3:     aload_0 
L4:     getfield Field X9FieldElement f LECFieldElement; 
L7:     invokevirtual Method X9IntegerConverter getByteLength (LECFieldElement;)I 
L10:    istore_1 
L11:    getstatic Field X9FieldElement converter LX9IntegerConverter; 
L14:    aload_0 
L15:    getfield Field X9FieldElement f LECFieldElement; 
L18:    invokevirtual Method ECFieldElement toBigInteger ()Ljava/math/BigInteger; 
L21:    iload_1 
L22:    invokevirtual Method X9IntegerConverter integerToBytes (Ljava/math/BigInteger;I)[B 
L25:    astore_2 
L26:    new DEROctetString 
L29:    dup 
L30:    aload_2 
L31:    invokespecial Method DEROctetString <init> ([B)V 
L34:    areturn 
L35:    
        .linenumbertable 
            L0 15 
            L11 16 
            L26 18 
        .end linenumbertable 
        .localvariabletable 
            0 is this LX9FieldElement; from L0 to L35 
            1 is byteCount I from L11 to L35 
            2 is paddedBigInteger [B from L26 to L35 
        .end localvariabletable 
    .end code 
.end method 

.method public hashCode : ()I 
    .code stack 1 locals 1 
L0:     aload_0 
L1:     invokevirtual Method X9FieldElement toASN1Primitive ()LASN1Primitive; 
L4:     invokevirtual Method ASN1Primitive hashCode ()I 
L7:     ireturn 
L8:     
        .linenumbertable 
            L0 23 
        .end linenumbertable 
        .localvariabletable 
            0 is this LX9FieldElement; from L0 to L8 
        .end localvariabletable 
    .end code 
.end method 

.method public equals : (Ljava/lang/Object;)Z 
    .code stack 2 locals 3 
L0:     aload_0 
L1:     aload_1 
L2:     if_acmpne L7 
L5:     iconst_1 
L6:     ireturn 

        .stack same 
L7:     aload_1 
L8:     instanceof X9FieldElement 
L11:    ifne L16 
L14:    iconst_0 
L15:    ireturn 

        .stack same 
L16:    aload_1 
L17:    checkcast X9FieldElement 
L20:    astore_2 
L21:    aload_0 
L22:    invokevirtual Method X9FieldElement toASN1Primitive ()LASN1Primitive; 
L25:    aload_2 
L26:    invokevirtual Method X9FieldElement toASN1Primitive ()LASN1Primitive; 
L29:    invokevirtual Method ASN1Primitive equals (Ljava/lang/Object;)Z 
L32:    ireturn 
L33:    
        .linenumbertable 
            L0 29 
            L5 31 
            L7 34 
            L14 36 
            L16 39 
            L21 41 
        .end linenumbertable 
        .localvariabletable 
            0 is this LX9FieldElement; from L0 to L33 
            1 is o Ljava/lang/Object; from L0 to L33 
            2 is other LX9FieldElement; from L21 to L33 
        .end localvariabletable 
    .end code 
.end method 

.method static <clinit> : ()V 
    .code stack 2 locals 0 
L0:     new X9IntegerConverter 
L3:     dup 
L4:     invokespecial Method X9IntegerConverter <init> ()V 
L7:     putstatic Field X9FieldElement converter LX9IntegerConverter; 
L10:    return 
L11:    
        .linenumbertable 
            L0 5 
        .end linenumbertable 
    .end code 
.end method 
.sourcefile 'X9FieldElement.java' 
.end class 
