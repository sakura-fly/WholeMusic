package wholemusic.core.api.framework.model;

/**
 * Created by haohua on 2018/2/9.
 */
public class Artist extends BaseBean {
    public String name;

    public interface Adapter {
        Artist convert();
    }
}
