.version 52 0 
.class super DERSequence 
.super ASN1Sequence 
.field private bodyLength I 

.method public <init> : ()V 
    .code stack 2 locals 1 
L0:     aload_0 
L1:     invokespecial Method ASN1Sequence <init> ()V 
L4:     aload_0 
L5:     iconst_m1 
L6:     putfield Field DERSequence bodyLength I 
L9:     return 
L10:    
        .linenumbertable 
            L0 12 
            L4 8 
            L9 13 
        .end linenumbertable 
        .localvariabletable 
            0 is this LDERSequence; from L0 to L10 
        .end localvariabletable 
    .end code 
.end method 

.method public <init> : (LASN1EncodableVector;)V 
    .code stack 2 locals 2 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial Method ASN1Sequence <init> (LASN1EncodableVector;)V 
L5:     aload_0 
L6:     iconst_m1 
L7:     putfield Field DERSequence bodyLength I 
L10:    return 
L11:    
        .linenumbertable 
            L0 19 
            L5 8 
            L10 20 
        .end linenumbertable 
        .localvariabletable 
            0 is this LDERSequence; from L0 to L11 
            1 is v LASN1EncodableVector; from L0 to L11 
        .end localvariabletable 
    .end code 
.end method 

.method private getBodyLength : ()I 
    .code stack 2 locals 3 
L0:     aload_0 
L1:     getfield Field DERSequence bodyLength I 
L4:     ifge L54 
L7:     iconst_0 
L8:     istore_1 
L9:     aload_0 
L10:    invokevirtual Method DERSequence getObjects ()Ljava/util/Enumeration; 
L13:    astore_2 

        .stack append Integer Object java/util/Enumeration 
L14:    aload_2 
L15:    invokeinterface InterfaceMethod java/util/Enumeration hasMoreElements ()Z 1 
L20:    ifeq L49 
L23:    iload_1 
L24:    aload_2 
L25:    invokeinterface InterfaceMethod java/util/Enumeration nextElement ()Ljava/lang/Object; 1 
L30:    checkcast ASN1Encodable 
L33:    invokeinterface InterfaceMethod ASN1Encodable toASN1Primitive ()LASN1Primitive; 1 
L38:    invokevirtual Method ASN1Primitive toDERObject ()LASN1Primitive; 
L41:    invokevirtual Method ASN1Primitive encodedLength ()I 
L44:    iadd 
L45:    istore_1 
L46:    goto L14 

        .stack chop 1 
L49:    aload_0 
L50:    iload_1 
L51:    putfield Field DERSequence bodyLength I 

        .stack chop 1 
L54:    aload_0 
L55:    getfield Field DERSequence bodyLength I 
L58:    ireturn 
L59:    
        .linenumbertable 
            L0 25 
            L7 27 
            L9 29 
            L23 32 
            L49 35 
            L54 38 
        .end linenumbertable 
        .localvariabletable 
            2 is e Ljava/util/Enumeration; from L14 to L49 
            1 is length I from L9 to L54 
            0 is this LDERSequence; from L0 to L59 
        .end localvariabletable 
    .end code 
    .exceptions java/lang/Exception 
.end method 

.method encodedLength : ()I 
    .code stack 2 locals 1 
L0:     iconst_1 
L1:     aload_0 
L2:     invokespecial Method DERSequence getBodyLength ()I 
L5:     invokestatic Method StreamUtil calculateBodyLength (I)I 
L8:     iadd 
L9:     aload_0 
L10:    invokespecial Method DERSequence getBodyLength ()I 
L13:    iadd 
L14:    ireturn 
L15:    
        .linenumbertable 
            L0 45 
        .end linenumbertable 
        .localvariabletable 
            0 is this LDERSequence; from L0 to L15 
        .end localvariabletable 
    .end code 
    .exceptions java/lang/Exception 
.end method 

.method encode : (LASN1OutputStream;)V 
    .code stack 2 locals 3 
L0:     aload_1 
L1:     bipush 48 
L3:     invokevirtual Method ASN1OutputStream write (I)V 
L6:     aload_1 
L7:     aload_0 
L8:     invokespecial Method DERSequence getBodyLength ()I 
L11:    invokevirtual Method ASN1OutputStream writeLength (I)V 
L14:    aload_0 
L15:    invokevirtual Method DERSequence getObjects ()Ljava/util/Enumeration; 
L18:    astore_2 

        .stack append Object java/util/Enumeration 
L19:    aload_2 
L20:    invokeinterface InterfaceMethod java/util/Enumeration hasMoreElements ()Z 1 
L25:    ifeq L47 
L28:    aload_1 
L29:    invokevirtual Method ASN1OutputStream getDERSubStream ()LASN1OutputStream; 
L32:    aload_2 
L33:    invokeinterface InterfaceMethod java/util/Enumeration nextElement ()Ljava/lang/Object; 1 
L38:    checkcast ASN1Encodable 
L41:    invokevirtual Method ASN1OutputStream writeObject (LASN1Encodable;)V 
L44:    goto L19 

        .stack chop 1 
L47:    return 
L48:    
        .linenumbertable 
            L0 54 
            L6 55 
            L14 57 
            L28 60 
            L47 62 
        .end linenumbertable 
        .localvariabletable 
            2 is e Ljava/util/Enumeration; from L19 to L47 
            0 is this LDERSequence; from L0 to L48 
            1 is out LASN1OutputStream; from L0 to L48 
        .end localvariabletable 
    .end code 
    .exceptions java/lang/Exception 
.end method 
.sourcefile 'DERSequence.java' 
.end class 
