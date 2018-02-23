package wholemusic.core.provider.kuwo;

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
class KuwoSong extends BaseBean implements Song {

    @JSONField(name = "SONGNAME")
    public String name;

    @JSONField(name = "MUSICRID")
    public String songId;

    @JSONField(name = "ARTIST")
    public String artist;

    @JSONField(name = "ALBUMID")
    public String albumId;

    @JSONField(name = "ALBUM")
    public String albumName;

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
        ArrayList<KuwoArtist> result = new ArrayList<>();
        String[] artistArray = artist.split(",");
        for (String name : artistArray) {
            KuwoArtist artist = new KuwoArtist();
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
        return MusicProvider.Kuwo;
    }

    @Override
    public MusicLink getMusicLink() {
        return musicLink;
    }

    public void setMusicLink(MusicLink musicLink) {
        this.musicLink = musicLink;
    }
}
