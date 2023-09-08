package cn.lzy.mybatis.jp;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DiscussRepository extends JpaRepository<Discuss,Integer> {
    public List<Discuss> findByAuthorNotNull();
}