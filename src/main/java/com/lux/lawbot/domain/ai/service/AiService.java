package com.lux.lawbot.domain.ai.service;

import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AiService {

    private final OpenAiChatModel openAiChatModel;

    public AiService(OpenAiChatModel openAiChatModel) {
        this.openAiChatModel = openAiChatModel;
    }

    public String simulate(String message) {
        PromptTemplate promptTemplate = new PromptTemplate(
                "너는 변호사를 대신해서 사용자에게 답변을 수행해주는 챗봇이야.\n" +
                        "사용자가 궁금한 정책을 질문할건데 너는 그 정책이 시행되었을 경우\n" +
                        "최대 3가지 측면에서 긍정적인 영향과 부정적인 영향을 한줄 이내로 적어줘.\n" +
                        "\n" +
                        "예시:\n" +
                        "[의료 시스템의 미치는 영향\n" +
                        "긍정적인 영향:\n" +
                        "의사 수가 증가함에 따라 의료 접근성이 향상되고,\n" +
                        "농어촌 및 의료 취약 지역에서의 의사 부족 문제가 개선될 수 있습니다.\n" +
                        "부정적인 영향:\n" +
                        "의사 수 증가로 인해 의료 서비스의 이용이 늘어나면\n" +
                        "전체 의료비용이 상승할 가능성이 있습니다.\n" +
                        "\n" +
                        "경제적인 측면의 미치는 영향\n" +
                        "긍정적인 영향:\n" +
                        "관련 교육 및 의료 시설의 확장과 함께 새로운 일자리가 창출될 것입니다.\n" +
                        "부정적인 영향:\n" +
                        "의대 증원을 위한 교육 인프라 확충 및 유지에\n" +
                        "상당한 비용이 들 수 있습니다.]\n" +
                        "\n" +
                        "질문은 {question} 이야."
        );

        Prompt prompt = promptTemplate.create(Map.of("question", message));

        return openAiChatModel.call(prompt).getResult().getOutput().getContent();
    }


    public String chatbot(String message) {
        PromptTemplate promptTemplate = new PromptTemplate(
                "너는 사람들이 전문가에게 상담을 좀 더 수훨하게 해줄 수 있도록 접근성을 낮춰주는 챗봇이야.\n" +
                "사용자가 질문을 하면 너는 법률/정책 전문가로서 평균적인 수치를 포함해서 2문장이내에 답변을 해줘. \n" +
                "질문은 {question} 이야."
        );

        Map<String, Object> variables = new HashMap<>();
        variables.put("question", message);

        String prompt = String.valueOf(promptTemplate.create(variables));

        return openAiChatModel.call(prompt);
    }
}
