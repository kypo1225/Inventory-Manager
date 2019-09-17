package com.example.demo.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.Book;
import com.example.demo.service.BookService;

@Controller
@RequestMapping("/books")
public class BookController {
	@Autowired
	private BookService bookService;
	
	@GetMapping
	public String index(Model model) {
		List<Book>books = bookService.findAll();
		model.addAttribute("books", books);
		return "books/index";
	}
    private Map<String, String> selectCategory;
    public Map<String, String> getSelectCategory(){
    	Map<String, String> category = new LinkedHashMap<String, String>();
    	category.put("A", "教育・自己啓発");
    	category.put("B", "小説");
    	category.put("C", "コミックス");
    	category.put("D", "ビジネス・経済");
    	category.put("D", "暮らし・健康・料理");    	
		return category;
    }
    
	@GetMapping("new")
	public String newBook(@ModelAttribute Book book,Model model) {
		selectCategory = getSelectCategory();
		model.addAttribute("selectCategory", selectCategory);
		return "books/new";
	}
	
	@GetMapping("{id}/edit")
	public String edit(@PathVariable Long id, Model model) {
		Book book = bookService.findOne(id);
		model.addAttribute("book", book);
		return "books/edit";
	}
	
    @GetMapping("{id}")
    public String show(@PathVariable Long id, Model model) {
        Book book = bookService.findOne(id);
        model.addAttribute("book", book);
        return "books/show";
    }

    @PostMapping
    public String create(@ModelAttribute Book book) { 
    	bookService.save(book);
        return "redirect:/books"; 
    }

    @PutMapping("{id}")
    public String update(@PathVariable Long id, @ModelAttribute Book book) {
        book.setId(id);
        bookService.save(book);
        return "redirect:/books";
    }

    @DeleteMapping("{id}")
    public String destroy(@PathVariable Long id) {
        bookService.delete(id);
        return "redirect:/books";
    }
}
