public class TestMain {
    public static void main(String[] args) {
        TestLinkedTree testLinkedTree = new TestLinkedTree();
        String str = "AB##C##";//"ABC##DE#G##F###";
        TestLinkedTree.Node root = testLinkedTree.createTestTree(str);

//        testLinkedTree.binaryTreePrevOrder(root);
//        System.out.println();
//        testLinkedTree.binaryTreePrevOrderNonR(root);
//        System.out.println();
//
//        testLinkedTree.binaryTreeInOrder(root);
//        System.out.println();
//        testLinkedTree.binaryTreeInOrderNonR(root);
//        System.out.println();
//
//        testLinkedTree.binaryTreePostOrder(root);
//        System.out.println();
//        testLinkedTree.binaryTreePostOrderNonR(root);
//        System.out.println();
        //testLinkedTree.binaryTreeLevelOrder(root);
        System.out.println(testLinkedTree.binaryTreeComplete(root));
    }
}
