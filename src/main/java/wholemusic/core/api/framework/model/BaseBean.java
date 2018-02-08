package wholemusic.core.api.framework.model;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by haohua on 2018/2/9.
 */
public abstract class BaseBean {
    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
