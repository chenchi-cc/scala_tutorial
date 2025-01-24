import java.lang.reflect.Method;

public class ReflectionSys {
    public static void main(String[] args) throws Exception {
        // 假设类名和方法名是从配置文件或用户输入读取的
        String className = "TestSingle";
        String methodName = "run";

        // 动态加载类
        Class<?> cls = Class.forName(className);

        // 创建实例
        Object instance = cls.getDeclaredConstructor().newInstance();

        // 调用方法
        Method method = cls.getMethod(methodName);
        method.invoke(instance);
    }

    /*public static void main(String[] args) throws Exception {
        // 假设类名和方法名是从配置文件或用户输入读取的
        String className = "TestSingle";
        String methodName = "main";

        // 动态加载类
        Class<?> cls = Class.forName(className);

        // 获取 main 方法
        Method method = cls.getMethod(methodName, String[].class);

        // 调用 main 方法，传递参数（即使为空，也需要提供 String 数组）
        // 对象传null，是因为是静态方法，不需要对象
        method.invoke(null, (Object) new String[]{}); // 注意 (Object) 是为了避免数组被拆解
    }*/
}
