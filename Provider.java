
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

import static java.util.Locale.ENGLISH;


public abstract class Provider extends Properties {


    static final long serialVersionUID = -4298000515446427739L;

    private static final sun.security.util.Debug debug =
            sun.security.util.Debug.getInstance
                    ("provider", "Provider");
    private final static String ALIAS_PREFIX = "Alg.Alias.";
    private final static String ALIAS_PREFIX_LOWER = "alg.alias.";
    private final static int ALIAS_LENGTH = ALIAS_PREFIX.length();
    private static final Map<String, EngineDescription> knownEngines;
    private static volatile ServiceKey previousKey =
            new ServiceKey("", "", false);

    static {
        knownEngines = new HashMap<String, EngineDescription>();

        addEngine("AlgorithmParameterGenerator", false, null);
        addEngine("AlgorithmParameters", false, null);
        addEngine("KeyFactory", false, null);
        addEngine("KeyPairGenerator", false, null);
        addEngine("KeyStore", false, null);
        addEngine("MessageDigest", false, null);
        addEngine("SecureRandom", false, null);
        addEngine("Signature", true, null);
        addEngine("CertificateFactory", false, null);
        addEngine("CertPathBuilder", false, null);
        addEngine("CertPathValidator", false, null);
        addEngine("CertStore", false,
                "java.security.cert.CertStoreParameters");

        addEngine("Cipher", true, null);
        addEngine("ExemptionMechanism", false, null);
        addEngine("Mac", true, null);
        addEngine("KeyAgreement", true, null);
        addEngine("KeyGenerator", false, null);
        addEngine("SecretKeyFactory", false, null);

        addEngine("KeyManagerFactory", false, null);
        addEngine("SSLContext", false, null);
        addEngine("TrustManagerFactory", false, null);

        addEngine("GssApiMechanism", false, null);

        addEngine("SaslClientFactory", false, null);
        addEngine("SaslServerFactory", false, null);

        addEngine("Policy", false,
                "java.security.Policy$Parameters");

        addEngine("Configuration", false,
                "javax.security.auth.login.Configuration$Parameters");

        addEngine("XMLSignatureFactory", false, null);
        addEngine("KeyInfoFactory", false, null);
        addEngine("TransformService", false, null);

        addEngine("TerminalFactory", false,
                "java.lang.Object");
    }

    private String name;
    private String info;
    private double version;
    private transient Set<Map.Entry<Object, Object>> entrySet = null;
    private transient int entrySetCallCount = 0;
    private transient boolean initialized;
    private transient boolean legacyChanged;
    private transient boolean servicesChanged;
    private transient Map<String, String> legacyStrings;
    private transient Map<ServiceKey, Service> serviceMap;
    private transient Map<ServiceKey, Service> legacyMap;
    private transient Set<Service> serviceSet;


    protected Provider(String name, double version, String info) {
        this.name = name;
        this.version = version;
        this.info = info;
        putId();
        initialized = true;
    }

    private static void addEngine(String name, boolean sp, String paramName) {
        EngineDescription ed = new EngineDescription(name, sp, paramName);

        knownEngines.put(name.toLowerCase(ENGLISH), ed);
        knownEngines.put(name, ed);
    }

    private static String getEngineName(String s) {

        EngineDescription e = knownEngines.get(s);
        if (e == null) {
            e = knownEngines.get(s.toLowerCase(ENGLISH));
        }
        return (e == null) ? s : e.name;
    }

    public String getName() {
        return name;
    }

    public double getVersion() {
        return version;
    }

    public String getInfo() {
        return info;
    }

    public String toString() {
        return name + " version " + version;
    }

    @Override
    public synchronized void clear() {
        check("clearProviderProperties." + name);
        if (debug != null) {
            debug.println("Remove " + name + " provider properties");
        }
        implClear();
    }

    @Override
    public synchronized void load(InputStream inStream) throws IOException {
        check("putProviderProperty." + name);
        if (debug != null) {
            debug.println("Load " + name + " provider properties");
        }
        Properties tempProperties = new Properties();
        tempProperties.load(inStream);
        implPutAll(tempProperties);
    }

