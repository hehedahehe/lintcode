package aliendictionary;

import java.util.*;

/**
 * https://www.lintcode.com/problem/alien-dictionary/description
 * 外星人词典
 * <p>
 * 这个题没有看明白
 */
public class Solution2 {

    /**
     * @param words: a list of words
     * @return: a string which is correct order
     */
    public String alienOrder(String[] words) {

        int length = words.length;

        //规则校验
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (words[i].startsWith(words[j])) {
                    return "";
                }
            }
        }

        //构建顺序对，以及暂时无法排序的字母

        List<Node> orderedPairs = new LinkedList<>();

        Set<Node> undefinedLetters = new HashSet<>();

        for (int i = 0; i < length; i++) {
            char[] letters1 = words[i].toCharArray();
            char[] letters2 = words[i + 1].toCharArray();
            int l1 = letters1.length;
            int l2 = letters2.length;
            int ll = Math.min(l1, l2);
            for (int j = 0; j < ll; j++) {
                char c1 = letters1[j];
                char c2 = letters2[j];
                if (c1 != c2) {
                    Node no2 = new Node(c2, null);
                    Node n1 = new Node(c1, no2);

                    orderedPairs.add(n1);
                    break;
                } else {
                    if (!undefinedLetters.contains(c1)) {
                        undefinedLetters.add(new Node(c1, null));
                    } else {
                        //如果已经包含了 就不再加入
                    }
                }
            }
        }

        //对 orderedPairs undefinedLetters进行归并操作
        //归并有两种可能，归并成功或失败
        //{"wrt", "wrf", "er"}这个该怎么排列？
        //规则没搞明白


        return "";
    }

    /**
     * 复杂度 n1*n2
     *
     * @param n1
     * @param n2
     * @return
     */
    Node merge(Node n1, Node n2) {
        return null;
    }

    class Node {
        char letter;
        Node next;

        public Node(char letter, Node next) {
            this.letter = letter;
            this.next = next;
        }

        public Node() {
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return letter == node.letter;
        }

        @Override
        public int hashCode() {
            return Objects.hash(letter, next);
        }
    }


    public static void main(String[] args) {
//        String[] words = {"wrt", "wrf", "er", "ett", "rftt"};
//        String s = new aliendictionary.Solution2().alienOrder(words);
//        System.out.println(s);
//
//        String[] words2 = {"z", "x"};
//        String s2 = new aliendictionary.Solution2().alienOrder(words2);
//        System.out.println(s2);
//
//        String[] words3 = {"zy", "zx"};
//        String s3 = new aliendictionary.Solution2().alienOrder(words3);
//        System.out.println(s3);
//
//        String[] words4 = {"wrt", "wrf", "wrz"};
//        String s4 = new aliendictionary.Solution2().alienOrder(words4);
//        System.out.println(s4);
//
//        String[] words5 = {"ab", "adc"};
//        String s5 = new aliendictionary.Solution2().alienOrder(words5);
//        System.out.println(s5);


//        String[] words6 = {"abc", "adc","ab"};
//        String s5 = new aliendictionary.Solution2().alienOrder(words6);
//        System.out.println(s5);

        String[] words7 = {
                "ze", "yf", "xd", "wd", "vd", "ua", "tt", "sz", "rd", "qd",
                "pz", "op", "nw", "mt", "ln", "ko",
                "jm", "il", "ho", "gk", "fa", "ed", "dg", "ct", "bb", "ba"};
        String s7 = new Solution2().alienOrder(words7);
        System.out.println(s7);

        String[] words = {"wrt", "wrf", "er", "ett", "rftt"};
        String s = new Solution2().alienOrder(words);
        System.out.println(s);
    }


}
