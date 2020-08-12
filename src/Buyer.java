import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Buyer<V> extends BuyerBase<V> {
    public Buyer (int sleepTime, int catalogSize, Lock lock, Condition full, Condition empty, PriorityQueue<V> catalog, int iteration) {
        //TODO Complete the Buyer Constructor method
        // ...
    	this.setSleepTime(sleepTime);
    	this.catalog = catalog;
    	setIteration(iteration);
    	this.lock = lock;
    	this.full = full;
    	this.empty = empty;
    }
    public void buy() throws InterruptedException {
	lock.lock();
    	try {
            //TODO Complete the try block for consume method
            // ...
    		while(catalog.isEmpty()) {
    			empty.await();
    			//System.out.println("Catalog empty");  // For testing
    		}
    	NodeBase<V> n = catalog.dequeue();    
	    
    	System.out.print("Consumed "); // DO NOT REMOVE (For Automated Testing)
            n.show(); // DO NOT REMOVE (For Automated Testing)
            full.signalAll();
	    
            // ...
	} catch (Exception e) {
            e.printStackTrace();
	} finally {
            //TODO Complete this block
		lock.unlock();
	}
    }
}