    @Override
    public synchronized void putAll(Map<?, ?> t) {
        check("putProviderProperty." + name);
        if (debug != null) {
            debug.println("Put all " + name + " provider properties");
        }
        implPutAll(t);
    }

    @Override
    public synchronized Set<Map.Entry<Object, Object>> entrySet() {
        checkInitialized();
        if (entrySet == null) {
            if (entrySetCallCount++ == 0)
                entrySet = Collections.unmodifiableMap(this).entrySet();
            else
                return super.entrySet();
        }


        if (entrySetCallCount != 2)
            throw new RuntimeException("Internal error.");

        return entrySet;
    }

    @Override
    public Set<Object> keySet() {
        checkInitialized();
        return Collections.unmodifiableSet(super.keySet());
    }

    @Override
    public Collection<Object> values() {
        checkInitialized();
        return Collections.unmodifiableCollection(super.values());
    }

    @Override
    public synchronized Object put(Object key, Object value) {
        check("putProviderProperty." + name);
        if (debug != null) {
            debug.println("Set " + name + " provider property [" +
                    key + "/" + value + "]");
        }
        return implPut(key, value);
    }

    @Override
    public synchronized Object putIfAbsent(Object key, Object value) {
        check("putProviderProperty." + name);
        if (debug != null) {
            debug.println("Set " + name + " provider property [" +
                    key + "/" + value + "]");
        }
        return implPutIfAbsent(key, value);
    }

    @Override
    public synchronized Object remove(Object key) {
        check("removeProviderProperty." + name);
        if (debug != null) {
            debug.println("Remove " + name + " provider property " + key);
        }
        return implRemove(key);
    }

    @Override
    public synchronized boolean remove(Object key, Object value) {
        check("removeProviderProperty." + name);
        if (debug != null) {
            debug.println("Remove " + name + " provider property " + key);
        }
        return implRemove(key, value);
    }

    @Override
    public synchronized boolean replace(Object key, Object oldValue,
                                        Object newValue) {
        check("putProviderProperty." + name);

        if (debug != null) {
            debug.println("Replace " + name + " provider property " + key);
        }
        return implReplace(key, oldValue, newValue);
    }

    @Override
    public synchronized Object replace(Object key, Object value) {
        check("putProviderProperty." + name);

        if (debug != null) {
            debug.println("Replace " + name + " provider property " + key);
        }
        return implReplace(key, value);
    }

    @Override
    public synchronized void replaceAll(BiFunction<? super Object, ? super Object, ? extends Object> function) {
        check("putProviderProperty." + name);

        if (debug != null) {
            debug.println("ReplaceAll " + name + " provider property ");
        }
        implReplaceAll(function);
    }

    @Override
    public synchronized Object compute(Object key,
                                       BiFunction<? super Object, ? super Object, ? extends Object> remappingFunction) {
        check("putProviderProperty." + name);
        check("removeProviderProperty" + name);

        if (debug != null) {
            debug.println("Compute " + name + " provider property " + key);
        }
        return implCompute(key, remappingFunction);
    }

    @Override
    public synchronized Object computeIfAbsent(Object key, Function<? super Object, ? extends Object> mappingFunction) {
        check("putProviderProperty." + name);
        check("removeProviderProperty" + name);

        if (debug != null) {
            debug.println("ComputeIfAbsent " + name + " provider property " +
                    key);
        }
        return implComputeIfAbsent(key, mappingFunction);
    }

    @Override
    public synchronized Object computeIfPresent(Object key, BiFunction<? super Object, ? super Object, ? extends Object> remappingFunction) {
        check("putProviderProperty." + name);
        check("removeProviderProperty" + name);

        if (debug != null) {
            debug.println("ComputeIfPresent " + name + " provider property " +
                    key);
        }
        return implComputeIfPresent(key, remappingFunction);
    }

