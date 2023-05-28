import java.util.concurrent.Semaphore;

public class Client {

    public static void main(String[] args) {
        
        Semaphore prodsre = new Semaphore(4, false);
        Semaphore consre = new Semaphore(0, false);

        Products products = new Products();

        Producer producer = new Producer(products, prodsre, consre);
        Consumer consumer = new Consumer(products, prodsre, consre);
        
        Thread t1 = new Thread(producer);
        Thread t2 = new Thread(consumer);
        t1.start();
        t2.start();

        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("array is "+products.ar);
    }
    
}
