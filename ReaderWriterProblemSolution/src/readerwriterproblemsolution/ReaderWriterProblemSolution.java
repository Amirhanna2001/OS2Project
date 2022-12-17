package readerwriterproblemsolution;

import java.util.Scanner;

/**
 *
 * @author amirh
 */
public class ReaderWriterProblemSolution {
    public static void main(String[] args) throws InterruptedException {
        final ReaderWriter rw= new ReaderWriter();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Number Of Threads You Want !....");
        int numberOfThreads = input.nextInt();
        
        
        Thread[] threads = new Thread[numberOfThreads];
        for (int i = 0; i < numberOfThreads; i++) {
            threads[i] = new Thread(() -> { //lamdba  
                try {
                rw.reader();
                rw.writer();
                
            } catch (InterruptedException e) {
                e.printStackTrace(); //for print if any exception happened 
            }
            });
        }
        
        for (int i = 0; i < threads.length; i++){
             threads[i].start() ;
             threads[i].join();
        } 
           

    }

    }
    

