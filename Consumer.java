import java.util.concurrent.Semaphore;

public class Consumer implements Runnable{
    Products pd;
    Semaphore prodsre, consre;

    public Consumer(Products pd , Semaphore prodsre, Semaphore consre){
        this.pd = pd;
        this.prodsre = prodsre;
        this.consre = consre;
    }


    @Override
    public void run() {
        for (int i = 0; i< 7; i++){
            try {
                this.consre.acquire();
                System.out.println("consumed the product : "+this.pd.ar.remove(0));
                this.prodsre.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}