package wholemusic.core.test.framework.impl;

import wholemusic.core.api.MusicApi;
import wholemusic.core.api.MusicApiFactory;
import wholemusic.core.api.MusicProvider;
import wholemusic.core.model.Album;
import wholemusic.core.model.Song;
import wholemusic.core.test.framework.AbsMusicTestCase;
import wholemusic.core.test.framework.mark.GetAlbumTest;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class GetAlbumTestImpl extends AbsMusicTestCase implements GetAlbumTest {
    private MusicApi api;
    private String searchQuery;
    private MusicProvider provider;

    @Override
    public void init(Object[] args) {
        provider = (MusicProvider) args[0];
        searchQuery = (String) args[1];
        api = MusicApiFactory.create(provider);
    }

    @Override
    public void runTest() throws IOException {
        List<? extends Song> page0 = api.searchMusicSync(searchQuery, 0, true);
        String albumId = page0.get(0).getAlbum().getAlbumId();
        Album album = api.getAlbumInfoByIdSync(albumId, false);
        assertEquals(albumId, album.getAlbumId());
        assertEquals(provider, album.getMusicProvider());
        println("album: " + album);
    }
}
