package workingwithabstraction.JediGalaxy;

import java.util.Arrays;

public class InputParser {

    public static int[] parseIntArray(String input){
        return Arrays
                .stream(input.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
