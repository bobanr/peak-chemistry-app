package com.pca.web.rest.dto;

import java.util.List;

public class UserDTO {
	
	private long id;
	
	private String login;

	private String password;

	private String firstName;

	private String lastName;

	private String email;

    private String langKey;

	private List<String> roles;

	private Boolean active;

	private Boolean hasAuthory;

	public UserDTO() {
	}

	public UserDTO(long id,String login, String password, String firstName,
			String lastName, String email, String langKey, Boolean active,
			List<String> roles, Boolean hasAuthory) {
		super();
		this.id = id;
		this.login = login;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.langKey = langKey;
		this.active = active;
		this.roles = roles;
		this.hasAuthory = hasAuthory;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public long getId() {
		return id;
	}
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Boolean getHasAuthory() {
		return hasAuthory;
	}

	public void setHasAuthory(Boolean hasAuthory) {
		this.hasAuthory = hasAuthory;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserDTO [login=");
		builder.append(login);
		builder.append(", password=");
		builder.append(password);
		builder.append(", firstName=");
		builder.append(firstName);
		builder.append(", lastName=");
		builder.append(lastName);
		builder.append(", email=");
		builder.append(email);
		builder.append(", roles=");
		builder.append(roles);
		builder.append(", active=");
		builder.append(active);
		builder.append(", hasAuthory=");
		builder.append(hasAuthory);
		builder.append("]");
		return builder.toString();
	}

	public String getLangKey() {
		return langKey;
	}

	public void setLangKey(String langKey) {
		this.langKey = langKey;
	}

}
