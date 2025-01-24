import java.lang.reflect.Method;

class Example {
    public void sayHello() {
        System.out.println("Hello, Reflection!");
    }
}

public class ReflectionDemo {
    public static void main(String[] args) throws Exception {
        // 1. 获取类的 Class 对象
        Class<?> cls = Example.class;

        // 2. 创建类的实例
        Object obj = cls.getDeclaredConstructor().newInstance();

        // 3. 获取方法并调用
        Method method = cls.getMethod("sayHello");
        method.invoke(obj);  // 输出：Hello, Reflection!
    }
}