/*
* This is a program that calculates the cooking time
* when type and quantity of the food is given.
*
* @author  Sean McLeod
* @version 1.0
* @since   2021-04-26
*/

import java.util.Scanner;


final class Microwave {
    private Microwave() {
        // Prevent instantiation
        // Optional: throw an exception e.g. AssertionError
        // if this ever *is* called
        throw new IllegalStateException("Cannot be instantiated");
    }

    public static void main(final String[] args) {
        final int sub = 1;
        final double pizza = 0.75;
        final double soup = 1.75;
        final double percentForTwo = 0.5;
        final int percentForThree = 1;
        final int maxQuantity = 3;
        final double timeIncrement = 0.5;
        String type;
        int quantity;
        double time;

        // input
        Scanner typeInput = new Scanner(System.in);
        System.out.print("Are you heating sub, pizza, or soup?: ");

        type = typeInput.nextLine();

        if ((type.equals("sub")) || (type.equals("pizza"))
            || (type.equals("soup"))) {
            if (type.equals("sub")) {
                time = sub;
            } else if (type.equals("pizza")) {
                time = pizza;
            } else {
                time = soup;
            }

            // input
            Scanner quantityInput = new Scanner(System.in);
            System.out.print("how many " + type
                             + "(s) are you cooking?(max:3): ");

            try {
                quantity = quantityInput.nextInt();

                if (quantity <= maxQuantity && quantity > 0) {
                    int loopCounter = 1;
                    double totalIncrement = 0;
                    /* use loop to determine how much time should be
                    incremented depending on the quantity */
                    while (loopCounter < quantity) {
                        totalIncrement += timeIncrement;
                        loopCounter++;
                    }
                    // calculate
                    time = time + time * totalIncrement;
                    // output
                    System.out.println("\n");
                    System.out.print("The total cook time is " + time
                                     + " minutes");
                } else {
                    System.out.println("The maximum quantity of food is 3");
                }

            } catch (Exception NumberFormatException) {
                    System.err.print("Please enter a number");

            }
        } else {
            System.err.println("This microwave doesn't accept " + type);
        }
    }
}
