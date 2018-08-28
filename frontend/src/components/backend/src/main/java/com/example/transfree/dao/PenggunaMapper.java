package com.agung.agungtesting.dao;

import com.agung.agungtesting.domain.Pengguna;
import com.agung.agungtesting.domain.PenggunaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface PenggunaMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pengguna
     *
     * @mbg.generated Mon Jul 02 02:49:41 ICT 2018
     */
    long countByExample(PenggunaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pengguna
     *
     * @mbg.generated Mon Jul 02 02:49:41 ICT 2018
     */
    int deleteByExample(PenggunaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pengguna
     *
     * @mbg.generated Mon Jul 02 02:49:41 ICT 2018
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pengguna
     *
     * @mbg.generated Mon Jul 02 02:49:41 ICT 2018
     */
    int insert(Pengguna record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pengguna
     *
     * @mbg.generated Mon Jul 02 02:49:41 ICT 2018
     */
    int insertSelective(Pengguna record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pengguna
     *
     * @mbg.generated Mon Jul 02 02:49:41 ICT 2018
     */
    List<Pengguna> selectByExampleWithRowbounds(PenggunaExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pengguna
     *
     * @mbg.generated Mon Jul 02 02:49:41 ICT 2018
     */
    List<Pengguna> selectByExample(PenggunaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pengguna
     *
     * @mbg.generated Mon Jul 02 02:49:41 ICT 2018
     */
    Pengguna selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pengguna
     *
     * @mbg.generated Mon Jul 02 02:49:41 ICT 2018
     */
    int updateByExampleSelective(@Param("record") Pengguna record, @Param("example") PenggunaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pengguna
     *
     * @mbg.generated Mon Jul 02 02:49:41 ICT 2018
     */
    int updateByExample(@Param("record") Pengguna record, @Param("example") PenggunaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pengguna
     *
     * @mbg.generated Mon Jul 02 02:49:41 ICT 2018
     */
    int updateByPrimaryKeySelective(Pengguna record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pengguna
     *
     * @mbg.generated Mon Jul 02 02:49:41 ICT 2018
     */
    int updateByPrimaryKey(Pengguna record);
}