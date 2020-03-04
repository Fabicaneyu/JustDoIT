package br.com.bandtec.justdoit;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class UsuarioController {

    @GetMapping("/{username}/{password}")
    public void login
            (@PathVariable("{username}") String username,
            @PathVariable("{password}")String password){};


}
