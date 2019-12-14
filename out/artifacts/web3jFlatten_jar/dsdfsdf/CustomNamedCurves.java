class CustomNamedCurves {
    final private static X9ECParametersHolder secp256k1;
    final private static java.util.Hashtable nameToCurve;
    final private static java.util.Hashtable nameToOID;
    final private static java.util.Hashtable oidToCurve;
    final private static java.util.Hashtable oidToName;
    final private static java.util.Vector names;
    
    CustomNamedCurves() {
    }
    
    private static ECCurve configureCurveGLV(ECCurve a) {
        return a.configure().setEndomorphism().create();
    }
    
    private static void defineCurveWithOID(String s) {
        names.addElement((Object)s);
        oidToName.put((Object)SECObjectIdentifiers.secp256k1, (Object)s);
        oidToCurve.put((Object)SECObjectIdentifiers.secp256k1, (Object)secp256k1);
        String s0 = Strings.toLowerCase(s);
        nameToOID.put((Object)s0, (Object)SECObjectIdentifiers.secp256k1);
        nameToCurve.put((Object)s0, (Object)secp256k1);
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
    // ClassNotFoundException: java/lang/ClassCastException
    public static X9ECParameters getByName() {/*error*/throw null;}
    
    
    static ECCurve access$000(ECCurve a) {
        return CustomNamedCurves.configureCurveGLV(a);
    }
    
    static {
        secp256k1 = new CustomNamedCurves$1();
        nameToCurve = new java.util.Hashtable();
        nameToOID = new java.util.Hashtable();
        oidToCurve = new java.util.Hashtable();
        oidToName = new java.util.Hashtable();
        names = new java.util.Vector();
        CustomNamedCurves.defineCurveWithOID((String)None);
    }
}
