public interface TextFormatter {
    /**
     * Truncate or append a text
     *
     * @param text
     * @param length
     * @return
     */
    static String formatSize(String text, int length) {
        String safeText = (text == null) ? "" : text;
        if (safeText.length() > length) {
            safeText = safeText.substring(0, length);
        } else {
            StringBuilder res = new StringBuilder();
            res.append(safeText);
            while (res.length() < length) {
                res.append(" ");
            }
            safeText = res.toString();
        }
        return safeText;
    }

    /**
     * Truncate or append a text with appendText
     *
     * @param text
     * @param length
     * @return
     */
    static String formatSize(String text, int length, String appendText) {
        String safeText = (text == null) ? "" : text;
        if (safeText.length() > length) {
            safeText = safeText.substring(0, length);
        } else {
            StringBuilder res = new StringBuilder();
            res.append(safeText);
            while (res.length() < length) {
                res.append(appendText);
            }
            safeText = res.toString();
        }
        return safeText;
    }

    /**
     * Repeat a String x times
     */
    static String repeat(String a, int x) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < x; i++) {
            res.append(a);
        }
        return res.toString();
    }
}
