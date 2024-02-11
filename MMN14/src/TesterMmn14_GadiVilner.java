public class TesterMmn14_GadiVilner {

    public static void main(String[] args) {
        q1();
        q2();
        q3();
        q4();
    }
    private static void q1() {
        IntList list = new IntList();
        list.addToEnd(3);
        list.addToEnd(6);
        list.addToEnd(2);
        list.addToEnd(7);
        list.addToEnd(1);
        System.out.println(list.subListSum(15));
    }
    private static void q2() {
        IntList list = new IntList();
        list.addToEnd(1);
        list.addToEnd(0);
        list.addToEnd(0);
        list.addToEnd(0);
        list.addToEnd(1);
        IntNode node = list.averageNode();
        System.out.println(node.getNext().getNext() == null);
    }

    private static void q3() {
        IntListTwo list = new IntListTwo();
        list.addToEnd(5);
        list.addToEnd(4);
        list.addToEnd(6);
        list.addToEnd(2);
        list.addToEnd(9);
        list.addToEnd(7);
        list.addToEnd(8);
        System.out.print(list.toString() + " reversed = " + list.toStringReverse().toString() + " - ");
        System.out.println(list.toStringReverse().equals("{8, 7, 9, 2, 6, 4, 5}"));
    }

    private static void q4() {
        IntListTwo list = new IntListTwo();
        list.addToEnd(2);
        list.addToEnd(4);
        list.addToEnd(1);
        list.addToEnd(6);
        list.addToEnd(4);
        list.addToEnd(2);
        list.addToEnd(4);
        list.addToEnd(3);
        list.addToEnd(5);
        System.out.println(list.isWay());

    }
}
