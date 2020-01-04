package polymorphism.shapes;

public class Rectangle extends Shape {
    private Double height;
    private Double width;

    public Rectangle(Double height, Double width) {
        this.height = height;
        this.width = width;
    }

    public Double getHeight() {
        return this.height;
    }

    public Double getWidth() {
        return this.width;
    }

    @Override
    public void calculatePerimeter() {
        Double result = 2 * (this.getHeight() + this.getWidth());
        super.setPerimeter(result);
    }

    @Override
    public void calculateArea() {
        super.setArea(this.getHeight() * this.getWidth());
    }
}
