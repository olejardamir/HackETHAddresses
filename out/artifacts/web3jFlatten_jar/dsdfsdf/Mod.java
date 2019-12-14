abstract class Mod {
    Mod() {
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
    public static void invert(int[] arg, int[] arg0, int[] arg1) {/*error*/throw null;}
    
    
    private static void inversionResult(int[] a, int i, int[] a0, int[] a1) {
        if (i >= 0) {
            System.arraycopy((Object)a0, 0, (Object)a1, 0, a.length);
        } else {
            Nat.add(a.length, a0, a, a1);
        }
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
    private static int inversionStep(int[] arg, int[] arg0, int arg1, int[] arg2, int arg3) {/*error*/throw null;}
    
    
    private static int getTrailingZeroes(int i) {
        int i0 = 0;
        while((i & 1) == 0) {
            int i1 = i >>> 1;
            i0 = i0 + 1;
            i = i1;
        }
        return i0;
    }
}
