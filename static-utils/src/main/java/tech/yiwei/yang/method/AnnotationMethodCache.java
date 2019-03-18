package tech.yiwei.yang.method;

import com.google.common.collect.Maps;
import org.reflections.Reflections;
import org.reflections.scanners.MethodAnnotationsScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Set;

public class AnnotationMethodCache {

	private Map<String, Method> methodCache;

	public AnnotationMethodCache(String packageBase, Class<? extends Annotation> annotation){
		methodCache = Maps.newConcurrentMap();
		Reflections reflections = new Reflections(
				new ConfigurationBuilder().setUrls(ClasspathHelper.forPackage(packageBase)).setScanners(new MethodAnnotationsScanner())
		);
		Set<Method> apis = reflections.getMethodsAnnotatedWith(annotation);
		for(Method m : apis){
			methodCache.put(m.getName(), m);
		}
	}

	public Method getMethod(String methodName){
		if(!methodCache.containsKey(methodName)) throw new NoSuchMethodCachedException(methodName);
		return methodCache.get(methodName);
	}

	public Set<String> listAllMethodName(){
		return methodCache.keySet();
	}

}
