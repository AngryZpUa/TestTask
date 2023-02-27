package TestTask;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class MyIterator implements Iterator<Integer> {
    private final Iterator[] iterators;
    private TreeSet<String>iteratorElementsSet = new TreeSet(new MyComparator());

    public MyIterator(Iterator[] iterators) {
        this.iterators = iterators;
        for (int i=0; i< iterators.length; i++) {
            Iterator<Integer> currentIterator = iterators[i];
            if (currentIterator.hasNext()) {
                iteratorElementsSet.add(currentIterator.next() + ":" + i);
            }
        }
    }

    @Override
    public boolean hasNext() {
        return iteratorElementsSet.size() > 0;
    }

    @Override
    public Integer next() {
        if (iteratorElementsSet.size() == 0) return null;
        String current = iteratorElementsSet.iterator().next();
        String[] elementSplit = current.split(":");
        int key = Integer.parseInt(elementSplit[0]);
        int value = Integer.parseInt(elementSplit[1]);
        System.out.println(key + " (from A" + (value + 1) + ")");
        iteratorElementsSet.remove(current);
        if (iterators[value].hasNext()){
            iteratorElementsSet.add(iterators[value].next() + ":" + value);
        }
        return key;
    }

    class MyComparator implements Comparator<String> {
        @Override
        public int compare(String s, String t1) {
            String[] pairS = s.split(":");
            String[] pairT1 = t1.split(":");
            int keyS = Integer.parseInt(pairS[0]);
            int valueS = Integer.parseInt(pairS[1]);
            int keyT1 = Integer.parseInt(pairT1[0]);
            int valueT1 = Integer.parseInt(pairT1[1]);
            if (keyS!=keyT1) {
                return keyS-keyT1;
            }
            else {
                return valueS-valueT1;
            }
        }
    }
}
