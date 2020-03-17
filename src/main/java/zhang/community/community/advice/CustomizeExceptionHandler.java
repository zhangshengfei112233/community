package zhang.community.community.advice;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import zhang.community.community.dto.ResultDTO;
import zhang.community.community.exception.CustomizeErrorCode;
import zhang.community.community.exception.CustomizeException;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class CustomizeExceptionHandler {
    @ExceptionHandler(Exception.class)
    Object handle( Throwable e, Model model,HttpServletRequest request){

        String contentType = request.getContentType();
        if ("application/json".equals(contentType)){
            //返回json
            if (e instanceof CustomizeException){
                return ResultDTO.errorof((CustomizeException) e);
            }else{
                return ResultDTO.errorof(CustomizeErrorCode.SYS_ERROR);
            }
        }else{
            //错误页面跳转
            if (e instanceof CustomizeException){
                model.addAttribute("message",e.getMessage());
            }else{
                model.addAttribute("message",CustomizeErrorCode.SYS_ERROR.getMessage());
            }

        }

        if (e instanceof CustomizeException){
            model.addAttribute("message",e.getMessage());
        }else{
            model.addAttribute("message","页面加载错误，请稍后再试！！！");
        }
        return  new ModelAndView("error");
    }
}
