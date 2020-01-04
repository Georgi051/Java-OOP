package polymorphism.word;

import java.util.Deque;

public class PasteTransform implements TextTransform {
    private Deque<String> memory;

    public PasteTransform(Deque<String> arrayDeque) {
        this.memory = arrayDeque;
    }

    @Override
    public void invokeOn(StringBuilder text, int startIndex, int endIndex) {
        if (startIndex == endIndex){
            text.insert(startIndex, memory.peek());
        }else{
            if (memory.peek() != null) {
                text.replace(startIndex, endIndex, memory.peek());
            }
        }
    }
}
