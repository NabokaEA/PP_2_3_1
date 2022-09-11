package ru.nabokae.persist;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CRUDuserRepository extends CrudRepository <User, Long > {
}
