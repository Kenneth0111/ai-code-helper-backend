package com.example.aicodehelper.ai;

import dev.langchain4j.rag.content.Content;
import dev.langchain4j.service.Result;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class AiCodeHelperServiceTest {

    @Resource
    private AiCodeHelperService aiCodeHelperService;

    @Test
    void chat() {
        String result = aiCodeHelperService.chat("你好，我是一个新手Java程序员");
        System.out.println(result);
    }

    @Test
    void chatWithMemory() {
        String result1 = aiCodeHelperService.chat("你好，我是一个新手Java程序员");
        System.out.println(result1);
        String result2 = aiCodeHelperService.chat("我是干什么的？");
        System.out.println(result2);
    }

    @Test
    void chatForReport() {
        String userMessage = "你好，我叫老K，学习Java半年，请帮我制定学习Java AI编程的学习报告";
        AiCodeHelperService.Report report = aiCodeHelperService.chatForReport(userMessage);
        System.out.println(report);
    }

    @Test
    void chatWithRag() {
        Result<String> result = aiCodeHelperService.chatWithRag("怎么学习 Java？有哪些常见面试题？");
        String content = result.content();
        List<Content> sources = result.sources();
        System.out.println(content);
        System.out.println(sources);
    }

}