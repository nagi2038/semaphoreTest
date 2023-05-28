import java.util.concurrent.Semaphore;

public class Producer implements Runnable{
    Products pd;
    Semaphore prodsre, consre;
    public Producer(Products pd, Semaphore prodsre , Semaphore consre){
        this.pd = pd;
        this.prodsre = prodsre;
        this.consre = consre;
    }

    @Override
    public void run() {
        for(int i = 0;i<11;i++){ // array size is 4 so max products can be 
            //no of products- no of consumer <= 4 ex : 11-7 <=4  if products are more than 11 it will wait forever.
            try {
                this.prodsre.acquire();
                this.pd.ar.add(i);
                System.out.println("added the product : "+i);
                this.consre.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } 

        }
    }
    
}
