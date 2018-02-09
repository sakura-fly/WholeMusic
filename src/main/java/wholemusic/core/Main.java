package wholemusic.core;

import wholemusic.core.api.framework.model.Music;
import wholemusic.core.api.impl.qqmusic.QQMusicApi;

import java.io.IOException;
import java.util.List;

/**
 * Created by haohua on 2018/2/8.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        QQMusicApi qq = new QQMusicApi();
        List<Music> result = qq.searchMusic("孙燕姿");
        String link1 = qq.getMusicLinkById(result.get(0).musicId);
        String link2 = qq.getMusicLinkById(result.get(1).musicId);
        System.out.println(link1);
        System.out.println(link2);
    }
}