    @Override
    public synchronized Object merge(Object key, Object value, BiFunction<? super Object, ? super Object, ? extends Object> remappingFunction) {
        check("putProviderProperty." + name);
        check("removeProviderProperty" + name);

        if (debug != null) {
            debug.println("Merge " + name + " provider property " + key);
        }
        return implMerge(key, value, remappingFunction);
    }

    @Override
    public Object get(Object key) {
        checkInitialized();
        return super.get(key);
    }

    @Override
    public synchronized Object getOrDefault(Object key, Object defaultValue) {
        checkInitialized();
        return super.getOrDefault(key, defaultValue);
    }

    @Override
    public synchronized void forEach(BiConsumer<? super Object, ? super Object> action) {
        checkInitialized();
        super.forEach(action);
    }

    @Override
    public Enumeration<Object> keys() {
        checkInitialized();
        return super.keys();
    }

    @Override
    public Enumeration<Object> elements() {
        checkInitialized();
        return super.elements();
    }

    public String getProperty(String key) {
        checkInitialized();
        return super.getProperty(key);
    }

    private void checkInitialized() {
        if (!initialized) {
            throw new IllegalStateException();
        }
    }

    private void check(String directive) {
        checkInitialized();
        SecurityManager security = System.getSecurityManager();
        if (security != null) {
            security.checkSecurityAccess(directive);
        }
    }

    private void putId() {

        super.put("Provider.id name", String.valueOf(name));
        super.put("Provider.id version", String.valueOf(version));
        super.put("Provider.id info", String.valueOf(info));
        super.put("Provider.id className", this.getClass().getName());
    }

    private void readObject(ObjectInputStream in)
            throws IOException, ClassNotFoundException {
        Map<Object, Object> copy = new HashMap<Object, Object>();
        for (Map.Entry<Object, Object> entry : super.entrySet()) {
            copy.put(entry.getKey(), entry.getValue());
        }
        defaults = null;
        in.defaultReadObject();
        implClear();
        initialized = true;
        putAll(copy);
    }

    private boolean checkLegacy(Object key) {
        String keyString = (String) key;
        if (keyString.startsWith("Provider.")) {
            return false;
        }

        legacyChanged = true;
        if (legacyStrings == null) {
            legacyStrings = new LinkedHashMap<String, String>(256);
        }
        return true;
    }

    private void implPutAll(Map<?, ?> t) {
        for (Map.Entry<?, ?> e : t.entrySet()) {
            implPut(e.getKey(), e.getValue());
        }
    }

    private Object implRemove(Object key) {
        if (key instanceof String) {
            if (!checkLegacy(key)) {
                return null;
            }
            legacyStrings.remove(key);
        }
        return super.remove(key);
    }

    private boolean implRemove(Object key, Object value) {
        if (key instanceof String && value instanceof String) {
            if (!checkLegacy(key)) {
                return false;
            }
            legacyStrings.remove(key, value);
        }
        return super.remove(key, value);
    }

    private boolean implReplace(Object key, Object oldValue, Object newValue) {
        if ((key instanceof String) && (oldValue instanceof String) &&
                (newValue instanceof String)) {
            if (!checkLegacy(key)) {
                return false;
            }
            legacyStrings.replace((String) key, (String) oldValue,
                    (String) newValue);
        }
        return super.replace(key, oldValue, newValue);
    }

    private Object implReplace(Object key, Object value) {
        if ((key instanceof String) && (value instanceof String)) {
            if (!checkLegacy(key)) {
                return null;
            }
            legacyStrings.replace((String) key, (String) value);
        }
        return super.replace(key, value);
    }

    private void implReplaceAll(BiFunction<? super Object, ? super Object, ? extends Object> function) {
        legacyChanged = true;
        if (legacyStrings == null) {
            legacyStrings = new LinkedHashMap<String, String>();
        } else {
            legacyStrings.replaceAll((BiFunction<? super String, ? super String, ? extends String>) function);
        }
        super.replaceAll(function);
    }

