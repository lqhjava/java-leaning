

import java.util.Scanner;
 
/**
 * Created by Olive on 2017/9/14.
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            // n*m迷宫,小青蛙初始在(0,0)位置,地下迷宫的出口在(0,m-1)
            // 小青蛙在迷宫中水平移动一个单位距离需要消耗1点体力值,向
            // 上爬一个单位距离需要消耗3个单位的体力值,向下移动不消耗体力值
            int n = in.nextInt();
            int m = in.nextInt();
            // 剩余体力值
            int power = in.nextInt();
            int[][] maze = new int[n][m];
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++)
                    maze[i][j] = in.nextInt();
            }
            System.out.println(pathOut(n , m, maze, power));
        }
    }
 
    static String path = "";
    public static String pathOut(int n, int m, int[][] maze, int power){
        if(n <= 0)
            return "Can not escape!";
 
        boolean[][] visited = new boolean[n][m];
        findPath(n, m, maze, 0, 0, "", visited, power);
 
        return path;
    }
 
    public static void findPath(int n, int m, int[][] maze, int nowx, int nowy, String res, boolean[][] visited, int power){
        if(nowx == 0 && nowy == m - 1 && maze[0][m - 1] == 1){
            if(power >= 0)
                path = res + "[0," + (m - 1) + "]";
            else
                path = "Can not escape!";
 
            return;
        }
 
        if(nowx < n && nowy < m && nowx >= 0 && nowy >= 0 && maze[nowx][nowy] == 1 && !visited[nowx][nowy]){
 
            visited[nowx][nowy] = true;
            res += "[" + nowx + "," + nowy + "],";
            // 水平向右
            findPath(n, m, maze, nowx, nowy + 1, res, visited, power - 1);
            // 向下
            findPath(n, m, maze, nowx + 1, nowy, res, visited, power);
            // 水平向左
            findPath(n, m, maze, nowx, nowy - 1, res, visited, power - 1);
            // 向上
            findPath(n, m, maze, nowx - 1, nowy, res, visited, power - 3);
        }
 
    }
}
