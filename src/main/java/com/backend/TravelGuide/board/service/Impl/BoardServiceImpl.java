package com.backend.TravelGuide.board.service.Impl;

import com.backend.TravelGuide.board.dto.BoardDTO;
import com.backend.TravelGuide.board.entity.BoardEntity;
import com.backend.TravelGuide.board.repository.BoardRepository;
import com.backend.TravelGuide.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
    private final BoardRepository boardRepository;

    public void save(BoardDTO boardDTO) {
        BoardEntity boardEntity = BoardEntity.toSaveEntity(boardDTO, boardDTO.getBoardId());
        boardRepository.save(boardEntity);
    }

    @Transactional
    public List<BoardDTO> findAll(int boardId) {
        List<BoardEntity> boardEntityList = boardRepository.findAll();
        List<BoardDTO> boardDTOList = new ArrayList<>();
        for (BoardEntity boardEntity: boardEntityList) {
            boardDTOList.add(BoardDTO.toBoardDTO(boardEntity));
        }
        return boardDTOList;
    }

    @Transactional
    public void updateHits(int boardId) {
        boardRepository.updateHits(boardId);
    }

    @Transactional
    public BoardDTO findById(Long postId) {
        Optional<BoardEntity> optionalBoardEntity = boardRepository.findById(postId);
        if (optionalBoardEntity.isPresent()) {
            BoardEntity boardEntity = optionalBoardEntity.get();
            BoardDTO boardDTO = BoardDTO.toBoardDTO(boardEntity);
            return boardDTO;
        } else {
            return null;
        }
    }

    public BoardDTO update(BoardDTO boardDTO) {
        BoardEntity boardEntity = BoardEntity.toUpdateEntity(boardDTO);
        boardRepository.save(boardEntity);
        return findById(boardDTO.getPostId());
    }

    public void delete(Long id) {
        boardRepository.deleteById(id);
    }
}
