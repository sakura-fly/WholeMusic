package wholemusic.core.util;

/**
 * Created by haohua on 2018/2/9.
 */

public interface Function<T, R> {

    /**
     * Applies this function to the given argument.
     *
     * @param t the function argument
     * @return the function result
     */
    R apply(T t);
}