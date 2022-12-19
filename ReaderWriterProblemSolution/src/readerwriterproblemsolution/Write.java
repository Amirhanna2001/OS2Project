package readerwriterproblemsolution;


/**
 *
 * @author amirh
 */
class Write implements Runnable {
        @Override
        public void run() {
//            while(true){
                try {
                ReaderWriterVariables.readSemaphore.acquire();
                ReaderWriterVariables.writeSemaphore.acquire();
                System.out.println(Thread.currentThread().getName() + " is WRITING");
                //Edit The Varaible Here
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + " has finished WRITING");
                ReaderWriterVariables.writeSemaphore.release();
                ReaderWriterVariables.readSemaphore.release();
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
//            }
            
        }
    }