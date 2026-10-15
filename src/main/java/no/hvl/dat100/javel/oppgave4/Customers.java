package no.hvl.dat100.javel.oppgave4;

import no.hvl.dat100.javel.oppgave3.Customer;

public class Customers {

    private Customer[] customers;

    // a) Complete constructor
    public Customers(int size) {

        // TODO
        customers = new Customer[size];
    }

    // b) count number of non-null references
    public int countNonNull() {


        int count = 0;
        // TODO
        for (int i = 0; i < customers.length; i++) {

            if (customers[i] != null) {

                count++;
            }
        }
        return count;
    }

    // c) return reference to customer with given id (if exists)
    public Customer getCustomer(int customer_id) {
        // TODO
        for (int i = 0; i < customers.length; i++) {

            if (customers[i] != null
                    && customers[i].getCustomer_id() == customer_id) {

                return customers[i];
            }
        }
        return null;
    }

    // d) add a customer to the reference table
    public boolean addCustomer(Customer c) {
        // TODO
        for (int i = 0; i < customers.length; i++) {
            if (customers[i] == null) {
                customers[i] = c;
                return true;
            }
        }
        return false;
    }

    // e) remove customer with given id from reference table
    public Customer removeCustomer(int customer_id) {
        // TODO
        for (int i = 0; i < customers.length; i++) {
            if (customers[i] != null
                    && customers[i].getCustomer_id() == customer_id) {
                Customer kunde = customers[i];
                customers[i] = null;
                return kunde;
            }
        }
        return null;
    }

    // f) return reference table with all customers
    public Customer[] getCustomers() {
        // TODO
        int antall = countNonNull();
        Customer[] kundeliste =
                new Customer[antall];
        int indeks = 0;
        for (int i = 0; i < customers.length; i++) {
            if (customers[i] != null) {
                kundeliste[indeks] = customers[i];
                indeks++;
            }
        }
        return kundeliste;
    }
}