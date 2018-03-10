package wholemusic.core.test.framework.impl;

import org.junit.Ignore;
import org.junit.Test;
import wholemusic.core.api.MusicApi;
import wholemusic.core.api.MusicApiFactory;
import wholemusic.core.api.MusicProvider;
import wholemusic.core.model.MusicLink;
import wholemusic.core.test.framework.mark.GetMusicLinkTest;
import wholemusic.core.test.util.TestUtils;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

@Ignore
public class GetMusicLinkTestImpl implements GetMusicLinkTest {

    private final MusicApi api;
    private final String songId;

    public GetMusicLinkTestImpl(MusicProvider provider, String songId) {
        this.songId = songId;
        this.api = MusicApiFactory.create(provider);
    }

    @Test
    public void getMusicLinkTest() throws IOException {
        MusicLink link = api.getMusicLinkByIdSync(songId);
        assertEquals(link.getSongId(), songId);
        assertEquals(200, TestUtils.testDownload(link.getUrl()));
    }
}
