package com.aoplog.log4jaop.Service;

import com.aoplog.log4jaop.Repository.MemberRespository;
import com.aoplog.log4jaop.dto.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    @Autowired
    MemberRespository memberRespository;

    public Optional<Member> getMemberByName(String name) {
        return memberRespository.getMemberByName(name);
    }

    public List<Member> getMemberByAge(int age) {
        return memberRespository.getMemberByAge(age);
    }
}
