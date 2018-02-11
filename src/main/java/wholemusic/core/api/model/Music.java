package wholemusic.core.api.model;

import java.util.List;

/**
 * Created by haohua on 2018/2/9.
 */
public interface Music {
    String getName();

    String getMusicId();

    List<? extends Artist> getArtists();
}
