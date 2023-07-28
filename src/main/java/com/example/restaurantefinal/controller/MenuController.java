package com.example.restaurantefinal.controller;

import com.example.restaurantefinal.dto.MenuDto;
import com.example.restaurantefinal.dto.MenuErrorDto;
import com.example.restaurantefinal.entities.Menu;
import com.example.restaurantefinal.services.MenuServicie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("restauranteAPI/menu")
public class MenuController {

    @Autowired
    MenuServicie menuServicie;

    @PostMapping
    public ResponseEntity<MenuDto> menuDtoResponseEntity(@RequestBody Menu menuToRegister){
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(menuServicie.createmenu(menuToRegister));

        }catch (Exception Error){
            MenuErrorDto responseError= new MenuErrorDto();
            responseError.setErrorMessage(Error.getMessage());
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(responseError);

        }

    }

}
