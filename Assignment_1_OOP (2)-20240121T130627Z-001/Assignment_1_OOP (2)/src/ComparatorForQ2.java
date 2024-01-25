import java.util.Comparator;

/**
 * firs comparator for question 2, will compare 2 pieces by the number of kills.
 */
public class ComparatorForQ2 implements Comparator<ConcretePiece> {
    @Override
    public int compare(ConcretePiece o1, ConcretePiece o2) {
        if (o1.getNumberOfKills() > o2.getNumberOfKills()) {
            return -1;
        }
        if (o1.getNumberOfKills() < o2.getNumberOfKills()) {
            return 1;
        }
        return 0;
    }
}
