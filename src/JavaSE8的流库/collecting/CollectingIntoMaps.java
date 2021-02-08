package JavaSE8的流库.collecting;

import java.util.stream.Stream;

public class CollectingIntoMaps {
    public static class Person {
        private int id;
        private String name;

        public Person(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        @Override public String toString() {
            return "Person{" + "id=" + id + ", name='" + name + '\'' + '}';
        }
    }

    public static Stream<Person> people() {
        return Stream.of(new Person(1001, "Peter"), new Person(1002, "Paul"), new Person(1003, "Mary"));
    }
}
