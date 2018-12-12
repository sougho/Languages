package functional.mcase;

public interface Result {

	public class Success implements Result {
	}

	public class Failure implements Result {
		private final String errorMsg;

		public Failure(String s) {
			this.errorMsg = s;
		}

		public String getMessage() {
			return errorMsg;
		}
	}

}
