package encapsulation.animalfarm;

public class Chicken {
    private String name;
    private int age;

    public Chicken(String name, int age) {
        this.setName(name) ;
        this.setAge(age);
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        checkForValidName(name);
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    private void setAge(int age) {
        checkForAge(age);
        this.age = age;
    }

    private void checkForAge(int age) {
        if (age < 1 || age > 15){
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        }
    }

    private void checkForValidName(String name) {
        if (name.length() < 1){
            throw new IllegalArgumentException("Name cannot be empty");
        }
    }


    public double productPerDay(){
       return calculateProductPerDay();
    }

    public double calculateProductPerDay(){
        double eggs = 0;
        if (this.getAge() <= 5){
            eggs = 2;
        }else if (this.getAge() <= 11){
            eggs = 1;
        }else {
            eggs = 0.75;
        }
        return eggs;
    }

    @Override
    public String toString() {
        return String.format("Chicken %s (age %d) can produce %.2f eggs per day."
        ,this.getName(),this.getAge(),this.productPerDay());
    }
}
