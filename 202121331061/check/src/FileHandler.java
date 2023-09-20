
import java.io.*;

public class FileHandler {
    public static String readFile(String filePath) throws IOException {
        //从指定路径的文件中逐行读取内容
        StringBuilder content = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String getstr;
            while ((getstr = reader.readLine()) != null) {
                content.append(getstr).append("\n");
            }
        }

        return content.toString();
    }
    public static void writeResult(String filePath, String similarity) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            //将相似度的值写入指定路径的文件中
            writer.write("相似度: " + similarity);
        }
    }
}
