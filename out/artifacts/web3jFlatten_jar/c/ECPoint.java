abstract public class ECPoint {
    final private static ECFieldElement[] EMPTY_ZS;
    final ECCurve curve;
    final ECFieldElement x;
    final ECFieldElement y;
    final ECFieldElement[] zs;
    boolean withCompression;
    java.util.Hashtable preCompTable;
    final static boolean $assertionsDisabled;
    
    // Traceback (most recent call last):
    //   File "/home/cocka/Krakatau/Krakatau/java/javaclass.py", line 37, in _getMethod
    //     graph = cb(method) if method.code is not None else None
    //   File "decompile.py", line 63, in makeGraph
    //     s.abstractInterpert()
    //   File "/home/cocka/Krakatau/Krakatau/ssa/graph.py", line 316, in abstractInterpert
    //     block.jump = block.jump.constrainJumps(*inputs)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/ssa_jumps/onexception.py", line 58, in constrainJumps
    //     self.cs.newMask(mask)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/exceptionset.py", line 25, in newMask
    //     self.sets[k] &= mask
    //   File "/home/cocka/Krakatau/Krakatau/ssa/exceptionset.py", line 102, in __and__
    //     new = self - (self - other)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/exceptionset.py", line 89, in __sub__
    //     pairs = itertools.chain(*[ExceptionSet.diffPair(subtest, pair1, pair2) for pair1 in pairs])
    //   File "/home/cocka/Krakatau/Krakatau/ssa/exceptionset.py", line 118, in diffPair
    //     if subtest(t1,t2): # t2 >= t1
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
    private static ECFieldElement[] getInitialZCoords(ECCurve arg) {/*error*/throw null;}
    
    
    ECPoint(ECCurve a, ECFieldElement a0, ECFieldElement a1) {
        this(a, a0, a1, ECPoint.getInitialZCoords(a));
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
    ECPoint(ECCurve arg, ECFieldElement arg0, ECFieldElement arg1, ECFieldElement[] arg2) {/*error*/throw null;}
    
    
    abstract protected boolean satisfiesCurveEquation();
    
    
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
    // ClassNotFoundException: java/lang/Throwable
    public ECCurve getCurve() {/*error*/throw null;}
    
    
    // Traceback (most recent call last):
    //   File "/home/cocka/Krakatau/Krakatau/java/javaclass.py", line 37, in _getMethod
    //     graph = cb(method) if method.code is not None else None
    //   File "decompile.py", line 63, in makeGraph
    //     s.abstractInterpert()
    //   File "/home/cocka/Krakatau/Krakatau/ssa/graph.py", line 316, in abstractInterpert
    //     block.jump = block.jump.constrainJumps(*inputs)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/ssa_jumps/onexception.py", line 58, in constrainJumps
    //     self.cs.newMask(mask)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/exceptionset.py", line 25, in newMask
    //     self.sets[k] &= mask
    //   File "/home/cocka/Krakatau/Krakatau/ssa/exceptionset.py", line 102, in __and__
    //     new = self - (self - other)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/exceptionset.py", line 89, in __sub__
    //     pairs = itertools.chain(*[ExceptionSet.diffPair(subtest, pair1, pair2) for pair1 in pairs])
    //   File "/home/cocka/Krakatau/Krakatau/ssa/exceptionset.py", line 118, in diffPair
    //     if subtest(t1,t2): # t2 >= t1
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
    int getCurveCoordinateSystem() {/*error*/throw null;}
    
    
    ECFieldElement getAffineYCoord() {
        this.checkNormalized();
        return this.getYCoord();
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
    // ClassNotFoundException: java/lang/Throwable
    public ECFieldElement getXCoord() {/*error*/throw null;}
    
    
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
    // ClassNotFoundException: java/lang/Throwable
    public ECFieldElement getYCoord() {/*error*/throw null;}
    
    
    // Traceback (most recent call last):
    //   File "/home/cocka/Krakatau/Krakatau/java/javaclass.py", line 37, in _getMethod
    //     graph = cb(method) if method.code is not None else None
    //   File "decompile.py", line 63, in makeGraph
    //     s.abstractInterpert()
    //   File "/home/cocka/Krakatau/Krakatau/ssa/graph.py", line 316, in abstractInterpert
    //     block.jump = block.jump.constrainJumps(*inputs)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/ssa_jumps/onexception.py", line 58, in constrainJumps
    //     self.cs.newMask(mask)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/exceptionset.py", line 25, in newMask
    //     self.sets[k] &= mask
    //   File "/home/cocka/Krakatau/Krakatau/ssa/exceptionset.py", line 102, in __and__
    //     new = self - (self - other)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/exceptionset.py", line 89, in __sub__
    //     pairs = itertools.chain(*[ExceptionSet.diffPair(subtest, pair1, pair2) for pair1 in pairs])
    //   File "/home/cocka/Krakatau/Krakatau/ssa/exceptionset.py", line 118, in diffPair
    //     if subtest(t1,t2): # t2 >= t1
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
    public ECFieldElement getZCoord(int arg) {/*error*/throw null;}
    
    
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
    // ClassNotFoundException: java/lang/Throwable
    final public ECFieldElement getRawXCoord() {/*error*/throw null;}
    
    
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
    // ClassNotFoundException: java/lang/Throwable
    final public ECFieldElement getRawYCoord() {/*error*/throw null;}
    
    
    // Traceback (most recent call last):
    //   File "/home/cocka/Krakatau/Krakatau/java/javaclass.py", line 37, in _getMethod
    //     graph = cb(method) if method.code is not None else None
    //   File "decompile.py", line 63, in makeGraph
    //     s.abstractInterpert()
    //   File "/home/cocka/Krakatau/Krakatau/ssa/graph.py", line 316, in abstractInterpert
    //     block.jump = block.jump.constrainJumps(*inputs)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/ssa_jumps/onexception.py", line 58, in constrainJumps
    //     self.cs.newMask(mask)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/exceptionset.py", line 25, in newMask
    //     self.sets[k] &= mask
    //   File "/home/cocka/Krakatau/Krakatau/ssa/exceptionset.py", line 102, in __and__
    //     new = self - (self - other)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/exceptionset.py", line 89, in __sub__
    //     pairs = itertools.chain(*[ExceptionSet.diffPair(subtest, pair1, pair2) for pair1 in pairs])
    //   File "/home/cocka/Krakatau/Krakatau/ssa/exceptionset.py", line 118, in diffPair
    //     if subtest(t1,t2): # t2 >= t1
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
    private void checkNormalized() {/*error*/throw null;}
    
    
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
    public boolean isNormalized() {/*error*/throw null;}
    
    
    // Traceback (most recent call last):
    //   File "/home/cocka/Krakatau/Krakatau/java/javaclass.py", line 37, in _getMethod
    //     graph = cb(method) if method.code is not None else None
    //   File "decompile.py", line 63, in makeGraph
    //     s.abstractInterpert()
    //   File "/home/cocka/Krakatau/Krakatau/ssa/graph.py", line 316, in abstractInterpert
    //     block.jump = block.jump.constrainJumps(*inputs)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/ssa_jumps/onexception.py", line 58, in constrainJumps
    //     self.cs.newMask(mask)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/exceptionset.py", line 25, in newMask
    //     self.sets[k] &= mask
    //   File "/home/cocka/Krakatau/Krakatau/ssa/exceptionset.py", line 102, in __and__
    //     new = self - (self - other)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/exceptionset.py", line 89, in __sub__
    //     pairs = itertools.chain(*[ExceptionSet.diffPair(subtest, pair1, pair2) for pair1 in pairs])
    //   File "/home/cocka/Krakatau/Krakatau/ssa/exceptionset.py", line 118, in diffPair
    //     if subtest(t1,t2): # t2 >= t1
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
    public ECPoint normalize() {/*error*/throw null;}
    
    
    ECPoint normalize(ECFieldElement a) {
        switch(this.getCurveCoordinateSystem()) {
            case 2: case 3: case 4: {
                ECFieldElement a0 = a.square();
                return this.createScaledPoint(a0, a0.multiply(a));
            }
            case 1: case 6: {
                return this.createScaledPoint(a, a);
            }
            default: {
                throw new IllegalStateException((String)None);
            }
        }
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
    private ECPoint createScaledPoint(ECFieldElement arg, ECFieldElement arg0) {/*error*/throw null;}
    
    
    // Traceback (most recent call last):
    //   File "/home/cocka/Krakatau/Krakatau/java/javaclass.py", line 37, in _getMethod
    //     graph = cb(method) if method.code is not None else None
    //   File "decompile.py", line 63, in makeGraph
    //     s.abstractInterpert()
    //   File "/home/cocka/Krakatau/Krakatau/ssa/graph.py", line 316, in abstractInterpert
    //     block.jump = block.jump.constrainJumps(*inputs)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/ssa_jumps/onexception.py", line 58, in constrainJumps
    //     self.cs.newMask(mask)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/exceptionset.py", line 25, in newMask
    //     self.sets[k] &= mask
    //   File "/home/cocka/Krakatau/Krakatau/ssa/exceptionset.py", line 102, in __and__
    //     new = self - (self - other)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/exceptionset.py", line 89, in __sub__
    //     pairs = itertools.chain(*[ExceptionSet.diffPair(subtest, pair1, pair2) for pair1 in pairs])
    //   File "/home/cocka/Krakatau/Krakatau/ssa/exceptionset.py", line 118, in diffPair
    //     if subtest(t1,t2): # t2 >= t1
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
    public boolean isInfinity() {/*error*/throw null;}
    
    
    // Traceback (most recent call last):
    //   File "/home/cocka/Krakatau/Krakatau/java/javaclass.py", line 37, in _getMethod
    //     graph = cb(method) if method.code is not None else None
    //   File "decompile.py", line 63, in makeGraph
    //     s.abstractInterpert()
    //   File "/home/cocka/Krakatau/Krakatau/ssa/graph.py", line 316, in abstractInterpert
    //     block.jump = block.jump.constrainJumps(*inputs)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/ssa_jumps/onexception.py", line 58, in constrainJumps
    //     self.cs.newMask(mask)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/exceptionset.py", line 25, in newMask
    //     self.sets[k] &= mask
    //   File "/home/cocka/Krakatau/Krakatau/ssa/exceptionset.py", line 102, in __and__
    //     new = self - (self - other)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/exceptionset.py", line 89, in __sub__
    //     pairs = itertools.chain(*[ExceptionSet.diffPair(subtest, pair1, pair2) for pair1 in pairs])
    //   File "/home/cocka/Krakatau/Krakatau/ssa/exceptionset.py", line 118, in diffPair
    //     if subtest(t1,t2): # t2 >= t1
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
    public boolean isValid() {/*error*/throw null;}
    
    
    boolean isValidPartial() {
        return this.implIsValid(false, false);
    }
    
    // Traceback (most recent call last):
    //   File "/home/cocka/Krakatau/Krakatau/java/javaclass.py", line 37, in _getMethod
    //     graph = cb(method) if method.code is not None else None
    //   File "decompile.py", line 63, in makeGraph
    //     s.abstractInterpert()
    //   File "/home/cocka/Krakatau/Krakatau/ssa/graph.py", line 316, in abstractInterpert
    //     block.jump = block.jump.constrainJumps(*inputs)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/ssa_jumps/onexception.py", line 58, in constrainJumps
    //     self.cs.newMask(mask)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/exceptionset.py", line 25, in newMask
    //     self.sets[k] &= mask
    //   File "/home/cocka/Krakatau/Krakatau/ssa/exceptionset.py", line 102, in __and__
    //     new = self - (self - other)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/exceptionset.py", line 89, in __sub__
    //     pairs = itertools.chain(*[ExceptionSet.diffPair(subtest, pair1, pair2) for pair1 in pairs])
    //   File "/home/cocka/Krakatau/Krakatau/ssa/exceptionset.py", line 118, in diffPair
    //     if subtest(t1,t2): # t2 >= t1
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
    boolean implIsValid(boolean arg, boolean arg0) {/*error*/throw null;}
    
    
    // Traceback (most recent call last):
    //   File "/home/cocka/Krakatau/Krakatau/java/javaclass.py", line 37, in _getMethod
    //     graph = cb(method) if method.code is not None else None
    //   File "decompile.py", line 63, in makeGraph
    //     s.abstractInterpert()
    //   File "/home/cocka/Krakatau/Krakatau/ssa/graph.py", line 316, in abstractInterpert
    //     block.jump = block.jump.constrainJumps(*inputs)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/ssa_jumps/onexception.py", line 58, in constrainJumps
    //     self.cs.newMask(mask)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/exceptionset.py", line 25, in newMask
    //     self.sets[k] &= mask
    //   File "/home/cocka/Krakatau/Krakatau/ssa/exceptionset.py", line 102, in __and__
    //     new = self - (self - other)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/exceptionset.py", line 89, in __sub__
    //     pairs = itertools.chain(*[ExceptionSet.diffPair(subtest, pair1, pair2) for pair1 in pairs])
    //   File "/home/cocka/Krakatau/Krakatau/ssa/exceptionset.py", line 118, in diffPair
    //     if subtest(t1,t2): # t2 >= t1
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
    public boolean equals(ECPoint arg) {/*error*/throw null;}
    
    
    // Traceback (most recent call last):
    //   File "/home/cocka/Krakatau/Krakatau/java/javaclass.py", line 37, in _getMethod
    //     graph = cb(method) if method.code is not None else None
    //   File "decompile.py", line 49, in makeGraph
    //     s = Krakatau.ssa.ssaFromVerified(m.code, v, opts)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/graph.py", line 717, in ssaFromVerified
    //     data = blockmaker.BlockMaker(parent, iNodes, inputTypes, returnTypes, code.except_raw, opts=opts)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/blockmaker.py", line 145, in __init__
    //     self._appendInstr(node, vals, outslot_norm)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/blockmaker.py", line 273, in _appendInstr
    //     self._addOnException(block, fallthrough, outslot_norm)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/blockmaker.py", line 244, in _addOnException
    //     block.jump = ssa_jumps.OnException(parent, ephi.outException, block.chpairs, fallthrough)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/ssa_jumps/onexception.py", line 12, in __init__
    //     self.cs = CatchSetManager.new(parent.env, chpairs)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/exceptionset.py", line 19, in new
    //     sets[handler] = old | (new - sofar)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/exceptionset.py", line 89, in __sub__
    //     pairs = itertools.chain(*[ExceptionSet.diffPair(subtest, pair1, pair2) for pair1 in pairs])
    //   File "/home/cocka/Krakatau/Krakatau/ssa/exceptionset.py", line 118, in diffPair
    //     if subtest(t1,t2): # t2 >= t1
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
    public boolean equals(Object arg) {/*error*/throw null;}
    
    
    // Traceback (most recent call last):
    //   File "/home/cocka/Krakatau/Krakatau/java/javaclass.py", line 37, in _getMethod
    //     graph = cb(method) if method.code is not None else None
    //   File "decompile.py", line 63, in makeGraph
    //     s.abstractInterpert()
    //   File "/home/cocka/Krakatau/Krakatau/ssa/graph.py", line 316, in abstractInterpert
    //     block.jump = block.jump.constrainJumps(*inputs)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/ssa_jumps/onexception.py", line 58, in constrainJumps
    //     self.cs.newMask(mask)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/exceptionset.py", line 25, in newMask
    //     self.sets[k] &= mask
    //   File "/home/cocka/Krakatau/Krakatau/ssa/exceptionset.py", line 102, in __and__
    //     new = self - (self - other)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/exceptionset.py", line 89, in __sub__
    //     pairs = itertools.chain(*[ExceptionSet.diffPair(subtest, pair1, pair2) for pair1 in pairs])
    //   File "/home/cocka/Krakatau/Krakatau/ssa/exceptionset.py", line 118, in diffPair
    //     if subtest(t1,t2): # t2 >= t1
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
    //   File "/home/cocka/Krakatau/Krakatau/ssa/graph.py", line 316, in abstractInterpert
    //     block.jump = block.jump.constrainJumps(*inputs)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/ssa_jumps/onexception.py", line 58, in constrainJumps
    //     self.cs.newMask(mask)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/exceptionset.py", line 25, in newMask
    //     self.sets[k] &= mask
    //   File "/home/cocka/Krakatau/Krakatau/ssa/exceptionset.py", line 102, in __and__
    //     new = self - (self - other)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/exceptionset.py", line 89, in __sub__
    //     pairs = itertools.chain(*[ExceptionSet.diffPair(subtest, pair1, pair2) for pair1 in pairs])
    //   File "/home/cocka/Krakatau/Krakatau/ssa/exceptionset.py", line 118, in diffPair
    //     if subtest(t1,t2): # t2 >= t1
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
    
    
    // Traceback (most recent call last):
    //   File "/home/cocka/Krakatau/Krakatau/java/javaclass.py", line 37, in _getMethod
    //     graph = cb(method) if method.code is not None else None
    //   File "decompile.py", line 63, in makeGraph
    //     s.abstractInterpert()
    //   File "/home/cocka/Krakatau/Krakatau/ssa/graph.py", line 316, in abstractInterpert
    //     block.jump = block.jump.constrainJumps(*inputs)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/ssa_jumps/onexception.py", line 58, in constrainJumps
    //     self.cs.newMask(mask)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/exceptionset.py", line 25, in newMask
    //     self.sets[k] &= mask
    //   File "/home/cocka/Krakatau/Krakatau/ssa/exceptionset.py", line 102, in __and__
    //     new = self - (self - other)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/exceptionset.py", line 89, in __sub__
    //     pairs = itertools.chain(*[ExceptionSet.diffPair(subtest, pair1, pair2) for pair1 in pairs])
    //   File "/home/cocka/Krakatau/Krakatau/ssa/exceptionset.py", line 118, in diffPair
    //     if subtest(t1,t2): # t2 >= t1
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
    public byte[] getEncoded(boolean arg) {/*error*/throw null;}
    
    
    abstract protected boolean getCompressionYTilde();
    
    
    abstract public ECPoint add(ECPoint arg);
    
    
    abstract public ECPoint negate();
    
    
    abstract public ECPoint subtract(ECPoint arg);
    
    
    // Traceback (most recent call last):
    //   File "/home/cocka/Krakatau/Krakatau/java/javaclass.py", line 37, in _getMethod
    //     graph = cb(method) if method.code is not None else None
    //   File "decompile.py", line 63, in makeGraph
    //     s.abstractInterpert()
    //   File "/home/cocka/Krakatau/Krakatau/ssa/graph.py", line 316, in abstractInterpert
    //     block.jump = block.jump.constrainJumps(*inputs)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/ssa_jumps/onexception.py", line 58, in constrainJumps
    //     self.cs.newMask(mask)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/exceptionset.py", line 25, in newMask
    //     self.sets[k] &= mask
    //   File "/home/cocka/Krakatau/Krakatau/ssa/exceptionset.py", line 102, in __and__
    //     new = self - (self - other)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/exceptionset.py", line 89, in __sub__
    //     pairs = itertools.chain(*[ExceptionSet.diffPair(subtest, pair1, pair2) for pair1 in pairs])
    //   File "/home/cocka/Krakatau/Krakatau/ssa/exceptionset.py", line 118, in diffPair
    //     if subtest(t1,t2): # t2 >= t1
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
    public ECPoint timesPow2(int arg) {/*error*/throw null;}
    
    
    abstract public ECPoint twice();
    
    
    public ECPoint twicePlus(ECPoint a) {
        return this.twice().add(a);
    }
    
    // Traceback (most recent call last):
    //   File "/home/cocka/Krakatau/Krakatau/java/javaclass.py", line 37, in _getMethod
    //     graph = cb(method) if method.code is not None else None
    //   File "decompile.py", line 63, in makeGraph
    //     s.abstractInterpert()
    //   File "/home/cocka/Krakatau/Krakatau/ssa/graph.py", line 316, in abstractInterpert
    //     block.jump = block.jump.constrainJumps(*inputs)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/ssa_jumps/onexception.py", line 58, in constrainJumps
    //     self.cs.newMask(mask)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/exceptionset.py", line 25, in newMask
    //     self.sets[k] &= mask
    //   File "/home/cocka/Krakatau/Krakatau/ssa/exceptionset.py", line 102, in __and__
    //     new = self - (self - other)
    //   File "/home/cocka/Krakatau/Krakatau/ssa/exceptionset.py", line 89, in __sub__
    //     pairs = itertools.chain(*[ExceptionSet.diffPair(subtest, pair1, pair2) for pair1 in pairs])
    //   File "/home/cocka/Krakatau/Krakatau/ssa/exceptionset.py", line 118, in diffPair
    //     if subtest(t1,t2): # t2 >= t1
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
    static {/*error*/throw null;}
}
