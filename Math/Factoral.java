package Math;
import java.util.*;

// Chapter 17.3
public class Factoral {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int count = 0;
		
		System.out.print("Factorial num: ");
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		scanner.close();
		
		// multiple m(5) in consecutive n(1..num) numbers.
		for (int i = 5; num / i > 0; i *=5){
			count += num/i;
		}
		
		System.out.println(num+"! has "+count+" trailing 0s");
		
		// How many digits(b+1) for n!(=ax10^b)
		int units = 0;
		double total = 0;
		for (int i = 1; i <= num; i++){
			total += Math.log10(i);
		}
		
		units = (int)total;
		units++;
		System.out.println(num+"! has "+units+" digits");
	}

}
