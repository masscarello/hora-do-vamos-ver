package com.mascarello.milagre.controllers;

import com.mascarello.milagre.models.MilagreModel;
import com.mascarello.milagre.services.MilagreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/milagres")
public class MilagreController {
    @Autowired
    private MilagreService milagreService;

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar (@PathVariable Long id){
        milagreService.excluirMilagre(id);
        return ResponseEntity.noContent().build();

    }
    @PostMapping
    public ResponseEntity<MilagreModel> criarMilagre(@RequestBody MilagreModel milagreModel){
        MilagreModel requeste = milagreService.criarMilagre(milagreModel);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(milagreModel.getId())
                .toUri();
        return ResponseEntity.created(uri).body(requeste);

    }
    @GetMapping
    public ResponseEntity<List<MilagreModel>> buscarTodosMilagres(){
        List<MilagreModel> requeste = milagreService.buscarTodosMilagres();
        return ResponseEntity.ok().body(requeste);
    }
    @PutMapping("/{id}")
    public ResponseEntity<MilagreModel> atualizarMilagre(@PathVariable Long id, @RequestBody MilagreModel milagreModel){
        MilagreModel requeste = milagreService.atualizarMilagre(id, milagreModel);
        return ResponseEntity.ok().body(requeste);
    }


}