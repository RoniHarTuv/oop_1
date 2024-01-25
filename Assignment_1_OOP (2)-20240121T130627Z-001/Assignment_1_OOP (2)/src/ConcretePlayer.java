public class ConcretePlayer implements Player {
    // the fields of the player:
    private int _num;
    public int _wins;

    //the constructor of the class.
    public ConcretePlayer(int num) {
        this._num = num;
        this._wins = 0;
    }

    //will check if the player is player one by comparing the _num of the player object.
    @Override
    public boolean isPlayerOne() {
        return this._num == 1;
    }

    //will return the number of wins of the player that we check.
    @Override
    public int getWins() {
        return this._wins;
    }
    //will return the number of the player that we check.
    public int getNum() {
        return this._num;
    }
}
