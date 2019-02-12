package com.example.demo;

import com.example.demo.DataInitialize.AdDTO;
import com.example.demo.DataInitialize.PictureDTO;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class AdminService {

    public List<com.example.demo.Domain.AdDTO> getAllAdScore() {
        Map<Integer, AdDTO> adDTOSet = DataInitializer.getAdDTOMap();
        Map<Integer, PictureDTO> pictureDTOSet = DataInitializer.getPictureDTOMap();
        List<com.example.demo.Domain.AdDTO> list = getAllAdScore(adDTOSet, pictureDTOSet);
        Collections.sort(list);
        Collections.reverse(list);
        return list;
    }

    private List<com.example.demo.Domain.AdDTO> getAllAdScore(Map<Integer, AdDTO> adDTOMap, Map<Integer, PictureDTO> pictureDTOMap) {
        List<com.example.demo.Domain.AdDTO> adDTODomainList = new ArrayList<>();

        adDTOMap.values().forEach(adDTO -> adDTODomainList.add(getAdDTODomain(adDTO, pictureDTOMap)));
        return adDTODomainList;
    }

    private com.example.demo.Domain.AdDTO getAdDTODomain(AdDTO adDTO, Map<Integer, PictureDTO> pictureDTOSet) {
        return new com.example.demo.Domain.AdDTO(adDTO, pictureDTOSet);
    }

    public List<com.example.demo.Domain.AdDTO> getAdminAds() {
        return getAllAdScore().stream().filter(com.example.demo.Domain.AdDTO::isRelevant).collect(Collectors.toList());
    }
}
