.version 52 0 
.class super CustomNamedCurves 
.super java/lang/Object 
.field private static final secp256k1 LX9ECParametersHolder; 
.field private static final nameToCurve Ljava/util/Hashtable; .fieldattributes 
    .signature Ljava/util/Hashtable<Ljava/lang/String;LX9ECParametersHolder;>; 
.end fieldattributes 
.field private static final nameToOID Ljava/util/Hashtable; .fieldattributes 
    .signature Ljava/util/Hashtable<Ljava/lang/String;LASN1ObjectIdentifier;>; 
.end fieldattributes 
.field private static final oidToCurve Ljava/util/Hashtable; .fieldattributes 
    .signature Ljava/util/Hashtable<LASN1ObjectIdentifier;LX9ECParametersHolder;>; 
.end fieldattributes 
.field private static final oidToName Ljava/util/Hashtable; .fieldattributes 
    .signature Ljava/util/Hashtable<LASN1ObjectIdentifier;Ljava/lang/String;>; 
.end fieldattributes 
.field private static final names Ljava/util/Vector; .fieldattributes 
    .signature Ljava/util/Vector<Ljava/lang/String;>; 
.end fieldattributes 

.method <init> : ()V 
    .code stack 1 locals 1 
L0:     aload_0 
L1:     invokespecial Method java/lang/Object <init> ()V 
L4:     return 
L5:     
        .linenumbertable 
            L0 4 
        .end linenumbertable 
        .localvariabletable 
            0 is this LCustomNamedCurves; from L0 to L5 
        .end localvariabletable 
    .end code 
.end method 

.method private static configureCurveGLV : (LECCurve;)LECCurve; 
    .code stack 1 locals 1 
L0:     aload_0 
L1:     invokevirtual Method ECCurve configure ()LECCurve$Config; 
L4:     invokevirtual Method ECCurve$Config setEndomorphism ()LECCurve$Config; 
L7:     invokevirtual Method ECCurve$Config create ()LECCurve; 
L10:    areturn 
L11:    
        .linenumbertable 
            L0 8 
        .end linenumbertable 
        .localvariabletable 
            0 is c LECCurve; from L0 to L11 
        .end localvariabletable 
    .end code 
    .exceptions java/lang/Exception 
.end method 

.method private static defineCurveWithOID : ()V 
    .code stack 3 locals 1 
L0:     ldc 'secp256k1' 
L2:     astore_0 
L3:     getstatic Field CustomNamedCurves names Ljava/util/Vector; 
L6:     aload_0 
L7:     invokevirtual Method java/util/Vector addElement (Ljava/lang/Object;)V 
L10:    getstatic Field CustomNamedCurves oidToName Ljava/util/Hashtable; 
L13:    getstatic Field SECObjectIdentifiers secp256k1 LASN1ObjectIdentifier; 
L16:    aload_0 
L17:    invokevirtual Method java/util/Hashtable put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 
L20:    pop 
L21:    getstatic Field CustomNamedCurves oidToCurve Ljava/util/Hashtable; 
L24:    getstatic Field SECObjectIdentifiers secp256k1 LASN1ObjectIdentifier; 
L27:    getstatic Field CustomNamedCurves secp256k1 LX9ECParametersHolder; 
L30:    invokevirtual Method java/util/Hashtable put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 
L33:    pop 
L34:    aload_0 
L35:    invokestatic Method Strings toLowerCase (Ljava/lang/String;)Ljava/lang/String; 
L38:    astore_0 
L39:    getstatic Field CustomNamedCurves nameToOID Ljava/util/Hashtable; 
L42:    aload_0 
L43:    getstatic Field SECObjectIdentifiers secp256k1 LASN1ObjectIdentifier; 
L46:    invokevirtual Method java/util/Hashtable put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 
L49:    pop 
L50:    getstatic Field CustomNamedCurves nameToCurve Ljava/util/Hashtable; 
L53:    aload_0 
L54:    getstatic Field CustomNamedCurves secp256k1 LX9ECParametersHolder; 
L57:    invokevirtual Method java/util/Hashtable put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 
L60:    pop 
L61:    return 
L62:    
        .linenumbertable 
            L0 32 
            L3 33 
            L10 34 
            L21 35 
            L34 36 
            L39 37 
            L50 38 
            L61 39 
        .end linenumbertable 
        .localvariabletable 
            0 is name Ljava/lang/String; from L3 to L62 
        .end localvariabletable 
    .end code 
