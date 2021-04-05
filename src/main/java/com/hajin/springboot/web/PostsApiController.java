package com.hajin.springboot.web;
import com.hajin.springboot.domain.posts.PostsRepository;
import com.hajin.springboot.service.posts.PostsService;
import com.hajin.springboot.web.dto.PostsResponseDto;
import com.hajin.springboot.web.dto.PostsSaveRequestDto;
import com.hajin.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
//import org.springframework.web.bind.annotation.PutMapping;


@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto){
        return postsService.update(id, requestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById (@PathVariable Long id)
    {
        return postsService.findById(id);
    }
}
