package MidtermPractice1.EmployeeExampleNov8;

public class Employee {
    
    private String name;
    private int salary;

    public Employee(String name, int salary){
        this.name = name;
        this.salary = salary;
    }

    public String getName(){
        return name;
    }

    public void setSalary(int s){
        salary = s;
    }

    public int getTotalComp(){
        return salary;
    }

    public String toString(){
        return getName() + " - $" + getTotalComp();
    }

    
}
