package com.wong.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.wong.dao.MemberDao;
import com.wong.pojo.Member;
import com.wong.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberDao memberDao;

    @Override
    public void add(Member member) {
        if (member.getPassword() != null) {
            member.setPassword(MD5Utils.md5(member.getPassword()));
        }
        memberDao.add(member);
    }

    @Override
    public Member findByTelephone(String telephone) {
        return memberDao.findByTelephone(telephone);
    }
}
