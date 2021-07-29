package com.example.idaas.demooidc;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/user")
    public String user(Model model,
                       @AuthenticationPrincipal OAuth2User oidcUser) {
        model.addAttribute("userName", oidcUser.getName());
//        model.addAttribute("audience", oidcUser.getIdToken().getAudience());
        return "user";
    }
}