package cn.edu.zut.trace.interceptor;

import cn.edu.zut.trace.common.enums.ResultCode;
import cn.edu.zut.trace.entity.po.User;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        if (user!=null) {
            return true;
        }
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=UTF-8");
        response.setStatus(403);
        JSONObject object = new JSONObject();
        object.put("code", String.valueOf(ResultCode.未登陆异常.getCode()));
        object.put("message", ResultCode.未登陆异常.getMsg());
        response.getWriter().write(object.toString());

        return false;
    }
}
