package readerwriterproblemsolution;

import java.util.Scanner;
import java.util.concurrent.Semaphore;

/**
 *
 * @author amirh
 */
public class ReaderWriterProblemSolution {
    static int readerCount = 0;
    static Semaphore semaphore1 = new Semaphore(1);
    static Semaphore readSemaphore = new Semaphore(1);
    static Semaphore writeSemaphore = new Semaphore(1);

    public static void main(String[] args) throws Exception {
        Read read = new Read(semaphore1,readSemaphore,writeSemaphore,readerCount);
        Write write = new Write(semaphore1,readSemaphore,writeSemaphore,readerCount);
        
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Number Of Threads You Want !....");
        int numberOfThreads = input.nextInt();
        System.out.println("yyy");
        
        Thread[] threads = new Thread[numberOfThreads];
        for (int i = 0; i < numberOfThreads; i++) {
            threads[i] = new Thread(read);           
            threads[i] = new Thread(write);

        }
        for (int i = 0; i < threads.length; i++) 
            threads[i].start();
            
    }

}
