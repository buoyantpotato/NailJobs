/**
 * Created by linzhou on 8/13/17.
 */
public class P165_CompareVersionNum {
    public int compareVersion(String version1, String version2) {
        if (version1 == null || version2 == null
                || version1.length() == 0 || version2.length() == 0) {
            return 0;
        }

        String[] v1 = version1.split("\\."); // In regular expresion, '.' means something so use "\\." to refer "."
        String[] v2 = version2.split("\\.");

        int i = 0;
        int len = Math.max(v1.length, v2.length);
        while (i < len) {
            int level1 = i < v1.length ? Integer.parseInt(v1[i]) : 0; // Integer.parseInt() is usefule for numeric String
            int level2 = i < v2.length ? Integer.parseInt(v2[i]) : 0; // Complemental Position
            if (level1 == level2) {
                i++;
                continue;
            } else {
                return level1 > level2 ? 1 : -1;
            }
        }

        return 0;
    }
}
