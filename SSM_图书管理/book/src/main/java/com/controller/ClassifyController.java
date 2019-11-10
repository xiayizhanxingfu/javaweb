package com.controller;

import com.bean.Classify;
import com.service.ClassifyService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/classify")
public class ClassifyController {
    @Resource
    ClassifyService service;

    @RequestMapping("/list")
    public String list(HttpServletRequest request) {
        request.setAttribute("classifyList", service.list());
        return "classify/list";
    }

    @GetMapping("/delete")
    public String deleteById(HttpServletRequest request) {
        String id = request.getParameter("id");
        service.deleteById(Integer.parseInt(id));
        return "forward:list";
    }

    @GetMapping("/add")
    public String add() {
        return "classify/add";
    }

    @PostMapping("/addClassify")
    public String addClassify(HttpServletRequest request) {
        String classifyId = request.getParameter("classifyId");
        String classifyName = request.getParameter("classifyName");
        Classify classify = new Classify();
        classify.setClassifyId(Integer.parseInt(classifyId));
        classify.setClassifyName(classifyName);
        service.add(classify);
        return "forward:list";
    }

    @GetMapping("/update")
    public String update(HttpServletRequest request) {
        String id = request.getParameter("id");
        request.setAttribute("id", id);
        return "classify/update";
    }

    @PostMapping("/updateClassify")
    public String updateClassify(HttpServletRequest request) {
        String classifyId = request.getParameter("classifyId");
        String classifyName = request.getParameter("classifyName");
        Classify classify = new Classify();
        classify.setClassifyId(Integer.parseInt(classifyId));
        classify.setClassifyName(classifyName);
        service.update(classify);
        return "forward:list";
    }
}

