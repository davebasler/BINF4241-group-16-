# Assignment 4 <br/>
## 1.1. Description <br/>
We implemented the Singleton Design Pattern on our GameBoard class. This made the most sense because at the very beginning of the game we need to create exactly one instance of GameBoard. Through the Singleton Design Pattern it is now ensured that only one object can be created.<br/>
First we added a private instance variable and a private constructor method (which es empty) to the GameBoard class. Then we created the "getInstance" method, which checks if the instance variable is empty. In the case that it is true, it receives a new instance of GameBoard and returns it. In the end we added the synchronized keyword to this method in order to be extra safe in case of multiple threads. Finally the Main class calls the method "getInstance" in order to get a new gameboard (GameBoard gameboard = GameBoard.getInstance())<br/><br/><br/>
## 1.2. Class diagram <br/>
![class_diagram](https://github.com/davebasler/BINF4241-group-16-/blob/master/Assignment%204/ClassDiagram.PNG)

