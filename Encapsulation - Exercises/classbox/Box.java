package encapsulation.classbox;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        this.setLength(length);
        this.setWidth(width);
        this.setHeight(height);
    }

    private void setHeight(double height) {
        checkForNegativeNum(height, "Height");
        this.height = height;
    }

    private void setWidth(double width) {
        checkForNegativeNum(width, "Width");
        this.width = width;
    }

    private void setLength(double length) {
        checkForNegativeNum(length, "Length");
        this.length = length;
    }

    private void checkForNegativeNum(double side, String type) {
        if (side <= 0){
            throw  new IllegalArgumentException(type + " cannot be zero or negative.");
        }
    }

    public double calculateSurfaceArea (){
        return 2*length*width + 2*length*height + 2*width*height;
    }

    public double calculateLateralSurfaceArea (){
        return 2*length*height + 2*width*height;
    }

    public double calculateVolume (){
        return  length*height*width;
    }

    @Override
    public String toString() {
        return String.format("Surface Area - %.2f%n"
                + "Lateral Surface Area - %.2f%n"
                + "Volume – %.2f%n",calculateSurfaceArea(),calculateLateralSurfaceArea(),calculateVolume());
    }
}
