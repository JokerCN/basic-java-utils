package tech.yiwei.yang.registry;

public class HandlerRegistry<T, R> extends RegistryAdapter<T, R> implements Handler<T, R>{

    public R handle(String path, T data){
        if(!getRegistry().containsKey(path)) {
            String errorInfo = String.format("%s is not supported yet.", path);
            throw new UnsupportedOperationException(errorInfo);
        }
        return getRegistry().get(path).apply(data);
    }
}
