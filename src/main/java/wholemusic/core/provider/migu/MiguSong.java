package wholemusic.core.provider.migu;

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
class MiguSong extends BaseBean implements Song {

    @JSONField(name = "songName")
    public String name;

    @JSONField(name = "song_id")
    public long songId;

    @JSONField(name = "artist")
    public String artist;

    @JSONField(name = "cover")
    public String cover;

    @JSONField(name = "albumId")
    public String albumId;

    @JSONField(name = "albumName")
    public String albumName;

    @JSONField(name = "mp3")
    public String songUrl;

    @JSONField(name = "lyrics")
    public String lyricsUrl;

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
        ArrayList<MiguArtist> result = new ArrayList<>();
        String[] artistArray = artist.split(",");
        for (String name : artistArray) {
            MiguArtist artist = new MiguArtist();
            artist.name = name.trim();
            result.add(artist);
        }
        return result;
    }

    @Override
    public String getFormattedArtistsString() {
        // TODO
        return SongUtils.getArtistsString(this);
    }

    @Override
    public Album getAlbum() {
        // TODO
        return null;
    }

    @Override
    public MusicProvider getMusicProvider() {
        return MusicProvider.Migu;
    }

    @Override
    public MusicLink getMusicLink() {
        MiguSongLink link = new MiguSongLink();
        link.setUrl(songUrl);
        return link;
    }

    @Override
    public String getPicUrl() {
        return null;
    }

    public void setMusicLink(MusicLink musicLink) {
        throw new UnsupportedOperationException();
    }
}
