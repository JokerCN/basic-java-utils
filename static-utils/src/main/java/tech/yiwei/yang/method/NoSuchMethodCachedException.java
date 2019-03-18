package tech.yiwei.yang.method;

public class NoSuchMethodCachedException extends RuntimeException {
	private final static String format = "No such method registered, please check the method name {%s}.";

	private String methodName;

	public NoSuchMethodCachedException(String methodName){
		this.methodName = methodName;
	}

	@Override
	public String getMessage() {
		return String.format(format, methodName);
	}
}
