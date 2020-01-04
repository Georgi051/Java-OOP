package harvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	private static final String pattern = "%s %s %s";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String line = scanner.nextLine();
        while (!"HARVEST".equals(line)) {
            Class richSoilLandClass = RichSoilLand.class;
            Field[] fields = richSoilLandClass.getDeclaredFields();
            switch (line) {
                case "private":
                    Arrays.stream(fields).filter(field -> Modifier.isPrivate(field.getModifiers()))
                            .forEach(f -> System.out.println(String.format(pattern,
									Modifier.toString(f.getModifiers())
                                    , f.getType().getSimpleName()
                                    , f.getName())));
                    break;
                case "public":
					Arrays.stream(fields).filter(field -> Modifier.isPublic(field.getModifiers()))
							.forEach(f -> System.out.println(String.format(pattern,
									Modifier.toString(f.getModifiers())
									, f.getType().getSimpleName()
									, f.getName())));
                    break;
                case "protected":
                    Arrays.stream(fields).filter(field -> Modifier.isProtected(field.getModifiers()))
                            .forEach(f -> System.out.println(String.format(pattern,
                                    Modifier.toString(f.getModifiers())
                                    , f.getType().getSimpleName()
                                    , f.getName())));
                    break;
                case "all":
					Arrays.stream(fields).forEach(f -> System.out.println(String.format(pattern,
									Modifier.toString(f.getModifiers())
									, f.getType().getSimpleName()
									, f.getName())));
                    break;
            }
            line = scanner.nextLine();
        }
    }
}
