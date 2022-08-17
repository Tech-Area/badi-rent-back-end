package com.techarea.badirent.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.techarea.badirent.dto.CarDto;
import com.techarea.badirent.dto.MotoDto;
import com.techarea.badirent.mapper.CarMapper;
import com.techarea.badirent.mapper.MotoMapper;
import com.techarea.badirent.repository.MotoRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class MotoService {

    private final MotoRepository motoRepository;

    public MotoService(MotoRepository motoRepository) {
        this.motoRepository = motoRepository;
    }

    public List<MotoDto> getAll() {
        return motoRepository.findAll().stream().map(MotoMapper::map).collect(toList());
    }

    public MotoDto save(String motoDto, MultipartFile imageFile) throws IOException {
        MotoDto jsonFromString = getJson(motoDto);
        byte[] motoImage = imageFile.getBytes();
        jsonFromString.setMotoImage(motoImage);
        return MotoMapper.map(motoRepository.save(MotoMapper.map(jsonFromString)));
    }

    private MotoDto getJson(String motoDto) {
        MotoDto jsonFromString = new MotoDto();
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            jsonFromString = objectMapper.readValue(motoDto, MotoDto.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return jsonFromString;
    }

    public MotoDto getById(Long id) {
        return MotoMapper.map(motoRepository.getReferenceById(id));
    }
}
