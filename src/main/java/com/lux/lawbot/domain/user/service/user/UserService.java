package com.lux.lawbot.domain.user.service.user;

import com.lux.lawbot.domain.user.payload.request.SignupRequest;
import com.lux.lawbot.domain.user.payload.response.ApiResponse;
import com.lux.lawbot.domain.user.payload.response.JwtResponse;
import com.lux.lawbot.global.exception.BusinessException;

public interface UserService {
    ApiResponse<JwtResponse> registerUser(SignupRequest signupRequest) throws BusinessException;
    JwtResponse authenticateAndGenerateJWT(String email, String password);
}