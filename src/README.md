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

## Application Tech and Installation

For this project, I used Java and JUnit to test the application code. I wanted to make the 
application as simple as possible to use. I could add a React user interface at some point, 
but this is the minimum viable product I was working towards.

Installation and running should be fairly straightforward. All this application requires is
cloning the code from the repository, building the project, and running the application. No 
other dependencies should need to be added. Once the application is running, the user should
simply follow the console prompts.