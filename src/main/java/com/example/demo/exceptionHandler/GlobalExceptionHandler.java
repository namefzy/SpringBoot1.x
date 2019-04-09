package com.example.demo.exceptionHandler;

import com.example.demo.domain.ErrorInfo;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

public class GlobalExceptionHandler {
    public static final String DEFAULT_ERROR_VIEW = "error";
//    @ExceptionHandler(value = Exception.class)
//    public ModelAndView defaultErrorHandler(HttpServletRequest req,Exception e)throws Exception{
//        System.out.println("111111111111111111111");
//        ModelAndView mv = new ModelAndView();
//        mv.addObject("exception", e);
//        mv.addObject("url", req.getRequestURL());
//        mv.setViewName(DEFAULT_ERROR_VIEW);
//        return mv;
//    }
    @ExceptionHandler(value = MyException.class)
    @ResponseBody
    public ErrorInfo<String> jsonErrorHandler(HttpServletRequest req, MyException e) throws Exception {
        ErrorInfo<String> r = new ErrorInfo<>();
        r.setMessage(e.getMessage());
        r.setCode(ErrorInfo.ERROR);
        r.setData("Some Data");
        r.setUrl(req.getRequestURL().toString());
        return r;
}
}
