package month2104;

import java.util.LinkedHashMap;

/**
 *第一个只出现一次的字符，空间换时间
 */
public class Problem350406 {

    public static void main(String[] args) {
        Problem350406 p = new Problem350406();
        System.out.println(p.firstNotRepeatChar("agbaccdeff"));
    }

    private Character firstNotRepeatChar(String str) {
        if (str == null) {
            return null;
        }

        char[] chars = str.toCharArray();
        LinkedHashMap<Character, Integer> hash = new LinkedHashMap<>();
        for (char c : chars) {
            if (hash.containsKey(c)) {
                hash.put(c, hash.get(c) + 1);
            } else {
                hash.put(c, 1);
            }
        }

        for (char key : hash.keySet()) {
            if (hash.get(key) == 1) {
                return key;
            }
        }
        return null;
    }
}
