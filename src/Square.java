public class Square extends Rectangle{
    private double side;

    public Square(double side, String color, boolean filled) {
        super (color, filled);
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    @Override
    public double getArea() {
        return Math. pow(side, 2) ;
    }

    @Override
    public double getPerimeter() {
        return 4 * side;
    }

    @Override
    public String toString() {
        return "Square{" +
                "side=" + side + ", color=" + super.getColor() + ", filled=" + super.isFilled() +
                '}';
    }
}
