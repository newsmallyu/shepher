package com.xiaomi.shepher.controller;

import com.xiaomi.shepher.common.Auth;
import com.xiaomi.shepher.common.Jurisdiction;
import com.xiaomi.shepher.common.LoginRequired;
import com.xiaomi.shepher.exception.ShepherException;
import com.xiaomi.shepher.util.SystemUser;
import com.xiaomi.shepher.util.SystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @author ay05
 * @create 3/22/2019
 */
@Controller
@LoginRequired
@RequestMapping("user")
@Auth(Jurisdiction.SUPER_ADMIN)
public class UserController {
    @Autowired
    SystemUserService systemUserService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String manage(Model model) {
        List<SystemUser> usernameList = systemUserService.listUser();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        model.addAttribute("userlist", usernameList);
        return "/user/manage";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@RequestParam("username") String username, @RequestParam("password") String password){
        SystemUser systemUser = new SystemUser(username,password);
        systemUserService.addUser(systemUser);
        return "redirect:/user";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@RequestParam("id") String id)  {
        systemUserService.delUser(id);
        return "redirect:/user";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@RequestParam("id") Integer id,@RequestParam("username") String username, @RequestParam("password") String password) {
        SystemUser systemUser = new SystemUser(id,username,password);
        systemUserService.updateUser(systemUser);
        return "redirect:/user";
    }
}
