package zhang.community.community.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import zhang.community.community.model.Question;

@Mapper
public interface QuestionMapper {
    @Insert("insert into question(tittle,description,gmt_create,gmt_modified,creator,tag) values(#{tittle},#{description},#{gmtCreate},#{gmtModified},#{creator},#{tag})")
    void create(Question question);
}
