package wholemusic.core.provider.netease;

import com.alibaba.fastjson.annotation.JSONField;

import wholemusic.core.api.MusicProvider;
import wholemusic.core.model.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by haohua on 2018/2/9.
 */
@SuppressWarnings("SpellCheckingInspection")
public class NeteaseSong extends BaseBean implements Song {

    @JSONField(name = "name")
    public String name;

    @JSONField(name = "id")
    public long songId;

    @JSONField(name = "ar")
    public ArrayList<NeteaseArtist> artists;

    @JSONField(name = "al")
    public NeteaseAlbum album;

    private MusicLink musicLink;

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
        return MusicProvider.Netease;
    }

    @Override
    public MusicLink getMusicLink() {
        return musicLink;
    }

    public void setMusicLink(MusicLink musicLink) {
        this.musicLink = musicLink;
    }
}
