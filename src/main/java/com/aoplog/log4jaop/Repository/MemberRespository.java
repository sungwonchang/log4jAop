package com.aoplog.log4jaop.Repository;

import com.aoplog.log4jaop.dto.Member;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class MemberRespository {
    public static List<Member> memberRepository = new ArrayList<>();

    @ConstructorBinding
    public MemberRespository(){
        for (int i = 0; i < 100; i++) {
            var age = i < 50 ? 30 : 40;
            Member member = Member.builder().name("name_" + i).age(age).userId("id_" + i).build();
            memberRepository.add(member);
        }
    }

    public Optional<Member> getMemberByName(String name) {
        Optional<Member> first = memberRepository.stream().filter(r -> r.getName().equals(name) ).findFirst();
        return first;
    }

    public List<Member> getMemberByAge(int age) {
        return memberRepository.stream().filter(r -> r.getAge() == age).collect(Collectors.toList());
    }
}
