package reflection.highqualitymistakes;

import reflection.reflection.Reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        Class reflection = Reflection.class;

        Method[] allMethods = reflection.getDeclaredMethods();

        Field[] fields = reflection.getDeclaredFields();

        Arrays.stream(fields)
                .filter(field -> !Modifier.isPrivate(field.getModifiers()))
                .sorted(Comparator.comparing(Field::getName))
                .forEach(f -> System.out.println(String.format("%s must be private!",f.getName())));


        Arrays.stream(allMethods)
                .filter(method -> method.getName().startsWith("get") && !Modifier.isPublic(method.getModifiers()))
                .sorted(getComparing())
                .forEach(m -> System.out.println(String.format("%s have to be public!", m.getName())));

        Arrays.stream(allMethods)
                .filter(method -> method.getName().startsWith("set") && !Modifier.isPrivate(method.getModifiers()))
                .sorted(getComparing())
                .forEach(m -> System.out.println(String.format("%s have to be private!", m.getName())));

    }

    private static Comparator<Method> getComparing() {
        return Comparator.comparing(Method::getName);
    }
}
