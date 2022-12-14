package readerwriterproblemsolution;

/**
 *
 * @author amirh
 */
public class ReaderWriterProblemSolution {
    public static void main(String[] args) throws InterruptedException {
        final ReaderWriter rw= new ReaderWriter();
        
        Thread t1= new Thread(() -> {//using lamdba exp
            try {
                rw.readerEnter();
            } catch (InterruptedException e) {
                e.printStackTrace();//for print if any exception message
            }
        });
        
        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    rw.readerExit();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t3= new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    rw.writerEnter();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t4= new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    rw.writerExit();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t1.join();
        t3.join();
        t2.join();
        t4.join();
    }

    }
    

