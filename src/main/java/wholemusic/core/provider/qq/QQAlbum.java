package wholemusic.core.provider.qq;

import wholemusic.core.model.Album;
import wholemusic.core.model.BaseBean;
import wholemusic.core.model.Song;

import java.util.List;

/**
 * Created by haohua on 2018/2/17.
 */
public class QQAlbum extends BaseBean implements Album {
    private String name;

    private String albumId;

    private List<? extends Song> songs;

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getAlbumId() {
        return albumId;
    }

    public void setAlbumId(String albumId) {
        this.albumId = albumId;
    }

    @Override
    public List<? extends Song> getSongs() {
        return songs;
    }
}
