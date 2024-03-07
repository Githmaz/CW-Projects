import java.util.Arrays;

public class Main {
    int x ;
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        System.out.println(Arrays.toString(arr));
        cal(arr);
        System.out.println(Arrays.toString(arr));
        Main main = new Main();
        main.x =10;

    }
    private  static void cal(int[] x ){
       x[0] = x[1];
    }

}


