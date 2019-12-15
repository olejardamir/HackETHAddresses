.version 52 0 
.class public super abstract ASN1Sequence 
.super ASN1Primitive 
.field seq Ljava/util/Vector; 

.method <init> : ()V 
    .code stack 3 locals 1 
L0:     aload_0 
L1:     invokespecial Method ASN1Primitive <init> ()V 
L4:     aload_0 
L5:     new java/util/Vector 
L8:     dup 
L9:     invokespecial Method java/util/Vector <init> ()V 
L12:    putfield Field ASN1Sequence seq Ljava/util/Vector; 
L15:    return 
L16:    
        .linenumbertable 
            L0 13 
            L4 9 
            L15 14 
        .end linenumbertable 
        .localvariabletable 
            0 is this LASN1Sequence; from L0 to L16 
        .end localvariabletable 
    .end code 
.end method 

.method <init> : (LASN1EncodableVector;)V 
    .code stack 3 locals 3 
L0:     aload_0 
L1:     invokespecial Method ASN1Primitive <init> ()V 
L4:     aload_0 
L5:     new java/util/Vector 
L8:     dup 
L9:     invokespecial Method java/util/Vector <init> ()V 
L12:    putfield Field ASN1Sequence seq Ljava/util/Vector; 
L15:    iconst_0 
L16:    istore_2 

        .stack full 
            locals Object ASN1Sequence Object ASN1EncodableVector Integer 
            stack 
        .end stack 
L17:    iload_2 
L18:    aload_1 
L19:    invokevirtual Method ASN1EncodableVector size ()I 
L22:    if_icmpeq L43 
L25:    aload_0 
L26:    getfield Field ASN1Sequence seq Ljava/util/Vector; 
L29:    aload_1 
L30:    iload_2 
L31:    invokevirtual Method ASN1EncodableVector get (I)LASN1Encodable; 
L34:    invokevirtual Method java/util/Vector addElement (Ljava/lang/Object;)V 
L37:    iinc 2 1 
L40:    goto L17 

        .stack chop 1 
L43:    return 
L44:    
        .linenumbertable 
            L0 19 
            L4 9 
            L15 20 
            L25 22 
            L37 20 
            L43 24 
        .end linenumbertable 
        .localvariabletable 
            2 is i I from L17 to L43 
            0 is this LASN1Sequence; from L0 to L44 
            1 is v LASN1EncodableVector; from L0 to L44 
        .end localvariabletable 
    .end code 
.end method 

.method getObjects : ()Ljava/util/Enumeration; 
    .code stack 1 locals 1 
L0:     aload_0 
L1:     getfield Field ASN1Sequence seq Ljava/util/Vector; 
L4:     invokevirtual Method java/util/Vector elements ()Ljava/util/Enumeration; 
L7:     areturn 
L8:     
        .linenumbertable 
            L0 28 
        .end linenumbertable 
        .localvariabletable 
            0 is this LASN1Sequence; from L0 to L8 
        .end localvariabletable 
    .end code 
.end method 

.method private size : ()I 
    .code stack 1 locals 1 
L0:     aload_0 
L1:     getfield Field ASN1Sequence seq Ljava/util/Vector; 
L4:     invokevirtual Method java/util/Vector size ()I 
L7:     ireturn 
L8:     
        .linenumbertable 
            L0 34 
        .end linenumbertable 
        .localvariabletable 
            0 is this LASN1Sequence; from L0 to L8 
        .end localvariabletable 
    .end code 
.end method 

.method public hashCode : ()I 
    .code stack 2 locals 4 
L0:     aload_0 
L1:     invokevirtual Method ASN1Sequence getObjects ()Ljava/util/Enumeration; 
L4:     astore_1 
L5:     aload_0 
L6:     invokespecial Method ASN1Sequence size ()I 
L9:     istore_2 

        .stack append Object java/util/Enumeration Integer 
L10:    aload_1 
L11:    invokeinterface InterfaceMethod java/util/Enumeration hasMoreElements ()Z 1 
L16:    ifeq L40 
L19:    aload_0 
L20:    aload_1 
L21:    invokespecial Method ASN1Sequence getNext (Ljava/util/Enumeration;)LASN1Encodable; 
L24:    astore_3 
L25:    iload_2 
L26:    bipush 17 
L28:    imul 
L29:    istore_2 
L30:    iload_2 
L31:    aload_3 
L32:    invokevirtual Method java/lang/Object hashCode ()I 
L35:    ixor 
L36:    istore_2 
L37:    goto L10 

        .stack same 
L40:    iload_2 
L41:    ireturn 
L42:    
        .linenumbertable 
            L0 39 
            L5 40 
            L10 42 
            L19 44 
            L25 45 
            L30 47 
            L37 48 
            L40 50 
        .end linenumbertable 
        .localvariabletable 
            3 is o Ljava/lang/Object; from L25 to L37 
            0 is this LASN1Sequence; from L0 to L42 
            1 is e Ljava/util/Enumeration; from L5 to L42 
            2 is hashCode I from L10 to L42 
        .end localvariabletable 
    .end code 
.end method 

.method asn1Equals : (LASN1Primitive;)Z 
    .code stack 2 locals 9 
L0:     aload_1 
L1:     instanceof ASN1Sequence 
L4:     ifne L9 
L7:     iconst_0 
L8:     ireturn 

        .stack same 
