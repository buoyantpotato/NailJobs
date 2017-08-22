
public class P275_HIndex2 {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }

        int first = 0, last = citations.length - 1;
        while (first + 1 < last) {
            int mid = first + (last - first) / 2;
            if (citations[mid] == citations.length - mid) {
                return citations.length - mid;
            } else if (citations[mid] > citations.length - mid) {
                last = mid;
            } else {
                first = mid;
            }
        }

        return citations[first] >= citations.length - first ? citations.length - first
                : citations[last] >= citations.length - last ? citations.length - last : 0;
    }
}
