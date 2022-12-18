package readerwriterproblemsolution;

import java.util.concurrent.Semaphore;

/**
 *
 * @author amirh
 */
public class ReaderWriterVariables {
     static int readerCount = 0;
     static String sharedData = "ReaderWriterDefaultValue";
    static Semaphore mutexSemaphore = new Semaphore(1);
    static Semaphore readSemaphore = new Semaphore(1);
    static Semaphore writeSemaphore = new Semaphore(1);
    
}