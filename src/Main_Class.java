import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;

public class Main_Class {
    public static void main(String[] args) {

        try {
            int size = Integer.decode(args[0]);
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

            ArrayList<Integer> list;

            list = QuickSorter.generateRandom(size);


            // writing values to the unsorted file
            for (Integer integer : list) {
                unsorted.write(integer + " ");
            }

            FIRST_ELEMENT = QuickSorter.timesQuickSort(list, QuickSorter.PivotStrategy.FIRST_ELEMENT);
            RANDOM_ELEMENT = QuickSorter.timesQuickSort(list, QuickSorter.PivotStrategy.RANDOM_ELEMENT);
            MEDIAN_OF_THREE_RANDOM_ELEMENTS = QuickSorter.timesQuickSort(list, QuickSorter.PivotStrategy.MEDIAN_OF_THREE_RANDOM_ELEMENTS);
            MEDIAN_OF_THREE_ELEMENTS = QuickSorter.timesQuickSort(list, QuickSorter.PivotStrategy.MEDIAN_OF_THREE_ELEMENTS);

            for (Integer integer : list) {
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
