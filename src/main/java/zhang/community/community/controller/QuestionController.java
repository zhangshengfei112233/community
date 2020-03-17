package zhang.community.community.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import zhang.community.community.dto.QuestionDTO;
import zhang.community.community.mapper.QuestionMapper;
import zhang.community.community.service.QuestionService;

@Controller
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/question/{id}")
    public String question(
            @PathVariable(name= "id")Long id, Model model
            ){
        QuestionDTO questionDTO=questionService.getById(id);
        //累加阅读数
        questionService.incView(id);

        model.addAttribute("question",questionDTO);
        return "question";
    }

}
