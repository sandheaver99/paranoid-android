# paranoid-android
online coding challenge

THE PROGRAM:
For level 2 of "Don't Panic", the goal and rules of level 1 still apply. A set of new rules has been added:
A floor can now have more than one elevator or no elevator at all.
In addition to the blocking action, you can ask the leading clone to build a new elevator (action ELEVATOR). The number of elevators you can build is provided at the beginning of the game (nbAdditionalElevators).
The clone that builds an elevator is destroyed in the process.
The inputs / outputs for this question are identical to the ones of question #1. Do not hesitate to go back to the previous question to copy your code and paste it into this question.

Reminder of previous rules :

You need to help Marvin and his clones (or is it the other way round?) reach the exit in order to help them escape the inside of the Infinite Improbability Drive.

The drive has a rectangular shape of variable size. It is composed of several floors (0 = lower floor) and each floor has several possible positions that the clones can occupy (0 = leftmost position, width - 1 = rightmost position).

The goal is to save at least one clone in a limited amount of rounds.

The details:
Clones appear from a unique generator at regular intervals, every three game turns. The generator is located on floor 0. Clones exit the generator heading towards the right.
Clones move one position per turn in a straight line, moving in their current direction.
A clone is destroyed by a laser if it is goes below position 0 or beyond position width - 1.
Elevators are scattered throughout the zone and can be used to move from one floor to the one above. When a clone arrives on the location of an elevator, it moves up one floor. Moving up one floor takes one game turn. On the next turn, the clone continues to move in the direction it had before moving upward.
On each game turn you can either block the leading clone - meaning the one that got out the earliest - or do nothing.
Once a clone is blocked, you can no longer act on it. The next clone in line takes the role of "leading clone" and can be blocked at a later time.
When a clone moves towards a blocked clone, it changes direction from left to right or right to left. It also changes direction when getting out of the generator directly on a blocked clone or when going up an elevator onto a blocked clone.
If a clone is blocked in front of an elevator, the elevator can no longer be used.
When a clone reaches the location of the exit, it is saved and disappears from the area.
 
You win if you correctly block clones to get at least one clone to the exit location in a limited amount of game rounds.
 
The program must first read the initialization data from standard input. Then, within an infinite loop, read the contextual data (location of leading clone) from the standard input and provide the next instruction to standard output. The protocol is detailed further down.

Don’t forget to run the tests by launching them from the “Test cases” window. You do not have to pass all tests to enter the leaderboard. Each test you pass will earn you some points (for example 10%).

The tests provided are similar to the validation tests used to compute the final score but are slightly different.


INITIALIZATION INPUT
Line 1: 8 integers:
nbFloors : number of floors in the area. A clone can move between floor 0 and floor (nbFloors - 1)
width : the width of the area. The clone can move without being destroyed between position 0 and position (width - 1)
nbRounds : maximum number of rounds before the end of the game
exitFloor : the floor on which the exit is located
exitPos : the position of the exit on its floor
nbTotalClones : the number of clones that will come out of the generator during the game
nbAdditionalElevators: the number of additional elevators that you can build
nbElevators : number of elevators in the area
nbElevators next lines: 2 integers elevatorFloor elevatorPos providing the floor and position of an elevator.

INPUT FOR ONE GAME TURN:
Line 1: 2 integers cloneFloor clonePos and one string direction. cloneFloor and clonePos are the coordinates of the leading unblocked clone. direction indicates the current direction of the leading clone:
LEFT the clone is moving towards the left
RIGHT the clone moving towards the right
If there is no leading clone, the line values are: -1 -1 NONE. This can happen only when the clones which are already outside are all blocked and the next clone is not out yet. In this case, you may output action WAIT.

OUTPUT FOR ONE GAME TURN:
A single line (including newline character) to indicate which action to take:
Either the keyword WAIT to do nothing.
or the keyword BLOCK to block the leading clone.
or the keyword ELEVATOR to build an elevator.

CONSTRAINTS:
1 <= nbFloors <= 15
5 <= width <= 100
10 <= nbRounds <= 200
0 <= exitFloor, elevatorFloor < nbFloors
0 <= exitPos , elevatorPos < width
-1 <= cloneFloor < nbFloors
-1 <= clonePos < width
2 <= nbTotalClones <= 50
0 <= nbAdditionalElevators <= 15
0 <= nbElevators <= 100
Duration of one game turn: 100 ms
Console output

