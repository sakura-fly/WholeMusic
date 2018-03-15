package wholemusic.core.test.framework.impl;

import wholemusic.core.api.MusicApi;
import wholemusic.core.api.MusicApiFactory;
import wholemusic.core.api.MusicProvider;
import wholemusic.core.model.Album;
import wholemusic.core.model.Song;
import wholemusic.core.test.framework.AbsMusicTestCase;
import wholemusic.core.test.framework.mark.GetAlbumTest;
import wholemusic.core.util.TextUtils;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

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
        String albumId = null;
        for (Song song : page0) {
            albumId = song.getAlbum().getAlbumId();
            if (!TextUtils.isEmpty(albumId)) {
                break;
            }
        }
        Album album = api.getAlbumInfoByIdSync(albumId, false);
        println("album: " + album);
        assertNotNull(album.getName());
        assertEquals(albumId, album.getAlbumId());
        assertTrue(album.getArtists().size() > 0);
        assertTrue(album.getSongs().size() > 0);
        assertEquals(provider, album.getMusicProvider());
    }
}
