
public class Test {
	
	public static class A{
		private String value;
		public A(B b) {
			this.value = b.value;
		}
		public String getv() {
			return value;
		}
	}
	
	public static class B{
		private String value;
		public B(String S) {
			this.value = S;
		}
	}

	public static void main(String[] args) {
		B b = new B("BBBBBBBBBB");
		A a = new A(b);
		System.out.println(a.getv());
		
	}

}
