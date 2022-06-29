package Fibo;

class Solution {
	static int[] fibo;

	static int fib(int n) {
		if (n <= 1)
			return n;

		if (fibo[n] != 0)
			return fibo[n];

		fibo[n] = fib(n - 1) + fib(n - 2);
		return fibo[n];
	}

	public static void main(String[] args) {
		fibo = new int[100];

		System.out.println(fib(33) == 3524578);
	}
}