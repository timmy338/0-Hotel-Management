package com.zero.dao;

import com.zero.pojo.Member;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MemberDao {
    /**
     * 增加会员
     * @param Member 会员对象
     * @return 0表明增加失败
     */
    int insertMember(Member Member);

    /**
     * 删除会员
     * @param memberId 会员id
     * @return 0表明删除失败
     */
    int deleteMember(@Param("memberId") Integer memberId);

    /**
     * 修改会员
     * @param id 会员id
     * @return 0表明修改失败
     */
    int updateMember(@Param("id")Integer id);

    /**
     * 查询所有会员
     * @return 一个带有所有会员的List
     */
    List<Member> selectAllMember();

    /**
     * 从会员编号查询会员
     * @param memberId 会员编号
     * @return 满足条件的会员List
     */
    List<Member> selectMemberById(@Param("memberId") Integer memberId);

    /**
     * 从会员名查询会员
     * @param memberName 会员名
     * @return 满足条件的会员List
     */
    List<Member> selectMembersByName(@Param("memberName") String memberName);
}
