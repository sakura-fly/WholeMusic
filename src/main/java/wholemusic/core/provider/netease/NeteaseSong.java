package wholemusic.core.provider.netease;

import com.alibaba.fastjson.annotation.JSONField;

import wholemusic.core.api.MusicProvider;
import wholemusic.core.model.Album;
import wholemusic.core.model.Artist;
import wholemusic.core.model.BaseBean;
import wholemusic.core.model.Song;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by haohua on 2018/2/9.
 */
public class NeteaseSong extends BaseBean implements Song {

    @JSONField(name = "name")
    public String name;

    @JSONField(name = "id")
    public long songId;

    @JSONField(name = "ar")
    public ArrayList<NeteaseArtist> artists;

    @JSONField(name = "al")
    public NeteaseAlbum album;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getSongId() {
        return String.valueOf(songId);
    }

    @Override
    public List<? extends Artist> getArtists() {
        return artists;
    }

    @Override
    public Album getAlbum() {
        return album;
    }

    @Override
    public MusicProvider getMusicProvider() {
        return MusicProvider.网易云音乐;
    }
}
