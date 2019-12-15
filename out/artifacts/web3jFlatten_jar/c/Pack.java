abstract class Pack {
    Pack() {
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
    public static void intToBigEndian(int arg, byte[] arg0, int arg1) {/*error*/throw null;}
    
    
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
    private static int littleEndianToInt(byte[] arg, int arg0) {/*error*/throw null;}
    
    
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
    private static void intToLittleEndian(int arg, byte[] arg0, int arg1) {/*error*/throw null;}
    
    
    public static long littleEndianToLong(byte[] a, int i) {
        int i0 = Pack.littleEndianToInt(a, i);
        return ((long)Pack.littleEndianToInt(a, i + 4) & 4294967295L) << 32 | (long)i0 & 4294967295L;
    }
    
    private static void longToLittleEndian(long j, byte[] a, int i) {
        Pack.intToLittleEndian((int)(j & 4294967295L), a, i);
        Pack.intToLittleEndian((int)(j >>> 32), a, i + 4);
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
    public static void longToLittleEndian(long[] arg, int arg0, int arg1, byte[] arg2, int arg3) {/*error*/throw null;}
}
