package com.ICM.GestionCamiones.Security;

import com.ICM.GestionCamiones.Models.CamionesModel;
import com.ICM.GestionCamiones.Repositories.CamionesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CamionesService {
    @Autowired
    CamionesRepository camionesRepository;

    // CRUD

    public List<CamionesModel> ListarCamiones(){
        return camionesRepository.findAll();
    }

    public Optional<CamionesModel> ListarCamionId(Long id){
        return camionesRepository.findById(id);
    }

    public CamionesModel CrearCamion(CamionesModel camionesModel){
        return camionesRepository.save(camionesModel);
    }

    public CamionesModel EditarCamion(CamionesModel camionesModel, Long id){
        Optional<CamionesModel> existing = camionesRepository.findById(id);
        if(existing.isPresent()){
            CamionesModel camiones = existing.get();
            camiones.setPlaca(camionesModel.getPlaca());
            camiones.setTiposCModel(camionesModel.getTiposCModel());
            camiones.setMarcasModel(camionesModel.getMarcasModel());
            camiones.setModeloModel(camionesModel.getModeloModel());
            camiones.setSedesModel(camionesModel.getSedesModel());
            return camionesRepository.save(camiones);
        }
        return null;
    }

    public void EliminarCamion(Long id){
        camionesRepository.deleteById(id);
    }

}
