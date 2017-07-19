package test;

public class TryTest {
	public static void main(String[] args) {
		System.out.println("test1="+test1());
		System.out.println("test2="+test2());
		System.out.println("test3="+test3());
		System.out.println("test4="+test4());
	}

	private static User test3() {
		User user = new User("zheng");
		try {
			return user;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			user = new User("fu");
		}
		return null;
	}
	private static User test4() {
		User user = new User("zheng");
		try {
			return user;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			user = new User("fu");
			return user;
		}
	}

	private static int test1() {
		int i =1;
		try {
			return i;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			i = 0;
		}
		return i;
	}
	private static int test2() {
		int i =1;
		try {
			return i;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			i = 0;
			return i;
		}
	}
}
class User{
	private String name;
	
	public User(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "User [name=" + name + "]";
	}
	
}