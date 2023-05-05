
import java.util.*;

public class Database {

    private final Map<Long, Person> accountIndexMap;
    private final Map<String, List<Long>> nameIndexMap;
    private final Map<Double, List<Long>> valueIndexMap;

    public Database() {
        accountIndexMap = new HashMap<>();
        nameIndexMap = new HashMap<>();
        valueIndexMap = new HashMap<>();
    }

    public void add(Person data) {
        accountIndexMap.put(data.getAccount(), data);
        nameIndexMap.computeIfAbsent(data.getName(), k -> new ArrayList<>()).add(data.getAccount());
        valueIndexMap.computeIfAbsent(data.getValue(), k -> new ArrayList<>()).add(data.getAccount());;
    }

    public void remove(long account) {
            if(accountIndexMap.containsKey(account)) {
                Person person=accountIndexMap.get(account);

                accountIndexMap.remove(account);

                List<Long> nameIndexes = nameIndexMap.get(person.getName());
                nameIndexes.remove(account);
                if (nameIndexes.isEmpty()) {
                    nameIndexMap.remove(person.getName());
                }
                List<Long> valueIndexes = valueIndexMap.get(person.getValue());
                valueIndexes.remove(account);
                if (valueIndexes.isEmpty()) {
                    valueIndexMap.remove(person.getValue());
                }
            }
    }

    public void update(Person person) {
        if(accountIndexMap.containsKey(person.getAccount())) {
            this.remove(person.getAccount());
            this.add(person);
        }
    }

    public Person getByAccount(long account) {
        if (accountIndexMap.containsKey(account)) {
            return accountIndexMap.get(account);
        }
        return null;
    }

    public List<Person> getByName(String name) {
        List<Long> nameIndexes = nameIndexMap.get(name);
        if (nameIndexes != null) {
            List<Person> result = new ArrayList<>();
            for (long index : nameIndexes) {
                Person data = accountIndexMap.get(index);
                if (data != null) {
                    result.add(data);
                }
            }
            return result;
        }
        return Collections.emptyList();
    }

    public List<Person> getByValue(double value) {
        List<Long> valueIndexes = valueIndexMap.get(value);
        if (valueIndexes != null) {
            List<Person> result = new ArrayList<>();
            for (long index : valueIndexes) {
                Person data = accountIndexMap.get(index);
                if (data != null) {
                    result.add(data);
                }
            }
            return result;
        }
        return Collections.emptyList();
    }


    public void start(){
        boolean flag=true;
        while(flag){
            System.out.println("""
                    1. add record;
                    2. get all;
                    3. get by account;
                    4. get by name;
                    5. get by value;
                    6. update;
                    7. remove;
                    100. exit;
                    """);
            Scanner in = new Scanner(System.in);

            // Reading data using readLine


            int choice = in.nextInt();

            switch (choice){
                case 1:
                    System.out.println("Введите account");
                    long account=in.nextLong();
                    System.out.println("Введите name");
                    String name=in.next();
                    System.out.println("Введите value");
                    double value=in.nextDouble();
                    this.add(new Person(account,name,value));
                    break;
                case 2:
                    System.out.println(accountIndexMap);
                    break;
                case 3:
                    System.out.println("Введите account");
                    account=in.nextLong();
                    System.out.println(this.getByAccount(account));
                    break;
                case 4:
                    System.out.println("Введите name");
                    name=in.next();
                    System.out.println(this.getByName(name));
                    break;
                case 5:
                    System.out.println("Введите value");
                    value=in.nextDouble();
                    System.out.println(this.getByValue(value));
                    break;
                case 6:
                    System.out.println("Введите account");
                    account=in.nextLong();
                    System.out.println("Введите name");
                     name=in.next();
                    System.out.println("Введите value");
                    value=in.nextDouble();
                    this.update(new Person(account,name,value));
                    break;
                case 7:
                    System.out.println("Введите account");
                    account=in.nextLong();
                    this.remove(account);
                    break;
                case 100:
                    flag=false;
                    break;
            }
        }
    }

}
