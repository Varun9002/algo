package algo;

public class Multiplication {
    public static long multiply(long a, long b) {
        int n = Long.toString(a).length();
        if (n == 1)
            return a * b;
        long m = (int) Math.pow(10, n / 2);
        long a1 = a / m, a2 = a % m;
        long b1 = b / m, b2 = b % m;

        long A = multiply(a1, b1);
        long B = multiply(a1 + a2, b1 + b2);
        long C = multiply(a2, b2);
        return A * m * m + (B - A - C) * m + C;
    }
    public static void main(String[] args) {
        System.out.println(multiply(1234, 5678));
    }
}