package com.sinco.common.word;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.io.Charsets;
import org.apache.commons.io.IOUtils;  
  
/** 
 * 初始化敏感词库<br> 
 * 将敏感词加入到HashMap中<br> 
 * 构建DFA算法模型 
 *  
 * @author dxm 
 *  
 */  
@SuppressWarnings({ "rawtypes", "unchecked" })  
public class SensitiveWordInit {  
  
    // 字符编码  
    private static String ENCODING = "UTF-8";  
  
    /** 
     * 初始化敏感字库 
     *  
     * @return 
     */  
    public static Map initKeyWord(InputStream in) {  
        // 读取敏感词库  
        Set<String> wordSet;
		try {
			wordSet = readSensitiveWordFile(in);
			// 将敏感词库加入到HashMap中  
			return addSensitiveWordToHashMap(wordSet);  
		} catch (IOException e) {
			throw new RuntimeException(e);
		}  
    }  
  
    /** 
     * 读取敏感词库，将敏感词放入HashSet中，构建一个DFA算法模型：<br> 
     * 中 = { isEnd = 0 国 = {<br> 
     * isEnd = 1 人 = {isEnd = 0 民 = {isEnd = 1} } 男 = { isEnd = 0 人 = { isEnd = 
     * 1 } } } } 五 = { isEnd = 0 星 = { isEnd = 0 红 = { isEnd = 0 旗 = { isEnd = 1 
     * } } } } 
     *  
     */  
    private static Map addSensitiveWordToHashMap(Set<String> wordSet) {  
  
        // 初始化敏感词容器，减少扩容操作  
        Map wordMap = new HashMap(wordSet.size());  
  
        for (String word : wordSet) {  
            Map nowMap = wordMap;  
            for (int i = 0; i < word.length(); i++) {  
  
                // 转换成char型  
                char keyChar = word.charAt(i);  
  
                // 获取  
                Object tempMap = nowMap.get(keyChar);  
  
                // 如果存在该key，直接赋值  
                if (tempMap != null) {  
                    nowMap = (Map) tempMap;  
                }  
  
                // 不存在则，则构建一个map，同时将isEnd设置为0，因为他不是最后一个  
                else {  
  
                    // 设置标志位  
                    Map<String, String> newMap = new HashMap<String, String>();  
                    newMap.put("isEnd", "0");  
  
                    // 添加到集合  
                    nowMap.put(keyChar, newMap);  
                    nowMap = newMap;  
                }  
  
                // 最后一个  
                if (i == word.length() - 1) {  
                    nowMap.put("isEnd", "1");  
                }  
            }  
        }  
  
        return wordMap;  
    }  
  
    /** 
     * 读取敏感词库中的内容，将内容添加到set集合中 
     *  
     * @return 
     * @throws IOException 
     * @throws Exception 
     */  
    private static Set<String> readSensitiveWordFile(InputStream in ) throws IOException {
        try {
            List<String> words=IOUtils.readLines(in, Charsets.toCharset(ENCODING));
            return  new HashSet<>(words); 
        } finally {
            IOUtils.closeQuietly(in);
        }
    }  
}  