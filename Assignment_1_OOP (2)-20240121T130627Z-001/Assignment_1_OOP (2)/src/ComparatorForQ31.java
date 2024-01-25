import java.util.Comparator;

/**
 * first comparator for question 3, will compare 2 pieces by the number of squares that this piece did.
 */
public class ComparatorForQ31 implements Comparator<ConcretePiece> {
    @Override
    public int compare(ConcretePiece o1, ConcretePiece o2) {
        if (o1.get_numberOfSquares() < o2.get_numberOfSquares()) {
            return 1;
        }
        if (o1.get_numberOfSquares() > o2.get_numberOfSquares()) {
            return -1;
        }
        return 0;
    }
}
