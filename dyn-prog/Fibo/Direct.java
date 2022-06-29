package Fibo;

class Direct {
	static int fib(int n) {
		if (n <= 2)
			return 1;

		return fib(n - 1) + fib(n - 2);
	}

	public static void main(String[] args) {
		System.out.println(fib(5) == 5 ? "PASSED" : "FAILED");
		System.out.println(fib(6) == 8 ? "PASSED" : "FAILED");
		System.out.println(fib(7) == 13 ? "PASSED" : "FAILED");
	}
}