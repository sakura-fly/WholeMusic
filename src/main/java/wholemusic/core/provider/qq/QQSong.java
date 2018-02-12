package wholemusic.core.provider.qq;

import com.alibaba.fastjson.annotation.JSONField;

import wholemusic.core.api.MusicProvider;
import wholemusic.core.model.Album;
import wholemusic.core.model.Artist;
import wholemusic.core.model.BaseBean;
import wholemusic.core.model.Song;

import java.util.ArrayList;

/**
 * Created by haohua on 2018/2/9.
 */
public class QQSong extends BaseBean implements Song {
    @JSONField(name = "songname")
    public String name;

    @JSONField(name = "songid")
    public String songId;

    @JSONField(name = "songmid")
    public String songMid;

    @JSONField(name = "singer")
    public ArrayList<QQSinger> singers;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getSongId() {
        return songMid;
    }

    @Override
    public ArrayList<? extends Artist> getArtists() {
        return singers;
    }

    @Override
    public Album getAlbum() {
        // TODO
        return null;
    }

    @Override
    public MusicProvider getMusicProvider() {
        return MusicProvider.QQ音乐;
    }
}