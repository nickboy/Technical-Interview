// x = 3, n = 5 = 101, x^n = 243  
// res = 1, x = 3, n = 5 = 1001
// res = 3, x = 9, n = 4 = 100
// res = 3, x = 27, n = 2 = 10
// res = 3, x = 81, n = 1 = 1;
// res = 243, x = 243, n = 0 = 0; 
public class IterativeSolution {
    public double myPow(double x, int n) {
        double res = 1.0;
        if (n < 0) {
            x = 1.0 / x;
            n = -n;
        }
        
        while (n) {
            System.out.printf("n = %d, res = %f, x = %d", n, res, x);
            if (n & 1 != 0) {
                res *= x;
            }
            x *= x;
            n >>= 1;
        }
        return res;
    }

    public void main() {
        IterativeSolution sol = new IterativeSolution();
        sol.myPow(3.0, 8);

    }
}

