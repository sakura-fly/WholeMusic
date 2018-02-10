package wholemusic.core;

import wholemusic.core.api.framework.MusicApi;
import wholemusic.core.api.framework.model.Music;
import wholemusic.core.api.impl.netease.NeteaseMusicApi;
import wholemusic.core.api.impl.qq.QQMusicApi;

import java.util.List;

/**
 * Created by haohua on 2018/2/8.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        MusicApi qq = new QQMusicApi();
        List<? extends Music> result = qq.searchMusic("孙燕姿");
        String link1 = qq.getMusicLinkById(result.get(0).getMusicId()).getUrl();
        String link2 = qq.getMusicLinkById(result.get(1).getMusicId()).getUrl();
        System.out.println(link1);
        System.out.println(link2);
        MusicApi netease = new NeteaseMusicApi();
        List<? extends Music> result2 = netease.searchMusic("Suede");
        netease.getMusicLinkById("4279445");
        System.out.println(result2);
    }
}
