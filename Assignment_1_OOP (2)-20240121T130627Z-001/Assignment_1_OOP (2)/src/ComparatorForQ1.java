import java.util.Comparator;

/**
 * first comparator for question 1, will compare 2 pieces by the size of the steps array.
 */
public class ComparatorForQ1 implements Comparator<ConcretePiece> {
    @Override
    public int compare(ConcretePiece o1, ConcretePiece o2) {
        if (o1.get_Steps().size() > o2.get_Steps().size()) {
            return 1;
        }
        if (o1.get_Steps().size() < o2.get_Steps().size()) {
            return -1;
        }
        return 0;
    }
}
