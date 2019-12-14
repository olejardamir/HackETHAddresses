class LongArray implements Cloneable {
    final private static short[] INTERLEAVE2_TABLE;
    final private static String ZEROES = "0000000000000000000000000000000000000000000000000000000000000000";
    final private static byte[] bitLengths;
    private long[] m_ints;
    
    // Traceback (most recent call last):
    //   File "/home/cocka/Krakatau/Krakatau/java/javaclass.py", line 37, in _getMethod
    //     graph = cb(method) if method.code is not None else None
    //   File "decompile.py", line 63, in makeGraph
    //     s.abstractInterpert()
    //   File "/home/cocka/Krakatau/Krakatau/ssa/graph.py", line 300, in abstractInterpert
    //     out = constraints.meet(*inputs)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/__init__.py", line 22, in meet
    //     return cons[0].meet(*cons[1:])
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 116, in meet
    //     types = TypeConstraint.meet(*(c.types for c in cons))
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 79, in meet
    //     return TypeConstraint.reduce(cons[0].env, supers, exact)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 41, in reduce
    //     if not isAnySubtype(env, x, newsupers):
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 10, in isAnySubtype
    //     return any(objtypes.isSubtype(env,x,y) for y in seq)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 10, in <genexpr>
    //     return any(objtypes.isSubtype(env,x,y) for y in seq)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/objtypes.py", line 54, in isSubtype
    //     return isBaseTClass(x) and isBaseTClass(y) and env.isSubclass(xname, yname)
    //   File "/home/cocka/Krakatau/Krakatau/environment.py", line 36, in isSubclass
    //     name1 = self._getSuper(name1)
    //   File "/home/cocka/Krakatau/Krakatau/environment.py", line 18, in _getSuper
    //     return self.getClass(name).supername
    //   File "/home/cocka/Krakatau/Krakatau/environment.py", line 24, in getClass
    //     result = self._loadClass(name)
    //   File "/home/cocka/Krakatau/Krakatau/environment.py", line 90, in _loadClass
    //     raise ClassLoaderError('ClassNotFoundException', name)
    // ClassLoaderError: 
    // ClassNotFoundException: java/lang/Throwable
    private LongArray(int arg) {/*error*/throw null;}
    
    
    // Traceback (most recent call last):
    //   File "/home/cocka/Krakatau/Krakatau/java/javaclass.py", line 37, in _getMethod
    //     graph = cb(method) if method.code is not None else None
    //   File "decompile.py", line 63, in makeGraph
    //     s.abstractInterpert()
    //   File "/home/cocka/Krakatau/Krakatau/ssa/graph.py", line 300, in abstractInterpert
    //     out = constraints.meet(*inputs)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/__init__.py", line 22, in meet
    //     return cons[0].meet(*cons[1:])
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 116, in meet
    //     types = TypeConstraint.meet(*(c.types for c in cons))
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 79, in meet
    //     return TypeConstraint.reduce(cons[0].env, supers, exact)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 41, in reduce
    //     if not isAnySubtype(env, x, newsupers):
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 10, in isAnySubtype
    //     return any(objtypes.isSubtype(env,x,y) for y in seq)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 10, in <genexpr>
    //     return any(objtypes.isSubtype(env,x,y) for y in seq)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/objtypes.py", line 54, in isSubtype
    //     return isBaseTClass(x) and isBaseTClass(y) and env.isSubclass(xname, yname)
    //   File "/home/cocka/Krakatau/Krakatau/environment.py", line 36, in isSubclass
    //     name1 = self._getSuper(name1)
    //   File "/home/cocka/Krakatau/Krakatau/environment.py", line 18, in _getSuper
    //     return self.getClass(name).supername
    //   File "/home/cocka/Krakatau/Krakatau/environment.py", line 24, in getClass
    //     result = self._loadClass(name)
    //   File "/home/cocka/Krakatau/Krakatau/environment.py", line 90, in _loadClass
    //     raise ClassLoaderError('ClassNotFoundException', name)
    // ClassLoaderError: 
    // ClassNotFoundException: java/lang/Throwable
    public LongArray(long[] arg) {/*error*/throw null;}
    
    
    // Traceback (most recent call last):
    //   File "/home/cocka/Krakatau/Krakatau/java/javaclass.py", line 37, in _getMethod
    //     graph = cb(method) if method.code is not None else None
    //   File "decompile.py", line 63, in makeGraph
    //     s.abstractInterpert()
    //   File "/home/cocka/Krakatau/Krakatau/ssa/graph.py", line 300, in abstractInterpert
    //     out = constraints.meet(*inputs)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/__init__.py", line 22, in meet
    //     return cons[0].meet(*cons[1:])
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 116, in meet
    //     types = TypeConstraint.meet(*(c.types for c in cons))
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 79, in meet
    //     return TypeConstraint.reduce(cons[0].env, supers, exact)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 41, in reduce
    //     if not isAnySubtype(env, x, newsupers):
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 10, in isAnySubtype
    //     return any(objtypes.isSubtype(env,x,y) for y in seq)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 10, in <genexpr>
    //     return any(objtypes.isSubtype(env,x,y) for y in seq)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/objtypes.py", line 54, in isSubtype
    //     return isBaseTClass(x) and isBaseTClass(y) and env.isSubclass(xname, yname)
    //   File "/home/cocka/Krakatau/Krakatau/environment.py", line 36, in isSubclass
    //     name1 = self._getSuper(name1)
    //   File "/home/cocka/Krakatau/Krakatau/environment.py", line 18, in _getSuper
    //     return self.getClass(name).supername
    //   File "/home/cocka/Krakatau/Krakatau/environment.py", line 24, in getClass
    //     result = self._loadClass(name)
    //   File "/home/cocka/Krakatau/Krakatau/environment.py", line 90, in _loadClass
    //     raise ClassLoaderError('ClassNotFoundException', name)
    // ClassLoaderError: 
    // ClassNotFoundException: java/lang/Throwable
    private LongArray(long[] arg, int arg0) {/*error*/throw null;}
    
    
    // Traceback (most recent call last):
    //   File "/home/cocka/Krakatau/Krakatau/java/javaclass.py", line 37, in _getMethod
    //     graph = cb(method) if method.code is not None else None
    //   File "decompile.py", line 63, in makeGraph
    //     s.abstractInterpert()
    //   File "/home/cocka/Krakatau/Krakatau/ssa/graph.py", line 300, in abstractInterpert
    //     out = constraints.meet(*inputs)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/__init__.py", line 22, in meet
    //     return cons[0].meet(*cons[1:])
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 116, in meet
    //     types = TypeConstraint.meet(*(c.types for c in cons))
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 79, in meet
    //     return TypeConstraint.reduce(cons[0].env, supers, exact)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 41, in reduce
    //     if not isAnySubtype(env, x, newsupers):
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 10, in isAnySubtype
    //     return any(objtypes.isSubtype(env,x,y) for y in seq)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 10, in <genexpr>
    //     return any(objtypes.isSubtype(env,x,y) for y in seq)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/objtypes.py", line 54, in isSubtype
    //     return isBaseTClass(x) and isBaseTClass(y) and env.isSubclass(xname, yname)
    //   File "/home/cocka/Krakatau/Krakatau/environment.py", line 36, in isSubclass
    //     name1 = self._getSuper(name1)
    //   File "/home/cocka/Krakatau/Krakatau/environment.py", line 18, in _getSuper
    //     return self.getClass(name).supername
    //   File "/home/cocka/Krakatau/Krakatau/environment.py", line 24, in getClass
    //     result = self._loadClass(name)
    //   File "/home/cocka/Krakatau/Krakatau/environment.py", line 90, in _loadClass
    //     raise ClassLoaderError('ClassNotFoundException', name)
    // ClassLoaderError: 
    // ClassNotFoundException: java/lang/Throwable
    public LongArray(java.math.BigInteger arg) {/*error*/throw null;}
    
    
    // Traceback (most recent call last):
    //   File "/home/cocka/Krakatau/Krakatau/java/javaclass.py", line 37, in _getMethod
    //     graph = cb(method) if method.code is not None else None
    //   File "decompile.py", line 63, in makeGraph
    //     s.abstractInterpert()
    //   File "/home/cocka/Krakatau/Krakatau/ssa/graph.py", line 300, in abstractInterpert
    //     out = constraints.meet(*inputs)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/__init__.py", line 22, in meet
    //     return cons[0].meet(*cons[1:])
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 116, in meet
    //     types = TypeConstraint.meet(*(c.types for c in cons))
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 79, in meet
    //     return TypeConstraint.reduce(cons[0].env, supers, exact)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 41, in reduce
    //     if not isAnySubtype(env, x, newsupers):
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 10, in isAnySubtype
    //     return any(objtypes.isSubtype(env,x,y) for y in seq)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 10, in <genexpr>
    //     return any(objtypes.isSubtype(env,x,y) for y in seq)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/objtypes.py", line 54, in isSubtype
    //     return isBaseTClass(x) and isBaseTClass(y) and env.isSubclass(xname, yname)
    //   File "/home/cocka/Krakatau/Krakatau/environment.py", line 36, in isSubclass
    //     name1 = self._getSuper(name1)
    //   File "/home/cocka/Krakatau/Krakatau/environment.py", line 18, in _getSuper
    //     return self.getClass(name).supername
    //   File "/home/cocka/Krakatau/Krakatau/environment.py", line 24, in getClass
    //     result = self._loadClass(name)
    //   File "/home/cocka/Krakatau/Krakatau/environment.py", line 90, in _loadClass
    //     raise ClassLoaderError('ClassNotFoundException', name)
    // ClassLoaderError: 
    // ClassNotFoundException: java/lang/Throwable
    void copyTo(long[] arg, int arg0) {/*error*/throw null;}
    
    
    // Traceback (most recent call last):
    //   File "/home/cocka/Krakatau/Krakatau/java/javaclass.py", line 37, in _getMethod
    //     graph = cb(method) if method.code is not None else None
    //   File "decompile.py", line 63, in makeGraph
    //     s.abstractInterpert()
    //   File "/home/cocka/Krakatau/Krakatau/ssa/graph.py", line 300, in abstractInterpert
    //     out = constraints.meet(*inputs)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/__init__.py", line 22, in meet
    //     return cons[0].meet(*cons[1:])
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 116, in meet
    //     types = TypeConstraint.meet(*(c.types for c in cons))
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 79, in meet
    //     return TypeConstraint.reduce(cons[0].env, supers, exact)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 41, in reduce
    //     if not isAnySubtype(env, x, newsupers):
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 10, in isAnySubtype
    //     return any(objtypes.isSubtype(env,x,y) for y in seq)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 10, in <genexpr>
    //     return any(objtypes.isSubtype(env,x,y) for y in seq)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/objtypes.py", line 54, in isSubtype
    //     return isBaseTClass(x) and isBaseTClass(y) and env.isSubclass(xname, yname)
    //   File "/home/cocka/Krakatau/Krakatau/environment.py", line 36, in isSubclass
    //     name1 = self._getSuper(name1)
    //   File "/home/cocka/Krakatau/Krakatau/environment.py", line 18, in _getSuper
    //     return self.getClass(name).supername
    //   File "/home/cocka/Krakatau/Krakatau/environment.py", line 24, in getClass
    //     result = self._loadClass(name)
    //   File "/home/cocka/Krakatau/Krakatau/environment.py", line 90, in _loadClass
    //     raise ClassLoaderError('ClassNotFoundException', name)
    // ClassLoaderError: 
    // ClassNotFoundException: java/lang/Throwable
    public boolean isOne() {/*error*/throw null;}
    
    
    // Traceback (most recent call last):
    //   File "/home/cocka/Krakatau/Krakatau/java/javaclass.py", line 37, in _getMethod
    //     graph = cb(method) if method.code is not None else None
    //   File "decompile.py", line 63, in makeGraph
    //     s.abstractInterpert()
    //   File "/home/cocka/Krakatau/Krakatau/ssa/graph.py", line 300, in abstractInterpert
    //     out = constraints.meet(*inputs)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/__init__.py", line 22, in meet
    //     return cons[0].meet(*cons[1:])
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 116, in meet
    //     types = TypeConstraint.meet(*(c.types for c in cons))
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 79, in meet
    //     return TypeConstraint.reduce(cons[0].env, supers, exact)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 41, in reduce
    //     if not isAnySubtype(env, x, newsupers):
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 10, in isAnySubtype
    //     return any(objtypes.isSubtype(env,x,y) for y in seq)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 10, in <genexpr>
    //     return any(objtypes.isSubtype(env,x,y) for y in seq)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/objtypes.py", line 54, in isSubtype
    //     return isBaseTClass(x) and isBaseTClass(y) and env.isSubclass(xname, yname)
    //   File "/home/cocka/Krakatau/Krakatau/environment.py", line 36, in isSubclass
    //     name1 = self._getSuper(name1)
    //   File "/home/cocka/Krakatau/Krakatau/environment.py", line 18, in _getSuper
    //     return self.getClass(name).supername
    //   File "/home/cocka/Krakatau/Krakatau/environment.py", line 24, in getClass
    //     result = self._loadClass(name)
    //   File "/home/cocka/Krakatau/Krakatau/environment.py", line 90, in _loadClass
    //     raise ClassLoaderError('ClassNotFoundException', name)
    // ClassLoaderError: 
    // ClassNotFoundException: java/lang/Throwable
    public boolean isZero() {/*error*/throw null;}
    
    
    // Traceback (most recent call last):
    //   File "/home/cocka/Krakatau/Krakatau/java/javaclass.py", line 37, in _getMethod
    //     graph = cb(method) if method.code is not None else None
    //   File "decompile.py", line 63, in makeGraph
    //     s.abstractInterpert()
    //   File "/home/cocka/Krakatau/Krakatau/ssa/graph.py", line 300, in abstractInterpert
    //     out = constraints.meet(*inputs)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/__init__.py", line 22, in meet
    //     return cons[0].meet(*cons[1:])
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 116, in meet
    //     types = TypeConstraint.meet(*(c.types for c in cons))
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 79, in meet
    //     return TypeConstraint.reduce(cons[0].env, supers, exact)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 41, in reduce
    //     if not isAnySubtype(env, x, newsupers):
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 10, in isAnySubtype
    //     return any(objtypes.isSubtype(env,x,y) for y in seq)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 10, in <genexpr>
    //     return any(objtypes.isSubtype(env,x,y) for y in seq)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/objtypes.py", line 54, in isSubtype
    //     return isBaseTClass(x) and isBaseTClass(y) and env.isSubclass(xname, yname)
    //   File "/home/cocka/Krakatau/Krakatau/environment.py", line 36, in isSubclass
    //     name1 = self._getSuper(name1)
    //   File "/home/cocka/Krakatau/Krakatau/environment.py", line 18, in _getSuper
    //     return self.getClass(name).supername
    //   File "/home/cocka/Krakatau/Krakatau/environment.py", line 24, in getClass
    //     result = self._loadClass(name)
    //   File "/home/cocka/Krakatau/Krakatau/environment.py", line 90, in _loadClass
    //     raise ClassLoaderError('ClassNotFoundException', name)
    // ClassLoaderError: 
    // ClassNotFoundException: java/lang/Throwable
    private int getUsedLength() {/*error*/throw null;}
    
    
    // Traceback (most recent call last):
    //   File "/home/cocka/Krakatau/Krakatau/java/javaclass.py", line 37, in _getMethod
    //     graph = cb(method) if method.code is not None else None
    //   File "decompile.py", line 63, in makeGraph
    //     s.abstractInterpert()
    //   File "/home/cocka/Krakatau/Krakatau/ssa/graph.py", line 300, in abstractInterpert
    //     out = constraints.meet(*inputs)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/__init__.py", line 22, in meet
    //     return cons[0].meet(*cons[1:])
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 116, in meet
    //     types = TypeConstraint.meet(*(c.types for c in cons))
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 79, in meet
    //     return TypeConstraint.reduce(cons[0].env, supers, exact)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 41, in reduce
    //     if not isAnySubtype(env, x, newsupers):
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 10, in isAnySubtype
    //     return any(objtypes.isSubtype(env,x,y) for y in seq)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 10, in <genexpr>
    //     return any(objtypes.isSubtype(env,x,y) for y in seq)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/objtypes.py", line 54, in isSubtype
    //     return isBaseTClass(x) and isBaseTClass(y) and env.isSubclass(xname, yname)
    //   File "/home/cocka/Krakatau/Krakatau/environment.py", line 36, in isSubclass
    //     name1 = self._getSuper(name1)
    //   File "/home/cocka/Krakatau/Krakatau/environment.py", line 18, in _getSuper
    //     return self.getClass(name).supername
    //   File "/home/cocka/Krakatau/Krakatau/environment.py", line 24, in getClass
    //     result = self._loadClass(name)
    //   File "/home/cocka/Krakatau/Krakatau/environment.py", line 90, in _loadClass
    //     raise ClassLoaderError('ClassNotFoundException', name)
    // ClassLoaderError: 
    // ClassNotFoundException: java/lang/Throwable
    private int getUsedLengthFrom(int arg) {/*error*/throw null;}
    
    
    // Traceback (most recent call last):
    //   File "/home/cocka/Krakatau/Krakatau/java/javaclass.py", line 37, in _getMethod
    //     graph = cb(method) if method.code is not None else None
    //   File "decompile.py", line 63, in makeGraph
    //     s.abstractInterpert()
    //   File "/home/cocka/Krakatau/Krakatau/ssa/graph.py", line 300, in abstractInterpert
    //     out = constraints.meet(*inputs)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/__init__.py", line 22, in meet
    //     return cons[0].meet(*cons[1:])
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 116, in meet
    //     types = TypeConstraint.meet(*(c.types for c in cons))
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 79, in meet
    //     return TypeConstraint.reduce(cons[0].env, supers, exact)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 41, in reduce
    //     if not isAnySubtype(env, x, newsupers):
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 10, in isAnySubtype
    //     return any(objtypes.isSubtype(env,x,y) for y in seq)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 10, in <genexpr>
    //     return any(objtypes.isSubtype(env,x,y) for y in seq)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/objtypes.py", line 54, in isSubtype
    //     return isBaseTClass(x) and isBaseTClass(y) and env.isSubclass(xname, yname)
    //   File "/home/cocka/Krakatau/Krakatau/environment.py", line 36, in isSubclass
    //     name1 = self._getSuper(name1)
    //   File "/home/cocka/Krakatau/Krakatau/environment.py", line 18, in _getSuper
    //     return self.getClass(name).supername
    //   File "/home/cocka/Krakatau/Krakatau/environment.py", line 24, in getClass
    //     result = self._loadClass(name)
    //   File "/home/cocka/Krakatau/Krakatau/environment.py", line 90, in _loadClass
    //     raise ClassLoaderError('ClassNotFoundException', name)
    // ClassLoaderError: 
    // ClassNotFoundException: java/lang/Throwable
    public int degree() {/*error*/throw null;}
    
    
    // Traceback (most recent call last):
    //   File "/home/cocka/Krakatau/Krakatau/java/javaclass.py", line 37, in _getMethod
    //     graph = cb(method) if method.code is not None else None
    //   File "decompile.py", line 63, in makeGraph
    //     s.abstractInterpert()
    //   File "/home/cocka/Krakatau/Krakatau/ssa/graph.py", line 300, in abstractInterpert
    //     out = constraints.meet(*inputs)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/__init__.py", line 22, in meet
    //     return cons[0].meet(*cons[1:])
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 116, in meet
    //     types = TypeConstraint.meet(*(c.types for c in cons))
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 79, in meet
    //     return TypeConstraint.reduce(cons[0].env, supers, exact)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 41, in reduce
    //     if not isAnySubtype(env, x, newsupers):
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 10, in isAnySubtype
    //     return any(objtypes.isSubtype(env,x,y) for y in seq)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 10, in <genexpr>
    //     return any(objtypes.isSubtype(env,x,y) for y in seq)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/objtypes.py", line 54, in isSubtype
    //     return isBaseTClass(x) and isBaseTClass(y) and env.isSubclass(xname, yname)
    //   File "/home/cocka/Krakatau/Krakatau/environment.py", line 36, in isSubclass
    //     name1 = self._getSuper(name1)
    //   File "/home/cocka/Krakatau/Krakatau/environment.py", line 18, in _getSuper
    //     return self.getClass(name).supername
    //   File "/home/cocka/Krakatau/Krakatau/environment.py", line 24, in getClass
    //     result = self._loadClass(name)
    //   File "/home/cocka/Krakatau/Krakatau/environment.py", line 90, in _loadClass
    //     raise ClassLoaderError('ClassNotFoundException', name)
    // ClassLoaderError: 
    // ClassNotFoundException: java/lang/Throwable
    private int degreeFrom(int arg) {/*error*/throw null;}
    
    
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
    private static int bitLength(long arg) {/*error*/throw null;}
    
    
    // Traceback (most recent call last):
    //   File "/home/cocka/Krakatau/Krakatau/java/javaclass.py", line 37, in _getMethod
    //     graph = cb(method) if method.code is not None else None
    //   File "decompile.py", line 63, in makeGraph
    //     s.abstractInterpert()
    //   File "/home/cocka/Krakatau/Krakatau/ssa/graph.py", line 300, in abstractInterpert
    //     out = constraints.meet(*inputs)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/__init__.py", line 22, in meet
    //     return cons[0].meet(*cons[1:])
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 116, in meet
    //     types = TypeConstraint.meet(*(c.types for c in cons))
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 79, in meet
    //     return TypeConstraint.reduce(cons[0].env, supers, exact)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 41, in reduce
    //     if not isAnySubtype(env, x, newsupers):
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 10, in isAnySubtype
    //     return any(objtypes.isSubtype(env,x,y) for y in seq)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 10, in <genexpr>
    //     return any(objtypes.isSubtype(env,x,y) for y in seq)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/objtypes.py", line 54, in isSubtype
    //     return isBaseTClass(x) and isBaseTClass(y) and env.isSubclass(xname, yname)
    //   File "/home/cocka/Krakatau/Krakatau/environment.py", line 36, in isSubclass
    //     name1 = self._getSuper(name1)
    //   File "/home/cocka/Krakatau/Krakatau/environment.py", line 18, in _getSuper
    //     return self.getClass(name).supername
    //   File "/home/cocka/Krakatau/Krakatau/environment.py", line 24, in getClass
    //     result = self._loadClass(name)
    //   File "/home/cocka/Krakatau/Krakatau/environment.py", line 90, in _loadClass
    //     raise ClassLoaderError('ClassNotFoundException', name)
    // ClassLoaderError: 
    // ClassNotFoundException: java/lang/Throwable
    private long[] resizedInts(int arg) {/*error*/throw null;}
    
    
    // Traceback (most recent call last):
    //   File "/home/cocka/Krakatau/Krakatau/java/javaclass.py", line 37, in _getMethod
    //     graph = cb(method) if method.code is not None else None
    //   File "decompile.py", line 63, in makeGraph
    //     s.abstractInterpert()
    //   File "/home/cocka/Krakatau/Krakatau/ssa/graph.py", line 300, in abstractInterpert
    //     out = constraints.meet(*inputs)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/__init__.py", line 22, in meet
    //     return cons[0].meet(*cons[1:])
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 116, in meet
    //     types = TypeConstraint.meet(*(c.types for c in cons))
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 79, in meet
    //     return TypeConstraint.reduce(cons[0].env, supers, exact)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 41, in reduce
    //     if not isAnySubtype(env, x, newsupers):
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 10, in isAnySubtype
    //     return any(objtypes.isSubtype(env,x,y) for y in seq)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 10, in <genexpr>
    //     return any(objtypes.isSubtype(env,x,y) for y in seq)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/objtypes.py", line 54, in isSubtype
    //     return isBaseTClass(x) and isBaseTClass(y) and env.isSubclass(xname, yname)
    //   File "/home/cocka/Krakatau/Krakatau/environment.py", line 36, in isSubclass
    //     name1 = self._getSuper(name1)
    //   File "/home/cocka/Krakatau/Krakatau/environment.py", line 18, in _getSuper
    //     return self.getClass(name).supername
    //   File "/home/cocka/Krakatau/Krakatau/environment.py", line 24, in getClass
    //     result = self._loadClass(name)
    //   File "/home/cocka/Krakatau/Krakatau/environment.py", line 90, in _loadClass
    //     raise ClassLoaderError('ClassNotFoundException', name)
    // ClassLoaderError: 
    // ClassNotFoundException: java/lang/Throwable
    public java.math.BigInteger toBigInteger() {/*error*/throw null;}
    
    
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
    private static void shiftUp(long[] arg, int arg0, long[] arg1, int arg2, int arg3, int arg4) {/*error*/throw null;}
    
    
    // Traceback (most recent call last):
    //   File "/home/cocka/Krakatau/Krakatau/java/javaclass.py", line 37, in _getMethod
    //     graph = cb(method) if method.code is not None else None
    //   File "decompile.py", line 63, in makeGraph
    //     s.abstractInterpert()
    //   File "/home/cocka/Krakatau/Krakatau/ssa/graph.py", line 300, in abstractInterpert
    //     out = constraints.meet(*inputs)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/__init__.py", line 22, in meet
    //     return cons[0].meet(*cons[1:])
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 116, in meet
    //     types = TypeConstraint.meet(*(c.types for c in cons))
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 79, in meet
    //     return TypeConstraint.reduce(cons[0].env, supers, exact)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 41, in reduce
    //     if not isAnySubtype(env, x, newsupers):
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 10, in isAnySubtype
    //     return any(objtypes.isSubtype(env,x,y) for y in seq)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 10, in <genexpr>
    //     return any(objtypes.isSubtype(env,x,y) for y in seq)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/objtypes.py", line 54, in isSubtype
    //     return isBaseTClass(x) and isBaseTClass(y) and env.isSubclass(xname, yname)
    //   File "/home/cocka/Krakatau/Krakatau/environment.py", line 36, in isSubclass
    //     name1 = self._getSuper(name1)
    //   File "/home/cocka/Krakatau/Krakatau/environment.py", line 18, in _getSuper
    //     return self.getClass(name).supername
    //   File "/home/cocka/Krakatau/Krakatau/environment.py", line 24, in getClass
    //     result = self._loadClass(name)
    //   File "/home/cocka/Krakatau/Krakatau/environment.py", line 90, in _loadClass
    //     raise ClassLoaderError('ClassNotFoundException', name)
    // ClassLoaderError: 
    // ClassNotFoundException: java/lang/Throwable
    public LongArray addOne() {/*error*/throw null;}
    
    
    // Traceback (most recent call last):
    //   File "/home/cocka/Krakatau/Krakatau/java/javaclass.py", line 37, in _getMethod
    //     graph = cb(method) if method.code is not None else None
    //   File "decompile.py", line 63, in makeGraph
    //     s.abstractInterpert()
    //   File "/home/cocka/Krakatau/Krakatau/ssa/graph.py", line 300, in abstractInterpert
    //     out = constraints.meet(*inputs)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/__init__.py", line 22, in meet
    //     return cons[0].meet(*cons[1:])
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 116, in meet
    //     types = TypeConstraint.meet(*(c.types for c in cons))
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 79, in meet
    //     return TypeConstraint.reduce(cons[0].env, supers, exact)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 41, in reduce
    //     if not isAnySubtype(env, x, newsupers):
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 10, in isAnySubtype
    //     return any(objtypes.isSubtype(env,x,y) for y in seq)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 10, in <genexpr>
    //     return any(objtypes.isSubtype(env,x,y) for y in seq)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/objtypes.py", line 54, in isSubtype
    //     return isBaseTClass(x) and isBaseTClass(y) and env.isSubclass(xname, yname)
    //   File "/home/cocka/Krakatau/Krakatau/environment.py", line 36, in isSubclass
    //     name1 = self._getSuper(name1)
    //   File "/home/cocka/Krakatau/Krakatau/environment.py", line 18, in _getSuper
    //     return self.getClass(name).supername
    //   File "/home/cocka/Krakatau/Krakatau/environment.py", line 24, in getClass
    //     result = self._loadClass(name)
    //   File "/home/cocka/Krakatau/Krakatau/environment.py", line 90, in _loadClass
    //     raise ClassLoaderError('ClassNotFoundException', name)
    // ClassLoaderError: 
    // ClassNotFoundException: java/lang/Throwable
    private void addShiftedByBitsSafe(LongArray arg, int arg0, int arg1) {/*error*/throw null;}
    
    
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
    private static long addShiftedUp(long[] arg, int arg0, long[] arg1, int arg2, int arg3, int arg4) {/*error*/throw null;}
    
    
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
    private static long addShiftedDown(long[] arg, int arg0, long[] arg1, int arg2, int arg3, int arg4) {/*error*/throw null;}
    
    
    // Traceback (most recent call last):
    //   File "/home/cocka/Krakatau/Krakatau/java/javaclass.py", line 37, in _getMethod
    //     graph = cb(method) if method.code is not None else None
    //   File "decompile.py", line 63, in makeGraph
    //     s.abstractInterpert()
    //   File "/home/cocka/Krakatau/Krakatau/ssa/graph.py", line 300, in abstractInterpert
    //     out = constraints.meet(*inputs)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/__init__.py", line 22, in meet
    //     return cons[0].meet(*cons[1:])
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 116, in meet
    //     types = TypeConstraint.meet(*(c.types for c in cons))
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 79, in meet
    //     return TypeConstraint.reduce(cons[0].env, supers, exact)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 41, in reduce
    //     if not isAnySubtype(env, x, newsupers):
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 10, in isAnySubtype
    //     return any(objtypes.isSubtype(env,x,y) for y in seq)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 10, in <genexpr>
    //     return any(objtypes.isSubtype(env,x,y) for y in seq)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/objtypes.py", line 54, in isSubtype
    //     return isBaseTClass(x) and isBaseTClass(y) and env.isSubclass(xname, yname)
    //   File "/home/cocka/Krakatau/Krakatau/environment.py", line 36, in isSubclass
    //     name1 = self._getSuper(name1)
    //   File "/home/cocka/Krakatau/Krakatau/environment.py", line 18, in _getSuper
    //     return self.getClass(name).supername
    //   File "/home/cocka/Krakatau/Krakatau/environment.py", line 24, in getClass
    //     result = self._loadClass(name)
    //   File "/home/cocka/Krakatau/Krakatau/environment.py", line 90, in _loadClass
    //     raise ClassLoaderError('ClassNotFoundException', name)
    // ClassLoaderError: 
    // ClassNotFoundException: java/lang/Throwable
    public void addShiftedByWords(LongArray arg, int arg0) {/*error*/throw null;}
    
    
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
    private static void add(long[] arg, int arg0, long[] arg1, int arg2, int arg3) {/*error*/throw null;}
    
    
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
    private static void add(long[] arg, int arg0, long[] arg1, int arg2, long[] arg3, int arg4, int arg5) {/*error*/throw null;}
    
    
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
    private static void addBoth(long[] arg, int arg0, long[] arg1, int arg2, long[] arg3, int arg4, int arg5) {/*error*/throw null;}
    
    
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
    private static void flipWord(long[] arg, int arg0, int arg1, long arg2) {/*error*/throw null;}
    
    
    // Traceback (most recent call last):
    //   File "/home/cocka/Krakatau/Krakatau/java/javaclass.py", line 37, in _getMethod
    //     graph = cb(method) if method.code is not None else None
    //   File "decompile.py", line 63, in makeGraph
    //     s.abstractInterpert()
    //   File "/home/cocka/Krakatau/Krakatau/ssa/graph.py", line 300, in abstractInterpert
    //     out = constraints.meet(*inputs)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/__init__.py", line 22, in meet
    //     return cons[0].meet(*cons[1:])
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 116, in meet
    //     types = TypeConstraint.meet(*(c.types for c in cons))
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 79, in meet
    //     return TypeConstraint.reduce(cons[0].env, supers, exact)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 41, in reduce
    //     if not isAnySubtype(env, x, newsupers):
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 10, in isAnySubtype
    //     return any(objtypes.isSubtype(env,x,y) for y in seq)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 10, in <genexpr>
    //     return any(objtypes.isSubtype(env,x,y) for y in seq)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/objtypes.py", line 54, in isSubtype
    //     return isBaseTClass(x) and isBaseTClass(y) and env.isSubclass(xname, yname)
    //   File "/home/cocka/Krakatau/Krakatau/environment.py", line 36, in isSubclass
    //     name1 = self._getSuper(name1)
    //   File "/home/cocka/Krakatau/Krakatau/environment.py", line 18, in _getSuper
    //     return self.getClass(name).supername
    //   File "/home/cocka/Krakatau/Krakatau/environment.py", line 24, in getClass
    //     result = self._loadClass(name)
    //   File "/home/cocka/Krakatau/Krakatau/environment.py", line 90, in _loadClass
    //     raise ClassLoaderError('ClassNotFoundException', name)
    // ClassLoaderError: 
    // ClassNotFoundException: java/lang/Throwable
    public boolean testBitZero() {/*error*/throw null;}
    
    
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
    private static boolean testBit(long[] arg, int arg0) {/*error*/throw null;}
    
    
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
    private static void flipBit(long[] arg, int arg0, int arg1) {/*error*/throw null;}
    
    
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
    private static void multiplyWord(long arg, long[] arg0, int arg1, long[] arg2) {/*error*/throw null;}
    
    
    // Traceback (most recent call last):
    //   File "/home/cocka/Krakatau/Krakatau/java/javaclass.py", line 37, in _getMethod
    //     graph = cb(method) if method.code is not None else None
    //   File "decompile.py", line 63, in makeGraph
    //     s.abstractInterpert()
    //   File "/home/cocka/Krakatau/Krakatau/ssa/graph.py", line 300, in abstractInterpert
    //     out = constraints.meet(*inputs)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/__init__.py", line 22, in meet
    //     return cons[0].meet(*cons[1:])
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 116, in meet
    //     types = TypeConstraint.meet(*(c.types for c in cons))
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 79, in meet
    //     return TypeConstraint.reduce(cons[0].env, supers, exact)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 41, in reduce
    //     if not isAnySubtype(env, x, newsupers):
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 10, in isAnySubtype
    //     return any(objtypes.isSubtype(env,x,y) for y in seq)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 10, in <genexpr>
    //     return any(objtypes.isSubtype(env,x,y) for y in seq)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/objtypes.py", line 54, in isSubtype
    //     return isBaseTClass(x) and isBaseTClass(y) and env.isSubclass(xname, yname)
    //   File "/home/cocka/Krakatau/Krakatau/environment.py", line 36, in isSubclass
    //     name1 = self._getSuper(name1)
    //   File "/home/cocka/Krakatau/Krakatau/environment.py", line 18, in _getSuper
    //     return self.getClass(name).supername
    //   File "/home/cocka/Krakatau/Krakatau/environment.py", line 24, in getClass
    //     result = self._loadClass(name)
    //   File "/home/cocka/Krakatau/Krakatau/environment.py", line 90, in _loadClass
    //     raise ClassLoaderError('ClassNotFoundException', name)
    // ClassLoaderError: 
    // ClassNotFoundException: java/lang/Throwable
    public LongArray modMultiply(LongArray arg, int arg0, int[] arg1) {/*error*/throw null;}
    
    
    // Traceback (most recent call last):
    //   File "/home/cocka/Krakatau/Krakatau/java/javaclass.py", line 37, in _getMethod
    //     graph = cb(method) if method.code is not None else None
    //   File "decompile.py", line 63, in makeGraph
    //     s.abstractInterpert()
    //   File "/home/cocka/Krakatau/Krakatau/ssa/graph.py", line 300, in abstractInterpert
    //     out = constraints.meet(*inputs)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/__init__.py", line 22, in meet
    //     return cons[0].meet(*cons[1:])
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 116, in meet
    //     types = TypeConstraint.meet(*(c.types for c in cons))
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 79, in meet
    //     return TypeConstraint.reduce(cons[0].env, supers, exact)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 41, in reduce
    //     if not isAnySubtype(env, x, newsupers):
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 10, in isAnySubtype
    //     return any(objtypes.isSubtype(env,x,y) for y in seq)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 10, in <genexpr>
    //     return any(objtypes.isSubtype(env,x,y) for y in seq)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/objtypes.py", line 54, in isSubtype
    //     return isBaseTClass(x) and isBaseTClass(y) and env.isSubclass(xname, yname)
    //   File "/home/cocka/Krakatau/Krakatau/environment.py", line 36, in isSubclass
    //     name1 = self._getSuper(name1)
    //   File "/home/cocka/Krakatau/Krakatau/environment.py", line 18, in _getSuper
    //     return self.getClass(name).supername
    //   File "/home/cocka/Krakatau/Krakatau/environment.py", line 24, in getClass
    //     result = self._loadClass(name)
    //   File "/home/cocka/Krakatau/Krakatau/environment.py", line 90, in _loadClass
    //     raise ClassLoaderError('ClassNotFoundException', name)
    // ClassLoaderError: 
    // ClassNotFoundException: java/lang/Throwable
    public LongArray multiply(LongArray arg) {/*error*/throw null;}
    
    
    // Traceback (most recent call last):
    //   File "/home/cocka/Krakatau/Krakatau/java/javaclass.py", line 37, in _getMethod
    //     graph = cb(method) if method.code is not None else None
    //   File "decompile.py", line 63, in makeGraph
    //     s.abstractInterpert()
    //   File "/home/cocka/Krakatau/Krakatau/ssa/graph.py", line 300, in abstractInterpert
    //     out = constraints.meet(*inputs)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/__init__.py", line 22, in meet
    //     return cons[0].meet(*cons[1:])
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 116, in meet
    //     types = TypeConstraint.meet(*(c.types for c in cons))
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 79, in meet
    //     return TypeConstraint.reduce(cons[0].env, supers, exact)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 41, in reduce
    //     if not isAnySubtype(env, x, newsupers):
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 10, in isAnySubtype
    //     return any(objtypes.isSubtype(env,x,y) for y in seq)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 10, in <genexpr>
    //     return any(objtypes.isSubtype(env,x,y) for y in seq)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/objtypes.py", line 54, in isSubtype
    //     return isBaseTClass(x) and isBaseTClass(y) and env.isSubclass(xname, yname)
    //   File "/home/cocka/Krakatau/Krakatau/environment.py", line 36, in isSubclass
    //     name1 = self._getSuper(name1)
    //   File "/home/cocka/Krakatau/Krakatau/environment.py", line 18, in _getSuper
    //     return self.getClass(name).supername
    //   File "/home/cocka/Krakatau/Krakatau/environment.py", line 24, in getClass
    //     result = self._loadClass(name)
    //   File "/home/cocka/Krakatau/Krakatau/environment.py", line 90, in _loadClass
    //     raise ClassLoaderError('ClassNotFoundException', name)
    // ClassLoaderError: 
    // ClassNotFoundException: java/lang/Throwable
    public void reduce(int arg, int[] arg0) {/*error*/throw null;}
    
    
    private static LongArray reduceResult(long[] a, int i, int i0, int[] a0) {
        return new LongArray(a, LongArray.reduceInPlace(a, i, i0, a0));
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
    private static int reduceInPlace(long[] arg, int arg0, int arg1, int[] arg2) {/*error*/throw null;}
    
    
    private static void reduceBitWise(long[] a, int i, int i0, int[] a0) {
        while(true) {
            int i1 = i + -1;
            if (i1 < i0) {
                return;
            }
            if (LongArray.testBit(a, i1)) {
                LongArray.reduceBit(a, i1, i0, a0);
                i = i1;
            } else {
                i = i1;
            }
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
    private static void reduceBit(long[] arg, int arg0, int arg1, int[] arg2) {/*error*/throw null;}
    
    
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
    private static void reduceWordWise(long[] arg, int arg0, int arg1, int arg2, int[] arg3) {/*error*/throw null;}
    
    
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
    private static void reduceWord(long[] arg, int arg0, long arg1, int arg2, int[] arg3) {/*error*/throw null;}
    
    
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
    private static void reduceVectorWise(long[] arg, int arg0, int arg1, int arg2, int[] arg3) {/*error*/throw null;}
    
    
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
    private static void flipVector(long[] arg, int arg0, long[] arg1, int arg2, int arg3, int arg4) {/*error*/throw null;}
    
    
    // Traceback (most recent call last):
    //   File "/home/cocka/Krakatau/Krakatau/java/javaclass.py", line 37, in _getMethod
    //     graph = cb(method) if method.code is not None else None
    //   File "decompile.py", line 63, in makeGraph
    //     s.abstractInterpert()
    //   File "/home/cocka/Krakatau/Krakatau/ssa/graph.py", line 300, in abstractInterpert
    //     out = constraints.meet(*inputs)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/__init__.py", line 22, in meet
    //     return cons[0].meet(*cons[1:])
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 116, in meet
    //     types = TypeConstraint.meet(*(c.types for c in cons))
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 79, in meet
    //     return TypeConstraint.reduce(cons[0].env, supers, exact)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 41, in reduce
    //     if not isAnySubtype(env, x, newsupers):
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 10, in isAnySubtype
    //     return any(objtypes.isSubtype(env,x,y) for y in seq)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 10, in <genexpr>
    //     return any(objtypes.isSubtype(env,x,y) for y in seq)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/objtypes.py", line 54, in isSubtype
    //     return isBaseTClass(x) and isBaseTClass(y) and env.isSubclass(xname, yname)
    //   File "/home/cocka/Krakatau/Krakatau/environment.py", line 36, in isSubclass
    //     name1 = self._getSuper(name1)
    //   File "/home/cocka/Krakatau/Krakatau/environment.py", line 18, in _getSuper
    //     return self.getClass(name).supername
    //   File "/home/cocka/Krakatau/Krakatau/environment.py", line 24, in getClass
    //     result = self._loadClass(name)
    //   File "/home/cocka/Krakatau/Krakatau/environment.py", line 90, in _loadClass
    //     raise ClassLoaderError('ClassNotFoundException', name)
    // ClassLoaderError: 
    // ClassNotFoundException: java/lang/Throwable
    public LongArray modSquare(int arg, int[] arg0) {/*error*/throw null;}
    
    
    // Traceback (most recent call last):
    //   File "/home/cocka/Krakatau/Krakatau/java/javaclass.py", line 37, in _getMethod
    //     graph = cb(method) if method.code is not None else None
    //   File "decompile.py", line 63, in makeGraph
    //     s.abstractInterpert()
    //   File "/home/cocka/Krakatau/Krakatau/ssa/graph.py", line 300, in abstractInterpert
    //     out = constraints.meet(*inputs)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/__init__.py", line 22, in meet
    //     return cons[0].meet(*cons[1:])
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 116, in meet
    //     types = TypeConstraint.meet(*(c.types for c in cons))
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 79, in meet
    //     return TypeConstraint.reduce(cons[0].env, supers, exact)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 41, in reduce
    //     if not isAnySubtype(env, x, newsupers):
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 10, in isAnySubtype
    //     return any(objtypes.isSubtype(env,x,y) for y in seq)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 10, in <genexpr>
    //     return any(objtypes.isSubtype(env,x,y) for y in seq)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/objtypes.py", line 54, in isSubtype
    //     return isBaseTClass(x) and isBaseTClass(y) and env.isSubclass(xname, yname)
    //   File "/home/cocka/Krakatau/Krakatau/environment.py", line 36, in isSubclass
    //     name1 = self._getSuper(name1)
    //   File "/home/cocka/Krakatau/Krakatau/environment.py", line 18, in _getSuper
    //     return self.getClass(name).supername
    //   File "/home/cocka/Krakatau/Krakatau/environment.py", line 24, in getClass
    //     result = self._loadClass(name)
    //   File "/home/cocka/Krakatau/Krakatau/environment.py", line 90, in _loadClass
    //     raise ClassLoaderError('ClassNotFoundException', name)
    // ClassLoaderError: 
    // ClassNotFoundException: java/lang/Throwable
    public LongArray modSquareN(int arg, int arg0, int[] arg1) {/*error*/throw null;}
    
    
    // Traceback (most recent call last):
    //   File "/home/cocka/Krakatau/Krakatau/java/javaclass.py", line 37, in _getMethod
    //     graph = cb(method) if method.code is not None else None
    //   File "decompile.py", line 63, in makeGraph
    //     s.abstractInterpert()
    //   File "/home/cocka/Krakatau/Krakatau/ssa/graph.py", line 300, in abstractInterpert
    //     out = constraints.meet(*inputs)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/__init__.py", line 22, in meet
    //     return cons[0].meet(*cons[1:])
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 116, in meet
    //     types = TypeConstraint.meet(*(c.types for c in cons))
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 79, in meet
    //     return TypeConstraint.reduce(cons[0].env, supers, exact)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 41, in reduce
    //     if not isAnySubtype(env, x, newsupers):
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 10, in isAnySubtype
    //     return any(objtypes.isSubtype(env,x,y) for y in seq)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 10, in <genexpr>
    //     return any(objtypes.isSubtype(env,x,y) for y in seq)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/objtypes.py", line 54, in isSubtype
    //     return isBaseTClass(x) and isBaseTClass(y) and env.isSubclass(xname, yname)
    //   File "/home/cocka/Krakatau/Krakatau/environment.py", line 36, in isSubclass
    //     name1 = self._getSuper(name1)
    //   File "/home/cocka/Krakatau/Krakatau/environment.py", line 18, in _getSuper
    //     return self.getClass(name).supername
    //   File "/home/cocka/Krakatau/Krakatau/environment.py", line 24, in getClass
    //     result = self._loadClass(name)
    //   File "/home/cocka/Krakatau/Krakatau/environment.py", line 90, in _loadClass
    //     raise ClassLoaderError('ClassNotFoundException', name)
    // ClassLoaderError: 
    // ClassNotFoundException: java/lang/Throwable
    public LongArray square() {/*error*/throw null;}
    
    
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
    private static void squareInPlace(long[] arg, int arg0) {/*error*/throw null;}
    
    
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
    private static long interleave2_32to64(int arg) {/*error*/throw null;}
    
    
    // Traceback (most recent call last):
    //   File "/home/cocka/Krakatau/Krakatau/java/javaclass.py", line 37, in _getMethod
    //     graph = cb(method) if method.code is not None else None
    //   File "decompile.py", line 63, in makeGraph
    //     s.abstractInterpert()
    //   File "/home/cocka/Krakatau/Krakatau/ssa/graph.py", line 300, in abstractInterpert
    //     out = constraints.meet(*inputs)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/__init__.py", line 22, in meet
    //     return cons[0].meet(*cons[1:])
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 116, in meet
    //     types = TypeConstraint.meet(*(c.types for c in cons))
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 79, in meet
    //     return TypeConstraint.reduce(cons[0].env, supers, exact)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 45, in reduce
    //     newexact = [x for x in exact if not isAnySubtype(env, x, newsupers)]
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 10, in isAnySubtype
    //     return any(objtypes.isSubtype(env,x,y) for y in seq)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 10, in <genexpr>
    //     return any(objtypes.isSubtype(env,x,y) for y in seq)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/objtypes.py", line 54, in isSubtype
    //     return isBaseTClass(x) and isBaseTClass(y) and env.isSubclass(xname, yname)
    //   File "/home/cocka/Krakatau/Krakatau/environment.py", line 36, in isSubclass
    //     name1 = self._getSuper(name1)
    //   File "/home/cocka/Krakatau/Krakatau/environment.py", line 18, in _getSuper
    //     return self.getClass(name).supername
    //   File "/home/cocka/Krakatau/Krakatau/environment.py", line 24, in getClass
    //     result = self._loadClass(name)
    //   File "/home/cocka/Krakatau/Krakatau/environment.py", line 90, in _loadClass
    //     raise ClassLoaderError('ClassNotFoundException', name)
    // ClassLoaderError: 
    // ClassNotFoundException: java/lang/ClassCastException
    public LongArray modInverse(int arg, int[] arg0) {/*error*/throw null;}
    
    
    // Traceback (most recent call last):
    //   File "/home/cocka/Krakatau/Krakatau/java/javaclass.py", line 37, in _getMethod
    //     graph = cb(method) if method.code is not None else None
    //   File "decompile.py", line 63, in makeGraph
    //     s.abstractInterpert()
    //   File "/home/cocka/Krakatau/Krakatau/ssa/graph.py", line 300, in abstractInterpert
    //     out = constraints.meet(*inputs)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/__init__.py", line 22, in meet
    //     return cons[0].meet(*cons[1:])
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 116, in meet
    //     types = TypeConstraint.meet(*(c.types for c in cons))
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 79, in meet
    //     return TypeConstraint.reduce(cons[0].env, supers, exact)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 45, in reduce
    //     newexact = [x for x in exact if not isAnySubtype(env, x, newsupers)]
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 10, in isAnySubtype
    //     return any(objtypes.isSubtype(env,x,y) for y in seq)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 10, in <genexpr>
    //     return any(objtypes.isSubtype(env,x,y) for y in seq)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/objtypes.py", line 54, in isSubtype
    //     return isBaseTClass(x) and isBaseTClass(y) and env.isSubclass(xname, yname)
    //   File "/home/cocka/Krakatau/Krakatau/environment.py", line 36, in isSubclass
    //     name1 = self._getSuper(name1)
    //   File "/home/cocka/Krakatau/Krakatau/environment.py", line 18, in _getSuper
    //     return self.getClass(name).supername
    //   File "/home/cocka/Krakatau/Krakatau/environment.py", line 24, in getClass
    //     result = self._loadClass(name)
    //   File "/home/cocka/Krakatau/Krakatau/environment.py", line 90, in _loadClass
    //     raise ClassLoaderError('ClassNotFoundException', name)
    // ClassLoaderError: 
    // ClassNotFoundException: java/lang/ClassCastException
    public boolean equals(Object arg) {/*error*/throw null;}
    
    
    // Traceback (most recent call last):
    //   File "/home/cocka/Krakatau/Krakatau/java/javaclass.py", line 37, in _getMethod
    //     graph = cb(method) if method.code is not None else None
    //   File "decompile.py", line 63, in makeGraph
    //     s.abstractInterpert()
    //   File "/home/cocka/Krakatau/Krakatau/ssa/graph.py", line 300, in abstractInterpert
    //     out = constraints.meet(*inputs)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/__init__.py", line 22, in meet
    //     return cons[0].meet(*cons[1:])
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 116, in meet
    //     types = TypeConstraint.meet(*(c.types for c in cons))
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 79, in meet
    //     return TypeConstraint.reduce(cons[0].env, supers, exact)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 41, in reduce
    //     if not isAnySubtype(env, x, newsupers):
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 10, in isAnySubtype
    //     return any(objtypes.isSubtype(env,x,y) for y in seq)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 10, in <genexpr>
    //     return any(objtypes.isSubtype(env,x,y) for y in seq)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/objtypes.py", line 54, in isSubtype
    //     return isBaseTClass(x) and isBaseTClass(y) and env.isSubclass(xname, yname)
    //   File "/home/cocka/Krakatau/Krakatau/environment.py", line 36, in isSubclass
    //     name1 = self._getSuper(name1)
    //   File "/home/cocka/Krakatau/Krakatau/environment.py", line 18, in _getSuper
    //     return self.getClass(name).supername
    //   File "/home/cocka/Krakatau/Krakatau/environment.py", line 24, in getClass
    //     result = self._loadClass(name)
    //   File "/home/cocka/Krakatau/Krakatau/environment.py", line 90, in _loadClass
    //     raise ClassLoaderError('ClassNotFoundException', name)
    // ClassLoaderError: 
    // ClassNotFoundException: java/lang/Throwable
    public int hashCode() {/*error*/throw null;}
    
    
    // Traceback (most recent call last):
    //   File "/home/cocka/Krakatau/Krakatau/java/javaclass.py", line 37, in _getMethod
    //     graph = cb(method) if method.code is not None else None
    //   File "decompile.py", line 63, in makeGraph
    //     s.abstractInterpert()
    //   File "/home/cocka/Krakatau/Krakatau/ssa/graph.py", line 300, in abstractInterpert
    //     out = constraints.meet(*inputs)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/__init__.py", line 22, in meet
    //     return cons[0].meet(*cons[1:])
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 116, in meet
    //     types = TypeConstraint.meet(*(c.types for c in cons))
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 79, in meet
    //     return TypeConstraint.reduce(cons[0].env, supers, exact)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 41, in reduce
    //     if not isAnySubtype(env, x, newsupers):
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 10, in isAnySubtype
    //     return any(objtypes.isSubtype(env,x,y) for y in seq)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 10, in <genexpr>
    //     return any(objtypes.isSubtype(env,x,y) for y in seq)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/objtypes.py", line 54, in isSubtype
    //     return isBaseTClass(x) and isBaseTClass(y) and env.isSubclass(xname, yname)
    //   File "/home/cocka/Krakatau/Krakatau/environment.py", line 36, in isSubclass
    //     name1 = self._getSuper(name1)
    //   File "/home/cocka/Krakatau/Krakatau/environment.py", line 18, in _getSuper
    //     return self.getClass(name).supername
    //   File "/home/cocka/Krakatau/Krakatau/environment.py", line 24, in getClass
    //     result = self._loadClass(name)
    //   File "/home/cocka/Krakatau/Krakatau/environment.py", line 90, in _loadClass
    //     raise ClassLoaderError('ClassNotFoundException', name)
    // ClassLoaderError: 
    // ClassNotFoundException: java/lang/Throwable
    public Object clone() {/*error*/throw null;}
    
    
    // Traceback (most recent call last):
    //   File "/home/cocka/Krakatau/Krakatau/java/javaclass.py", line 37, in _getMethod
    //     graph = cb(method) if method.code is not None else None
    //   File "decompile.py", line 63, in makeGraph
    //     s.abstractInterpert()
    //   File "/home/cocka/Krakatau/Krakatau/ssa/graph.py", line 300, in abstractInterpert
    //     out = constraints.meet(*inputs)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/__init__.py", line 22, in meet
    //     return cons[0].meet(*cons[1:])
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 116, in meet
    //     types = TypeConstraint.meet(*(c.types for c in cons))
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 79, in meet
    //     return TypeConstraint.reduce(cons[0].env, supers, exact)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 41, in reduce
    //     if not isAnySubtype(env, x, newsupers):
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 10, in isAnySubtype
    //     return any(objtypes.isSubtype(env,x,y) for y in seq)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/constraints/obj_c.py", line 10, in <genexpr>
    //     return any(objtypes.isSubtype(env,x,y) for y in seq)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/objtypes.py", line 54, in isSubtype
    //     return isBaseTClass(x) and isBaseTClass(y) and env.isSubclass(xname, yname)
    //   File "/home/cocka/Krakatau/Krakatau/environment.py", line 36, in isSubclass
    //     name1 = self._getSuper(name1)
    //   File "/home/cocka/Krakatau/Krakatau/environment.py", line 18, in _getSuper
    //     return self.getClass(name).supername
    //   File "/home/cocka/Krakatau/Krakatau/environment.py", line 24, in getClass
    //     result = self._loadClass(name)
    //   File "/home/cocka/Krakatau/Krakatau/environment.py", line 90, in _loadClass
    //     raise ClassLoaderError('ClassNotFoundException', name)
    // ClassLoaderError: 
    // ClassNotFoundException: java/lang/Throwable
    public String toString() {/*error*/throw null;}
    
    
    static {
        short[] a = new short[256];
        a[0] = (short)0;
        a[1] = (short)1;
        a[2] = (short)4;
        a[3] = (short)5;
        a[4] = (short)16;
        a[5] = (short)17;
        a[6] = (short)20;
        a[7] = (short)21;
        a[8] = (short)64;
        a[9] = (short)65;
        a[10] = (short)68;
        a[11] = (short)69;
        a[12] = (short)80;
        a[13] = (short)81;
        a[14] = (short)84;
        a[15] = (short)85;
        a[16] = (short)256;
        a[17] = (short)257;
        a[18] = (short)260;
        a[19] = (short)261;
        a[20] = (short)272;
        a[21] = (short)273;
        a[22] = (short)276;
        a[23] = (short)277;
        a[24] = (short)320;
        a[25] = (short)321;
        a[26] = (short)324;
        a[27] = (short)325;
        a[28] = (short)336;
        a[29] = (short)337;
        a[30] = (short)340;
        a[31] = (short)341;
        a[32] = (short)1024;
        a[33] = (short)1025;
        a[34] = (short)1028;
        a[35] = (short)1029;
        a[36] = (short)1040;
        a[37] = (short)1041;
        a[38] = (short)1044;
        a[39] = (short)1045;
        a[40] = (short)1088;
        a[41] = (short)1089;
        a[42] = (short)1092;
        a[43] = (short)1093;
        a[44] = (short)1104;
        a[45] = (short)1105;
        a[46] = (short)1108;
        a[47] = (short)1109;
        a[48] = (short)1280;
        a[49] = (short)1281;
        a[50] = (short)1284;
        a[51] = (short)1285;
        a[52] = (short)1296;
        a[53] = (short)1297;
        a[54] = (short)1300;
        a[55] = (short)1301;
        a[56] = (short)1344;
        a[57] = (short)1345;
        a[58] = (short)1348;
        a[59] = (short)1349;
        a[60] = (short)1360;
        a[61] = (short)1361;
        a[62] = (short)1364;
        a[63] = (short)1365;
        a[64] = (short)4096;
        a[65] = (short)4097;
        a[66] = (short)4100;
        a[67] = (short)4101;
        a[68] = (short)4112;
        a[69] = (short)4113;
        a[70] = (short)4116;
        a[71] = (short)4117;
        a[72] = (short)4160;
        a[73] = (short)4161;
        a[74] = (short)4164;
        a[75] = (short)4165;
        a[76] = (short)4176;
        a[77] = (short)4177;
        a[78] = (short)4180;
        a[79] = (short)4181;
        a[80] = (short)4352;
        a[81] = (short)4353;
        a[82] = (short)4356;
        a[83] = (short)4357;
        a[84] = (short)4368;
        a[85] = (short)4369;
        a[86] = (short)4372;
        a[87] = (short)4373;
        a[88] = (short)4416;
        a[89] = (short)4417;
        a[90] = (short)4420;
        a[91] = (short)4421;
        a[92] = (short)4432;
        a[93] = (short)4433;
        a[94] = (short)4436;
        a[95] = (short)4437;
        a[96] = (short)5120;
        a[97] = (short)5121;
        a[98] = (short)5124;
        a[99] = (short)5125;
        a[100] = (short)5136;
        a[101] = (short)5137;
        a[102] = (short)5140;
        a[103] = (short)5141;
        a[104] = (short)5184;
        a[105] = (short)5185;
        a[106] = (short)5188;
        a[107] = (short)5189;
        a[108] = (short)5200;
        a[109] = (short)5201;
        a[110] = (short)5204;
        a[111] = (short)5205;
        a[112] = (short)5376;
        a[113] = (short)5377;
        a[114] = (short)5380;
        a[115] = (short)5381;
        a[116] = (short)5392;
        a[117] = (short)5393;
        a[118] = (short)5396;
        a[119] = (short)5397;
        a[120] = (short)5440;
        a[121] = (short)5441;
        a[122] = (short)5444;
        a[123] = (short)5445;
        a[124] = (short)5456;
        a[125] = (short)5457;
        a[126] = (short)5460;
        a[127] = (short)5461;
        a[128] = (short)16384;
        a[129] = (short)16385;
        a[130] = (short)16388;
        a[131] = (short)16389;
        a[132] = (short)16400;
        a[133] = (short)16401;
        a[134] = (short)16404;
        a[135] = (short)16405;
        a[136] = (short)16448;
        a[137] = (short)16449;
        a[138] = (short)16452;
        a[139] = (short)16453;
        a[140] = (short)16464;
        a[141] = (short)16465;
        a[142] = (short)16468;
        a[143] = (short)16469;
        a[144] = (short)16640;
        a[145] = (short)16641;
        a[146] = (short)16644;
        a[147] = (short)16645;
        a[148] = (short)16656;
        a[149] = (short)16657;
        a[150] = (short)16660;
        a[151] = (short)16661;
        a[152] = (short)16704;
        a[153] = (short)16705;
        a[154] = (short)16708;
        a[155] = (short)16709;
        a[156] = (short)16720;
        a[157] = (short)16721;
        a[158] = (short)16724;
        a[159] = (short)16725;
        a[160] = (short)17408;
        a[161] = (short)17409;
        a[162] = (short)17412;
        a[163] = (short)17413;
        a[164] = (short)17424;
        a[165] = (short)17425;
        a[166] = (short)17428;
        a[167] = (short)17429;
        a[168] = (short)17472;
        a[169] = (short)17473;
        a[170] = (short)17476;
        a[171] = (short)17477;
        a[172] = (short)17488;
        a[173] = (short)17489;
        a[174] = (short)17492;
        a[175] = (short)17493;
        a[176] = (short)17664;
        a[177] = (short)17665;
        a[178] = (short)17668;
        a[179] = (short)17669;
        a[180] = (short)17680;
        a[181] = (short)17681;
        a[182] = (short)17684;
        a[183] = (short)17685;
        a[184] = (short)17728;
        a[185] = (short)17729;
        a[186] = (short)17732;
        a[187] = (short)17733;
        a[188] = (short)17744;
        a[189] = (short)17745;
        a[190] = (short)17748;
        a[191] = (short)17749;
        a[192] = (short)20480;
        a[193] = (short)20481;
        a[194] = (short)20484;
        a[195] = (short)20485;
        a[196] = (short)20496;
        a[197] = (short)20497;
        a[198] = (short)20500;
        a[199] = (short)20501;
        a[200] = (short)20544;
        a[201] = (short)20545;
        a[202] = (short)20548;
        a[203] = (short)20549;
        a[204] = (short)20560;
        a[205] = (short)20561;
        a[206] = (short)20564;
        a[207] = (short)20565;
        a[208] = (short)20736;
        a[209] = (short)20737;
        a[210] = (short)20740;
        a[211] = (short)20741;
        a[212] = (short)20752;
        a[213] = (short)20753;
        a[214] = (short)20756;
        a[215] = (short)20757;
        a[216] = (short)20800;
        a[217] = (short)20801;
        a[218] = (short)20804;
        a[219] = (short)20805;
        a[220] = (short)20816;
        a[221] = (short)20817;
        a[222] = (short)20820;
        a[223] = (short)20821;
        a[224] = (short)21504;
        a[225] = (short)21505;
        a[226] = (short)21508;
        a[227] = (short)21509;
        a[228] = (short)21520;
        a[229] = (short)21521;
        a[230] = (short)21524;
        a[231] = (short)21525;
        a[232] = (short)21568;
        a[233] = (short)21569;
        a[234] = (short)21572;
        a[235] = (short)21573;
        a[236] = (short)21584;
        a[237] = (short)21585;
        a[238] = (short)21588;
        a[239] = (short)21589;
        a[240] = (short)21760;
        a[241] = (short)21761;
        a[242] = (short)21764;
        a[243] = (short)21765;
        a[244] = (short)21776;
        a[245] = (short)21777;
        a[246] = (short)21780;
        a[247] = (short)21781;
        a[248] = (short)21824;
        a[249] = (short)21825;
        a[250] = (short)21828;
        a[251] = (short)21829;
        a[252] = (short)21840;
        a[253] = (short)21841;
        a[254] = (short)21844;
        a[255] = (short)21845;
        INTERLEAVE2_TABLE = a;
        byte[] a0 = new byte[256];
        a0[0] = (byte)0;
        a0[1] = (byte)1;
        a0[2] = (byte)2;
        a0[3] = (byte)2;
        a0[4] = (byte)3;
        a0[5] = (byte)3;
        a0[6] = (byte)3;
        a0[7] = (byte)3;
        a0[8] = (byte)4;
        a0[9] = (byte)4;
        a0[10] = (byte)4;
        a0[11] = (byte)4;
        a0[12] = (byte)4;
        a0[13] = (byte)4;
        a0[14] = (byte)4;
        a0[15] = (byte)4;
        a0[16] = (byte)5;
        a0[17] = (byte)5;
        a0[18] = (byte)5;
        a0[19] = (byte)5;
        a0[20] = (byte)5;
        a0[21] = (byte)5;
        a0[22] = (byte)5;
        a0[23] = (byte)5;
        a0[24] = (byte)5;
        a0[25] = (byte)5;
        a0[26] = (byte)5;
        a0[27] = (byte)5;
        a0[28] = (byte)5;
        a0[29] = (byte)5;
        a0[30] = (byte)5;
        a0[31] = (byte)5;
        a0[32] = (byte)6;
        a0[33] = (byte)6;
        a0[34] = (byte)6;
        a0[35] = (byte)6;
        a0[36] = (byte)6;
        a0[37] = (byte)6;
        a0[38] = (byte)6;
        a0[39] = (byte)6;
        a0[40] = (byte)6;
        a0[41] = (byte)6;
        a0[42] = (byte)6;
        a0[43] = (byte)6;
        a0[44] = (byte)6;
        a0[45] = (byte)6;
        a0[46] = (byte)6;
        a0[47] = (byte)6;
        a0[48] = (byte)6;
        a0[49] = (byte)6;
        a0[50] = (byte)6;
        a0[51] = (byte)6;
        a0[52] = (byte)6;
        a0[53] = (byte)6;
        a0[54] = (byte)6;
        a0[55] = (byte)6;
        a0[56] = (byte)6;
        a0[57] = (byte)6;
        a0[58] = (byte)6;
        a0[59] = (byte)6;
        a0[60] = (byte)6;
        a0[61] = (byte)6;
        a0[62] = (byte)6;
        a0[63] = (byte)6;
        a0[64] = (byte)7;
        a0[65] = (byte)7;
        a0[66] = (byte)7;
        a0[67] = (byte)7;
        a0[68] = (byte)7;
        a0[69] = (byte)7;
        a0[70] = (byte)7;
        a0[71] = (byte)7;
        a0[72] = (byte)7;
        a0[73] = (byte)7;
        a0[74] = (byte)7;
        a0[75] = (byte)7;
        a0[76] = (byte)7;
        a0[77] = (byte)7;
        a0[78] = (byte)7;
        a0[79] = (byte)7;
        a0[80] = (byte)7;
        a0[81] = (byte)7;
        a0[82] = (byte)7;
        a0[83] = (byte)7;
        a0[84] = (byte)7;
        a0[85] = (byte)7;
        a0[86] = (byte)7;
        a0[87] = (byte)7;
        a0[88] = (byte)7;
        a0[89] = (byte)7;
        a0[90] = (byte)7;
        a0[91] = (byte)7;
        a0[92] = (byte)7;
        a0[93] = (byte)7;
        a0[94] = (byte)7;
        a0[95] = (byte)7;
        a0[96] = (byte)7;
        a0[97] = (byte)7;
        a0[98] = (byte)7;
        a0[99] = (byte)7;
        a0[100] = (byte)7;
        a0[101] = (byte)7;
        a0[102] = (byte)7;
        a0[103] = (byte)7;
        a0[104] = (byte)7;
        a0[105] = (byte)7;
        a0[106] = (byte)7;
        a0[107] = (byte)7;
        a0[108] = (byte)7;
        a0[109] = (byte)7;
        a0[110] = (byte)7;
        a0[111] = (byte)7;
        a0[112] = (byte)7;
        a0[113] = (byte)7;
        a0[114] = (byte)7;
        a0[115] = (byte)7;
        a0[116] = (byte)7;
        a0[117] = (byte)7;
        a0[118] = (byte)7;
        a0[119] = (byte)7;
        a0[120] = (byte)7;
        a0[121] = (byte)7;
        a0[122] = (byte)7;
        a0[123] = (byte)7;
        a0[124] = (byte)7;
        a0[125] = (byte)7;
        a0[126] = (byte)7;
        a0[127] = (byte)7;
        a0[128] = (byte)8;
        a0[129] = (byte)8;
        a0[130] = (byte)8;
        a0[131] = (byte)8;
        a0[132] = (byte)8;
        a0[133] = (byte)8;
        a0[134] = (byte)8;
        a0[135] = (byte)8;
        a0[136] = (byte)8;
        a0[137] = (byte)8;
        a0[138] = (byte)8;
        a0[139] = (byte)8;
        a0[140] = (byte)8;
        a0[141] = (byte)8;
        a0[142] = (byte)8;
        a0[143] = (byte)8;
        a0[144] = (byte)8;
        a0[145] = (byte)8;
        a0[146] = (byte)8;
        a0[147] = (byte)8;
        a0[148] = (byte)8;
        a0[149] = (byte)8;
        a0[150] = (byte)8;
        a0[151] = (byte)8;
        a0[152] = (byte)8;
        a0[153] = (byte)8;
        a0[154] = (byte)8;
        a0[155] = (byte)8;
        a0[156] = (byte)8;
        a0[157] = (byte)8;
        a0[158] = (byte)8;
        a0[159] = (byte)8;
        a0[160] = (byte)8;
        a0[161] = (byte)8;
        a0[162] = (byte)8;
        a0[163] = (byte)8;
        a0[164] = (byte)8;
        a0[165] = (byte)8;
        a0[166] = (byte)8;
        a0[167] = (byte)8;
        a0[168] = (byte)8;
        a0[169] = (byte)8;
        a0[170] = (byte)8;
        a0[171] = (byte)8;
        a0[172] = (byte)8;
        a0[173] = (byte)8;
        a0[174] = (byte)8;
        a0[175] = (byte)8;
        a0[176] = (byte)8;
        a0[177] = (byte)8;
        a0[178] = (byte)8;
        a0[179] = (byte)8;
        a0[180] = (byte)8;
        a0[181] = (byte)8;
        a0[182] = (byte)8;
        a0[183] = (byte)8;
        a0[184] = (byte)8;
        a0[185] = (byte)8;
        a0[186] = (byte)8;
        a0[187] = (byte)8;
        a0[188] = (byte)8;
        a0[189] = (byte)8;
        a0[190] = (byte)8;
        a0[191] = (byte)8;
        a0[192] = (byte)8;
        a0[193] = (byte)8;
        a0[194] = (byte)8;
        a0[195] = (byte)8;
        a0[196] = (byte)8;
        a0[197] = (byte)8;
        a0[198] = (byte)8;
        a0[199] = (byte)8;
        a0[200] = (byte)8;
        a0[201] = (byte)8;
        a0[202] = (byte)8;
        a0[203] = (byte)8;
        a0[204] = (byte)8;
        a0[205] = (byte)8;
        a0[206] = (byte)8;
        a0[207] = (byte)8;
        a0[208] = (byte)8;
        a0[209] = (byte)8;
        a0[210] = (byte)8;
        a0[211] = (byte)8;
        a0[212] = (byte)8;
        a0[213] = (byte)8;
        a0[214] = (byte)8;
        a0[215] = (byte)8;
        a0[216] = (byte)8;
        a0[217] = (byte)8;
        a0[218] = (byte)8;
        a0[219] = (byte)8;
        a0[220] = (byte)8;
        a0[221] = (byte)8;
        a0[222] = (byte)8;
        a0[223] = (byte)8;
        a0[224] = (byte)8;
        a0[225] = (byte)8;
        a0[226] = (byte)8;
        a0[227] = (byte)8;
        a0[228] = (byte)8;
        a0[229] = (byte)8;
        a0[230] = (byte)8;
        a0[231] = (byte)8;
        a0[232] = (byte)8;
        a0[233] = (byte)8;
        a0[234] = (byte)8;
        a0[235] = (byte)8;
        a0[236] = (byte)8;
        a0[237] = (byte)8;
        a0[238] = (byte)8;
        a0[239] = (byte)8;
        a0[240] = (byte)8;
        a0[241] = (byte)8;
        a0[242] = (byte)8;
        a0[243] = (byte)8;
        a0[244] = (byte)8;
        a0[245] = (byte)8;
        a0[246] = (byte)8;
        a0[247] = (byte)8;
        a0[248] = (byte)8;
        a0[249] = (byte)8;
        a0[250] = (byte)8;
        a0[251] = (byte)8;
        a0[252] = (byte)8;
        a0[253] = (byte)8;
        a0[254] = (byte)8;
        a0[255] = (byte)8;
        bitLengths = a0;
    }
}
