package com.example.demo;

import com.example.demo.DataInitialize.AdDTO;
import com.example.demo.DataInitialize.PictureDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

class DataInitializer {
    static Map<Integer, AdDTO> getAdDTOMap() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            List<AdDTO> myObjects = objectMapper.readValue(new File("anuncios.js"), new TypeReference<List<AdDTO>>() {
            });
            return myObjects.stream().collect(Collectors.toMap(AdDTO::getId,
                    Function.identity()));
        } catch (IOException e) {
            return new HashMap<>();
        }
    }

    static Map<Integer, PictureDTO> getPictureDTOMap() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            List<PictureDTO> myObjects = objectMapper.readValue(new File("fotos.js"), new TypeReference<List<PictureDTO>>() {
            });
            return myObjects.stream().collect(Collectors.toMap(PictureDTO::getId,
                    Function.identity()));
        } catch (IOException e) {
            return new HashMap<>();
        }
    }
}
