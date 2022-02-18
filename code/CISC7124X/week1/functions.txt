public class Functions {
    static int gcd(int x, int y) {

        /*Always set numbers to positive*/
        x = (x > 0) ? x : -x;
        y = (y > 0) ? y : -y;

        /* Gte minimum of the two numbers */
        int minimum = Math.min(x, y);

        /* If x,y are divisible by the minimum of these two then the GCD is minimum */
        if (x % minimum == 0 && y % minimum == 0) {
            return minimum;
        }
        for (int i = minimum / 2; i >= 2; i--) {
            /* If both the numbers are divisible by i return i */
            if (x % i == 0 && y % i == 0)
                return i;
        }
        /* if nothing divides then only 1 divides every number */
        return 1;
    }
    static int sumEven(int[] a) {
        /* initialize sum as 0 */
        int sum = 0;
        /* loop through each element */
        for (int i = 0; i < a.length; i++) {
            /* if even */
            if (a[i] % 2 == 0) {
                /* pass number to sum*/
                sum += a[i];
            }
        }
        /* return sum */
        return sum;
    }
    static boolean sorted(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1]) {
                return false;
            }
        }
        return true;
    }
    static int[] copy(int[] a) {
        // initialize new array with size of input
        int a_copy[] = new int[a.length];
        //copy each element to new array
        for (int i = 0; i < a.length; i++) {
            a_copy[i] = a[i];
        }
        return a_copy;
    }
    public static void main(String[] args) {
        int[] arr = new int[] {
            1,
            2,
            3,
            4,
            5,
            6,
            7,
            8
        };

        System.out.println("Gcd of 8 and 12 is " + gcd(8, 12));

        System.out.println("Even elements sum in given array is " + sumEven(arr));
        System.out.println("Is array sorted " + sorted(arr));
        System.out.println("Conent of copied array is ");

        int[] b = copy(arr);
        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i] + " ");
        }
    }
}