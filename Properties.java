
import java.security.AccessControlException;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Map;

/**
 * Utility method for accessing system properties.
 */
public class Properties
{
    private Properties()
    {

    }

    private static final ThreadLocal threadProperties = new ThreadLocal();

    /**
     * Return whether a particular override has been set to true.
     *
     * @param propertyName the property name for the override.
     * @return true if the property is set to "true", false otherwise.
     */
    public static boolean isOverrideSet(String propertyName)
    {
        try
        {
            String p = fetchProperty(propertyName);

            if (p != null)
            {
                return "true".equals(Strings.toLowerCase(p));
            }

            return false;
        }
        catch (AccessControlException e)
        {
            return false;
        }
    }

    private static String fetchProperty(final String propertyName)
    {
        return (String)AccessController.doPrivileged(new PrivilegedAction()
        {
            public Object run()
            {
                Map localProps = (Map)threadProperties.get();
                if (localProps != null)
                {
                    return localProps.get(propertyName);
                }

                return System.getProperty(propertyName);
            }
        });
    }
}
