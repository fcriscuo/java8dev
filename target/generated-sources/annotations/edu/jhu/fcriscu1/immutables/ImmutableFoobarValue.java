package edu.jhu.fcriscu1.immutables;

import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.primitives.Ints;
import com.google.common.primitives.Longs;
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;

/**
 * Immutable implementation of {@link FoobarValue}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableFoobarValue.builder()}.
 */
@SuppressWarnings("all")
@Generated({"Immutables.generator", "FoobarValue"})
public final class ImmutableFoobarValue extends FoobarValue {
  private final int foo;
  private final String bar;
  private final ImmutableList<Integer> buz;
  private final ImmutableSet<Long> crux;

  private ImmutableFoobarValue(
      int foo,
      String bar,
      ImmutableList<Integer> buz,
      ImmutableSet<Long> crux) {
    this.foo = foo;
    this.bar = bar;
    this.buz = buz;
    this.crux = crux;
  }

  /**
   * @return The value of the {@code foo} attribute
   */
  @Override
  public int foo() {
    return foo;
  }

  /**
   * @return The value of the {@code bar} attribute
   */
  @Override
  public String bar() {
    return bar;
  }

  /**
   * @return The value of the {@code buz} attribute
   */
  @Override
  public ImmutableList<Integer> buz() {
    return buz;
  }

