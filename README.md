# Currency Calculator - JavaFX

Ein einfacher Währungsrechner basierend auf JavaFX, der mithilfe der FreeCurrencyAPI aktuelle Wechselkurse abruft und Währungen umrechnet.

---

## Features

- **Wechselkursaktualisierung**: Holen Sie sich aktuelle Wechselkurse über die FreeCurrencyAPI.
- **Benutzerfreundliche GUI**: Wählen Sie Währungen aus einer Dropdown-Liste mit Namen und Kürzeln aus.
- **Betriebssystemunterstützung**:
  - Windows: Speichert den API-Key in LocalAppData.
  - macOS: Speichert den API-Key in ~/Library/Application Support.
  - Linux: Speichert den API-Key in ~/.config.
- **Eingabevalidierung**: Validierung für Zahlen und Dezimaltrennzeichen (Punkt und Komma).

---

## Voraussetzungen

- **Java 17 oder höher**
- **Maven** (zum Bauen des Projekts)

---

## Installation

1. **Repository klonen**:

   ```bash
   git clone https://github.com/<your-username>/currency-calculator-javafx.git
   cd currency-calculator-javafx
   ```

2. **Abhängigkeiten installieren**:

   ```bash
   mvn clean install
   ```

3. **Projekt starten**:

   ```bash
   mvn javafx:run
   ```

4. **API-Key bereitstellen**:
   Wenn kein API-Key gefunden wird, öffnet sich ein Fenster, in dem Sie den API-Key eingeben können.

---

## Anleitung: API-Key von FreeCurrencyAPI

1. Besuchen Sie die Website [https://freecurrencyapi.com/](https://freecurrencyapi.com/).
2. Registrieren Sie sich oder melden Sie sich an.
3. Gehen Sie zu Ihrem Dashboard und Kopieren Sie den vorhandenen Default API-Key:.

  ![API-KEY_location](https://github.com/user-attachments/assets/96eb89ba-1529-43b7-bec7-447d052b63a5)

4. Fügen Sie den API-Key in das geöffnete Eingabefeld des Programms ein.

  ![enter_api-key](https://github.com/user-attachments/assets/cba59c8c-7f96-45a2-af86-0f5294d62948)

---

## Verwendung

1. **Starten Sie das Programm**.
2. Wählen Sie die Quell- und Zielwährung aus.
   
   ![dropdown-lists_for-currency](https://github.com/user-attachments/assets/de8364d1-074b-4599-9d0b-55cbb624ff72)


3. Geben Sie den Betrag ein, den Sie umrechnen möchten.
   
   ![input-amount](https://github.com/user-attachments/assets/875cc45e-23f1-4070-821c-84183965f0e9)


4. Klicken Sie auf "Convert", um den umgerechneten Betrag anzuzeigen.
   
   ![converted-result](https://github.com/user-attachments/assets/f8b6d04f-18bd-4277-b22c-fb481e9abe3f)

---

## Projektstruktur

```plaintext
src/
├── main/
│   ├── java/com/currencycalc/currencycalculatorjavafx/
│   │   ├── App.java                // Hauptklasse
│   │   ├── Launcher.java           // Startet die JavaFX-Anwendung
│   │   ├── CurrencyClient.java     // Kommuniziert mit der FreeCurrencyAPI
│   │   ├── MainController.java     // Steuert die GUI-Logik
│   │   ├── model/
│   │   │   ├── CurrencyData.java // Datenmodell für API-Antworten
│   │   │   ├── Data.java          // Enthält die Wechselkurse
│   │   ├── utils/
│   │       ├── ApiKeyManager.java   // Verwalten des API-Keys
│   │       ├── ApiKeyWindow.java    // Fenster zur Eingabe des API-Keys
│   ├── resources/
│       ├── main-view.fxml          // GUI-Layout
```

---

## Lizenz

Dieses Projekt steht unter der [MIT-Lizenz](LICENSE).

---

## Kontakt

Bei Fragen oder Problemen wenden Sie sich bitte an [tim.platzer@gmx.at](mailto:tim.platzer@gmx.at).

