import java.util.HashMap;
import java.util.Map;

public class TrieTree2 {

    Node node_all = new Node();

    public void add(String word) {
        Node node = node_all;
        for (int i = 0; i < word.length(); i++) {
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

    /**
     * 输入的word是否有以字典开头的
     * 这个是“最短”匹配，也就是一有匹配的词就return了
     * @param word
     * @return
     */
    public boolean isStartWith(String word) {
        Node node_all_temp = node_all;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if (node_all_temp.content.containsKey(c)) {
                if (node_all_temp.content.get(c).isEnd) {
                    return true;
                }

                node_all_temp = node_all_temp.content.get(c);
            }

        }
        return false;
    }
    
    private static class Node {
        boolean isEnd = false;
        Map<Character, Node> content = new HashMap<>();
    }

    public static void main(String[] args) {
        TrieTree2 ins = new TrieTree2();
        String[] st = new String[]{"about", "boyfriend", "bee", "select", "buy", "weak"};
        for (String word : st) {
            ins.add(word);
        }
        System.out.println(ins.isStartWith("weak123"));

        System.out.println("===");
    }


}
