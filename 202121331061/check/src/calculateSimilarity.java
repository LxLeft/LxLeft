
import com.huaban.analysis.jieba.JiebaSegmenter;
import com.huaban.analysis.jieba.SegToken;

import java.util.HashSet;
import java.util.Set;

public class calculateSimilarity {
    public static double calculateJaccardSimilarity(Set<String> set1, Set<String> set2) {
        // 计算两个集合的交集大小
        Set<String> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);
        int intersectionSize = intersection.size();

        // 计算两个集合的并集大小
        Set<String> union = new HashSet<>(set1);
        union.addAll(set2);
        int unionSize = union.size();

        // 计算Jaccard相似度
        double jaccard = (double) intersectionSize / unionSize;

        return jaccard;
    }

    public static Set<String> getWordSet(String text) {
        Set<String> wordSet = new HashSet<>();

        // 使用jieba分词库进行中文分词
        JiebaSegmenter segmenter = new JiebaSegmenter();
        Iterable<SegToken> tokens = segmenter.process(text, JiebaSegmenter.SegMode.SEARCH);

        // 构建词频向量
        for (SegToken token : tokens) {
            String word = token.word.toLowerCase().trim();
            if (!word.isEmpty()) {
                wordSet.add(word);
            }
        }

        return wordSet;
    }
}
