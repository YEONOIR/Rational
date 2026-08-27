class Rational { 
    long numerator,denominator; 

    class Illegal extends Exception { 
        String reason; 
        Illegal (String reason) { 
            this.reason = reason; 
        } 
    }

    /***
     * This is a traditional constructor without any parameter
     */
    Rational() {
        // to be completed
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
        // to be completed
        this.numerator = numerator;
        this.denominator = denominator;
    }

    /***
     * find the simplest form of a Rational number
     * E.g., 2/4 ==> 1/2, 4/6 ==> 2/3
     */
    private void simplestForm() { 
        long computeGCD; 
        computeGCD = GCD(Math.abs(numerator), denominator); 
        numerator /= computeGCD; 
        denominator /= computeGCD; 
    }

    /***
     * find the greatest common denominator
     */
    private long GCD(long a, long b) { 
        if (a%b ==0) return b; 
        else return GCD(b,a%b); 
    }

    /***
     * Compute an addition of the current rational number to another given rational number
     * @param x the rational number to be added to the current rational number
     */
    public void add(Rational x) { 
        numerator = (numerator * x.denominator) + (x.numerator * denominator);
        denominator = (denominator * x.denominator); 
        simplestForm();
    }

    /***
     * Compute a subtraction of the current rational number to another given rational number
     * @param x the rational number to be subtracted from the current rational number
     */
    public void subtract(Rational x) {
        // to be completed
        numerator = (numerator * x.denominator) - (x.numerator * denominator);
        denominator = (denominator * x.denominator);
        simplestForm();
    }

    /***
     * Compute a multiplication of the current rational number to another given rational number
     * @param x the rational number to be multiplied to the current rational number
     */
    public void multiply(Rational x) { 
        // to be completed
        numerator = numerator * x.numerator;
        denominator = denominator * x.denominator;
        simplestForm();
    }

    /***
     * Compute a division of the current rational number to another given rational number
     * @param x the rational number to be divided by the current rational number
     */
    public void divide(Rational x) {
        // to be completed
        numerator = numerator * x.denominator;
        denominator = denominator * x.numerator;
        simplestForm();
    }

    /***
     * Check if the given rational number equals to the current rational number
     * @param x the rational number to be compared to the current rational number
     * @return true if the given rational number equals to the current, false otherwise
     */
    public boolean equals(Rational x) {
        // to be completed
        return x.numerator == numerator && x.denominator == denominator;// TODO: This needs to be modified.
    }

    /***
     * Compare the current rational number to the current rational number
     * @param x the rational number to be compared to the current rational number
     * @return -1 if the current rational number is less than the given number, 0 if they're equal, 1 if the current
     * rational number is larger than the given number
     */
    public long compareTo(Rational x) {
        // to be completed
        subtract(x);
        if((numerator >0 && denominator >0) ||(numerator <0 && denominator <0)) {
            return 1;
        } else if (numerator <0 || denominator <0){
            return -1;
        } else {
            return 0;
        }
        // TODO: this needs to be modified.
    }

    /***
     * Give the formatted string of the rational number
     * @return the string representation of the rational number. For example, "1/2", "3/4".
     */
    public String toString() { 
        // to be completed
        return numerator+"/"+denominator; // TODO: This needs to be modified.
    }

    public static void main(String[] args) {
        System.out.println("This is Rational class.");
    }
}