/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package readerwriterproblemsolution;

import java.util.concurrent.Semaphore;

/**
 *
 * @author amirh
 */
public class Write implements Runnable{
static int readerCount;
    static Semaphore semaphore1;
    static Semaphore readSemaphore;
    static Semaphore writeSemaphore ;
    
    public Write(Semaphore s1,Semaphore s2,Semaphore s3 ,int rc){
        semaphore1 = s1;       
        readSemaphore = s2; 
        writeSemaphore = s3;
        readerCount = rc;

    }
        @Override
        public void run() {
//            while(true){
                try {
                readSemaphore.acquire();
                writeSemaphore.acquire();
                System.out.println(Thread.currentThread().getName() + " is WRITING");
                Thread.sleep(2500);
                System.out.println(Thread.currentThread().getName() + " has finished WRITING");
                writeSemaphore.release();
                readSemaphore.release();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
//            }
            
        }
}