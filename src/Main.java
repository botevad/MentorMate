public class Main {
    public static void main(String[] args) {
        Person person = new Person("Albena", "Female", "Bulgarian", "Orthodox", "QA", "Bulgarian", "0351283437", "Bulgaria");
        Person person1 = new Person("Marius", "MALE", "Italian", "Catholic", null, "Italian", "0352128347", "Italy");
        Person person2 = new Person("John", "other", "English", "Islam", "Support", "American", "0345178347", "USA");

        System.out.println(person);
        System.out.println(person1);
        System.out.println(person2);
        System.out.println();
        person.sayHello();
        person1.sayHello();
        person2.sayHello();
        System.out.println();

        person.celebrateEaster();
        person1.celebrateEaster();
        person2.celebrateEaster();
        System.out.println();

        person.isAdult();
        person1.isAdult();
        person2.isAdult();

        System.out.println();

        person.canTakeLoan();
        person1.canTakeLoan();
        person2.canTakeLoan();
    }
}
