package com.ICM.GestionCamiones.Controllers;

import com.ICM.GestionCamiones.Models.ReparacionesModel;
import com.ICM.GestionCamiones.Service.ReparacionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/reparaciones")
public class ReparacionesController {
    @Autowired
    ReparacionesService reparacionesService;

    @GetMapping
    public List<ReparacionesModel> GetAllC(){
        return reparacionesService.GetAllS();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReparacionesModel>  GetByIdC(@PathVariable Long id){
        Optional<ReparacionesModel> reparaciones = reparacionesService.GetByIdS(id);
        return new ResponseEntity<>(reparaciones.get(), HttpStatus.OK);
    }

    @GetMapping("/xrgs/{rgs}")
    public ResponseEntity<List<ReparacionesModel>> VerxRGS(@PathVariable Long rgs){
        List<ReparacionesModel> reparaciones = reparacionesService.VerxRGS(rgs);
        if (!reparaciones.isEmpty()) {
            return new ResponseEntity<>(reparaciones, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<ReparacionesModel> SaveC (@RequestBody ReparacionesModel reparacionesModel){
        ReparacionesModel creparaciones = reparacionesService.SaveS(reparacionesModel);
        return new ResponseEntity<>(creparaciones, HttpStatus.OK);
    }


}
