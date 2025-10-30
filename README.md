# 🃏 OOP Card Games (Java)

---

## 1) Project Description

This repository contains a small **Java console project** that implements shared playing-card utilities and two games:

* **In-Between** (a.k.a. Acey-Deucey / Between the Sheets)
    * A **betting game** where you wager whether a third card's rank falls between two shown cards.
    * *Rules:* [Bicycle Cards — In-Between](https://www.bicyclecards.com/how-to-play/in-between/) • [Denexa — In-Between](https://denexa.com/rules/in-between/)

* **Xeri (Ξερή)**
    * A classic **Greek "fishing" card game** for two players that captures table cards by matching ranks (with special roles for Jacks).
    * *Rules:* [Pagat — Xeri](https://www.pagat.com/fishing/xeri.html)

**Core components** include a `Card` model (suits/ranks + helpers), a `CardStack` (array-based deck with shuffle/draw), and separate classes for the game logic and simple console I/O.

---

## 2) How to Run 🚀

**Requirements:** Java 8+ (JDK). Source files live in `src/`.

### From the Command Line

To compile and run the games from your terminal:

```bash
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
