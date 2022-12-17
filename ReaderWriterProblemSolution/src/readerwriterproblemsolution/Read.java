package readerwriterproblemsolution;
import java.util.concurrent.Semaphore;

/**
 *
 * @author amirh
 */
class Read implements Runnable {
        @Override
        public void run() {
            try {
                ReaderWriterVariables.rsem.acquire();
                ReaderWriterVariables.x.acquire();
                ReaderWriterVariables.readerCount++;
                if (ReaderWriterVariables.readerCount == 1) ReaderWriterVariables.wsem.acquire();
                ReaderWriterVariables.x.release();

                System.out.println("Thread "+Thread.currentThread().getName() + " is READING");
                Thread.sleep(1500);
                System.out.println("Thread "+Thread.currentThread().getName() + " has FINISHED READING");
                
                ReaderWriterVariables.x.acquire();
                ReaderWriterVariables.readerCount--;
                if (ReaderWriterVariables.readerCount == 0) ReaderWriterVariables.wsem.release();
                ReaderWriterVariables.x.release();
                ReaderWriterVariables.rsem.release();

            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
