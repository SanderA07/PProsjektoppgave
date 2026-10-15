package no.hvl.dat100.javel.oppgave5;

public class Invoices {

    public static void processInvoices(Invoice[] invoices) {

        // TODO
        for (Invoice invoice : invoices) {
            if (invoice != null) {
                System.out.println(
                        "========================")
                invoice.computeAmount();
                invoice.printInvoice();
                System.out.println(
                        "========================");
                System.out.println();
            }
        }
    }

