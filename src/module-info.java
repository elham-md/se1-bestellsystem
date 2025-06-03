/**
 * Modules have been introduced in Java 9 (2017) to compose software from
 * multiple modularized Java projects. Prior to this, only packages within
 * a single project could be composed.
 *
 * {@code module-info.java} indicates a <i>modularized</i> Java project. It
 * defines the module name {@link se1.bestellsystem}, other modules required
 * by this module, and packages that are opened or exported to other modules.
 * 
 * <p> Opening a package makes it accessible to tools such as JUnit test runners.
 * Exporting a package makes it accessible to other modules at compile and runtime.
 *
 * <p> Locations of <i>required</i> modules must be provided via {@code MODULEPATH}.
 *
 * @version <code style="color:green">{@value application.package_info#Version}</code>
 * @author  <code style="color:blue">{@value application.package_info#Author}</code>
 */
module se1.bestellsystem {

    /**
     * Make package {@code application} accessible to other modules at compile- and runtime.
     */
    exports application;

    /**
     * Open package {@code application} for use by tools such as JUnit test runners.
     */
    opens application;

    /**
     * Declare dependency on external module JUnit Jupiter API for testing.
     */
    requires org.junit.jupiter.api;
}
