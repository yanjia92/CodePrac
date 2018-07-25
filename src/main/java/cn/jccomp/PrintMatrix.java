package cn.jccomp;

import javafx.geometry.Pos;

import java.util.Stack;

/**
 * Created by bitbook on 2/24/18.
 * https://www.nowcoder.com/practice/9b4c81a02cd34f76be2659fa0d54342a?tpId=13&tqId=11172&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
public class PrintMatrix {
    private static class Position{
        public enum Direction {
            RIGHT, LEFT, TOP, DOWN;
        }
        private final int x, y;
        public Position(int x, int y) {
            this.x=x;
            this.y=y;
        }
        public Position move(Direction d) {
            int newX = this.x;
            int newY = this.y;
            switch (d) {
                case RIGHT:
                    newX += 1;
                    break;
                case LEFT:
                    newX -= 1;
                    break;
                case TOP:
                    newY += 1;
                    break;
                case DOWN:
                    newY -= 1;
                    break;
            }
            return new Position(newX, newY);
        }

//        public double distance(Position anotherPos) {
//            return Math.sqrt(Math.pow((this.x-anotherPos.x), 2) + Math.pow((this.y-anotherPos.y), 2));
//        }

        public int distanceX(Position another) {
            return Math.abs(this.x - another.x);
        }

        public int distanceY(Position another) {
            return Math.abs(this.y - another.y);
        }
    }

    public static void solution(int[][] matrix) {
//        System.out.println(matrix.length);
//        System.out.println(matrix[0].length);
        int row = matrix.length;
        int col = matrix[0].length;
        Position lt = new Position(0, 0);
        Position ld = new Position(row-1, 0);
        Position rt = new Position(0, col-1);
        Position rd = new Position(row-1, col-1);
        while (lt.distanceX(rt) > 2 && lt.distanceY(ld) >2) {
            // 将四个顶点组成的一圈数字按顺时针方向打出来

        }
        // 判断是否存在单行（列）数据或者单个点(包含在单行当中)

    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        solution(matrix);
    }
}
