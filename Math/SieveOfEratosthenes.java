package Math;

public class SieveOfEratosthenes {

	private boolean[] flags;
	
	public void sieving(int max){
		if (max < 2){
			System.out.println("None");
			return;
		}
		
		flags = new boolean[max+1];
		flags[0] = flags[1] = true;
		
		int prime = 2;
		while (prime <= max){
			crossOff(prime);
			prime = getNextPrime(prime);
		}
		
		System.out.print("Primes: ");
		for (int i = 0; i < flags.length; i++){
			if (flags[i] == false)
				System.out.print(i+" ");
		}
	}
	
	private void crossOff(int prime){
		for (int i = prime * prime; i < flags.length; i += prime){
			flags[i] = true;
		}
	}
	
	private int getNextPrime(int prime){
		int next = prime + 1;
		while (next < flags.length){
			if (flags[next] == false)
				break;
			next++;
		}
		return next;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SieveOfEratosthenes soe = new SieveOfEratosthenes();
		soe.sieving(100);
	}

}
