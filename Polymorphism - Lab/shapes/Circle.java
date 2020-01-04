package polymorphism.shapes;

public class Circle extends Shape{
    private Double radius;

    public Circle(Double radius) {
        this.radius = radius;
    }

    public final Double getRadius() {
        return this.radius;
    }

    @Override
    public void calculatePerimeter() {
        super.setPerimeter(2 * Math.PI * this.getRadius());
    }

    @Override
    public void calculateArea() {
        Double result =  Math.PI * Math.pow(this.getRadius(),2);
        super.setArea(result);
    }
}
