package Top50_test;

import java.util.*;
import java.util.List;

public class SpiralMatrix {

	public static void main(String[] args) {
//		int[][] nums = {
//				{1, 2, 3 },
//		                {4, 5, 6 },
//		                {7, 8, 9 }
//				};
		int[][] nums = { { 1, 2,  3,  4 },
				 { 5, 6,  7,  8 }, 
				 { 9, 10, 11, 12 } };
		System.out.println(spiralOrder(nums));
		System.out.println(spiralOrder2(nums));

	}
	

	public static List<Integer> spiralOrder(int[][] matrix) {
		// 1
		List<Integer> result = new ArrayList<>();
		if (matrix == null || matrix.length == 0)
			return result;
		int rowStart = 0;
		int rowEnd = matrix.length - 1;

		int colStart = 0;
		int colEnd = matrix[0].length - 1;

		//
		while (rowStart <= rowEnd && colStart <= colEnd) {
			// right
			for (int i = colStart; i <= colEnd; i++) {
				result.add(matrix[rowStart][i]);
			}
			rowStart++;
			// down
			for (int i = rowStart; i <= rowEnd; i++) {
				result.add(matrix[i][colEnd]);
			}
			colEnd--;

			// left 3->0
			System.out.println("rowStart: "+rowStart+" rowEnd: "+rowEnd);
		
			if (rowStart <= rowEnd) {
				for (int i = colEnd; i >= colStart; i--) {
					System.out.println("matrix["+rowEnd+"]["+i+"] "+matrix[rowEnd][i]);
					result.add(matrix[rowEnd][i]);
				}
			}
			rowEnd--;
			// up 2->1
			if (colStart <= colEnd) {
					for (int i = rowEnd; i >= rowStart; i--) {
						result.add(matrix[i][colStart]);
					}
			}
			colStart++;
		}
		return result;
	}
	
	// switch case 문 적용
	public static List<Integer> spiralOrder2(int[][] matrix) {
		List<Integer> result = new ArrayList<>();
	    if(matrix == null || matrix.length == 0) return result;
	    
	    int rowStart = 0, rowEnd = matrix.length-1;
	    int colStart = 0, colEnd = matrix[0].length - 1;
	    int dir = 0;
	    
	    while(rowStart <= rowEnd && colStart <= colEnd) {
	        switch(dir) {
	            case 0: //Right
	                for(int col = colStart; col <= colEnd; col++)
	                    result.add(matrix[rowStart][col]);
	                rowStart++;
	                break;
	            case 1: //Down
	                for(int row = rowStart; row <=rowEnd; row++) 
	                    result.add(matrix[row][colEnd])    ;
	                colEnd--;
	                break;
	            case 2://Left
	                for(int col = colEnd; col >= colStart; col --) 
	                    result.add(matrix[rowEnd][col]);
	                rowEnd--;
	                break;
	            case 3://Up
	                for(int row = rowEnd; row >= rowStart; row--)
	                    result.add(matrix[row][colStart]);
	                colStart++;  
	                break;
	        }                                   
	        dir = (dir+1)%4;                                                            
	    }
	    
	    return result;
	}

}
