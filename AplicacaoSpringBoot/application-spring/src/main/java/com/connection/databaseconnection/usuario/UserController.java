package com.connection.databaseconnection.usuario;

import com.connection.databaseconnection.associative.conhecimento.ConhecimentoUsuario;
import com.connection.databaseconnection.conhecimento.Conhecimento;
import com.connection.databaseconnection.conhecimento.ConhecimentoRepository;
import com.connection.databaseconnection.conhecimento.types.TipoConhecimento;
import com.connection.databaseconnection.dto.UserDTO;
import com.connection.databaseconnection.dto.UsuarioViewDTO;
import com.connection.databaseconnection.exception.ErroAutenticacao;
import com.connection.databaseconnection.exception.ErroConexao;
import com.connection.databaseconnection.exception.RegraException;
import com.connection.databaseconnection.exception.UserNotFoundException;
import com.connection.databaseconnection.security.access.UserBaseAcess;
import com.connection.databaseconnection.security.captcha.CaptchaDTO;
import com.connection.databaseconnection.security.captcha.CaptchaValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;


import java.awt.peer.CanvasPeer;
import java.util.List;

@Service
@Controller
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {


    //Esse atributo vai armazenar o usuario atual
    private Usuario currentUser = null;

    //Esse Atributo vai nos permitir utilizar os metodos da classe Service
    @Autowired
    private UserService controller;

    @Autowired
    private ConhecimentoRepository conhecimentoRepository;

    @Autowired
    private CaptchaValidator captchaValidator;


    private final UserBaseAcess userBaseAcess;
    private final PasswordEncoder passwordEncoder;


        /*Esse end-point é resposavel pelo login, ele executa o
        metodo "authentication" que verifica o email e a senha no banco*/

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody UserDTO userDTO) {
        try {
            Usuario userAutenticado = controller.authentication(userDTO.getEmail(), userDTO.getSenha());
            currentUser = userAutenticado;
            return ResponseEntity.ok(userAutenticado);
        } catch (ErroAutenticacao e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/recaptcha")
    public ResponseEntity recaptchaValidate(@RequestBody CaptchaDTO captchaDTO) throws Exception {

        Boolean isValidCaptcha = captchaValidator.validateCaptcha(captchaDTO.getCaptcha());

        if(!isValidCaptcha){
            return ResponseEntity.badRequest().body("Captcha não valido");
        }
        return ResponseEntity.ok("Captcha validado com sucesso");
    }


    @GetMapping("/logoff")
    public ResponseEntity logoff() {
        try {
            currentUser = null;
            return ResponseEntity.ok(HttpStatus.ACCEPTED);
        } catch (ErroConexao e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }


    //Pega o json fornecido pelo front do tipo userDTO e cria um user do tipo User
    @PostMapping("/cadastro")
    public ResponseEntity cadastrar(@RequestBody UserDTO userDTO) {

        Usuario user = Usuario.builder()
                .nome(userDTO.getNome())
                .email(userDTO.getEmail())
                .photo(userDTO.getPhoto())
                .senha(userDTO.getSenha())
                .sobre(userDTO.getSobre())
                .local(userDTO.getLocal())
                .title(userDTO.getTitle()).build();

        try {

            String senhaCriptografada = passwordEncoder.encode(user.getSenha());
            user.setSenha(senhaCriptografada);

            Usuario userSalvo = controller.saveUser(user);
            return new ResponseEntity(userSalvo, HttpStatus.CREATED);
        } catch (RegraException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @GetMapping("/about")
    public ResponseEntity sobre(@RequestParam(required = true) Integer id) {
        try {


            Usuario user = this.controller.buscaporId(id);
            if (user != null) {
                return new ResponseEntity(user.getSobre(), HttpStatus.OK);
            } else {
                return new ResponseEntity("Usuário não encontrado", HttpStatus.NO_CONTENT);
            }

        } catch (ErroConexao e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PatchMapping("/about")
    public ResponseEntity atualizarSobre(@RequestBody UserDTO userDTO) {

        try {
            Usuario user = Usuario.builder().id(userDTO.getId()).sobre(userDTO.getSobre()).build();

            controller.updateSobre(user);

            return new ResponseEntity(HttpStatus.OK);

        } catch (UserNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @GetMapping("/view/{id}")
    public ResponseEntity view(@PathVariable("id") Integer id) {

        try {

            UsuarioViewDTO user = this.controller.buscaViewporId(id);
            if (user != null) {
                return new ResponseEntity(user, HttpStatus.OK);
            } else {
                return new ResponseEntity("Usuário não encontrado", HttpStatus.NO_CONTENT);
            }

        } catch (ErroConexao e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    @GetMapping("/find")
    public ResponseEntity findUsers(@RequestParam(required = false) String conhecimento,
                                    @RequestParam(required = false) Integer level,
                                    @RequestParam(required = false) TipoConhecimento tipo ) {
        try {

            if(tipo != null) {
                if (level > 0) {

                    Conhecimento consulta = Conhecimento.builder().tipo(tipo).build();

                    List conhecimentos = controller.buscarPorTipoAndNivel(consulta.getTipo(), level);

                    if (conhecimentos == null) {
                        return new ResponseEntity("Infelizmente ainda não temos usuários que " +
                                "possuem este nível de conhecimento .",HttpStatus.NOT_FOUND);
                    } else {
                        return ResponseEntity.ok(conhecimentos);
                    }

                } else {
                    Conhecimento consulta = Conhecimento.builder().tipo(tipo).build();

                    List conhecimentos = controller.buscarPorTipo(consulta.getTipo());

                    if (conhecimentos == null) {
                        return new ResponseEntity("Infelizmente ainda não temos usuários que" +
                                " possuem este tipo de conhecimento ."
                                , HttpStatus.NOT_FOUND);
                    } else {
                        return ResponseEntity.ok(conhecimentos);
                    }
                }
            }
            if (level > 0) {
                if (conhecimento != null) {

                    Conhecimento con = Conhecimento.builder().conhecimento(conhecimento).build();
                    ConhecimentoUsuario consulta = ConhecimentoUsuario.builder()
                            .conhecimento(con)
                            .nivel(level).build();

                    List conhecimentos = controller.buscarPorLevelandConhecimento(consulta);

                    if (conhecimentos == null) {
                        return new ResponseEntity("Infelizmente ainda não temos usuários que" +
                                "possuem este nível de conhecimento .",HttpStatus.NOT_FOUND);
                    } else {
                        return ResponseEntity.ok(conhecimentos);
                    }

                }else {

                    ConhecimentoUsuario consulta = ConhecimentoUsuario.builder().nivel(level).build();

                    List conhecimentos = controller.buscarPorLevel(consulta.getNivel());

                    if (conhecimentos == null) {
                        return new ResponseEntity("Infelizmente ainda não temos usuários que possuem este nível" +
                                "de conhecimento ."
                                , HttpStatus.NOT_FOUND);
                    } else {
                        return ResponseEntity.ok(conhecimentos);
                    }
                }

            }

            Conhecimento consulta = Conhecimento.builder().conhecimento(conhecimento).build();

            List conhecimentos = controller.buscarConhecimentos(consulta.getConhecimento());


            if (conhecimentos == null) {
                return new ResponseEntity("Infelizmente ainda não temos usuários que possuem este conhecimento ."
                        , HttpStatus.NOT_FOUND);
            }
            else{
                return ResponseEntity.ok(conhecimentos);
            }


        } catch (ErroConexao e) {
            return ResponseEntity.badRequest().body(e.getMessage());

        }
    }

    public Usuario getCurrentUser() {
        return this.currentUser;
    }

}
