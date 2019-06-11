import java.util.*;

public class Main{
    static class Student{
        public String  name;
        public int score;
        //private Node next;
        public Student(String name,int score){
            this.name = name;
            this.score = score;
        }
    }

    public static  void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int flag =sc.nextInt();
            List<Student> li = new  ArrayList<Student>();
            for(int i = 0;i < n; i++){
                li.add(new Student(sc.next(),sc.nextInt()));
            }
            if(flag == 0){
                //降序
                Collections.sort(li, new Comparator<Student>()
                {
                    public int compare(Student o1,Student o2)
                    {
                        return o2.score-o1.score;
                    }
                });
            }else{
                //升序
                Collections.sort(li, new Comparator<Student>()
                {
                    public int compare(Student o1,Student o2)
                    {
                        return o1.score-o2.score;
                    }
                });
            }
            //输出
            for(int j= 0;j < n;j++)
            {
                System.out.println(li.get(j).name+" "+li.get(j).score);
            }
        }
    }
}
