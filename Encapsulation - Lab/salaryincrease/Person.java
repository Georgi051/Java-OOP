package encapsulation.salaryincrease;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public Person(String firstName, String lastName, int age, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.setSalary(salary);
    }

    private void setSalary(double salary) {
        this.salary = salary;
    }


    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public int getAge() {
        return this.age;
    }

    private double getSalary() {
        return this.salary;
    }


    public void increaseSalary(double bonus) {
        double increaseSalary;
        double salary = this.getSalary();

        if (this.getAge() < 30) {
            increaseSalary = (salary * bonus / 200);
            salary += increaseSalary;
        } else {
            increaseSalary = (salary * bonus / 100);
            salary += increaseSalary;
        }
        this.setSalary(salary);
    }

    @Override
    public String toString() {
        return String.format("%s %s gets %f leva"
                , this.getFirstName()
                , this.getLastName()
                , this.getSalary());
    }
}
