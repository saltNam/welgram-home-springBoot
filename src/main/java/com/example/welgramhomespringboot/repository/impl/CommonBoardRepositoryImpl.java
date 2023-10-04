package com.example.welgramhomespringboot.repository.impl;

import com.example.welgramhomespringboot.controller.dto.request.GetBoardListDto;
import com.example.welgramhomespringboot.controller.dto.response.BoardListDto;
import com.example.welgramhomespringboot.controller.dto.response.QBoardListDto;
import com.example.welgramhomespringboot.repository.custom.CommonBoardRepositoryCustom;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.example.welgramhomespringboot.domain.QCommonBoard.commonBoard;


@Repository
@RequiredArgsConstructor
// 쿼리문 작성
public class CommonBoardRepositoryImpl implements CommonBoardRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    @Override
    public List<BoardListDto> getBoardList(GetBoardListDto getBoardListDto) {
        return queryFactory.select(
                new QBoardListDto(
                        commonBoard.seq,
                        commonBoard.title,
                        commonBoard.contentText,
                        commonBoard.contentUrl,
                        commonBoard.regTime))
                .from(commonBoard)
                .where(commonBoard.useYn.eq("Y")
                        .and(commonBoard.delYn.eq("N"))
                        .and(commonBoard.useFrontYn.eq("Y"))
                        .and(commonBoard.regTime.isNotNull())
                        .and(commonBoard.category.eq(getBoardListDto.getCategory())))
                .limit(getBoardListDto.getLimit())
                .offset(getBoardListDto.getOffset())
                .fetch();



    }

    @Override
    public Long getBoardListCount(GetBoardListDto getBoardListDto) {
        return queryFactory
                .selectFrom(commonBoard)
                .where(commonBoard.useYn.eq("Y")
                        .and(commonBoard.delYn.eq("N"))
                        .and(commonBoard.useFrontYn.eq("Y"))
                        .and(commonBoard.regTime.isNotNull())
                        .and(commonBoard.category.eq(getBoardListDto.getCategory())))
                .fetchCount();
    }

}
