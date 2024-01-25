public class King extends ConcretePiece {
    //this class represent the king of the game, extends all the methods of ConcretePiece class.
    public King(Position p, int id, ConcretePlayer owner, String type) {
        super(p, id, owner, type);
    }
    @Override
    public String toString(){
        return "K7:";
    }
}
