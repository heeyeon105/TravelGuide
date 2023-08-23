package com.backend.TravelGuide.board.controller;

import com.backend.TravelGuide.board.dto.BoardDTO;
import com.backend.TravelGuide.board.service.Impl.BoardServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
    private final BoardServiceImpl boardService;

    @PostMapping("/save")
    public String save(@ModelAttribute BoardDTO boardDTO) {
        boardService.save(boardDTO);
        return ;
    }

    @GetMapping("/")
    public List<BoardDTO> findAll(Model model, int boardId) {
        List<BoardDTO> boardDTOList = boardService.findAll(boardId);
        model.addAttribute("boardList", boardDTOList);
        return boardDTOList;
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable int boardId, @PathVariable Long postId, Model model) {
        boardService.updateHits(boardId);
        BoardDTO boardDTO = boardService.findById(postId);
        model.addAttribute("board", boardDTO);
        return String.valueOf(postId);
    }

    @GetMapping("/update/{id}")
    public String updateForm(@PathVariable Long id, Model model) {
        BoardDTO boardDTO = boardService.findById(id);
        model.addAttribute("boardUpdate", boardDTO);
        return ;
    }

    @PostMapping("/update")
    public String update(@ModelAttribute BoardDTO boardDTO, Model model) {
        BoardDTO board = boardService.update(boardDTO);
        model.addAttribute("board", board);
        return "redirect:/board/" + boardDTO.getPostId();
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long postId) {
        boardService.delete(postId);
        return "redirect:/board/";
    }

}
