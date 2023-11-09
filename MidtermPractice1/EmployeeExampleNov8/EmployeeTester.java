package MidtermPractice1.EmployeeExampleNov8;

public class EmployeeTester {
    public static void main(String[] args) {
        Employee a = new Employee("Jim", 10000);

        Manager b = new Manager("Paul", 100000, 30000);

        System.out.println(b.toString());
        System.out.println(a.toString());
        System.out.println(b);

    }
}
