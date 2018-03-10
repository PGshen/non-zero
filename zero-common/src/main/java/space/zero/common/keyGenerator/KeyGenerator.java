package space.zero.common.keyGenerator;

public interface KeyGenerator<T> {
    T getNext(String type);
    T getNext();
}
