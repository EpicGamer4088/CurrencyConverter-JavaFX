package com.currencycalc.currencycalculatorjavafx.utils;

import java.io.*;

public class ApiKeyManager
{
    private static final String APP_FOLDER_NAME = "exchange-calculator";
    private static final String API_KEY_FILE_NAME = "api_key.ser";

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

    private static File getApiKeyFile()
    {
        File appDataFolder = getAppDataFolder();
        if (!appDataFolder.exists() && !appDataFolder.mkdirs())
        {
            throw new RuntimeException("Failed to create application data directory: " + appDataFolder.getAbsolutePath());
        }
        return new File(appDataFolder, API_KEY_FILE_NAME);
    }

    public static void saveApiKey(String apiKey) throws IOException
    {
        File apiKeyFile = getApiKeyFile();
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(apiKeyFile)))
        {
            oos.writeObject(apiKey);
        }
    }

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
