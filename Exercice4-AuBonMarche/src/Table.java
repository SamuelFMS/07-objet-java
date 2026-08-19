import javax.xml.soap.Text;
import java.util.ArrayList;

public class Table {
    private static final String crossDelimiter = "+";
    private static final String verticalDelimiter = "-";
    private static final String horizontalDelimiter = "|";
    private ArrayList<Column> myColumn = new ArrayList<>();
    private int spaceHorizontal = 1;
    private int numberLine = 0;

    public void addLine(String... myLines) {
        while(myColumn.size() < myLines.length) {
            myColumn.add(new Column());
        }
        int index = 0;
        for(String line : myLines){
            myColumn.get(index).addColumn(line);
            index++;
        }
        numberLine++;
    }

    private String generateDelimiter(){
        StringBuilder lineDelimiterString = new StringBuilder();
        for (Column column:myColumn) {
            lineDelimiterString.append(crossDelimiter);
            lineDelimiterString.append(TextFormatter.repeat(verticalDelimiter, column.returnMaxSizeColumn() + spaceHorizontal*2));
        }
        lineDelimiterString.append(crossDelimiter);
        return lineDelimiterString.toString();
    }

    @Override
    public String toString() {
        StringBuilder tableString = new StringBuilder();
        tableString.append(generateDelimiter());
        tableString.append("\n");
        for(int indexLine = 0; indexLine < numberLine; indexLine++){
            tableString.append(horizontalDelimiter);
            for (Column column : myColumn) {
                tableString.append( TextFormatter.repeat(" ", spaceHorizontal));
                tableString.append(TextFormatter.formatSize(column.getLine(indexLine),column.returnMaxSizeColumn()));
                tableString.append( TextFormatter.repeat(" ", spaceHorizontal));
                tableString.append(horizontalDelimiter);
            }
            tableString.append("\n");
            if(indexLine == 0){
                tableString.append(generateDelimiter());
                tableString.append("\n");
            }
        }
        tableString.append(generateDelimiter());
        return tableString.toString();
    }
}
