package edu.jhu.fcriscu1.java8dev;

/**
 * Created by fcriscuolo on 5/9/16.
 */
import java.util.function.Function;
import java.util.Optional;

class JDK8OptionalMonadExample {
    public static void main (String[] args) throws java.lang.Exception
    {
        System.out.println("");
        System.out.println("Does JDK8's Optional class satisfy the Monad laws?");
        System.out.println("=================================================");
        System.out.println("  1.  Left identity:  " + satisfiesLaw1LeftIdentity());
        System.out.println("  2.  Right identity: " + satisfiesLaw2RightIdentity());
        System.out.println("  3.  Associativity:  " + satisfiesLaw3Associativity());
        System.out.println("");
        System.out.println(satisfiesLaw1LeftIdentity()
                && satisfiesLaw2RightIdentity()
                && satisfiesLaw3Associativity()
                ? "Yes, it does."
                : "No, it doesn't.");
    }

    // Input values for the monad law tests below
    static int value = 42;
    static Optional monadicValue = Optional.of(value);

    // With lambdas, this entire thing goes away (pass `Optional.of` directly)
    static Function optionalOf = new Function<Integer, Optional<Integer>>() {
        @Override public Optional<Integer> apply(Integer n) { return Optional.of(n); }
    };

    // With lambdas, this becomes `n -> Optional.of(n * 2)`
    static Function f = new Function<Integer, Optional<Integer>>() {
        @Override public Optional<Integer> apply(Integer n) { return Optional.of(n * 2); }
    };

    // With lambdas, this becomes `n -> Optional.of(n * 5)`
    static Function g = new Function<Integer, Optional<Integer>>() {
        @Override public Optional<Integer> apply(Integer n) { return Optional.of(n * 5); }
    };

    // With lambdas, this becomes `n -> f(n).flatMap(g)`
    static Function f_flatMap_g = new Function<Integer, Optional<Integer>>() {
        @Override public Optional<Integer> apply(Integer n) { return ((Optional<Integer>) f.apply(n)).flatMap(g); }
        // NOTE (2013-11-11): Bug in latest JDK8 requires this cast:  ^^^^^^^^^^^^^^^^^^^
    };


    /**
     * Monad law 1, Left Identity
     *
     * From LYAHFGG [1] above:
     *   The first monad law states that if we take a value, put it in a default context
     *   with return and then feed it to a function by using >>=, it’s the same as just
     *   taking the value and applying the function to it
     */
    public static boolean satisfiesLaw1LeftIdentity() {
        return Optional.of(value).flatMap(f)
                .equals(f.apply(value));
    }

    /**
     * Monad law 2, Right Identity
     *
     * From LYAHFGG [1] above:
     *   The second law states that if we have a monadic value and we use >>= to feed
     *   it to return, the result is our original monadic value.
     */
    public static boolean satisfiesLaw2RightIdentity() {
        return monadicValue.flatMap(optionalOf)
                .equals(monadicValue);
    }

    /**
     * Monad law 3, Associativity
     *
     * From LYAHFGG [1] above:
     *   The final monad law says that when we have a chain of monadic function
     *   applications with >>=, it shouldn’t matter how they’re nested.
     */
    public static boolean satisfiesLaw3Associativity() {
        return monadicValue.flatMap(f).flatMap(g)
                .equals(monadicValue.flatMap(f_flatMap_g));
    }
}