.end method 

.method public static getByName : ()LX9ECParameters; 
    .code stack 2 locals 1 
L0:     getstatic Field CustomNamedCurves nameToCurve Ljava/util/Hashtable; 
L3:     ldc 'secp256k1' 
L5:     invokevirtual Method java/util/Hashtable get (Ljava/lang/Object;)Ljava/lang/Object; 
L8:     checkcast X9ECParametersHolder 
L11:    astore_0 
L12:    aload_0 
L13:    ifnonnull L20 
L16:    aconst_null 
L17:    goto L24 

        .stack append Object X9ECParametersHolder 
L20:    aload_0 
L21:    invokevirtual Method X9ECParametersHolder getParameters ()LX9ECParameters; 

        .stack stack_1 Object X9ECParameters 
L24:    areturn 
L25:    
        .linenumbertable 
            L0 49 
            L12 50 
        .end linenumbertable 
        .localvariabletable 
            0 is holder LX9ECParametersHolder; from L12 to L25 
        .end localvariabletable 
    .end code 
    .exceptions java/lang/Exception 
.end method 

.method static synthetic access$000 : (LECCurve;)LECCurve; 
    .code stack 1 locals 1 
L0:     aload_0 
L1:     invokestatic Method CustomNamedCurves configureCurveGLV (LECCurve;)LECCurve; 
L4:     areturn 
L5:     
        .linenumbertable 
            L0 4 
        .end linenumbertable 
        .localvariabletable 
            0 is x0 LECCurve; from L0 to L5 
        .end localvariabletable 
    .end code 
    .exceptions java/lang/Exception 
.end method 

.method static <clinit> : ()V 
    .code stack 2 locals 0 
L0:     new CustomNamedCurves$1 
L3:     dup 
L4:     invokespecial Method CustomNamedCurves$1 <init> ()V 
L7:     putstatic Field CustomNamedCurves secp256k1 LX9ECParametersHolder; 
L10:    new java/util/Hashtable 
L13:    dup 
L14:    invokespecial Method java/util/Hashtable <init> ()V 
L17:    putstatic Field CustomNamedCurves nameToCurve Ljava/util/Hashtable; 
L20:    new java/util/Hashtable 
L23:    dup 
L24:    invokespecial Method java/util/Hashtable <init> ()V 
L27:    putstatic Field CustomNamedCurves nameToOID Ljava/util/Hashtable; 
L30:    new java/util/Hashtable 
L33:    dup 
L34:    invokespecial Method java/util/Hashtable <init> ()V 
L37:    putstatic Field CustomNamedCurves oidToCurve Ljava/util/Hashtable; 
L40:    new java/util/Hashtable 
L43:    dup 
L44:    invokespecial Method java/util/Hashtable <init> ()V 
L47:    putstatic Field CustomNamedCurves oidToName Ljava/util/Hashtable; 
L50:    new java/util/Vector 
L53:    dup 
L54:    invokespecial Method java/util/Vector <init> ()V 
L57:    putstatic Field CustomNamedCurves names Ljava/util/Vector; 
L60:    invokestatic Method CustomNamedCurves defineCurveWithOID ()V 
L63:    return 
L64:    
        .linenumbertable 
            L0 12 
            L10 24 
            L20 25 
            L30 26 
            L40 27 
            L50 28 
            L60 44 
            L63 46 
        .end linenumbertable 
    .end code 
.end method 
.sourcefile 'CustomNamedCurves.java' 
.innerclasses 
    CustomNamedCurves$1 [0] [0] static 
    ECCurve$Config ECCurve Config public 
.end innerclasses 
.end class 
