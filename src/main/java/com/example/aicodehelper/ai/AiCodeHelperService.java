package com.example.aicodehelper.ai;

import dev.langchain4j.service.Result;
import dev.langchain4j.service.SystemMessage;

import java.util.List;

public interface AiCodeHelperService {

    @SystemMessage(fromResource = "system-prompt.txt")
    String chat(String userMessage);

    @SystemMessage(fromResource = "system-prompt.txt")
    Report chatForReport(String userMessage);

    // 报告类型的数据结构
    record Report(String name, List<String> suggestionsList){};

    // 带RAG的会话
    @SystemMessage(fromResource = "system-prompt.txt")
    Result<String> chatWithRag(String userMessage);

}
