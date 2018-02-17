package wholemusic.core.util;

import wholemusic.core.model.Album;
import wholemusic.core.model.Artist;
import wholemusic.core.model.Song;

import java.util.ArrayList;

public class SongUtils {
    public static String getArtistsString(Song song) {
        ArrayList<String> names = new ArrayList<>();
        for (Artist artist : song.getArtists()) {
            names.add(artist.getName());
        }
        return TextUtils.join(", ", names);
    }

    public static String generateSongPath(Song song) {
        Album album = song.getAlbum();
        String path = FileUtils.combine(song.getMusicProvider().toString(),
                album.getName(), generateSongFilename(song));
        return path;
    }

    private static String generateSongFilename(Song song) {
        return song.getName() + " - " + getArtistsString(song) + ".mp3";
    }
}
