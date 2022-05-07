package Overlapping;

public class Main {
    public static void main(String[] args) throws Exception {
        Person p1 = new Person(1,"Mark","Pak","cleaner");
        Person p2 = new Person(2,"Mark","Twen",12);
        Person p3 = new Person(3,"Den","Mark",12,"security");

        System.out.println(p1.getRentCosts());
        System.out.println(p2.getRentCosts());
        System.out.println(p3.getRentCosts());

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
    }
}
