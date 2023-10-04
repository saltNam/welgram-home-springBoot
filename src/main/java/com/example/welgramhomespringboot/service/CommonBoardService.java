package com.example.welgramhomespringboot.service;

import com.example.welgramhomespringboot.controller.dto.request.GetBoardListDto;
import com.example.welgramhomespringboot.controller.dto.response.BoardListDto;
import com.example.welgramhomespringboot.repository.CommonBoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommonBoardService {

   private final CommonBoardRepository commonBoardRepository;

    public List<BoardListDto> getBoardList(GetBoardListDto getBoardListDto, String category){
        getBoardListDto.setCategory(category);
        return commonBoardRepository.getBoardList(getBoardListDto);
    }

    public Long getBoardListCount(GetBoardListDto getBoardListDto, String category) {
        getBoardListDto.setCategory(category);
        return commonBoardRepository.getBoardListCount(getBoardListDto);
    }




}
