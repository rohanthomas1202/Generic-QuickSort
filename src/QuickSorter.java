import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;

public class QuickSorter<E> {
    // timesQuickSort calls the quick sort function and returns the time it took to do the sort
    public static <E extends Comparable<E>> Duration timesQuickSort(ArrayList<E> list, PivotStrategy pivotStrategy) {


        // checking for null list
        if (list != null && pivotStrategy != null) {
            long startTime = System.nanoTime();

            timesQuickSort((ArrayList<Integer>) list, 0, list.size() - 1, pivotStrategy);

            return Duration.ofNanos((System.nanoTime() - startTime));
        } else if (list == null) {
            throw new NullPointerException("list is null");
        } else {
            throw new NullPointerException("not a valid pivot strategy");
        }


    }

    public static <E extends Comparable<E>> void timesQuickSort(ArrayList<Integer> list, int lower_bound, int upper_bound, PivotStrategy pivotStrategy) {

        // check to see if the lower bound is to the left of the upper bound
        if (lower_bound < upper_bound) {
            // check to see which type of pivot to choose
            if (pivotStrategy == PivotStrategy.FIRST_ELEMENT) {
                // moving the first element to the end, to perform the quicksort operation
                //System.out.println("First Element");
                Integer temp = list.get(lower_bound);
                list.set(lower_bound, list.get(upper_bound));
                list.set(upper_bound, temp);
            } else if (pivotStrategy == PivotStrategy.RANDOM_ELEMENT) {
                // finding a random element and moving it to the very end of the list to perform quicksort
                //System.out.println("Random Element");
                int rand_index = lower_bound + (int) (Math.random() * ((upper_bound - lower_bound) + 1));
                Integer temp = list.get(rand_index);
                list.set(rand_index, list.get(upper_bound));
                list.set(upper_bound, temp);

            } else if (pivotStrategy == PivotStrategy.MEDIAN_OF_THREE_RANDOM_ELEMENTS) {
                // finding three random elements and taking the mean value of the three
                //System.out.println("Median of three random Element");
                int val_1 = lower_bound + (int) (Math.random() * ((upper_bound - lower_bound) + 1));
                int val_2 = lower_bound + (int) (Math.random() * ((upper_bound - lower_bound) + 1));
                int val_3 = lower_bound + (int) (Math.random() * ((upper_bound - lower_bound) + 1));

                ArrayList<Integer> val = new ArrayList<>();
                val.add(list.get(val_1));
                val.add(list.get(val_2));
                val.add(list.get(val_3));

                // getting the median of the  elements
                Collections.sort(val);
                int index = list.indexOf(val.get(1));
                Integer temp = list.get(index);
                list.set(index, list.get(upper_bound));
                list.set(upper_bound, temp);


            } else if (pivotStrategy == PivotStrategy.MEDIAN_OF_THREE_ELEMENTS) {
                // finding the median of the first middle elements and also the last element and shifting it to the end too do quicksort
                //System.out.println("Median of three elements");
                int val_1 = lower_bound;
                int val_2 = (lower_bound + upper_bound)/2;
                int val_3 = (upper_bound);

                ArrayList<Integer> values = new ArrayList<>();
                values.add(list.get(val_1));
                values.add(list.get(val_2));
                values.add(list.get(val_3));

                // getting the median of the  elements
                Collections.sort(values);
                int index = list.indexOf(values.get(1));
                Integer temp = list.get(index);
                list.set(index, list.get(upper_bound));
                list.set(upper_bound, temp);

            }
            int part_index = arr_part(list, lower_bound, upper_bound);

            timesQuickSort(list, lower_bound, part_index - 1, pivotStrategy);
            timesQuickSort(list, part_index + 1, upper_bound, pivotStrategy);
        }


    }

    // partitioning the subarray at each recursive step
    static int arr_part(ArrayList<Integer> list, int lower_bound, int upper_bound) {
        int pivot = list.get(upper_bound);
        int i = (lower_bound - 1);
        for (int j = lower_bound; j < upper_bound; j++) {
            if (list.get(j) < pivot) {
                i++;
                int temp = list.get(i);
                list.set(i, list.get(j));
                list.set(j, temp);
            }
        }
        int temp = list.get(i + 1);
        list.set(i + 1, list.get(upper_bound));
        list.set(upper_bound, temp);

        return i + 1;
    }

    // function to generate an arraylist with random unsorted values
    public static ArrayList<Integer> generateRandom(int size) {
        // checking if the size is positive
        if (size >= 0) {
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
            //System.out.println("Time taken is " + (System.nanoTime() - initial_time));
            // returning the un-sorted value
            return random_unsorted;
        } else {
            // if size is negative
            throw new IllegalArgumentException("size is negative");
        }


    }

    // enumeration to select which pivot strategy to use
    public enum PivotStrategy {
        FIRST_ELEMENT,
        RANDOM_ELEMENT,
        MEDIAN_OF_THREE_RANDOM_ELEMENTS,
        MEDIAN_OF_THREE_ELEMENTS,
    }

}