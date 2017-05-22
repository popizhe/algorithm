package ray.liu.algorithm.example;

public class FibonacciSequence {
	// 1, 1, 2, 3, 5, 8, 13, 21
	// 0, 1, 2, 3, 4, 5, 6, 7
	// fn = f(n-1) + f(n-2)

	private static long[] pair = new long[2];

	/**
	 * @param n
	 * @return
	 */
	public long cal(int n) {
		if (n == 0) {
			return 1;
		}
		if (n == 1) {
			return 1;
		}
		return cal(n - 1) + cal(n - 2);
	}

	public long calsum(int n) {
		if (n == 0) {
			return 1;
		}
		if (n == 1) {
			return 1;
		}
		return cal(n - 1, n - 2);
	}

	public long cal(int fh, int fl) {
		long h, l;
		if (fh == 0) {
			h = 1;
		} else if (fh == 1) {
			h = 1;
		} else {
			final int hh = fh - 1;
			final int hl = fh - 2;
			h = cal(hh, hl);
		}
		if (fl == 1) {
			l = 1;
		} else if (fl == 0) {
			l = 1;
		} else {
			final int lh = fl - 1;
			final int ll = fl - 2;
			l = cal(lh, ll);
		}

		final long sum = h + l;
		return sum;
	}

	public long f(int n) {
		long f0 = 1;
		long f1 = 1;
		long f2 = 0;

		for (int i = 2; i <= n; i++) {
			f2 = f0 + f1;
			f0 = f1;
			f1 = f2;
		}
		return f2;
	}

	public static void main(String[] args) {
		final FibonacciSequence fs = new FibonacciSequence();
		System.out.println(fs.cal(7));
		System.out.println(fs.calsum(7));
		System.out.println(fs.f(7));
	}
}

