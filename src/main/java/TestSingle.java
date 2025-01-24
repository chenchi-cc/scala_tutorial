public class TestSingle {
    public void run() {
        Single s1 = Single.getInstance();
        Single s2 = Single.getInstance();
        System.out.println(s1 == s2);

        Single2 s3 = Single2.getInstance();
        Single2 s4 = Single2.getInstance();
        System.out.println(s3 == s4);
    }

    public static void main(String[] args) {
        new TestSingle().run();
    }
}

class Single {
    private static Single instance = new Single();

    private Single() {
    }

    public static Single getInstance() {
        return instance;
    }
}

class Single2 {
    private static Single2 instance;

    private Single2() {
    }

    public static Single2 getInstance() {
        if (instance == null) {
            instance = new Single2();
        }
        return instance;
    }
}
