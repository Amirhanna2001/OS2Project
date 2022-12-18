package readerwriterproblemsolution;

/**
 *
 * @author amirh
 */
public class ReaderWriterProblemSolution {

     public static void main(String[] args) throws Exception {
        Read read = new Read();
        Write write = new Write();
        Thread t1 = new Thread(read);
        Thread t2 = new Thread(read);
        Thread t3 = new Thread(write);
        Thread t4 = new Thread(write);
        
        t3.start();
        t4.start();
        t1.start();
        t2.start();
        
    }

}
