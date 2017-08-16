/**
 * Created by linzhou on 8/15/17.
 */
public class P468_ValidateIPAddr {
    public String validIPAddress(String IP) {
        if (IP == null || IP.length() == 0) {
            return "Neither";
        }
        if (IP.charAt(0) == '.' || IP.charAt(0) == ':'
                || IP.charAt(IP.length() - 1) == '.'
                || IP.charAt(IP.length() - 1) == ':' ) {
            return "Neither";
        }

        String[] ipv4 = IP.split("\\.");
        String[] ipv6 = IP.split(":");

        if (ipv4.length == 4) {
            if (isEachDigitValidforIPv4(ipv4)) {
                return "IPv4";
            } else {
                return "Neither";
            }
        } else if (ipv6.length == 8) {
            if (isEachDigitValidforIPv6(ipv6)) {
                return "IPv6";
            } else {
                return "Neither";
            }
        }

        return "Neither";
    }

    private boolean isEachDigitValidforIPv4(String[] ipv4) {
        for (String s : ipv4) {
            try {
                int num = Integer.parseInt(s);
                if ((num < 0 || num >= 256)
                        || (num != 0 && s.charAt(0) == '0')
                        || (num == 0 && s.length() > 1)) {
                    return false;
                }
            } catch (Exception e) {
                return false;
            }

        }

        return true;
    }

    private boolean isEachDigitValidforIPv6(String[] ipv6) {
        for (String s : ipv6) {
            char[] chs = s.toCharArray();
            if (chs.length == 0 || chs.length > 4) {
                return false;
            }
            for (char ch : chs) {
                if (!Character.isDigit(ch)
                        && !(ch >= 65 && ch <= 70)
                        && !(ch >= 97 && ch <= 102)) {
                    return false;
                }
            }
        }
        return true;
    }
}
