import java.util.ArrayList;

public class FileEntier {
	private ArrayList<Integer> fifo = new ArrayList<Integer>();
	
	public void add(int n) {
		fifo.add(n);
	}
	
	public int take() {
		if(!fifo.isEmpty()) {
			int val = fifo.get(0);
			
			fifo.remove(0);
			
			return val;
		}
		
		return -1;
	}
	
}
