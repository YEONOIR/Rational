class Rational {
    long numerator, denominator;

    class Illegal extends Exception {
        String reason;

        Illegal(String reason) {
            this.reason = reason;
        }
    }

    /***
     * This is a traditional constructor without any parameter
     */
    Rational() {
        numerator = 0;
        denominator = 1;
    }

    /***
     * This is the constructor which receive the values of numerator and denominator
     * @param numerator the value of the numerator
     * @param denominator the value of the denominator
     * @throws Illegal will throw Illegal when wrong inputs are given
     */
    Rational(long numerator, long denominator) throws Illegal {
        if (denominator == 0) {
            throw new Illegal("Denominator cannot be zero.");
        }

        this.numerator = numerator;
        this.denominator = denominator;
        simplestForm();
    }

    /***
     * find the simplest form of a Rational number
     * E.g., 2/4 ==> 1/2, 4/6 ==> 2/3
     */
    private void simplestForm() {
        if (numerator == 0) {
            denominator = 1;
            return;
        }

        long computeGCD = GCD(Math.abs(numerator), Math.abs(denominator));
        numerator /= computeGCD;
        denominator /= computeGCD;

        // Keep the denominator positive.
        if (denominator < 0) {
            numerator *= -1;
            denominator *= -1;
        }
    }

    /***
     * find the greatest common denominator
     */
    private long GCD(long a, long b) {
        if (b == 0) return a;
        if (a % b == 0) return b;
        return GCD(b, a % b);
    }

    /***
     * Compute an addition of the current rational number to another given rational number
     * @param x the rational number to be added to the current rational number
     */
    public void add(Rational x) {
        numerator = (numerator * x.denominator) + (x.numerator * denominator);
        denominator = denominator * x.denominator;
        simplestForm();
    }

    /***
     * Compute a subtraction of the current rational number to another given rational number
     * @param x the rational number to be subtracted from the current rational number
     */
    public void subtract(Rational x) {
        numerator = (numerator * x.denominator) - (x.numerator * denominator);
        denominator = denominator * x.denominator;
        simplestForm();
    }

    /***
     * Compute a multiplication of the current rational number to another given rational number
     * @param x the rational number to be multiplied to the current rational number
     */
    public void multiply(Rational x) {
        numerator = numerator * x.numerator;
        denominator = denominator * x.denominator;
        simplestForm();
    }

    /***
     * Compute a division of the current rational number to another given rational number
     * @param x the rational number to be divided by the current rational number
     */
    public void divide(Rational x) {
        if (x.numerator == 0) {
            throw new ArithmeticException("Cannot divide by zero.");
        }

        numerator = numerator * x.denominator;
        denominator = denominator * x.numerator;
        simplestForm();
    }

    /***
     * Check if the given rational number equals to the current rational number
     * @param x the rational number to be compared to the current rational number
     * @return true if the given rational number equals to the current, false otherwise
     */
    @Override
    public boolean equals(Object x) {
        if (this == x) return true;
        if (!(x instanceof Rational)) return false;

        Rational other = (Rational) x;

        return numerator * other.denominator == other.numerator * denominator;
    }

    /***
     * Compare the current rational number to the current rational number
     * @param x the rational number to be compared to the current number
     * @return -1 if the current rational number is less than the given number,
     *         0 if they're equal, 1 if the current rational number is larger
     */
    public long compareTo(Object x) {
        if (!(x instanceof Rational)) {
            throw new IllegalArgumentException("Object must be a Rational.");
        }

        Rational other = (Rational) x;

        long left = numerator * other.denominator;
        long right = other.numerator * denominator;

        if (left < right) return -1;
        if (left > right) return 1;
        return 0;
    }

    /***
     * Give the formatted string of the rational number
     * @return the string representation of the rational number. For example, "1/2", "3/4".
     */
    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    public static void main(String[] args) {
        System.out.println("This is Rational class.");
    }
}
