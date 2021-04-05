package com.hajin.springboot.service.posts;
import com.hajin.springboot.domain.posts.Posts;
import com.hajin.springboot.domain.posts.PostsRepository;
import com.hajin.springboot.web.dto.PostsResponseDto;
import com.hajin.springboot.web.dto.PostsSaveRequestDto;
import com.hajin.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor //생성자 생성 (Autowired 안써도 됨) // bean 주입 방식 - 1. @Autowired 2. setter 3. 생성
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id ="+id));
        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public PostsResponseDto findById (Long id) {
        Posts entity = postsRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 사용자가 없습니다. id ="+id));
        return new PostsResponseDto(entity);
    }
}
