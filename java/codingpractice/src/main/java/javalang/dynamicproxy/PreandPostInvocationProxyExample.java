package javalang.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class PreandPostInvocationProxyExample {
	
	public static class MyInvocationHandler implements InvocationHandler {

		Intf o;
		
		public MyInvocationHandler(Impl o) {
			// TODO Auto-generated constructor stub
			this.o = o;
		}
		
		@Override
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			System.out.println("Before..");
			Object ret = method.invoke(o, args);
			System.out.println("After..");
			return ret;
		}
		
	}
	
	public static interface Intf {
		public String convert(int i);
	}
	
	public static class Impl implements Intf {

		@Override
		public String convert(int i) {
			// TODO Auto-generated method stub
			return ">> " + i;
		}
		
	}
	
	public static void main(String [] args) {
		
		Impl imple = new Impl();
		MyInvocationHandler mh = new MyInvocationHandler(imple);
		
		Intf intf = (Intf) Proxy.newProxyInstance(PreandPostInvocationProxyExample.class.getClassLoader(), 
				new Class [] {Intf.class }, 
				mh
				);
		System.out.println(intf.convert(4));
	}
}
