package test;

public class TestVoid {
	public static void main(String[] args) {
		test1();
		Void v1 = test2();
		System.out.println(v1);// null

		BaseDAO<Void> dao = new BaseDAO<>();
		Void v2 = dao.get();
		System.out.println(v2);// null
	}

	public static void test1() {
	}

	public static Void test2() {
		return null;
	}

	static class BaseDAO<T> {

		public T get() {
			// ...
			return null;
		}

	}

}
