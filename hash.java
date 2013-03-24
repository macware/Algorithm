import java.io.*;
import java.util.*;

public class hash {

	private HashSet<Integer> register;
	
	private int[] sums = new int[]{231552,234756,596873,648219,726312,981237,988331,1277361,1283379};
	private int[] result = new int[9];
	
	public hash(){
		register = new HashSet<Integer>();		
		for(int i = 0; i < result.length; i++)
			result[i] = 0;
	}
	
	public void checkSums(String filePath){
		if(loadData(filePath) < 0){
			System.out.println("Fail to read data");
			return;
		}
		
		Iterator<Integer> it;
		for(int i = 0; i < result.length; i++){
			it = register.iterator();
			while(it.hasNext()){
				if(register.contains(sums[i]-it.next())){
					result[i] = 1;
					System.out.println(sums[i]+" = "+it.next()+" + "+(sums[i]-it.next()));
					break;
				}
			}
		}
		
		System.out.println("The result is ");
		for(int i = 0; i < result.length; i++)
			System.out.print(result[i]);
	}
	
	private int loadData(String filePath){
		try{
			BufferedReader bReader = new BufferedReader(new FileReader(filePath));
			String line = null;
			
			while((line = bReader.readLine()) != null){
				register.add(Integer.parseInt(line));
			}
			
			bReader.close();
			System.out.println("Get "+register.size()+" lines of data");
		
		} catch (Exception e){			
			e.printStackTrace();
			return -1;
		}
		
		return 0;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		hash h = new hash();
		h.checkSums("//media//Work//src//HashInt.txt");
	}

}
