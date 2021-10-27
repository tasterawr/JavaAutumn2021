
/**
 * Class which provides basic factorial, absolute and power methods.
 * @author Loktev Ilya
 * @version 1.0
*/
public class MagicMath {

    /**
     * Method which returns factorial number for a specified value.
     * @param n int parameter, must not be negative.
     * @return factorial number for provided value n.
     */
    public static int fact(int n){
        int result = 1;
        for (int i = 1; i<= n; i++){
            result *= i;
        }

        return result;
    }

    /**
     * Method which returns an absolute number for a specified value.
     * @param n int parameter, can be positive/negative or zero.
     * @return an absolute number for a provided value.
     */
    public static int abs(int n){
        return n >= 0 ? n : -n;
    }

    /**
     * Method which raises a number to a specified power.
     * @param n int parameter, a number which has to be raised to a power.
     * @param e int parameter, the degree to which the number must be raised.
     * @return the number raised to a specified power.
     */
    public static int pow(int n, int e){
        int result = 1;
        for (int i = 0; i < e; i++){
            result *= n;
        }

        return result;
    }
}