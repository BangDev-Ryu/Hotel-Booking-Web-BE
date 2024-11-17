package com.hotelmanagement.springHotel.controller;

import com.hotelmanagement.springHotel.model.NoiThat;
import com.hotelmanagement.springHotel.service.NoiThatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/noi-that")
@CrossOrigin
public class NoiThatController {

    @Autowired
    private NoiThatService noiThatService;

    @GetMapping
    public List<NoiThat> getAllNoiThat() {
        return noiThatService.getAllNoiThat();
    }

    @GetMapping("/{id}")
    public ResponseEntity<NoiThat> getNoiThatById(@PathVariable Long id) {
        return noiThatService.getNoiThatById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public NoiThat createNoiThat(@RequestBody NoiThat noiThat) {
        return noiThatService.saveNoiThat(noiThat);
    }

    @PutMapping("/{id}")
    public ResponseEntity<NoiThat> updateNoiThat(@PathVariable Long id, @RequestBody NoiThat noiThat) {
        return noiThatService.getNoiThatById(id)
                .map(existingNoiThat -> {
                    noiThat.setId(id);
                    return ResponseEntity.ok(noiThatService.saveNoiThat(noiThat));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteNoiThat(@PathVariable Long id) {
        return noiThatService.getNoiThatById(id)
                .map(noiThat -> {
                    noiThatService.deleteNoiThat(id);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
