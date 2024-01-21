import java.util.Comparator;
import java.util.Map;

/**
 * first comparator for question number 4. will compare 2 pair like data structures by the value of the pair.
 * the value of the pair represent the number of different pieces that was in that cell.
 */
public class ComparatorQ41 implements Comparator<Map.Entry<Position, Integer>> {
    public int compare(Map.Entry<Position, Integer> o1, Map.Entry<Position, Integer> o2) {
        if (o1.getValue() > o2.getValue()) {
            return -1;
        }
        if (o1.getValue() < o2.getValue()) {
            return 1;
        }
        return 0;
    }
}
