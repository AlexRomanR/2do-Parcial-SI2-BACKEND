package com.GestionAsisDocente.service;

import com.GestionAsisDocente.dto.AulasRequest;
import com.GestionAsisDocente.entity.Aulas;
import com.GestionAsisDocente.entity.Modulos;
import com.GestionAsisDocente.repository.AulasRepository;
import com.GestionAsisDocente.repository.ModulosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AulasService {

    @Autowired
    private AulasRepository aulasRepository;

    @Autowired
    private ModulosRepository modulosRepository;

    public List<Aulas> getAllAulas() {
        return aulasRepository.findAll();
    }

    public Aulas createAula(AulasRequest aulaRequest) {
        Modulos modulo = modulosRepository.findById(aulaRequest.getModulo_id())
                .orElseThrow(() -> new RuntimeException("Modulo not found with id " + aulaRequest.getModulo_id()));

        Aulas aula = new Aulas();
        aula.setNumero(aulaRequest.getNumero());
        aula.setPiso(aulaRequest.getPiso());
        aula.setCapacidad(aulaRequest.getCapacidad());
        aula.setDescripcion(aulaRequest.getDescripcion());
        aula.setModulos(modulo);

        return aulasRepository.save(aula);
    }

    public Aulas updateAula(Integer id, AulasRequest aulaRequest) {
        Aulas aula = aulasRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aula not found with id " + id));

        Modulos modulo = modulosRepository.findById(aulaRequest.getModulo_id())
                .orElseThrow(() -> new RuntimeException("Modulo not found with id " + aulaRequest.getModulo_id()));

        aula.setNumero(aulaRequest.getNumero());
        aula.setPiso(aulaRequest.getPiso());
        aula.setCapacidad(aulaRequest.getCapacidad());
        aula.setDescripcion(aulaRequest.getDescripcion());
        aula.setModulos(modulo);

        return aulasRepository.save(aula);
    }

    public void deleteAula(Integer id) {
        Aulas aula = aulasRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aula not found with id " + id));
        aulasRepository.delete(aula);
    }

    public Aulas getAulaById(Integer id) {
        return aulasRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aula not found with id " + id));
    }
}
