OOP Card Games (Java)
1) Project Description
This repository contains a small Java console project that implements shared playing-card utilities and two games:


In-Between (a.k.a. Acey-Deucey / Between the Sheets) — a betting game where you wager whether a third card’s rank falls between two shown cards.
Rules: Bicycle Cards — In-Between • Denexa — In-Between


Xeri (Ξερή) — a classic Greek “fishing” card game for two players that captures table cards by matching ranks (with special roles for Jacks).
Rules: Pagat — Xeri


Core components include a Card model (suits/ranks + helpers), a CardStack (array-based deck with shuffle/draw), and separate classes for the game logic and simple console I/O.

2) How to Run
Requirements: Java 8+ (JDK). Source files live in src/.
# From the project root
cd src

# Compile everything
javac *.java

# Run the basic deck demo (optional)
java CardStack

# Run the In-Between game
java Between

# Run the Xeri game
java Xeri


Using an IDE (IntelliJ/Eclipse/VS Code)? Mark src/ as your source root, build, and run the Between or Xeri main classes.

