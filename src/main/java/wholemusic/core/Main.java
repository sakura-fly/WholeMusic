package wholemusic.core;

import wholemusic.core.api.*;
import wholemusic.core.model.Music;
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

    public static void main(String[] args) throws IOException, InterruptedException {
        final MusicApi qq = MusicApiFactory.create(MusicProvider.QQ音乐);
        qq.searchMusicAsync("孙燕姿", 0, new SimpleRequestCallback<List<? extends Music>>() {
            @Override
            public void onSuccess(List<? extends Music> result) {
                qq.getMusicLinkByIdAsync(result.get(0).getMusicId(), linkCallback);
                qq.getMusicLinkByIdAsync(result.get(1).getMusicId(), linkCallback);
            }
        });

        final MusicApi netease = MusicApiFactory.create(MusicProvider.网易云音乐);
        netease.searchMusicAsync("Suede", 0, new SimpleRequestCallback<List<? extends Music>>() {
            @Override
            public void onSuccess(List<? extends Music> result) {
                netease.getMusicLinkByIdAsync(result.get(0).getMusicId(), linkCallback);
            }
        });
    }
}
