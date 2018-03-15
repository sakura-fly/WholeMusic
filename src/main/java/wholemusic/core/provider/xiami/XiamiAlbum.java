package wholemusic.core.provider.xiami;

import com.alibaba.fastjson.annotation.JSONField;
import wholemusic.core.api.MusicProvider;
import wholemusic.core.model.Album;
import wholemusic.core.model.Artist;
import wholemusic.core.model.BaseBean;
import wholemusic.core.model.Song;
import wholemusic.core.util.SongUtils;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("SpellCheckingInspection")
public class XiamiAlbum extends BaseBean implements Album {
    @JSONField(name = "artist_name")
    public String artistName;

    @JSONField(name = "artist_id")
    public long artistId;

    @JSONField(name = "album_id")
    public String albumId;

    @JSONField(name = "album_name")
    public String albumName;

    @JSONField(name = "songs")
    public List<XiamiSong> songs;

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
        artist.artistId = String.valueOf(this.artistId);
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
        return MusicProvider.Xiami;
    }
}
