package java_base.annotation;

/**
 * 用于"注解学习"的测试类：
 *     自定义注解，见MyAnnotation.java
 * jdk8中注解的新特性：
 *     1）可重复注解：在自定义注解上使用Repeatable元注解，即可使得该自定义注解重复使用（注：需要借助关联注解作为Repeatable的成员变量值）
 *     2）类型注解：见MyAnnotation中的Target元注解记录最后两条
 */
@MyAnnotation
public class AnnotationTest {
    public static void main(String[] args) {

    }
}


