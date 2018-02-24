package wholemusic.core.provider.xiami;

import com.alibaba.fastjson.annotation.JSONField;
import wholemusic.core.api.MusicProvider;
import wholemusic.core.model.Album;
import wholemusic.core.model.Artist;
import wholemusic.core.model.BaseBean;
import wholemusic.core.model.Song;
import wholemusic.core.provider.xiami.XiamiSinger;
import wholemusic.core.util.SongUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by haohua on 2018/2/17.
 */
public class XiamiAlbum /*extends BaseBean*/ implements Album {
/*    @JSONField(name = "name")
    private String name;

    @JSONField(name = "mid")
    private String albumId;*/

    //@JSONField(name = "artist_name")
    public String artistName;

    //@JSONField(name = "artist_id")
    public String artistId;

    @JSONField(name = "album_id")
    public String albumId;

    @JSONField(name = "album_name")
    public String albumName;

    private List<? extends Song> songs;

    @Override
    public String getName() {
        return albumName;
    }

    public void setName(String name) {
        this.albumName = name;
    }

    @Override
    public String getAlbumId() {
        return albumId;
    }

    @Override
    public List<? extends Artist> getArtists() {
        XiamiSinger artist = new XiamiSinger();
        artist.artistName = this.artistName;
        artist.artistId = this.artistId;
        ArrayList<XiamiSinger> result = new ArrayList<>();
        result.add(artist);
        return result;
    }

    @Override
    public String getFormattedArtistsString() {
        return SongUtils.getArtistsString(getArtists());
    }

    public void setAlbumId(String albumId) {
        this.albumId = albumId;
    }

    @Override
    public List<? extends Song> getSongs() {
        return songs;
    }

    @Override
    public MusicProvider getMusicProvider() {
        return MusicProvider.QQ;
    }

    public void setSongs(List<? extends Song> songs) {
        this.songs = songs;
    }

    public String getSingerMid() {
        return artistId;
    }

    public void setSingerMid(String singerMid) {
        this.artistId = singerMid;
    }

    public String getSingerName() {
        return artistName;
    }

    public void setSingerName(String singerName) {
        this.artistName = singerName;
    }
}
