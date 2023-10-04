package com.example.welgramhomespringboot.controller.dto.request;

import lombok.Builder;
import lombok.Getter;

@Getter
public class GetBoardListDto {

    private int page;
    private long limit;
    private long offset;
    private String sort;
    private String category;

    public void setCategory(String category) {
        this.category = category;
    }

    @Builder
    public GetBoardListDto(int page, long limit, String sort) {
        this.page = page == 0 ? 1 : page;
        this.limit = limit == 0 ? 20 : limit;
        this.offset = (this.page-1)*limit;
        this.sort = sort;
    }

}
