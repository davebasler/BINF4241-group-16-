# Assignment 5 <br/>
## Part 1 <br/>
### 1.1. Description <br/>

## Part 2 <br/>
### 1. Descritpion <br/>
markTwice: this test failed because the mark method (in the class GameBoard) returned the opposite boolean value if the position was already marked and should have returned false in this case, so we changed the return value from true to **false**. <br/>
markOnBoard: this test failed because the mark method (in the class GameBoard) returned the opposite boolean value if the position was not already marked and should have returned true in this case, so we changed the return value from false to **true**. <br/>
getOpenPositions: this test failed because the getOpenPositions method (in the class GameBoard) did not consider the 0th column in the second for loop, so the returned list never contained the positions with columns 0. So we simply changed the initial value in the second for loop from 1 or 0 to fix the issue.<br/>
getOpenPositionsAll: this test failed for the same reason as above, so by changing 1 to 0 in the second for loop fixed this issue as well.<br/>

## Part 3 <br/>
### 1. Description <br/>


