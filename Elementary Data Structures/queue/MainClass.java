package queue;

public class MainClass {

	public static void main(String[] args) {
		ArrayQueue<Integer> x = new ArrayQueue<>(20);
		x.AddQ(10);
		x.AddQ(20);
		x.AddQ(30);
		x.DeleteQ();
		System.out.println(x.rear);
	}
	
	
}
