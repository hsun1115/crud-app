package com.hsun.crudapp.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class User {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	     
	    @NotBlank(message = "Name is mandatory")
	    private String name;
	     
	    @NotBlank(message = "Email is mandatory")
	    private String email;
	    
	    public User() {}

		public User(Long id, @NotBlank(message = "Name is mandatory") String name,
				@NotBlank(message = "Email is mandatory") String email) {
			super();
			this.id = id;
			this.name = name;
			this.email = email;
		}

		@Override
		public String toString() {
			return "User [id=" + id + ", name=" + name + ", email=" + email + "]";
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

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}
	    
	    
}
