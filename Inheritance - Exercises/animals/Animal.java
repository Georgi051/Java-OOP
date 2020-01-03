package inheritance.animals;

public abstract class Animal {
    private String name;
    private int age;
    private String gender;

    public Animal(String name, int age, String gender) {
        this.name = name;
        this.setAge(age);
        this.setGender(gender);
    }

    private void setAge(int age) {
        ageCheck(age);
        this.age = age;
    }

    public void ageCheck(int age){
        if (age <= 0) {
            throw new IllegalArgumentException("Invalid input!");
        }
    }

    public void setName(String name) {
        checkIsEmpty(name);
        this.name = name;
    }

    public void setGender(String gender) {
        checkIsEmpty(gender);
        this.gender = gender;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public String getGender() {
        return this.gender;
    }

    private void checkIsEmpty(String type) {
        if (type.isEmpty()){
            throw new IllegalArgumentException("Invalid input!");
        }
    }

    public abstract String produceSound();

    @Override
    public String toString() {
       return String.format("%s%n%s %d %s%n%s"
               ,this.getClass().getSimpleName()
               ,this.getName()
               ,this.getAge()
               ,this.getGender()
               ,this.produceSound());
    }
}
