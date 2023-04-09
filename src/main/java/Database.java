import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Database {
    private TreeMap<Long,Person> people=new TreeMap<>();
    private HashMap<Long,Person> people1=new HashMap<>();
//    лучше хэш мап по использованию памяти, будем искать по account за O(log(n))
//    хэшмап быстрее
    public Database() {
        System.out.println("database created");
    }
    public void start(){
        boolean flag=true;
        while(flag){
            System.out.println("""
                    1. add record;
                    2. delete record;
                    3. edit record;
                    """);
            Scanner in = new Scanner(System.in);

            // Reading data using readLine


            int choice = in.nextInt();

            switch (choice){
                case 1:
//                    System.out.println("Введите account");
//                    long account=in.nextLong();
//                    System.out.println("Введите name");
//                    String name=in.nextLine();
//                    System.out.println("Введите value");
//                    double value=in.nextDouble();
//                    people.put(account,new Person(account,name,value));
                    Random rand = new Random();
                    long startTime = System.currentTimeMillis();
                    for(int i=0;i<10000;i++){
                        long account=rand.nextLong(1002)*i;
                        people1.put(account,new Person(account,"rwrwq"+i+rand.nextInt(30), rand.nextDouble(30000)));
                    }
                    long stopTime = System.currentTimeMillis();
                    long elapsedTime = stopTime - startTime;
                    System.out.println(elapsedTime);
                    break;
                case 2:
                    System.out.println(people);
                    break;
                case 100:
                    flag=false;
                    break;
            }
        }
    }

}
