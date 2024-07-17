package com.lux.lawbot.domain.ai.presentation;

import com.lux.lawbot.domain.ai.service.AiService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ai")
@Tag(name = "Ai", description = "Ai 관련 api 입니다.")
public class AiController {

    private final AiService aiService;

    public AiController(AiService aiService) {
        this.aiService = aiService;
    }

    @PostMapping("/simulate")
    @Operation(summary = "정책 시뮬레이터", description = "궁금한 정책을 시뮬레이션 합니다.")
    public String simulate(@RequestBody String message) {
        return aiService.simulate(message);
    }

    @PostMapping("/chatbot")
    @Operation(summary = "챗봇", description = "Ai 챗봇 Lux")
    public String chatbot(@RequestBody String message) {
        return aiService.chatbot(message);
    }
}