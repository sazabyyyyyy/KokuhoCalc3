package com.kaneko.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kaneko.springboot.MyData;

@Repository//このクラスがデータアクセスのクラスであることを示すアノテーション
public interface MyDataRepository extends JpaRepository<MyData, Long> {

}
