package cs1302.calc;

/**
 * This implementation of MathOps provides iterative definitions for
 * basic mathematical operations such as add, multiply, etc. The methods
 * pred(int n) and succ(int n) are used to increment integers.
 *
 * @author Kaiva Mannam
 */

public class IterativeMathOps implements MathOps {

    /**
     * This method takes two parameters: lhs & rhs, and returns
     * their sum. An iterative approach is used to calculate the sum.
     * @param lhs the first operand
     * @param rhs the second operand
     * @return sum of lhs and rhs
     */


    // (5 + 3) = (6 + 2) = (7 + 1) = (8 + 0) = 8
    @Override
    public int add(int lhs, int rhs) {

        while (rhs > 0) { // while rhs > 0
            lhs = succ(lhs); // increment lhs
            rhs = pred(rhs); // decrement rhs
        }

        return lhs;
    }

    /**
     * This method takes two parameters: lhs & rhs, and returns
     * their difference. If rhs > lhs, 0 is returned. An iterative
     * approach is used to calculate the difference.
     *
     * @param lhs the first operand
     * @param rhs the second operand
     * @return difference of lhs and rhs
     */

    // (5 - 3) = (4 - 2) = (3 - 1) = (2 - 0) = 2
    @Override
    public int sub(int lhs, int rhs) {

        // prevents a negative result
        if (lhs < rhs) {
            return 0;
        }


        while (rhs > 0) {
            lhs = pred(lhs); // increments lhs
            rhs = pred(rhs); // increments rhs
        }

        return lhs;
    }


    // 5 x 3 = 5 + (5 x 2) = 5 + 5 + (5 x 1) = 20
    @Override
    public int mul(int lhs, int rhs) {
        int sum = 0;

        while (rhs > 0) {
            sum = add(sum, lhs);
            rhs = pred(rhs);
        }

        return sum;
    }

    // 19/5 = 1 + 14/5 = 1 + 1 + 9/5 + 1 + 1 + 1 + 4/5 = 3
    @Override
    public int div(int lhs, int rhs) throws ArithmeticException {
        int counter = 0;

        while (lhs >= rhs) {
            counter = succ(counter);
            lhs = sub(lhs,rhs);
        }

        return counter;
    }

    // 3! = 3 x 2! = 3 x 2 x 1! = 3 x 2 x 1 x 0! = 6
    @Override
    public int fac(int num) {
        int product = 1;

        while (num > 0) {

            product = mul(product,num);
            num = pred(num);
        }

        return product;
    }

    // 2^4 = 2 x 2^3 = 2 x 2 x 2^2 = 2 x 2 x 2 x 2^1 = 2 x 2 x 2 x 2 x 2^0 = 16
    @Override
    public int pow(int lhs, int rhs) {
        int product = 1;

        while (rhs > 0) {
            product = mul(product,lhs);
            rhs = pred(rhs);
        }

        return product;
    }

    // 6 << 3 = 2 x (6 << 2) = 2 x 2 x (6 << 1) = 2 x 2 x 2 x (6 << 0)
    public int lshift(int lhs, int rhs) {
        int product = lhs;

        while (rhs > 0) {
            product = mul(product, 2);
            rhs = pred(rhs);
        }

        return product;
    }

    public int rshift(int lhs, int rhs) {
        int product = lhs;

        while (rhs > 0) {
            product = div(product, 2);
            rhs = pred(rhs);
        }
        return product;
    }



}


