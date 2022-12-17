package readerwriterproblemsolution;
import java.util.concurrent.Semaphore;

/**
 *
 * @author amirh
 */
class Read implements Runnable {
    static int readerCount;
    static Semaphore semaphore1;
    static Semaphore readSemaphore;
    static Semaphore writeSemaphore ;
    
    public Read(Semaphore s1,Semaphore s2,Semaphore s3 ,int rc){
        semaphore1 = s1;       
        readSemaphore = s2; 
        writeSemaphore = s3;
        readerCount = rc;

    }
    
        @Override
        public void run() {
                try {
                readSemaphore.acquire();
                semaphore1.acquire();
                ++readerCount;
                if (readerCount == 1) writeSemaphore.acquire();
                semaphore1.release();

                System.out.println(Thread.currentThread().getName() + " is READING");
                Thread.sleep(100);
                System.out.println(Thread.currentThread().getName() + " has FINISHED READING");
                
                semaphore1.acquire();
                ++readerCount;
                if (readerCount == 0) writeSemaphore.release();
                semaphore1.release();
                readSemaphore.release();

            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
            
            
        }
    }

