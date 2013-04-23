package Bit;

// Chapter 5
public class BitManip {

	public String printBinary(double num){
		if (num > 1 || num <= 0){
			System.out.println("Num Error");
			return null;
		}
		
		StringBuilder sbuilder = new StringBuilder();
		sbuilder.append(".");
		double r = 0;
		while (num > 0){
			if (sbuilder.length() >= 32){
				System.out.println("Limit Error");
				return sbuilder.toString();
			}
			
			r = num * 2;
			if (r >= 1){
				sbuilder.append(1);
				num = r - 1;
			} else {
				sbuilder.append(0);
				num = r;
			}
		}
		
		return sbuilder.toString();
		
	}
	
	public int count1s(int num){
		if (num <= 0){
			System.out.println("Num Error");
			return -1;
		}
		
		int count = 0;
		do{
			count++;
			num &= num-1;
		}while (num > 0);
		
		return count;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BitManip chapter = new BitManip();
		System.out.println(chapter.count1s(15));

	}

}