    private Object implMerge(Object key, Object value, BiFunction<? super Object, ? super Object, ? extends Object> remappingFunction) {
        if ((key instanceof String) && (value instanceof String)) {
            if (!checkLegacy(key)) {
                return null;
            }
            legacyStrings.merge((String) key, (String) value,
                    (BiFunction<? super String, ? super String, ? extends String>) remappingFunction);
        }
        return super.merge(key, value, remappingFunction);
    }

    private Object implCompute(Object key, BiFunction<? super Object, ? super Object, ? extends Object> remappingFunction) {
        if (key instanceof String) {
            if (!checkLegacy(key)) {
                return null;
            }
            legacyStrings.computeIfAbsent((String) key,
                    (Function<? super String, ? extends String>) remappingFunction);
        }
        return super.compute(key, remappingFunction);
    }

    private Object implComputeIfAbsent(Object key, Function<? super Object, ? extends Object> mappingFunction) {
        if (key instanceof String) {
            if (!checkLegacy(key)) {
                return null;
            }
            legacyStrings.computeIfAbsent((String) key,
                    (Function<? super String, ? extends String>) mappingFunction);
        }
        return super.computeIfAbsent(key, mappingFunction);
    }

    private Object implComputeIfPresent(Object key, BiFunction<? super Object, ? super Object, ? extends Object> remappingFunction) {
        if (key instanceof String) {
            if (!checkLegacy(key)) {
                return null;
            }
            legacyStrings.computeIfPresent((String) key,
                    (BiFunction<? super String, ? super String, ? extends String>) remappingFunction);
        }
        return super.computeIfPresent(key, remappingFunction);
    }

    private Object implPut(Object key, Object value) {
        if ((key instanceof String) && (value instanceof String)) {
            if (!checkLegacy(key)) {
                return null;
            }
            legacyStrings.put((String) key, (String) value);
        }
        return super.put(key, value);
    }

    private Object implPutIfAbsent(Object key, Object value) {
        if ((key instanceof String) && (value instanceof String)) {
            if (!checkLegacy(key)) {
                return null;
            }
            legacyStrings.putIfAbsent((String) key, (String) value);
        }
        return super.putIfAbsent(key, value);
    }

    private void implClear() {
        if (legacyStrings != null) {
            legacyStrings.clear();
        }
        if (legacyMap != null) {
            legacyMap.clear();
        }
        if (serviceMap != null) {
            serviceMap.clear();
        }
        legacyChanged = false;
        servicesChanged = false;
        serviceSet = null;
        super.clear();
        putId();
    }

    private void ensureLegacyParsed() {
        if ((legacyChanged == false) || (legacyStrings == null)) {
            return;
        }
        serviceSet = null;
        if (legacyMap == null) {
            legacyMap = new LinkedHashMap<ServiceKey, Service>();
        } else {
            legacyMap.clear();
        }
        for (Map.Entry<String, String> entry : legacyStrings.entrySet()) {
            parseLegacyPut(entry.getKey(), entry.getValue());
        }
        removeInvalidServices(legacyMap);
        legacyChanged = false;
    }

    private void removeInvalidServices(Map<ServiceKey, Service> map) {
        for (Iterator<Map.Entry<ServiceKey, Service>> t =
             map.entrySet().iterator(); t.hasNext(); ) {
            Service s = t.next().getValue();
            if (s.isValid() == false) {
                t.remove();
            }
        }
    }

    private String[] getTypeAndAlgorithm(String key) {
        int i = key.indexOf(".");
        if (i < 1) {
            if (debug != null) {
                debug.println("Ignoring invalid entry in provider "
                        + name + ":" + key);
            }
            return null;
        }
        String type = key.substring(0, i);
        String alg = key.substring(i + 1);
        return new String[]{type, alg};
    }

