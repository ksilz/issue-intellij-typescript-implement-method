package com.betterprojectsfaster.talks.openj9memory.repository;

import com.betterprojectsfaster.talks.openj9memory.domain.Authority;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Spring Data JPA repository for the {@link Authority} entity.
 */
public interface AuthorityRepository extends JpaRepository<Authority, String> {
}
