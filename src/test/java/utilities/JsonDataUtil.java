package utilities;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

public class JsonDataUtil {

    public static Object[][] readJsonData(String filePath) throws IOException {
        Gson gson = new Gson();
        FileReader reader = new FileReader(filePath);

        Type listType = new TypeToken<List<Map<String, String>>>() {}.getType();
        List<Map<String, String>> dataList = gson.fromJson(reader, listType);
        reader.close();

        Object[][] dataArray = new Object[dataList.size()][1];
        for (int i = 0; i < dataList.size(); i++) {
            dataArray[i][0] = dataList.get(i);
        }

        return dataArray;
    }
}