package wholemusic.core.test.framework.impl;

import org.junit.Ignore;
import org.junit.Test;
import wholemusic.core.api.MusicApi;
import wholemusic.core.api.MusicApiFactory;
import wholemusic.core.api.MusicProvider;
import wholemusic.core.model.Album;
import wholemusic.core.model.Song;
import wholemusic.core.test.framework.GetAlbumTest;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;

@Ignore
public class GetAlbumTestImpl implements GetAlbumTest {
    private final MusicApi api;
    private final String searchQuery;
    private final MusicProvider provider;

    public GetAlbumTestImpl(MusicProvider provider, String searchQuery) {
        this.provider = provider;
        this.api = MusicApiFactory.create(provider);
        this.searchQuery = searchQuery;
    }

    @Test
    public void getAlbumInfoTest() throws IOException {
        List<? extends Song> page0 = api.searchMusicSync(searchQuery, 0, true);
        String albumId = page0.get(0).getAlbum().getAlbumId();
        Album album = api.getAlbumInfoByIdSync(albumId, false);
        assertEquals(albumId, album.getAlbumId());
        assertEquals(provider, album.getMusicProvider());
    }
}
