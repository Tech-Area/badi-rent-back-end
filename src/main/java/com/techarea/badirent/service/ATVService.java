package com.techarea.badirent.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.techarea.badirent.dto.ATVDto;
import com.techarea.badirent.mapper.AtvMapper;
import com.techarea.badirent.repository.ATVRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class ATVService {
    private final ATVRepository atvRepository;

    public ATVService(ATVRepository atvRepository) {
        this.atvRepository = atvRepository;
    }

    public List<ATVDto> getAll() {
        return atvRepository.findAll().stream().map(AtvMapper::map).collect(toList());
    }

    public ATVDto save(String atvDto, MultipartFile imageFile) throws IOException {
        ATVDto jsonFromString = getJson(atvDto);
        byte[] atvImage = imageFile.getBytes();
        jsonFromString.setAtvImage(atvImage);
        return AtvMapper.map(atvRepository.save(AtvMapper.map(jsonFromString)));
    }

    private ATVDto getJson(String atvDto) {
        ATVDto jsonFromString = new ATVDto();
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            jsonFromString = objectMapper.readValue(atvDto, ATVDto.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return jsonFromString;
    }
}
