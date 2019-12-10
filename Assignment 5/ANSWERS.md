# Assignment 5 <br/>
## Part 1 <br/>
### 1.1. Description <br/>

## Part 2 <br/>
### 1. Descritpion <br/>
markTwice: this test failed because the mark method (in the class GameBoard) returned the opposite boolean value if the position was already marked and should have returned false in this case, so we changed the return value from true to **false**. <br/>
markOnBoard: this test failed because the mark method (in the class GameBoard) returned the opposite boolean value if the position was not already marked and should have returned true in this case, so we changed the return value from false to **true**. <br/>
getOpenPositions: this test failed because the getOpenPositions method (in the class GameBoard) did not consider the 0th column in the second for loop, so the returned list never contained the positions with columns 0. So we simply changed the initial value in the second for loop from 1 or 0 to fix the issue.<br/>
getOpenPositionsAll: this test failed for the same reason as above, so by changing 1 to 0 in the second for loop fixed this issue as well.<br/>
startingPlayerIsX: This test failed because the getCurrentPlayer method was returning player.O instead of the current player.
We modified the method so that it always return the current player.
<br/>
switchPlayer: This test failed for the same reason as startingPlayerIsX. The same modification fixed this as well.
<br/>
playSameLocation: This test failed because the getCurrentPlayer method initially set the currentPlayer variable to player.O.
By deleting this line the issue was resolved.
<br/>
isOverWin: This test failed because the isOver method returned the wrong boolean value whit the mistake coming from the hasWin method which returned false instead of true if the player has won. So we changed that.  
<br/>
hasWinRow: This test failed because the hasWin method returned the opposite boolean value if the row was complete.
Same fix as before.
<br/>
hasWinCol: This test failed because the hasWin method returned the opposite boolean value if the column was complete.
Same fix as before.
<br/>
hasWinDiagonal: This test failed because the hasWin method returned the opposite boolean value if the diagonal was complete.
So we changed we added a negation (!) to the completesDiagonal method.
<br/>
## Part 3 <br/>
### 1. Description <br/>


