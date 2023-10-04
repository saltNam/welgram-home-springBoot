package com.example.welgramhomespringboot.service;

import com.example.welgramhomespringboot.controller.dto.request.GetBoardListDto;
import com.example.welgramhomespringboot.controller.dto.response.BoardListDto;
import com.example.welgramhomespringboot.repository.CommonBoardRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import javax.transaction.Transactional;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest
@Transactional
public class CommonBoardServiceTest {

    @Autowired
    CommonBoardService commonBoardService;

    @Autowired
    CommonBoardRepository commonBoardRepository;

    @Test
    void getNoticeList() {

        //given
    GetBoardListDto requestDto = GetBoardListDto.builder()
            .page(1)
            .limit(5)
            .build();

        System.out.println(requestDto.toString());

        // when
        List<BoardListDto> response = commonBoardService.getBoardList(requestDto,"CD00594");
        Long responseCount = commonBoardService.getBoardListCount(requestDto, "CD00594");


        System.out.println(response.toString());
        System.out.println(responseCount);
    }




}
