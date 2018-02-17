package wholemusic.core.util;

public class CommonUtils {
    public static String generateChinaRandomIP() {
        String ip = "47.93.50." + (1 + RandomHelper.getInstance().nextInt(255));
        return ip;
    }
}
