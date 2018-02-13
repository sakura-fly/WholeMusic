package wholemusic.core;

import wholemusic.core.api.*;
import wholemusic.core.model.Album;
import wholemusic.core.model.Song;
import wholemusic.core.model.MusicLink;

import java.io.IOException;
import java.util.List;

/**
 * Created by haohua on 2018/2/8.
 */
public class Main {
    private static RequestCallback<MusicLink> linkCallback = new SimpleRequestCallback<MusicLink>() {
        @Override
        public void onSuccess(MusicLink result) {
            System.out.println(result.getUrl());
        }
    };

    public static void main(String[] args) throws IOException {
        testNeteaseAlbum();
    }

    private static void testQQMusic() {
        final MusicApi qq = MusicApiFactory.create(MusicProvider.QQ);
        qq.searchMusicAsync("孙燕姿", 0, new SimpleRequestCallback<List<? extends Song>>() {
            @Override
            public void onSuccess(List<? extends Song> result) {
                qq.getMusicLinkByIdAsync(result.get(0).getSongId(), linkCallback);
                qq.getMusicLinkByIdAsync(result.get(1).getSongId(), linkCallback);
            }
        });
    }

    private static void testNeteaseMusic() {
        final MusicApi netease = MusicApiFactory.create(MusicProvider.Neteast);
        netease.searchMusicAsync("Suede", 0, new SimpleRequestCallback<List<? extends Song>>() {
            @Override
            public void onSuccess(List<? extends Song> result) {
                netease.getMusicLinkByIdAsync(result.get(0).getSongId(), linkCallback);
            }
        });
    }

    private static void testNeteaseAlbum() {
        final MusicApi netease = MusicApiFactory.create(MusicProvider.Neteast);
        netease.getAlbumInfoById(new SimpleRequestCallback<Album>() {
            @Override
            public void onSuccess(Album album) {
                System.out.println(album);
            }
        }, "37017747");
    }
}
