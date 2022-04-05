public class Test {

    public static void main(String[] args) {
        Person p = new Person("Vishwa", 19);

        System.out.println(p);
    }
}


class Person {
    String name ;
    int age ;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
