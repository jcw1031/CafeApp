package jcw.camo_server.mapper;

import jcw.camo_server.entity.Cafe;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface CafeMapper {

    /**
     * Cafe 저장
     *
     * @param cafe
     */
    void cafeSave(Cafe cafe);

    /**
     * 카페 리스트
     */
    List<Cafe> findAll();

    /**
     * 이름으로 cafe 검색
     */
    List<Cafe> findByName(@Param("name") String cafeName);

    /**
     * userId로 cafe 검색
     */
    Optional<Cafe> findByUserId(@Param("id") Long userId);
}