package fc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @author fuchen03
 * @version V1.0
 * @Package fc
 * @date 2021/1/27 上午10:23
 */
public class Que27 {

    public ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        if (str != null && str.length() > 0) {
            Permutation(str.toCharArray(), 0, res);
            Collections.sort(res);
        }

        return res;
    }

    private void Permutation(char[] chars, int i, ArrayList<String> list) {
        if (i == chars.length - 1) {
            list.add(String.valueOf(chars));
        } else {
            Set<Character> charSet = new HashSet<>();
            for (int j = i; j < chars.length; j++) {
                if (j == i || !charSet.contains(chars[j])) {
                    charSet.add(chars[j]);
                    swap(chars, i, j);
                    Permutation(chars, i + 1, list);
                    swap(chars, j, i);
                }
            }
        }

    }

    private void swap(char[] chars, int j, int i) {
        char temp = chars[j];
        chars[j] = chars[i];
        chars[i] = temp;
    }


    public ArrayList<String> Permutation1(String str) {
        ArrayList<String> res = new ArrayList<>();
        PermutationByMyself(res, 0, str.toCharArray());
        Collections.sort(res);
        return res;
    }

    private void PermutationByMyself(ArrayList<String> res, int i, char[] chars) {

        if (i == chars.length - 1) {
            res.add(String.valueOf(chars));
        } else {
            Set<Character> charSet = new HashSet<>();
            for (int j = i; j < chars.length; j++) {
                if (!charSet.contains(chars[j])) {
                    charSet.add(chars[j]);
                    // 交换
                    swap(chars, i, j);
                    // 处理子串
                    PermutationByMyself(res, i + 1, chars);
                    // 交换回来
                    swap(chars, i, j);
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Que27().Permutation1("abb"));
    }

}
