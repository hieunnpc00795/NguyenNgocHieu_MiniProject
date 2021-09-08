package com.miniproject.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "Authorities", uniqueConstraints = {
		@UniqueConstraint(columnNames = {"Username", "Roleid"})
})
public class Authority {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	@ManyToOne @JoinColumn(name = "Username")
	Account account;
	@ManyToOne @JoinColumn(name = "Roleid")
	Role role;
	
}
