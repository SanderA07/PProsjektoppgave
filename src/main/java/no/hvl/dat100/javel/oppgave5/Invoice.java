package no.hvl.dat100.javel.oppgave5;

import no.hvl.dat100.javel.oppgave1.DailyPower;
import no.hvl.dat100.javel.oppgave3.Customer;
import no.hvl.dat100.javel.oppgave2.MonthlyPower;
import no.hvl.dat100.javel.oppgave3.PowerAgreementType;

import java.io.PrintStream;
import java.util.Arrays;

public class Invoice {

    private Customer c; // customer associated with this invoice
    private String month; // month that the invoice covers
    private double[][] usage; // power usage this month (per day and per hour)
    private double[][] prices; // power prices for this month

    private double amount; // power price for this month
    private DailyPower MonthPower;


    public Invoice(Customer c, String month, double[][] usage, double[][] power_prices) {

        // TODO - konstruktør
        this.c = c;
        this.month = month;
        this.usage = usage;
        this.prices = power_prices;

        amount = 0;

    }

    public void computeAmount() {
        // TODO
        MonthlyPower MonthPower = null;
        if (c.getAgreement()
                == PowerAgreementType.SPOTPRICE) {
            amount =
                    MonthPower.computeSpotPrice(
                            usage,
                            prices);
        } else if (c.getAgreement()
                == PowerAgreementType.POWERSUPPORT) {
            double spotpris =
                    MonthPower.computeSpotPrice(
                            usage,
                            prices);
            double stromstotte =
                    MonthPower.computePowerSupport(
                            usage,
                            prices);
            amount = spotpris - stromstotte;
        } else if (c.getAgreement()
                == PowerAgreementType.NORGESPRICE) {
            amount =
                    MonthPower.computeNorgesPrice(
                            usage);
        }
    }


    public void printInvoice() {

        // TODO
        System.out.println(c);
        System.out.println();
        System.out.println("Month: " + month);
        PrintStream printf = System.out.printf(
                "Usage: %.2f kWh%n",
                MonthPower.computePowerUsage(usage));
        System.out.printf(
                "Amount: %.2f NOK%n",
                amount);

    }
}