    private void parseLegacyPut(String name, String value) {
        if (name.toLowerCase(ENGLISH).startsWith(ALIAS_PREFIX_LOWER)) {


            String stdAlg = value;
            String aliasKey = name.substring(ALIAS_LENGTH);
            String[] typeAndAlg = getTypeAndAlgorithm(aliasKey);
            if (typeAndAlg == null) {
                return;
            }
            String type = getEngineName(typeAndAlg[0]);
            String aliasAlg = typeAndAlg[1].intern();
            ServiceKey key = new ServiceKey(type, stdAlg, true);
            Service s = legacyMap.get(key);
            if (s == null) {
                s = new Service(this);
                s.type = type;
                s.algorithm = stdAlg;
                legacyMap.put(key, s);
            }
            legacyMap.put(new ServiceKey(type, aliasAlg, true), s);
            s.addAlias(aliasAlg);
        } else {
            String[] typeAndAlg = getTypeAndAlgorithm(name);
            if (typeAndAlg == null) {
                return;
            }
            int i = typeAndAlg[1].indexOf(' ');
            if (i == -1) {

                String type = getEngineName(typeAndAlg[0]);
                String stdAlg = typeAndAlg[1].intern();
                String className = value;
                ServiceKey key = new ServiceKey(type, stdAlg, true);
                Service s = legacyMap.get(key);
                if (s == null) {
                    s = new Service(this);
                    s.type = type;
                    s.algorithm = stdAlg;
                    legacyMap.put(key, s);
                }
                s.className = className;
            } else {

                String attributeValue = value;
                String type = getEngineName(typeAndAlg[0]);
                String attributeString = typeAndAlg[1];
                String stdAlg = attributeString.substring(0, i).intern();
                String attributeName = attributeString.substring(i + 1);

                while (attributeName.startsWith(" ")) {
                    attributeName = attributeName.substring(1);
                }
                attributeName = attributeName.intern();
                ServiceKey key = new ServiceKey(type, stdAlg, true);
                Service s = legacyMap.get(key);
                if (s == null) {
                    s = new Service(this);
                    s.type = type;
                    s.algorithm = stdAlg;
                    legacyMap.put(key, s);
                }
                s.addAttribute(attributeName, attributeValue);
            }
        }
    }

    public synchronized Service getService(String type, String algorithm) {
        checkInitialized();

        ServiceKey key = previousKey;
        if (key.matches(type, algorithm) == false) {
            key = new ServiceKey(type, algorithm, false);
            previousKey = key;
        }
        if (serviceMap != null) {
            Service service = serviceMap.get(key);
            if (service != null) {
                return service;
            }
        }
        ensureLegacyParsed();
        return (legacyMap != null) ? legacyMap.get(key) : null;
    }

    public synchronized Set<Service> getServices() {
        checkInitialized();
        if (legacyChanged || servicesChanged) {
            serviceSet = null;
        }
        if (serviceSet == null) {
            ensureLegacyParsed();
            Set<Service> set = new LinkedHashSet<>();
            if (serviceMap != null) {
                set.addAll(serviceMap.values());
            }
            if (legacyMap != null) {
                set.addAll(legacyMap.values());
            }
            serviceSet = Collections.unmodifiableSet(set);
            servicesChanged = false;
        }
        return serviceSet;
    }

    protected synchronized void putService(Service s) {
        check("putProviderProperty." + name);
        if (debug != null) {
            debug.println(name + ".putService(): " + s);
        }
        if (s == null) {
            throw new NullPointerException();
        }
        if (s.getProvider() != this) {
            throw new IllegalArgumentException
                    ("service.getProvider() must match this Provider object");
        }
        if (serviceMap == null) {
            serviceMap = new LinkedHashMap<ServiceKey, Service>();
        }
        servicesChanged = true;
        String type = s.getType();
        String algorithm = s.getAlgorithm();
        ServiceKey key = new ServiceKey(type, algorithm, true);

        implRemoveService(serviceMap.get(key));
        serviceMap.put(key, s);
        for (String alias : s.getAliases()) {
            serviceMap.put(new ServiceKey(type, alias, true), s);
        }
        putPropertyStrings(s);
    }

