package javalang.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;

public class MyProxy implements InvocationHandler {

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		
		System.out.println(method);
		return "257";
	}
	
	public static void main(String[] args) {
		
		Map<String, String> proxyInstance = (Map) Proxy.newProxyInstance(
				Map.class.getClassLoader(), 
				  new Class[] { Map.class }, 
				  new MyProxy());
		
		System.out.println(proxyInstance.get("Khuki"));
	}

}
