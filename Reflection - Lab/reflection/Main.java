package reflection.reflection;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Main {
    public static void main(String[] args){

        Class reflection = Reflection.class;

        Method[] allMethods = reflection.getDeclaredMethods();


        Arrays.stream(allMethods)
                .filter(method -> method.getName().startsWith("get") && method.getParameterCount() == 0)
                .sorted((f, s) -> f.getName().compareTo(s.getName()))
                .forEach(m -> System.out.println(String.format("%s will return class %s",
                        m.getName(), m.getReturnType().getName())));

        Arrays.stream(allMethods)
                .filter(method -> method.getName().startsWith("set") && method.getParameterCount() != 0)
                .sorted((f, s) -> f.getName().compareTo(s.getName()))
                .forEach(m -> System.out.println(String.format("%s and will set field of class %s",
                                m.getName(), m.getParameterTypes()[0].getName())));

    }
}
