package functional.function;

import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class FunctionLrn {

	public static String f1(int i) {
		return "---> " + i;
	}

	public static String f2(int i) {
		return i + "<---";
	}

	public static interface MyFunc extends Function<Integer, String> {
	};

	public static void main(String[] args) {
		MyFunc f1 = FunctionLrn::f1;
		MyFunc f2 = FunctionLrn::f2;
		
		//MyFunc f3 = new MyFunc();

		// Explicit Declaration
		Function<Integer, Integer> inc = x -> {
			return x + 1;
		};
		
		// Higher order functions - directly define
		Function<Integer, Function<Integer, Integer>> makeAdder = (x) -> {
			return (y) -> {
				return x + y;
			};
		};

		Function<Integer, Integer> incBy2 = makeAdder.apply(2);
		System.out.println("1: " + incBy2.apply(55));
		
		// HOF - Through static method in utility class
		// Bit simpler syntax
		Function<Integer, Function<Integer, Integer>> makeAdder1 = Utils::makeAdder;
		Function<Integer, Integer> incBy3 = makeAdder1.apply(3);
		System.out.println("2: " + incBy3.apply(55));

		// Functions taking functions and argument both 
		// And apply 
		
		// Preparatory - Binary Operators (T,T)->(T)
		BinaryOperator<Integer> binOp1 = (x,y) -> {return x+y;};	
		System.out.println("3: " + binOp1.apply(4, 6));
		
		// Now use a binop which takes two unary ops 
		
		BinaryOperator <Function<Integer, Integer>> combine = (x,y) ->  t->x.apply(y.apply(t));
		Function<Integer, Integer> mul3 = x -> 3*x;
		
		Function<Integer, Integer> threexPlus2 = combine.apply(incBy2, mul3);
		
		System.out.println("4: " + threexPlus2.apply(4));
		
		//IMPORTANT: Currying - partially applied function
		
		Function<Integer, Function<Integer, Integer>> funcFactory = x -> y -> x+y;
		Function<Integer, Integer> add42 = funcFactory.apply(42);
		System.out.println("5: " + add42.apply(8));
		
		// UnaryOperator - shorthand for Funcion<T,T>
		Function<Integer, UnaryOperator<Integer>> funcFactory1 = x -> y -> x+y;
		Function<Integer, Integer> add421 = funcFactory.apply(42);
		System.out.println("6: " + add421.apply(8));
		
		// Curried 3 example
		// x+y+z
		Function<Integer, Function<Integer, Function<Integer, Integer>>> plus3 = x->y->z->x+y+z;
		// Now perfor 1+2+3
		System.out.println("7: " + plus3.apply(1).apply(2).apply(3));
	}
	
	public static final class Utils {
		public static final Function<Integer, Integer> makeAdder (int x) {
			return (t) -> {return t + x;};
		}
	}
	
	

}
