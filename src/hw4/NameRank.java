package hw4;
import java.io.*;
import java.util.*;

public class NameRank {
  // 将文件中的数据读入到 Map 中
    public void loadData(String filename, HashMap<String, Student> boyData, HashMap<String, Student> girlData) throws IOException {
        File file = new File(filename); // 新建一个文件
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file))); // 新建一个 reader
        String line;
        int maleRank = 1, femaleRank = 1; // 男女排名
        // 读到文件末尾
        while ((line = reader.readLine()) != null) {
          String[] parts = line.split(","); // 用逗号分割字符串
          String name = parts[0];
          String gender = parts[1];
          int peopleUse = Integer.parseInt(parts[2]);
          if (gender.equals("M")) {
            boyData.put(name, new Student(name,gender,peopleUse,maleRank));
            maleRank++;
          } else if (gender.equals("F")) {
            girlData.put(name, new Student(name,gender,peopleUse,femaleRank));
            femaleRank++;
          }
        }
        reader.close();
    }
    public void loadDataByRank(File f, Student[] boyData, Student[] girlData) throws Exception{
        File file = f; // 新建一个文件
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file))); // 新建一个 reader
        String line;
        int maleRank = 1, femaleRank = 1; // 男女排名
        // 读到文件末尾
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(","); // 用逗号分割字符串
            String name = parts[0];
            String gender = parts[1];
            int peopleUse = Integer.parseInt(parts[2]);
            if (gender.equals("M")) {
                boyData[maleRank]=(new Student(name,gender,peopleUse,maleRank));
                maleRank++;

            } else if (gender.equals("F")) {
                girlData[femaleRank]=(new Student(name,gender,peopleUse,femaleRank));
                femaleRank++;
            }
        }
        reader.close();
    }
    public void testNameRank() throws IOException {
    Scanner scanner = new Scanner(System.in);

    // 提示输入年份
    System.out.print("Enter the year: ");
    int year = scanner.nextInt();

    // 两个 Map 分别存储男孩和女孩的数据
    HashMap<String, Student> boyData = new HashMap<>();
    HashMap<String, Student> girlData = new HashMap<>();

    if (year == 2020) {
      loadData("/Users/hugo/02大二/Java/Java Homework/src/hw4/yob2020.txt", boyData, girlData);
    } else if (year == 2021) {
      loadData("/Users/hugo/02大二/Java/Java Homework/src/hw4/yob2021.txt", boyData, girlData);
    } else {
      System.out.println("Invalid year.");
      return;
    }

    // 提示输入性别和名字
    System.out.print("Enter the gender (M/F): ");
    String gender = scanner.next();

    System.out.print("Enter the name: ");
    String name = scanner.next();

    HashMap<String, Student> data;
    if (gender.equals("M")){
        data = boyData;
    } else if(gender.equals("F")){
        data = girlData;
    } else {
        System.out.print("Invaile gender");
        return;
    }
    
    Student student = data.get(name);
    if (student == null) {
      System.out.println("The name " + name + " is not ranked in year " + year);
    } else {
      System.out.println(name + " is ranked #" + student.getRank() + " in year " + year);
    }

    scanner.close();
  }
    public static class Student{
        String name;
        int rank;
        int numberUse;
        String gender;
        public Student(String name, String gender, int numberUse, int rank){
            this.name = name;
            this.gender = gender;
            this.numberUse = numberUse;
            this.rank = rank;
        }
        public String getName(){
            return name;
        }
        public int getRank(){
            return rank;
        }
        public int getNumberUse(){
            return numberUse;
        }
        public String getGender(){
            return gender;
        }
    }
}


  