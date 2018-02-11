package wholemusic.core.api;

import wholemusic.core.api.model.Music;
import wholemusic.core.api.model.MusicLink;

import java.io.IOException;
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
    List<? extends Music> searchMusic(String keyword) throws IOException;

    /**
     * 获取某音乐id对应的音乐信息
     *
     * @param musicId
     * @return
     */
    Music getMusicInfoById(String musicId) throws IOException;

    /**
     * 获取某音乐id对应的音乐链接
     *
     * @param musicId
     * @return
     * @throws Exception
     */
    MusicLink getMusicLinkById(String musicId) throws IOException;

    /**
     * 获取音乐id列表对应的音乐链接集合
     *
     * @param musicIds
     * @return
     * @throws Exception
     */
    List<? extends MusicLink> getMusicLinkByIds(String... musicIds) throws IOException;
}
