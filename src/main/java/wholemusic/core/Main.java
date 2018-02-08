package wholemusic.core;

import wholemusic.core.api.impl.qqmusic.QQMusicApi;

import java.io.IOException;
import java.util.List;

/**
 * Created by haohua on 2018/2/8.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        QQMusicApi qq = new QQMusicApi();
        List result = qq.searchMusic("孙燕姿");
    }
}
