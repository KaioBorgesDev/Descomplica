package com.example.springcrud.controller;

import com.example.springcrud.dtos.UsersRecordsDTO;
import com.example.springcrud.models.UserModel;
import com.example.springcrud.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;

    @PostMapping("/users")
    public ResponseEntity<UserModel> saveUser(@RequestBody @Valid UsersRecordsDTO usersRecordsDTO) {
        var userModel = new UserModel();
        BeanUtils.copyProperties(usersRecordsDTO, userModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(userRepository.save(userModel));
    }

    @GetMapping("/users")
        public ResponseEntity<List<UserModel>> getAllUser(){
            List<UserModel> userModelList = userRepository.findAll();
            if (!userModelList.isEmpty()){
                for(UserModel userModelModel : userModelList){
                    UUID id = userModelModel.getIdUser();

                    userModelModel.add(linkTo(methodOn(UserController.class).getOneUser(id)).withSelfRel());
                }
            }
            return ResponseEntity.status(HttpStatus.OK).body(userModelList);
        }


        @GetMapping("/users/{id}")
        public ResponseEntity<Object> getOneUser(@PathVariable(value = "id") UUID id){
            Optional<UserModel> user0 = userRepository.findById(id);
            if (user0.isEmpty()){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
            }

            user0.get().add(linkTo(methodOn(UserController.class).getAllUser()).withSelfRel());
            return ResponseEntity.status(HttpStatus.OK).body(user0.get());
        }

    @PutMapping("/users/{id}")
    public ResponseEntity<Object> updateUser(@PathVariable(value = "id") UUID id, @RequestBody @Valid UsersRecordsDTO usersRecordsDTO) {
        Optional<UserModel> userModel = userRepository.findById(id);
        if (userModel.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
        }
        var userModel1 = userModel.get();
        BeanUtils.copyProperties(usersRecordsDTO, userModel1);
        return ResponseEntity.status(HttpStatus.OK).body(userRepository.save(userModel1));
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable(value = "id") UUID id){
        Optional<UserModel> userModel1 = userRepository.findById(id);
        if (userModel1.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
        userRepository.delete(userModel1.get());

        return ResponseEntity.status(HttpStatus.OK).body("User deleted sucessfully.");
    }


}
