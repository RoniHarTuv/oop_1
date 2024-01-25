import java.util.Comparator;

/**
 * second comparator for the second question. if the number of kills is the same will compare by the id.
 */
public class ComparatorForQ22 implements Comparator<ConcretePiece> {
    @Override
    public int compare(ConcretePiece o1, ConcretePiece o2) {
        if (o1.getNumberOfKills() == o2.getNumberOfKills() && o1.get_ID() > o2.get_ID()) {
            return 1;
        }
        if (o1.getNumberOfKills() == o2.getNumberOfKills() && o1.get_ID() < o2.get_ID()) {
            return -1;
        }
        return 0;
    }
}
