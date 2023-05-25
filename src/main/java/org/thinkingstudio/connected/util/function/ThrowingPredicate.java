package org.thinkingstudio.connected.util.function;

public interface ThrowingPredicate<T, U extends Throwable> {
	boolean test(T t) throws U;
}
