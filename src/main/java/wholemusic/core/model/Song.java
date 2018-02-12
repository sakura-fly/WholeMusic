package wholemusic.core.model;

import java.io.Serializable;
import java.util.List;

import wholemusic.core.api.MusicProvider;

/**
 * Created by haohua on 2018/2/9.
 */
public interface Song extends Serializable {
    String getName();

    String getSongId();

    List<? extends Artist> getArtists();

    Album getAlbum();

    MusicProvider getMusicProvider();
}