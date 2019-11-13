import java.util.HashMap;
import java.util.Map;

public class TrieTree2 {

    Node node_all = new Node();

    public void add(String word) {
        Node node = node_all;
        for (int i=0; i<word.length(); i++) {
            char c = word.charAt(i);

            // 如果是新的字，就直接put
            Node tempNode = new Node();
            if (!node.content.containsKey(c)) {
                node.content.put(c, tempNode);
            }
             node = node.content.get(c);
//            node = tempNode;
        }
        node.isEnd = true;
    }

    public static void main(String[] args) {
        TrieTree2 ins = new TrieTree2();
        String[] st = new String[]{"af", "bf", "be", "cq", "b",  "w"};
        for(String word : st) {
            ins.add(word);
        }
        System.out.println("===");
    }

    private static class Node {
        boolean isEnd = false;
        Map<Character, Node> content = new HashMap<>();
    }
}