  /**
   * @return The value of the {@code crux} attribute
   */
  @Override
  public ImmutableSet<Long> crux() {
    return crux;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link FoobarValue#foo() foo} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for foo
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableFoobarValue withFoo(int value) {
    if (this.foo == value) return this;
    return new ImmutableFoobarValue(value, this.bar, this.buz, this.crux);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link FoobarValue#bar() bar} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for bar
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableFoobarValue withBar(String value) {
    if (this.bar.equals(value)) return this;
    return new ImmutableFoobarValue(this.foo, Objects.requireNonNull(value, "bar"), this.buz, this.crux);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link FoobarValue#buz() buz}.
   * @param elements The elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableFoobarValue withBuz(int... elements) {
    ImmutableList<Integer> newValue = ImmutableList.copyOf(Ints.asList(elements));
    return new ImmutableFoobarValue(this.foo, this.bar, newValue, this.crux);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link FoobarValue#buz() buz}.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param elements An iterable of buz elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableFoobarValue withBuz(Iterable<Integer> elements) {
    if (this.buz == elements) return this;
    ImmutableList<Integer> newValue = ImmutableList.copyOf(elements);
    return new ImmutableFoobarValue(this.foo, this.bar, newValue, this.crux);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link FoobarValue#crux() crux}.
   * @param elements The elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableFoobarValue withCrux(long... elements) {
    ImmutableSet<Long> newValue = ImmutableSet.copyOf(Longs.asList(elements));
    return new ImmutableFoobarValue(this.foo, this.bar, this.buz, newValue);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link FoobarValue#crux() crux}.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param elements An iterable of crux elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableFoobarValue withCrux(Iterable<Long> elements) {
    if (this.crux == elements) return this;
    ImmutableSet<Long> newValue = ImmutableSet.copyOf(elements);
    return new ImmutableFoobarValue(this.foo, this.bar, this.buz, newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableFoobarValue} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof ImmutableFoobarValue
        && equalTo((ImmutableFoobarValue) another);
  }

  private boolean equalTo(ImmutableFoobarValue another) {
    return foo == another.foo
        && bar.equals(another.bar)
        && buz.equals(another.buz)
        && crux.equals(another.crux);
  }

  /**
   * Computes a hash code from attributes: {@code foo}, {@code bar}, {@code buz}, {@code crux}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 31;
    h = h * 17 + foo;
    h = h * 17 + bar.hashCode();
    h = h * 17 + buz.hashCode();
    h = h * 17 + crux.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code FoobarValue} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("FoobarValue")
        .omitNullValues()
        .add("foo", foo)
        .add("bar", bar)
        .add("buz", buz)
        .add("crux", crux)
        .toString();
  }

  /**
   * Creates an immutable copy of a {@link FoobarValue} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable FoobarValue instance
   */
  public static ImmutableFoobarValue copyOf(FoobarValue instance) {
    if (instance instanceof ImmutableFoobarValue) {
      return (ImmutableFoobarValue) instance;
    }
    return ImmutableFoobarValue.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableFoobarValue ImmutableFoobarValue}.
   * @return A new ImmutableFoobarValue builder
   */
  public static ImmutableFoobarValue.Builder builder() {
    return new ImmutableFoobarValue.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableFoobarValue ImmutableFoobarValue}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  public static final class Builder {
    private static final long INIT_BIT_FOO = 0x1L;
    private static final long INIT_BIT_BAR = 0x2L;
    private long initBits = 0x3;

    private int foo;
    private String bar;
    private ImmutableList.Builder<Integer> buzBuilder = ImmutableList.builder();
    private ImmutableSet.Builder<Long> cruxBuilder = ImmutableSet.builder();

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code FoobarValue} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * Collection elements and entries will be added, not replaced.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(FoobarValue instance) {
      Objects.requireNonNull(instance, "instance");
      foo(instance.foo());
      bar(instance.bar());
      addAllBuz(instance.buz());
      addAllCrux(instance.crux());
      return this;
    }

    /**
     * Initializes the value for the {@link FoobarValue#foo() foo} attribute.
     * @param foo The value for foo 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder foo(int foo) {
      this.foo = foo;
      initBits &= ~INIT_BIT_FOO;
      return this;
    }

    /**
     * Initializes the value for the {@link FoobarValue#bar() bar} attribute.
     * @param bar The value for bar 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder bar(String bar) {
      this.bar = Objects.requireNonNull(bar, "bar");
      initBits &= ~INIT_BIT_BAR;
      return this;
    }

    /**
     * Adds one element to {@link FoobarValue#buz() buz} list.
     * @param element A buz element
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addBuz(int element) {
      buzBuilder.add(element);
      return this;
    }

    /**
     * Adds elements to {@link FoobarValue#buz() buz} list.
     * @param elements An array of buz elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addBuz(int... elements) {
      buzBuilder.addAll(Ints.asList(elements));
      return this;
    }

    /**
     * Sets or replaces all elements for {@link FoobarValue#buz() buz} list.
     * @param elements An iterable of buz elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder buz(Iterable<Integer> elements) {
      buzBuilder = ImmutableList.builder();
      return addAllBuz(elements);
    }

    /**
     * Adds elements to {@link FoobarValue#buz() buz} list.
     * @param elements An iterable of buz elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addAllBuz(Iterable<Integer> elements) {
      buzBuilder.addAll(elements);
      return this;
    }

    /**
     * Adds one element to {@link FoobarValue#crux() crux} set.
     * @param element A crux element
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addCrux(long element) {
      cruxBuilder.add(element);
      return this;
    }

    /**
     * Adds elements to {@link FoobarValue#crux() crux} set.
     * @param elements An array of crux elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addCrux(long... elements) {
      cruxBuilder.addAll(Longs.asList(elements));
      return this;
    }

    /**
     * Sets or replaces all elements for {@link FoobarValue#crux() crux} set.
     * @param elements An iterable of crux elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder crux(Iterable<Long> elements) {
      cruxBuilder = ImmutableSet.builder();
      return addAllCrux(elements);
    }

    /**
     * Adds elements to {@link FoobarValue#crux() crux} set.
     * @param elements An iterable of crux elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addAllCrux(Iterable<Long> elements) {
      cruxBuilder.addAll(elements);
      return this;
    }

    /**
     * Builds a new {@link ImmutableFoobarValue ImmutableFoobarValue}.
     * @return An immutable instance of FoobarValue
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableFoobarValue build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableFoobarValue(foo, bar, buzBuilder.build(), cruxBuilder.build());
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = Lists.newArrayList();
      if ((initBits & INIT_BIT_FOO) != 0) attributes.add("foo");
      if ((initBits & INIT_BIT_BAR) != 0) attributes.add("bar");
      return "Cannot build FoobarValue, some of required attributes are not set " + attributes;
    }
  }
}
