package functional.consumer;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Main {

	public static void main(String[] args) {
		
		// Usage of Accept
		
		Consumer<Integer> consumer = i -> {
			System.out.println(2*i);
		};
		List<Integer> integerList = Arrays.asList(1, 10, 200, 101, -10, 0);
		
		// Implicitly calling accept
		integerList.forEach(consumer);
		
		System.out.println("----------");
		
		// Andthen combines the two consumers 
		
		Consumer<Integer> dblConsumer = consumer.andThen(i->{System.out.println(-2*i);});
		integerList.forEach(dblConsumer);
		
		// Now same with customer consumer class
		System.out.println("----------");
		
		MyConsumer<Integer> myconsumer = i -> {
			System.out.println("FirstC:" + 2*i);
		};
		Consumer<Integer> trc = myconsumer.andThen(i->{System.out.println("SecondC:" + -2*i);});
		integerList.forEach(trc);
	}
}
