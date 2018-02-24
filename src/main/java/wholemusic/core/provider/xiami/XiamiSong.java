package wholemusic.core.provider.xiami;

import com.alibaba.fastjson.annotation.JSONField;
import wholemusic.core.api.MusicProvider;
import wholemusic.core.model.*;
import wholemusic.core.provider.xiami.XiamiAlbum;
import wholemusic.core.provider.xiami.XiamiSinger;
//import wholemusic.core.provider.xiami.XiamiSongQuality;
import wholemusic.core.util.SongUtils;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by haohua on 2018/2/9.
 */
public class XiamiSong /*extends BaseBean*/ implements Song {
    @JSONField(name = "song_name")
    public String name;

    @JSONField(name = "song_id")
    public String songId;

/*
    @JSONField(name = "songmid")
    public String songMid;
*/
    //@JSONField(name = "album_id")
    public String albumId;

    //@JSONField(name = "album_name")
    public String albumName;

    @JSONField(name = "artist_id")
    public String artistId;

    @JSONField(name = "artist_name")
    public String artistName;

/*    @JSONField(name = "sizeogg")
    public long sizeogg;

    @JSONField(name = "sizeflac")
    public long sizeflac;

    @JSONField(name = "sizeape")
    public long sizeape;

    @JSONField(name = "size320")
    public long size320;

    @JSONField(name = "size128")
    public long size128;*/

    private MusicLink musicLink;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getSongId() {
        return songId;
    }

    @Override
    public ArrayList<? extends Artist> getArtists() {
        ArrayList<XiamiSinger> artist = new ArrayList<>();
        XiamiSinger singer = new XiamiSinger();
        singer.artistId = artistId;
        singer.artistName = artistName;
        artist.add(singer);
        return artist;
    }

    @Override
    public String getFormattedArtistsString() {
        return SongUtils.getArtistsString(this);
    }

    @Override
    public Album getAlbum() {
        XiamiAlbum album = new XiamiAlbum();
        album.setName(this.albumName);
        album.setAlbumId(this.albumId);
        return album;
    }

    @Override
    public MusicProvider getMusicProvider() {
        return MusicProvider.Xiami;
    }

    @Override
    public void setMusicLink(MusicLink musicLink) {
        this.musicLink = musicLink;
    }

    @Override
    public MusicLink getMusicLink() {
        return musicLink;
    }

    /**
     * 根据size字段猜测url中的quality音质字段
     *
     * @return
     */
/*    public QQSongQuality guessQuality() {
        if (size320 != 0) {
            return QQSongQuality.High;
        } else if (size128 != 0) {
            return QQSongQuality.Medium;
        } else {
            return QQSongQuality.Low;
        }
    }*/
}
