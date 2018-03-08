package wholemusic.core.provider.baidu;

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
class BaiduSong extends BaseBean implements Song {

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
        return removeEm(name);
    }

    @Override
    public String getSongId() {
        return String.valueOf(songId);
    }

    @Override
    public List<? extends Artist> getArtists() {
        ArrayList<BaiduArtist> result = new ArrayList<>();
        String[] artistNames = getArtist().split(",");
        for (String name : artistNames) {
            BaiduArtist artist = new BaiduArtist();
            artist.name = name;
            result.add(artist);
        }
        return result;
    }

    @Override
    public String getFormattedArtistsString() {
        return SongUtils.getArtistsString(this);
    }

    @Override
    public Album getAlbum() {
        BaiduAlbum album = new BaiduAlbum();
        album.id = this.albumId;
        album.name = getAlbumTitle();
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

    @Override
    public String getPicUrl() {
        return null;
    }

    @Override
    public Lyric getLyric() {
        return null;
    }

    public void setMusicLink(MusicLink musicLink) {
        this.musicLink = musicLink;
    }

    public String getArtist() {
        return removeEm(artist);
    }

    public String getAlbumTitle() {
        return removeEm(albumTitle);
    }

    private static String removeEm(String text) {
        return text.replaceAll("<em>", "").replaceAll("</em>", "");
    }
}
