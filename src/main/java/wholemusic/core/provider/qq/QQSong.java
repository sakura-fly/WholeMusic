package wholemusic.core.provider.qq;

import com.alibaba.fastjson.annotation.JSONField;

import wholemusic.core.api.MusicProvider;
import wholemusic.core.model.*;

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

    @JSONField(name = "albummid")
    public String albumMid;

    @JSONField(name = "albumname")
    public String albumName;

    private MusicLink musicLink;

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
        QQAlbum album = new QQAlbum();
        album.setName(this.albumName);
        album.setAlbumId(this.albumMid);
        return album;
    }

    @Override
    public MusicProvider getMusicProvider() {
        return MusicProvider.QQ;
    }

    @Override
    public void setMusicLink(MusicLink musicLink) {
        this.musicLink = musicLink;
    }

    @Override
    public MusicLink getMusicLink() {
        return musicLink;
    }
}
