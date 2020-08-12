public class PriorityQueue<V> implements QueueInterface<V>{

    private NodeBase<V>[] queue;
    private int capacity, currentSize;
	
    //TODO Complete the Priority Queue implementation
    // You may create other member variables/ methods if required.
   
	public PriorityQueue(int capacity) {    
    	this.capacity = capacity + 1;
    	queue = new Node[this.capacity];
    	currentSize = 0;
    }

    public int size() {
    	return this.currentSize;
    }

    public boolean isEmpty() {
    	return (currentSize == 0);
    }
	
    public boolean isFull() {
    	return (currentSize == capacity-1);
    }

    public void add(int p, V data) {
    	if(!isFull()) {
    		Node<V> n = new Node<V>(p,data);
    		enqueue(n);
    	}
    	else
    		return;
    }
    public void enqueue(Node<V> node) {
    	if(isFull()) {
    		System.out.println("Queue Full");
    		return;
    	}
    	currentSize++;
    	queue[currentSize] = node;
    	int position = currentSize;
    //if(node!=null) {	
    	while(position != 1 && queue[position/2].getPriority() > node.getPriority()) {
    		queue[position] = queue[position/2];
    		position = position/2;
    	}
    	queue[position] = node;
    	//}
    }

    // In case of priority queue, the dequeue() should 
    // always remove the element with minimum priority value
    public NodeBase<V> dequeue() {
    	if(isEmpty()) {
    		System.out.println("Queue Empty");
    		return null;
    	}
    	NodeBase<V> element, temp;
    	int p, c;
    	element = queue[1];
    	temp = queue[currentSize];
    	currentSize--;
    	p=1;
    	c=2;
    	while(c <= currentSize) {
    	//if(temp!=null && queue[c]!=null && queue[c+1]!=null) {	
    		if(c < currentSize && queue[c].getPriority() > queue[c+1].getPriority())
    			c++;
    		if(temp.getPriority() <= queue[c].getPriority())
    			break;
    		queue[p] = queue[c];
    		p=c;
    		c = c*2;
    	//}
		}
    	queue[p] = temp;
    	return element;
    }

    public void display () {
	if (this.isEmpty()) {
            System.out.println("Queue is empty");
	}
	for(int i=0; i<currentSize; i++) {
            queue[i+1].show();
	}
    }
}

