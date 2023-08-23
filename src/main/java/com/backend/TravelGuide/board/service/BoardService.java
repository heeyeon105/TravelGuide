package com.backend.TravelGuide.board.service;

import com.backend.TravelGuide.board.dto.BoardDTO;

import java.util.List;

public interface BoardService {

    // 게시글 저장
    void save(BoardDTO boardDTO);

    // 게시글 보기
    List<BoardDTO> findAll(int boardId);

    // 조회수 증가
    void updateHits(int boardId);

    BoardDTO findById(Long postId);

    // 게시글 수정
    BoardDTO update(BoardDTO boardDTO);

    // 게시글 삭제
    void delete(Long postId);

}
