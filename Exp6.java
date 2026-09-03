import java.util.*;

public class OptimalStorageOnTape {

    public static void main(String[] args) {

        int[] files = {10, 5, 15, 15, 20, 25, 30, 20};

        // Sort files in increasing order
        Arrays.sort(files);

        int totalRetrievalTime = 0;
        int currentTime = 0;

        System.out.println("Optimal order:");

        for (int file : files) {
            currentTime += file;
            totalRetrievalTime += currentTime;

            System.out.print(file + " ");
        }

        double mrt = (double) totalRetrievalTime / files.length;

        System.out.println("\n\nTotal Retrieval Time = " + totalRetrievalTime);
        System.out.println("Mean Retrieval Time = " + mrt);
    }
}