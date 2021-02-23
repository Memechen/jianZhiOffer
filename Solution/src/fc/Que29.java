package fc;

import java.util.*;

/**
 * @author fuchen03
 * @version V1.0
 * @Package fc
 * @date 2021/2/19 下午4:09
 */
public class Que29 {
    /**
     * 暴力破解，但我知道一定有最优解
     * @param input
     * @param k
     * @return
     */
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();

        if (k > input.length) {
            return res;
        }

        Arrays.sort(input);
        for (int i = 0; i < k; i++) {
            res.add(input[i]);
        }

        return res;
    }

    /**
     * 利用最大堆，构建排序
     * @param input
     * @param k
     * @return
     */
    public ArrayList<Integer> GetLeastNumbers_Solution2(int [] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();

        if (k > input.length || input == null  || k <= 0) {
            return res;
        }

        PriorityQueue<Integer> queue  = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

        int length = input.length;
        for (int i = 0; i < length; i++) {
            // 数据个数不够k时，添加数据，并通过比较器排序
            if(queue.size() != k){
                queue.offer(input[i]);
            }else if (queue.peek() > input[i]){
                queue.poll();
                queue.offer(input[i]);
            }
        }
        Iterator<Integer> it = queue.iterator();
        while (it.hasNext()){
            res.add(it.next());
        }

        return res;
    }

    public static void main(String[] args) {
        new Que29().GetLeastNumbers_Solution(new int[]{4,5,1,6,2,7,3,8},10);
    }
}
