/**
Fractions sum

Add two fractions
*/
private int maxCommonDivisor(int m, int n) {
    if (n > m) {
        int temp = n;
        n = m;
        m = temp;
    }
    while (m % n > 0) {
        int temp = m % n;
        m = n;
        n = temp;
    }
    return n;
}

private int minCommonMultiple(int m, int n) {
    return m * n / maxCommonDivisor(m, n);
}

public String addFractions(String a, String b) {
    String[] aArr = a.split("/");
    String[] bArr = b.split("/");
    int num1 = Integer.valueOf(aArr[0]);
    int num2 = Integer.valueOf(bArr[0]);
    int den1 = Integer.valueOf(aArr[1]);
    int den2 = Integer.valueOf(bArr[1]);
    int den = minCommonMultiple(den1, den2);
    int num = num1 * (den / den1) + num2 * (den / den2);
    int maxCommonMul = maxCommonDivisor(num, den);
    num /= maxCommonMul;
    den /= maxCommonMul;
    return num + "" + "/" + den + "";
}