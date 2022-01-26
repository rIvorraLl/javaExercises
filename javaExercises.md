- Symmetric difference. It takes a matrix consisting of an array of n (n > 1) arrays, and returns an array with numbers present in any of those arrays, but not in more than one array.

```java
package difference;

public class Difference {

	public static int[] simDiff(int[][] matrix) {
		int len = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				len++;
			}
		}
		int[] arrWholeLen = new int[len];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				arrWholeLen[len - 1] = matrix[i][j];
				len--;
			}
		}
		int uniqueNums = 0;
		int countRepeat = 0;
		for (int i = 0; i < arrWholeLen.length; i++) {
			for (int j = 0; j < arrWholeLen.length; j++) {
				if (arrWholeLen[i] == arrWholeLen[j]) {
					countRepeat++;
				}
			}
			if (countRepeat < 2) {
				uniqueNums++;
			}
			countRepeat = 0;
		}
		countRepeat = 0;
		int[] uniqueNumArr = new int[uniqueNums];
		int index = 0;
		for (int i = 0; i < arrWholeLen.length; i++) {
			for (int j = 0; j < arrWholeLen.length; j++) {
				if (arrWholeLen[i] == arrWholeLen[j]) {
					countRepeat++;
				}
			}
			if (countRepeat < 2) {
				uniqueNumArr[index] = arrWholeLen[i];
				index++;
			}
			countRepeat = 0;
		}

		return uniqueNumArr;
	}
    // Testing:
	public static void main(String[] args) {
		int[][] testArr = { { 1, 2, 3, 4 }, { 3, 4, 5, 6 }, { 5, 6, 7 } };
		int[][] test2 = { { 1, 2, 3 }, { 5, 2, 1, 4 } };
		int[] testResult = simDiff(testArr);
		int[] testResult2 = simDiff(test2);
		for (int i = 0; i < testResult2.length; i++) {
			System.out.println(testResult2[i]);
		}
	}
}
```

- Get the primorial of an integer number. It takes the n number of consecutive prime numbers, and multiply for each other.

```java
public class Primorial {
    public static boolean isPrime(int num) {
    if (num <= 1) {
      return false;
    }
    double nn = Math.sqrt(num);
    int n = (int)nn + 1;
    for (int i = 2; i < n; i++) {
      if (num % i == 0) {
        return false;
      }
    }
    return true;
  }
    public static String numPrimorial(int n) {
      long primorial = 1;
      int i = 1;
      int num = 0;
      while (num < n) {
        boolean prime = isPrime(i);
        if (prime) {
          primorial *= i;
          num++;
        }
        i++;
      }
      return primorial + "";
    }
    // Testing:
    public static void main (String[] args ) {
    	System.out.println(numPrimorial(69));
    }
}
```
