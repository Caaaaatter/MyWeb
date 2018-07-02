package zzg.web;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/")
public class HomeController {


    @RequestMapping(method = GET)
    public String index(Model model) {
        return "index";
    }


    @RequestMapping(value = "getGallery", method = GET)
    public String gallery(Model model) {


        return "gallery";
    }

    private static HttpSession getSession() {
        HttpSession session = null;

        session = getRequest().getSession();
        return session;
    }

    public static HttpServletRequest getRequest() {
        ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return attrs.getRequest();
    }
}
