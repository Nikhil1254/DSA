import java.util.*;

//https://www.pepcoding.com/resources/online-java-foundation/binary-tree/size-sum-max-height-binarytree-official/ojquestion

public class l001_sizeSumMaxMinHeightFind {
  public static class Node {
    int data;
    Node left;
    Node right;

    Node(int data, Node left, Node right) {
      this.data = data;
      this.left = left;
      this.right = right;
    }
  }

  public static int size(Node node) {
    return node == null ? 0 : size(node.left) + size(node.right) + 1;
  }

  public static int sum(Node node) {
    return node == null ? 0 : sum(node.left) + sum(node.right) + node.data;
  }

  public static int max(Node node) {
    return node == null ? -(int) 1e9 : Math.max(node.data, Math.max(max(node.left), max(node.right)));
  }

  public static int min(Node node) {
    return node == null ? (int) 1e9 : Math.min(node.data, Math.min(min(node.left), min(node.right)));
  }

  public static boolean find(Node node, int data) {
    if (node == null)
      return false;

    return node.data == data || find(node.left, data) || find(node.right, data);
  }

  public static int height(Node node) {
    // write your code here
    return node == null ? -1 : Math.max(height(node.left), height(node.right)) + 1;
  }

}