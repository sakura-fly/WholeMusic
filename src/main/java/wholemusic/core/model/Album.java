package wholemusic.core.model;

import java.util.List;

/**
 * Created by haohua on 2018/2/11.
 */
public interface Album {
    String getName();

    String getAlbumId();

    List<? extends Song> getSongs();
}
