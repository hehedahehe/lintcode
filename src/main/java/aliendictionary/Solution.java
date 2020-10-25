package aliendictionary;

public class Solution {
    /**
     * @param words: the array of string means the list of words
     * @param order: a string indicate the order of letters
     * @return: return true or false
     */
    public boolean isAlienSorted(String[] words, String order) {
        boolean res = true;
        char[] letters = order.toCharArray();
        //
        long length = words.length - 1;
        for (int i = 0; i < length; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            if (word1BiggerThanWord2(word1, word2, letters)) {
                res = false;
                break;
            }
        }

        return res;
    }

    private boolean word1BiggerThanWord2(String word1, String word2, char[] letters) {
        boolean res = false;

        char[] letters1 = word1.toCharArray();

        long ll1 = letters1.length - 1;

        char[] letters2 = word2.toCharArray();
        long ll2 = letters2.length - 1;


        long l = Math.max(ll1, ll2);

        for (int i = 0; i < l; i++) {
            if (i <= ll1 && i <= ll2) {
                char c1 = letters1[i];
                char c2 = letters2[i];

                long index1 = getLetterIndexInOrder(c1, letters);
                long index2 = getLetterIndexInOrder(c2, letters);

                if (index1 > index2) {
                    res = true;
                    break;
                } else if (index1 == index2) {
                    continue;
                } else {
                    res = false;
                    break;
                }
            } else {
                if (l > ll1) {
                    res = false;
                } else {
                    res = true;
                }
            }

        }
        return res;
    }

    //获取字母在字母表的索引
    private long getLetterIndexInOrder(char letter, char[] letters) {
        long index = 0;
        for (int i = 0; i < letters.length; i++) {
            char l = letters[i];
            if (l == letter) {
                index = i;
            }
        }
        return index;
    }


    public static void main(String[] args) {
        String[] words = {"word", "world"};
        String order = "worldabcefghijkmnpqstuvxyz";
        Solution solution = new Solution();
        boolean alienSorted = solution.isAlienSorted(words, order);
        System.out.println(alienSorted);
    }
}
