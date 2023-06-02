
public class Khagendra {

	public static String displayFactorialFormula(int x) {
		return ((x <= 2) ? "1" : displayFactorialFormula(x - 1)) + "*" + x;
	}

	public static String displayFactorialFormulaReverse(int x) {
		return ((x <= 1) ? "1" : x + "*" + displayFactorialFormulaReverse(x - 1));
	}

	public static String reverse(String mStr) {
		return reverser(mStr, 0);
	}

	public static String reverser(String mStr, int d) {
		if (d >= (mStr.length() / 2)) {
			return mStr;
		}

		return reverser(swapIt(mStr, d), d + 1);
	}

	public static int sumOfDigits(int x) {
		return sumOfDigitsHelper(String.valueOf(x), 0);
	}

	public static int sumOfDigitsHelper(String x, int d) {
		if (d == x.length() - 1) {
			return Integer.parseInt(String.valueOf(x.charAt(d)));
		}
		return (Integer.parseInt(String.valueOf(x.charAt(d))) + sumOfDigitsHelper(x, d + 1));
	}

	public static char minDigit(int n) {
		return minDigitHelper(String.valueOf(n).toCharArray(), 0);
	}

	public static char minDigitHelper(char[] n, int d) {
		if (d == n.length - 1) {
			return n[d];
		}
		return myMin(n[d], minDigitHelper(n, d + 1));
	}

	private static char myMin(char c, char mDigit) {
		return (c > mDigit ? mDigit : c);
	}

	public static String swapIt(String sString, int i) {
		char[] myChar = sString.toCharArray();
		char temp = myChar[i];
		int pos = sString.length() - 1 - i;
		myChar[i] = myChar[pos];
		myChar[pos] = temp;
		return String.copyValueOf(myChar);
	}

	public static void main(String[] args) {
		System.out.println(displayFactorialFormula(8));
		System.out.println(displayFactorialFormulaReverse(8));
		System.out.println(reverse("Khagendra"));
		System.out.println(sumOfDigits(123456));
		System.out.println(minDigit(78605645));
	}

}
