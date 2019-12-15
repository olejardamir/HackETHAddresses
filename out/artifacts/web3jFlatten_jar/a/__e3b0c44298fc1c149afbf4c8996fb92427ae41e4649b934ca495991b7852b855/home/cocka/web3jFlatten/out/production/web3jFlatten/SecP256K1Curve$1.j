.version 52 0 
.class super SecP256K1Curve$1 
.super java/lang/Object 
.implements ECLookupTable 
.field final synthetic val$len I 
.field final synthetic val$table [I 
.field final synthetic this$0 LSecP256K1Curve; 

.method <init> : (LSecP256K1Curve;I[I)V 
    .code stack 2 locals 4 
L0:     aload_0 
L1:     aload_1 
L2:     putfield Field SecP256K1Curve$1 this$0 LSecP256K1Curve; 
L5:     aload_0 
L6:     iload_2 
L7:     putfield Field SecP256K1Curve$1 val$len I 
L10:    aload_0 
L11:    aload_3 
L12:    putfield Field SecP256K1Curve$1 val$table [I 
L15:    aload_0 
L16:    invokespecial Method java/lang/Object <init> ()V 
L19:    return 
L20:    
        .linenumbertable 
            L0 77 
        .end linenumbertable 
        .localvariabletable 
            0 is this LSecP256K1Curve$1; from L0 to L20 
            1 is this$0 LSecP256K1Curve; from L0 to L20 
        .end localvariabletable 
    .end code 
.end method 

.method public getSize : ()I 
    .code stack 1 locals 1 
L0:     aload_0 
L1:     getfield Field SecP256K1Curve$1 val$len I 
L4:     ireturn 
L5:     
        .linenumbertable 
            L0 80 
        .end linenumbertable 
        .localvariabletable 
            0 is this LSecP256K1Curve$1; from L0 to L5 
        .end localvariabletable 
    .end code 
.end method 

.method public lookup : (I)LECPoint; 
    .code stack 6 locals 8 
L0:     invokestatic Method Nat256 create ()[I 
L3:     astore_2 
L4:     invokestatic Method Nat256 create ()[I 
L7:     astore_3 
L8:     iconst_0 
L9:     istore 4 
L11:    iconst_0 
L12:    istore 5 

        .stack full 
            locals Object SecP256K1Curve$1 Integer Object [I Object [I Integer Integer 
            stack 
        .end stack 
L14:    iload 5 
L16:    aload_0 
L17:    getfield Field SecP256K1Curve$1 val$len I 
L20:    if_icmpge L102 
L23:    iload 5 
L25:    iload_1 
L26:    ixor 
L27:    iconst_1 
L28:    isub 
L29:    bipush 31 
L31:    ishr 
L32:    istore 6 
L34:    iconst_0 
L35:    istore 7 

        .stack append Integer Integer 
L37:    iload 7 
L39:    bipush 8 
L41:    if_icmpge L93 
L44:    aload_2 
L45:    iload 7 
L47:    dup2 
L48:    iaload 
L49:    aload_0 
L50:    getfield Field SecP256K1Curve$1 val$table [I 
L53:    iload 4 
L55:    iload 7 
L57:    iadd 
L58:    iaload 
L59:    iload 6 
L61:    iand 
L62:    ixor 
L63:    iastore 
L64:    aload_3 
L65:    iload 7 
L67:    dup2 
L68:    iaload 
L69:    aload_0 
L70:    getfield Field SecP256K1Curve$1 val$table [I 
L73:    iload 4 
L75:    bipush 8 
L77:    iadd 
L78:    iload 7 
L80:    iadd 
L81:    iaload 
L82:    iload 6 
L84:    iand 
L85:    ixor 
L86:    iastore 
L87:    iinc 7 1 
L90:    goto L37 

        .stack chop 1 
L93:    iinc 4 16 
L96:    iinc 5 1 
L99:    goto L14 

        .stack chop 2 
L102:   aload_0 
L103:   getfield Field SecP256K1Curve$1 this$0 LSecP256K1Curve; 
L106:   new SecP256K1FieldElement 
L109:   dup 
L110:   aload_2 
L111:   invokespecial Method SecP256K1FieldElement <init> ([I)V 
L114:   new SecP256K1FieldElement 
L117:   dup 
L118:   aload_3 
L119:   invokespecial Method SecP256K1FieldElement <init> ([I)V 
L122:   iconst_0 
L123:   invokevirtual Method SecP256K1Curve createRawPoint (LECFieldElement;LECFieldElement;Z)LECPoint; 
L126:   areturn 
L127:   
        .linenumbertable 
            L0 85 
            L8 86 
            L11 88 
            L23 90 
            L34 92 
            L44 94 
            L64 95 
            L87 92 
            L93 98 
            L96 88 
            L102 101 
        .end linenumbertable 
        .localvariabletable 
            7 is j I from L37 to L93 
            6 is MASK I from L34 to L96 
            5 is i I from L14 to L102 
            0 is this LSecP256K1Curve$1; from L0 to L127 
            1 is index I from L0 to L127 
            2 is x [I from L4 to L127 
            3 is y [I from L8 to L127 
            4 is pos I from L11 to L127 
        .end localvariabletable 
    .end code 
.end method 
.sourcefile 'SecP256K1Curve.java' 
.enclosing method SecP256K1Curve createCacheSafeLookupTable ([LECPoint;II)LECLookupTable; 
.innerclasses 
    SecP256K1Curve$1 [0] [0] 
.end innerclasses 
.end class 
