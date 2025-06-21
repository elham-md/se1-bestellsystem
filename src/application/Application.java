package application;

import java.util.Arrays;
import java.util.Optional;


/**
 * Die {@link Application}-Klasse enthält die {@code main()}-Methode als
 * Einstiegspunkt für die Java Virtual Machine. Sie implementiert das
 * {@link Runner}-Interface und verwendet Kommandozeilenargumente zur
 * Ausgabe formatierter Texte.
 *
 * @version {@value application.package_info#Version}
 * @author  {@value application.package_info#Author}
 */
public class Application implements Runner {

    /**
     * Singleton-Instanz von {@link Application}.
     */
    //private static final Application application = new Application();
    private static final Runner application = new Application_C12();

    /**
     * Privater Konstruktor verhindert externe Instanziierung.
     */
    private Application() {}

    /**
     * Einstiegspunkt der Java VM. Erstellt eine {@link Runner}-Instanz
     * und delegiert die Ausführung an {@code run()}.
     *
     * @param args Kommandozeilenargumente
     */
    public static void main(String[] args) {
        // execute(...) ist Methode dieser Klasse, also muss sie über ein Application-Objekt aufgerufen werden.
        new Application().execute(application, args);
    }

    /**
     * Führt eine {@link Runner}-Instanz aus, zeigt einen Begrüßungstext
     * und ruft {@code run()} auf.
     *
     * @param runner das auszuführende {@link Runner}-Objekt
     * @param args Kommandozeilenargumente
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
     * Gibt alle übergebenen Kommandozeilenargumente einzeln aus.
     *
     * @param args die Kommandozeilenargumente
     */
    @Override
    public void run(String[] args) {
        Arrays.stream(args)
            .map(arg -> String.format(" - arg: %s", arg))
            .forEach(System.out::println);
    }
}
