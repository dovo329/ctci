package Question1_6;

public class Matrix {
	private final int M; // number of rows
	private final int N; // number of columns
	private double [][] data;
	
	public Matrix(int M, int N) {
		this.M = M;
		this.N = N;
		this.data = new double [M][N];
	}
	
	public Matrix(double [][] data) {
		this.M = data.length;
		this.N = data[0].length;
		this.data = new double [M][N];
		for (int r = 0; r < M; r++) {
			for (int c= 0; c < N; c++) {
				this.data[r][c] = data[r][c];
			}
		}
	}	
	
	// copy constructor
	private Matrix(Matrix A) {
		this(A.data);
	}
	
	public static Matrix random(int M, int N) {
		Matrix A = new Matrix(M, N);
		for (int r=0; r<M; r++) {
			for (int c=0; c<N; c++) {
				A.data[r][c] = Math.random();
			}
		}
		return A;
	}
	
	public String toString() {
		StringBuilder strBld = new StringBuilder();
		strBld.append('[');
		for (int r=0; r<this.M; r++) {
			if (r!=0) {
				strBld.append(' ');
			}
			strBld.append('[');
			for (int c=0; c<this.N; c++) {
				strBld.append(String.format("%.2f", this.data[r][c]));
				if (c+1<this.N) {
					strBld.append(", ");
				}
			}
			strBld.append(']');
			if (r+1<this.M) {
				strBld.append('\n');
			}
				
		}
		strBld.append(']');
		return strBld.toString();
	}

	public static Matrix rotate(Matrix B) {
		Matrix A = new Matrix(B.N, B.M);
		for (int r=0; r<B.M; r++) {
			for (int c=0; c<B.N; c++) {
				A.data[c][B.M-1-r] = B.data[r][c];
			}
		}
		return A;
	}
	
	public static void main (String [] args) {
		Matrix A = Matrix.random(2,3);
		System.out.printf("original\n%s", A.toString());
		Matrix B = Matrix.rotate(A);
		System.out.printf("\nrotated\n%s", B.toString());
	}
}

/*package Question1_6;


import CtCILibrary.*;

public class Question {

	public static void rotate(int[][] matrix, int n) {
		for (int layer = 0; layer < n / 2; ++layer) {
			int first = layer;
			int last = n - 1 - layer;
			for(int i = first; i < last; ++i) {
				int offset = i - first;
				int top = matrix[first][i]; // save top

				// left -> top
				matrix[first][i] = matrix[last-offset][first]; 			

				// bottom -> left
				matrix[last-offset][first] = matrix[last][last - offset]; 

				// right -> bottom
				matrix[last][last - offset] = matrix[i][last]; 

				// top -> right
				matrix[i][last] = top; // right <- saved top
			}
		}
	}
	
	public static void main(String[] args) {
		int[][] matrix = AssortedMethods.randomMatrix(10, 10, 0, 9);
		AssortedMethods.printMatrix(matrix);
		rotate(matrix, 10);
		System.out.println();
		AssortedMethods.printMatrix(matrix);
	}

}
*/