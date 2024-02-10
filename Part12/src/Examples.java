public class Examples
{
    public static boolean search(Node root, int num)
    {
        if (root == null)
            return false;

        if (root.getNumber() == num)
            return true;

        return search(root.getLeftSon(), num) || search(root.getRightSon(), num);
    }

    public static void printPreOrder(Node root)
    {
        if (root != null)
        {
            System.out.print(root.getNumber() + " ");
            printPreOrder(root.getLeftSon());
            printPreOrder(root.getRightSon());
        }
    }

    public static void printInOrder(Node root)
    {
        if (root != null)
        {
            printInOrder(root.getLeftSon());
            System.out.print(root.getNumber() + " ");
            printInOrder(root.getRightSon());
        }
    }

    public static void printPostOrder(Node root)
    {
        if (root != null)
        {
            printPostOrder(root.getLeftSon());
            printPostOrder(root.getRightSon());
            System.out.print(root.getNumber() + " ");
        }
    }

    public static int sum(Node n)
    {
        if (n == null)
            return 0;

        return n.getNumber() + sum(n.getLeftSon()) + sum(n.getRightSon());
    }

    public static int countLeaves(Node n)
    {
        if (n == null)
            return 0;

        if (n.getLeftSon() == null && n.getRightSon() == null)
            return 1;

        return countLeaves(n.getLeftSon()) + countLeaves(n.getRightSon());
    }

    public static int maxInTree(Node t)
    {
        if (t == null)
            return Integer.MIN_VALUE;

        if ((t.getLeftSon() == null) && (t.getRightSon() == null))
            return t.getNumber();

        int a = maxInTree(t.getLeftSon());
        int b = maxInTree(t.getRightSon());

        return Math.max(t.getNumber(), Math.max(a, b));
    }

    // Binary Search Tree (BST) methods
    public static boolean searchInBST(Node root, int num)
    {
        if (root == null)
            return false;

        if (root.getNumber() == num)
            return true;

        if (num < root.getNumber())
            return searchInBST(root.getLeftSon(), num);

        return searchInBST(root.getRightSon(), num);
    }

    public static void insert(Node bst, int x)
    {
        if (bst == null)
        {
            bst = new Node(x);
            return;
        }

        if (x < bst.getNumber())
        {
            if (bst.getLeftSon() == null)
                bst.setLeftSon(new Node(x));
            else
                insert(bst.getLeftSon(), x);
        }
        else
        {
            if (bst.getRightSon() == null)
                bst.setRightSon(new Node(x));
            else
                insert(bst.getRightSon(), x);
        }
    }

    public static int maxInSearchTree(Node root)
    {
        if (root == null)
            return Integer.MIN_VALUE;

        if (root.getRightSon() == null)
            return root.getNumber();

        return maxInSearchTree(root.getRightSon());
    }
}
