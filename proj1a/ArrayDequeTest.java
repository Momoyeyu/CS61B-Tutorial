public class ArrayDequeTest {

    public static void main(String[] args) {
        ArrayDeque<Integer> ad = new ArrayDeque<Integer>();
        if (ad.isEmpty()) {
            System.out.println("[INFO]: Method isEmpty() passed!");
        }
        else {
            System.out.println("[ERROR]: Array should be empty, but method isEmpty() return false.");
        }
        ad.addLast(11);
        ad.addFirst(22);
        ad.addLast(33);
        ad.addLast(44);
        ad.addFirst(55);
        // 55 22 11 33 44
        System.out.print("[INFO]: The current array deque: ");
        ad.printDeque();

        System.out.println("[INFO]: Testing get() ...");
        int[] array = new int[] {55, 22, 11, 33, 44};
        boolean ad_equal_array = true;
        for (int i = 0; i < ad.size(); i++) {
            if (ad.get(i) != array[i]){
                System.out.println("[ERROR]: Get wrong data.");
                ad_equal_array = false;
                break;
            }
        }
        if (ad_equal_array) {
            System.out.println("[INFO]: Method get() passed!");
        }

        System.out.print("[INFO]: Remove first, getting: ");
        ad.removeFirst();
        ad.printDeque();

        System.out.print("[INFO]: Remove last, getting: ");
        ad.removeLast();
        ad.printDeque();

        System.out.print("[INFO]: Remove last, getting: ");
        ad.removeLast();
        ad.printDeque();

        System.out.print("[INFO]: Remove last, getting: ");
        ad.removeLast();
        ad.printDeque();

        System.out.print("[INFO]: Remove last, getting: ");
        ad.removeLast();
        ad.printDeque();

    }



}
