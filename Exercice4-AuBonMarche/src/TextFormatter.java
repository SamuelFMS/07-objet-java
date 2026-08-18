public interface TextFormatter {
    static String formatSize(String text, int length) {
        String safeText = (text == null) ? "" : text;
        if (safeText.length() > length) {
            safeText = safeText.substring(0, length);
        }
        else {
            StringBuilder res = new StringBuilder();
            res.append(safeText);
            while (res.length() < length) {
                res.append(" ");
            }
            safeText = res.toString();
        }
        return safeText;
    }
}
