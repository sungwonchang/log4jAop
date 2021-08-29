package com.aoplog.log4jaop;

import com.aoplog.log4jaop.Service.MemberService;
import com.aoplog.log4jaop.dto.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@EnableAspectJAutoProxy
@RequestMapping("log4j")
public class LogTestController {

    @Autowired
    MemberService memberService;

    @GetMapping("index/{name}")
    public String index(@PathVariable String name){
        var member = memberService.getMemberByName(name);
        if(member.isPresent()) {
            return member.get().getName();
        }
        else {
            return "없어";
        }

    }

    @GetMapping("about/{age}")
    public List<Member> about(@PathVariable("age") Integer age){
        var memberList = memberService.getMemberByAge(age);
        return memberList;
    }

}
