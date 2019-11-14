package Trie;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 基于字典的正向最大匹配分词方法
 */
public class WordSplitFMM {
    private static Set dicSet;
    // 存储分词结果
    static List<String> splitedList = new LinkedList<>();

    public WordSplitFMM() {
        dicSet = Tools.loadDic("data/idc.txt");
    }

    public static List<String> dicSplit(String sentence) {
        int lenght = sentence.length();

        String matchedWord = "";
        boolean isMatched = false;
        for (int i = 1; i <= lenght; i++) {
            // 切分单词，开始匹配
            String tempWord = sentence.substring(0, i);
            if (dicSet.contains(tempWord)) {
                isMatched = true;

                // 比较长度，目的就是最长匹配
                if (tempWord.length() > matchedWord.length()) {
                    matchedWord = tempWord;
                }
                if (i == lenght) {
                    splitedList.add(matchedWord);
                }
            } else if (isMatched) {
                splitedList.add(matchedWord);
                // 这么写不就把相同的词替换了吗
//                dicSplit(sentence.replace(matchedWord, ""));
                dicSplit(sentence.substring(matchedWord.length()));
                break;
            }
        }
        return splitedList;
    }

    public static void main(String[] args) {
        WordSplitFMM ins = new WordSplitFMM();


        List<String> result = ins.dicSplit("哈利波特是我最喜欢的书我正在上班今天周四阳光非常好而我却在办公室写代码");
        for (String word : result) {
            System.out.print(word + " ");
        }
    }
}
