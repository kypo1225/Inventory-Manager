package com.example.demo.domain;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String person;
	private Integer page;
	private String selectCategory;
	private Date regist;
	private byte[] cover;
	
	@Override
    public String toString() {
        return "Player [id=" + id + ", title=" + title + ", pseron=" + person + ", page=" + page + ", selectCategory=" + selectCategory + "]";
    }
}
