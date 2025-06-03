package application;

/**
 * The {@link Runner} interface defines a single entry-point
 * {@code run(String[] args)} that accepts the command-line arguments
 * of the Java VM.  
 * <p>
 * This goes beyond the standard {@link Runnable} interface, which does not
 * forward the original argument array.
 * </p>
 *
 * @author  <code style="color:blue">{@value application.package_info#Author}</code>
 * @version <code style="color:green">{@value application.package_info#Version}</code>
 */
public interface Runner {

    /**
     * Executes the application logic using the command-line arguments.
     *
     * @param args the arguments passed from the command line
     */
    void run(String[] args);
}
