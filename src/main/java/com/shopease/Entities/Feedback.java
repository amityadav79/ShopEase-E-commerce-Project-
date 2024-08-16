package com.shopease.Entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "feedbacks")
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false)
    private String feedbackText;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date feedbackDate;
    
    @ManyToOne
    @JoinColumn(name = "order_item_id", nullable = false)
    private OrderItem orderItem;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getFeedbackText() {
		return feedbackText;
	}

	public void setFeedbackText(String feedbackText) {
		this.feedbackText = feedbackText;
	}

	public Date getFeedbackDate() {
		return feedbackDate;
	}

	public void setFeedbackDate(Date feedbackDate) {
		this.feedbackDate = feedbackDate;
	}
	
	public OrderItem getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(OrderItem orderItem) {
        this.orderItem = orderItem;
    }

    // Getters and setters...
    
}
