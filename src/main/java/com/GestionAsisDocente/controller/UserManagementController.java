package com.GestionAsisDocente.controller;

import com.GestionAsisDocente.dto.ReqRes;
import com.GestionAsisDocente.dto.UserProfileMovil;
import com.GestionAsisDocente.entity.OurUsers;
import com.GestionAsisDocente.service.UsersManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserManagementController {
    @Autowired
    private UsersManagementService usersManagementService;




    @GetMapping("/admin/get-all-users")
    public ResponseEntity<ReqRes> getAllUsers(){
        return ResponseEntity.ok(usersManagementService.getAllUsers());

    }

    @GetMapping("/admin/get-all-usersV2")
    public ResponseEntity<List<OurUsers>> getAllUsersV2() {
        List<OurUsers> User = usersManagementService.getAllUsersV2();
        return ResponseEntity.ok(User);
    }

    @GetMapping("/admin/get-users/{userId}")
    public ResponseEntity<ReqRes> getUSerByID(@PathVariable Integer userId){
        return ResponseEntity.ok(usersManagementService.getUsersById(userId));

    }

    @PutMapping("/admin/update/{userId}")
    public ResponseEntity<ReqRes> updateUser(@PathVariable Integer userId, @RequestBody OurUsers reqres){
        return ResponseEntity.ok(usersManagementService.updateUser(userId, reqres));
    }

    @GetMapping("/adminuser/get-profile")
    public ResponseEntity<ReqRes> getMyProfile(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();

        ReqRes response = usersManagementService.getMyInfo(email);
        return  ResponseEntity.status(response.getStatusCode()).body(response);
    }

    @GetMapping("/adminuser/get-userToken")
    public ResponseEntity<UserProfileMovil> getUserToken() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();

        ReqRes response = usersManagementService.getMyInfo(email);
        OurUsers user = response.getOurUsers();

        UserProfileMovil userProfileDto = new UserProfileMovil();
        userProfileDto.setId(user.getId());
        userProfileDto.setEmail(user.getEmail());
        userProfileDto.setName(user.getName());
        userProfileDto.setPassword(user.getPassword());
        userProfileDto.setRole(user.getRole());

        return ResponseEntity.ok(userProfileDto);
    }

    @DeleteMapping("/admin/delete/{userId}")
    public ResponseEntity<ReqRes> deleteUSer(@PathVariable Integer userId){
        return ResponseEntity.ok(usersManagementService.deleteUser(userId));
    }


}