abstract class GraphicObject {

    int x, y;

    void moveTo(int newX, int newY) {
        System.out.println("In the main Stack");
        System.out.println("X :" + newX + ", Y :" + newY);
    }

    abstract void draw();

    abstract void resize();
}

class Circle extends GraphicObject {

    @Override
    public void draw() {
        System.out.println("Circle");
    }

    @Override
    public void resize() {
        System.out.println("Resizing Circle");
    }

    public void moveTo(int i, int j) {
        System.out.println("in the Circle");
        System.out.println("Possition : X :" + i + ", Y :" + j);
    }
}

class Rectangle extends GraphicObject {

    @Override
    public void draw() {
        System.out.println("Rectangle");
    }

    @Override
    public void resize() {
        System.out.println("Resizing Rectangle");
    }
}

public class OopAbstraction {

    public static void main(String[] args) {
        GraphicObject circle = new Circle();
        circle.draw();
        circle.resize();
        circle.moveTo(10, 25);

        GraphicObject rectangle = new Rectangle();
        rectangle.draw();
        rectangle.resize();
        rectangle.moveTo(10, 20);
    }
}
