# Tic-Tac-Toe — Low Level Design & Machine Coding

A Java implementation of **Tic-Tac-Toe designed using Low Level Design (LLD) and machine-coding principles**.

The goal of this project is not just to make Tic-Tac-Toe work, but to practice designing a system that is **modular, extensible, and easy to maintain** using Object-Oriented Programming and design principles.

## 🎯 Project Goals

This project is part of my journey to strengthen:

* Object-Oriented Programming (OOP)
* SOLID principles
* Low Level Design (LLD)
* Design patterns
* Separation of responsibilities
* Interface-based programming
* Strategy Pattern
* Machine coding / object-oriented problem solving

## 🎮 Features

* Configurable Tic-Tac-Toe board size
* Multiple players
* Player symbols
* Move validation
* Board management
* Winning strategies
* Diagonal, row, and column winning conditions
* Game state management
* Separation between controllers, models, and strategies
* Extensible winning-strategy design

## 🏗️ High-Level Design

The implementation separates the game into different responsibilities.

```text
                    GameController
                          |
                          v
                        Game
                    /     |      \
                   /      |       \
                  v       v        v
               Board    Players   WinningStrategy
                                      |
                    +-----------------+----------------+
                    |                 |                |
                    v                 v                v
             RowWinning       ColumnWinning      DiagonalWinning
              Strategy            Strategy           Strategy
```

### Main Components

#### `Game`

Responsible for managing the overall game state and game flow.

It coordinates:

* Players
* Board
* Moves
* Winning strategies
* Game state

#### `Board`

Represents the Tic-Tac-Toe board and manages the cells on the board.

#### `Player`

Represents a player participating in the game along with their symbol.

#### `Move`

Represents a move made by a player on a particular cell.

#### `GameController`

Acts as an entry point for interacting with the game and delegates game operations to the appropriate objects.

#### `WinningStrategy`

Defines the contract for checking whether a particular move results in a win.

Different winning conditions can be implemented independently behind this interface.

```java
public interface WinningStrategy {

    boolean checkWinner(Move move);
}
```

This allows the game to work with different winning strategies without tightly coupling the `Game` class to their implementations.

## 🧩 Design Principles

### Strategy Pattern

The winning logic is separated using the Strategy Pattern.

Instead of putting all winning logic directly inside `Game`, different strategies can be implemented independently.

For example:

```text
WinningStrategy
       |
       +---- RowWinningStrategy
       |
       +---- ColumnWinningStrategy
       |
       +---- DiagonalWinningStrategy
```

This makes it easier to introduce or modify winning conditions without changing the core game logic.

### Separation of Responsibilities

Each class is responsible for a specific part of the system.

For example:

```text
GameController → handles interaction
Game           → manages game flow
Board          → manages board
Player         → represents player
Move           → represents a move
Strategy       → determines winning condition
```

This keeps individual classes focused and makes the system easier to extend.

## 📁 Project Structure

```text
src
└── main
    └── java
        └── org
            └── example
                ├── controllers
                ├── models
                ├── strategy
                └── Main.java
```

## 🚀 How to Run

### Prerequisites

* Java JDK
* IntelliJ IDEA (recommended)
* Git

### Run using IntelliJ IDEA

1. Clone the repository.

```bash
git clone https://github.com/GarvJaiswal/tic-tac-toe-machine-coding.git
```

2. Open the project in IntelliJ IDEA.

3. Locate:

```text
src/main/java/org/example/Main.java
```

4. Run `Main.java`.

## 🧪 Example Game Flow

A typical game follows this flow:

```text
GameController
      ↓
    makeMove()
      ↓
      Game
      ↓
  Validate Move
      ↓
    Update Board
      ↓
 Check Winning Strategies
      ↓
 Winner / Draw / Continue
```

## 🔮 Future Improvements

Possible extensions to this project include:

* Support for more than two players
* Configurable board dimensions
* Draw detection
* Undo/redo moves
* Player types such as human and bot
* AI-based player
* Minimax strategy
* Additional winning strategies
* Unit tests
* Improved input validation
* Game restart functionality

## 📚 Learning Focus

This repository is primarily a **learning and interview-preparation project** focused on understanding how to approach machine-coding problems using clean object-oriented design.

The implementation may evolve as I learn additional LLD concepts and design patterns.

## 👨‍💻 Author

**Garv Jaiswal**

GitHub: [GarvJaiswal](https://github.com/GarvJaiswal)
