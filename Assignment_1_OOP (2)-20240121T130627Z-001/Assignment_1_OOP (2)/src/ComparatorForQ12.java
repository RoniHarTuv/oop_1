import java.util.Comparator;

/**
 * send comparator for question 1, if 2 pieces did the same amount of steps, they will be compared by the number of their id.
 */
public class ComparatorForQ12 implements Comparator<ConcretePiece> {
    @Override
    public int compare(ConcretePiece o1, ConcretePiece o2) {
        if (o1.get_Steps().size() == o2.get_Steps().size() && o1.get_ID() > o2.get_ID()) {
            return 1;
        }
        if (o1.get_Steps().size() == o2.get_Steps().size() && o1.get_ID() < o2.get_ID()) {
            return -1;
        }
        return 0;
    }
}
