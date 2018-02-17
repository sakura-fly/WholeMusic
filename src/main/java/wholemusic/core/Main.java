package wholemusic.core;

import wholemusic.core.api.MusicApi;
import wholemusic.core.api.MusicApiFactory;
import wholemusic.core.api.MusicProvider;
import wholemusic.core.model.Album;
import wholemusic.core.model.Song;

import java.io.IOException;
import java.util.List;

/**
 * Created by haohua on 2018/2/8.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        testNeteaseMusic();
        testQQMusic();
        testNeteaseAlbum();
    }

    private static void testQQMusic() throws IOException {
        final MusicApi qq = MusicApiFactory.create(MusicProvider.QQ);
        List<? extends Song> result = qq.searchMusicSync("孙燕姿", 0, true);
        System.out.println(result.get(0).getMusicLink().getUrl());
    }

    private static void testNeteaseMusic() throws IOException {
        final MusicApi netease = MusicApiFactory.create(MusicProvider.Neteast);
        List<? extends Song> result = netease.searchMusicSync("Suede", 0, true);
        System.out.println(result.get(0).getMusicLink().getUrl());
    }

    private static void testNeteaseAlbum() throws IOException {
        final MusicApi netease = MusicApiFactory.create(MusicProvider.Neteast);
        Album album = netease.getAlbumInfoByIdSync("37017747", true);
        System.out.println(album);
    }
}
