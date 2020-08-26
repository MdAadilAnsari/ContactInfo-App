package com.aadil.phonebook.model;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class ContactDtls implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6452994455087104204L;
	private Integer contactId;
	private String contactName;
	private String contactEmail;
	private Long contactNumber;
	private Date creationDate;
	private Date updatedDate;

}
