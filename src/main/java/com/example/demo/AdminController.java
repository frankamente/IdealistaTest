package com.example.demo;

import com.example.demo.Domain.AdDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("admin")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService){

        this.adminService = adminService;
    }

    @GetMapping("/getAllAdScore")
    public List<AdDTO> getAllAdScore() {
        return adminService.getAllAdScore();
    }

    @GetMapping("/getAdminAds")
    public List<AdDTO> getAdminAds() {
        return adminService.getAdminAds();
    }
}
