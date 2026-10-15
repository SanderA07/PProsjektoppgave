package no.hvl.dat100.javel.oppgave1;

public class DailyPower {

    // a) print power prices during a day
    public static void printPowerPrices(double[] prices) {
        for (int i = 0; i < prices.length; i++) {
            System.out.printf("%.2f NOK ", prices[i]);
        }

        System.out.println();
    }

    // b) print power usage during a day
    public static void printPowerUsage(double[] usage) {
        for (int i = 0; i < usage.length; i++) {
            System.out.printf("%.2f kWh ", usage[i]);
        }

        System.out.println();
    }

    // c) compute power usage for a single day
    public static double computePowerUsage(double[] usage) {

        double sum = 0;

        for (int i = 0; i < usage.length; i++) {
            sum += usage[i];
        }

        return sum;
    }

    // d) compute spot price for a single day
    public static double computeSpotPrice(double[] usage, double[] prices) {

        double price = 0;

        for (int i = 0; i < usage.length; i++) {
            double totalPrice = usage[i] * prices[i];
        }

        return price;
    }

    // e) compute power support for a given usage and price
    private static double getSupport(double usage, double price) {

            double threshold = 0.9375; // 93,75 øre = 0,9375 NOK

            if (price > threshold) {
                return usage * (price - threshold) * 0.90;
            }

            return 0;
        }



    // f) compute power support for a single day
    public static double computePowerSupport(double[] usage, double[] prices) {

        double support = 0;

        for (int i = 0; i < usage.length; i++) {
            support += getSupport(usage[i], prices[i]);
        }

        return support;
    }

    private static final double NORGESPRIS_KWH = 0.5;

    // g) compute norges pris for a single day
    public static double computeNorgesPrice(double[] usage) {

        double totalUsage = computePowerUsage(usage);

        return totalUsage * 0.50;
    }

    // h) compute peak usage during a single day
    public static double findPeakUsage(double[] usage) {

        double max = usage[0];

        for (int i = 1; i < usage.length; i++) {
            if (usage[i] > max) {
                max = usage[i];
            }
        }
        return max;
    }

    // i)
    public static double findAvgPower(double[] usage) {

        return computePowerUsage(usage) / usage.length;
    }
}