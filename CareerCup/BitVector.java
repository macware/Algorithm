package CareerCup;

// Chapter 10.4
public class BitVector {
	private byte[] bitField;

	public BitVector(int size) {
		int n = size + 1;
		if ((n % 8)!= 0)
			n += 8;
		
		bitField = new byte[n >> 3];
		for (int i = 0; i < bitField.length; i++)
			bitField[i] = 0;
	}

	public void setPos(int pos) {
		int bytenum = pos >> 3;
		int bitnum = pos % 8;
		bitField[bytenum] |= 1 << bitnum;
	}
	
	public int getPos(int pos){
		int bytenum = pos >> 3;
		int bitnum = pos % 8;
		int ret = 0;
		if ((bitField[bytenum] & (1 << bitnum)) != 0)
			ret = 1;
		return ret;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(Integer.MAX_VALUE);
		BitVector bv = new BitVector(100);
		bv.setPos(100);
		System.out.println(bv.getPos(10));
	}

}
