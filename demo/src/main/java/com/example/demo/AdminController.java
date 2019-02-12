package com.example.demo;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController("admin")
public class AdminController {

    @GetMapping("/getAll")
    public List<Foto> getAll() throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        List<Foto> myObjects = objectMapper.readValue(new File("fotos.js"), new TypeReference<List<Foto>>(){});
        return myObjects;
    }
    @GetMapping("/getAllAnunciosAdmin")
    public List<Anuncio> getAllAnuncios() throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        List<Anuncio> myObjects = objectMapper.readValue(new File("anuncios.js"), new TypeReference<List<Anuncio>>(){});
        return myObjects;
    }
}
