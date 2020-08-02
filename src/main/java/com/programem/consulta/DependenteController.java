package com.programem.consulta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/dependente")
public class DependenteController {

    @Autowired
    private DependenteRepository dependenteRepository;
    private Lista lista = new Lista();

    @GetMapping("/")
    public String dependenteForm(){
      return "dependenteForm";
    }

    @PostMapping(path="/insere") // Map ONLY POST Requests
    public @ResponseBody String addNewDependente (
         @RequestParam String nome
        ,@RequestParam Integer idade
        
        ) {

            Dependente d = new Dependente();

            d.setNome(nome);
            d.setIdade(idade);
           

            dependenteRepository.save(d);

            return nome+" "+idade+" ";
    }

    @GetMapping(path="/lista")
    public @ResponseBody String getAllDependente() {

      Iterable<Dependente> resultado = dependenteRepository.findAll();
      
      return lista.listaDependente(resultado);
    }

    @GetMapping(path="/filtroForm")
    public String filtroForm(){
      return "filtroForm";
    }

    @GetMapping(path="/filtro")
    public @ResponseBody String getDependente(@RequestParam Integer idade) {

      Iterable<Dependente> resultado = dependenteRepository.findIdadeDependente(idade);
      
      return lista.listaDependente(resultado);
    }

}