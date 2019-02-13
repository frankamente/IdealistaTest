package com.example.demo;

import java.util.List;

import com.example.demo.Domain.AdDTO;

import static org.assertj.core.api.Assertions.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Test
    public void whenGetAllAdScoreThenAdWithId1ShouldHaveScoreNegative5() {
        List<AdDTO> adDTOs = new AdminService().getAllAdScore();
        AdDTO adDTO = getAdDTOById(adDTOs, 1);
        assertThat(adDTO.getScore()).isEqualTo(-5);
    }

    @Test
    public void whenGetAllAdScoreThenAdWithId2ShouldHaveScore35() {
        List<AdDTO> adDTOs = new AdminService().getAllAdScore();
        AdDTO adDTO = getAdDTOById(adDTOs, 2);
        assertThat(adDTO.getScore()).isEqualTo(35);
    }

    @Test
    public void whenGetAllAdScoreThenAdWithId3ShouldHaveScore20() {
        List<AdDTO> adDTOs = new AdminService().getAllAdScore();
        AdDTO adDTO = getAdDTOById(adDTOs, 3);
        assertThat(adDTO.getScore()).isEqualTo(20);
    }

    @Test
    public void whenGetAllAdScoreThenAdWithId4ShouldHaveScore70() {
        List<AdDTO> adDTOs = new AdminService().getAllAdScore();
        AdDTO adDTO = getAdDTOById(adDTOs, 4);
        assertThat(adDTO.getScore()).isEqualTo(70);
    }

    @Test
    public void whenGetAllAdScoreThenAdWithId5ShouldHaveScore35() {
        List<AdDTO> adDTOs = new AdminService().getAllAdScore();
        AdDTO adDTO = getAdDTOById(adDTOs, 5);
        assertThat(adDTO.getScore()).isEqualTo(35);
    }

    @Test
    public void whenGetAllAdScoreThenAdWithId6ShouldHaveScore50() {
        List<AdDTO> adDTOs = new AdminService().getAllAdScore();
        AdDTO adDTO = getAdDTOById(adDTOs, 6);
        assertThat(adDTO.getScore()).isEqualTo(50);
    }

    @Test
    public void whenGetAllAdScoreThenAdWithId7ShouldHaveScoreNegative5() {
        List<AdDTO> adDTOs = new AdminService().getAllAdScore();
        AdDTO adDTO = getAdDTOById(adDTOs, 7);
        assertThat(adDTO.getScore()).isEqualTo(-5);
    }

    @Test
    public void whenGetAllAdScoreThenAdWithId8ShouldHaveScore75() {
        List<AdDTO> adDTOs = new AdminService().getAllAdScore();
        AdDTO adDTO = getAdDTOById(adDTOs, 8);
        assertThat(adDTO.getScore()).isEqualTo(75);
    }

    private AdDTO getAdDTOById(List<AdDTO> adDTOs, int id) {
        return adDTOs.stream().filter(adDTO -> adDTO.getId() == id).findFirst().get();
    }

}
