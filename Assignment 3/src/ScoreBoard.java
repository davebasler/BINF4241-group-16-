public class ScoreBoard implements ScoreBoardInterface{

    private int scorePlayer1;
    private int scorePlayer2;

    public ScoreBoard(){
        this.scorePlayer1 = 0;
        this.scorePlayer2 = 0;
    }

    @Override
    public void updateScorePlayer(int scorePlayer1, int scorePlayer2) {
        this.scorePlayer1 += scorePlayer1;
        this.scorePlayer2 += scorePlayer2;
    }

    public void displayScores(){
        System.out.println("Player 1, score: " + this.scorePlayer1 + " - Player 2, score: " + this.scorePlayer2);
    }
}
