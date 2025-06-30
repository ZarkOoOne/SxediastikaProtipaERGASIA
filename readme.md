echo 'INSERT-INSTALL-COMMAND-HERE'
echo 'INSERT-RUN-COMMAND-HERE'
echo 'INSERT-TEST-COMMAND-HERE'

# Sxediastika Protipa Ergasia

## Overview

This project is a Java implementation for a strategy-based battle simulation involving Aliens, Warriors, Satellites, and Telescopes. It demonstrates the use of design patterns such as Observer and Strategy, and models interactions between different entities in a battle scenario. The code is organized for clarity and extensibility, making it suitable for educational and demonstration purposes.

## Features

- **Battle Simulation:** Simulates battles between alien armies and warriors using different attack strategies.
- **Design Patterns:** Implements the Observer and Strategy patterns for flexible and decoupled code.
- **Extensible Entities:** Easily add new types of aliens, warriors, or strategies.
- **Event Notification:** Observers (e.g., satellites, telescopes) receive updates about battle events.
- **Detailed Attack Info:** Tracks and reports information about each attack.

## Project Structure

```
SxediastikaProtipaERGASIA/
├── LICENSE
├── PerigrafiClass5486.pdf
├── Source5486/
│   ├── Alien.java
│   ├── AlienArmy.java
│   ├── BattleStrategy.java
│   ├── FullAttack.java
│   ├── Game.java
│   ├── LastAttackInfo.java
│   ├── Observable.java
│   ├── Observer.java
│   ├── PartialAttack.java
│   ├── Satellite.java
│   ├── Telescope.java
│   ├── Warrior.java
│   └── WarriorAttack.java
└── Stoixeia5486.txt
```

## Getting Started

### Prerequisites
- Java 8 or newer

### Installation
1. Clone the repository:
   ```sh
   git clone https://github.com/ZarkOoOne/SxediastikaProtipaERGASIA
   cd SxediastikaProtipaERGASIA
   ```
2. Compile the source code:
   ```sh
   javac Source5486/*.java
   ```

### Usage
Run the main class (e.g., `Game`):
```sh
java -cp Source5486 Game
```

### Testing
No automated tests are included. To test, run the program and observe the output for correctness.

## Contributing

1. Fork the repository and clone it locally.
2. Create a new branch for your feature or fix.
3. Make your changes and commit them with clear messages.
4. Push to your fork and submit a pull request.

## License
This project is licensed under the terms described in the LICENSE file.

## Author

- ZarkOoOne (https://github.com/ZarkOoOne)

## Acknowledgments
- Based on the requirements and description provided in PerigrafiClass5486.pdf.
- Thanks to all contributors and reviewers.