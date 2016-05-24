package edu.jhu.fcriscu1.java8dev;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Multimap;

import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 * Copied from stackoverflow:
 * http://stackoverflow.com/questions/23003542/cleanest-way-to-create-a-guava-multimap-from-a-java8-stream
 *
 * Guava alternative: Multimaps.index(foos, Foo::getId);
 * Usage:
 * Multimap<String, Foo> collect = foos.stream().collect(MultimapCollector.toMultimap(Foo::getId));
 */
public class MultimapCollector<T, K, V> implements Collector<T, Multimap<K, V>, Multimap<K, V>> {


    private final Function<T, K> keyGetter;
    private final Function<T, V> valueGetter;

    public MultimapCollector(Function<T, K> keyGetter, Function<T, V> valueGetter) {
        this.keyGetter = keyGetter;
        this.valueGetter = valueGetter;
    }

    public static <T, K, V> MultimapCollector<T, K, V> toMultimap(Function<T, K> keyGetter, Function<T, V> valueGetter) {
        return new MultimapCollector<>(keyGetter, valueGetter);
    }

    public static <T, K, V> MultimapCollector<T, K, T> toMultimap(Function<T, K> keyGetter) {
        return new MultimapCollector<>(keyGetter, v -> v);
    }

    @Override
    public Supplier<Multimap<K, V>> supplier() {
        return ArrayListMultimap::create;
    }

    @Override
    public BiConsumer<Multimap<K, V>, T> accumulator() {
        return (map, element) -> map.put(keyGetter.apply(element), valueGetter.apply(element));
    }

    @Override
    public BinaryOperator<Multimap<K, V>> combiner() {
        return (map1, map2) -> {
            map1.putAll(map2);
            return map1;
        };
    }

    @Override
    public Function<Multimap<K, V>, Multimap<K, V>> finisher() {
        return map -> map;
    }

    @Override
    public Set<Characteristics> characteristics() {
        return ImmutableSet.of(Collector.Characteristics.IDENTITY_FINISH);
    }
}

