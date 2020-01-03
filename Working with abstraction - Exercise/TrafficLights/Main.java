package workingwithabstraction.TrafficLights;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
      // Lights[] lights =  Arrays.stream(scanner.nextLine().split("\\s+"))
      //         .map(Lights::valueOf).toArray(Lights[]::new);

        String[] input = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(scanner.nextLine());

        Lights[] lightsValues = new Lights[input.length];
        for (int i = 0; i < input.length; i++) {
            lightsValues[i] = Lights.valueOf(input[i]);
        }

        Lights[] currentLights = {Lights.RED,Lights.GREEN,Lights.YELLOW};
        StringBuilder sb = new StringBuilder();
        while (n-- > 0){
            for (int i = 0; i < lightsValues.length; i++) {
                int index = (lightsValues[i].ordinal() + 1) % currentLights.length;
                lightsValues[i] = currentLights[index];

               // if (lightsValues[i].ordinal() == 2) {
               //     lightsValues[i] = Lights.RED;
               // }else {
               //     lightsValues[i] = currentLights[lightsValues[i].ordinal() + 1];
               // }
                sb.append(lightsValues[i].toString()).append(" ");
            }
            sb.append(System.lineSeparator());
        }
        System.out.println(sb.toString());
    }
}
