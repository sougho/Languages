package functional.function;

import java.util.function.Function;

public class Compose {
	
	public static interface MyFunction <T,V> {
		V apply (T t);
	}
	
	public static MyFunction<Integer, Integer> compose (MyFunction<Integer, Integer> f1, MyFunction <Integer, Integer> f2) {
		return x -> f2.apply(f1.apply(x));
	}

	public static void main(String[] args) {
		MyFunction<Integer, Integer> c = compose(x->x*2, x->x+1);
		MyFunction<Integer, Integer> f1 = x->x*2;
		MyFunction<Integer, Integer> f2 = x->x+1;
		MyFunction<Integer, Integer> d = compose(f1,f2);
		System.out.println(d.apply(3));
		
		Function<Integer, Integer> f = MyComposer.<Integer, Integer, Integer>compose(x->x+1, x->x*2);
		System.out.println(f.apply(3));
		
		Function<Integer, String> g = MyComposer.<Integer, Integer, String>compose(x->x+1, x->"V: " + x);
		System.out.println(g.apply(3));
		
	}
	
	public static class MyComposer <T,U,V> {
		public static <T,U,V> Function <T,V> compose(Function<T,U> f1, Function<U,V> f2) {
			return x -> f2.apply(f1.apply(x));
		}
	}
	
	public static class MetaFuncs  {
		
		public static <T> Function<T,T> makeIdentity()  {
			return x->x;
		}
		
		public static <T,U> Function<Function<T,U>,Function<T,U>> applicator() {
			return x->x;
		}
		
		public static <T,U,V> Function<Function<U,V>, Function<Function<T,U>, Function<T,V>>> superComposer () {
			return x->y->z->x.apply(y.apply(z));
		}
		
		public static <T,U,V> Function<Function<T,U>, Function<Function<U,V>, Function<T,V>>> superComposer1 () {
			return x->y->z->y.apply(x.apply(z));
		}
		
		public int toInt(Float x) {
			return x.intValue();
		}
		public static void main(String[] args) {
			Function<String, String> f = MetaFuncs.<String>makeIdentity();
			System.out.println(f.apply("Default"));
			Function<Integer, Integer> f1 = MetaFuncs.<Integer>makeIdentity();
			System.out.println(f1.apply(7));
			
			// Applicator
			Function<Integer, String> fa = MetaFuncs.<Integer, String>applicator().apply(x->"B: " + x);
			System.out.println(fa.apply(4));
			
			// Composer
			
			
			 Function<Function<Integer, String>, Function<Function<Float, Integer>, Function<Float, String>>> supCompo =
					 MetaFuncs.<Float, Integer, String>superComposer();
			 System.out.println(supCompo.apply(x->"V: " + x).apply(x->x.intValue()).apply(5.567F));
			 
			 Function<Function<Float, Integer>, Function<Function<Integer, String>, Function<Float, String>>> supCompo1 =
					 MetaFuncs.<Float, Integer, String>superComposer1();
			 System.out.println(supCompo1.apply(x->x.intValue()).apply(x->"VV: " + x).apply(5.567F));
			 
			 // Partially applied, can be passed around
			 Function<Float, String> fk = supCompo1.apply(x->x.intValue()).apply(x->"VV: " + x);
			 // Example of using a instance method as a lambda
			 Function<Float, String> fk1 = supCompo1.apply(x->new MetaFuncs().toInt(x)).apply(x->"VV: " + x);
			 
			 System.out.println(fk.apply(6.78F));
			 System.out.println(fk1.apply(6.78F));
		}
	}
}
