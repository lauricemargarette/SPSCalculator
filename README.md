# SPSCalculator

A **Java-based Solar Power System (SPS) Calculator** that helps estimate energy consumption, solar panel capacity, and battery storage for solar setups.
This project aims to assist users, students, society, and developers in understanding the main computations behind solar energy system design.

-----

## 📘 Table of Contents

- [About](#about)
- [Features](#features)
- [Getting Started](#getting-started)
  - [Prerequisites](#Prerequisites)
  - [Installation](#Installation)
  - [Usage](#Usage)
- [Project Structure](#Project-Structure)
- [How It Works](#How-It-Works)
- [Contributing](#Contributing)
- [License](#License)
- [Contact](#Contact)

-----

## ℹ️ About

The **SPS Calculator** is a simple Java Project that simulates the essential components of a solar power system - **solar panels**, **batteries**, and **appliances**.
By entering energy consumption details and system specifications, the calculator provides quick estimates of:  

- How much energy your setup can produce
- The battery capacity needed
- Whether your system meets your energy demands

This project can serve as a **learning tool** or **prototype model** for future GUI-based or web-based solar calculators.

-----

## ⚙️ Features

✔ Calculate daily energy requirements  
✔ Estimate required solar panel wattage  
✔ Determine battery storage needs  
✔ Model energy input/output behavior  
✔ Simple and modular Java codebase
✔ Easily extendable (e.g., add inverters, weather data, etc.)

-----

## 🚀 Getting Started

### 🧩 Prerequisites

Before running the project, ensure you have:  

- **Java JDK 8** or higher installed
- A Java IDE (e.g., IntelliJ IDEA, Eclipse, NetBeans) or command line  
- Basic understanding of solar energy concepts (optional)

### 🛠️ Installation

1. Clone this repository:

   ```bash
   git clone https://github.com/lauricemargarette/SPSCalculator.git
2. Navigate to the project folder:

   ```bash
   cd SPSCalculator
3. Compile the Java files:

   ```bash
   javac *.java
4. Run the program:

   ```bash
   java Main

### 💡 Usage

Once the program runs, you can input or modify values such as:

- Daily power consumption (kWh)
- Solar panel rating and efficiency
- Battery capacity (Ah or Wh)
- System voltage
- Backup/autonomy days

#### Example output may include

  ```yaml
  Recommended Solar Panel: 350W x 4
  Required Battery Capacity: 12V 200Ah
  Estimated Daily Production: 5.6 kWh
  ```

-----

## 🧱 Project Structure

  ```css
  SPSCalculator/
  │
  ├── Main.java
  ├── PowerConsumption.java
  ├── SolarPanel.java
  ├── Battery.java
  ├── SolarBattery.java
  ├── Appliances.java
  └── README.md
  ```

Main.java – Entry point of the program  
PowerConsumption.java – Calculates total energy usage  
SolarPanel.java – Handles solar energy generation logic  
Battery.java – Models energy storage and capacity  
SolarBattery.java – Integrates solar and battery operations  
Appliances.java – Defines user load or device consumption  

-----

## 🔍 How It Works

1. The user inputs power consumption and panel/battery specs.
2. The program calculates solar generation vs consumption.
3. It determines if your battery capacity is sufficient.
4. The system outputs recommended setup adjustments.

The logic behind the calculator can be expanded into a graphical interface or web-based solar planner.

-----

## 🤝 Contributing

Contributions are welcome!

1. Fork the repository
2. Create your branch (`git checkout -b feature/YourFeature`)
3. Commit your changes (`git commit -m 'Add Feature'`)
4. **Push** to your branch (`git push origin feature/YourFeature`)
5. Open a **Pull Request**.

-----

## 📜 License

This project is open-source under the MIT License.  
Feel free to modify and use it for educational or commercial purposes.

-----

## 📫 Contact

Developer: Laurice Margarette  
GitHub: @lauricemargarette  
Email: <lauricepates1126@gmail.com>
