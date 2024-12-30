package org.example.controller;


import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.example.dto.TipNotifikacijeDto;
import org.example.dto.TipPorukeDto;
import org.example.security.CheckSecurity;
import org.example.service.NotifikacijaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notifikacije")
public class AdminController {

    private NotifikacijaService notifikacijaService;

    public AdminController(NotifikacijaService notifikacijaService) {
        this.notifikacijaService = notifikacijaService;
    }

    @ApiOperation(value = "Get all users")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "What page number you want", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "tipNotifikacije", value = "Which notification do you want", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "email", value = "Which email do you want", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "year", value = "Which year do you want", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "size", value = "Number of items to return", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "sort", allowMultiple = true, dataType = "string", paramType = "query",
                    value = "Sorting criteria in the format: property(,asc|desc). " +
                            "Default sort order is ascending. " +
                            "Multiple sort criteria are supported.")})
    @GetMapping("/admin")
    @CheckSecurity(permissions = {1,2,3,4})
    public ResponseEntity<Page<TipPorukeDto>> getAllNotifikacionsForAdmin(@RequestHeader("Authorization") String authorization,
                                                          Pageable pageable) {

        return new ResponseEntity<>(notifikacijaService.findAllAdmin(pageable), HttpStatus.OK);
    }

    @PostMapping("/admin/addTipNotifikacije")
    @CheckSecurity(permissions = {1,2,3,4})
    public ResponseEntity<TipNotifikacijeDto> addTipNotifikacije(@RequestHeader("Authorization") String authorization, @RequestBody TipNotifikacijeDto tipNotifikacijeDto) {

        return new ResponseEntity<>(notifikacijaService.addNewNotification(tipNotifikacijeDto), HttpStatus.OK);
    }

    @DeleteMapping("/admin/deleteTipNotifikacije/{id}")
    @CheckSecurity(permissions = {1,2,3,4})
    public ResponseEntity<?> deleteTipNotifikacije(@RequestHeader("Authorization") String authorization, @PathVariable("id") Long id) {
        notifikacijaService.deleteNotification(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping("/user/{id}")
    @CheckSecurity(permissions = {1})
    public ResponseEntity<List<TipPorukeDto>> getAllNotifikacionsForUser(@RequestHeader("Authorization") String authorization, @PathVariable("id") Long id) {

        return new ResponseEntity<>(notifikacijaService.findAllUser(id, authorization), HttpStatus.OK);
    }


    @GetMapping("/menadzer/{id}")
    @CheckSecurity(permissions = {1,2})
    public ResponseEntity<List<TipPorukeDto>> getAllNotifikacionsForMenadzer(@RequestHeader("Authorization") String authorization, @PathVariable("id") Long id) {

        return new ResponseEntity<>(notifikacijaService.findAllMenadzer(id, authorization), HttpStatus.OK);
    }

}
