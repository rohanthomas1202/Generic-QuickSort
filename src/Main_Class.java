import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;

public class Main_Class {
    public static void main(String[] args) {

        // checking if we can open every file
        try {
            // getting size of array from arguments
            int size = Integer.decode(args[0]);
            ArrayList<Integer> list_first;


            // creating required variables of type duration to keep track of time
            Duration FIRST_ELEMENT, RANDOM_ELEMENT, MEDIAN_OF_THREE_RANDOM_ELEMENTS, MEDIAN_OF_THREE_ELEMENTS;

            // getting the report file name from arguments
            String report_file_name = args[1];
            File report_file = new File(report_file_name);
            if (!report_file.exists())
                report_file.createNewFile();
            FileWriter report = new FileWriter(report_file);


            // getting the unsorted file name from arguents
            String unsorted_file_name = args[2];
            File unsorted_file = new File(unsorted_file_name);
            if (!unsorted_file.exists())
                unsorted_file.createNewFile();
            FileWriter unsorted = new FileWriter(unsorted_file);


            // getting the sorted file name from arguments
            String sorted_file_name = args[3];
            File sorted_file = new File(sorted_file_name);
            if (!sorted_file.exists())
                sorted_file.createNewFile();
            FileWriter sorted = new FileWriter(sorted_file);


            // getting an unsorted arrayList
            list_first = QuickSorter.generateRandom(size);

            // making four copies for each type of pivots
            ArrayList<Integer> list_random = new ArrayList<>(list_first);
            ArrayList<Integer> list_MTR = new ArrayList<>(list_first);
            ArrayList<Integer> list_MT = new ArrayList<>(list_first);


            // writing values to the unsorted file
            for (Integer integer : list_first) {
                unsorted.write(integer + " ");
            }

            FIRST_ELEMENT = QuickSorter.timesQuickSort(list_first, QuickSorter.PivotStrategy.FIRST_ELEMENT);
            RANDOM_ELEMENT = QuickSorter.timesQuickSort(list_random, QuickSorter.PivotStrategy.RANDOM_ELEMENT);
            MEDIAN_OF_THREE_RANDOM_ELEMENTS = QuickSorter.timesQuickSort(list_MTR, QuickSorter.PivotStrategy.MEDIAN_OF_THREE_RANDOM_ELEMENTS);
            MEDIAN_OF_THREE_ELEMENTS = QuickSorter.timesQuickSort(list_MT, QuickSorter.PivotStrategy.MEDIAN_OF_THREE_ELEMENTS);



            // writing values to the sorted file
            sorted.write("Choosing first element as the pivot \n");
            for (Integer integer : list_first) {
                sorted.write(integer + " ");
            }

            // writing values to the sorted file
            sorted.write("\nChoosing a random element as the pivot \n");
            for (Integer integer : list_random) {
                sorted.write(integer + " ");
            }

            // writing values to the sorted file
            sorted.write("\nChoosing median of three random elements as the pivot \n");
            for (Integer integer : list_MTR) {
                sorted.write(integer + " ");
            }

            // writing values to the sorted file
            sorted.write("\nChoosing median of the first middle and last elements as the pivot \n");
            for (Integer integer : list_MT) {
                sorted.write(integer + " ");
            }


            // printing the report to the report file
            report.write("Array Size = " + size + "\n");
            report.write("FIRST_ELEMENT : " + FIRST_ELEMENT + "\n");
            report.write("RANDOM_ELEMENT : " + RANDOM_ELEMENT + "\n");
            report.write("MEDIAN_OF_THREE_RANDOM _ELEMENTS : " + MEDIAN_OF_THREE_RANDOM_ELEMENTS + "\n");
            report.write("MEDIAN_OF_THREE_ELEMENTS : " + MEDIAN_OF_THREE_ELEMENTS + "\n");

            // closing all three files
            report.close();
            unsorted.close();
            sorted.close();
        } catch (IOException e) {
            // if either of the files is unusable
            e.printStackTrace();
        }

    }

}
