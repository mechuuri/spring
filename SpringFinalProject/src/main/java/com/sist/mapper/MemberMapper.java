package com.sist.mapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;
public interface MemberMapper {
  // 로그인	
  // 아이디 중복체크
  @Select("SELECT COUNT(*) FROM spring_join "
		 +"WHERE id=#{id}")
  public int memberIdCheck(String id);
  
  @Select("SELECT id,pwd,name,admin FROM spring_join "
		 +"WHERE id=#{id}")
  public MemberVO memberLogin(String id);
  
  // 회원가입
  @Insert("INSERT INTO spirng_join VALUES("
		  +"#{id},#{pwd},#{name},'n'")
  public void memberInsert(MemberVO vo);
  
}