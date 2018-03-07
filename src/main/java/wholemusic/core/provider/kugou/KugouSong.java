package wholemusic.core.provider.kugou;

import com.alibaba.fastjson.annotation.JSONField;
import wholemusic.core.api.MusicProvider;
import wholemusic.core.model.*;
import wholemusic.core.util.SongUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by haohua on 2018/2/23.
 */
@SuppressWarnings("SpellCheckingInspection")
class KugouSong extends BaseBean implements Song {

    @JSONField(name = "songname")
    public String name;

    @JSONField(name = "audio_id")
    public long songId;

    @JSONField(name = "singername")
    public String artist;

    @JSONField(name = "album_id")
    public String albumId;

    @JSONField(name = "album_name")
    public String albumName;

    @JSONField(name = "hash")
    public String songHash;

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
        ArrayList<KugouArtist> result = new ArrayList<>();
        KugouArtist artist = new KugouArtist();
        artist.name = this.artist;
        result.add(artist);
        return result;
    }

    @Override
    public String getFormattedArtistsString() {
        return SongUtils.getArtistsString(this);
    }

    @Override
    public Album getAlbum() {
        KugouAlbum album = new KugouAlbum();
        album.name = this.albumName;
        album.id = this.albumId;
        return album;
    }

    @Override
    public MusicProvider getMusicProvider() {
        return MusicProvider.Kugou;
    }

    @Override
    public MusicLink getMusicLink() {
        return musicLink;
    }

    @Override
    public String getPicUrl() {
        return null;
    }

    public void setMusicLink(MusicLink musicLink) {
        this.musicLink = musicLink;
    }
}
