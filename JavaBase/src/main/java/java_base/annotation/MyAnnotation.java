package java_base.annotation;

/**
 * 创建自定义注解：
 *      1、注解声明为：@interface
 *      2、内部成员的定义：
 *      3、指定成员的默认值，用default
 *      4、如果自定义注解没有成员，表明是一个标识作用，如Serializable
 * Jdk中的元注解：对现有的注解进行解释说明
 *      1）Retation：指明所修饰的注解的生命周期，其成员变量为：RetentionPolicy value()
 *                RetentionPolicy为enum枚举类型 ，有三种值
 *                SOURCE：源文件行为，所修饰的注解只保留在源文件中，编译后不保留
 *                CLASS：编译后行为，所修饰的注解只保留在源文件和编译后的字节码文件中，运行时不加载到内存，默认值
 *                RUNTIME：运行时行为，运行后仍然保留，加载到内存，并通过反射机制读取
 *      2）Target：用于指定被修饰的注解可以修饰哪些结构（元素），其成员变量为 ElementType[] value();
 *              ElementType为枚举类，有7种值：
 *              FIELD：类、接口、注解类、枚举
 *              METHOD：方法
 *              PARAMETER：参数
 *              CONSTRUCTOR：构造器
 *              LOCAL_VARIABLE：本地变量
 *              ANNOTATION_TYPE：注解类型
 *              PACKAGE：包
 *              TYPE_PARAMETER：1.8新增：可以修饰范型类型（类定义中）
 *              TYPE_USE：1.8新增：可以修饰范型类型（创建变量名或对象时）、类型强转时、跑出异常前
 *      3）Documented：表示所修饰的注解在被Javadoc解析时保留下来，默认javadoc解析时不保留注解
 *                    如Deprecated注解（过时注解）
 *      4）Inherited：表示所修饰的注解具有继承性（该注解标注的类的子类自动继承该注解）
 * 使用自定义注解：
 *      用到反射知识，即"注解的信息处理流程"
 *
 */
public @interface MyAnnotation {
    String value() default "hello";
}
