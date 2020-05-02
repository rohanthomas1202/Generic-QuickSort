import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;

public class QuickSorter<E> {
    public static <E extends Comparable<E>> Duration timesQuickSort(ArrayList<E> list, PivotStrategy pivotStrategy) {


        if (list != null && pivotStrategy != null) {
            long startTime = System.nanoTime();

            if (pivotStrategy == PivotStrategy.FIRST_ELEMENT){
                System.out.println("First Element");
            }else if (pivotStrategy == PivotStrategy.RANDOM_ELEMENT){
                System.out.println("Random Element");
            }else if(pivotStrategy == PivotStrategy.MEDIAN_OF_THREE_RANDOM_ELEMENTS){
                System.out.println("Median of fthree random Element");
            }else if(pivotStrategy == PivotStrategy.MEDIAN_OF_THREE_ELEMENTS){
                System.out.println("Median of three elements");
            }

            timesQuickSort((ArrayList<Integer>) list, 0, list.size() - 1);

            return Duration.ofNanos((System.nanoTime() - startTime));
        } else if (list == null) {
            throw new NullPointerException("list is null");
        } else {
            throw new NullPointerException("not a valid pivot strategy");
        }


    }

    public static <E extends Comparable<E>> void timesQuickSort(ArrayList<Integer> list, int low, int high) {

        if (low < high) {
            int part_index = arr_part(list, low, high);

            timesQuickSort(list, low, part_index - 1);
            timesQuickSort(list, part_index + 1, high);
        }


    }

    static int arr_part(ArrayList<Integer> list, int low, int high) {
        int pivot = list.get(high);
        int i = (low - 1);
        for (int j = low; j < high; j++){
            if (list.get(j) < pivot){
                i++;
                int temp = list.get(i);
                list.set(i, list.get(j));
                list.set(j, temp);
            }
        }
        int temp = list.get(i + 1);
        list.set(i + 1, list.get(high));
        list.set(high, temp);

        return i + 1;
    }

    public static ArrayList<Integer> generateRandom(int size) {
        // checking if the size is positive
        if (size > 0) {
            long initial_time = System.nanoTime();

            // creating a new arraylist
            ArrayList<Integer> random_unsorted = new ArrayList<>(size);

            // populating the arraylist with values in order so that we do not get duplicates
            for (int i = 0; i < size; i++) {
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