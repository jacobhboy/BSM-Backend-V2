package bssm.bsm.domain.board.post.dto;

import bssm.bsm.domain.user.dto.response.UserResponseDto;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Getter
@SuperBuilder
public class PostDto {

    private int id;
    private UserResponseDto user;
    private String category;
    private String title;
    private Date createdAt;
    private int hit;
    private int totalComments;
    private int totalLikes;
}
