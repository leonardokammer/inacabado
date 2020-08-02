package com.programem.consulta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;
    private Lista lista = new Lista();

    @GetMapping("/")
    public String clienteForm(){
      return "clienteForm";
    }

    @PostMapping(path="/insere") // Map ONLY POST Requests
    public @ResponseBody String addNewCliente (
         @RequestParam String nome
        ,@RequestParam Integer idade
        ,@RequestParam String endereco
        ) {

            Cliente c = new Cliente();

            c.setNome(nome);
            c.setIdade(idade);
            c.setEndereco(endereco);

            clienteRepository.save(c);

            return nome+" "+idade+" "+endereco;
    }

    @GetMapping(path="/lista")
    public @ResponseBody String getAllCliente() {

      Iterable<Cliente> resultado = clienteRepository.findAll();
      
      return lista.listaCliente(resultado);
    }

    @GetMapping(path="/filtroForm")
    public String filtroForm(){
      return "filtroForm";
    }

    @GetMapping(path="/filtro")
    public @ResponseBody String getCliente(@RequestParam Integer idade) {

      Iterable<Cliente> resultado = clienteRepository.findIdadeCliente(idade);
      
      return lista.listaCliente(resultado);
    }

}