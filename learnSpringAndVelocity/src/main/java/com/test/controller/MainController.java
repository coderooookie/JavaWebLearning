package com.test.controller;

import com.test.model.Department;
import com.test.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import java.util.List;

@Controller
public class MainController {
    @Autowired
    private DepartmentService departmentService;

    @RequestMapping(value = {"/","/welcome"}, method = RequestMethod.GET)
    public String welcomePage(Model model) {
        List<Department> list = departmentService.listDepartment();
        model.addAttribute("departments", list);
        return "index";
    }
}
