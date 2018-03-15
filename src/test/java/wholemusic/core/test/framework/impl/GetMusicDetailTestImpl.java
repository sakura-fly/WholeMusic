package wholemusic.core.test.framework.impl;

import wholemusic.core.api.MusicApi;
import wholemusic.core.api.MusicApiFactory;
import wholemusic.core.api.MusicProvider;
import wholemusic.core.model.Song;
import wholemusic.core.test.framework.AbsMusicTestCase;
import wholemusic.core.test.framework.mark.GetMusicDetailTest;
import wholemusic.core.test.util.TestUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GetMusicDetailTestImpl extends AbsMusicTestCase implements GetMusicDetailTest {
    private MusicApi api;
    private String searchQuery;

    @Override
    public void init(Object[] args) {
        MusicProvider provider = (MusicProvider) args[0];
        api = MusicApiFactory.create(provider);
        searchQuery = (String) args[1];
    }

    @Override
    public void runTest() throws IOException {
        List<? extends Song> songs = api.searchMusicSync(searchQuery, 0, false);
        ArrayList<String> musicIds = new ArrayList<>();
        for (Song song : songs) {
            musicIds.add(song.getSongId());
        }
        List<? extends Song> songDetails = api.getSongDetailInfoByIdsSync(true, musicIds.toArray(new String[]{}));
        assertEquals(songDetails.size(), songs.size());
        Song detailSong0 = songDetails.get(0);
        println("detailSong0: " + detailSong0);
        String picUrl = detailSong0.getPicUrl();
        println("picUrl: " + picUrl);
        assertEquals(200, TestUtils.testDownload(picUrl));
        assertTrue(detailSong0.getLyric().getLyric().length() > 0);
    }
}
