package com.wss.assignment.restserver;

import com.wss.assignment.models.Users;
import com.wss.assignment.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RestUser {
    private final String url = "/api/user";
    private final UserService userService;

    public RestUser(@Autowired UserService userService){
        this.userService = userService;
    }

    @GetMapping("/ping")
    public String index() {
        return "pong";
    }

    @GetMapping(url + "/list")
    public ResponseEntity<Object> getUsers(){
        try {
            return ResponseHandler.generateResponse(HttpStatus.OK, "success", userService.getUsers());
        } catch (Exception ex){
            return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), null);
        }
    }

    @PostMapping(url + "/search-by-identity-number")
    public ResponseEntity<Object> findByIdentityNumber(@RequestBody Users users){
        try {
            return ResponseHandler.generateResponse(HttpStatus.OK, "success", userService.findByIdentityNumber(users.getIdentityNumber()));
        } catch (Exception ex) {
            return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), null);
        }
    }

    @PostMapping(url + "/save")
    public ResponseEntity<Object> saveUser(@RequestBody Users users) {
        try {
            this.userService.save(users);
            return ResponseHandler.generateResponse(HttpStatus.CREATED, "Saving", null);
        } catch (Exception ex) {
            return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), null);
        }
    }

    @PutMapping(url + "/update")
    public ResponseEntity<Object> updateUser(@RequestBody Users users) {
        try {
//            this.userService.save(users);
            Users user = userService.findById(users.getId());
            user.setName((users.getName() != null) ? users.getName() : user.getName());
            user.setAddress((users.getAddress() != null) ? users.getAddress() : user.getAddress());
            user.setBirthdate((users.getBirthdate() != null) ? users.getBirthdate() : user.getBirthdate());
            user.setBirthplace((users.getBirthplace() != null) ? users.getBirthplace() : user.getBirthplace());
            user.setPhone((users.getPhone() != null) ? users.getPhone() : user.getPhone());
            userService.save(user);

            return ResponseHandler.generateResponse(HttpStatus.OK, "updated", null);
        } catch (Exception ex) {
            return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "error", null);
        }
    }

    @DeleteMapping(url + "/delete/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable int id) {
        try {
            this.userService.delete(id);
            return ResponseHandler.generateResponse(HttpStatus.OK, "deleted", null);
        } catch (Exception ex) {
            return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), null);
        }
    }


}
