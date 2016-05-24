package edu.jhu.fcriscu1.immutables;

/**
 * Created by fcriscuolo on 4/19/16.
 */
import java.util.List;
import java.util.Set;
import org.immutables.value.Value;

@Value.Immutable
public abstract class FoobarValue {
    public abstract int foo();
    public abstract String bar();
    public abstract List<Integer> buz();
    public abstract Set<Long> crux();
}
