package com.example.pruebatecnica.app.rest.user;

import com.example.pruebatecnica.app.dao.dataModel.common.ErrorResponse;
import com.example.pruebatecnica.app.dao.dataModel.common.Response;
import com.example.pruebatecnica.app.dao.dataModel.user.UserRequest;
import com.example.pruebatecnica.app.dao.dataModel.user.UserSearchRequest;
import com.example.pruebatecnica.app.service.UserService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.io.Serializable;

@Api(value = "Usuario", tags = "Usuario")
@RequiredArgsConstructor
@RestController
public class UserControllerImpl implements UserController {

    private final UserService userService;

    @Override
    public ResponseEntity<Response<Serializable>> saveUser(@Valid UserRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new Response<>(userService.saveUser(request), new ErrorResponse()));
    }

    @Override
    public ResponseEntity<Response<Serializable>> searchUser(@Valid UserSearchRequest request) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(new Response<>(userService.searchUser(request), new ErrorResponse()));
    }

    @Override
    public ResponseEntity searchAllUser() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(userService.searchAllUser());
    }

}
