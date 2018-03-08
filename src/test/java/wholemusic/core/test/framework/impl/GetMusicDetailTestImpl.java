package wholemusic.core.test.framework.impl;

import org.junit.Ignore;
import wholemusic.core.api.MusicApi;
import wholemusic.core.api.MusicApiFactory;
import wholemusic.core.api.MusicProvider;
import wholemusic.core.model.Song;
import wholemusic.core.test.framework.GetMusicDetailTest;
import wholemusic.core.test.util.TestUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@Ignore
public class GetMusicDetailTestImpl implements GetMusicDetailTest {
    private final MusicApi api;
    private final String searchQuery;

    public GetMusicDetailTestImpl(MusicProvider provider, String searchQuery) {
        this.api = MusicApiFactory.create(provider);
        this.searchQuery = searchQuery;
    }

    @Override
    public void getMusicDetailTest() throws IOException {
        List<? extends Song> songs = api.searchMusicSync(searchQuery, 0, false);
        ArrayList<String> musicIds = new ArrayList<>();
        for (Song song : songs) {
            musicIds.add(song.getSongId());
        }
        List<? extends Song> songDetails = api.getSongDetailInfoByIdsSync(true, musicIds.toArray(new String[]{}));
        assertEquals(songDetails.size(), songs.size());
        Song detailSong0 = songDetails.get(0);
        assertEquals(200, TestUtils.testDownload(detailSong0.getPicUrl()));
        assertTrue(detailSong0.getLyric().getLyric().length() > 0);
    }
}
