/**
 * @(#)Timer.java
 *
 * Timer application
 *
 * @author
 * @version 1.00 2010/10/27
 */

public class Timer {

    public static void main(String[] args) {

    long startTime = System.nanoTime();

	int count = 100000;
	int i = 1;

	while (i <= count)
	{
		i = i * 2;
	}


	long finishTime = System.nanoTime();
	long elapsedTime = finishTime - startTime; // elapsed time in milliseconds

	System.out.println("");
	System.out.println("The elapsed time was" + " " + elapsedTime + " " + "Nanoseconds");
    }
}
