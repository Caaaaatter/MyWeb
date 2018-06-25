package zzg.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by zhangzhenguo
 * on 2018/6/21
 * info:
 */
@Controller
@RequestMapping("/operations")
public class OperationsController {
    @RequestMapping("/installTeam")
    public String installTeamViewer(){
        return "installTeam";
    }
}
