package com.example.java_fpt.Repositories;

import com.example.java_fpt.Model.Truong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TruongRepository extends JpaRepository<Truong,String> {
}
