package com.sist.dao;

import org.springframework.stereotype.Repository;

import com.sist.vo.ReplyVO;

import oracle.jdbc.OracleType;
import oracle.jdbc.OracleTypes;

import java.util.*;
import java.sql.*;
/*
create or replace NONEDITIONABLE PROCEDURE replyDelete(
    pNo spring_reply.no%TYPE
)
IS 
BEGIN
    DELETE FROM spring_reply 
    WHERE no=pNo;
    COMMIT;
END;


create or replace NONEDITIONABLE PROCEDURE replyInsert(
    pRno spring_reply.rno%TYPE,
    pType spring_reply.type%TYPE,
    pId spring_reply.id%TYPE,
    pName spring_reply.name%TYPE,
    pMsg spring_reply.msg%TYPE
)
IS
BEGIN
    INSERT INTO spring_reply VALUES(sr_no_seq.nextval,pRno,pType,pId,pName,pMsg,SYSDATE);
    COMMIT;
END;

create or replace NONEDITIONABLE PROCEDURE replyList(
    pRno spring_reply.rno%TYPE,
    pType spring_reply.type%TYPE,
    pResult OUT SYS_REFCURSOR
)
IS
BEGIN
    OPEN pResult FOR
        SELECT no,rno,type,id,name,msg,regdate,TO_CHAR(regdate,'YYYY-MM-DD HH24:MI:SS') as dbday
        FROM spring_reply
        WHERE rno=pRno AND type=pType
        ORDER BY no DESC;
END;

create or replace NONEDITIONABLE PROCEDURE replyUpdate(
    pNo spring_reply.no%TYPE,
    pMsg spring_reply.msg%TYPE
)
IS
BEGIN
    UPDATE spring_reply SET
    msg=pMsg
    WHERE no=pNo;
    COMMIT;
END;
 */
@Repository
public class ReplyDAO {
	private Connection conn;
	private CallableStatement cs;
	private final String URL="jdbc:oracle:thin:@localhost:1521:XE";
	
	public ReplyDAO()
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
		}catch(Exception ex) {}
	}
	
	public void getConnection()
	{
		try
		{
			conn=DriverManager.getConnection(URL,"hr","happy");
		}catch(Exception ex) {}
	}
	public void disConnection()
	{
		try
		{
			if(cs!=null) cs.close();
			if(conn!=null) conn.close();
		}catch (Exception e) {
			// TODO: handle exception
		}
	
	}
	
	// CURD
	public List<ReplyVO> replyListData(ReplyVO vo)
	{
		List<ReplyVO> list=new ArrayList<ReplyVO>();
		try
		{
			getConnection();
			String sql="{CALL replyList(?,?,?)}";
			cs=conn.prepareCall(sql);
			cs.setInt(1, vo.getType());// 카테고리 (맛집,여행,레시피...)
			cs.setInt(2, vo.getNo()); // 맛집,번호(고유번호)
			cs.registerOutParameter(3, OracleTypes.CURSOR);
			cs.executeQuery();
			ResultSet rs=(ResultSet)cs.getObject(3);
			// CURSOR = ResultSet
			while(rs.next())
			{
				ReplyVO rvo=new ReplyVO();
				rvo.setNo(rs.getInt(1));
				rvo.setRno(rs.getInt(2));
				rvo.setType(rs.getInt(3));
				rvo.setId(rs.getNString(4));
				rvo.setName(rs.getNString(5));
				rvo.setMsg(rs.getNString(6));
				rvo.setRegdate(rs.getDate(7));
				rvo.setDbday(rs.getString(8));
				list.add(rvo);
			}
			rs.close();
			
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			disConnection();
		}
		
		
		return list;
	}
	
	// insert
	/*
	create or replace NONEDITIONABLE PROCEDURE replyInsert(
    pRno spring_reply.rno%TYPE,
    pType spring_reply.type%TYPE,
    pId spring_reply.id%TYPE,
    pName spring_reply.name%TYPE,
    pMsg spring_reply.msg%TYPE
)
IS
BEGIN
    INSERT INTO spring_reply VALUES(sr_no_seq.nextval,pRno,pType,pId,pName,pMsg,SYSDATE);
    COMMIT;
END;
	 */
	public void replyInsert(ReplyVO vo)
	{
		try
		{
			getConnection();
			String sql="{CALL replyInsert(?,?,?,?,?)}";
			cs=conn.prepareCall(sql);
			cs.setInt(1, vo.getRno());
			cs.setInt(2, vo.getType());
			cs.setString(3, vo.getId());
			cs.setString(4, vo.getName());
			cs.setString(5, vo.getMsg());
			cs.executeQuery();
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			disConnection();
		}
	}
	
	// 수정하기 
/*
create or replace NONEDITIONABLE PROCEDURE replyUpdate(
    pNo spring_reply.no%TYPE,
    pMsg spring_reply.msg%TYPE
)
IS
BEGIN
    UPDATE spring_reply SET
    msg=pMsg
    WHERE no=pNo;
    COMMIT;
END;
 */
	public void replyUpdate(int no,String msg)
	{
		try
		{
			getConnection();
			String sql= "{CALL replyDelete(?,?)}";
			cs=conn.prepareCall(sql);
			cs.setInt(1, no);
			cs.setString(2, msg);
			cs.executeQuery();
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			disConnection();
		}
	}
	
	// 삭제하기
/*
create or replace NONEDITIONABLE PROCEDURE replyDelete(
    pNo spring_reply.no%TYPE
)
IS 
BEGIN
    DELETE FROM spring_reply 
    WHERE no=pNo;
    COMMIT;
END;
 */
	public void replyDelete(int no)
	{
		try
		{
			getConnection();
			String sql= "{CALL replyDelete(?)}";
			cs=conn.prepareCall(sql);
			cs.setInt(1, no);
			cs.executeQuery();
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			disConnection();
		}
	}
	
	
	
	
}
