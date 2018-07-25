package cn.jccomp.array;

/**
 * Created by bitbook on 7/21/18.
 */
public class Q11 {

    public static int solution(int[] height) {
        int beginIndex, endIndex;
        beginIndex = 0;
        endIndex = height.length - 1;
        int maxVolumn = (endIndex - beginIndex) * Math.min(height[beginIndex], height[endIndex]);
        while ((endIndex - beginIndex) >= 2) {
            if (height[beginIndex] <= height[endIndex]) {
                beginIndex += 1;
                maxVolumn = Math.max(maxVolumn, (endIndex - beginIndex) * Math.min(height[beginIndex], height[endIndex]));
            } else {
                endIndex -= 1;
                maxVolumn = Math.max(maxVolumn, (endIndex - beginIndex) * Math.min(height[beginIndex], height[endIndex]));
            }
        }
        return maxVolumn;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 4, 3};
        int answer = Q11.solution(array);
        System.out.println(answer);
    }
}
