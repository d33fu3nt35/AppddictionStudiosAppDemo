package com.appddiction.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by daniel on 8/2/17.
 */

@Controller
public class IndexController {
    @RequestMapping("/")
    String index(){
        return "index";
    }
}
