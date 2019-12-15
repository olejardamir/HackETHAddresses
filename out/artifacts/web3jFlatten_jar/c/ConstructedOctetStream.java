class ConstructedOctetStream extends java.io.InputStream {
    final private ASN1StreamParser _parser;
    private boolean _first;
    private java.io.InputStream _currentStream;
    
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
    ConstructedOctetStream(ASN1StreamParser arg) {/*error*/throw null;}
    
    
    // Traceback (most recent call last):
    //   File "/home/cocka/Krakatau/Krakatau/java/javaclass.py", line 37, in _getMethod
    //     graph = cb(method) if method.code is not None else None
    //   File "decompile.py", line 48, in makeGraph
    //     v = verifyBytecode(m.code)
    //   File "/home/cocka/Krakatau/Krakatau/verifier/inference_verifier.py", line 477, in verifyBytecode
    //     iNodes = [InstructionNode(code, offset_rmap, offsets, key) for key in offsets[:-1]]
    //   File "/home/cocka/Krakatau/Krakatau/verifier/inference_verifier.py", line 299, in __init__
    //     self._precomputeValues()
    //   File "/home/cocka/Krakatau/Krakatau/verifier/inference_verifier.py", line 318, in _precomputeValues
    //     result = self._removeInterface(result)
    //   File "/home/cocka/Krakatau/Krakatau/verifier/inference_verifier.py", line 302, in _removeInterface
    //     if vt.tag == '.obj' and vt.extra is not None and self.env.isInterface(vt.extra, forceCheck=True):
    //   File "/home/cocka/Krakatau/Krakatau/environment.py", line 56, in isInterface
    //     raise e
    // ClassLoaderError: 
    // ClassNotFoundException: ASN1OctetStringParser
    public int read(byte[] arg, int arg0, int arg1) {/*error*/throw null;}
    
    
    // Traceback (most recent call last):
    //   File "/home/cocka/Krakatau/Krakatau/java/javaclass.py", line 37, in _getMethod
    //     graph = cb(method) if method.code is not None else None
    //   File "decompile.py", line 48, in makeGraph
    //     v = verifyBytecode(m.code)
    //   File "/home/cocka/Krakatau/Krakatau/verifier/inference_verifier.py", line 477, in verifyBytecode
    //     iNodes = [InstructionNode(code, offset_rmap, offsets, key) for key in offsets[:-1]]
    //   File "/home/cocka/Krakatau/Krakatau/verifier/inference_verifier.py", line 299, in __init__
    //     self._precomputeValues()
    //   File "/home/cocka/Krakatau/Krakatau/verifier/inference_verifier.py", line 318, in _precomputeValues
    //     result = self._removeInterface(result)
    //   File "/home/cocka/Krakatau/Krakatau/verifier/inference_verifier.py", line 302, in _removeInterface
    //     if vt.tag == '.obj' and vt.extra is not None and self.env.isInterface(vt.extra, forceCheck=True):
    //   File "/home/cocka/Krakatau/Krakatau/environment.py", line 56, in isInterface
    //     raise e
    // ClassLoaderError: 
    // ClassNotFoundException: ASN1OctetStringParser
    public int read() {/*error*/throw null;}
}
