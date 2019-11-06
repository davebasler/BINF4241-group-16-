# Assignment 3 <br/>
## Part 1 <br/>
### 1.1. Description <br/>
We implemented the Singleton Design Pattern on our GameBoard class. This made the most sense because at the very beginning of the game we need to create exactly one instance of GameBoard. Through the Singleton Design Pattern it is now ensured that only one object can be created.<br/>
First we added a private instance variable and a private constructor method (which es empty) to the GameBoard class. Then we created the "getInstance" method, which checks if the instance variable is empty. In the case that it is true, it receives a new instance of GameBoard and returns it. In the end we added the synchronized keyword to this method in order to be extra safe in case of multiple threads. Finally the Main class calls the method "getInstance" in order to get a new gameboard (GameBoard gameboard = GameBoard.getInstance())<br/><br/><br/>
### 1.2. Class diagram <br/>
![class_diagram_singleton](https://github.com/davebasler/BINF4241-group-16-/blob/master/Assignment%203/class_diagram_singleton.PNG)

### 1.3. Sequence diagram <br/>
![class_diagram_singleton](https://github.com/davebasler/BINF4241-group-16-/blob/master/Assignment%203/sequence_diagram_singleton.PNG)
<br/>
### 2.1. Description <br/>
We have implemented the Iterator Pattern because we want to allow the PossibleMoves class to process every element of the squareslist while isolating the PossibleMoves class from the internal structure of the list. Additionally, the figure list operation is now more open for expansion (e.g., different types of lists like []).
First, we created the Iterator interface and its concrete class FigureIterator which both have the methods hasNext() and next(). Both this methods are implemented for the use of array lists as the figure lists consist of this type of list. In the PossibleMoves class we then call the createIterator() method which is implemented in the Figure abstract class and in all its descendants (e.g., pawn, tower,…). This way a new Iterator is created after every step in the loop of the method update_player_list, which then is used to update the list of the current player.
<br/>
### 2.2. Class diagram <br/>
![class_diagram_singleton](https://github.com/davebasler/BINF4241-group-16-/blob/master/Assignment%203/class_diagram_iterator.PNG)
### 2.3. Sequence diagram <br/>
![class_diagram_singleton](https://github.com/davebasler/BINF4241-group-16-/blob/master/Assignment%203/sequence_diagram_iterator.PNG)
<br/>
## Part 2 <br/>
### 1. Sequence diagram <br/>
![class_diagram_singleton](https://github.com/davebasler/BINF4241-group-16-/blob/master/Assignment%203/sequence_diagram_task2.PNG)
<br/>
Remark: this is just the general case for a figure. In more specific cases (e.g. if the pawn were the specific figure) there would be additional methods like for example "can_eat_diagonal()" in the sequence diagram. Also the special cases en passant, castling and switching the pawn at the end of the board would need the respective methods to be shown in the sequence diagram (e.g. small_rochade()).
## Part 3 <br/>
### 1. Description <br/>
For task 3 we chose to implement the third functionality. First, we created an interface (ScoreBoardInterface) with the method updateScorePlayer() which we then implemented in the observer class ScoreBoard. This class stores the respective score of player 1 (black figures) and player 2 (white figures) in two different instance variables which are incremented each time a figure of the opposite color gets eaten. The class also contains a second method displayScores() that prints the scores.
In our game implementation the class Move is the subject class that implements the methods registerObserver(), removeObserver() and notifyObserver() from the interface MoveInterface. The latter method updates all the observer contained in the list and has as input parameters the variables scorePlayer1 and scorePlayer2 which value is determined in the method eat_figure() each time a figure of the respective color is eaten. 
The call of the method  displayScores() is located in the main class and is as the name says responsible for printing the actual score of both players..
<br/>
## Notation <br/>
Standard user input should have the following format --> <br/>
**(letter of origin column)(digit of origin row)(letter of destination column)(digit of destination row)** <br/>
<br/> 
example: **a2a4** (move Pawn on a2 to a4) <br/> <br/> 
User input for special moves are the following: --><br/> 
Small rochade (castling): **0-0**<br/> 
Large rochade (castling): **0-0-0**

