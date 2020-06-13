package com.connection.databaseconnection.conhecimento;

import com.connection.databaseconnection.associative.conhecimento.ConhecimentoUsuarioRepository;
import com.connection.databaseconnection.associative.interesse.InteresseUsuarioRepository;
import com.connection.databaseconnection.conhecimento.types.TipoConhecimento;
import com.connection.databaseconnection.iterators.BuscaBuilder;
import com.connection.databaseconnection.iterators.ConhecimentoBuilder;
import com.connection.databaseconnection.iterators.InteresseBuilder;
import com.connection.databaseconnection.security.access.UserBaseAcess;
import com.connection.databaseconnection.security.captcha.CaptchaValidator;
import com.connection.databaseconnection.security.jwt.JwtService;
import com.connection.databaseconnection.usuario.UserService;
import com.connection.databaseconnection.usuario.Usuario;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.EntityManager;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class ConhecimentoControllerTest {


    @Autowired
    private CaptchaValidator captchaValidator;

    @Autowired
    private PasswordEncoder encoder;

    @MockBean
    private ConhecimentoRepository repository;

    @Autowired
    private ConhecimentoController controller;

    @Autowired
    private ConhecimentoService service;

//    @Autowired
//    private UserService userController;

    @Autowired
    ConhecimentoBuilder conhecimentoBuilder;

    @Autowired
    InteresseBuilder interesseBuilder;

    @Autowired
    private BuscaBuilder buscaBuilder;

    @Autowired
    private ConhecimentoUsuarioRepository conhecimentoUsuarioRepository;

    @Autowired
    private InteresseUsuarioRepository interesseUsuarioRepository;

    @Autowired
    private EntityManager entityManager;

    @Test
    void buscarConhecimentos() {
    }

    @Test
    void buscarInteresses() {
    }

    @Test
    void removerConhecimentoPorId() {
    }

    @Test
    void removerInteresseorId() {
    }

    @Test
    void recomendados() {
    }

    @Test
    void buscaTipos() {

        //cenário 1 - Deve trazer a mesma quantidade de conhecimentos cadatrados & status 200

        TipoConhecimento dado = TipoConhecimento.DADOS;

        List<Conhecimento> conhecimentos = Arrays.asList(new Conhecimento(), new Conhecimento());

        Mockito.when(repository.findByTipo(dado)).thenReturn( new ArrayList<>(conhecimentos));

        ResponseEntity resposta = controller.buscaTipos(dado);

        assertEquals(200, resposta.getStatusCodeValue(),
                "Status em caso de sucesso na requisição é o 200");

        // tive que criar essa lista do tipo >Conhecimento< para poder pegar o tamanho dela depois.
        List<Conhecimento> lista = (List<Conhecimento>) resposta.getBody();

        assertEquals(conhecimentos.size(), lista.size(),"O tamanho da lista retornada deve ser o mesmo" +
                "disponível na base de dados");


        //cenário 2 - Não existem conhecimentos para este tipo específico, status 204


        Mockito.when(repository.findByTipo(dado)).thenReturn(new ArrayList<>());

        resposta = controller.buscaTipos(dado);

        assertEquals(204, resposta.getStatusCodeValue(), "O status neste caso deverá ser" +
                " o no-content - "+204);

        assertNull(resposta.getBody(), "Conhecimento não cadastrado deverá vir sem corpo");

    }
}