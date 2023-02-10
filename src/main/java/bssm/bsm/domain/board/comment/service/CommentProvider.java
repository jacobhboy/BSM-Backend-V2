package bssm.bsm.domain.board.comment.service;

import bssm.bsm.domain.board.comment.domain.Comment;
import bssm.bsm.domain.board.comment.domain.repository.CommentRepository;
import bssm.bsm.domain.board.comment.exception.NoSuchCommentException;
import bssm.bsm.domain.board.post.domain.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CommentProvider {

    private final CommentRepository commentRepository;

    public Comment findComment(Post post, long id) {
        return commentRepository.findByPkIdAndPost(id, post)
                .orElseThrow(NoSuchCommentException::new);
    }

    public List<Comment> findCommentList(Post post) {
        return commentRepository.findAllByPost(post);
    }

    public long getNewCommentId(Post post) {
        return commentRepository.countByPost(post) + 1;
    }

}
