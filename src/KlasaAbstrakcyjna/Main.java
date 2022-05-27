package KlasaAbstrakcyjna;

public class Main {
    public static void main(String[] args) {

        Person g1 = new Gardener(1,"Mad", "Dik" ,50);
        System.out.println(g1);
        System.out.println("salary: "+g1.getSalary() + "\n");

        Person c1 = new Cleaner(1,"xd","xd", 15);
        System.out.println(c1);
        System.out.println("salary: "+c1.getSalary() + "\n");

        Person s1 = new Security(1,"xd","xd", 25);
        System.out.println(s1);
        System.out.println("salary: "+s1.getSalary());

    }
}
