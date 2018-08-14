package functional.combinator;

public class TwoNums {

	int i1;
	int i2;
	public TwoNums(int i1, int i2) {
		super();
		this.i1 = i1;
		this.i2 = i2;
	}
	
	public static void main(String[] args) {
		TwoNums tn = new TwoNums(25, 37);
		System.out.println(TwoNumsValidation.validatFirstParam().apply(tn));
		System.out.println(TwoNumsValidation.validatSecondParam().apply(tn));
		System.out.println(TwoNumsValidation.validatFirstParam().and(TwoNumsValidation.validatSecondParam()).apply(tn));
	}
}
