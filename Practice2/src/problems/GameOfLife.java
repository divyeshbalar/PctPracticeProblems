package problems;

import java.util.Arrays;
import java.util.Scanner;

public class GameOfLife {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int r, c;
		r = sc.nextInt();
		c = sc.nextInt();

		char fieldPrev[][] = new char[r][c];

		for (int i = 0; i < r; i++) {
			String input = "";
			input = sc.next();
			for (int j = 0; j < c; j++) {
				fieldPrev[i][j] = input.charAt(j);
			}
		}
		char fieldCurrent[][] = null;

		int iterations = sc.nextInt();
		String neighbors = "";
		for (int k = 0; k < iterations; k++) {
			fieldCurrent = new char[r][c];
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					if (i == 0 && j == 0) {
						neighbors = "" + fieldPrev[i][j + 1] + fieldPrev[i + 1][j + 1] + fieldPrev[i + 1][j];
					} else if (i == 0 && j == c - 1) {
						neighbors = "" + fieldPrev[i][j - 1] + fieldPrev[i + 1][j - 1] + fieldPrev[i + 1][j];
					} else if (i == r - 1 && j == 0) {
						neighbors = "" + fieldPrev[i][j + 1] + fieldPrev[i - 1][j + 1] + fieldPrev[i - 1][j];
					} else if (i == r - 1 && j == c - 1) {
						neighbors = "" + fieldPrev[i][j - 1] + fieldPrev[i - 1][j - 1] + fieldPrev[i - 1][j];
					} else if (i == 0) {
						neighbors = "" + fieldPrev[i][j - 1] + fieldPrev[i + 1][j - 1] + fieldPrev[i + 1][j]
								+ fieldPrev[i + 1][j + 1] + fieldPrev[i][j + 1];
					} else if (j == 0) {
						neighbors = "" + fieldPrev[i - 1][j] + fieldPrev[i - 1][j + 1] + fieldPrev[i][j + 1]
								+ fieldPrev[i + 1][j + 1] + fieldPrev[i + 1][j];
					} else if (i == r - 1) {
						neighbors = "" + fieldPrev[i][j - 1] + fieldPrev[i - 1][j - 1] + fieldPrev[i - 1][j]
								+ fieldPrev[i - 1][j + 1] + fieldPrev[i][j + 1];
					} else if (j == c - 1) {
						neighbors = "" + fieldPrev[i - 1][j] + fieldPrev[i - 1][j - 1] + fieldPrev[i][j - 1]
								+ fieldPrev[i + 1][j - 1] + fieldPrev[i + 1][j];
					} else {
						neighbors = "" + fieldPrev[i - 1][j - 1] + fieldPrev[i - 1][j] + fieldPrev[i - 1][j + 1]
								+ fieldPrev[i][j + 1] + fieldPrev[i + 1][j + 1] + fieldPrev[i + 1][j]
								+ fieldPrev[i + 1][j - 1] + fieldPrev[i][j - 1];
					}
					// System.out.println(neighbors);
					int orgCount = 0;
					for (int z = 0; z < neighbors.length(); z++) {
						if (neighbors.charAt(z) == '@')
							orgCount++;
					}
					if (fieldPrev[i][j] == '#' && orgCount == 3)
						fieldCurrent[i][j] = '@';
					else if (fieldPrev[i][j] == '@' && (orgCount <= 1 || orgCount >= 4))
						fieldCurrent[i][j] = '#';
					else if (fieldPrev[i][j] == '@' && (orgCount == 2 || orgCount == 3))
						fieldCurrent[i][j] = '@';
					else
						fieldCurrent[i][j] = '#';
				}
			}
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					fieldPrev[i][j] = fieldCurrent[i][j];
				}
			}
		}

		int count = 0;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (fieldCurrent[i][j] == '@')
					count++;
			}
		}
		System.out.println(count);

	}

}

/*//col , row : representing the cell you want to find neighbors to 
private void neighbours(int  col, int row) {

   //find all serouding cell by adding +/- 1 to col and row 
  for (int colNum = col - 1 ; colNum <= (col + 1) ; colNum +=1  ) {

      for (int rowNum = row - 1 ; rowNum <= (row + 1) ; rowNum +=1  ) {

           //if not the center cell 
          if(! ((colNum == col) && (rowNum == row))) {

              //make sure it is within  grid
              if(withinGrid (colNum, rowNum)) {
                  System.out.println("Neighbor of "+ col+ " "+ row + " - " + colNum +" " + rowNum );
              }
          }
      }
  }
}

//define if cell represented by colNum, rowNum is inside grid
//function used by neighbours()
private boolean withinGrid(int colNum, int rowNum) {

  if((colNum < 0) || (rowNum <0) ) {
      return false;    //false if row or col are negative
  }
  if((colNum >= COLS) || (rowNum >= ROWS)) {
      return false;    //false if row or col are > 75
  }
  return true;
}
*/



