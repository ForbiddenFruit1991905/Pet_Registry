package model.comparator;

import model.services.IRepository;

import java.util.Comparator;

public class ComparatorByDateBirth<T extends IRepository<T>> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}
