public class HelloNumbers {
    public static void main(String[] args) {
        int num_to_print = 0;
        for(int i = 0; i < 10; ++i) {
            num_to_print += i;
            System.out.print(num_to_print + " ");
        }
    }
}