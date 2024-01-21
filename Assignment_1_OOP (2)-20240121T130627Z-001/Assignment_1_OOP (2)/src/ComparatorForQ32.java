import java.util.Comparator;
/**
 * second comparator for question 3, if 2 pieces did the same amount of squares will compare by their id.
 */
public class ComparatorForQ32 implements Comparator<ConcretePiece> {
    @Override
    public int compare(ConcretePiece o1, ConcretePiece o2) {
        if (o1.get_numberOfSquares() == o2.get_numberOfSquares() && o1.get_ID() < o2.get_ID()) {
            return -1;
        }
        if (o1.get_numberOfSquares() == o2.get_numberOfSquares() && o1.get_ID() > o2.get_ID()) {
            return 1;
        }
        return 0;
    }
}
