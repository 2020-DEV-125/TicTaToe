Java "Tic Tac Toe" game
-----------------------------

This project was developed with Eclipse IDE for Enterprise Java Developers (includes Incubating components) Version: 2020-06 (4.16.0).

## Prerequisites

1. Make sure [JDK 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) is installed.

2. Make sure [Maven](https://maven.apache.org/install.html) is installed.

3. Make sure [Git](https://git-scm.com) is installed.


## Rules

- X always goes first.

- Players cannot play on a played position/cell.

- Players alternate placing X’s and O’s on the board until either:

	- One player has three in a row, horizontally, vertically or diagonally

	- All nine squares are filled.

- If a player is able to draw three X’s or three O’s in a row, horizontally, vertically or diagonally, that player wins.

- If all nine squares are filled and neither player has three in a row, the game is a draw.


## How to run

This repository contains very trivial Java program. To build and run this program, follow the instruction:

Create a directory tic-tac-toe.

```console
$ mkdir tic-tac-toe
$ cd tic-tac-toe
$ git clone https://github.com/2020-DEV-125/TicTacToe.git
$ mvn package
$ java -jar target/tic-tac-toe.jar
```

Open [http://localhost:9000](http://localhost:9000) to view it in the browser.
