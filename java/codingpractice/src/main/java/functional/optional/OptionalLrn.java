package functional.optional;

import static org.junit.Assert.assertFalse;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.junit.Test;


public class OptionalLrn {

	public void optionalTest() {
		Optional<String> opt1 = Optional.empty();
		try {
			String s = opt1.get();
		} catch (NoSuchElementException e) {
			// e.printStackTrace();
		}
		assertFalse(opt1.isPresent());

		Optional<String> opt2 = Optional.of("MyName");
		System.out.println(opt2);

		try {
			Optional<String> opt3 = Optional.of(null);
		} catch (NullPointerException e) {
			System.out.println("As expected");
		}

		Optional<String> opt3 = Optional.ofNullable(null);
		assertFalse(opt3.isPresent());

		Optional<String> opt4 = Optional.of("Soumen Ghosh");
		opt4.ifPresent((t) -> {
			System.out.println("Should Come: " + t.length());
		});
		
		opt4 = Optional.ofNullable(null);
		opt4.ifPresent((t)-> {
			System.out.println("Should not come: " + t.length());
		});
		
		// Use of orElse

		Optional<String> opt5 = Optional.of("Soumen");
		String s = opt5.orElse("Defualt");
		System.out.println("1: " + s);
		
		System.out.println("----------");
		
		Optional<String> opt6 = Optional.ofNullable(null);
		s = opt6.orElse("Defualt");
		System.out.println("2: " + s);
		
		// Use of orElseGet
		// Takes a supplier interface
		// ()->T
		
		s = opt6.orElseGet(() -> { return "Default";});
		System.out.println("3: " + s);
		
		// Diff bw orElse and orElseGet
		System.out.println("----");
		// Eager evaluation of the function
		s = opt5.orElse(getDefault());
		System.out.println("----");
		// Lazy evaluation of the function
		s = opt5.orElseGet(this::getDefault);
		System.out.println("----");
		
		// orElseThrow
		try {
		opt6.orElseThrow(NullPointerException::new);
		} catch (NullPointerException e) {
			System.out.println("3: Expected");
		}
		
		// Filter - takes a predicate
		// Predicate is a function with only one line
		
		opt5.filter((t1) -> t1.equals("Soumen")).ifPresent(t2 -> System.out.println("4: " + t2));
		opt5.filter((t1) -> t1.equals("soumen")).ifPresent(t2 -> System.out.println("5: " + t2));
		
		//Map - transform an optional into another
		
		System.out.println(Optional.of("Soumen Ghosh")
				.map(String::length)
				.filter(t -> t.SIZE > 0)
				.isPresent());
		
		String s3 = null;
		System.out.println("6: " + Optional.ofNullable(s3)
				.map(String::length)
				.filter(t -> t.SIZE > 0)
				.isPresent());
		
		System.out.println("7: " + Optional.ofNullable(s3).map(String::length));
		
		// The parameterized type also changes
		
		int i = Optional.of("Soumen").map(String::length).get();
		System.out.println("8: " + i);
		
		// Flatmap
		
		Optional<String> opt7 = Optional.ofNullable("SOUMEN");
		
		System.out.println(opt7.map(String::length));
		System.out.println(opt7.flatMap(OptionalLrn::wrapInOpt));
		
		
		
	}
	
	private String getDefault() {
		System.out.println("Default !!");
		return "Default";
	}

	public static Optional<Integer> wrapInOpt(String s) {
		return Optional.ofNullable(s.length());
	}
	
	public static void main(String[] args) {
		new OptionalLrn().optionalTest();
	}
}
