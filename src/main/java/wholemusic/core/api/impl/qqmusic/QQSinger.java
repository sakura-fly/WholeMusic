package wholemusic.core.api.impl.qqmusic;

import com.alibaba.fastjson.annotation.JSONField;
import wholemusic.core.api.framework.model.BaseBean;

/**
 * Created by haohua on 2018/2/9.
 */
public class QQSinger extends BaseBean {
    @JSONField(name = "name")
    public String name;
}
