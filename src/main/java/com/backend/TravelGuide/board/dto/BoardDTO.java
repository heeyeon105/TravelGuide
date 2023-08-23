package com.backend.TravelGuide.board.dto;

import com.backend.TravelGuide.board.entity.BoardEntity;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BoardDTO {
    private int boardId; // 게시판 아이디? 1 : 2
    private Long postId; // 게시글 번호
    private String email;
    private String boardTitle;
    private String boardContents;
    private int viewCount;
    private LocalDateTime boardCreatedTime;
    private LocalDateTime boardUpdatedTime;
    private int viewRole;

    // boardService -> findAll()
    public static BoardDTO toBoardDTO(BoardEntity boardEntity) {
        BoardDTO boardDTO = new BoardDTO();
        boardDTO.setBoardId(boardEntity.getBoard_id());
        boardDTO.setPostId(boardEntity.getPost_id());
        boardDTO.setEmail(boardEntity.getEmail());
        boardDTO.setBoardTitle(boardEntity.getTitle());
        boardDTO.setBoardContents(boardEntity.getContent());
        boardDTO.setViewCount(boardEntity.getView_count());
        boardDTO.setBoardCreatedTime(boardEntity.getCreatedAt());
        boardDTO.setBoardUpdatedTime(boardEntity.getModifiedAt());
        boardDTO.setViewRole(boardEntity.getView_role());

        return boardDTO;
    }
}
