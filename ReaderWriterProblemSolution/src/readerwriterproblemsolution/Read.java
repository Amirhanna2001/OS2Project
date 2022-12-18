package readerwriterproblemsolution;
import java.util.concurrent.Semaphore;

/**
 *
 * @author amirh
 */
class Read implements Runnable {
        @Override
        public void run() {
//            while(true){
                try {
                ReaderWriterVariables.readSemaphore.acquire();
                ReaderWriterVariables.mutexSemaphore.acquire();
                ReaderWriterVariables.readerCount++;
                if (ReaderWriterVariables.readerCount == 1) ReaderWriterVariables.writeSemaphore.acquire();
                ReaderWriterVariables.mutexSemaphore.release();

                System.out.println(Thread.currentThread().getName() + " is READING");
                Thread.sleep(1500);
                System.out.println(Thread.currentThread().getName() + " has FINISHED READING");
                
                ReaderWriterVariables.mutexSemaphore.acquire();
                ReaderWriterVariables.readerCount--;
                if (ReaderWriterVariables.readerCount == 0) ReaderWriterVariables.writeSemaphore.release();
                ReaderWriterVariables.mutexSemaphore.release();
                ReaderWriterVariables.readSemaphore.release();

            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
//            }
            
        }
    }
