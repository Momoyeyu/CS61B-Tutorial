public class ArrayDequeTest {

    public static void testAddLast() throws RuntimeException {
        ArrayDeque<Integer> ad2 = new ArrayDeque<Integer>();
        System.out.println("[INFO]: Testing addLast()");
        for (int i = 0; i < 20; i++) {
            ad2.addLast(1);
        }
        ad2.printDeque();
    }

    public static void main(String[] args) {
        try {
            testAddLast();
        } catch (RuntimeException e){
            // Handle the exception here, or propagate it further using "throws" in the method signature
            System.out.println("Exception caught: " + e.getMessage());
        }

        ArrayDeque<Integer> ad = new ArrayDeque<Integer>();
        if (ad.isEmpty()) {
            System.out.println("[INFO]: Method isEmpty() passed!");
        } else {
            System.out.println("[ERROR]: Array should be empty "
                               + "but method isEmpty() return false.");
        }

        ad.addLast(11);
        ad.addFirst(22);
        ad.addLast(33);
        ad.addLast(44);
        ad.addLast(44);
        ad.addLast(44);
        ad.addLast(44);
        ad.addFirst(55);
        ad.addFirst(55);
        ad.addFirst(55);
        ad.addFirst(55);
        // 55 55 55 55 22 11 33 44 44 44 44
        System.out.print("[INFO]: The current array deque: ");
        ad.printDeque();

        System.out.println("[INFO]: Testing get() ...");
        int[] array = new int[] {55, 22, 11, 33, 44};
        boolean adEqualArray = true;
        for (int i = 0; i < ad.size(); i++) {
            if (ad.get(i) != array[i]) {
                System.out.println("[ERROR]: Get wrong data.");
                adEqualArray = false;
                break;
            }
        }
        if (adEqualArray) {
            System.out.println("[INFO]: Method get() passed!");
        }

        System.out.print("[INFO]: Remove first 3, getting: ");
        ad.removeFirst(); ad.removeFirst(); ad.removeFirst();
        ad.printDeque();

        System.out.print("[INFO]: Remove last 3, getting: ");
        ad.removeLast(); ad.removeLast(); ad.removeLast();
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
