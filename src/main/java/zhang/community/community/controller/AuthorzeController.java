package zhang.community.community.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import zhang.community.community.dto.AccessTokenDTO;
import zhang.community.community.dto.GithubUser;
import zhang.community.community.mapper.UserMapper;
import zhang.community.community.model.User;
import zhang.community.community.provider.GithubProvider;
import zhang.community.community.service.UserService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class AuthorzeController {

    @Autowired
    private GithubProvider githubProvider;

    @Value("${github.client.id}")
    private String clientId;

    @Value("${github.client.secret}")
    private String clientSecret;

    @Value("${github.redirect.uri}")
    private String redirectUri;

    @Autowired
    private UserService userService;

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state,
                           HttpServletRequest request,
                           HttpServletResponse response) {
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id(clientId);
        accessTokenDTO.setClient_secret(clientSecret);
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri(redirectUri);
        accessTokenDTO.setState(state);
        String accessToken = githubProvider.getAccessToken(accessTokenDTO);

        GithubUser githubUser = githubProvider.getUser(accessToken);
        if (githubUser != null&&githubUser.getId()!=null ) {
            User user = new User();
            user.setToken(accessToken);
            user.setName(githubUser.getName());
            user.setAccountId(String.valueOf(githubUser.getId()));
            user.setAvatarUrl(githubUser.getAvatarUrl());
            userService.createOrUpdate(user);
            response.addCookie(new Cookie("token", accessToken));
            return "redirect:/";
        } else {
            //登陆失败，重新登陆
            return "redirect:/";
        }
    }
    @GetMapping("/logout")
    public String logout(HttpServletRequest request,HttpServletResponse response){
        request.getSession().removeAttribute("user");
        Cookie cookie = new Cookie("token",null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);

        return "redirect:/";
    }



}
