package ddaaniel.either.demo;


public class Either<L, R> {
	private Either() { } // closed hierarchy
	public L left(){ return null; } // default signature to be oberrided and accessed by the super class
	public R right(){ return null; } // default signature to be oberrided and accessed by the super class

	public final static class Left<L, R> extends Either<L, R> { // to inherit a Generic<L, R>, is required be a Generic<L, R> && L(Left) -> Error
		private L l; // instance of the Left type reference (Error)
		public Left(L l){ this.l = l; } // Left type reference constructor's
		public L left(){ return l; } // function that overrides the super class method 'left()'
	}

	public static class Right<L, R> extends Either<L, R> { // to inherit a Generic<L, R>, is required be a Generic<L, R>
		private R r; // instance of the Right type reference (Result)
		public Right(R r){ this.r = r; } // Right type reference constructor's
		public R right() { return r; } // function that overrides the super class method 'right()' 
	}

	public <C> C either(Map<L, C> f, Map<R, C> g) { // <C> create a new -> reserved_space / type
		if (this instanceof Left) return f.apply(left());
		return g.apply(right());
	}
}

interface Map<L, R> {
	R apply(L l);
}
