package tech.yiwei.yang.registry;

import com.google.common.collect.Maps;

import java.util.Map;
import java.util.function.Function;

public abstract class RegistryAdapter<T, R> implements Registry<T, R> {
    private final Map<String, Function<T, R>> registry = Maps.newConcurrentMap();

    @Override
    public Map<String, Function<T, R>> getRegistry() {
        return registry;
    }
}
