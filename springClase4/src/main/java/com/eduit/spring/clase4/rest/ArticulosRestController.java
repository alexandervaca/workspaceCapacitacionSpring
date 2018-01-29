package com.eduit.spring.clase4.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.eduit.spring.clase4.dto.ArticuloCantidadDTO;
import com.eduit.spring.clase4.model.Articulo;
import com.eduit.spring.clase4.service.ArticuloService;


@RestController
@RequestMapping("/service")
public class ArticulosRestController {

    @Autowired
    private ArticuloService articuloService;

    @RequestMapping(value="/articulo/all" , method = RequestMethod.GET,headers = "Accept=application/json")
    public @ResponseBody List<Articulo> getAll(){
       return articuloService.listarArticulos();
    }

    @RequestMapping(value="/articulo/{id}" , method = RequestMethod.GET,headers = "Accept=application/json")
    public @ResponseBody  Articulo byId(@PathVariable("id")Long id){
        return articuloService.obtenerPorId(id);
    }
    
    @RequestMapping(value="/articulo/getby" , method = RequestMethod.GET,headers = "Accept=application/json")
    public @ResponseBody  Articulo byParams(@RequestParam Integer cantidad,@RequestParam Float precio,@RequestParam String presentacion){
        
    	return articuloService.obtenerPorParametros(cantidad,precio,presentacion);
    }


    @RequestMapping(value="/articulo/insert" , method = RequestMethod.PUT,headers = "Accept=application/json")
    public  @ResponseBody  Articulo  save(@RequestBody Articulo articulo){
      return articuloService.salvarArticulo(articulo);
    }

    @RequestMapping(value="/articulo/delete/{id}" , method = RequestMethod.DELETE,headers = "Accept=application/json")
    public ResponseEntity<?> delete (@PathVariable("id")Long id){
         Articulo articulo = new Articulo();
         articulo.setId(id);
         articuloService.borrarArticulo(articulo);
         return new ResponseEntity<String>("OK", HttpStatus.OK);
    }


    @RequestMapping(value="/articulo/update" , method = RequestMethod.POST,headers = "Accept=application/json")
    public  @ResponseBody   ResponseEntity<?>  update(@RequestBody Articulo articulo){
        if(!articuloService.exists(articulo)){
           return new ResponseEntity<String>("Articulo " + articulo.getId() + " not found",HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Articulo>(articuloService.modificarArticulo(articulo),HttpStatus.OK);
    }

    
    @RequestMapping(value="/articulo/update/cantidad" , method = RequestMethod.POST,headers = "Accept=application/json")
    public  @ResponseBody   ResponseEntity<?>  updateCantidad(@RequestBody ArticuloCantidadDTO articuloCantidadDTO){
    	Articulo articulo= new Articulo();
    	articulo.setId(articuloCantidadDTO.getId());
    	articulo.setCantidad(articuloCantidadDTO.getCantidad());
        if(!articuloService.exists(articulo)){
           return new ResponseEntity<String>("Articulo " + articulo.getId() + " not found",HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Articulo>(articuloService.modificarArticuloCantidad(articulo),HttpStatus.OK);
    }



}
