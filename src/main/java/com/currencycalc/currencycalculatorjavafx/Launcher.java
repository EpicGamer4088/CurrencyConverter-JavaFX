package com.currencycalc.currencycalculatorjavafx;

/**
 * A simple launcher class for the Currency Calculator application.
 * This class serves as an entry point for environments where the main class
 * defined in a modular JavaFX project (e.g., {@link App}) cannot be launched directly.
 *
 * This workaround is often necessary to handle JavaFX module configurations or
 * IDE-specific limitations.
 *
 * @author Tim Platzer
 * @version 1.0.0
 */
public class Launcher
{
    /**
     * The main method that starts the application.
     * It delegates the launch process to the {@link App#main(String[])} method.
     *
     * @param args Command-line arguments passed to the application (not used).
     */
    public static void main(String[] args)
    {
        App.main(args); // Delegates the launch to the App class
    }
}
