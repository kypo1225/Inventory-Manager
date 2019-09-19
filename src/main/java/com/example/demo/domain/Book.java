package com.example.demo.domain;





import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String title;
	@NotBlank
	private String person;
	@NotNull
	private Integer page;
	@NotBlank
	private String selectCategory;
	private Date register;
	
	@Override
    public String toString() {
        return "Player [id=" + id + ", title=" + title + ", person=" 
    + person + ", page=" + page + ", selectCategory=" + selectCategory + "register=" + register + "]";
    }
}
