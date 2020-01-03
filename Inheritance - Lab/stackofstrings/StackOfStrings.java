package inheritance.stackofstrings;

import java.util.ArrayList;

public class StackOfStrings {
    private ArrayList<String> data;

    public StackOfStrings() {
        this.data = new ArrayList<>();
    }

    public void push(String item){
        data.add(item);
    }

    public String pop(){
        int index = data.size() - 1;
        return data.remove(index);
    }

    public String peek(){
        int index = data.size() - 1;
        return data.get(index);
    }

    public boolean isEmpty(){
        return data.isEmpty();
    }
}
