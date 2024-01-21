import java.util.HashMap;

public class Position {
    //the fields of the class.
    public int _x; //is public because we use it a lot and don't have a problem that it's not private in privacy manners.
    public int _y;//is public because we use it a lot and don't have a problem that it's not private in privacy manners.
    private HashMap<ConcretePiece, Boolean> _hash = new HashMap<>(); //for p2q4.
    private boolean _wasChangedFor4 = false; //for p2q4.

    //the constructor of the class.
    public Position(int c, int r) {
        this._y = r;
        this._x = c;
    }

    /**
     * for p2q4, will set the pair like data structure with the piece that visit the position for the
     * first time. we want to check that the map in the key of the piece is null, this is how we know
     * how much pieces been in the position without adding ones that been there already.
     */
    public void setNumberOfP(ConcretePiece p) {
        if (_hash.get(p) == null) {
            _hash.put(p, true);
            _wasChangedFor4 = true;
        }
    }

    /**
     * to know how many pieces been in the cell we will return the size of the hash map because each pair
     * of piece and boolean value in the map represent a different piece that been in the position.
     */
    public Integer getNumberOfP() {
        return this._hash.size();
    }

    //to string method that overrides the object to string method.
    @Override
    public String toString() {
        return "(" + this._x + ", " + this._y + ")";
    }

    //the is_wasChangedFor4 getter.
    public boolean is_wasChangedFor4() {
        return this._wasChangedFor4;
    }

    //this method used for the undo function to remove the pair that we don't want to consider after the undo function.
    public void removeFromHash(ConcretePiece p) {
        this._hash.remove(p);
    }
}
