package functional.consumer;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

@FunctionalInterface
public interface MyConsumer<T> {
	public void accept(T t);
	
	default Consumer<T> andThen (MyConsumer <? super T> aft) {
		// Return a function with functional descriptor (T) -> void
		Consumer<T> ret = (T t) -> { accept(t);aft.accept(t);accept(t);};
		return ret;
	}
}
