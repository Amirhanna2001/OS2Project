package readerwriterproblemsolution;
/**
 *
 * @author amirh
 */
class ReaderWriter {
    boolean read = false;
    int readerCount = 0;
    boolean writer=false;

    public void reader() throws InterruptedException {

            synchronized (this) {
                while (writer) {
                    System.out.println("Reader From " + Thread.currentThread().getName()+" cannot read... Becase another Writer now writing");
                    wait();
                }
                
                ++readerCount;
                read = true;
                
                //Sleep For 3 seconds
                System.out.println("Reader " + readerCount + " from " + Thread.currentThread().getName()+" is reading...");
                Thread.sleep(1000);
                System.out.println("Reader " + readerCount + " from " + Thread.currentThread().getName()+" is reading...");
                Thread.sleep(1000);
                System.out.println("Reader " + readerCount + " from " + Thread.currentThread().getName()+" is reading...");
                Thread.sleep(1000);      
                
                read = false;
                notifyAll();
                --readerCount;
            }
    }

    
    
//    public void readerExit() throws InterruptedException {
////        while (true) {
//            synchronized (this) {
//                while (readerCount != 0) {
//                    System.out.println("Reader " + readerCount + " form " + Thread.currentThread().getName()+" is now exiting...");
//                    readerCount--;
//                }
//                lock = false;
//                notifyAll();
////                Thread.sleep(1000);
//
////            }
//        }
//    }

    public void writer() throws InterruptedException {
            synchronized (this) {
                while (read||writer){
                    System.out.println("New writer cannot write...");
                    wait();
                }
                writer=true;
                //Sleep for 3 seconds
                System.out.println("Writer " + Thread.currentThread().getName()+" is now writing.....");
                Thread.sleep(1000);
                System.out.println("Writer " + Thread.currentThread().getName()+" is now writing.....");
                Thread.sleep(1000);
                System.out.println("Writer " + Thread.currentThread().getName()+" is now writing.....");
                Thread.sleep(1000);
                
                writer = read = false;
                notify();



            }
    }

//    public void writerExit() throws InterruptedException {
////        while (true) {
//            synchronized (this) {
//                if (writer) {
//                    System.out.println("Writer " + Thread.currentThread().getName()+" leaving now...");
//                    writer=false;
//                    lock = false;
//                    notifyAll();
////                    Thread.sleep(100);
//                }
//            }
////        }
//
//    }
}
