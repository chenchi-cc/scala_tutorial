package chapter06;

public class Test08_DynamicBindJava {
    public static void main(String[] args) {
        Person8Java person = new Student8Java();
        System.out.println(person.name);    // 静态绑定属性
        person.hello();    // 动态绑定方法
    }
}

class Person8Java {
    String name = "person"; //加不加static都一样
    public void hello() {
        System.out.println("hello person");
    }
}

class Student8Java extends Person8Java {
    String name = "student";
    public void hello() {
        System.out.println("hello student");
    }
}
