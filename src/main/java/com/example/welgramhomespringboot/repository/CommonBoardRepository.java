package com.example.welgramhomespringboot.repository;

import com.example.welgramhomespringboot.domain.CommonBoard;
import com.example.welgramhomespringboot.repository.custom.CommonBoardRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommonBoardRepository extends JpaRepository<CommonBoard, Long>, CommonBoardRepositoryCustom {
}
