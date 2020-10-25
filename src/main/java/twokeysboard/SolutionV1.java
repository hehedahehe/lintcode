package twokeysboard;

/**
 * 出现了MLE
 * 你的代码内存使用超过了限制，检查你的空间复杂度。MLE通常是由多余的二维数组造成的。
 */
public class SolutionV1 {
    /**
     * 基本思想 递归
     * 后来发现不是递归：不存在递归关系
     *
     * @param n: The number of 'A'
     * @return: the minimum number of steps to get n 'A'
     */
    public int minSteps(int n) {
        // Write your code here
        if (n == 1) {
            return 0;
        }
        int res = find("", "初始化操作", n, 1, 0, 0);
        return res;
    }


    public int find(String lstOp, String op, int nTarget, int numberInBoard, int numberInBuffer, int step) {
        System.out.printf("%s %s->%s nLeft %d numberInBoard %d - numberInBuffer %d", genSpaces(step), lstOp, op, nTarget, numberInBoard, numberInBuffer);
        System.out.println();
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
                stepByCopy = find(op, "copy操作", nTarget, numberInBoard, numberInBoard, t);
            }
            //缓冲区大于0才允许Paste
            int stepByPaste = 0;
            if (numberInBuffer > 0) {
                //执行paste操作
                int nInBoard = numberInBoard + numberInBuffer;
                int t = step + 1;
                stepByPaste = find(op, "paste操作", nTarget, nInBoard, numberInBuffer, t);
            }

            if (stepByCopy > 0 && stepByPaste > 0) {
                return Math.min(stepByCopy, stepByPaste);
            } else {
                return stepByPaste == 0 ? stepByCopy : stepByPaste;
            }

        }
    }


    private String genSpaces(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            stringBuilder.append("---->");
        }
        return stringBuilder.toString();
    }


    public static void main(String[] args) {
        System.out.println(new SolutionV1().minSteps(7));
    }
}
