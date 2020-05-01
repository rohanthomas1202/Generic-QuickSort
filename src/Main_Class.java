public class Main_Class {
    public static void main(String[] args) {
        int size = Integer.decode(args[0]);
        String report_file = args[1];
        String unsorted_file = args[2];
        String sorted_file = args[3];

        QuickSorter<Integer> quicksort = new QuickSorter<Integer>();


        System.out.println(size + 1);
        System.out.println(report_file);
        System.out.println(unsorted_file);
        System.out.println(sorted_file);


    }
}
