package design_pattern.principle.open_close;

public class Ocp1 {

    public static void main(String[] args) {
        //使用看看存在的问题
        GraphicEditor graphicEditor = new GraphicEditor();
        graphicEditor.drawShape(new Rectangle());
        graphicEditor.drawShape(new Circle());
        // 新增需求
        graphicEditor.drawShape(new Triangle());
    }

}

//这是一个用于绘图的类 [使用方]
class GraphicEditor {
    //接收Shape对象，然后根据type，来绘制不同的图形
    public void drawShape(Shape s) {
        if (s.m_type == 1)
            drawRectangle(s);
        else if (s.m_type == 2)
            drawCircle(s);
        // 当需求改变后（增加三角形的绘制），需要改动使用方的代码，违反了开闭原则
        else if (s.m_type == 3)
            drawTriangle(s);
    }

    public void drawRectangle(Shape r) {
        System.out.println(" 绘制矩形 ");
    }

    public void drawCircle(Shape r) {
        System.out.println(" 绘制圆形 ");
    }

    // 当需求改变后（增加三角形的绘制），需要改动使用方的代码，违反了开闭原则
    public void drawTriangle(Shape r) {
        System.out.println(" 绘制三角形 ");
    }
}

class Shape {
    int m_type;
}

class Rectangle extends Shape {
    Rectangle() {
        super.m_type = 1;
    }
}

class Circle extends Shape {
    Circle() {
        super.m_type = 2;
    }
}

//新增画三角形
class Triangle extends Shape {
    Triangle() {
        super.m_type = 3;
    }
}
