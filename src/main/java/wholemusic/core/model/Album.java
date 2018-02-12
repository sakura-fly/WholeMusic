package wholemusic.core.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by haohua on 2018/2/11.
 */
public interface Album extends Serializable {
    String getName();

    String getAlbumId();

    List<? extends Song> getSongs();
}
