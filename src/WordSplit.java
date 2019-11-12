import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 基于字典的正向最大匹配分词方法
 */
public class WordSplit {
    private static Set dicSet;
    // 存储分词结果
    static List<String> splitedList = new LinkedList<>();

    public WordSplit() {
        dicSet = Tools.loadDic("data/idf.txt");
    }

    public static List<String> dicSplit(String sentence) {
        int lenght = sentence.length();
        int startindex = 0;

        String matchedWord = "";
        boolean isMatched = false;
        for (int i = 1; i <= lenght; i++) {
            String tempWord = sentence.substring(startindex, startindex + i);
            if (dicSet.contains(tempWord)) {
                isMatched = true;
                if (tempWord.length() > matchedWord.length()) {
                    matchedWord = tempWord;
                }
                if (i == lenght) {
                    splitedList.add(matchedWord);
                }
            } else if (isMatched) {
                splitedList.add(matchedWord);
                dicSplit(sentence.replace(matchedWord, ""));
                break;
            }
        }
        return splitedList;
    }

    public static void main(String[] args) {
        WordSplit ins = new WordSplit();
        List<String> result = ins.dicSplit("哈利波特是我最喜欢的书");
        for (String word : result) {
            System.out.print(word + " ");
        }
    }
}
