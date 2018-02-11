package wholemusic.core.api;

import wholemusic.core.api.impl.baidu.BaiduMusicApi;
import wholemusic.core.api.impl.kugou.KugouMusicApi;
import wholemusic.core.api.impl.migu.MiguMusicApi;
import wholemusic.core.api.impl.netease.NeteaseMusicApi;
import wholemusic.core.api.impl.qq.QQMusicApi;
import wholemusic.core.api.impl.xiami.XiamiMusicApi;

/**
 * Created by haohua on 2018/2/11.
 */
public enum MusicProvider {
    网易云音乐(NeteaseMusicApi.class),
    QQ音乐(QQMusicApi.class),
    虾米音乐(XiamiMusicApi.class),
    酷狗音乐(KugouMusicApi.class),
    百度音乐(BaiduMusicApi.class),
    咪咕音乐(MiguMusicApi.class),;

    private final Class<? extends MusicApi> musicApiClass;

    MusicProvider(Class<? extends MusicApi> musicApiClass) {
        this.musicApiClass = musicApiClass;
    }

    public Class<? extends MusicApi> getMusicApiClass() {
        return musicApiClass;
    }

}
