package model.iterator;

import java.util.Iterator;
import java.util.List;

public class PetIterator<T> implements Iterator<T> {
    private int index;
    private List<T> petList;

    public PetIterator(List<T> petList) {
        this.petList = petList;
    }

    @Override
    public boolean hasNext() {
        return petList.size() > index;
    }

    @Override
    public T next() {
        return petList.get(index++);
    }
}
