public class MagicMath {

    public static int fact(int n){
        int result = 1;
        for (int i = 1; i<= n; i++){
            result *= i;
        }

        return result;
    }

    public static int abs(int n){
        return n >= 0 ? n : -n;
    }

    public static int pow(int n, int e){
        int result = 1;
        for (int i = 0; i < e; i++){
            result *= n;
        }

        return result;
    }
}