import java.util.Scanner;

public class Model {

	
	public int sum, avg;

	public Model(int sum, int avg) {
		super();
		this.sum = sum;
		this.avg = avg;
	}
	public Model(int sum) {
		super();
		this.sum = sum;
		this.avg = 0;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	public int getAvg() {
		return avg;
	}
	public void setAvg(int avg) {
		this.avg = avg;
	}
	
	
}
