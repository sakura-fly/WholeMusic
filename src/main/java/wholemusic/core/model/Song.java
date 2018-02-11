package wholemusic.core.model;

import java.util.List;

/**
 * Created by haohua on 2018/2/9.
 */
public interface Song {
    String getName();

    String getSongId();

    List<? extends Artist> getArtists();
}
