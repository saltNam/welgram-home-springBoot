package com.example.welgramhomespringboot.repository.custom;

import com.example.welgramhomespringboot.controller.dto.request.GetBoardListDto;
import com.example.welgramhomespringboot.controller.dto.response.BoardListDto;

import java.util.List;

public interface CommonBoardRepositoryCustom {

    List<BoardListDto> getBoardList (GetBoardListDto getBoardListDto);

    Long getBoardListCount(GetBoardListDto getBoardListDto);
}
