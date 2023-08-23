package com.backend.TravelGuide.board.entity;

import com.backend.TravelGuide.board.dto.BoardDTO;
import com.backend.TravelGuide.member.domain.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "board")
public class BoardEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long post_id;

    @Column
    private int board_id;

    @Column(length = 64, nullable = false)
    private String email;

    @Column(length = 64, nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private int view_count;

    @Column(nullable = false)
    private int view_role;

    public static BoardEntity toSaveEntity(BoardDTO boardDTO, int board_id) {
        BoardEntity boardEntity = new BoardEntity();

        if(board_id == 1) {
            boardEntity.setTitle(boardDTO.getBoardTitle());
            boardEntity.setContent(boardDTO.getBoardContents());
        } else if (board_id == 2) {
            boardEntity.setTitle(boardDTO.getBoardTitle());
            boardEntity.setContent(boardDTO.getBoardContents());
            boardEntity.setView_count(0);
        }
        return boardEntity;
    }

    public static BoardEntity toUpdateEntity(BoardDTO boardDTO) {
        BoardEntity boardEntity = new BoardEntity();
        boardEntity.setBoard_id(boardDTO.getBoardId());
        boardEntity.setPost_id(boardDTO.getPostId());
        boardEntity.setEmail(boardDTO.getEmail());
        boardEntity.setTitle(boardDTO.getBoardTitle());
        boardEntity.setContent(boardDTO.getBoardContents());
        boardEntity.setView_count(boardDTO.getViewCount());
        return boardEntity;
    }

}
