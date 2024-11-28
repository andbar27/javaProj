package p20241122_Test_Regine;



public class Regin {

	public static Boolean regine(int riga, int colonna, int[][] arr) {
		int len = arr.length;
		
		for(int i = 0; i < len; i++) {
			if(i == colonna)
				continue;
			if(arr[riga][i] != 0)
				return false;
		}
		
		return true;
	}

	public static void main(String[] args) {
		int len = 4;
		
		int[][] square = new int[len][len];
		for(int i=0; i < len; i++)
			for(int j=0; j < len; j++)
				square[i][j] = 0;
		
		
		
		int count = 0;
		
		for(int k=0; k < len; k++) {
		
			for(int i=0; i < len; i++) {
				for(int j=0; j < len; j++) {
					
	
				}
			}
			
		}

	}

}
