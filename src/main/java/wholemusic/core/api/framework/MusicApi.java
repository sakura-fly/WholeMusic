package wholemusic.core.api.framework;

import wholemusic.core.api.framework.model.Music;
import wholemusic.core.api.framework.model.MusicLink;

import java.util.List;

/**
 * Created by haohua on 2018/2/8.
 */
public interface MusicApi {
    /**
     * 使用关键词查询歌曲
     *
     * @param keyword
     * @return the music list
     */
    List<? extends Music> searchMusic(String keyword) throws Exception;

    /**
     * 获取某音乐id对应的音乐信息
     *
     * @param musicId
     * @return
     */
    Music getMusicInfoById(String musicId) throws Exception;

    /**
     * 获取某音乐id对应的音乐链接
     *
     * @param musicId
     * @return
     * @throws Exception
     */
    MusicLink getMusicLinkById(String musicId) throws Exception;

    /**
     * 获取音乐id列表对应的音乐链接集合　
     * @param musicIds
     * @return
     * @throws Exception
     */
    List<? extends MusicLink> getMusicLinkByIds(String... musicIds) throws Exception;
}
