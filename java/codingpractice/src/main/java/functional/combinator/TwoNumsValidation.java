package functional.combinator;

import java.util.function.Function;

public interface TwoNumsValidation extends Function<TwoNums, Boolean>{
	
	static TwoNumsValidation validatFirstParam() {
		return x -> x.i1%5 == 0?true:false;
	}
	
	static TwoNumsValidation validatSecondParam() {
		return x -> x.i2%7 == 0?true:false;
	}
	
	default TwoNumsValidation and(TwoNumsValidation other) {
		return x -> this.apply(x) && other.apply(x);
	}
	
}
