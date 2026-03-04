package com.mascarello.milagre.services;

import com.mascarello.milagre.models.MilagreModel;
import com.mascarello.milagre.repositories.MilagreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/milagres")
public class MilagreService {
    @Autowired
    private MilagreRepository milagreRepository;
    //get
    //post
    //delete
    @GetMapping
    public List<MilagreModel> milagreModelList(){
        return milagreRepository.findAll();
    }
    @PostMapping
    public MilagreModel criar(@RequestBody MilagreModel milagreModel){
        return milagreRepository.save(milagreModel);
    }
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        milagreRepository.deleteById(id);
    }
    @PutMapping("/{id}")
    public MilagreModel atualizar(@PathVariable Long id, @RequestBody MilagreModel milagreModel){
        MilagreModel newMilagre = milagreRepository.findById(id).get();

        newMilagre.setNome(milagreModel.getNome());

        return milagreRepository.save(newMilagre);
    }

}
