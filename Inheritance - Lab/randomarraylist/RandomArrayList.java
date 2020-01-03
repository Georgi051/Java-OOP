package inheritance.randomarraylist;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList<T> extends ArrayList<T> {

    public T getRandomElement(){
        int index = this.getRandomIndex();
        return super.remove(index);
    }

    private int getRandomIndex() {
        Random random = new Random();
      return random.nextInt(super.size());
    }
}
