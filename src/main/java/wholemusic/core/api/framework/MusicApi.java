package wholemusic.core.api.framework;

import wholemusic.core.api.framework.model.Music;

import java.util.List;

/**
 * Created by haohua on 2018/2/8.
 */
public interface MusicApi {
    /**
     * 使用关键词查询歌曲
     *
     * @param keyWord
     * @return the music list
     */
    List<Music> searchMusic(String keyWord) throws Exception;

    /**
     * 获取某音乐id对应的音乐信息
     *
     * @param musicId
     * @return
     */
    Music getMusicInfoById(String musicId) throws Exception;
}
