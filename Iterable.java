
import java.util.Iterator;

/**
 * Utility class to allow use of Iterable feature in JDK 1.5+
 */
interface Iterable<T>
        extends java.lang.Iterable<T>
{
    Iterator<T> iterator();
}
