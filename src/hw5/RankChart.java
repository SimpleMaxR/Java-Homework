package hw5;
import hw4.*;
import java.io.*;


public class RankChart {
    NameRank hw4 = new NameRank();
    public String[][] getTop5Name(int year) throws Exception {
        File file;
        // 读取文件
        if (year == 2020) {
            file = new File("/Users/hugo/02大二/Java/Java Homework/src/hw4/yob2020.txt");
        } else if (year == 2021) {
            file = new File("/Users/hugo/02大二/Java/Java Homework/src/hw4/yob2021.txt");
        } else {
            throw new Exception("Invalid year.");
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        NameRank.Student[] boyData = new NameRank.Student[20000];
        NameRank.Student[] girlData = new NameRank.Student[20000];
        hw4.loadDataByRank(file, boyData,girlData);
        String[][] result = new String[2][5];
        for (int i = 0; i < 5; i++) {
            // 二维数组第一行存储男孩名字，第二行存储女孩名字
            result[0][i] = boyData[i+1].getName();
            result[1][i] = girlData[i+1].getName();
        }
        return result;
    }


    public void printChart() {
        System.out.println("--------------------");
        System.out.printf("%4s", "Year");
        for (int i = 0; i < 2; i++) {
            for (int j = 1; j < 6; j++) {
                System.out.printf("%15s", "Rank" + j);
            }
        }
        System.out.println();
        // 2020
        System.out.print(2020);
        try {
            String[][] result = getTop5Name(2020);
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 5; j++) {
                    System.out.printf("%15s", result[i][j]);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println();
        // 2021
        System.out.print(2021);
        try {
            String[][] result = getTop5Name(2021);
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 5; j++) {
                    System.out.printf("%15s", result[i][j]);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
