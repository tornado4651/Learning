package design_pattern.principle.open_close;

public class Ocp2 {

    public static void main(String[] args) {
        //使用看看存在的问题
        GraphicEditor2 graphicEditor = new GraphicEditor2();
        graphicEditor.drawShape(new Rectangle2());
        graphicEditor.drawShape(new Circle2());
        // 新增需求,直接传入使用即可，不需要任何改动
        graphicEditor.drawShape(new Triangle2());
    }

}

//这是一个用于绘图的类 [使用方]
class GraphicEditor2 {
    //接收Shape对象，然后根据type，来绘制不同的图形
    public void drawShape(Shape2 s) {
        // 这里因为对修改关闭，使用了扩展方法，所以不需要任何更改
        s.draw();
    }
}

abstract class Shape2 {
    int m_type;
    public abstract void draw();
}

class Rectangle2 extends Shape2 {
    Rectangle2() {
        super.m_type = 1;
    }
    @Override
    public void draw() {
        System.out.println(" 绘制矩形 ");
    }
}

class Circle2 extends Shape2 {
    Circle2() {
        super.m_type = 2;
    }
    @Override
    public void draw() {
        System.out.println(" 绘制圆形 ");
    }
}

// 新增需求：使用扩展方法画三角形
class Triangle2 extends Shape2 {
    Triangle2() {
        super.m_type = 3;
    }
    @Override
    public void draw() {
        System.out.println(" 绘制三角形 ");
    }
}
