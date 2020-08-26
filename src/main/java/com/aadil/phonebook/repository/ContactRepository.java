package com.aadil.phonebook.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aadil.phonebook.entity.ContactInfoEntity;

public interface ContactRepository extends JpaRepository<ContactInfoEntity, Serializable>{

}