    private void putPropertyStrings(Service s) {
        String type = s.getType();
        String algorithm = s.getAlgorithm();

        super.put(type + "." + algorithm, s.getClassName());
        for (String alias : s.getAliases()) {
            super.put(ALIAS_PREFIX + type + "." + alias, algorithm);
        }
        for (Map.Entry<UString, String> entry : s.attributes.entrySet()) {
            String key = type + "." + algorithm + " " + entry.getKey();
            super.put(key, entry.getValue());
        }
    }

    private void removePropertyStrings(Service s) {
        String type = s.getType();
        String algorithm = s.getAlgorithm();

        super.remove(type + "." + algorithm);
        for (String alias : s.getAliases()) {
            super.remove(ALIAS_PREFIX + type + "." + alias);
        }
        for (Map.Entry<UString, String> entry : s.attributes.entrySet()) {
            String key = type + "." + algorithm + " " + entry.getKey();
            super.remove(key);
        }
    }

    protected synchronized void removeService(Service s) {
        check("removeProviderProperty." + name);
        if (debug != null) {
            debug.println(name + ".removeService(): " + s);
        }
        if (s == null) {
            throw new NullPointerException();
        }
        implRemoveService(s);
    }

    private void implRemoveService(Service s) {
        if ((s == null) || (serviceMap == null)) {
            return;
        }
        String type = s.getType();
        String algorithm = s.getAlgorithm();
        ServiceKey key = new ServiceKey(type, algorithm, false);
        Service oldService = serviceMap.get(key);
        if (s != oldService) {
            return;
        }
        servicesChanged = true;
        serviceMap.remove(key);
        for (String alias : s.getAliases()) {
            serviceMap.remove(new ServiceKey(type, alias, false));
        }
        removePropertyStrings(s);
    }

    private static class ServiceKey {
        private final String type;
        private final String algorithm;
        private final String originalAlgorithm;

        private ServiceKey(String type, String algorithm, boolean intern) {
            this.type = type;
            this.originalAlgorithm = algorithm;
            algorithm = algorithm.toUpperCase(ENGLISH);
            this.algorithm = intern ? algorithm.intern() : algorithm;
        }

        public int hashCode() {
            return type.hashCode() + algorithm.hashCode();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ServiceKey == false) {
                return false;
            }
            ServiceKey other = (ServiceKey) obj;
            return this.type.equals(other.type)
                    && this.algorithm.equals(other.algorithm);
        }

