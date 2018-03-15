package wholemusic.core.provider.xiami;

import com.alibaba.fastjson.annotation.JSONField;
import wholemusic.core.api.MusicProvider;
import wholemusic.core.model.*;
import wholemusic.core.util.SongUtils;

import java.util.ArrayList;

@SuppressWarnings("SpellCheckingInspection")
public class XiamiSong extends BaseBean implements Song {
    @JSONField(name = "song_name")
    public String name;

    @JSONField(name = "song_id")
    public String songId;

    @JSONField(name = "album_id")
    public long albumId;

    @JSONField(name = "album_name")
    public String albumName;

    @JSONField(name = "album_logo")
    public String albumPicUrl;

    @JSONField(name = "artist_id")
    public long artistId;

    @JSONField(name = "artist_name")
    public String artistName;

    @JSONField(name = "artist_logo")
    public String artistPicUrl;

    @JSONField(name = "listen_file")
    public String listenUrl;

    @JSONField(name = "lyric")
    public String lyricUrl;

    @Override
    public MusicLink getMusicLink() {
        XiamiSongLink link = new XiamiSongLink();
        link.url = this.listenUrl;
        return link;
    }

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
        singer.artistId = String.valueOf(artistId);
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
        album.setAlbumId(String.valueOf(this.albumId));
        return album;
    }

    @Override
    public MusicProvider getMusicProvider() {
        return MusicProvider.Xiami;
    }

    @Override
    public void setMusicLink(MusicLink musicLink) {
    }

    @Override
    public String getPicUrl() {
        return albumPicUrl;
    }

    @Override
    public Lyric getLyric() {
        XiamiLyric lyric = new XiamiLyric();
        lyric.setLyricUrl(this.lyricUrl);
        return lyric;
    }
}
