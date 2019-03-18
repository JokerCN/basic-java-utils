package tech.yiwei.yang.registry;

import java.util.Map;
import java.util.Set;
import java.util.function.Function;

public interface Registry<T, R> {

    default void register(String path, Function<T, R> handler){
        getRegistry().put(path, handler);
    }

    default void unRegister(String path){
        getRegistry().remove(path);
    }

    Map<String, Function<T, R>> getRegistry();

    default Set<String> listRegistryKeys(){
        return getRegistry().keySet();
    }
}
