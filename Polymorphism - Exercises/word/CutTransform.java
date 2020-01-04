package polymorphism.word;

import java.util.Deque;

public class CutTransform implements TextTransform {
    private Deque<String> memory;

    public CutTransform(Deque<String> arrayDeque) {
        this.memory = arrayDeque;
    }

    @Override
    public void invokeOn(StringBuilder text, int startIndex, int endIndex) {
        memory.push(text.substring(startIndex, endIndex));
        if (startIndex != endIndex) {
            text.delete(startIndex, endIndex);
        } else {
            this.memory.pop();
        }
    }
}
