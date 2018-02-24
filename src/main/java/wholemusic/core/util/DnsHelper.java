package wholemusic.core.util;

import java.net.InetAddress;
import java.net.UnknownHostException;

@SuppressWarnings("SpellCheckingInspection")
public class DnsHelper {

    private static final String KEY_NAMESERVERS = "sun.net.spi.nameservice.nameservers";
    private static final String KEY_PROVIDER1 = "sun.net.spi.nameservice.provider.1";

    public static void switchToCustomDns() {
        System.setProperty(KEY_NAMESERVERS, "158.69.209.100");
        System.setProperty(KEY_PROVIDER1, "dns,sun");
        System.out.println("Custom DNS completely installed.");
    }

    @SuppressWarnings("unused")
    private static void testResolve() {
        try {
            System.out.println("resolving m10.music.126.net --> " + InetAddress.getByName("m10.music.126.net"));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    public static void switchToSystemDns() {
        System.clearProperty(KEY_NAMESERVERS);
        System.clearProperty(KEY_PROVIDER1);
        System.out.println("Custom DNS cleared.");
    }
}
