import java.lang.reflect.Field;

class PersonMan {
    public String name;
}

public class ReflectionTool {
    public static void setFieldValue(Object obj, String fieldName, Object value) throws Exception {
        Field field = obj.getClass().getField(fieldName);
        field.set(obj, value);  // 动态设置字段值
    }

    public static void main(String[] args) throws Exception {
        PersonMan person = new PersonMan();
        setFieldValue(person, "name", "Alice");
        System.out.println(person.name); // 输出：Alice
    }
}
