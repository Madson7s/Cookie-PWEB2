package br.com.ifal.usando_cookie;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class CookieController {

    @GetMapping("/")
    public ModelAndView lerCookie(@CookieValue(value = "primeiroAcesso", defaultValue = "Sim") String primeiroAcesso,
            HttpServletResponse response) {

        ModelAndView mv = new ModelAndView("index");
        if (primeiroAcesso.equals("Sim")) {

            mv.addObject("msg", "Este é o primeiro acesso");

        } else {
            mv.addObject("msg", "Este NÃO é meu primerio acesso! Bem-vindo de Volta " + primeiroAcesso);
        }
        return mv;

    }

    @PostMapping("/adicionacookie")
    public ModelAndView mudaNomeCookie(String nome, HttpServletResponse response) {
        Cookie c = new Cookie("primeiroAcesso", nome);
        response.addCookie(c);
        return new ModelAndView("redirect:/");
    }
}
