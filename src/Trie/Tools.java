package Trie;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Tools {
    private Tools() {
    }

    /**
     * 载入字典
     *
     * @param path
     */
    static Set<String> loadDic(String path) {
        BufferedReader br = null;
        Set<String> wordSet = new HashSet<>();

        try {
            br = new BufferedReader(new FileReader(path));
            String s;
            while ((s = br.readLine()) != null) {
                String word = s.split(" ")[0];
                wordSet.add(word);
            }
        } catch (Exception E) {
            E.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return wordSet;
    }

}
