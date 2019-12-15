public class ASN1ObjectIdentifier extends ASN1Primitive {
    final private String identifier;
    private byte[] body;
    
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
    public ASN1ObjectIdentifier(String arg) {/*error*/throw null;}
    
    
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
    private ASN1ObjectIdentifier(ASN1ObjectIdentifier arg, String arg0) {/*error*/throw null;}
    
    
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
    private String getId() {/*error*/throw null;}
    
    
    public ASN1ObjectIdentifier branch(String s) {
        return new ASN1ObjectIdentifier(this, s);
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
    private void writeField(java.io.ByteArrayOutputStream arg, long arg0) {/*error*/throw null;}
    
    
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
    private void writeField(java.io.ByteArrayOutputStream arg, java.math.BigInteger arg0) {/*error*/throw null;}
    
    
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
    private void doOutput(java.io.ByteArrayOutputStream arg) {/*error*/throw null;}
    
    
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
    private synchronized byte[] getBody() {/*error*/throw null;}
    
    
    int encodedLength() {
        int i = this.getBody().length;
        return 1 + StreamUtil.calculateBodyLength(i) + i;
    }
    
    void encode(ASN1OutputStream a) {
        byte[] a0 = this.getBody();
        a.write(6);
        a.writeLength(a0.length);
        a.write(a0);
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
    boolean asn1Equals(ASN1Primitive arg) {/*error*/throw null;}
    
    
    public String toString() {
        return this.getId();
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
    private static boolean isValidBranchID(String arg, int arg0) {/*error*/throw null;}
    
    
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
    private static boolean isValidIdentifier(String arg) {/*error*/throw null;}
}
