package br.com.anthony.loja.Produtos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;


@RestController
public class ProdutosController {
    @Autowired
    ProdutosRepository pr;
    
    @GetMapping("/loja")
    public List <Produto> List(){
        return (List<Produto>) this.pr.findAll();
    }

    @PostMapping("/loja")
    public Produto create(@RequestBody Produto produto ) {
        return pr.save(produto);
    }
    
    
}
