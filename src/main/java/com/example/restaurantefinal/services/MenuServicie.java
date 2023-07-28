package com.example.restaurantefinal.services;


import com.example.restaurantefinal.dto.MenuResponseDto;
import com.example.restaurantefinal.entities.Menu;
import com.example.restaurantefinal.maps.MenuMap;
import com.example.restaurantefinal.repositories.MenuRepository;
import com.example.restaurantefinal.validations.Menuvalidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MenuServicie  {

    @Autowired //inyeccion
    Menuvalidation validation;
    @Autowired
    MenuRepository repository;
    @Autowired
    MenuMap menumap;

    public MenuResponseDto createmenu(Menu menuToRegister) throws Exception{
        try {
            if (!menuToRegister.getRole().equals('A')){
                throw new Exception("Rol no autorizado para crear el plato");

            }
            if (validation.validationprice(menuToRegister.getPrice())){
                throw new Exception("El precio es invalido.");
            }

            if (validation.validationcampus(menuToRegister.getCampus())){
                throw new Exception("La sede es obligatoria");
            }

            return menumap.transformationMenu(repository.save(menuToRegister));

        }catch (Exception error){
          throw  new Exception(error.getMessage());
        }

        }

    public MenuResponseDto updatestatus(Menu editmenu, Integer idMenuEdit) throws Exception{

        try {
            //VALIDACION GENERAL
            if (!editmenu.getRole().equals('A')){
                throw new Exception("Rol no autorizado para actualizar el plato");
            }
            //BUSCAR SI ELPALTO QUE ENVIA EXISTE
            Optional<Menu> menuOpcional=repository.findById(idMenuEdit);
            if (!menuOpcional.isPresent()){
                throw new Exception("El plato no existe");

            }
            //EL PALTO SI ESTA, OBTENER LAINFO DEL PLATO

            Menu menuFound=menuOpcional.get();

            //Actualizar estado
            //set campo que quiere actualizar
            menuFound.setState(editmenu.getState());
            //guardamos cambios bd
            Menu menuUpdate=repository.save(menuFound);


            //transformo el plato en DTO
             return menumap.transformationMenu(menuUpdate);


        }catch (Exception error){
            throw  new Exception(error.getMessage());

        }
    }
    public Page<MenuResponseDto> categoriesMenuAndCampus(String categories, String campues, int registerNumber) throws Exception{
        try {
            //crear objeto de spring para paginar
            //el numero de paginas y de registros por paginas
            Pageable pager= PageRequest.of(0, registerNumber);

            Page<Menu> menuPagerfind=repository.findByCategoriesAndCampus(categories,campues,pager);

            return menuPagerfind.map(menu -> menumap.transformationMenu(menu));

        }catch (Exception error){
        throw  new Exception(error.getMessage());
        }
    }


}
