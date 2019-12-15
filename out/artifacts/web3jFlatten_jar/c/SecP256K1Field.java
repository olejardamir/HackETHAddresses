class SecP256K1Field {
    final static int[] P;
    final private static int[] PExt;
    final private static int[] PExtInv;
    final private static int P7 = -1;
    final private static int PExt15 = -1;
    final private static int PInv33 = 977;
    
    SecP256K1Field() {
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
    public static void add(int[] arg, int[] arg0, int[] arg1) {/*error*/throw null;}
    
    
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
    public static int[] fromBigInteger(java.math.BigInteger arg) {/*error*/throw null;}
    
    
    public static void multiply(int[] a, int[] a0, int[] a1) {
        int[] a2 = Nat256.createExt();
        Nat256.mul(a, a0, a2);
        SecP256K1Field.reduce(a2, a1);
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
    public static void multiplyAddToExt(int[] arg, int[] arg0, int[] arg1) {/*error*/throw null;}
    
    
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
    public static void negate(int[] arg, int[] arg0) {/*error*/throw null;}
    
    
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
    public static void reduce(int[] arg, int[] arg0) {/*error*/throw null;}
    
    
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
    public static void reduce32(int arg, int[] arg0) {/*error*/throw null;}
    
    
    public static void square(int[] a, int[] a0) {
        int[] a1 = Nat256.createExt();
        Nat256.square(a, a1);
        SecP256K1Field.reduce(a1, a0);
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
    public static void squareN(int[] arg, int arg0, int[] arg1) {/*error*/throw null;}
    
    
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
    public static void subtract(int[] arg, int[] arg0, int[] arg1) {/*error*/throw null;}
    
    
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
    public static void twice(int[] arg, int[] arg0) {/*error*/throw null;}
    
    
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
