package twokeysboard;

/**
 * 移除了多余的字符串和打印逻辑（IO占用资源）
 * 通过
 */
public class Solution {
    /**
     * 基本思想 递归
     * 后来发现不是递归：无法找出递归关系
     * <p>
     * 是一个逻辑递归树的遍历问题
     *
     * @param n: The number of 'A'
     * @return: the minimum number of steps to get n 'A'
     */
    public int minSteps(int n) {
        // Write your code here
        if (n == 1) {
            return 0;
        }
        int res = find(n, 1, 0, 0);
        return res;
    }


    public int find(int nTarget, int numberInBoard, int numberInBuffer, int step) {
        //如果只剩下一个字母则直接返回，无须进行操作
        if (numberInBoard == nTarget) {
            return step;
        } else if (numberInBoard > nTarget) {
            step = Integer.MAX_VALUE;
            return step;
        } else {
            //要不要加个限定 如果numberInBoard<=numberInBuffer就没有必要进行Copy了

            //执行copy操作 如果一直copy呢 剩余字符数会保持不变的 程序将执行不下去
            int stepByCopy = 0;
            //如果boar的数量低于或等于numberInBuffer则不必执行paste操作
            if (numberInBoard <= numberInBuffer) {
                //
            } else {
                int t = step + 1;
                stepByCopy = find(nTarget, numberInBoard, numberInBoard, t);
            }
            //缓冲区大于0才允许Paste
            int stepByPaste = 0;
            if (numberInBuffer > 0) {
                //执行paste操作
                int nInBoard = numberInBoard + numberInBuffer;
                int t = step + 1;
                stepByPaste = find(nTarget, nInBoard, numberInBuffer, t);
            }

            if (stepByCopy > 0 && stepByPaste > 0) {
                return Math.min(stepByCopy, stepByPaste);
            } else {
                return stepByPaste == 0 ? stepByCopy : stepByPaste;
            }

        }
    }


}
