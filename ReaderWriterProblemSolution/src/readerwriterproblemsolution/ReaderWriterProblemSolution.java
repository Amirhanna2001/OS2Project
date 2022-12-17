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
                rw.readerEnter();
                rw.writerEnter();
                rw.readerExit();
                rw.writerExit();
            } catch (InterruptedException e) {
                e.printStackTrace(); //for print if any exception happened 
            }
            });
        }
        
        for (int i = 0; i < threads.length; i++){
             threads[i].start() ;
//             threads[i].join();
        } 
           
//        
//        
//        for (int i = 0; i < threads.length; i++) 
//            threads[i].join();
//            
        
//        Thread t1= new Thread(() -> {//using lamdba exp
//            try {
//                rw.readerEnter();
//                rw.writerEnter();
//                rw.readerExit();
//                rw.writerExit();
//            } catch (InterruptedException e) {
//                e.printStackTrace();//for print if any exception happened 
//            }
//        });
//        
//        Thread t2 =new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    rw.readerEnter();
//                    rw.writerEnter();
//                    rw.readerExit();
//                    rw.writerExit();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        Thread t3= new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    rw.readerEnter();
//                rw.writerEnter();
//                rw.readerExit();
//                rw.writerExit();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        Thread t4= new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    rw.readerEnter();
//                rw.writerEnter();
//                rw.readerExit();
//                rw.writerExit();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        
//        
//        Thread t5= new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    rw.readerEnter();
//                rw.writerEnter();
//                rw.readerExit();
//                rw.writerExit();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });

//        t1.start();
//        t2.start();
//        t3.start();
//        t4.start();
//        t5.start();
//        t1.join();
//        t3.join();
//        t2.join();
//        t4.join();
//        t5.join();
        //boinded !!!!
    }

    }
    

