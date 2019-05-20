package java_concept;

/**
 * Created by idongsu on 09/05/2019.
 */
public class ex_thread {
    public static void main(String args[]) {
        test_thread th = new test_thread();
        Thread th2 = new Thread(new test_run());

        th.run();
        th2.run();
    }
}

class test_thread extends Thread {

    @Override
    public void run() {
        for(int i = 0; i < 5; i++) {
            System.out.println(this.getName());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class test_run implements Runnable {
    @Override
    public void run() {
        for(int i=0; i<5; ++i) {
            System.out.println(Thread.currentThread().getName() + " a ");
        }
        try {
            Thread.sleep(100);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}
