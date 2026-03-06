package com.mascarello.milagre.services;

import com.mascarello.milagre.models.MilagreModel;
import com.mascarello.milagre.repositories.MilagreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class MilagreService {
    @Autowired
    private MilagreRepository milagreRepository;

    public void excluirMilagre(@PathVariable Long id){
        milagreRepository.deleteById(id);

    }

    public MilagreModel criarMilagre(@RequestBody MilagreModel milagreModel){
        return milagreRepository.save(milagreModel);
    }

    public List<MilagreModel> buscarTodosMilagres(){
        return milagreRepository.findAll();
    }

    public MilagreModel atualizarMilagre(Long id, MilagreModel milagreModel){
        MilagreModel novo = milagreRepository.findById(id).get();
        novo.setNome(milagreModel.getNome());
        return milagreRepository.save(novo);
    }

}