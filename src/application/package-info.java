/**
 * Das {@link application}-Package enthält Klassen mit einer
 * {@code main()}-Methode, die von der Java VM direkt ausgeführt werden können.
 *
 * <p>{@code package-info.java} wurde mit der Einführung der Java-Module
 * (Java 9, 2017) eingeführt, um
 * <ul>
 *   <li>Package-level-Dokumentation bereitzustellen und</li>
 *   <li>projektweite Konstanten zu definieren, die in der Javadoc angezeigt werden können.</li>
 * </ul>
 *
 * @version {@value application.package_info#Version}
 * @author  {@value application.package_info#Author}
 */
package application;

/**
 * Globale Konstanten, die in der gesamten Projektdokumentation
 * verwendet werden können (z. B. in Javadoc-Tags).
 */
class package_info {

    /** Autor-Name, der in der Javadoc erscheint. */
    static final String Author = "sgraupner";      // ← ggf. anpassen

    /** Versionsnummer des Projekts, die in der Javadoc erscheint. */
    static final String Version = "1.0.0-SNAPSHOT";
}
