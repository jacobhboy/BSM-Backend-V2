package bssm.bsm.domain.auth.presentation;

import bssm.bsm.domain.auth.service.BsmOauthService;
import bssm.bsm.domain.auth.service.AuthService;
import bssm.bsm.global.auth.CurrentUser;
import bssm.bsm.domain.auth.presentation.dto.res.AuthTokenRes;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final BsmOauthService bsmOauthService;

    @DeleteMapping("logout")
    public void logout(
            HttpServletRequest req,
            HttpServletResponse res
    ) {
        authService.logout(req, res);
    }

    @PostMapping("/oauth/bsm")
    public AuthTokenRes bsmOauth(
            @RequestParam(value = "code") String authCode,
            HttpServletResponse res
    ) throws Exception {
        return authService.loginPostProcess(res, bsmOauthService.bsmOauth(authCode));
    }
}
