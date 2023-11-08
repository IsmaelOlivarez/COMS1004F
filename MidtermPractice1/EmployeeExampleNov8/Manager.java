package MidtermPractice1.EmployeeExampleNov8;

//Manager inherits all of the public stuff of all of the public aspects of 'Employee.java'
/*
 * Our Classes: Employee     ,     Manager
 * Manager extends Employee meaning...
 * Employee --> Manager   | Employee is the parent class of Manager.
 * Manager has access to anything PUBLIC from the employee class. Nothing private.
 * Can override a number of things, specifically mehthods.
 * 
 */

public class Manager extends Employee {

    private int bonus;

    //If there is no default constructor, you must include a 'super' one. :3
    public Manager(String name, int salary, int bonus) {
        super(name, salary);
        this.bonus = bonus;
    }

    public void setBonus(int bonus){
        this.bonus = bonus;
    }

    //Overriding the 'getTotalComp' method in 'Employee' for the 'Manager' class.
    public int getTotalComp(){
        return super.getTotalComp() + bonus;
    }

    // super() - Constructors
    // super.'name of method' - Methods


    
}
