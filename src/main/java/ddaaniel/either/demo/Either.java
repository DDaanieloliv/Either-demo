package ddaaniel.either.demo;


public class Either<L, R> {
	private Either() { } // closed hierarchy
	public L left(){ return null; } // default signature to be oberrided and accessed by the super class
	public R right(){ return null; } // default signature to be oberrided and accessed by the super class

	public final static class Left<L, R> extends Either<L, R> { // to inherit a Generic<L, R>, is required be a Generic<L, R> && L(Left) -> Error
		private L l;
		public Left(L l){ this.l = l; }
		public L left(){ return l; }
	}

	public static class Right<L, R> extends Either<L, R> { // to inherit a Generic<L, R>, is required be a Generic<L, R>
		private R r;
		public Right(R r){ this.r = r; }
		public R right() { return r; }
	}

	public <C> C either(Map<L, C> f, Map<R, C> g) {
		if (this instanceof Left) return f.apply(left());
		return g.apply(right());
	}
}

interface Map<L, R> {
	R apply(L l);
}
