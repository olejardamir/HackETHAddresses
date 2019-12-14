public class Curve25519Point extends ECPoint$AbstractFp {
    public Curve25519Point(ECCurve a, ECFieldElement a0, ECFieldElement a1) {
        this(a, a0, a1, false);
    }
    
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
    public Curve25519Point(ECCurve arg, ECFieldElement arg0, ECFieldElement arg1, boolean arg2) {/*error*/throw null;}
    
    
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
    Curve25519Point(ECCurve arg, ECFieldElement arg0, ECFieldElement arg1, ECFieldElement[] arg2, boolean arg3) {/*error*/throw null;}
    
    
    public ECFieldElement getZCoord(int i) {
        if (i == 1) {
            ECFieldElement a = this.getJacobianModifiedW();
            return a;
        }
        return ((ECPoint$AbstractFp)this).getZCoord(i);
    }
    
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
    public ECPoint add(ECPoint arg) {/*error*/throw null;}
    
    
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
    public ECPoint twice() {/*error*/throw null;}
    
    
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
    public ECPoint twicePlus(ECPoint arg) {/*error*/throw null;}
    
    
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
    public ECPoint threeTimes() {/*error*/throw null;}
    
    
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
    public ECPoint negate() {/*error*/throw null;}
    
    
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
    private Curve25519FieldElement calculateJacobianModifiedW(Curve25519FieldElement arg, int[] arg0) {/*error*/throw null;}
    
    
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
    private Curve25519FieldElement getJacobianModifiedW() {/*error*/throw null;}
    
    
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
    private Curve25519Point twiceJacobianModified(boolean arg) {/*error*/throw null;}
}
