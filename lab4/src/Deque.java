
public class Deque<T> extends Stack<T> {

    public void pushFront(T value) {
        if (last == data.length) {
            throw new Error("Overflow");
        }
        for (int i = last; i > 0; i--) {
            data[i] = data[i - 1];
        }
        this.data[0] = value;
        last += 1;
    }

    public T popFront() {
        if (last == 0) {
            return null;
        } else {
            T el = (T) this.data[0];
            for (int i = 0; i < last-1; i++) {
                data[i] = data[i + 1];
            }
            this.data[last-1] = null; // Удаляем объект
            last -= 1;
            return el;
        }
    }

    public T begin() {
        if (last == 0) {
            return null;
        } else {
            return (T) data[0];
        }
    }

}
