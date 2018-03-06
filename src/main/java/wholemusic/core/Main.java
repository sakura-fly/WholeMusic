package wholemusic.core;

import okhttp3.Request;
import okhttp3.Response;
import wholemusic.core.api.HttpEngine;
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
        testBaiduMusic();
        testMiguMusic();
        testKugouMusic();
        testKuwoMusic();
        testYitingMusic();

        testNeteaseAlbum();
        testQQAlbum();
    }

    private static void testQQMusic() throws IOException {
        final MusicApi api = MusicApiFactory.create(MusicProvider.QQ);
        List<? extends Song> result = api.searchMusicSync("孙燕姿 第一天", 0, true);
        String url = result.get(0).getMusicLink().getUrl();
        System.out.println(url);
        testDownload(url);
    }

    @SuppressWarnings("SpellCheckingInspection")
    private static void testNeteaseMusic() throws IOException {
        final MusicApi api = MusicApiFactory.create(MusicProvider.Netease);
        List<? extends Song> result = api.searchMusicSync("Suede", 0, true);
        String url = result.get(0).getMusicLink().getUrl();
        System.out.println(url);
        testDownload(url);
    }

    private static void testDownload(String url) throws IOException {
        Request.Builder builder = new Request.Builder();
        builder.url(url);
        builder.get();
        Response response = HttpEngine.requestSync(builder.build(), false);
        System.out.println("download music response code: " + response.code());
        response.close();
    }

    @SuppressWarnings("SpellCheckingInspection")
    private static void testBaiduMusic() throws IOException {
        final MusicApi api = MusicApiFactory.create(MusicProvider.Baidu);
        List<? extends Song> result = api.searchMusicSync("岳云鹏 送情郎", 0, true);
        String url = result.get(0).getMusicLink().getUrl();
        System.out.println(url);
        testDownload(url);
    }

    @SuppressWarnings("SpellCheckingInspection")
    private static void testMiguMusic() throws IOException {
        final MusicApi api = MusicApiFactory.create(MusicProvider.Migu);
        List<? extends Song> result = api.searchMusicSync("孙燕姿 第一天", 0, true);
        String url = result.get(0).getMusicLink().getUrl();
        System.out.println(url);
        testDownload(url);
    }


    @SuppressWarnings("SpellCheckingInspection")
    private static void testKugouMusic() throws IOException {
        final MusicApi api = MusicApiFactory.create(MusicProvider.Kugou);
        List<? extends Song> result = api.searchMusicSync("Beyond", 0, true);
        String url = result.get(0).getMusicLink().getUrl();
        System.out.println(url);
        testDownload(url);
    }

    @SuppressWarnings("SpellCheckingInspection")
    private static void testKuwoMusic() throws IOException {
        final MusicApi api = MusicApiFactory.create(MusicProvider.Kuwo);
        List<? extends Song> result = api.searchMusicSync("Beyond", 0, true);
        String url = result.get(0).getMusicLink().getUrl();
        System.out.println(url);
        testDownload(url);
    }

    @SuppressWarnings("SpellCheckingInspection")
    private static void testYitingMusic() throws IOException {
        final MusicApi api = MusicApiFactory.create(MusicProvider.Yiting);
        List<? extends Song> result = api.searchMusicSync("Beyond", 0, true);
        String url = result.get(0).getMusicLink().getUrl();
        System.out.println(url);
        testDownload(url);
    }


    @SuppressWarnings("SpellCheckingInspection")
    private static void testNeteaseAlbum() throws IOException {
        final MusicApi api = MusicApiFactory.create(MusicProvider.Netease);
        Album album = api.getAlbumInfoByIdSync("37017747", true);
        System.out.println(album);
    }

    private static void testQQAlbum() throws IOException {
        final MusicApi api = MusicApiFactory.create(MusicProvider.QQ);
        // Album album = api.getAlbumInfoByIdSync("001wmoL43SVFjj", true);
        Album album = api.getAlbumInfoByIdSync("000yiVfk1EpZIs", true);
        System.out.println(album);
    }
}
