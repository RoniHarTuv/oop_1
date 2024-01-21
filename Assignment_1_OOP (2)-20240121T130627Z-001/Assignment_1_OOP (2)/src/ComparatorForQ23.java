import java.util.Comparator;
/**
 * third comparator for the second question. if the number of kills is the same and the id is the same, will compare by who won, thus who won is static.
 */
public class ComparatorForQ23 implements Comparator<ConcretePiece> {
    @Override
    public int compare(ConcretePiece o1, ConcretePiece o2) {
        if (o1.getNumberOfKills() == o2.getNumberOfKills() && o1.get_ID() == o2.get_ID() && o1.getOwner().isPlayerOne() && GameLogic.getWhoWon() == 1) {
            return -1;
        }
        if (o1.getNumberOfKills() == o2.getNumberOfKills() && o1.get_ID() == o2.get_ID() && !o1.getOwner().isPlayerOne() && GameLogic.getWhoWon() == 2) {
            return -1;
        }
        return 0;
    }
}
