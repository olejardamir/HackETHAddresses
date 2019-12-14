abstract class Nat256 {
    final private static long M = 4294967295L;
    
    Nat256() {
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
    public static int add(int[] arg, int[] arg0, int[] arg1) {/*error*/throw null;}
    
    
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
    public static int addBothTo(int[] arg, int[] arg0, int[] arg1) {/*error*/throw null;}
    
    
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
    public static int addTo(int[] arg, int[] arg0) {/*error*/throw null;}
    
    
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
    public static void copy(int[] arg, int arg0, int[] arg1, int arg2) {/*error*/throw null;}
    
    
    public static int[] create() {
        return new int[8];
    }
    
    public static int[] createExt() {
        return new int[16];
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
    public static boolean eq(int[] arg, int[] arg0) {/*error*/throw null;}
    
    
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
    public static int[] fromBigInteger(java.math.BigInteger arg) {/*error*/throw null;}
    
    
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
    public static int getBit(int[] arg, int arg0) {/*error*/throw null;}
    
    
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
    public static boolean gte(int[] arg, int[] arg0) {/*error*/throw null;}
    
    
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
    public static boolean isOne(int[] arg) {/*error*/throw null;}
    
    
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
    public static boolean isZero(int[] arg) {/*error*/throw null;}
    
    
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
    public static void mul(int[] arg, int[] arg0, int[] arg1) {/*error*/throw null;}
    
    
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
    public static int mulAddTo(int[] arg, int[] arg0, int[] arg1) {/*error*/throw null;}
    
    
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
    public static long mul33Add(int arg, int[] arg0, int arg1, int[] arg2, int arg3, int[] arg4, int arg5) {/*error*/throw null;}
    
    
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
    public static int mulByWordAddTo(int arg, int[] arg0, int[] arg1) {/*error*/throw null;}
    
    
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
    public static int mul33DWordAdd(int arg, long arg0, int[] arg1, int arg2) {/*error*/throw null;}
    
    
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
    public static int mul33WordAdd(int arg, int arg0, int[] arg1, int arg2) {/*error*/throw null;}
    
    
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
    public static void square(int[] arg, int[] arg0) {/*error*/throw null;}
    
    
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
    public static int sub(int[] arg, int[] arg0, int[] arg1) {/*error*/throw null;}
    
    
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
    public static void subFrom(int[] arg, int[] arg0) {/*error*/throw null;}
    
    
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
    public static java.math.BigInteger toBigInteger(int[] arg) {/*error*/throw null;}
    
    
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
    public static void zero(int[] arg) {/*error*/throw null;}
}
