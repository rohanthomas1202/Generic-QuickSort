import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;

public class Main_Class {
    public static void main(String[] args) {

        try {
            int size = Integer.decode(args[0]);
            ArrayList<Integer> list_first;


            Duration FIRST_ELEMENT, RANDOM_ELEMENT, MEDIAN_OF_THREE_RANDOM_ELEMENTS, MEDIAN_OF_THREE_ELEMENTS;

            String report_file_name = args[1];
            File report_file = new File(report_file_name);
            if (!report_file.exists())
                report_file.createNewFile();
            FileWriter report = new FileWriter(report_file);


            String unsorted_file_name = args[2];
            File unsorted_file = new File(unsorted_file_name);
            if (!unsorted_file.exists())
                unsorted_file.createNewFile();
            FileWriter unsorted = new FileWriter(unsorted_file);


            String sorted_file_name = args[3];
            File sorted_file = new File(sorted_file_name);
            if (!sorted_file.exists())
                sorted_file.createNewFile();
            FileWriter sorted = new FileWriter(sorted_file);


            list_first = QuickSorter.generateRandom(size);
            // making four copies

            ArrayList<Integer> list_random = new ArrayList<>(list_first);
            ArrayList<Integer> list_MTR = new ArrayList<>(list_first);
            ArrayList<Integer> list_MT = new ArrayList<>(list_first);

            System.out.println("1");


            // writing values to the unsorted file
            for (Integer integer : list_first) {
                unsorted.write(integer + " ");
            }

            FIRST_ELEMENT = QuickSorter.timesQuickSort(list_first, QuickSorter.PivotStrategy.FIRST_ELEMENT);
            System.out.println("2");
            RANDOM_ELEMENT = QuickSorter.timesQuickSort(list_random, QuickSorter.PivotStrategy.RANDOM_ELEMENT);
            System.out.println("3");
            MEDIAN_OF_THREE_RANDOM_ELEMENTS = QuickSorter.timesQuickSort(list_MTR, QuickSorter.PivotStrategy.MEDIAN_OF_THREE_RANDOM_ELEMENTS);
            System.out.println("4");
            MEDIAN_OF_THREE_ELEMENTS = QuickSorter.timesQuickSort(list_MT, QuickSorter.PivotStrategy.MEDIAN_OF_THREE_ELEMENTS);
            System.out.println("5");

            sorted.write("Choosing first element as the pivot \n");
            for (Integer integer : list_first) {
                sorted.write(integer + " ");
            }

            sorted.write("\nChoosing a random element as the pivot \n");
            for (Integer integer : list_random) {
                sorted.write(integer + " ");
            }
            sorted.write("\nChoosing median of three random elements as the pivot \n");
            for (Integer integer : list_MTR) {
                sorted.write(integer + " ");
            }
            sorted.write("\nChoosing median of the first middle and last elements as the pivot \n");
            for (Integer integer : list_MT) {
                sorted.write(integer + " ");
            }




            report.write("Array Size = " + size + "\n");
            report.write("FIRST_ELEMENT : " + FIRST_ELEMENT + "\n");
            report.write("RANDOM_ELEMENT : " + RANDOM_ELEMENT + "\n");
            report.write("MEDIAN_OF_THREE_RANDOM _ELEMENTS : " + MEDIAN_OF_THREE_RANDOM_ELEMENTS + "\n");
            report.write("MEDIAN_OF_THREE_ELEMENTS : " + MEDIAN_OF_THREE_ELEMENTS + "\n");

            report.close();
            unsorted.close();
            sorted.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
