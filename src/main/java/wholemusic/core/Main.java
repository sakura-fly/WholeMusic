package wholemusic.core;

import wholemusic.core.api.MusicApi;
import wholemusic.core.api.MusicApiFactory;
import wholemusic.core.api.MusicProvider;
import wholemusic.core.api.model.Music;

import java.util.List;

/**
 * Created by haohua on 2018/2/8.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        MusicApi qq = MusicApiFactory.create(MusicProvider.QQ音乐);
        List<? extends Music> result = qq.searchMusic("孙燕姿");
        String link1 = qq.getMusicLinkById(result.get(0).getMusicId()).getUrl();
        String link2 = qq.getMusicLinkById(result.get(1).getMusicId()).getUrl();
        System.out.println(link1);
        System.out.println(link2);
        MusicApi netease = MusicApiFactory.create(MusicProvider.网易云音乐);
        List<? extends Music> result2 = netease.searchMusic("Suede");
        netease.getMusicLinkById(result2.get(0).getMusicId());
        System.out.println(result2);
    }
}
