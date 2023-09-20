import java.io.IOException;
import java.util.Set;

public class main {
    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("请根据该格式在命令行给出参数：Java: java -jar main.jar [原文文件] [抄袭版论文的文件] [答案文件]");
            return;
        }

        String originalPaperFile = args[0];
        String plagiarizedPaperFile = args[1];
        String answerFile = args[2];

        try {
            // 读取论文原文和抄袭版论文
            String originalPaper = FileHandler.readFile(originalPaperFile);
            String plagiarizedPaper = FileHandler.readFile(plagiarizedPaperFile);

            // 构建词频向量
            Set<String> originalWordSet = calculateSimilarity.getWordSet(originalPaper);
            Set<String> plagiarizedWordSet = calculateSimilarity.getWordSet(plagiarizedPaper);

            // 计算相似度
            double similarity = calculateSimilarity.calculateJaccardSimilarity(originalWordSet, plagiarizedWordSet);
            String similaritystring = String.format("%.2f", similarity);
            // 输出结果到答案文件
            FileHandler.writeResult(answerFile, similaritystring);

            System.out.println("相似度: " + similaritystring);
        } catch (IOException e) {
            System.out.println("发生错误：" + e.getMessage());
        }
    }
}
