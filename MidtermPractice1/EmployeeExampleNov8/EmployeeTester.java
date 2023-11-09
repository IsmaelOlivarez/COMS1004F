package MidtermPractice1.EmployeeExampleNov8;

public class EmployeeTester {
    public static void main(String[] args) {
        Employee a = new Employee("Jim", 10000);

        Manager b = new Manager("Paul", 100000, 30000);

        System.out.println(b.toString());
        System.out.println(a.toString());
        System.out.println(b);

        Employee e2 = b;
        System.out.println(e2.getTotalComp());

        //Cant do this because Employee does not have a method called such things, but it does have 'getTotalComp'
        //After that, it will use the most recent one, being the overridden one that b has made in the 
        //Manager class.
        //e2.setBonus(10);

        Employee[] people = new Employee[3];
        people[0] = a;
        people[1] = b;
        people[2] = e2; //just a reference of b tbh

        for(Employee x : people){
            System.out.println(x);
        }

        //Manager m2 = e2; no workie--All managers are employees, but not all employees are managers


    }
}
