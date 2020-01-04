package blackBoxInteger;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Scanner scanner = new Scanner(System.in);

        Class blackBoxIntClass = BlackBoxInt.class;

        Constructor constructor = blackBoxIntClass.getDeclaredConstructor();
        constructor.setAccessible(true);


        BlackBoxInt constructorInstance = (BlackBoxInt) constructor.newInstance();
        Method[] methods = blackBoxIntClass.getDeclaredMethods();

        Field innerValue = blackBoxIntClass.getDeclaredField("innerValue");
        innerValue.setAccessible(true);

        String line = scanner.nextLine();
        while (!"END".equals(line)){
            String[] data = line.split("_");
            String operationType = data[0];
            int value = Integer.parseInt(data[1]);

            for (Method method : methods) {
                String name = method.getName();
                if (name.equals(operationType)){
                    method.setAccessible(true);
                    method.invoke(constructorInstance,value);
                    System.out.println(innerValue.get(constructorInstance));
                    break;
                }
            }
            line = scanner.nextLine();
        }
    }
}
