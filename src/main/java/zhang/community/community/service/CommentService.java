package zhang.community.community.service;

import org.springframework.stereotype.Service;
import zhang.community.community.exception.CustomizeErrorCode;
import zhang.community.community.exception.CustomizeException;
import zhang.community.community.model.Comment;

@Service
public class CommentService {


    public void insert(Comment comment) {
        if(comment.getParentId()==null||comment.getParentId()==0){
            throw  new CustomizeException(CustomizeErrorCode.TARGET_PARAM_NOT_FOUND);
        }
    }
}
