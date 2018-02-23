package wholemusic.core.api;

import wholemusic.core.provider.baidu.BaiduMusicApi;
import wholemusic.core.provider.kugou.KugouMusicApi;
import wholemusic.core.provider.kuwo.KuwoMusicApi;
import wholemusic.core.provider.migu.MiguMusicApi;
import wholemusic.core.provider.netease.NeteaseMusicApi;
import wholemusic.core.provider.qq.QQMusicApi;
import wholemusic.core.provider.xiami.XiamiMusicApi;
import wholemusic.core.provider.yiting.YitingMusicApi;

/**
 * Created by haohua on 2018/2/11.
 */
@SuppressWarnings("SpellCheckingInspection")
public enum MusicProvider {
    Netease("网易云音乐", NeteaseMusicApi.class),
    QQ("QQ音乐", QQMusicApi.class),
    Xiami("虾米音乐", XiamiMusicApi.class),
    Kugou("酷狗音乐", KugouMusicApi.class),
    Kuwo("酷我音乐", KuwoMusicApi.class),
    Baidu("百度音乐", BaiduMusicApi.class),
    Migu("咪咕音乐", MiguMusicApi.class),
    Yiting("一听音乐", YitingMusicApi.class),;

    private final Class<? extends MusicApi> musicApiClass;
    private final String providerName;

    MusicProvider(String providerName, Class<? extends MusicApi> musicApiClass) {
        this.providerName = providerName;
        this.musicApiClass = musicApiClass;
    }

    public Class<? extends MusicApi> getMusicApiClass() {
        return musicApiClass;
    }

    @Override
    public String toString() {
        return providerName;
    }
}
