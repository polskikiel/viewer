package newsheetviewer.viewer.filters;

import lombok.AllArgsConstructor;
import newsheetviewer.viewer.compontents.MySession;
import newsheetviewer.viewer.services.MySessionServices;
import newsheetviewer.viewer.services.RestServicesImpl;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by Majk on 2017-10-21.
 */
@Component
@AllArgsConstructor
public class MainInterceptor implements HandlerInterceptor{

    RestServicesImpl restServicesImpl;
    MySessionServices mySession;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession(true);

        if (session.isNew()) {
            session.setAttribute("session", new MySession());
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
