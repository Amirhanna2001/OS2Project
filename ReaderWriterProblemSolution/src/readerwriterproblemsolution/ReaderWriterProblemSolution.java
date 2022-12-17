package readerwriterproblemsolution;
import java.util.Scanner;
import java.util.concurrent.Semaphore;
/**
 *
 * @author amirh
 */
public class ReaderWriterProblemSolution {

     public static void main(String[] args) throws Exception {
        Read read = new Read();
        Write write = new Write();
        Thread t1 = new Thread(read);
        t1.setName("thread1");
        Thread t2 = new Thread(read);
        t2.setName("thread2");
        Thread t3 = new Thread(write);
        t3.setName("thread3");
        Thread t4 = new Thread(write);
        t4.setName("thread4");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }

}
