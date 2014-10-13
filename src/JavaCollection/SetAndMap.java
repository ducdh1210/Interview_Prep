/**
 * Created by ducdh1210 on 10/11/14.
 */

package JavaCollection;

import java.util.*;

/**
 * Note: if you want to used customised object as key or value in Map or Set, need to implement equals(Object o) and
 * hashCode() method in order to maintain the "unique key" principle in Map and Set
 * **/

class Person{
    private int id;
    private String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name=" + name +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;

        Person person = (Person) o;

        if (id != person.id) return false;
        if (name != null ? !name.equals(person.name) : person.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}

public class SetAndMap {
    public static void main(String[] args) {
        /*Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("One",4);
        map.put("Two",2);
        map.put("Three",3);
        map.put("One",1);

        for (String key : map.keySet()){
            System.out.println( key + " : " + map.get(key) );
        }

        System.out.println(map.size());*/

        /*Map<String, Integer> map = new LinkedHashMap<String, Integer>();
        map.put("One",4);
        map.put("Two",2);
        map.put("Three",3);
        map.put("One",1);

        for (String key : map.keySet()){
            System.out.println( key + " : " + map.get(key) );
        }

        System.out.println(map.size());


        Set<String> set = new LinkedHashSet<String>();
        set.add("dog");
        set.add("cat");
        set.add("mouse");
        set.add("cat");

        System.out.println(set);*/

        Person p1 = new Person(0, "Bob");
        Person p2 = new Person(1, "Sue");
        Person p3 = new Person(2, "Mike");
        Person p4 = new Person(1, "Sue");

        Map<Person, Integer> mapNew = new LinkedHashMap<Person, Integer>();

        mapNew.put(p1,1);
        mapNew.put(p2,2);
        mapNew.put(p3,3);
        mapNew.put(p4,1);
        System.out.println("Test Map:");
        for (Person key : mapNew.keySet()){
            System.out.println( key + " : " + mapNew.get(key) );
        }

        Set<Person> set = new LinkedHashSet<Person>();
        set.add(p1);
        set.add(p2);
        set.add(p3);
        set.add(p4);
        System.out.println("Test Set:");
        System.out.println(set);

    }

}
