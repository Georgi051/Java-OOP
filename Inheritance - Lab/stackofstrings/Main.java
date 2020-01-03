package inheritance.stackofstrings;

public class Main {
    public static void main(String[] args) {
        StackOfStrings stack = new StackOfStrings();

        stack.push("da");
        stack.push("ne");
        stack.push("ili");

        System.out.println(stack.isEmpty());
        System.out.println(stack.peek());

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
