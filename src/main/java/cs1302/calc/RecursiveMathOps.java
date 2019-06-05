package cs1302.calc;

public class RecursiveMathOps implements MathOps {


    // (5 + 3) = (6 + 2) = (7 + 1) = (8 + 0) = 8
    @Override
    public int add(int lhs, int rhs) {
        if (rhs == 0) return lhs;
        return add(succ(lhs), pred(rhs));
    }


    // (5 - 3) = (4 - 2) = (3 - 1) = (2 - 0) = 2
    @Override
    public int sub(int lhs, int rhs){
        if (lhs < rhs) return 0;
        if (rhs == 0) return lhs;
        return sub(pred(lhs), pred(rhs));
    }

    // 5 x 3 = 5 + (5 x 2) = 5 + 5 + (5 x 1) = 20
    @Override
    public int mul(int lhs, int rhs) {
        return mul_acc(0, lhs, rhs);
    }

    public int mul_acc(int sum, int lhs, int rhs) {
        if (rhs == 0) return sum;
        return mul_acc(sum + lhs, lhs, pred(rhs));
    }

    // 19/5 = 1 + 14/5 = 1 + 1 + 9/5 + 1 + 1 + 1 + 4/5 = 3
    // 0/
    @Override
    public int div(int lhs, int rhs) throws ArithmeticException {
        if (rhs == 0) throw new ArithmeticException("Cant Divide by Zero!");
        return div_acc(0, lhs, rhs);
    }

    public int div_acc(int counter, int lhs, int rhs) {
        if (lhs < rhs) return counter;
        return div_acc(succ(counter), sub(lhs, rhs), rhs);
    }

    // 3! = 3 x 2! = 3 x 2 x 1! = 3 x 2 x 1 x 0! = 6
    @Override
    public int fac(int num) {
        return fac_acc(1, num);
    }

    public int fac_acc(int product, int num) {
        if (num == 0) return product;
        return fac_acc(mul(product, num), pred(num));
    }

    // 2^4 = 2 x 2^3 = 2 x 2 x 2^2 = 2 x 2 x 2 x 2^1 = 2 x 2 x 2 x 2 x 2^0 = 16
    @Override
    public int pow(int lhs, int rhs) {
        return pow_acc(1, lhs, rhs);
    }

    public int pow_acc(int product, int lhs, int rhs) {
        if (rhs == 0) return product;
        return pow_acc(mul(product, lhs), lhs, pred(rhs));
    }

    // 6 << 3 = 2 x (6 << 2) = 2 x 2 x (6 << 1) = 2 x 2 x 2 x (6 << 0)
    @Override
    public int lshift(int lhs, int rhs) {
        return lshift_acc(lhs, lhs, rhs);
    }

    public int lshift_acc(int product, int lhs, int rhs) {

        if (rhs == 0) return product;
        product = mul(product, 2);
        rhs = pred(rhs);
        return lshift_acc(product, lhs, rhs);
    }


    // 6 >> 3 = (6 >> 2) /2 = (6 >> 1) /2 /2 = (6 >> 0) /2 /2 /2
    @Override
    public int rshift(int lhs, int rhs) {
        return rshift_acc(lhs, lhs, rhs);
    }

    public int rshift_acc(int product, int lhs, int rhs) {

        if (rhs == 0) return product;
        product = div(product, 2);
        rhs = pred(rhs);
        return rshift_acc(product, lhs, rhs);
    }

}


