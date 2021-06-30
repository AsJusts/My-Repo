package dev.ikhtiyor.appsharelinkserver.repository;

import dev.ikhtiyor.appsharelinkserver.entity.DataEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


public interface DataRepository extends JpaRepository<DataEntity, UUID> {

}