L9:     aload_1 
L10:    checkcast ASN1Sequence 
L13:    astore_2 
L14:    aload_0 
L15:    invokespecial Method ASN1Sequence size ()I 
L18:    aload_2 
L19:    invokespecial Method ASN1Sequence size ()I 
L22:    if_icmpeq L27 
L25:    iconst_0 
L26:    ireturn 

        .stack append Object ASN1Sequence 
L27:    aload_0 
L28:    invokevirtual Method ASN1Sequence getObjects ()Ljava/util/Enumeration; 
L31:    astore_3 
L32:    aload_2 
L33:    invokevirtual Method ASN1Sequence getObjects ()Ljava/util/Enumeration; 
L36:    astore 4 

        .stack append Object java/util/Enumeration Object java/util/Enumeration 
L38:    aload_3 
L39:    invokeinterface InterfaceMethod java/util/Enumeration hasMoreElements ()Z 1 
L44:    ifeq L102 
L47:    aload_0 
L48:    aload_3 
L49:    invokespecial Method ASN1Sequence getNext (Ljava/util/Enumeration;)LASN1Encodable; 
L52:    astore 5 
L54:    aload_0 
L55:    aload 4 
L57:    invokespecial Method ASN1Sequence getNext (Ljava/util/Enumeration;)LASN1Encodable; 
L60:    astore 6 
L62:    aload 5 
L64:    invokeinterface InterfaceMethod ASN1Encodable toASN1Primitive ()LASN1Primitive; 1 
L69:    astore 7 
L71:    aload 6 
L73:    invokeinterface InterfaceMethod ASN1Encodable toASN1Primitive ()LASN1Primitive; 1 
L78:    astore 8 
L80:    aload 7 
L82:    aload 8 
L84:    if_acmpeq L38 
L87:    aload 7 
L89:    aload 8 
L91:    invokevirtual Method ASN1Primitive equals (Ljava/lang/Object;)Z 
L94:    ifeq L100 
L97:    goto L38 

        .stack full 
            locals Object ASN1Sequence Object ASN1Primitive Object ASN1Sequence Object java/util/Enumeration Object java/util/Enumeration Object ASN1Encodable Object ASN1Encodable Object ASN1Primitive Object ASN1Primitive 
            stack 
        .end stack 
L100:   iconst_0 
L101:   ireturn 

        .stack full 
            locals Object ASN1Sequence Object ASN1Primitive Object ASN1Sequence Object java/util/Enumeration Object java/util/Enumeration 
            stack 
        .end stack 
L102:   iconst_1 
L103:   ireturn 
L104:   
        .linenumbertable 
            L0 56 
            L7 58 
            L9 61 
            L14 63 
            L25 65 
            L27 68 
            L32 69 
            L38 71 
            L47 73 
            L54 74 
            L62 76 
            L71 77 
            L80 79 
            L97 81 
            L100 84 
            L102 87 
        .end linenumbertable 
        .localvariabletable 
            5 is obj1 LASN1Encodable; from L54 to L102 
            6 is obj2 LASN1Encodable; from L62 to L102 
            7 is o1 LASN1Primitive; from L71 to L102 
            8 is o2 LASN1Primitive; from L80 to L102 
            0 is this LASN1Sequence; from L0 to L104 
            1 is o LASN1Primitive; from L0 to L104 
            2 is other LASN1Sequence; from L14 to L104 
            3 is s1 Ljava/util/Enumeration; from L32 to L104 
            4 is s2 Ljava/util/Enumeration; from L38 to L104 
        .end localvariabletable 
    .end code 
.end method 

.method private getNext : (Ljava/util/Enumeration;)LASN1Encodable; 
    .code stack 1 locals 2 
L0:     aload_1 
L1:     invokeinterface InterfaceMethod java/util/Enumeration nextElement ()Ljava/lang/Object; 1 
L6:     checkcast ASN1Encodable 
L9:     areturn 
L10:    
        .linenumbertable 
            L0 93 
        .end linenumbertable 
        .localvariabletable 
            0 is this LASN1Sequence; from L0 to L10 
            1 is e Ljava/util/Enumeration; from L0 to L10 
        .end localvariabletable 
    .end code 
.end method 

.method toDERObject : ()LASN1Primitive; 
    .code stack 2 locals 2 
L0:     new DERSequence 
L3:     dup 
L4:     invokespecial Method DERSequence <init> ()V 
L7:     astore_1 
L8:     aload_1 
L9:     aload_0 
L10:    getfield Field ASN1Sequence seq Ljava/util/Vector; 
L13:    putfield Field ASN1Sequence seq Ljava/util/Vector; 
L16:    aload_1 
L17:    areturn 
L18:    
        .linenumbertable 
            L0 99 
            L8 101 
            L16 103 
        .end linenumbertable 
        .localvariabletable 
            0 is this LASN1Sequence; from L0 to L18 
            1 is derSeq LASN1Sequence; from L8 to L18 
        .end localvariabletable 
    .end code 
.end method 

.method abstract encode : (LASN1OutputStream;)V 
    .exceptions java/lang/Exception 
.end method 

.method public toString : ()Ljava/lang/String; 
    .code stack 1 locals 1 
L0:     aload_0 
L1:     getfield Field ASN1Sequence seq Ljava/util/Vector; 
L4:     invokevirtual Method java/util/Vector toString ()Ljava/lang/String; 
L7:     areturn 
L8:     
        .linenumbertable 
            L0 113 
        .end linenumbertable 
        .localvariabletable 
            0 is this LASN1Sequence; from L0 to L8 
        .end localvariabletable 
    .end code 
.end method 
.sourcefile 'ASN1Sequence.java' 
.end class 
