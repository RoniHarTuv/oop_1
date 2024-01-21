import java.util.ArrayList;

public class ConcretePiece implements Piece {
    //the fields of the class:
    protected Position _position;
    private final int _ID;
    private final ConcretePlayer _OWNER;
    private final String _TYPE;
    private ArrayList<Position> _steps = new ArrayList<>(); //for p2q1
    private int _numberOfKills;//for p2q2
    private int _inWhichTurnWasEaten; //for undo
    private int _numberOfSquares; //for p2q3
    private String[] _neighbors = new String[4]; // the neighbors of the piece as a string array.


    //The constructor of the ConcretePiece class.
    public ConcretePiece(Position p, int id, ConcretePlayer owner, String type) {
        this._ID = id;
        this._position = p;
        this._OWNER = owner;
        this._TYPE = type;
    }

    //will return the owner of the ConcretePiece.
    @Override
    public ConcretePlayer getOwner() {
        return this._OWNER;
    }

    //will return the type of the ConcretePiece
    @Override
    public String getType() {
        return this._TYPE;
    }

    //will return the id of the ConcretePiece
    public int get_ID() {
        return this._ID;
    }

    //will add the position that is given as input to the steps arraylist for p2q1.
    public void addStep(Position p) {
        this._steps.add(new Position(p._x,p._y));
    }

    // the getter of the steps array.
    public ArrayList<Position> get_Steps() {
        return this._steps;
    }

    //to string method that overrides the object method.
    @Override
    public String toString() {
        if (this.getOwner().getNum() == 1) {
            return "D" + this._ID + ":";
        } else {
            return "A" + this._ID + ":";
        }
    }

    //will return the number of kills of the concretePiece. for p2q2.
    public int getNumberOfKills() {
        return this._numberOfKills;
    }

    //will increase the number of kills of a piece by 1. for p2q2.
    public void increaseNumberOfKills() {
        this._numberOfKills++;
    }

    //will decease the number of kills by 1, for the undo function , for p2q2.
    public void decreaseNumberOfKills() {
        this._numberOfKills--;
    }

    //will set the turn in which the piece was eaten in the game. for the undo method.
    public void setTurnWasEaten(int a) {
        this._inWhichTurnWasEaten = a;
    }

    //will get the turn in which the piece was eaten in the game. for the undo method.
    public int getTurnWasEaten() {
        return this._inWhichTurnWasEaten;
    }

    //will return the number of squares that a piece did in the game. for p2q3.
    public int get_numberOfSquares() {
        return this._numberOfSquares;
    }

    //will increase the number of squares by the "distance" between the cells in the game logic class. for p2q3.
    public void set_numberOfSquares(int n) {
        this._numberOfSquares += n;
    }

    //will increase the number of squares by the "distance" between the cells in the game logic class. for p2q3, undo method.
    public void undo_numberOfSquares(int n) {
        this._numberOfSquares = this._numberOfSquares - n;
    }

    //will return the neighbors array of the piece. _neighbors[0]=u,_neighbors[0]=d,_neighbors[0]=r,_neighbors[0]=l.
    // can be one of the pawns, the king, the wall, the corners.
    public String[] get_n() {
        return this._neighbors;
    }

    //will set neighbors array of the piece. _neighbors[0]=u,_neighbors[0]=d,_neighbors[0]=r,_neighbors[0]=l.
    // can be one of the pawns, the king, the wall, the corners.
    public void set_n(String u, String d, String r, String l) {
        this._neighbors[0] = u;
        this._neighbors[1] = d;
        this._neighbors[2] = r;
        this._neighbors[3] = l;
    }
}

