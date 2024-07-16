package com.lux.lawbot.domain.user.service.user;

import com.lux.lawbot.domain.user.domain.entity.user.User;
import com.lux.lawbot.domain.user.domain.repository.user.UserRepository;
import com.lux.lawbot.domain.user.payload.request.SignupRequest;
import com.lux.lawbot.domain.user.payload.response.ApiResponse;
import com.lux.lawbot.domain.user.payload.response.JwtResponse;
import com.lux.lawbot.domain.user.security.jwt.JwtUtils;
import com.lux.lawbot.domain.user.security.service.UserDetailsImpl;
import com.lux.lawbot.global.exception.BusinessException;
import com.lux.lawbot.global.exception.error.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder encoder;
    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;

    @Override
    @Transactional
    public ApiResponse<JwtResponse> registerUser(SignupRequest signupRequest) throws BusinessException {
        validateEmail(signupRequest.getEmail());
        User user = createUser(signupRequest);
        userRepository.save(user);
        JwtResponse jwtResponse = authenticateAndGenerateJWT(signupRequest.getEmail(), signupRequest.getPassword());
        return ApiResponse.setApiResponse(true, "회원 가입이 완료 되었습니다!", jwtResponse);
    }

    /* 인증 및 JWT 토큰 생성 */
    public JwtResponse authenticateAndGenerateJWT(String email, String password) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(email, password));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtUtils.generateJwtToken(authentication);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        return JwtResponse.setJwtResponse(jwt, userDetails.getId(), userDetails.getEmail());
    }

    private void validateEmail(String email) throws BusinessException {
        if (userRepository.existsByEmail(email)) {
            throw new BusinessException(ErrorCode.EMAIL_BAD_REQUEST);
        }
    }

    private User createUser(SignupRequest signupRequest) {
        return User.registerUser(
                signupRequest.getEmail(),
                encoder.encode(signupRequest.getPassword())
        );
    }
}