/**
 * Created by ducdh1210 on 10/11/14.
 */

package JavaCollection.Comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;

class StringLengthComparator implements Comparator<String>{

    @Override
    public int compare(String s1, String s2) {
        if (s1.length() > s2.length()) return 1;
        else if (s1.length() < s2.length()) return -1;
        else return 0;
    }
}

class AlphabeticalComparator implements Comparator<String>{

    @Override
    public int compare(String s1, String s2) {
        return s1.compareTo(s2);
    }
}

class ReverseComparator implements Comparator<String>{

    @Override
    public int compare(String s1, String s2) {
        return s1.compareTo(s2)*(-1);
    }
}

class Person{
    private int id;
    private String name;

    Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }


}

public class ComparatorExample {

    public static void main(String[] args) {
        List<String> animals = new ArrayList<String>();
        animals.add("elephant");
        animals.add("tiger");
        animals.add("lion");
        animals.add("cat");
        animals.add("snake");
        animals.add("mongoose");

        Collections.sort(animals);
        Collections.sort(animals, new StringLengthComparator());
        Collections.sort(animals, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareTo(s2)*(-1);
            }
        });

        System.out.println(animals);

        List<Integer> numbers = new ArrayList<Integer>();
        numbers.add(3);
        numbers.add(36);
        numbers.add(73);
        numbers.add(40);
        numbers.add(1);

        Collections.sort(numbers);
        System.out.println(numbers);

        /**  Sort Person  **/
        List<Person> people = new ArrayList<Person>();
        people.add(new Person(1,"Joe"));
        people.add(new Person(2,"Bob"));
        people.add(new Person(3,"Sue"));
        people.add(new Person(4,"Ann"));

        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                return p1.getName().compareTo(p2.getName());
            }
        });

        System.out.println(people);

    }
}
