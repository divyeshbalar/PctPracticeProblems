/**
 * 
 */

/**
 * @author d_balar
 *
 */
public class Controller {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		int sum = 0;
		sum = View.getData();
		Model numObj = new Model(sum);
		Controller.getSumAvg(numObj);
		View.displaySumAvg(numObj.sum, numObj.avg);

	}
	
	private static void getSumAvg(Model num){

        for (int i=1; i < 10; i++){
            //Here the controller interfaces with 
            //the model
            num.sum = num.sum + i;
            num.avg = num.sum/i;

        }

}
}