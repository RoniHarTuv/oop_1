import java.util.Comparator;

/**
 * third comparator for the third question. if the number of squares is the same and the id is the same, will compare by who won, thus who won is static.
 */
public class ComparatorForQ33 implements Comparator<ConcretePiece> {
    @Override
    public int compare(ConcretePiece o1, ConcretePiece o2) {
        if (o1.get_numberOfSquares() == o2.get_numberOfSquares() && o1.get_ID() == o2.get_ID() && o1.getOwner().isPlayerOne() && GameLogic.getWhoWon() == 1) {
            return -1;
        }
        if (o1.get_numberOfSquares() == o2.get_numberOfSquares() && o1.get_ID() == o2.get_ID() && !o1.getOwner().isPlayerOne() && GameLogic.getWhoWon() == 2) {
            return -1;
        }
        return 0;
    }
}
