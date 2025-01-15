package com.currencycalc.currencycalculatorjavafx.utils;

import java.io.*;

/**
 * Utility class for managing the storage and retrieval of the API key.
 * The API key is stored in a serialized file within the operating system's
 * designated application data folder. The class ensures cross-platform
 * compatibility for Windows, macOS, and Linux.
 * <p>
 * The folder structure and file name are as follows:
 * <ul>
 *     <li>Windows: {@code %LOCALAPPDATA%/exchange-calculator/api_key.ser}</li>
 *     <li>macOS: {@code ~/Library/Application Support/exchange-calculator/api_key.ser}</li>
 *     <li>Linux: {@code ~/.config/exchange-calculator/api_key.ser}</li>
 * </ul>
 * </p>
 *
 * @author Tim Platzer
 * @version 1.0.0
 */
public class ApiKeyManager
{
    /**
     * The folder name where the application data is stored.
     */
    private static final String APP_FOLDER_NAME = "currency-converter";

    /**
     * The file name for storing the API key.
     */
    private static final String API_KEY_FILE_NAME = "api_key.ser";

    /**
     * Retrieves the path to the application data folder based on the operating system.
     *
     * @return A {@link File} object representing the application data folder.
     */
    private static File getAppDataFolder()
    {
        String os = System.getProperty("os.name").toLowerCase();
        String appDataPath;

        if (os.contains("win"))
        {
            appDataPath = System.getenv("LOCALAPPDATA");
        } else if (os.contains("mac"))
        {
            appDataPath = System.getProperty("user.home") + "/Library/Application Support";
        } else
        {
            appDataPath = System.getProperty("user.home") + "/.config";
        }

        return new File(appDataPath, APP_FOLDER_NAME);
    }

    /**
     * Retrieves the file where the API key is stored.
     * Ensures the application data folder exists, creating it if necessary.
     *
     * @return A {@link File} object representing the API key file.
     * @throws RuntimeException if the application data directory cannot be created.
     */
    private static File getApiKeyFile()
    {
        File appDataFolder = getAppDataFolder();
        if (!appDataFolder.exists() && !appDataFolder.mkdirs())
        {
            throw new RuntimeException("Failed to create application data directory: " + appDataFolder.getAbsolutePath());
        }
        return new File(appDataFolder, API_KEY_FILE_NAME);
    }

    /**
     * Saves the provided API key to the storage file.
     *
     * @param apiKey The API key to save.
     * @throws IOException If an I/O error occurs while saving the key.
     */
    public static void saveApiKey(String apiKey) throws IOException
    {
        File apiKeyFile = getApiKeyFile();
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(apiKeyFile)))
        {
            oos.writeObject(apiKey);
        }
    }

    /**
     * Loads the API key from the storage file.
     *
     * @return The stored API key as a {@link String}.
     * @throws IOException If the file does not exist or an I/O error occurs.
     * @throws ClassNotFoundException If the serialized object cannot be deserialized.
     */
    public static String loadApiKey() throws IOException, ClassNotFoundException
    {
        File apiKeyFile = getApiKeyFile();
        if (!apiKeyFile.exists())
        {
            throw new FileNotFoundException("The API-key file was not found: " + apiKeyFile.getAbsolutePath());
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(apiKeyFile)))
        {
            return (String) ois.readObject();
        }
    }
}
