package com.example.java_fpt.Repositories;

import com.example.java_fpt.Model.Nganh;
import com.example.java_fpt.Model.Truong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NganhRepository extends JpaRepository<Nganh,String>{

}
