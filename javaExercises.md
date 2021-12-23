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
    public static void main (String[] args ) {
    	System.out.println(numPrimorial(69));
    }
}
```
