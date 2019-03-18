package tech.yiwei.yang.registry;

public interface Handler<T,R> {
    R handle(String path, T data);
}
