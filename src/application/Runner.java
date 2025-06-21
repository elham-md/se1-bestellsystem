package application;

/**
 * The {@link Runner} interface defines a {@code run(String[] args)} method
 * that allows executing application logic using command-line arguments.
 * 
 * <p>This goes beyond the standard {@link Runnable} interface, which does not
 * forward the original argument array. It allows better support for
 * applications that rely on CLI parameters.</p>
 *
 * @version <code style="color:green">{@value application.package_info#Version}</code>
 * @author  <code style="color:blue">{@value application.package_info#Author}</code>
 */
public interface Runner {

    /**
     * Executes the application logic using the command-line arguments.
     *
     * @param args the arguments passed from the command line
     */
    void run(String[] args);
}
