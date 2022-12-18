package readerwriterproblemsolution;

import java.util.concurrent.Semaphore;

/**
 *
 * @author amirh
 */
public class ReaderWriterVariables {
     static int readerCount = 0;
    static Semaphore x = new Semaphore(1);
    static Semaphore rsem = new Semaphore(1);
    static Semaphore wsem = new Semaphore(1);
    
}