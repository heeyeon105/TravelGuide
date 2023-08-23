package com.backend.TravelGuide.board.repository;

import com.backend.TravelGuide.board.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BoardRepository extends JpaRepository<BoardEntity, Long> {
    @Modifying
    @Query(value = "update BoardEntity b set b.view_count=b.view_count+1 where b.board_id=:boardId")
    void updateHits(@Param("board_id") int boardId);
}
