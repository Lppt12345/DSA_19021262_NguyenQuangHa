package Week10;


import java.util.ArrayList;
import java.util.List;

public class Trie {

    class Node {
        public String s;
        public boolean terminal;
        public Node[] children;

        public Node(String s) {
            this.s = s;
            this.terminal = false;
            this.children = new Node[26];
            for (int i = 0; i < 26; i++) {
                this.children[i] = null;
            }
        }
    }

    public Node root;

    public Trie() {
        root = new Node("");
    }

    public void insert(Node root, String s) {
        // YOUR CODE GOES HERE
        if (search(root, s)) return;
        int count = 0;
        Node curNode = root;
        if (root == null) root = new Node("");
        while (count < s.length()) {
            if (curNode.children[s.charAt(count) - 'a'] == null) {
                //String now = String.valueOf(s.charAt(count));
                curNode.children[s.charAt(count) - 'a'] = new Node(String.valueOf(s.charAt(count)));
            }
            curNode = curNode.children[s.charAt(count) - 'a'];
            count++;
        }
        curNode.terminal = true;
        curNode.s = s;
    }

    public void delete(Node root, String s) {
        // YOUR CODE GOES HERE
        if (!search(root, s)) return;
        int count = 0;
        Node pre = null;
        Node curNode = root;
        if (root == null) return;
        while (count < s.length()) {
            if (curNode.terminal == true) {
                pre = curNode;
            }
            curNode = curNode.children[s.charAt(count) - 'a'];
            count++;
        }
        curNode.terminal = false;

    }

    private int numOfChild(Node root) {
        int count = 0;
        if (root == null || root.children == null) return count;
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null) count++;
        }
        return count;
    }

    public boolean search(Node root, String s) {
        // YOUR CODE GOES HERE
        int count = 0;
        Node curNode = root;
        while (count < s.length()) {
            if (curNode.children[s.charAt(count) - 'a'] == null) {
                //String now = String.valueOf(s.charAt(count));
                return false;
            }
            curNode = curNode.children[s.charAt(count) - 'a'];
            count++;
        }
        if (curNode.terminal && curNode.s.equals(s)) return true;
        return false;
    }

    public List<String> startWith(Node root, String s) {
        // YOUR CODE GOES HERE
        List<String> ans = new ArrayList<>();
        int count = 0;
        Node curNode = root;
        while (count < s.length()) {
            if (curNode.children[s.charAt(count) - 'a'] == null) {
                //String now = String.valueOf(s.charAt(count));
                ans.add("");
                return ans;
            }
            curNode = curNode.children[s.charAt(count) - 'a'];
            count++;
        }
        ans = preOrder(curNode, ans);
        if (ans == null) {
            ans.add("");
        }
        return ans;
    }

    public List<String> preOrder(Node root, List<String> ans) {
        if (root == null) return ans;
        if (root.terminal == true) ans.add(root.s);
        if (root.children == null) return ans;
        for (int i = 0; i < 26; i++) {
            ans = preOrder(root.children[i], ans);
        }
        return ans;
    }

    public boolean isBinary(Node root) {
        boolean check = true;
        if (root == null) return true;
        int count = numOfChild(root);
        if (count == 1) {
            for (int i = 0; i < 26; i++) {
                if (root.children[i] != null) {
                    if (!isBinary(root.children[i])) check = false;
                }
            }
        } else if (count == 2) {
            for (int i = 0; i < 26; i++) {
                if (root.children[i] != null) {
                    if (!isBinary(root.children[i])) check = false;
                }
            }
        } else check = false;

        return check;
    }

    public int sizeTree(Node root) {
        if (root == null) return 0;
        else {
            int max = 0;
            for (int i = 0; i < 26; i++) {
                if (sizeTree(root.children[i]) > max) max = sizeTree(root.children[i]);
            }
            return 1 + max;
        }
    }

    public boolean isBalanced(Node root) {
        if (root == null) return true;
        if (numOfChild(root) == 0) return true;
        int min = 1000000;
        int max = 0;
        boolean check = true;
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null) {
                if (!isBalanced(root.children[i])) check = false;
                if (sizeTree(root.children[i]) > max) max = sizeTree(root.children[i]);
                if (sizeTree(root.children[i]) < min) min = sizeTree(root.children[i]);
            }
        }
        if (max - min > 1) check = false;
        return check;
    }

    public static void main (String [] args){
        Trie trie = new Trie();
        trie.insert(trie.root, "apple");
        System.out.println(trie.search(trie.root, "apple"));
        System.out.println(trie.search(trie.root, "app"));
        System.out.println(trie.startWith(trie.root, "app"));
        trie.insert(trie.root, "app");
        System.out.println(trie.search(trie.root, "app"));
    }


}

