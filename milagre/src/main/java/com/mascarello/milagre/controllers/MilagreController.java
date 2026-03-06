package com.mascarello.milagre.controllers;

import com.mascarello.milagre.models.MilagreModel;
import com.mascarello.milagre.services.MilagreService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/milagres")
public class MilagreController {

    private MilagreService milagreService;

    @DeleteMapping("/{id}")
    public void excluirMilagre(@PathVariable Long id){
        milagreService.excluirMilagre(id);

    }
    @PostMapping
    public MilagreModel criarMilagre(@RequestBody MilagreModel milagreModel){
        return milagreService.criarMilagre(milagreModel);
    }
    @GetMapping
    public List<MilagreModel> buscarTodosMilagres(){
        return milagreService.buscarTodosMilagres();
    }
    @PutMapping("/{id}")
    public MilagreModel atualizarMilagre(@PathVariable Long id, @RequestBody MilagreModel milagreModel){
        return milagreService.atualizarMilagre(id, milagreModel);
    }


}