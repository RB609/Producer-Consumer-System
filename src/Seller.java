import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Seller<V> extends SellerBase<V> {
	
    public Seller (int sleepTime, int catalogSize, Lock lock, Condition full, Condition empty, PriorityQueue<V> catalog, Queue<V> inventory) {
        //TODO Complete the constructor method by initializing the attributes
        // ...
    	this.empty = empty;
    	this.full = full;
    	this.setSleepTime(sleepTime);
    	this.catalog = catalog;
    	this.inventory = inventory;
    	this.lock = lock;
    }
    
    public void sell() throws InterruptedException {
	lock.lock();
    	try {
            //TODO Complete the try block for produce method
            // ...
			while(catalog.isFull()) {
				full.await();
				//System.out.println("Catalog full");
			}
			if(inventory.isEmpty()) {return;}
			Node<V> n = (Node<V>) inventory.dequeue();
			catalog.enqueue(n);
			
			empty.signalAll();
	} catch(Exception e) {
            e.printStackTrace();
	} finally {
            //TODO Complete this block
		lock.unlock();
	}		
    }
}
