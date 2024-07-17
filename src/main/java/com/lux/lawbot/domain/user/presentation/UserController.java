package com.lux.lawbot.domain.user.presentation;

import com.lux.lawbot.domain.user.payload.request.LoginRequest;
import com.lux.lawbot.domain.user.payload.request.SignupRequest;
import com.lux.lawbot.domain.user.service.user.UserService;
import com.lux.lawbot.global.exception.BusinessException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "유저", description = "유저 관련 api 입니다.")
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @Operation(summary = "로그인", description = "이메일과 비밀번호를 통해 로그인을 진행합니다.")
    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
        return ResponseEntity.ok().body(userService.authenticateAndGenerateJWT(loginRequest.getEmail(), loginRequest.getPassword()));
    }

    @Operation(summary = "회원가입", description = "이메일과 비밀번호로 회원가입을 진행합니다.")
    @PostMapping("/signup")
    public ResponseEntity<?> registerAndAuthenticateUser(@RequestBody SignupRequest signupRequest) throws BusinessException {
        return ResponseEntity.ok().body(userService.registerUser(signupRequest));
    }
}