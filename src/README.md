# Welcome to Game of Life!

This project is based on Ron Conway's Game of Life automaton simulator.
The application will take in a game board object with live cells and dead cells
and return the next state of the game board. This next state is determined
by a set of four rules which are detailed below:

1. Any live cell with fewer than two live neighbours dies, as if by underpopulation.
2. Any live cell with two or three live neighbours lives on to the next generation.
3. Any live cell with more than three live neighbours dies, as if by overpopulation.
4. Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.

## How to Play

This application is a console application. It will prompt the user to input how many rows
and columns should be on their game board. Once the application has accepted the input, it
will prompt the user for a series of live cells and dead cells. 

For this iteration of the application, a live cell is 1 and a dead cell is 0. 
The series of live cells and dead cells is dependent on how many rows and columns a user has input. 
For example, if the user has input 8 rows and 6 columns, the application will prompt the user 
to enter a series of 6 live cells and dead cells. This will occur 8 times, allowing the user 
to enter input to build an 8 x 6 player board. 

Once the board is built, the application will evaluate each cell of the board to determine 
the next state of the board and print that next state to the console.

##Requirements, Features, and Algorithm and Design Choice
• Highlights the requirements and additional features that were implemented.

The main requirements were fairly straightforward: the initial program should accept and 8x6 
grid and that grid would be evaluated based on the rules of Conway's Game of Life and output
the next state. The application should be designed based on Object Oriented Programming principles
and should utilise test driven development with JUnit tests. A fancy user interface wasn't 
required, but the program should be easy and intuitive and not require extensive set up.

• A brief discussion of your algorithm and design choice.

I started by simply solving the Game of Life LeetCode problem. I figured that would give me a 
baseline of what the solution could be at bare minimum and I could start to see how to design
the application around the solution. Once I had that down, I fleshed out the steps of the game
from the user's perspective; what input would be required of the user and how the application could
work around that. The GameBoardEvaluator class came first, since most of the LeetCode solution
revolved around the actual evaluation of the GameBoard. Then I wrote the
GameBoard class to set up its attributes and a method to print the board.
As I started to flesh out those two classes, I realized I needed a third class
to actually build the GameBoard and validate the values that were going into it.
The Evaluator cared to a point what the values were, and originally I had an exception to handle
invalid boards there, but in order to keep the game from crashing entirely at that point,
I decided it would be better to have the user input validated in real time than at the end
of the game. It makes more sense to validate the input before you build the GameBoard
rather than waiting all the way until the end to do it.

## Application Tech and Installation

For this project, I used Java and JUnit to test the application code. I wanted to make the 
application as simple as possible to use. I could add a React user interface at some point, 
but this is the minimum viable product I was working towards.

Installation and running should be fairly straightforward. All this application requires is
cloning the code from the repository, opening a console terminal, navigating into the 
project's directory and into the `src/main/java` folder. Once there, run the command 
`java GameOfLife.java ` and the application will run. No other dependencies should need 
to be added. Once the application is running, the user should simply follow the console prompts.

To run the unit tests, simply type the command `./gradlew build test` into the console and it
should run all tests as well as indicate whether they have passed, failed, or been skipped.

