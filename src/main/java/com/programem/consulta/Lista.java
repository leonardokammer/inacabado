package com.programem.consulta;

public class Lista {
    
    String listaCliente(Iterable<Cliente> lista){
        String html = "";

        for(Cliente c : lista){
            html = html +
            "<h1>"+c.getNome()+"</h1>"+
            c.getIdade()+"<br>"+
            c.getEndereco()+"<br>"+
            "<br>"
            ;
        }
        return html;
    }

    String listaDependente(Iterable<Dependente> lista){
        String html = "";

        for(Dependente d : lista){
            html = html +
            "<h1>"+d.getNome()+"</h1>"+
            d.getIdade()+"<br>";
        }
        return html;
    }
}