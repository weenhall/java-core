package com.ween.stream;

public class Fruit {
	private Long id;
	private String name;
	private float price;

	public Fruit(){

	}

	public Fruit(long id,String name,float price){
		this.id=id;
		this.name=name;
		this.price=price;
	}

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

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Fruit{" +
				"id=" + id +
				", name='" + name + '\'' +
				", price=" + price +
				'}';
	}
}
