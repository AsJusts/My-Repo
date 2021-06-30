package dev.ikhtiyor.appsharelinkserver.repository;

import dev.ikhtiyor.appsharelinkserver.entity.Link;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by Ikhtiyor Khaitov
 * 15/05/21
 **/

public interface LinkRepository extends JpaRepository<Link, Long> {
    Optional<Link> findByGeneratedLink(String generatedLink);
    boolean existsByGeneratedLink(String generatedLink);
}
