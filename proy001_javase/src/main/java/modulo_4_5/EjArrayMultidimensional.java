package modulo_4_5;

public class EjArrayMultidimensional {
	
	public static void main(String[] args) {
		
		int[][][][][][] datos;
		int[][][][] datos2 [][];
		
		int [][] d = new int[3][5];
		d[0][1] = 4;
		
		for(int[] f : d) {
			for(int c: f) {
				System.out.println(c);
			}
			System.out.println();
		}
		
		//crear un array de dos dimensiones pero irregular
		
		int[][] notas = new int[3][];
		notas[0] = new int [2];
		notas[1] = new int[6];
		notas[1][2] = 7;
		//notas[2][1] = 44;  // provoca un java.lang.NullPointerException ----> porque notas[2] es null
		
//		for(int[] f : notas) {
//			for(int c: f) {
//				System.out.println(c);
//			}
//			System.out.println();
//		}
		
		int[][][] grande = new int[3][][];
	}

}
