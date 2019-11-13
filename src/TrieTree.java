import java.util.*;

public class TrieTree {

    HashMap<Integer, HashMap<Character, Node>> tree = new HashMap<>();

    // 强行用map嵌套构建了一个字典树
    public void add(String word) {

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            // 这三种数据结构构建一颗树
            Node node = new Node();
            // Interger表示树的层数，Character表示每一层的字母，node包含两个属性：a,是否可以做叶子节点；下一层的字母集合
            char nextChar = ' ' ;

            if (i == word.length() - 1) {
                node.isEndNode = true;
            } else {
                nextChar = word.charAt(i + 1);
                node.nextWordSet.add(nextChar);
            }

            // 给node节点赋值
            HashMap<Character, Node> leaf = new HashMap<>();
            if (tree.get(i) == null ) {
                leaf.put(ch, node);
                tree.put(i, leaf);
            } else if (!tree.get(i).containsKey(ch)) {
                tree.get(i).put(ch, node);
            } else {
                // 更新node的状态
                tree.get(i).get(ch).isEndNode = node.isEndNode;
                if (!(nextChar + "").equals(" ")) {
                    tree.get(i).get(ch).nextWordSet.add(nextChar);
                }
            }

            System.out.println("---");
        }

    }

    static class Node {
        boolean isEndNode = false;
        Set<Character> nextWordSet = new HashSet<>();
    }


    public static void main(String[] args) {
        String[] test = new String[]{"af", "bf", "be", "cq", "b",  "w"};
        TrieTree ins = new TrieTree();
        for (String word : test) {
            ins.add(word);
        }
    }
}
