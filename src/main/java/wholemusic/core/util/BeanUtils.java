package wholemusic.core.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by haohua on 2018/2/9.
 */
public class BeanUtils {
    /**
     * 函数式调用，把T类型的列表通过func来map到R类型的列表
     *
     * @param list
     * @param func
     * @param <T>
     * @param <R>
     * @return
     */
    public static <T, R> ArrayList<R> map(List<T> list, Function<T, R> func) {
        ArrayList<R> result = new ArrayList<>();
        for (T item : list) {
            result.add(func.apply(item));
        }
        return result;
    }
}
