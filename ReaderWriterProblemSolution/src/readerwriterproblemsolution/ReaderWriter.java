package readerwriterproblemsolution;
/**
 *
 * @author amirh
 */
class ReaderWriter {
    boolean lock = false;
    int readerCount = 0;
    boolean writer=false;

    public void readerEnter() throws InterruptedException {
        while (true) {
            synchronized (this) {
                while (lock && readerCount == 0) {
                    System.out.println("Reader cannot read... Becase another Writer now writing");
                    wait();
                }
                readerCount++;
                lock = true;
                System.out.println("Reader " + readerCount + " is reading...");
                Thread.sleep(100);
            }
        }
    }

    public void readerExit() throws InterruptedException {
        while (true) {
            synchronized (this) {
                while (readerCount != 0) {
                    System.out.println("Reader " + readerCount + " is now exiting...");
                    readerCount--;
                }
                lock = false;
                notifyAll();
                Thread.sleep(100);

            }
        }
    }

    public void writerEnter() throws InterruptedException {
        while (true) {
            synchronized (this) {
                while (lock){
                    System.out.println("New writer cannot write... Becase another Writer now writing");
                    wait();
                }
                lock = true;
                writer=true;
                System.out.println("Writer is now writing.....");
                Thread.sleep(100);

            }
        }
    }

    public void writerExit() throws InterruptedException {
        while (true) {
            synchronized (this) {
                if (writer) {
                    System.out.println("Writer leaving now...");
                    writer=false;
                    lock = false;
                    notifyAll();
                    Thread.sleep(100);
                }
            }
        }

    }
}
