# Currency Converter - JavaFX

A simple currency converter based on JavaFX that retrieves real-time exchange rates using the FreeCurrencyAPI and converts currencies.

---

## Features

- **Real-time exchange rates**: Fetch the latest exchange rates via FreeCurrencyAPI.
- **User-friendly GUI**: Select currencies from a dropdown list with full names and abbreviations.
- **Cross-platform support**:
  - Windows: Stores the API key in LocalAppData.
  - macOS: Stores the API key in ~/Library/Application Support.
  - Linux: Stores the API key in ~/.config.
- **Input validation**: Validates numeric inputs and supports both dots and commas as decimal separators.

---

## Requirements

- **Java 17 or higher**
- **Maven** (for building the project)

---

## Installation

1. **Clone the repository**:

   ```bash
   git clone https://github.com/EpicGamer4088/currency-calculator-javafx.git
   cd currency-calculator-javafx
   ```

2. **Install dependencies**:

   ```bash
   mvn clean install
   ```

3. **Run the project**:

   ```bash
   mvn javafx:run
   ```

4. **Provide an API key**:
   If no API key is found, a window will open where you can enter your API key.

---

## How to get an API key from FreeCurrencyAPI

1. Visit the website [https://freecurrencyapi.com/](https://freecurrencyapi.com/).
2. Register or log in.
3. Go to your dashboard and copy the existing Default API Key.

  ![API-KEY_location](https://github.com/user-attachments/assets/96eb89ba-1529-43b7-bec7-447d052b63a5)

4. Paste the API key into the program's input field when prompted.

  ![enter_api-key](https://github.com/user-attachments/assets/cba59c8c-7f96-45a2-af86-0f5294d62948)

---

## Usage

1. **Start the program**.
2. Select the source and target currency.
   
   ![dropdown-lists_for-currency](https://github.com/user-attachments/assets/de8364d1-074b-4599-9d0b-55cbb624ff72)


3. Enter the amount to be converted.
   
   ![input-amount](https://github.com/user-attachments/assets/875cc45e-23f1-4070-821c-84183965f0e9)


4. Click "Convert" to see the converted amount.
   
   ![converted-result](https://github.com/user-attachments/assets/f8b6d04f-18bd-4277-b22c-fb481e9abe3f)

---

## Project Structure

```plaintext
src/
├── main/
│   ├── java/com/currencycalc/currencycalculatorjavafx/
│   │   ├── App.java                // Main application class
│   │   ├── Launcher.java           // Launches the JavaFX application
│   │   ├── CurrencyClient.java     // Communicates with the FreeCurrencyAPI
│   │   ├── MainController.java     // Controls GUI logic
│   │   ├── model/
│   │   │   ├── CurrencyData.java   // Data model for API responses
│   │   │   ├── Data.java           // Holds exchange rate data
│   │   ├── utils/
│   │       ├── ApiKeyManager.java  // Manages the API key
│   │       ├── ApiKeyWindow.java   // Window for entering the API key
│   ├── resources/
│       ├── main-view.fxml          // GUI layout
```

---

## License

This project is licensed under the [MIT License](LICENSE).

---

## Contact

For questions or issues, please contact [tim.platzer@gmx.at](mailto:tim.platzer@gmx.at).

