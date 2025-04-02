// ## ListIterator
// - add
// - hasNext
// - hasPrevious
// - next
// - nextIndex
// - previous
// - previousIndex
// - remove
// - set

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ListIteratorMethods {

    public static void main(String[] args) {
        List<Integer> num = new ArrayList<>();

        num.add(1);
        num.add(2);
        num.add(3);
        num.add(4);
        num.add(5);
        num.add(6);
        num.add(7);
        num.add(8);
        num.add(9);
        num.add(10);
        ListIterator lt = num.listIterator();

        System.out.println("hasNext :" + lt.hasNext());
        System.out.println("hasPrevious :" + lt.hasPrevious());

        while (lt.hasNext()) {
            System.out.print(lt.next() + ", ");
        }

        num.set(2, 33);
        lt.remove();

        System.out.println();
        while (lt.hasPrevious()) {
            System.out.print(lt.previous() + ", ");
        }
    }
}
