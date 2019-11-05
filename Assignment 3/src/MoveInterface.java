public interface MoveInterface{
    void registerObserver(ScoreBoard scoreBoard);
    void removeObserver(ScoreBoard scoreBoard);
    void notifyObserver(int scorePlayer1, int scorePlayer2);
}
