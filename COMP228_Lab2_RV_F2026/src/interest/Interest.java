package interest;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Interest {

    private BigDecimal principal;
    private BigDecimal rate;
    private BigDecimal time;

    // Constructor with validation
    public Interest(BigDecimal principal, BigDecimal rate, BigDecimal time) {


        if (principal.compareTo(BigDecimal.ZERO) <= 0 ||
            rate.compareTo(BigDecimal.ZERO) <= 0 ||
            time.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Values cannot be negative or zero.");
        }

        if (principal.scale() == 0) {
            throw new IllegalArgumentException("Principal cannot be an integer. It must include decimals.");
        }

        if (rate.scale() == 0) {
            throw new IllegalArgumentException("Rate cannot be an integer. Must include decimals.");
        }

        this.principal = principal;
        this.rate = rate;
        this.time = time;
    }

    // Simple Interest using BigDecimal
    public BigDecimal calculateSimpleInterest() {
        return principal.multiply(rate).multiply(time);
    }

    // Simple Interest using double (method overloading)
    public double calculateSimpleInterest(double p, double r, double t) {
        return p * r * t;
    }
    
    /*
     * This Method is overloaded and takes input from user using scanner library..
     * and returns double value
     */
    
    

    // COMPOUND INTEREST using BigDecimal
    public BigDecimal calculateCompoundInterest() {
        BigDecimal onePlusRate = BigDecimal.ONE.add(rate);
        BigDecimal amount = principal.multiply(onePlusRate.pow(time.intValue()));
        return amount.subtract(principal).setScale(2, RoundingMode.HALF_UP);
    }

    // COMPOUND INTEREST using double (method overloading)
    public double calculateCompoundInterest(double p, double r, double t) {
        return p * (Math.pow(1 + r, t)) - p;
    }
}