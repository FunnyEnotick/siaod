import java.util.ArrayList;

public class Stack<T> {
    public static final int N = 1000;
    Object[] data;
    int last;

    public Stack(int capacity) {
        this.data = new Object[capacity];
        this.last = 0;
    }

    public Stack() {
        this(N);
    }

    public boolean isEmpty() {
        return last == 0;
    }

    public void pushBack(T value) {
        if (last == data.length) {
            throw new Error("Stack overflow");
        }
        this.data[last] = value;
        last += 1;
    }

    public T popBack() {
        if (last == 0) {
            return null;
        } else {
            T el = (T) this.data[last-1];
            this.data[last-1] = null; // Удаляем объект
            last -= 1;
            return el;
        }
    }

    public T end() {
        if (last == 0) return null;
        else return (T) data[last-1];
    }

    public int size() {
        return last;
    }
}


