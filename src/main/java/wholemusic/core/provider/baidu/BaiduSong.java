package wholemusic.core.provider.baidu;

import com.alibaba.fastjson.annotation.JSONField;
import wholemusic.core.api.MusicProvider;
import wholemusic.core.model.*;
import wholemusic.core.provider.netease.NeteaseAlbum;
import wholemusic.core.provider.netease.NeteaseArtist;
import wholemusic.core.util.SongUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by haohua on 2018/2/23.
 */
@SuppressWarnings("SpellCheckingInspection")
public class BaiduSong extends BaseBean implements Song {

    @JSONField(name = "title")
    public String name;

    @JSONField(name = "song_id")
    public long songId;

    @JSONField(name = "author")
    public String artist;

    @JSONField(name = "all_artist_id")
    public String artistIds;

    @JSONField(name = "album_id")
    public String albumId;

    @JSONField(name = "album_title")
    public String albumTitle;

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
        ArrayList<BaiduArtist> result = new ArrayList<>();
        String[] artistIdArray = artistIds.split(",");
        for (String artistId : artistIdArray) {
            BaiduArtist artist = new BaiduArtist();
            artist.id = artistId;
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
        BaiduAlbum album = new BaiduAlbum();
        album.id = this.albumId;
        album.name = albumTitle;
        return album;
    }

    @Override
    public MusicProvider getMusicProvider() {
        return MusicProvider.Baidu;
    }

    @Override
    public MusicLink getMusicLink() {
        return musicLink;
    }

    public void setMusicLink(MusicLink musicLink) {
        this.musicLink = musicLink;
    }
}
