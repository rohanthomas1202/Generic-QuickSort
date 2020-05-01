import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;

public class QuickSorter<E> {
    public static <E extends Comparable<E>> Duration timesQuickSort(ArrayList<E> list, PivotStrategy pivotStrategy) {
        long startTime = System.nanoTime();


        if (list != null && pivotStrategy != null) {
            Collections.sort(list);
        } else if (list == null) {
            throw new NullPointerException("list is null");
        } else{
            throw new NullPointerException("not a valid pivot strategy");
        }


        return Duration.ofNanos((System.nanoTime() - startTime));
    }

    public static ArrayList<Integer> generateRandom(int size) {
        // checking if the size is positive
        if (size > 0) {
            long initial_time = System.nanoTime();

            // creating a new arraylist
            ArrayList<Integer> random_unsorted = new ArrayList<>(size);

            // populating the arraylist with values in order so that we do not get duplicates
            for (int i = 0; i <= size; i++) {
                random_unsorted.add(i + 1);
            }
            // un-sorting the values in the ArrayList
            Collections.shuffle(random_unsorted);
            Collections.shuffle(random_unsorted);
            System.out.println("Time taken is " + (System.nanoTime() - initial_time));
            // returning the un-sorted value
            return random_unsorted;
        } else if (size < 0) {
            // if size is negative
            throw new IllegalArgumentException("size is negative");
        } else {
            // if size is zero
            throw new IllegalArgumentException("size is zero");
        }

    }

    public enum PivotStrategy {
        FIRST_ELEMENT,
        RANDOM_ELEMENT,
        MEDIAN_OF_THREE_RANDOM_ELEMENTS,
        MEDIAN_OF_THREE_ELEMENTS,
    }

}