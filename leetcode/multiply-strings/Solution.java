class Solution {
    public static String multiply(String num1, String num2) {
        // Ensures that num1's length is less than or equal to num2's length
        if (num2.length() < num1.length())
            return multiply(num2, num1);

        if (num1.equals("0"))
            return "0";

        if (num1.length() == 1 && num2.length() == 1) {
            int d1 = num1.charAt(0) - 48;
            int d2 = num2.charAt(0) - 48;
            return (d1 * d2) + "";
        }

        if (num1.length() == 1) {
            int carry = 0;
            String d1 = num1.charAt(0) + "";
            String res = "";
            for (int i = num2.length() - 1; i >= 0; i--) {
                String d2 = num2.charAt(i) + "";
                int mul = Integer.parseInt(multiply(d1, d2)) + carry;
                carry = mul / 10;
                mul %= 10;
                res = mul + res;
            }
            if (carry != 0)
                res = carry + res;
            return res;
        }

        String zeroes = "";
        String result = "0";
        for (int i = num1.length() - 1; i >= 0; i--) {
            String d1 = num1.charAt(i) + "";
            String mul = multiply(d1, num2);
            mul += zeroes;
            zeroes += "0";
            result = add(mul, result);
        }

        return result;
    }

    public static String add(String num1, String num2) {
        // Ensures that num1's length is less than or equal to num2's length
        if (num2.length() < num1.length())
            return add(num2, num1);

        int sz = num1.length();
        int carry = 0;
        String result = "";
        for (int i = 1; i <= sz; i++) {
            int dig2 = num2.charAt(num2.length() - i) - 48;
            int dig1 = num1.charAt(num1.length() - i) - 48;
            int sum = (carry + dig1 + dig2);
            carry = sum / 10;
            result = (sum % 10) + result;
        }
        String remaining = num2.substring(0, num2.length() - sz);
        if (carry != 0)
            remaining = add("1", remaining);

        result = remaining + result;
        return result;
    }

    public static void main(String[] args) {
        // System.out.println(add("150", "10").equals("160"));
        // System.out.println(multiply("5", "6").equals("30"));
        // System.out.println(multiply("0", "6").equals("0"));
        // System.out.println(multiply("19", "6").equals("114"));
        // // System.out.println(multiply("123", "456"));
        // System.out.println(multiply("123", "456").equals("56088"));
    }
}