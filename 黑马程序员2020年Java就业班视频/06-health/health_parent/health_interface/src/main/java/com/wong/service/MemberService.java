package com.wong.service;

import com.wong.pojo.Member;

public interface MemberService {
    void add(Member member);

    Member findByTelephone(String telephone);
}
