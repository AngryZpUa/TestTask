package TestTask;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class App {
    private static final List<Integer> firstList = Arrays.asList(6, 8, 19, 21, 32, 66, 67, 77, 89);
    private static final List<Integer> secondList = Arrays.asList(1, 3, 5,  24, 33, 45, 57, 59, 89);
    private static final List<Integer> thirdList = Arrays.asList(2, 4, 9,  18, 22, 44, 46, 89, 89);
    private static final Iterator<Integer> firstListIterator = firstList.iterator();
    private static final Iterator<Integer> secondListIterator = secondList.iterator();
    private static final Iterator<Integer> thirdListIterator = thirdList.iterator();

    public static void main(String[] args) {
        Iterator[] iteratorsArray = {firstListIterator, secondListIterator, thirdListIterator};
        MyIterator myIterator = new MyIterator(iteratorsArray);
        ArrayList<Integer> result = new ArrayList();
        while (myIterator.hasNext()) {
            result.add(myIterator.next());
        }
        System.out.println(result);
    }
}
