package ddaaniel.either.demo;


public class Either<A, B> {
	private Either() { } // closed hierarchy
	public A left(){ return null; } // default signature to be oberrided and accessed by the super class
	public B right(){ return null; } // default signature to be oberrided and accessed by the super class

	public final static class Left<A, B> extends Either<A, B> { 
		private A a;
		public Left(A a){ this.a = a; }
		public A left(){ return a; }
	}

	public static class Right<A, B> extends Either<A, B> {
		private B b;
		public Right(B b){ this.b = b; }
		public B right() { return b; }
	}

	public <C> C either(Map<A, C> f, Map<B, C> g) {
		if (this instanceof Left) return f.apply(left());
		return g.apply(right());
	}
}

interface Map<A, B> {
	B apply(A a);
}
