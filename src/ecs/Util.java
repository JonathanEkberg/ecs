package ecs;

public class Util {
    private Util() {
        super();
    }

    public static <T> void println(T arg) {
        java.lang.System.out.println(arg);
    }

    public static <T> void print(T arg) {
        java.lang.System.out.print(arg);
    }
}
