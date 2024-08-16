package com.shopease.Entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private double price;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    private Category category;
    
    @Column(name = "description")
    private String description; // Add this line


    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Review> reviews;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	public String getDescription() {
        return description; // Add this method
    }

    public void setDescription(String description) {
        this.description = description; // Add this method
    }

	public Set<Review> getReviews() {
		return reviews;
	}

	public void setReviews(Set<Review> reviews) {
		this.reviews = reviews;
	}

    // Getters and setters...
    
}
