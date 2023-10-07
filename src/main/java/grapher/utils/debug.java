package grapher.utils;

import java.lang.reflect.Field;

public class debug {
    public static void log(Object o){
        System.out.println(o.toString());
    }

    public static void error(String s) {
        System.out.println(s);
    }
}
