# Assignment 5 <br/>
## Part 1 <br/>
### 1.1. Description <br/>

## Part 2 <br/>
### 2.1. Descritpion <br/>
markTwice: this test failed because the mark method (in the class GameBoard) returned the opposite boolean value if the position was already marked and should have returned false in this case, so we changed the return value from true to **false**. <br/><br/>
markOnBoard: this test failed because the mark method (in the class GameBoard) returned the opposite boolean value if the position was not already marked and should have returned true in this case, so we changed the return value from false to **true**. <br/><br/>
getOpenPositions: this test failed because the getOpenPositions method (in the class GameBoard) did not consider the 0th column in the second for loop, so the returned list never contained the positions with columns 0. So we simply changed the initial value in the second for loop from 1 or 0 to fix the issue.<br/><br/>
getOpenPositionsAll: this test failed for the same reason as above, so by changing 1 to 0 in the second for loop fixed this issue as well.<br/><br/>
startingPlayerIsX: This test failed because the getCurrentPlayer method was returning player.O instead of the current player.
We modified the method so that it always return the current player.
<br/><br/>
switchPlayer: This test failed for the same reason as startingPlayerIsX. The same modification fixed this as well.
<br/><br/>
playSameLocation: This test failed because the getCurrentPlayer method initially set the currentPlayer variable to player.O.
By deleting this line the issue was resolved.
<br/><br/>
isOverWin: This test failed because the isOver method returned the wrong boolean value whit the mistake coming from the hasWin method which returned false instead of true if the player has won. So we changed that.  
<br/><br/>
hasWinRow: This test failed because the hasWin method returned the opposite boolean value if the row was complete.
Same fix as before.
<br/><br/>
hasWinCol: This test failed because the hasWin method returned the opposite boolean value if the column was complete.
Same fix as before.
<br/><br/>
hasWinDiagonal: This test failed because the hasWin method returned the opposite boolean value if the diagonal was complete.
So we changed we added a negation (!) to the completesDiagonal method.
<br/><br/>
## Part 3 <br/>
### 3.1. System behavior <br/>
**a.** A player initially has 7 cards. If he has one or more cards which can be placed on the discard pile he has 2 options: place a correct card or draw a new card (inputs "place card" and "draw"). Otherwise he always has two draw a card. Assume a player has a card that matches with the card on the discard pile (e.g. Green and 8) and decides to place it. Than the player gives as input "place card" followed by the specific card in his deck (input in this example would be "g, 8"). If a player has no matching cards and wants to place a card, the input "place card" will not be accepted. In this case he has to give the input "draw" to draw a new card from the draw pile. Also not accepted should be a non matching card (e.g. red 5 and blue 2). <br/>
A player can place an action card as well (input e.g. "wild", "wild4", "take2" etc.) and in the case that the color can be changed ("wild" and "wild4") the player has to enter the new desired color as input (e.g. "blue, "red" etc.). In the case that a player is supposed to draw cards, he has the option to give the input "challenge" to challenge the previous player.
<br/> If a player only has 1 card left, he has the option to give an input "uno", which is required to win the game.<br/>
Any other inputs which aren't defined (e.g. wrong input type) should not be accepted and the user has to provide a new input (repeats until a correct input is given).<br/><br/>
**b.** Whenever a player chooses the input "draw", the top card of the draw pile is poped and added to the players deck. If the input is "place card" then the respective card is deleted from the players deck and pushed on the discard pile. In any other case in which a non accepting input is given (see a.) a while loop ensured that the user can enter a new input until it is accepted.<br/>
If a action card is placed the system has to ensure that the specific action is performed (e.g. the next user has to draw 4 new cards or the color is set to the desired color of the previous player).<br/>
If someone places his last card (and previously "said" UNO) the system will print the winners name and terminates the game loop.
<br/><br/>
**c** Whenever an accepting input was given, the output will be the updated current top card of the discard pile and the current cards of the next player. If a non accepting input is given the output will be a message (e.g. "this card doesn't match with the top card of the discard pile"). If a player wins the game ends and the output will be the winners name (e.g. "Player 1 wins!").<br/>
If the input was wrong the output should never not print a error message.
<br/><br/>
### 3.2. Class diagram <br/>
![class_diagram]https://github.com/davebasler/BINF4241-group-16-/blob/master/Assignment%205/UNO_classdiagram.PNG

