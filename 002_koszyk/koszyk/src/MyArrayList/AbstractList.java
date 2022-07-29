package MyArrayList;

import java.util.Arrays;

public abstract class AbstractList<T> {

    T[] list;

    public AbstractList(T[] list) {
        this.list = list;
    }

    public T get(int index) {
        return this.list[index];
    }

    public T[] getList() {
        return this.list;
    }

    public void add(T newEl) {
        this.list = Arrays.copyOf(this.list, this.list.length + 1);
        this.list[this.list.length - 1] = newEl;
    }
}
