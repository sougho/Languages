package javalang.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicImplementationOfIntfExample {
	
	public static interface Intf {
		public String convertToStr(int i);
	}

	public class MyInvoker implements InvocationHandler {

		@Override
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			// TODO Auto-generated method stub
			
			System.out.println(method);
			System.out.println(args);
			return null;
		}
		
		
	}
}
