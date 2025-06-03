package application;

import java.util.Arrays;
import java.util.Optional;

/**
 * The {@link Application} class contains the {@code main()} method as
 * entry point for the Java Virtual Machine. It implements the {@link Runner}
 * interface and uses command-line arguments to print formatted output.
 *
 * @version <code style="color:green">{@value application.package_info#Version}</code>
 * @author  <code style="color:blue">{@value application.package_info#Author}</code>
 */
public class Application implements Runner {

    /**
     * Singleton instance (strict).
     */
    private static final Application application = new Application();

    /**
     * Private default constructor prevents instance creation outside this class.
     */
    private Application() {}

    /**
     * Static {@code main()} method as entry point for the Java VM.
     * Delegates execution to the singleton instance.
     *
     * @param args arguments passed from the command line
     */
    public static void main(String[] args) {
        application.execute(application, args);
    }

    /**
     * Executes the {@link Runner} instance with a greeting message
     * and the given command-line arguments.
     *
     * @param runner the instance to run
     * @param args the command-line arguments
     */
    private void execute(Runner runner, String[] args) {
        String className = runner.getClass().getSimpleName();
        String moduleName = Application.class.getModule().getName();
        System.out.println(Optional.ofNullable(moduleName)
            .map(m -> String.format("Hello, %s (%s, modular)", moduleName, className))
            .orElse(String.format("Hello, se1-bestellsystem (%s)", className)));

        runner.run(args);
    }

    /**
     * Prints all passed command-line arguments, one per line.
     *
     * @param args the arguments passed from the command line
     */
    @Override
    public void run(String[] args) {
        Arrays.stream(args)
            .map(arg -> String.format(" - arg: %s", arg))
            .forEach(System.out::println);
    }
}
