package wholemusic.core.util;

import wholemusic.core.model.Album;
import wholemusic.core.model.Artist;
import wholemusic.core.model.Song;

import java.util.ArrayList;
import java.util.List;

public class SongUtils {
    public static String getArtistsString(Song song) {
        return getArtistsString(song.getArtists());
    }

    public static String getArtistsString(List<? extends Artist> artists) {
        ArrayList<String> names = new ArrayList<>();
        if (artists != null) {
            for (Artist artist : artists) {
                names.add(artist.getName());
            }
        }
        return TextUtils.join(", ", names);
    }

    public static String generateSongPath(Album album, Song song) {
        // 专辑文件夹名称是专辑名+专辑信息中的歌手名(不要用歌曲中的歌手名)
        final String albumPathName = album.getName() + " - " + album.getFormattedArtistsString();
        String path = FileUtils.combine(song.getMusicProvider().toString(),
                albumPathName, generateSongFilename(song));
        return path;
    }

    private static String generateSongFilename(Song song) {
        return song.getName() + " - " + getArtistsString(song) + ".mp3";
    }
}
