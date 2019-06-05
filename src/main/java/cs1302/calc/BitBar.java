package cs1302.calc;

import javafx.geometry.*;
import javafx.scene.control.Separator;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

/**
 * BitBar represents an HBox holding 32 Bit objects. Together, the
 * 32 bit objects represent the binary form of the result integer.
 * The clickable bits can update the result value as well.
 *
 * @author Kaiva Mannam
 *
 */

public class BitBar extends HBox {

    ResultBar resultBar; // reference variable for driver's ResultBar instance
    Text text; // text to show in BitBar
    Bit[] bitArray; // array representing current bits

    /**
     * This constructor creates and formats the parent HBox object.
     * It also assigns the driver's current instance of ResultBar.
     *
     * @param mainApp the Driver application object
     */

    public BitBar(CalcApp mainApp) {

        super(1); // creates parent HBox
        super.setAlignment(Pos.CENTER); // center-aligns text
        super.setStyle("-fx-border-style: solid"); // creates border
        super.setPrefHeight(20); // sets box HBox height

        resultBar = mainApp.getResultBar(); // assigns driver's ResultBar instance

        /* adds a new text node to the HBox */
        text = new Text();
        super.getChildren().add(text);
        initializeBits();
    } // constructor

    /**
     * This method does preliminary work to set up the BitBar
     */

    public void initializeBits() {

        bitArray = new Bit[32]; // assigns a new array of Bits


        for (int i = 0; i < 32; i++) { // for each element in bitArray

            /* adds a separator every four bits */
            if ((i % 4 == 0) && (i > 0)) {
                super.getChildren().add(new Separator());
            }

            Bit myBit = new Bit(); // instantiates a new bit


            myBit.setOnMouseClicked(event -> {
                myBit.toggle(); // call toggle() when pressed
                int result = computeBits(); // recompute result from bits
                resultBar.displayResult(result); // display new result
            });

            bitArray[i] = myBit; // adds Bit object to array
            super.getChildren().add(myBit); // adds Bit object to HBox (as text)
        }

    } // initializeBits

    /**
     * This method converts a base 10 integer into a binary number using a
     * helper method and updates the Bit array accordingly. This method is
     * called when the user presses the "Evaluate" KeyPadButton.
     *
     * @param result the integer to be represented in the BitBar
     */

    public void evaluateToBits(int result) {

        if (result != -1) { // only if result is valid

            String bitString = intToByte(result); // converts integer to a String of bits
            for (int i = 0; i < 32; i++) {
                /* changes Bit objects in the array to match the bit string */
                if (!bitString.substring(i, i + 1).equals(bitArray[i].toString())) {
                    bitArray[i].toggle();
                }
            }
        }
    } // evaluateToBits

    /**
     * This method computes the integer result from the Bit Array.
     * This method is called when the bits are toggled by the user.
     *
     * @return decimal integer representation of the bits
     */

    public int computeBits() {
        int sum = 0;

        // sum of products of digits and base exponents
        for (int i = 0; i <32; i++) {
             sum += bitArray[i].getValue() * Math.pow(2,31-i);
        }

        return sum;
    }

    /**
     * This method takes an integer as parameter and returns a
     * String representation of the integer in binary.
     *
     * @param num number to be converted to binary
     * @return binary Bit String
     */

    public static String intToByte(int num) {

        String str = ""; // bit string
        int pow = 31;

        while (num != 0) {
            if (num - Math.pow(2, pow) >= 0) {
                str += ("1"); // concat "1" if 2^pow fits within num
                num = num - (int) Math.pow(2, pow); // subtract num accordingly
            } else {
                str = str.concat("0"); // else, concat "0"
            }

            pow--; // decrement pow
        }

        // add zeroes to have a 32 bit string
        while (pow >= 0) {
            str = str.concat("0");
            pow--;
        }

        return str;
    }




}
