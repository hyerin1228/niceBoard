package com.nice.board.springboot.web;

import com.nice.board.springboot.service.posts.PostsService;
import com.nice.board.springboot.web.dto.PostsResponseDto;
import com.nice.board.springboot.web.dto.PostsSaveRequestDto;
import com.nice.board.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor        // final이 선언된 모든 필드를 인자값으로 하는 생성자
@RestController
public class PostsApiController {

    private final PostsService postsService;

    // 게시글 등록
    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto){
        return postsService.save(requestDto);
    }

    // 게시글 수정
    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto){
        return postsService.update(id, requestDto);
    }

    // 게시글 조회
    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById (@PathVariable Long id){
        return postsService.findById(id);
    }

    // 게시글 삭제
    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id){
        postsService.delete(id);
        return id;
    }

}
