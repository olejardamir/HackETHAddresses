abstract class FiniteFields {
    final static FiniteField GF_2;
    final private static FiniteField GF_3;
    
    FiniteFields() {
    }
    
    // Traceback (most recent call last):
    //   File "/home/cocka/Krakatau/Krakatau/java/javaclass.py", line 39, in _getMethod
    //     code_ast = javamethod.generateAST(method, graph, forbidden_identifiers)
    //   File "/home/cocka/Krakatau/Krakatau/java/javamethod.py", line 851, in generateAST
    //     ast_root, varinfo = astgen.createAST(method, graph, setree, namegen)
    //   File "/home/cocka/Krakatau/Krakatau/java/astgen.py", line 320, in createAST
    //     info = VarInfo(method, ssagraph.blocks, namegen)
    //   File "/home/cocka/Krakatau/Krakatau/java/astgen.py", line 32, in __init__
    //     tt = uc.getSingleTType() # temp hack
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 103, in getSingleTType
    //     return self.types.getSingleTType() if self.types else objtypes.NullTT
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 28, in getSingleTType
    //     return objtypes.commonSupertype(self.env, list(self.supers) + list(self.exact))
    //   File "/home/cocka/Krakatau/Krakatau/ssa/objtypes.py", line 78, in commonSupertype
    //     superclass = reduce(env.commonSuperclass, bases)
    //   File "/home/cocka/Krakatau/Krakatau/environment.py", line 43, in commonSuperclass
    //     a = self._getSuper(a)
    //   File "/home/cocka/Krakatau/Krakatau/environment.py", line 18, in _getSuper
    //     return self.getClass(name).supername
    //   File "/home/cocka/Krakatau/Krakatau/environment.py", line 24, in getClass
    //     result = self._loadClass(name)
    //   File "/home/cocka/Krakatau/Krakatau/environment.py", line 90, in _loadClass
    //     raise ClassLoaderError('ClassNotFoundException', name)
    // ClassLoaderError: 
    // ClassNotFoundException: java/lang/Throwable
    public static PolynomialExtensionField getBinaryExtensionField(int[] arg) {/*error*/throw null;}
    
    
    public static FiniteField getPrimeField(java.math.BigInteger a) {
        int i = a.bitLength();
        if (a.signum() > 0 && i >= 2) {
            if (i < 3) {
                switch(a.intValue()) {
                    case 3: {
                        return GF_3;
                    }
                    case 2: {
                        return GF_2;
                    }
                }
            }
            return (FiniteField)(Object)new PrimeField(a);
        }
        throw new IllegalArgumentException((String)None);
    }
    
    static {
        GF_2 = (FiniteField)(Object)new PrimeField(java.math.BigInteger.valueOf(2L));
        GF_3 = (FiniteField)(Object)new PrimeField(java.math.BigInteger.valueOf(3L));
    }
}
