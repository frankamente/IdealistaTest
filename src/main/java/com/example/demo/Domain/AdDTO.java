package com.example.demo.Domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.*;

public class AdDTO  implements Comparable{
    private int id;
    private AdDescription adDescription;
    private AdTypology adTypology;
    private int houseSize;
    private int gardenSize;
    private int score;
    private Set<PictureDTO> pictureSet;
    private final int RELEVANT_MINIMUM_SCORE = 40;

    public AdDTO() {
    }

    public AdDTO(com.example.demo.DataInitialize.AdDTO adDTO, Map<Integer, com.example.demo.DataInitialize.PictureDTO> pictureDTOMap) {
        initializeBasicInformation(adDTO);
        pictureSet = new HashSet<>();
        for (int i = 0; i < adDTO.getPictures().length; i++) {
            int actualPictureId = adDTO.getPictures()[i];
            if (pictureDTOMap.containsKey(actualPictureId)) {
                pictureSet.add(parse(pictureDTOMap.get(actualPictureId)));
            }
        }
        initializeScore();
    }

    private void initializeScore() {
        List<ScoreFilter> scoreFilters = new ArrayList<>();
        scoreFilters.add(new NoPictureScoreFilter());
        scoreFilters.add(new PictureQualityScoreFilter());
        scoreFilters.add(new HasDescriptionScoreFilter());
        scoreFilters.add(new DescriptionSizeScoreFilter());
        scoreFilters.add(new SpecificWordsScoreFilter());
        scoreFilters.add(new CompletedAdScoreFilter());
        scoreFilters.forEach(scoreFilter -> score += scoreFilter.getFilterScore(this));
    }

    private PictureDTO parse(com.example.demo.DataInitialize.PictureDTO pictureDTO) {
        return new PictureDTO(pictureDTO);
    }

    private void initializeBasicInformation(com.example.demo.DataInitialize.AdDTO adDTO) {
        this.id = adDTO.getId();
        this.adDescription = getAdDescription(adDTO.getDescription());
        this.adTypology = getAdTypology(adDTO.getTypology());
        this.houseSize = adDTO.getHouseSize();
        this.gardenSize = adDTO.getGardenSize();
    }

    private AdDescription getAdDescription(String description) {
        return new AdDescription(description);
    }

    private AdTypology getAdTypology(String typology) {
        AdTypologyEnum adTypologyEnum = AdTypologyEnum.getEnumFromString(typology);
        switch (adTypologyEnum) {
            case CHALET:
                return new AdTypology(adTypologyEnum, new ChaletTypologyScoreBehaviour());
            case FLAT:
                return new AdTypology(adTypologyEnum, new FlatTypologyScoreBehaviour());
            case GARAGE:
                return new AdTypology(adTypologyEnum, new NoTypologyScoreBehaviour());
        }
        return new AdTypology(adTypologyEnum, new NoTypologyScoreBehaviour());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdDTO adDTO = (AdDTO) o;
        return id == adDTO.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public AdDescription getAdDescription() {
        return adDescription;
    }

    public void setAdDescription(AdDescription adDescription) {
        this.adDescription = adDescription;
    }

    public AdTypology getAdTypology() {
        return adTypology;
    }

    public void setAdTypology(AdTypology adTypology) {
        this.adTypology = adTypology;
    }

    public int getHouseSize() {
        return houseSize;
    }

    public void setHouseSize(int houseSize) {
        this.houseSize = houseSize;
    }

    public int getGardenSize() {
        return gardenSize;
    }

    public void setGardenSize(int gardenSize) {
        this.gardenSize = gardenSize;
    }

    public Set<PictureDTO> getPictureSet() {
        return pictureSet;
    }

    public void setPictureSet(Set<PictureDTO> pictureSet) {
        this.pictureSet = pictureSet;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    boolean isComplete() {
        if (!hasDescription() && !isGarage()) {
            return false;
        }
        if (!hasAnyPicture()) {
            return false;
        }
        if (isFlat() && !hasHouseSize()) {
            return false;
        }
        if (isChalet() && (!hasHouseSize() || !hasGardenSize())) {
            return false;
        }
        return true;
    }

    private boolean hasAnyPicture() {
        return !pictureSet.isEmpty();
    }

    private boolean hasDescription() {
        return getAdDescription().hasValue();
    }

    private boolean hasHouseSize() {
        return houseSize > 0;
    }

    private boolean hasGardenSize() {
        return gardenSize > 0;
    }

    private boolean isGarage() {
        return getAdTypology().getAdTypologyEnum() == AdTypologyEnum.GARAGE;
    }

    private boolean isFlat() {
        return getAdTypology().getAdTypologyEnum() == AdTypologyEnum.FLAT;
    }

    private boolean isChalet() {
        return getAdTypology().getAdTypologyEnum() == AdTypologyEnum.CHALET;
    }

    @JsonIgnore
    public boolean isRelevant() {
        return getScore() > RELEVANT_MINIMUM_SCORE;
    }

    @Override
    public int compareTo(Object o) {
        return Integer.compare(getScore(), ((AdDTO)o).getScore());
    }
}
