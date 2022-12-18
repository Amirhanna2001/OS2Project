/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package readerwriterproblemsolution;

import java.util.concurrent.Semaphore;

/**
 *
 * @author amirh
 */
class Write implements Runnable {
        @Override
        public void run() {
            try {
                ReaderWriterVariables.rsem.acquire();
                ReaderWriterVariables.wsem.acquire();
                System.out.println("Thread "+Thread.currentThread().getName() + " is WRITING");
                Thread.sleep(5000);
                System.out.println("Thread "+Thread.currentThread().getName() + " has finished WRITING");
                ReaderWriterVariables.wsem.release();
                ReaderWriterVariables.rsem.release();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }