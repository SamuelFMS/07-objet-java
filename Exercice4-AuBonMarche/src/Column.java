import java.util.ArrayList;
import java.util.Arrays;

public class Column {
    private ArrayList<String> myColumn = new ArrayList<>();

    public Column(String... myColumn) {
        this.myColumn = new ArrayList<>(Arrays.asList(myColumn));
    }

    public void addColumn(String value){
        myColumn.add(value);
    }

    public String getLine(int indexLine) {
        return myColumn.get(indexLine);
    }

    public int returnMaxSizeColumn(){
        int max = 0;
        for(String s : myColumn) {
            if(s.length() > max){
                max = s.length();
            }
        }
        return max;
    }
}
