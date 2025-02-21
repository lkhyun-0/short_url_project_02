package com.example.short_url_project_02.domain.surl.repository;

import com.example.short_url_project_02.domain.surl.entity.Surl;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurlRepository extends JpaRepository<Surl, Long> {
}
