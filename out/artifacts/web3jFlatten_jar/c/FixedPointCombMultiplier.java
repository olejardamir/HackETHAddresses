public class FixedPointCombMultiplier extends AbstractECMultiplier {
    public FixedPointCombMultiplier() {
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
    protected ECPoint multiplyPositive(ECPoint arg, java.math.BigInteger arg0) {/*error*/throw null;}
    
    
    public ECPoint multiply(ECPoint a, java.math.BigInteger a0) {
        return ((AbstractECMultiplier)this).multiply(a, a0);
    }
}
