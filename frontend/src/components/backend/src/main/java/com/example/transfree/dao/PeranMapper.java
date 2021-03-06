package com.agung.agungtesting.dao;

import com.agung.agungtesting.domain.Peran;
import com.agung.agungtesting.domain.PeranExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface PeranMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table peran
     *
     * @mbg.generated Mon Jul 02 02:49:41 ICT 2018
     */
    long countByExample(PeranExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table peran
     *
     * @mbg.generated Mon Jul 02 02:49:41 ICT 2018
     */
    int deleteByExample(PeranExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table peran
     *
     * @mbg.generated Mon Jul 02 02:49:41 ICT 2018
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table peran
     *
     * @mbg.generated Mon Jul 02 02:49:41 ICT 2018
     */
    int insert(Peran record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table peran
     *
     * @mbg.generated Mon Jul 02 02:49:41 ICT 2018
     */
    int insertSelective(Peran record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table peran
     *
     * @mbg.generated Mon Jul 02 02:49:41 ICT 2018
     */
    List<Peran> selectByExampleWithRowbounds(PeranExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table peran
     *
     * @mbg.generated Mon Jul 02 02:49:41 ICT 2018
     */
    List<Peran> selectByExample(PeranExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table peran
     *
     * @mbg.generated Mon Jul 02 02:49:41 ICT 2018
     */
    Peran selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table peran
     *
     * @mbg.generated Mon Jul 02 02:49:41 ICT 2018
     */
    int updateByExampleSelective(@Param("record") Peran record, @Param("example") PeranExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table peran
     *
     * @mbg.generated Mon Jul 02 02:49:41 ICT 2018
     */
    int updateByExample(@Param("record") Peran record, @Param("example") PeranExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table peran
     *
     * @mbg.generated Mon Jul 02 02:49:41 ICT 2018
     */
    int updateByPrimaryKeySelective(Peran record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table peran
     *
     * @mbg.generated Mon Jul 02 02:49:41 ICT 2018
     */
    int updateByPrimaryKey(Peran record);
}