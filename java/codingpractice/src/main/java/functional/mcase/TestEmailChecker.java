package functional.mcase;

import java.util.function.Function;
import java.util.regex.Pattern;

public class TestEmailChecker {

	final Pattern emailPattern = Pattern.compile("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$");

	final Function<String, Result> emailChecker = k -> {
		if (k == null) {
			return new Result.Failure("email must not be null");
		} else if (k.length() == 0) {
			return new Result.Failure("email must not be empty");
		} else if (emailPattern.matcher(k).matches()) {
			return new Result.Success();

		} else {
			return new Result.Failure("email " + k + " is invalid.");
		}
	};

	public interface Executable {
		void exec();
	}

	private Executable testMail(String email) {

		Result res = emailChecker.apply(email);
		return (res instanceof Result.Success ? () -> sendVerificationMail(email)
				: () -> logError(((Result.Failure) res).getMessage()));

	}

	void sendVerificationMail(String s) {
		System.out.println("Verification mail sent to " + s);
	}

	private static void logError(String s) {
		System.err.println("Error message logged: " + s);
	}

	public static void main(String[] args) {

		new TestEmailChecker().testMail("sougho@gmail.com").exec();
	}

}
