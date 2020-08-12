//Use this driver for the testing the correctness of your priority queue implementation
//You can change the add, remove sequence to test for various scenarios.
public class PriorityQueueTestDriver {
 public static void main(String[] args) {
	PriorityQueue<String> pq = new PriorityQueue<String>(6);
	pq.add(4, "A");
	pq.add(6, "B");
	pq.add(3, "C");
	pq.add(5, "E");
	pq.add(2, "F");
	pq.add(8,"H");
	pq.dequeue();
	//pq.dequeue();
	//pq.dequeue();
	//pq.dequeue();
	//pq.dequeue();

	//pq.display();
	int size = pq.size();
	pq.display();
 }
}