        boolean matches(String type, String algorithm) {
            return (this.type == type) && (this.originalAlgorithm == algorithm);
        }
    }

    private static class UString {
        final String string;
        final String lowerString;

        UString(String s) {
            this.string = s;
            this.lowerString = s.toLowerCase(ENGLISH);
        }

        public int hashCode() {
            return lowerString.hashCode();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof UString == false) {
                return false;
            }
            UString other = (UString) obj;
            return lowerString.equals(other.lowerString);
        }

        public String toString() {
            return string;
        }
    }

    private static class EngineDescription {
        final String name;
        final boolean supportsParameter;
        final String constructorParameterClassName;
        private volatile Class<?> constructorParameterClass;

        EngineDescription(String name, boolean sp, String paramName) {
            this.name = name;
            this.supportsParameter = sp;
            this.constructorParameterClassName = paramName;
        }

        Class<?> getConstructorParameterClass() throws ClassNotFoundException {
            Class<?> clazz = constructorParameterClass;
            if (clazz == null) {
                clazz = Class.forName(constructorParameterClassName);
                constructorParameterClass = clazz;
            }
            return clazz;
        }
    }

    public static class Service {

        private static final Class<?>[] CLASS0 = new Class<?>[0];
        private final Provider provider;
        private String type, algorithm, className;
        private List<String> aliases;
        private Map<UString, String> attributes;
        private volatile Reference<Class<?>> classRef;
        private volatile Boolean hasKeyAttributes;
        private String[] supportedFormats;
        private Class[] supportedClasses;
        private boolean registered;


        private Service(Provider provider) {
            this.provider = provider;
            aliases = Collections.emptyList();
            attributes = Collections.emptyMap();
        }

        public Service(Provider provider, String type, String algorithm,
                       String className, List<String> aliases,
                       Map<String, String> attributes) {
            if ((provider == null) || (type == null) ||
                    (algorithm == null) || (className == null)) {
                throw new NullPointerException();
            }
            this.provider = provider;
            this.type = getEngineName(type);
            this.algorithm = algorithm;
            this.className = className;
            if (aliases == null) {
                this.aliases = Collections.emptyList();
            } else {
                this.aliases = new ArrayList<String>(aliases);
            }
            if (attributes == null) {
                this.attributes = Collections.emptyMap();
            } else {
                this.attributes = new HashMap<UString, String>();
                for (Map.Entry<String, String> entry : attributes.entrySet()) {
                    this.attributes.put(new UString(entry.getKey()), entry.getValue());
                }
            }
        }

        private boolean isValid() {
            return (type != null) && (algorithm != null) && (className != null);
        }

        private void addAlias(String alias) {
            if (aliases.isEmpty()) {
                aliases = new ArrayList<String>(2);
            }
            aliases.add(alias);
        }

        void addAttribute(String type, String value) {
            if (attributes.isEmpty()) {
                attributes = new HashMap<UString, String>(8);
            }
            attributes.put(new UString(type), value);
        }

        public final String getType() {
            return type;
        }


        public final String getAlgorithm() {
            return algorithm;
        }


        public final Provider getProvider() {
            return provider;
        }


        public final String getClassName() {
            return className;
        }


        private final List<String> getAliases() {
            return aliases;
        }


        public final String getAttribute(String name) {
            if (name == null) {
                throw new NullPointerException();
            }
            return attributes.get(new UString(name));
        }





        private Class<?> getImplClass()  {
            try {
                Reference<Class<?>> ref = classRef;
                Class<?> clazz = (ref == null) ? null : ref.get();
                if (clazz == null) {
                    ClassLoader cl = provider.getClass().getClassLoader();
                    if (cl == null) {
                        clazz = Class.forName(className);
                    } else {
                        clazz = cl.loadClass(className);
                    }
                     classRef = new WeakReference<Class<?>>(clazz);
                }
                return clazz;
            } catch (ClassNotFoundException e) {

            }
            return null;
        }






        private boolean hasKeyAttributes() {
            Boolean b = hasKeyAttributes;
            if (b == null) {
                synchronized (this) {
                    String s;
                    s = getAttribute("SupportedKeyFormats");
                    if (s != null) {
                        supportedFormats = s.split("\\|");
                    }
                    s = getAttribute("SupportedKeyClasses");
                    if (s != null) {
                        String[] classNames = s.split("\\|");
                        List<Class<?>> classList =
                                new ArrayList<>(classNames.length);
                        for (String className : classNames) {
                            Class<?> clazz = getKeyClass(className);
                            if (clazz != null) {
                                classList.add(clazz);
                            }
                        }
                        supportedClasses = classList.toArray(CLASS0);
                    }
                    boolean bool = (supportedFormats != null)
                            || (supportedClasses != null);
                    b = Boolean.valueOf(bool);
                    hasKeyAttributes = b;
                }
            }
            return b.booleanValue();
        }


        private Class<?> getKeyClass(String name) {
            try {
                return Class.forName(name);
            } catch (ClassNotFoundException e) {

            }
            try {
                ClassLoader cl = provider.getClass().getClassLoader();
                if (cl != null) {
                    return cl.loadClass(name);
                }
            } catch (ClassNotFoundException e) {

            }
            return null;
        }




        public String toString() {
            String aString = aliases.isEmpty()
                    ? "" : "\r\n  aliases: " + aliases.toString();
            String attrs = attributes.isEmpty()
                    ? "" : "\r\n  attributes: " + attributes.toString();
            return provider.getName() + ": " + type + "." + algorithm
                    + " -> " + className + aString + attrs + "\r\n";
        }

    }

}
