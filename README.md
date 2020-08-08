Java "Tic Tac Toe" game
-----------------------------

## Prerequisites

1. Make sure [JDK 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) is installed.

2. Make sure [Maven](https://maven.apache.org/install.html) is installed.

3. Make sure [Git](https://git-scm.com) is installed.

## Port Configuration

The application is running on port 8080. It is configured in the file '/tic-tac-toe/src/main/resources/application.properties' and can be changed here before clone.
After clone is executed on linux machine, the port can be changed in the file 'TicTacToe/src/main/resources/application.properties'.
After the port is changed, the application can be build and deployed as explained at the end of this document.

## Rules

- X always goes first.

- Players cannot play on a played position/cell.

- Players alternate placing X’s and O’s on the board until either:

	- One player has three in a row, horizontally, vertically or diagonally

	- All nine squares are filled.

- If a player is able to draw three X’s or three O’s in a row, horizontally, vertically or diagonally, that player wins.

- If all nine squares are filled and neither player has three in a row, the game is a draw.


## How to build, deploy and run application

To build, deploy and run this java application, follow the instruction below:

Open terminal (putty for example) and connect to a linux machine via ssh.

```console
$ git clone https://github.com/2020-DEV-125/TicTacToe.git
$ cd TicTacToe
$ mvn package
$ java -jar target/tic-tac-toe.jar
```

Open your browser and type http://"IP Address":8080 to view user interface of the game and follow instructions.

Here "IP Address" is IP address of the sever where the application is deployed.
