import java.util.Comparator;
import java.util.Map;
/**
 * second comparator for question number 4. if the number of the different pieces that was on a cell was the same , and the x values of the positions is the same ,
 * will compare by the y value.
 */
public class ComparatorQ43 implements Comparator<Map.Entry<Position, Integer>> {
    public int compare(Map.Entry<Position, Integer> o1, Map.Entry<Position, Integer> o2) {
        if (o1.getValue() == o2.getValue() && o1.getKey()._x == o2.getKey()._x && o1.getKey()._y < o2.getKey()._y) {
            return -1;
        }
        if (o1.getValue() == o2.getValue() && o1.getKey()._x == o2.getKey()._x && o1.getKey()._y > o2.getKey()._y) {
            return 1;
        }
        return 0;
    }
}