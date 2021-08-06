package com.edu.book.springboot.service.posts;

import com.edu.book.springboot.domain.posts.Posts;
import com.edu.book.springboot.domain.posts.PostsRepository;
import com.edu.book.springboot.web.dto.PostsListResponseDto;
import com.edu.book.springboot.web.dto.PostsResponseDto;
import com.edu.book.springboot.web.dto.PostsSaveRequestDto;
import com.edu.book.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.w3c.dom.stylesheets.LinkStyle;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto){
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 업습니다. id="+id));

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    @Transactional
    public PostsResponseDto findById(Long id){
        Posts entity = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id="+id));

        return new PostsResponseDto(entity);
    }

    @Transactional
    public List<PostsListResponseDto> findAllDesc(){
        return postsRepository.findAllDesc().stream().map(PostsListResponseDto::new).collect(Collectors.toList());
        // = .map(posts -> new PostsListResponseDto(posts))
        //postsRepository 결과로 넘어온 Posts의 stream을 map을 통해 PostsListResponseDto로 변환하고 List로 변환하는 작업
    }

    @Transactional
    public void delete (Long id){
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id="+id));

        postsRepository.delete(posts);
    }
}
