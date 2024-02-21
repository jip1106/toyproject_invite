package com.jun.toyproject.invite.product.repository;

import com.jun.toyproject.invite.product.entity.SaveOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface SaveOptionRepository extends JpaRepository<SaveOption, Long> {
}
