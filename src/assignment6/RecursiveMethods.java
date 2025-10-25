package assignment6;

public class RecursiveMethods {

	/**
	 * Recursively computes base ^ exponent
	 * 
	 * @param base the base - can be positive or negative
	 * @param exp  the exponent - can be positive or negative
	 * @return base ^ exponent
	 */
	public static double exponent(int base, int exp) {
			if (exp == 0){
				return 1;
			}
			else if(exp<0){
			return 1.0/exponent(base, -exp);
			}
			// FIXME Recursively compute base^exp
			else {
			return base * exponent(base, exp-1);
			}
	}

	

	/**
	 * Recursively compute the sum of elements in an array
	 * 
	 * @param array an array of integers
	 * @return the sum of the elements in values
	 */
	public static int arraySum(int[] array) {

			// FIXME: Recursively compute the sum of the values in an array
			return arraySumHelper(array, 0);	
	}
	public static int arraySumHelper(int[]array, int index){
		if (index == array.length){
			return 0;
		}
		else {
			return array[index] + arraySumHelper(array, index+1);
		}
	}

	/**
	 * Recursively computes string representations of dragon curves
	 * 
	 * @param n the desired degree of the dragon curve
	 * @return the nth dragon curve
	 */
	public static String dragon(int n) {
		if (n==0){
				return "F-H";
			}
		else{
			String edit = dragon(n-1);
			edit = edit.replace("F", "Temp");
			edit = edit.replace("H", "F+H");
			edit = edit.replace("Temp", "F-H");
			return edit;
		}
			// FIXME Recursively compute dragon curves		
	}

	

	/**
	 * Finds the length of the longest path in the given 2D array from the specified
	 * start position.
	 * 
	 * @param chart 2D array of stones
	 * @param r     start position row
	 * @param c     start position column
	 * @return the length of the longest path that was found
	 */
	public static int maxPathLength(boolean[][] chart, int r, int c) {
    if (r < 0 || c < 0 || r >= chart.length || c >= chart[0].length || !chart[r][c]){
        return 0;
	}
    chart[r][c] = false; // mark visited
    int up = maxPathLength(chart, r-1, c);
    int down = maxPathLength(chart, r+1, c);
    int left = maxPathLength(chart, r, c-1);
    int right = maxPathLength(chart, r, c+1);
    chart[r][c] = true;  // unmark for other paths
    return 1 + Math.max(Math.max(up, down), Math.max(left, right));
	}
	 
	/*public static int maxPathLength(boolean[][] chart, int r, int c){
		int max = 1;
		if (!chart[r][c]){
			return 0;
		}
		//up
		if (r-1>=0){
			max = Math.max(max, maxPathLengthUp(chart, r, c));
		}
		//down
		if (r+1<chart.length){
			max = Math.max(max, maxPathLengthDown(chart, r, c));
		}
		//left
		if (c-1>=0){
			max = Math.max(max, maxPathLengthLeft(chart, r, c));
		}
		//right
		if (c+1<chart[0].length){
			max = Math.max(max, maxPathLengthRight(chart, r, c));
		}
		if (maxPathLengthUp(chart, r, c)==max){
			chart [r-max+1][c] = false;
			return max + maxPathLength(chart, r-max, c);
		}
		if (maxPathLengthDown(chart, r, c)==max){
			chart[r+max-1][c] = false;
			return max + maxPathLength(chart, r+max, c);
		}
		if (maxPathLengthLeft(chart, r, c)==max){
			chart[r][c-max+1] = false;
			return max + maxPathLength(chart, r, c-max);
		}
		else{
			chart[r][c+max-1] = false;
			return  max + maxPathLength(chart, r, c+max);
		}
		
	}


	/*public static int maxPathLength(boolean[][] chart, int r, int c) {
		int distance = Math.max(Math.max(maxPathLengthDown(chart, r, c),maxPathLengthUp(chart, r, c)),Math.max(maxPathLengthLeft(chart, r, c),maxPathLengthRight(chart, r, c)));
		boolean upGreaterThanDown = false;
		boolean leftGreaterThanRight = false;
		int vertical;
		int horizontal;
		if (!chart[r][c]){
			return 0;
		}
		if(maxPathLengthUp(chart, r, c)>maxPathLengthDown(chart, r, c)){
			upGreaterThanDown = true;
			vertical = maxPathLengthUp(chart, r, c);
		}
		else{
			vertical = maxPathLengthDown(chart, r, c);
		}
		if(maxPathLengthLeft(chart, r, c)>maxPathLengthRight(chart, r, distance)){
			leftGreaterThanRight = true;
			horizontal = maxPathLengthLeft(chart, r, c);
		}
		else {
			horizontal = maxPathLengthRight(chart, r, c);
		}
		if (horizontal>vertical){
			if (leftGreaterThanRight){
				//chart[r][c-horizontal+1] = false;
				return distance + maxPathLength(chart, r, c-horizontal);
			}
			else {
				//chart[r][c+horizontal-1] = false;
				return distance + maxPathLength(chart, r, c+horizontal);
			}
		}
		else{
			if (upGreaterThanDown){
				//chart[r+vertical-1][c] = false;
				return distance + maxPathLength(chart, r+vertical, c);
			}
			else {
				//chart[r-vertical+1][c] = false;
				return distance + maxPathLength(chart, r-vertical, c);
			}
		}

	}  */
	/*public static int maxPathLengthLeft(boolean[][] chart, int r, int c) {
		if (!chart[r][c]){
			return 0;
		}
		else if (c-1>=0){
			if (chart[r][c-1]){
				return 1+maxPathLengthLeft(chart, r, c-1);
			}
			else {
				return 1;
			}
		}
		else {
			return 1;
		}
	} 
	public static int maxPathLengthRight(boolean[][] chart, int r, int c) {
		if (!chart[r][c]){
			return 0;
		}
		else if (c+1<chart[0].length){
			if (chart[r][c+1]){
				return 1+maxPathLengthRight(chart, r, c+1);
			}
			else {
				return 1;
			}
		}
		else {
			return 1;
		}
	} 
	public static int maxPathLengthUp(boolean[][] chart, int r, int c) {
		if (!chart[r][c]){
			return 0;
		}
		else if (r+1<(chart.length)){
			if (chart[r+1][c]){
				return 1+maxPathLengthUp(chart, r+1, c);
			}
			else {
				return 1;
			}
		}
		else {
			return 1;
		}
	}
	public static int maxPathLengthDown(boolean[][] chart, int r, int c) {
		if (!chart[r][c]){
			return 0;
		}
		else if (r-1>=0){
			if (chart[r-1][c]){
				return 1+maxPathLengthDown(chart, r-1, c);
			}
			else {
				return 1;
			}
		}
		else {
			return 1;
		}
	}*/
}
