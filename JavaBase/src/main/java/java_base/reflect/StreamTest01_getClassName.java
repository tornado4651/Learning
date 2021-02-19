package java_base.reflect;

import java_base.reflect.beans.Address;
import java_base.reflect.beans.Person;
import java_base.reflect.beans.Student;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class StreamTest01_getClassName {

    /**
     * 一、获得反射类的基础信息：名称和包信息等。
     */
    @Test
    public void getClassNameTest() {
        Person person = new Person();
        System.out.println("getClass():      " + person.getClass());
        System.out.println("getSimpleName(): " + person.getClass().getSimpleName());
        System.out.println("getName():       " + person.getClass().getName());
        System.out.println("getPackage():    " + person.getClass().getPackage());
    }


    /**
     * 获取反射类的Class对象：三种方法
     */
    @Test
    public void getClassTest() {
        Class<?> invocation1 = null;
        Class<?> invocation2 = null;
        Class<?> invocation3 = null;
        try {// 最常用的方法
            invocation1 = Class.forName("java_base.reflect.beans.Person");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        invocation2 = new Person().getClass();
        invocation3 = Person.class;
        System.out.println("通过'Class.forName()'方式获得：" + invocation1);
        System.out.println("通过'getClass()'方式获得：     " + invocation2);
        System.out.println("通过'.class'方式获得：         " + invocation3);
    }


    /**
     * 获取反射类的实例化对象
     * 但要需要强转，所以要知道目标转换类型
     */
    @Test
    public void getInstanceTest() {
        try {
            Class<?> personInvocation = Class.forName("java_base.reflect.beans.Person");
            Person person = (Person) personInvocation.newInstance();
            person.setAge(20);
            person.setName("Tornado4651");
            person.setAddress(new Address("北京", "天安门"));
            System.out.println("通过'newInstance()'方法获得的实例化对象：" + person);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    /**
     * 使用.getConstructor获得反射类的构造方法
     */
    @Test
    public void testConstruct() {
        try {
            Class<?> personInvocation = Class.forName("java_base.reflect.beans.Person");
            Constructor<?>[] cons = personInvocation.getConstructors();
            System.out.println("遍历使用'.getConstructors()'获得的构造器数组：");
            for (int i = 0; i < cons.length; i++) {
                System.out.println(cons[i]);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    /**
     * 对构造方法进行获取解析
     */
    @Test
    public void constructGetInstance() {
        try {
            Class<?> personInvocation = Class.forName("java_base.reflect.beans.Person");
            Constructor<?>[] cons = personInvocation.getConstructors();
            Constructor constructor = cons[1];
            System.out.println("对所有构造方法中的第二个进行具体属性解析：\n【" + constructor + "】");
            System.out.println("name:           " + constructor.getName());
            System.out.println("modifier:       " + constructor.getModifiers());
            System.out.println("parameterCount: " + constructor.getParameterCount());
            System.out.print("构造参数类型如下： ");
            for (int i = 0; i < constructor.getParameterTypes().length; i++) {
                System.out.print(" " + constructor.getParameterTypes()[i].getName());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 通过'.getInterfaces()'方法获得当前反射对象的接口
     */
    @Test
    public void testGetInterfaces() throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Class<?> studentClass = Class.forName("java_base.reflect.beans.Student");
        Class<?>[] interfaces = studentClass.getInterfaces();
        System.out.println("遍历studentClass反射类的所有接口：" + interfaces.toString());
        for (Class c : interfaces) {
            // 获取接口
            System.out.println("当前接口：" + c);
            // 获取接口里面的方法
            Method[] methods = c.getMethods();
            System.out.println("开始遍历当前接口" + c + "的所有方法：" + methods);
            // 遍历接口的方法
            for (Method method : methods) {
                // 通过反射创建对象
                Student student = (Student) studentClass.newInstance();
                // 通过反射调用方法
                method.invoke(student, null);
            }
        }
    }


    /**
     * 使用反射获取父类
     * 并使用'.getDeclaredMethods()'获取声明的方法
     * 并使用method.invoke(instance, args...)反射调用该方法
     */
    @Test
    public void testGetSuperclass() throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Class<?> dogsClass = Class.forName("java_base.reflect.beans.Dogs");
        Class<?> dogSuperclass = dogsClass.getSuperclass();
        System.out.println("Dogs的父类是：【" + dogSuperclass.toString() + "】");
        System.out.println("调用Dogs的方法：");
        Method[] dogsMethods = dogsClass.getDeclaredMethods();
        for (Method dogsMethod : dogsMethods) {
            System.out.print(dogsMethod.getName() + ":  ");
            dogsMethod.invoke(dogsClass.newInstance());
        }
        System.out.println("调用父类的方法：");
        Method[] superclassMethods = dogSuperclass.getDeclaredMethods();
        for (Method superclassMethod : superclassMethods) {
            System.out.print(superclassMethod.getName() + ":  ");
            superclassMethod.invoke(dogSuperclass.newInstance());
        }
    }


    /**
     * 获取反射类的公有属性和私有属性以及更新
     */
    @Test
    public void tsetGetFilds() throws ClassNotFoundException {
        Class<?> invokeClass = Class.forName("java_base.reflect.beans.Person");
        Field[] fields = invokeClass.getFields();
        System.out.println("这是使用'.getFields()'获得的所有属性：");
        for (Field field : fields) {
            System.out.println(field.getGenericType() + "  " + field.getName());
        }
        System.out.println("\n这是使用'.getDeclaredFields()'获得的所有属性");
        Field[] declaredFields = invokeClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField.getGenericType() + "  " + declaredField.getName());
            // 对于非public范围的，使用filed.setAttribute(true)获得操作权限
            // Field field = invokeClass.getDeclaredField("age");
            // field.setAccess(true);
            // field.set(invokeClass.newInstance(),null);
        }

    }

}
