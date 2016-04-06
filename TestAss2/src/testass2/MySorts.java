package testass2;

import java.util.Scanner;

public class MySorts {

    // Array of Bikes, Seriously.
    public static void main(String[] args) {
        Bike[] bikes = new Bike[13];
        bikes[0] = new Bike("Mountain", "Raliagh", 10, 22, 250.00);
        bikes[1] = new Bike("Mountain", "Raliagh", 12, 20, 260.99);
        bikes[2] = new Bike("Racer", "Kona", 14, 22, 260.50);
        bikes[3] = new Bike("Street", "Getz", 12, 23, 350.67);
        bikes[4] = new Bike("Street", "Freespirit", 10, 23, 157.42);
        bikes[5] = new Bike("Racer", "Kona", 12, 20, 345.87);
        bikes[6] = new Bike("Mountain", "Freespirit", 15, 20, 234.53);
        bikes[7] = new Bike("Racer", "Professional", 14, 22, 328.78);
        bikes[8] = new Bike("Street", "Getz", 14, 22, 328.78);
        bikes[9] = new Bike("Racer", "Professional", 15, 22, 228.78);
        bikes[10] = new Bike("Bmx", "Federal", 10, 24, 528.78);
        bikes[11] = new Bike("Racer", "Abola", 12, 20, 344.78);
        bikes[12] = new Bike("Mountain", "Scrap", 14, 22, 167.78);
        Scanner sc = new Scanner(System.in);

        // Menu for selecting a Sort
        System.out.println("1. Insertion Sort");
        System.out.println("2. Merge Sort");
        System.out.println("3. Quick Sort");
        System.out.println("Please enter 1, 2 or 3 for you choice:  ");
        // Scans in the User input,
        int srt = sc.nextInt();

        // Switch statement to Call sort method
        // and pass in the array of bikes and any
        // other paramaters.
        switch (srt) {
            case 1: {
                System.out.println("\n" + "You choose Insertion sort" + "\n");
                insertionSort(bikes);
                break;
            }
            case 2: {
                System.out.println("\n" + "You have chosen Merge Sort" + "\n");
                mergeSort(bikes, 0, bikes.length - 1);
                break;
            }
            case 3: {
                System.out.println("\n" + "You have chosen Quick Sort" + "\n");
                quickSort(bikes, 0, bikes.length - 1);
                break;
            }
            default:
                System.out.println("Please enter 1,2 or 3");

        }
    }

    public static <T extends Comparable<? super T>> void quickSort(T[] data, int min, int max) {
        int indexofpartition;
        long st = System.currentTimeMillis();       // Start Time
        

        if (max - min > 0) {
            /** Create partitions */
            indexofpartition = findPartition(data, min, max);

            /** Sort the left side */
            quickSort(data, min, indexofpartition - 1);


            /** Sort the right side */
            quickSort(data, indexofpartition + 1, max);
           
        }

    }

    private static <T extends Comparable<? super T>> int findPartition(T[] data, int min, int max) {
        int left, right;
        T temp, partitionelement;
        int pivot = min;
        int count = 0;
        long st = System.currentTimeMillis();       // Start Time

        partitionelement = data[pivot]; // use middle element as partition
        left = min;
        right = max;

        while (left < right) {
            /** search for an element that is > the partitionelement */
            while (data[left].compareTo(partitionelement) <= 0
                    && left < right) {
                left++;
            }
            /** search for an element that is < the partitionelement */
            while (data[right].compareTo(partitionelement) > 0) {
                right--;
            }

            /** swap the elements  */
            if (left < right) {
                temp = data[left];
                data[left] = data[right];
                data[right] = temp;
            }
            count++;
        }
        printList(data);
        long et = System.currentTimeMillis();       // End time
        long ext = et - st;
        System.out.println("\n" + "This Sort took: " + ext + " Milliseconds");
        System.out.println("This Sort iterated: " + count + " Times" + "\n");

        /** move partition element to partition index*/
        temp = data[min];
        data[min] = data[right];
        data[right] = temp;

        return right;


    }

    public static <T extends Comparable<? super T>> void mergeSort(T[] data, int min, int max) {
        T[] temp;
        int index1, left, right;
        long st = System.currentTimeMillis();       // Start Time
        int count = 0;

        // Return on list of length one
        if (min == max) {
            return;
        }

        // Find the length and the midpoint of the list
        int size = max - min + 1;
        int pivot = (min + max) / 2;
        temp = (T[]) (new Comparable[size]);
        mergeSort(data, min, pivot); // Sort left half of list

        mergeSort(data, pivot + 1, max); // Sort right half of list


        /** copy sorted data into workspace */
        for (index1 = 0; index1 < size; index1++) {
            temp[index1] = data[min + index1];
        }

        /** merge the two sorted lists */
        left = 0;
        right = pivot - min + 1;
        for (index1 = 0; index1 < size; index1++) {
            if (right <= max - min) {
                if (left <= pivot - min) {
                    if (temp[left].compareTo(temp[right]) > 0) {
                        data[index1 + min] = temp[right++];
                    } else {
                        data[index1 + min] = temp[left++];
                    }
                } else {
                    data[index1 + min] = temp[right++];
                }
            } else {
                data[index1 + min] = temp[left++];
            }
            count++;
        }

        printList(data);     // Prints out Sorted Array
        // The timing and print out or time and interations
        long et = System.currentTimeMillis();       // End time
        long ext = et - st;
        System.out.println("\n" + "This step of the sort took: " + ext + " Milliseconds");
        System.out.println("This step of the sort iterated: " + count + " Times" + "\n");
    }

    public static <T extends Comparable<? super T>> void insertionSort(T[] data) {
        int position, count;
        count = 0;
        T temp;

        long st = System.currentTimeMillis();       // Start time
        for (int index = 1; index < data.length; index++) {
            temp = data[index];// copy item to deal with
            position = index;
            // move items up to make space for the item
            while (position > 0 && data[position - 1].compareTo(temp) > 0) {
                //move item up
                data[position] = data[position - 1];
                position--;
            }
            data[position] = temp;
            printList(data);// put item into position
            count++;        // Loop for counting No. of times array is sorted


        }

        long et = System.currentTimeMillis();       // End Time
        long ext = et - st;
        // Print statements for time and Iterations
        System.out.println(" ");
        System.out.println("The sort made" + " " + count + " " + "passes");
        System.out.println("This sort took" + " " + ext + " " + "Miliseconds");
    }

    private static <T extends Comparable<? super T>> void printList(T[] data) {

        // For loop to print out array of Bikes
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + "\n");
        }
        System.out.println("");
    }
}
