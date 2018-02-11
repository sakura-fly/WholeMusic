package wholemusic.core.api;

import wholemusic.core.model.Album;
import wholemusic.core.model.Song;
import wholemusic.core.model.MusicLink;

import java.util.List;

/**
 * Created by haohua on 2018/2/8.
 */
public interface MusicApi {
    /**
     * 使用关键词查询歌曲
     *
     * @param keyword
     * @param page
     * @param callback
     */
    void searchMusicAsync(String keyword, int page, RequestCallback<List<? extends Song>> callback);

    /**
     * 获取某音乐id对应的音乐信息
     *
     * @param musicId
     * @return
     */
    void getMusicInfoByIdAsync(String musicId, RequestCallback<? extends Song> callback);

    /**
     * 获取某音乐id对应的音乐链接
     *
     * @param musicId
     * @return
     * @throws Exception
     */
    void getMusicLinkByIdAsync(String musicId, RequestCallback<MusicLink> callback);

    /**
     * 获取音乐id列表对应的音乐链接集合
     *
     * @param musicIds
     * @return
     * @throws Exception
     */
    void getMusicLinkByIdsAsync(RequestCallback<List<? extends MusicLink>> callback, String... musicIds);

    /**
     * 获取专辑id对应的专辑信息
     *
     * @param callback
     * @param albumId
     */
    void getAlbumInfoById(RequestCallback<Album> callback, String albumId);
}
